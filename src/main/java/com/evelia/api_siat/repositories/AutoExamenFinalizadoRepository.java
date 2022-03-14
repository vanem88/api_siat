package com.evelia.api_siat.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.evelia.api_siat.entity.AutoexamenFinalizadoEntity;

public interface AutoExamenFinalizadoRepository extends JpaRepository<AutoexamenFinalizadoEntity, Long>{
	
	//Recupera un autoexamen finalizado de un usuario.
	AutoexamenFinalizadoEntity findByEvaluacionFinalizadaByAutoexamenFinalizadoIdPersonaByAlumnoIdAndEvaluacionFinalizadaByAutoexamenFinalizadoIdEvaluacionId(Long idAlumno,Long idExamen);
	
	//Recupera todos los autoexamenes finalizados de un aula
	List<AutoexamenFinalizadoEntity> findByEvaluacionFinalizadaByAutoexamenFinalizadoIdEvaluacionByEvaluacionIdAulaId(Long idAula);
	
	
}

