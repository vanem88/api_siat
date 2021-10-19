package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.ExamenFinalizadoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExamenFinalizadoRepository extends JpaRepository<ExamenFinalizadoEntity, Long>{
	
	//Recupera un examen finalizado de un usuario.
	ExamenFinalizadoEntity findByEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdAlumnoIdAndEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdEvaluacionId(Long idAlumno,Long idExamen);
	
	//Recupera todos los examenes finalizados de un aula
	List<ExamenFinalizadoEntity> findByEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdEvaluacionByEvaluacionIdAulaId(Long idAula);
	
	
	//@Query(value = "SELECT E FROM ExamenFinalizadoEntity E WHERE E.evaluacionFinalizadaConRespuestasByExamenFinalizadoId.EvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId.AlumnoId = ?1 AND E.E.evaluacionFinalizadaConRespuestasByExamenFinalizadoId.EvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId.EvaluacionId = ?2 AND (E.Reasignar=NULL OR (E.Reasignar!=NULL AND E.Reasignar!='Invalido'))", nativeQuery = true)
	//@Query(value = "SELECT E FROM ExamenFinalizadoEntity E WHERE E.evaluacionFinalizadaConRespuestasByExamenFinalizadoId.evaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId.PersonaByAlumnoId = ?1)", nativeQuery = true)
	//List<ExamenFinalizadoEntity> recuperarEvaluacionesFinalizadasAlumnoActivo(Long idAlumno,Long idExamen);
	
	//List<ExamenFinalizadoEntity> findByEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdPersonaByAlumnoIdPersonaId(Long idAlumno);
	
}

