package com.neki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.dto.SkillDTO;
import com.neki.service.SkillService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/skill")
public class SkillController {
	@Autowired
	private SkillService skillService;

	@GetMapping
	@ApiOperation(value = "Retorna lista de skills", notes = "Listagem de skills")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna lista de skills"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"),
	})
	public ResponseEntity<List<SkillDTO>> listar() {
		return ResponseEntity.ok(skillService.findAll());
	}

}
