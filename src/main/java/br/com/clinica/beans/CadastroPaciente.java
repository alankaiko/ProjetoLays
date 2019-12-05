package br.com.clinica.beans;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.clinica.domain.Paciente;
import br.com.clinica.service.PacienteService;

@ManagedBean(name="MBCadPaciente")
@ViewScoped
public class CadastroPaciente {
	private List<String> listaEstados;
	private Paciente paciente;
	private PacienteService service;
	private Long id;
	
	public CadastroPaciente() {
		this.service = new PacienteService();
		this.paciente = new Paciente();
	}
	
	public void Inicializar(){
		VerificarDataDeCadastro();
	}
	
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoGASWeb/pacientes/GerenciarPacientes.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Salvando(){
		this.service.Salvar(this.paciente);
	}
	

	public void CarregarPacienteEditar(){
		if(this.id != null)
			this.paciente = service.BuscandoId(this.id);
	}
	
	
	public void VerificarDataDeCadastro() {
		if(this.id == null){
			Date data = new Date();
			this.paciente.setDataCad(data);
		}
	}
	
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public List<String> getListaEstados() {
		return listaEstados;
	}	
}
