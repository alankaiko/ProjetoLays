package br.com.clinica.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.clinica.domain.DicomServidor;
import br.com.clinica.service.DicomServidorService;

@ManagedBean(name="ServerBean")
@ViewScoped
public class CadastroServidor {
	private DicomServidorService service;
	private DicomServidor servidor;
	private Long id;
	
	public CadastroServidor() {
		this.service = new DicomServidorService();
		this.servidor = new DicomServidor();
	}
	
	
	public void Inicializar(){
		
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoLays/dicons/GerenciarServers.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Salvando(){
		this.service.Salvar(this.servidor);
	}
	
	public void CarregarServidorEditar(){
		if(this.id != null)
			this.servidor = service.BuscandoId(this.id);
	}

	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public DicomServidor getServidor() {
		return servidor;
	}
	
	public void setServidor(DicomServidor servidor) {
		this.servidor = servidor;
	}
}
