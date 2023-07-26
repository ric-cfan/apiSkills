package com.neki.dto;

import io.swagger.annotations.ApiModelProperty;

public class EditUserSkillDTO {
	@ApiModelProperty(value = "Identificador único da ligação skill-usuário")
	private Long id;

	@ApiModelProperty(value = "Level da skill")
	private Integer lvl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLvl() {
		return lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

}
