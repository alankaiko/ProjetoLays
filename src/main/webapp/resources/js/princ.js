 var app = new DcmApp('view-area');

    function load_urllist_from_url(url) {
        app.load_urllist_from_url(url);
    }

    function testscroll(i, len) {
        if(i > len-1)
            return;
        app.curr_file_idx = i;
        app.draw_image();
        setTimeout((function(a, b) { 
                    return function() {
                        testscroll(a, b);
                    }})(i+1, len), 0);
    }



    $(document).ready(function() {
        app.init();
        $("input[type=file]").change(function(evt) {
            //app.load_files(evt);
        });
        $("#test-scroll").click(function() {
            testscroll(0, app.files.length);
        });
        // Setup cluts
        for(clut in cluts) {
            $("#clut-select optgroup").append($("<option>").val(clut).text(clut));
        }

        // Setup tools
        for(tool in tools) {
            var button = $("<div>").addClass("tool-button").text(tool);
            $("#button-bar-horz").prepend(button);
            $(button).click(function() {
                $(this).parent().find("div").removeClass("butt-selected");
                $(this).addClass("butt-selected");
                app.activate_tool(tool);
            });
        }

        $("#slider").slider();

        $("button").button();

        $("#axial-view").buttonset();

        $("#view-metadata").click(function() {
            app.fill_metadata_table();
            $("#metadata-dialog").dialog({
                modal: true,
                width: 600,
                button: {
                    'Ok': function() {
                        $(this).dialog('close');
                    }
                }
            });
        });

        $("#open").click(function() {
            $("#open-dialog").dialog({
                    modal: true,
                    buttons: {
                        'Ok': function() {
                            var file_input = $("input[type=file]")[0];
                            app.load_files(file_input.files);
                            $(this).dialog('close');
                        },
                        'Cancel': function() {
                            $(this).dialog('close');
                        }
                    }
                });
        });
/*
        $("#browse").click(function() {
            $("#browse-dialog").dialog({
                    modal: true,
                    buttons: {
                        'Ok': function() {
                            var file_input = $("input[type=file]")[0];
                            app.load_files(file_input.files);
                            $(this).dialog('close');
                        },
                        'Cancel': function() {
                            $(this).dialog('close');
                        }
                    }
                });
            $("#browse-pacs-radio").empty();
            listPacsNames(function(pacsnames) {
              $.each(pacsnames, function(i, name) {
                $("#browse-pacs-radio").append('<input type="radio" id="radio' + i + '" name="radio" /><label for="radio' + i + '">'+ name + '</label>');
              });
              $("#browse-pacs-radio").buttonset();
              $.each(pacsnames, function(i, name) {
                $("#radio" + i).click(function (e) {
                  console.log("radio" + i + " clicked");
                  $("#studiesaccordion").accordion("destroy");
                  $("#studiesaccordion").empty();
                  findAllPatients(name, function(patients) {
                    $.each(patients, function(i, patient) {
                      $("#studiesaccordion").append('<h3><a href="#">' + patient["Patient's Name"] + '</a></h3>');
                      $("#studiesaccordion").append('<div id="pat-' + patient["Patient ID"] + '"><ul id="ul-pat-' + patient["Patient ID"] + '"></ul></div>');
		      findSeriesInStudy(name, patient["Patient ID"], '', function(serieslist) {
		        $.each(serieslist, function(i, series) {
		          $("#ul-pat-" + patient["Patient ID"]).append('<li><a href="#">' + series['Modality'] + " " + series['Series Number'] + '</a></li>');
  			  $("#studiesaccordion").accordion("resize");
		        });
                      });
		    });
                    $("#studiesaccordion").accordion({collapsible: true}).accordion("resize");
		  });
                  return false;
		});
              });
            });
        });
 */

        $("#butt-reset").click(function() {
            app.reset_levels();
        });
        $("#clut-select").change(function() {
            app.set_clut($(this).val());
        });
        $("#window-presets").change(function() {
            app.set_window_preset($(this).val());
        });
        function handleDragOver(evt) {
            evt.stopPropagation();
            evt.preventDefault();
            evt.dataTransfer.dropEffect = 'copy'; // Explicitly show this is a copy.
        }
        function handleFileSelect(evt) {
            evt.stopPropagation();
            evt.preventDefault();
            app.load_files(evt.dataTransfer.files);
        }

        // Setup the dnd listeners.
        var dropZone = document.getElementById('filebox');
        dropZone.addEventListener('dragover', handleDragOver, false);
        dropZone.addEventListener('drop', handleFileSelect, false);
        //webGLStart();
    });