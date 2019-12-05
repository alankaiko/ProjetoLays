package br.com.clinica.service;

import java.util.List;

import br.com.clinica.domain.Funcionario;
import br.com.clinica.repository.FuncionarioRepository;



public class FuncionarioService {
	private FuncionarioRepository repositorio = new FuncionarioRepository();

	
	public void Salvar(Funcionario funcionario){
		this.repositorio.Guardar(funcionario);
	}
	
	public void Remover(Funcionario funcionario){
		this.repositorio.Remover(funcionario);
	}
	
	public List<Funcionario> ListandoFuncionarios(){
		return repositorio.ListarFuncionarios();
	}
	
	public Funcionario BuscandoId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
	
	public List<Funcionario> BuscandoPeloNome(String nome){
		return this.repositorio.BuscarPeloNome(nome);
	}

	public Funcionario BuscarNome(String nome){
		return this.repositorio.BuscarNome(nome);
	}
}
