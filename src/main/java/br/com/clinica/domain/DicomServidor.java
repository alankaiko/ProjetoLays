package br.com.clinica.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "DicomServidor.listar", query = "SELECT dicomservidor FROM DicomServidor dicomservidor order by id"),
	@NamedQuery(name = "DicomServidor.buscarPorId", query = "SELECT dicomservidor FROM DicomServidor dicomservidor WHERE dicomservidor.id= :id"),
	@NamedQuery(name = "DicomServidor.buscarHostName", query = "SELECT dicomservidor FROM DicomServidor dicomservidor WHERE dicomservidor.hostname= :hostname"),
	@NamedQuery(name = "DicomServidor.buscarTitulo", query = "SELECT dicomservidor FROM DicomServidor dicomservidor WHERE dicomservidor.titulo= :titulo") })
public class DicomServidor {
	private Long id;
	private String titulo;
	private String hostname;
	private String porta;
	
	public DicomServidor() {
		super();
	}

	public DicomServidor(String titulo, String hostname, String porta) {
		super();
		this.titulo = titulo;
		this.hostname = hostname;
		this.porta = porta;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DicomServidor other = (DicomServidor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
