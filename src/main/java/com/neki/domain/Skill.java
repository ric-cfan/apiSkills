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

import com.neki.dto.SkillDTO;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "skill")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Identificador único da skill")
	@Column(name = "id_skill")
	private Long id;

	@NotBlank
	@ApiModelProperty(value = "Nome da skill")
	@Column(name = "nome", nullable = false, length = 50, unique = true)
	private String nome;

	@ApiModelProperty(value = "Descrição da skill")
	@Column(name = "descricao", length = 255, nullable = false)
	private String descricao;

	@ApiModelProperty(value = "URL da imagem da skill")
	@Column(name = "url_imagem", length = 255, nullable = false)
	private String urlImagem;

	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
	private List<UsuarioSkill> listaUsuarioSkill;

	public Skill() {
		super();
	}

	public Skill(Long id, @NotBlank String nome, String descricao, String urlImagem,
			List<UsuarioSkill> listaUsuarioSkill) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.urlImagem = urlImagem;
		this.listaUsuarioSkill = listaUsuarioSkill;
	}

	public Skill(SkillDTO skill) {
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

	public List<UsuarioSkill> getListaUsuarioSkill() {
		return listaUsuarioSkill;
	}

	public void setListaUsuarioSkill(List<UsuarioSkill> listaUsuarioSkill) {
		this.listaUsuarioSkill = listaUsuarioSkill;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		return Objects.equals(id, other.id);
	}
}
