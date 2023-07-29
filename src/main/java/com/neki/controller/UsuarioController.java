package com.neki.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.neki.dto.CriarUsuarioDTO;
import com.neki.dto.UsuarioDTO;
import com.neki.dto.UsuarioResponseDTO;
import com.neki.service.UsuarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de Usuários", notes = "Listagem de Usuários")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retornando lista de Usuários"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<List<UsuarioResponseDTO>> listar() {
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@GetMapping("/{login}")
	@ApiOperation(value = "Retorna a id e login do usuario", notes = "Retorna a id e login do usuario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retornando Usuário"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<UsuarioResponseDTO> findByLogin(@PathVariable String login) {
		return ResponseEntity.ok(usuarioService.findByLogin(login));
	}

	@PostMapping
	@ApiOperation(value = "Insere os dados de um Usuário", notes = "Inserir Usuário")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuário adicionado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<UsuarioDTO> inserir(@RequestBody CriarUsuarioDTO usuario) throws Exception {
		UsuarioDTO usuarioCadastro = usuarioService.inserir(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioCadastro.getId())
				.toUri();
		return ResponseEntity.created(uri).body(usuarioCadastro);
	}

}
