package com.neki.dto;

import com.neki.domain.Usuario;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioDTO {
	@ApiModelProperty(value = "Identificador único do usuário")
	private Long id;

	@ApiModelProperty(value = "Login do usuário")
	private String login;

	@ApiModelProperty(value = "Senha do usuário")
	private String senha;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Long id, String login, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
	}

	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
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

}
