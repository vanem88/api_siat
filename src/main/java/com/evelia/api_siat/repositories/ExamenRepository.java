package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.ExamenEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<ExamenEntity, Long>{
	
	//Retorna todas los examenes de un aula
	//List<ExamenEntity> findByEvaluacionByExamenIdAulaIdAndEvaluacionByExamenIdEliminadoAndOrderByEvaluacionByExamenIdNombreAsc(Long idAula,boolean eliminado);
	
	List<ExamenEntity> findByEvaluacionByExamenIdAulaIdAndEvaluacionByExamenIdEliminado(Long idAula,boolean eliminado);
	
	List<ExamenEntity> findByEvaluacionByExamenIdAulaId(Long idAula);
	
}