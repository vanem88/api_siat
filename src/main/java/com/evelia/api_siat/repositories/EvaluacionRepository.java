package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.EvaluacionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluacionRepository extends JpaRepository<EvaluacionEntity, Long>{
	
	//Retorna todas los examenes de un aula
	List<EvaluacionEntity> findDistinctByAulaId(Long idAula);
	

}