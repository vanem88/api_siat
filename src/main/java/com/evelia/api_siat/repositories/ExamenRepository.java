package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.ExamenEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<ExamenEntity, Long>{
	
	// Retorna todos los Autoexamenes del aula segun los campos "eliminado" y "publicado"
	List<ExamenEntity> findByEvaluacionByExamenIdAulaIdAndEvaluacionByExamenIdEliminadoAndEvaluacionByExamenIdPublicado(Long idAula,boolean eliminado,boolean publicado);
	
}