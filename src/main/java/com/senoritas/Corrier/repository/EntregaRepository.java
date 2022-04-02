package com.senoritas.Corrier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senoritas.Corrier.model.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
 public List<Entrega> findAllByEnderecoContainingIgnoreCase (String endereco);
}
