package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.ActividadArchivosAdjuntosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadArchivosAdjuntosRepository extends JpaRepository<ActividadArchivosAdjuntosEntity, Long>{
	
	
	ActividadArchivosAdjuntosEntity findByActividadId(long idActividad);
	
				
}



