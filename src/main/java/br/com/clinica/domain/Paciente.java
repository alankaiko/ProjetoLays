package br.com.clinica.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table
@Entity
@NamedQueries({
	@NamedQuery(name = "Paciente.buscarPorNomeUnico", query = "SELECT paciente FROM Paciente paciente WHERE paciente.nome= :nome"),
	@NamedQuery(name = "Paciente.listar", query = "SELECT paciente FROM Paciente paciente order by id"),
	@NamedQuery(name = "Paciente.VerificaCpf", query = "SELECT paciente.cpf FROM Paciente paciente WHERE paciente.cpf= :cpf"),
	@NamedQuery(name = "Paciente.verificaQtd", query = "SELECT COUNT(*) FROM Paciente paciente"),
	@NamedQuery(name = "Paciente.buscarPorId", query = "SELECT paciente FROM Paciente paciente WHERE paciente.id= :id"),
	@NamedQuery(name = "Paciente.buscarPeloNome", query = "SELECT paciente FROM Paciente paciente WHERE paciente.nome LIKE :nome") })
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cpf;
	private String rg;
	private Date dataNasc;
	private Date dataCad;
	private Contato_cli contato;
	private Endereco_cli endereco;
	private String profissao;
	private String naturalidade;
	private String procedencia;
	private String religiao;

	public Paciente() {
		nome = new String();
		cpf = new String();
		rg = new String();
		contato = new Contato_cli();
		endereco = new Endereco_cli();
		religiao = new String();
		profissao = new String();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(nullable = false, unique = true, length = 15)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(length = 9)
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Temporal(TemporalType.DATE)
	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Temporal(TemporalType.DATE)
	public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tbl_contato_id", referencedColumnName = "id")
	public Contato_cli getContato() {
		return contato;
	}

	public void setContato(Contato_cli contato) {
		this.contato = contato;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tbl_endereco_id", referencedColumnName = "id")
	public Endereco_cli getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco_cli endereco) {
		this.endereco = endereco;
	}

	
	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}


	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getReligiao() {
		return religiao;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}

	
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
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
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}