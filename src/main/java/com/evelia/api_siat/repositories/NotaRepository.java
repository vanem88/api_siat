package com.evelia.api_siat.repositories;


import com.evelia.api_siat.entity.NotaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NotaRepository extends JpaRepository<NotaEntity, Long>{
	
	//vista alumnos
	//Retorna todas las calificaciones de un alumno en un aula dada.
	@Query(value = "SELECT DISTINCT * FROM NOTA N join ACTIVIDAD A  join PUBLICACION P ON (N.ACTIVIDAD_ID = A.ACTIVIDAD_ID) AND (A.PUBLICACION_ID = P.PUBLICACION_ID) AND A.AULA_ID = ?1 AND N.PERSONA_ID = ?2 ORDER BY P.FECHA_CIERRE ASC", nativeQuery = true)
	List<NotaEntity> CalificacionesAlumno(Long idAula, Long idAlumno);
	
	NotaEntity findDistinctByActividadIdAndPersonaId(Long idActividad, Long idAlumno);
	
	List<NotaEntity> findDistinctByActividadByActividadIdAulaIdAndPersonaId(Long idAula, Long idAlumno);
			
}