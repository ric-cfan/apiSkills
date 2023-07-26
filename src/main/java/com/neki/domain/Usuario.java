package com.neki.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.neki.dto.RequestUsuarioDTO;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Identificador único do usuário")
	@Column(name = "id_usuario")
	private Long id;

	@NotBlank
	@ApiModelProperty(value = "Login do usuário")
	@Column(name = "login", nullable = false, length = 20, unique = true)
	private String login;

	@ApiModelProperty(value = "Senha do usuário")
	@Column(name = "senha", length = 255, nullable = false)
	private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<UsuarioSkill> listaUsuarioSkill;

	public Usuario() {
		super();
	}

	public Usuario(Long id, @NotBlank String login, String senha, List<UsuarioSkill> listaUsuarioSkill) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.listaUsuarioSkill = listaUsuarioSkill;
	}
	
	public Usuario(RequestUsuarioDTO usuario) {
		super();
		this.id = usuario.getId();
		this.login = usuario.getLogin();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<UsuarioSkill> getListaUsuarioSkill() {
		return listaUsuarioSkill;
	}

	public void setListaUsuarioSkill(List<UsuarioSkill> listaUsuarioSkill) {
		this.listaUsuarioSkill = listaUsuarioSkill;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
}
