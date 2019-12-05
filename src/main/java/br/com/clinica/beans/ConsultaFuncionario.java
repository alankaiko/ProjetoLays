package br.com.clinica.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.clinica.domain.Funcionario;
import br.com.clinica.service.FuncionarioService;
import br.com.clinica.util.Mensagem;

@ManagedBean(name="MBFuncionario")
@ViewScoped
public class ConsultaFuncionario {
	private List<Funcionario> listaFuncionario;
	private Funcionario funcionarioSelecionado;
	private FuncionarioService service;
	
	public ConsultaFuncionario() {
		this.service = new FuncionarioService();
	}
	
	public void ListarFuncionarios(){
		this.listaFuncionario = service.ListandoFuncionarios();
	}
	
	
	public void Excluir(){
		try {
			this.service.Remover(this.funcionarioSelecionado);
			
			Mensagem.mensagemInfo("Funcionário "+ this.funcionarioSelecionado.getNome()+ " excluído com sucesso");
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoGASWeb/funcionarios/GerenciarFuncionarios.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}
	
	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}
	
	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}
	
}
