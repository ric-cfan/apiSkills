package com.neki.dto;

import com.neki.domain.Skill;

import io.swagger.annotations.ApiModelProperty;

public class SkillDTO {
	@ApiModelProperty(value = "Identificador único da skill")
	private Long id;

	@ApiModelProperty(value = "Nome da skill")
	private String nome;

	@ApiModelProperty(value = "Descrição da skill")
	private String descricao;

	@ApiModelProperty(value = "URL da imagem da skill")
	private String urlImagem;

	public SkillDTO() {
		super();
	}

	public SkillDTO(Long id, String nome, String descricao, String urlImagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.urlImagem = urlImagem;
	}
	
	public SkillDTO(Skill skill) {
		super();
		this.id = skill.getId();
		this.nome = skill.getNome();
		this.descricao = skill.getDescricao();
		this.urlImagem = skill.getUrlImagem();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

}
