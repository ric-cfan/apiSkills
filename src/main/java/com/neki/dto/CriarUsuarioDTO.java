package com.neki.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class CriarUsuarioDTO {
	@NotBlank
	@ApiModelProperty(value = "Login do usuário")
	private String login;

	@NotBlank
	@ApiModelProperty(value = "Senha do usuário")
	private String senha;

	@NotBlank
	@ApiModelProperty(value = "Confirmação de senha do usuário")
	private String confirmaSenha;

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

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

}
