package br.com.clinica.domain;

import java.io.Serializable;

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

@Table
@Entity
@NamedQueries({ @NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario order by login"),
	@NamedQuery(name = "Usuario.verificaQtd", query = "SELECT COUNT(*) FROM Usuario usuario"),
	@NamedQuery(name = "Usuario.buscarPorId", query = "SELECT usuario FROM Usuario usuario WHERE usuario.id = :id"),
	@NamedQuery(name = "Usuario.buscarPorNome", query = "SELECT usuario FROM Usuario usuario WHERE usuario.funcionario.nome LIKE :nome"),
	@NamedQuery(name = "Usuario.buscarPeloLogin", query = "SELECT usuario FROM Usuario usuario WHERE usuario.login = :login"),
	@NamedQuery(name = "Usuario.autenticar", query = "SELECT usuario FROM Usuario usuario WHERE usuario.login = :login AND usuario.senha= :senha") })
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "tbl_funcionario_id", referencedColumnName = "id", nullable = false)
	private Funcionario funcionario;

	@Column(nullable = false, unique = true)
	private String login;

	@Column(nullable = false)
	private String senha;

	public Usuario() {
		login = new String();
		senha = new String();
		funcionario = new Funcionario();
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
