package br.com.clinica.domain;

public enum TipoDicom {
	PATIENT("PATIENT"), STUDY("STUDY"), SERIE("SERIE"), IMAGE("IMAGE");
	
	private String valor;
	
	private TipoDicom(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}
