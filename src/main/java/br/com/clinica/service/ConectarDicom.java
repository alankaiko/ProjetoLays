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

public class ConectarDicom {
	private AtendimentoDicom atend;
	
	public void ClasseConectar(){
		try {
            SpecificCharacterSet esp = new SpecificCharacterSet((String[])null);
            AttributeList identidade = new AttributeList();

            identidade.putNewAttribute(TagFromName.QueryRetrieveLevel).addValue(this.atend.getTipo().getValor()); 
            identidade.putNewAttribute(TagFromName.PatientName, esp).addValue(this.atend.getPaciente().getNome());
            identidade.putNewAttribute(TagFromName.PatientID, esp);
            identidade.putNewAttribute(TagFromName.PatientBirthDate);
            identidade.putNewAttribute(TagFromName.PatientSex);
            identidade.putNewAttribute(TagFromName.StudyInstanceUID);
            identidade.putNewAttribute(TagFromName.SOPInstanceUID);
            identidade.putNewAttribute(TagFromName.StudyDescription);
            identidade.putNewAttribute(TagFromName.StudyDate);
            
            this.Conectando(identidade);
            System.out.println("deu certo");
        }
        catch (Exception e) {
            e.printStackTrace(System.err); //in real life, do something about this exception
        }
	}
	
	private void Conectando(AttributeList identidade) throws DicomNetworkException, DicomException, IOException{
		new FindSOPClassSCU(this.Concat(), 104, "MEDCONNEC", "MYJAVACLIENT",
				SOPClass.StudyRootQueryRetrieveInformationModelFind, identidade, new IdentifierHandler(),3);
	}
	
	private String Concat(){
		return this.atend.getDados().getHostname() + this.atend.getDados().getPorta();
	}
	
	public AtendimentoDicom getAtend() {
		return atend;
	}
	
	public void setAtend(AtendimentoDicom atend) {
		this.atend = atend;
	}
}
