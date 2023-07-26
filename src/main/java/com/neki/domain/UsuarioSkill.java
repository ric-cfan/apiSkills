package com.neki.domain;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.neki.dto.UsuarioSkillDTO;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "usuario_skill")
public class UsuarioSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Identificador da associação entre usuário e skill")
	@Column(name = "id_usuario_skill")
	private Long id;

	@ApiModelProperty(value = "Level da skill")
	@Column(name = "lvl", nullable = false)
	private Integer lvl;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_skill")
	private Skill skill;

	public UsuarioSkill() {
		super();
	}

	public UsuarioSkill(Long id, Integer lvl, Usuario usuario, Skill skill) {
		super();
		this.id = id;
		this.lvl = lvl;
		this.usuario = usuario;
		this.skill = skill;
	}

	public UsuarioSkill(UsuarioSkillDTO skill) {
		super();
		this.id = skill.getId();
		this.lvl = skill.getLvl();
		this.usuario = new Usuario(skill.getUsuario());
		this.skill = new Skill(skill.getSkill());
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
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
		UsuarioSkill other = (UsuarioSkill) obj;
		return Objects.equals(id, other.id);
	}
}
