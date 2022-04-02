package com.senoritas.Corrier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senoritas.Corrier.model.Usuario;
import com.senoritas.Corrier.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity <List<Usuario>> GetAll(){
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id){
		return usuarioRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> GetByNome (@PathVariable String nome){
	return ResponseEntity.ok(usuarioRepository.findAllByNomeContainingIgnoreCase(nome));
}
	
	@PostMapping
	public ResponseEntity<Usuario> Post (@RequestBody Usuario usuario){
		return ResponseEntity.ok(usuarioRepository.save(usuario));
	}
	@PutMapping
	public ResponseEntity<Usuario> Put (@RequestBody Usuario usuario){
		return ResponseEntity.ok(usuarioRepository.save(usuario));
		
	}
	@DeleteMapping
	public void Delete(@PathVariable long id) {
		usuarioRepository.deleteById(id);
	}
	
}
