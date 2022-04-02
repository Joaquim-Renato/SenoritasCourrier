package com.senoritas.Corrier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.senoritas.Corrier.model.Coleta;
import com.senoritas.Corrier.model.Entrega;
import com.senoritas.Corrier.repository.EntregaRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/entrega")
public class EntregaController {

	@Autowired
	private EntregaRepository entregaRepository;
	
	
	@GetMapping
	public ResponseEntity <List<Entrega>> GetAll(){
		return ResponseEntity.ok(entregaRepository.findAll());
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Entrega> GetById (@PathVariable long id){
		return entregaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/endereco/{endereco}")
	public ResponseEntity<List<Entrega>> GetByEndereco(@PathVariable String endereco){
		return ResponseEntity.ok(entregaRepository.findAllByEnderecoContainingIgnoreCase(endereco));
		
	}
	@PostMapping
	public ResponseEntity<Entrega> Post (@RequestBody Entrega entrega){
		return ResponseEntity.status(HttpStatus.CREATED).body(entregaRepository.save(entrega));
		
	}
	@PutMapping
	public ResponseEntity<Entrega> Put (@RequestBody Entrega entrega){
		return ResponseEntity.status(HttpStatus.OK).body(entregaRepository.save(entrega));
		
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		entregaRepository.deleteById(id);
	}
}
