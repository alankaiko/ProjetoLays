package br.com.clinica.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.clinica.domain.AtendimentoDicom;
import br.com.clinica.domain.DicomServidor;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.TipoDicom;
import br.com.clinica.service.DicomBuscaServidor;

@ManagedBean(name="AtendDBean")
@ViewScoped
public class AtendimentoDicomBean {
	private DicomBuscaServidor service;
	private AtendimentoDicom atendimento;
	
	public AtendimentoDicomBean() {
		this.service = new DicomBuscaServidor();
		this.atendimento = new AtendimentoDicom();
	}
	
	public void Buscar() {
		Paciente paciente = new Paciente();
		paciente.setNome("bowen");
		paciente.setCpf("14332665789");
		paciente.setRg("5337896");
		
		DicomServidor servidor = new DicomServidor();
		servidor.setHostname("34.235.169.100");
		servidor.setPorta("11112");
		servidor.setTitulo("testnado");
		
		TipoDicom tipo = TipoDicom.STUDY;
		
		this.atendimento.setDados(servidor);
		this.atendimento.setPaciente(paciente);
		this.atendimento.setTipo(tipo);

		this.service.PreencherDados(this.atendimento);
	}
}























