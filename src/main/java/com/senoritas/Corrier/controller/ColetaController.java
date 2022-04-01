package com.senoritas.Corrier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senoritas.Corrier.model.Coleta;
import com.senoritas.Corrier.repository.ColetaRepository;

@RestController
@RequestMapping("/coleta")
@CrossOrigin("*")
public class ColetaController {
	
	@Autowired
	private ColetaRepository coletaRepository;
	
	@GetMapping
	public ResponseEntity <List<Coleta>> GetAll(){
		return ResponseEntity.ok(coletaRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Coleta> GetById (@PathVariable long id){
		return coletaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
}
