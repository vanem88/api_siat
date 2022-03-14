package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.AccesoPaginaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccesoPaginaRepository extends JpaRepository<AccesoPaginaEntity, Long>{
	
	AccesoPaginaEntity findByPersonaId(Long idPersona);
	
}