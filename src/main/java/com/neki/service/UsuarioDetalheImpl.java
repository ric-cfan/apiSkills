package com.neki.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neki.domain.Usuario;
import com.neki.repository.UsuarioRepository;
import com.neki.security.UsuarioDetalhe;

@Service
public class UsuarioDetalheImpl implements UserDetailsService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByLogin(username);
		if (usuario == null) {
			throw new RuntimeException();
		}
		return new UsuarioDetalhe(usuario);
	}
}