package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.ActividadEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepository extends JpaRepository<ActividadEntity, Long>{
	
	//Retorna todas las actividades de una comision
	List<ActividadEntity> findDistinctByAulaId(Long idComision);
	

}