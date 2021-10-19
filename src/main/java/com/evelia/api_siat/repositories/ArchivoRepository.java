package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.ArchivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchivoRepository extends JpaRepository<ArchivoEntity, Long>{
	
	//List<ArchivoEntity> findDistinctByAulaId(Long idComision);
	

}