package com.evelia.api_siat.repositories;


import com.evelia.api_siat.entity.TextoEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TextoRepository extends JpaRepository<TextoEntity, Long>{
	
	//Retorna todas las comunicaciones de un aula posteriores a una fecha de evento dada, que no esten eliminados.
	//Utilizado para obtener los eventos del calendario 
	@Query("SELECT T FROM TextoEntity T WHERE T.comunicacionId = ?1 AND T.eliminado = ?2 AND (T.fechaEvento >= ?3 OR T.fechaEvento = null) ORDER BY T.fechaEvento DESC")
	List<TextoEntity> ComunicacionIdAndEliminadoAndFechaEventoAfterOrFechaEventoIsNull(Long idCalendario, boolean eliminado,java.sql.Timestamp fechaDesde);
	
	//Retorna todos los eventos de una persona a partir de una fecha dada que no esten eliminados.
	//Utilizado para obtener los eventos personales
	List<TextoEntity> findByPersonaIdAndTipoEventoAndEliminadoAndFechaEventoAfter(Long idPersona,String tipoEvento, boolean eliminado,java.sql.Timestamp fechaDesde);
	
	//Retorna todas las comunicaciones de un aula que no esten eliminadas. 
	//Utilizado para obtener las noticias y los pizarrones.
	List<TextoEntity> findByComunicacionIdAndEliminadoOrderByFechaDesc(Long idComunicacion,boolean eliminado);
	
	
	//Retorna todas las comunicaciones de un aula, que no esten eliminadas, segun el tipo de evento (Actividades, foros.)
	@Query("SELECT T FROM TextoEntity T WHERE T.comunicacionId = ?1 AND T.eliminado = ?2 AND T.tipoEvento= ?3 AND T.personaId = ?4 ORDER BY T.fechaEvento DESC")
	List<TextoEntity> ComunicacionIdAndEliminadoAndTipoEventoOrPersonaId(Long idCalendario, boolean eliminado,String tipoEvento,Long idPersona);
			
}