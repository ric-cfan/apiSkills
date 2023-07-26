package com.neki.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neki.domain.UsuarioSkill;
import com.neki.dto.EditUserSkillDTO;
import com.neki.dto.UsuarioSkillDTO;
import com.neki.repository.UsuarioRepository;
import com.neki.repository.UsuarioSkillRepository;

@Service
public class UsuarioSkillService {
	
	@Autowired
	private UsuarioSkillRepository usuarioSkillRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioSkillDTO> listarTodos(Long idUsuario) {
		List<UsuarioSkill> skills = usuarioSkillRepository.findAll();
		List<UsuarioSkillDTO> skillsDTO = new ArrayList<>();

		for (UsuarioSkill skill : skills) {
			if(idUsuario == skill.getUsuario().getId()) {
				skillsDTO.add(new UsuarioSkillDTO(skill));
			}
		}
		return skillsDTO;
	}

	@Transactional
	public UsuarioSkillDTO cadastrar(UsuarioSkillDTO novaSkill) throws Exception {
		if(usuarioRepository.findById(novaSkill.getUsuario().getId()).isEmpty()) {
			throw new Exception("Usuário inválido");
		}
		
		UsuarioSkill skill = usuarioSkillRepository.save(new UsuarioSkill(novaSkill));
		UsuarioSkillDTO skillDTO = new UsuarioSkillDTO(skill);
		return skillDTO;
	}

	@Transactional
	public UsuarioSkillDTO atualizar(EditUserSkillDTO skillAtualizada, Long idUsuarioSkill) throws Exception {
		
		UsuarioSkill skillSalva = usuarioSkillRepository.findById(idUsuarioSkill).get();	
		skillSalva.setLvl(skillAtualizada.getLvl());
		usuarioSkillRepository.save(skillSalva);
		UsuarioSkillDTO retornoDTO = new UsuarioSkillDTO(skillSalva);
			
		return retornoDTO;

	}

	@Transactional
	public void deleteById(Long idUsuarioSkill) throws Exception {
		if (!usuarioSkillRepository.existsById(idUsuarioSkill)) {
			throw new Exception("Skill de usuário não encontrada!");
		}
		usuarioSkillRepository.deleteById(idUsuarioSkill);
	}
}
