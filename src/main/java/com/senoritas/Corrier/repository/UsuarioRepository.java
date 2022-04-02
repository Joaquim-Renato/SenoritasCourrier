package com.senoritas.Corrier.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senoritas.Corrier.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//Busca por Email//
	public Optional<Usuario> findByUsuario(String ususario);
	
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

}
