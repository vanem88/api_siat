package com.evelia.api_siat.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.evelia.api_siat.entity.AutoexamenEntity;

public interface AutoExamenRepository extends JpaRepository<AutoexamenEntity, Long>{
	
	// Retorna todos los Autoexamenes del aula segun los campos "eliminado" y "publicado"
	List<AutoexamenEntity> findByEvaluacionByAutoexamenIdAulaIdAndEvaluacionByAutoexamenIdEliminadoAndEvaluacionByAutoexamenIdPublicado(Long idAula,boolean eliminado,boolean publicado);
	
	
}
