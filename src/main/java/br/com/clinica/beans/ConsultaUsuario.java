package br.com.clinica.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.clinica.domain.Usuario;
import br.com.clinica.service.UsuarioService;
import br.com.clinica.util.Mensagem;



@ManagedBean(name="MBUsuario")
@ViewScoped
public class ConsultaUsuario {
	private Usuario usuarioSelecionado;
	private UsuarioService service;
	private List<Usuario> listaUsuario;
	
	public ConsultaUsuario() {
		service = new UsuarioService();
	}
		
	public void ListarGeral(){
		this.listaUsuario = service.ListandoUsuarios();
	}

	public void Excluir(){
		try {
			this.service.Remover(this.usuarioSelecionado);
			
			Mensagem.mensagemInfo("Usuário "+ this.usuarioSelecionado.getLogin()+ " excluído com sucesso");
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoGASWeb/usuarios/GerenciarUsuarios.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}
	
	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
	
	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}
}
