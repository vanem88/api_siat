package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.MensajeAdjuntosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeAdjuntoRepository extends JpaRepository<MensajeAdjuntosEntity, Long>{
	
	MensajeAdjuntosEntity findByMensajeId(long idMensaje);
	
				
}


