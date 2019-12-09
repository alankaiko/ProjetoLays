package br.com.clinica.domain;

public class AtendimentoDicom {
	private DicomServidor dados;
	private Paciente paciente;
	private TipoDicom tipo;

	public DicomServidor getDados() {
		return dados;
	}

	public void setDados(DicomServidor dados) {
		this.dados = dados;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public TipoDicom getTipo() {
		return tipo;
	}

	public void setTipo(TipoDicom tipo) {
		this.tipo = tipo;
	}

}
