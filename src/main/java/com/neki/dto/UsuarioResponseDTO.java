package com.neki.dto;

import com.neki.domain.Usuario;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioResponseDTO {
	@ApiModelProperty(value = "Identificador único do usuário")
	private Long id;

	@ApiModelProperty(value = "Login do usuário")
	private String login;

	public UsuarioResponseDTO() {
		super();
	}

	public UsuarioResponseDTO(Long id, String login) {
		super();
		this.id = id;
		this.login = login;
	}

	public UsuarioResponseDTO(Usuario usuario) {
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

}
