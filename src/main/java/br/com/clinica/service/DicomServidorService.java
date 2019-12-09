package br.com.clinica.service;

import java.util.List;

import br.com.clinica.domain.DicomServidor;
import br.com.clinica.repository.DicomServidorRepository;



public class DicomServidorService {
	private DicomServidorRepository repositorio;

	
	public DicomServidorService() {
		this.repositorio = new DicomServidorRepository();
	}
	
	public void Salvar(DicomServidor servidor){
		this.repositorio.Guardar(servidor);
	}
	
	public void Remover(DicomServidor servidor){
		this.repositorio.Remover(servidor);
	}
	
	public List<DicomServidor> ListandoServidores(){
		return repositorio.ListarServidores();
	}
	
	public DicomServidor BuscandoId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
	
	public List<DicomServidor> BuscandoPeloNome(String nome){
		return this.repositorio.BuscarPeloNomeServidor(nome);
	}

	public DicomServidor BuscarNome(String nome){
		return this.repositorio.BuscarNomeServidor(nome);
	}
}
