package br.com.clinica.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.clinica.domain.AtendimentoDicom;
import br.com.clinica.domain.DicomServidor;
import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.TipoDicom;
import br.com.clinica.service.DicomBuscaServidor;
import br.com.clinica.service.DicomServidorService;
import br.com.clinica.service.PacienteService;

@ManagedBean(name = "TesteConBean")
@ViewScoped
public class TesteConectarBean {
	private List<Paciente> listaPaciente;
	private List<DicomServidor> listaServidor;
	private Paciente paciente;
	private DicomServidor servidor;
	private DicomServidorService serviceDicom;
	private PacienteService servicePaciente;
	private AtendimentoDicom atendimento;
	private DicomBuscaServidor serviceServ;
	private Long id;

	public TesteConectarBean() {
		this.serviceDicom = new DicomServidorService();
		this.paciente = new Paciente();
		this.servidor = new DicomServidor();
		this.servicePaciente = new PacienteService();
		this.serviceServ = new DicomBuscaServidor();
		this.atendimento = new AtendimentoDicom();
	}
	
	public void Inicializar() {
		this.listaPaciente = this.servicePaciente.ListandoPacientes();
		this.listaServidor = this.serviceDicom.ListandoServidores();
	}

	public void Redirecionar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoLays/dicons/TesteConectarBean.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void PegaPaciente(SelectEvent event){}	
	
	public void PegaServidor(SelectEvent event){}	
	
	
	public void Executar(){
		this.atendimento.setDados(this.servidor);
		this.atendimento.setPaciente(this.paciente);
		this.atendimento.setTipo(TipoDicom.STUDY);
		
		this.serviceServ.PreencherDados(this.atendimento);
	}
	
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}

	public void setListaPaciente(List<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}

	public List<DicomServidor> getListaServidor() {
		return listaServidor;
	}

	public void setListaServidor(List<DicomServidor> listaServidor) {
		this.listaServidor = listaServidor;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public DicomServidor getServidor() {
		return servidor;
	}

	public void setServidor(DicomServidor servidor) {
		this.servidor = servidor;
	}

	public DicomServidorService getServiceDicom() {
		return serviceDicom;
	}

	public void setServiceDicom(DicomServidorService serviceDicom) {
		this.serviceDicom = serviceDicom;
	}

	public PacienteService getServicePaciente() {
		return servicePaciente;
	}

	public void setServicePaciente(PacienteService servicePaciente) {
		this.servicePaciente = servicePaciente;
	}

}
