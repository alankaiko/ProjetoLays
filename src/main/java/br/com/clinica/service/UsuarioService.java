package br.com.clinica.service;

import java.util.List;

import br.com.clinica.domain.Funcionario;
import br.com.clinica.domain.Usuario;
import br.com.clinica.repository.UsuarioRepository;

public class UsuarioService {
	private UsuarioRepository repositorio = new UsuarioRepository();

	
	public void Salvar(Usuario usuario){
		this.repositorio.Guardar(usuario);
	}
	
	public void Remover(Usuario usuario){
		this.repositorio.Remover(usuario);
	}
	
	public Usuario BuscaPelaId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
	
	public List<Usuario> ListandoUsuarios(){
		return this.repositorio.ListarUsuario();
	}
	
	public Long VerificaQtdReg(){
		return this.repositorio.VerificaQTDRegistro();
	}
	
	public Usuario Autenticando(String login, String senha){
		return this.repositorio.Autenticar(login, senha);
	}
	
	public Usuario BuscandoPeloLogin(String login){
		return this.repositorio.BuscarPeloLogin(login);
	}
	
	public List<Usuario> ListandoPorNome(String nome){
		return repositorio.BuscarPeloNome(nome);
	}
	
	//Lista Funcionarios para cadastrar no Usuario
	public List<Funcionario> ListarFuncionarios(){
		FuncionarioService serviceFun = new FuncionarioService();
		return serviceFun.ListandoFuncionarios();
	}
	
	
}
