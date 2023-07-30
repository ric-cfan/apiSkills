package com.neki.dto;

import com.neki.domain.UsuarioSkill;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioSkillDTO {
	@ApiModelProperty(value = "Identificador único da ligação skill-usuário")
	private Long id;

	@ApiModelProperty(value = "Level da skill")
	private Integer lvl;

	@ApiModelProperty(value = "Dados do usuario")
	private RequestUsuarioDTO usuario;

	@ApiModelProperty(value = "Dados da skill")
	private SkillDTO skill;

	public UsuarioSkillDTO() {
		super();
	}

	public UsuarioSkillDTO(Long id, Integer lvl, RequestUsuarioDTO usuario,
			SkillDTO skill) {
		super();
		this.id = id;
		this.lvl = lvl;
		this.usuario = usuario;
		this.skill = skill;
	}
	
	public UsuarioSkillDTO(Long id, Integer lvl, Long idUser,
			SkillDTO skill) {
		super();
		this.id = id;
		this.lvl = lvl;
		RequestUsuarioDTO usuario = new RequestUsuarioDTO(null, null);
		usuario.setId(idUser);
		this.usuario = usuario;
		this.skill = skill;
	}

	public UsuarioSkillDTO(UsuarioSkill skill) {
		super();
		this.id = skill.getId();
		this.lvl = skill.getLvl();
		this.usuario = new RequestUsuarioDTO(skill.getUsuario());
		this.skill = new SkillDTO(skill.getSkill());
	}

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

	public RequestUsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(RequestUsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public SkillDTO getSkill() {
		return skill;
	}

	public void setSkill(SkillDTO skill) {
		this.skill = skill;
	}

}
