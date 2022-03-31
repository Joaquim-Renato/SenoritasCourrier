package com.senoritas.Corrier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senoritas.Corrier.model.Coleta;

@Repository
public interface ColetaRepository extends JpaRepository<Coleta, Long> {
	public List<Coleta> findAllByTipoContainingIgnoreCase(String tipo);

}
