package br.com.clinica.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.clinica.domain.Funcionario;
import br.com.clinica.domain.Usuario;
import br.com.clinica.service.UsuarioService;

@ManagedBean(name="MBCadUsuario")
@ViewScoped
public class CadastroUsuario{
	private Usuario usuario;
	private UsuarioService service;
	private String login;
	private List<Funcionario> listaFuncionario;
	
	public CadastroUsuario() {
		this.service = new UsuarioService();
		this.usuario = new Usuario();
		this.listaFuncionario = service.ListarFuncionarios();
	}
	
	public void PegaFabricante(SelectEvent event){
		
	}	
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoLays/usuarios/GerenciarUsuarios.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Salvando(){
		this.service.Salvar(this.usuario);
	}
	
	public void CarregarUsuarioEditar(){
		if(this.login != null){
			this.usuario = service.BuscandoPeloLogin(this.login);
			
		}
	}	
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

}
