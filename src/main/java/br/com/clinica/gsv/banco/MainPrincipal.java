package br.com.clinica.gsv.banco;

import br.com.clinica.domain.Funcionario;
import br.com.clinica.domain.Usuario;
import br.com.clinica.service.FuncionarioService;
import br.com.clinica.service.UsuarioService;

public class MainPrincipal {
	private Funcionario funcionario;
	private FuncionarioService serviceFun;
	private Usuario usuario;
	private UsuarioService serviceUser;
	
	public static void main(String[] args){
		MainPrincipal us = new MainPrincipal();
	}
	
	public MainPrincipal() {
		funcionario = new Funcionario();
		serviceFun = new FuncionarioService();
		usuario = new Usuario();
		serviceUser = new UsuarioService();
	
		AdicionaFuncionario();
		AdicionaUsuario();
		System.out.println("terminou");
		System.exit(0);
	}

	

	private void AdicionaFuncionario(){
		this.funcionario.setNome("Admin admin");
		this.funcionario.setRg("0000000");
		this.funcionario.setCpf("00000000000");
		
		this.serviceFun.Salvar(this.funcionario);
	}

	private void AdicionaUsuario(){
		this.usuario.setFuncionario(this.serviceFun.BuscandoId(1L));
		this.usuario.setLogin("admin");
		this.usuario.setSenha("123");
		
		this.serviceUser.Salvar(this.usuario);
	}
	
	
}
