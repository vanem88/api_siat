package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.PublicacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<PublicacionEntity, Long>{
	
	PublicacionEntity findByIdsGenera(String idsGenera);
	
	
}