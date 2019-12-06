package br.com.clinica.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.clinica.domain.Funcionario;
import br.com.clinica.service.FuncionarioService;

@ManagedBean(name="MBCadFuncionario")
@ViewScoped
public class CadastroFuncionario {
	private Funcionario funcionario;
	private FuncionarioService service;
	private Long id;
	
	public CadastroFuncionario() {
		this.service = new FuncionarioService();
		this.funcionario = new Funcionario();
	}
	
	public void Inicializar(){
		
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoLays/funcionarios/GerenciarFuncionarios.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Salvando(){
		this.service.Salvar(this.funcionario);
	}
	
	public void CarregarFuncionarioEditar(){
		if(this.id != null)
			this.funcionario = service.BuscandoId(this.id);
	}

	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
