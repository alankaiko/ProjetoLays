package br.com.clinica.beans;

import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.SOPClass;
import com.pixelmed.dicom.SpecificCharacterSet;
import com.pixelmed.dicom.TagFromName;
import com.pixelmed.network.FindSOPClassSCU;
import com.pixelmed.network.IdentifierHandler;

public class DicomCFindFunctionalityDemo {
	 public static void main(String arg[]) {
         
         try {
             SpecificCharacterSet specificCharacterSet = new SpecificCharacterSet((String[])null);
             AttributeList identifier = new AttributeList();
             
             //specify attributes to retrieve and pass in any search criteria
             //query root of "study" to retrieve studies

             identifier.putNewAttribute(TagFromName.QueryRetrieveLevel).addValue("STUDY"); 
             identifier.putNewAttribute(TagFromName.PatientName,specificCharacterSet).addValue("reacher*");
             identifier.putNewAttribute(TagFromName.PatientID,specificCharacterSet);
             identifier.putNewAttribute(TagFromName.PatientBirthDate);
             identifier.putNewAttribute(TagFromName.PatientSex);
             identifier.putNewAttribute(TagFromName.StudyInstanceUID);
             identifier.putNewAttribute(TagFromName.SOPInstanceUID);
             identifier.putNewAttribute(TagFromName.StudyDescription);
             identifier.putNewAttribute(TagFromName.StudyDate);
             
             //retrieve all studies belonging to patient with name 'Bowen'
             new FindSOPClassSCU("www.dicomserver.co.uk",
                     104,
                     "MEDCONNEC",
                     "MYJAVACLIENT",
                     SOPClass.StudyRootQueryRetrieveInformationModelFind,identifier,
                     new IdentifierHandler(),
                     3);
             System.out.println("ave amria");
         }
         catch (Exception e) {
             e.printStackTrace(System.err); //in real life, do something about this exception
             System.out.println("deu nao");
             System.exit(0);
         }
     }
}
