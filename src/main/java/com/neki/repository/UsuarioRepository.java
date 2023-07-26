package com.neki.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByLogin(String login);
	Optional<Usuario> findById(Long idUsuario);

}
