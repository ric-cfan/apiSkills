package com.neki.dto;

import javax.validation.constraints.NotBlank;

import com.neki.domain.Usuario;

import io.swagger.annotations.ApiModelProperty;

public class RequestUsuarioDTO {
	@NotBlank
	@ApiModelProperty(value = "Identificador único do usuário")
	private Long id;

	@NotBlank
	@ApiModelProperty(value = "Login do usuário")
	private String login;

	public RequestUsuarioDTO() {
		super();
	}

	public RequestUsuarioDTO(@NotBlank Long id, @NotBlank String login) {
		super();
		this.id = id;
		this.login = login;
	}

	public RequestUsuarioDTO(Usuario usuario) {
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
