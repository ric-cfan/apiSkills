package com.neki.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.neki.dto.EditUserSkillDTO;
import com.neki.dto.UsuarioSkillDTO;
import com.neki.service.UsuarioSkillService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/usuarioSkill")
public class UsuarioSkillController {
	@Autowired
	private UsuarioSkillService usuarioSkillService;

	@GetMapping("/{idUsuario}")
	@ApiOperation(value = "Retorna lista de skills do usuário", notes = "Listagem de skills do usuário")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retornando lista de skills do usuário"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"),
	})
	public ResponseEntity<List<UsuarioSkillDTO>> listarTodasSkills(@PathVariable Long idUsuario) {
		return ResponseEntity.ok(usuarioSkillService.listarTodos(idUsuario));
	}

	@PostMapping
	@ApiOperation(value = "Insere a skill do usuario", notes = "Inserir skill do usuario")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Skill adcionada"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"),
	})
	public ResponseEntity<UsuarioSkillDTO> cadastrar(@Valid @RequestBody UsuarioSkillDTO novaSkill) throws Exception {
		UsuarioSkillDTO skillDTO = usuarioSkillService.cadastrar(novaSkill);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(skillDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(skillDTO);
	}

	@PutMapping("/{idUsuarioSkill}")
	@ApiOperation(value = "Atualiza dados da skill do usuário", notes = "Atualizar skill do usuário")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Skill Atualizada"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"),
	})
	public ResponseEntity<UsuarioSkillDTO> salvar(@PathVariable Long idUsuarioSkill, @Valid @RequestBody EditUserSkillDTO skillAtualizada) throws Exception {
		UsuarioSkillDTO skillDTO = usuarioSkillService.atualizar(skillAtualizada, idUsuarioSkill);
		return ResponseEntity.ok(skillDTO);
	}

	@DeleteMapping("/{idUsuarioSkill}")
	@ApiOperation(value = "Remove uma skill do usuário", notes = "Remover Skill do usuário")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Skill Removida"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"),
	})
	public ResponseEntity<Void> deletar(@PathVariable Long idUsuarioSkill) throws Exception {
		usuarioSkillService.deleteById(idUsuarioSkill);
		return ResponseEntity.noContent().build();
	}
}
