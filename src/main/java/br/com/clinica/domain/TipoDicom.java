package br.com.clinica.domain;

public enum TipoDicom {
	PACIENTE("Patienty"), ESTUDO("Study"), SERIE("Serie"), IMAGEM("Image");
	
	private String valor;
	
	private TipoDicom(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}
