package br.com.clinica.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.clinica.domain.DicomServidor;
import br.com.clinica.service.DicomServidorService;
import br.com.clinica.util.Mensagem;

@ManagedBean(name="ServerConsBean")
@ViewScoped
public class ConsultaServerDicom {
	private List<DicomServidor> listaServidor;
	private DicomServidor servidorSelecionado;
	private DicomServidorService service;
	
	public ConsultaServerDicom() {
		this.service = new DicomServidorService();
	}
	
	
	public void ListarFuncionarios(){
		this.listaServidor = service.ListandoServidores();
	}
	
	
	public void Excluir(){
		try {
			this.service.Remover(this.servidorSelecionado);
			
			Mensagem.mensagemInfo("Servidor "+ this.servidorSelecionado.getTitulo()+ " excluído com sucesso");
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoLays/dicons/GerenciarServers.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<DicomServidor> getListaServidor() {
		return listaServidor;
	}
	
	public DicomServidor getServidorSelecionado() {
		return servidorSelecionado;
	}
	
	public void setServidorSelecionado(DicomServidor servidorSelecionado) {
		this.servidorSelecionado = servidorSelecionado;
	}
	
}
