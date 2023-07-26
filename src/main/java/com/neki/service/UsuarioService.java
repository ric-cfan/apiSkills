package com.neki.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neki.domain.Usuario;
import com.neki.dto.CriarUsuarioDTO;
import com.neki.dto.UsuarioDTO;
import com.neki.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	BCryptPasswordEncoder encoder;

	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			usuarioDTOs.add(new UsuarioDTO(usuario));
		}
		return usuarioDTOs;
	}

	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Transactional
	public UsuarioDTO inserir(CriarUsuarioDTO user) throws Exception {
		if (!user.getSenha().equalsIgnoreCase(user.getConfirmaSenha())) {
			throw new Exception("Senha e Confirma Senha não são iguais");
		}
		if (usuarioRepository.findByLogin(user.getLogin()) != null) {
			System.out.println(user.getLogin());
			throw new Exception("Usuário já existente");
		}
		Usuario usuario = new Usuario();
		usuario.setLogin(user.getLogin());
		usuario.setSenha(encoder.encode(user.getSenha()));
		usuario = usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);
	}

	public UsuarioDTO findById(Long idUsuario) throws Exception {
		if (usuarioRepository.findById(idUsuario).isPresent()) {
			UsuarioDTO usuarioDTO = new UsuarioDTO(usuarioRepository.findById(idUsuario).get());
			return usuarioDTO;
		}
		throw new Exception("Usuário não encontrado!");
	}

}