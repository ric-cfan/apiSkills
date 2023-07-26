package com.neki.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.domain.Skill;
import com.neki.dto.SkillDTO;
import com.neki.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;
	
	public List<SkillDTO> findAll() {
		List<Skill> skills = skillRepository.findAll();
		List<SkillDTO> skillsDTOs = new ArrayList<>();
		for (Skill skill : skills) {
			skillsDTOs.add(new SkillDTO(skill));
		}
		return skillsDTOs;
	}
}
