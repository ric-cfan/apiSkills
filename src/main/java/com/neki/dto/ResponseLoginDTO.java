package com.neki.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class ResponseLoginDTO {
	@NotBlank
	@ApiModelProperty(value = "Identificador único do usuário")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
