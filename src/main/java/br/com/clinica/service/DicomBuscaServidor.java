package br.com.clinica.service;

import java.io.IOException;

import br.com.clinica.domain.AtendimentoDicom;

import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.SOPClass;
import com.pixelmed.dicom.SpecificCharacterSet;
import com.pixelmed.dicom.TagFromName;
import com.pixelmed.network.DicomNetworkException;
import com.pixelmed.network.FindSOPClassSCU;
import com.pixelmed.network.IdentifierHandler;

public class DicomBuscaServidor {
	private AttributeList atributos;
	
	public DicomBuscaServidor() {
		this.atributos = new AttributeList();
	}
	
	
	public void PreencherDados(AtendimentoDicom atendimento){
		this.PreencherDadosServidor(atendimento);
	}
	
	private void PreencherDadosServidor(AtendimentoDicom atendimento) {
        
        try {
        	SpecificCharacterSet esp = new SpecificCharacterSet((String[])null);

            
            //specify attributes to retrieve and pass in any search criteria
            //query root of "study" to retrieve studies

            atributos.putNewAttribute(TagFromName.QueryRetrieveLevel).addValue(atendimento.getTipo().getValor()); 
            atributos.putNewAttribute(TagFromName.PatientName,esp).addValue(atendimento.getPaciente().getNome());
            atributos.putNewAttribute(TagFromName.PatientID,esp);
            atributos.putNewAttribute(TagFromName.PatientBirthDate);
            atributos.putNewAttribute(TagFromName.PatientSex);
            atributos.putNewAttribute(TagFromName.StudyInstanceUID);
            atributos.putNewAttribute(TagFromName.SOPInstanceUID);
            atributos.putNewAttribute(TagFromName.StudyDescription);
            atributos.putNewAttribute(TagFromName.StudyDate); 

            //retrieve all studies belonging to patient with name 'Bowen'
           this.ExecutaRequisicao(atendimento, atributos);
            System.out.println("ave amria");
        }
        catch (Exception e) {
            e.printStackTrace(System.err); //in real life, do something about this exception
            System.out.println("deu nao");
            System.exit(0);
        }
    }
	
	private void ExecutaRequisicao(AtendimentoDicom atendimento, AttributeList atributos) throws NumberFormatException, DicomNetworkException, DicomException, IOException {
		new FindSOPClassSCU(
			atendimento.getDados().getHostname(), Integer.parseInt(atendimento.getDados().getPorta()), "MEDCONNEC","MYJAVACLIENT",
	        SOPClass.StudyRootQueryRetrieveInformationModelFind,this.atributos,
	        new IdentifierHandler(),3
        );
	}
}
