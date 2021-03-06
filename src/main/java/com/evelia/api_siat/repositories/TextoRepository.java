package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.TextoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TextoRepository extends JpaRepository<TextoEntity, Long>{
	
	//Retorna todas las comunicaciones de un aula posteriores a una fecha de evento dada, que no esten eliminados.
	//Utilizado para obtener los eventos del calendario 
	//@Query("SELECT T FROM TextoEntity T WHERE T.comunicacionId = ?1 AND T.eliminado = ?2 AND ((T.fechaEvento = null AND T.fechaFinEvento = null) OR (T.fechaEvento <= ?3 AND T.fechaFinEvento = null) OR (T.fechaEvento <= ?3 AND T.fechaFinEvento >= ?3)  OR (T.fecha <= ?3 AND T.fechaFinEvento >= ?3)) ORDER BY T.fechaEvento DESC")
	@Query("SELECT T FROM TextoEntity T WHERE T.comunicacionId = ?1 AND T.eliminado = ?2 AND (T.fechaEvento >= ?3 OR T.fechaEvento = null) ORDER BY T.fechaEvento DESC")
	List<TextoEntity> EventosDelCalendarioDisponibles(Long idCalendario, boolean eliminado,java.sql.Timestamp fechaDesde);
	
	//Retorna todos los eventos de una persona a partir de una fecha dada que no esten eliminados.
	//Utilizado para obtener los eventos personales
	List<TextoEntity> findByPersonaIdAndTipoEventoAndEliminadoAndFechaEventoAfterOrderByFechaDesc(Long idPersona,String tipoEvento, boolean eliminado,java.sql.Timestamp fechaDesde);
	
	//Retorna todas las comunicaciones de un aula que no esten eliminadas. 
	//Utilizado para obtener las noticias y los pizarrones.
	@Query(value = "SELECT * FROM TEXTO T inner join PUBLICACION P WHERE (T.id = P.ids_Genera) AND T.comunicacion_Id = ?1 AND T.eliminado = ?2 AND (P.fecha_Apertura <= ?3 OR P.fecha_Apertura IS NULL) AND (P.fecha_Cierre >= ?3 OR P.fecha_Cierre IS NULL) ORDER BY P.fecha_Apertura DESC", nativeQuery = true)
	List<TextoEntity> ComunicacionesDisponibles(Long idComunicacion,boolean eliminado,java.sql.Timestamp fechaHoy);
	
	//List<TextoEntity> findByComunicacionIdAndEliminadoOrderByFechaDesc(Long idComunicacion,boolean eliminado);
	//verrrrrrr filtras en publicacion
	//@Query("SELECT T FROM TextoEntity T WHERE T.comunicacionId = ?1 AND T.eliminado = ?2 AND (T.fechaEvento >= ?3 OR T.fechaEvento = null) ORDER BY T.fechaEvento DESC")
	//List<TextoEntity> findByComunicacionIdAndEliminadoOrderByFechaDesc(Long idComunicacion,boolean eliminado,Timestamp fechaActual);
	
	//Retorna todas las comunicaciones de un aula, que no esten eliminadas, segun el tipo de evento (Actividades, foros.)
	//@Query("SELECT T FROM TextoEntity T WHERE T.comunicacionId = ?1 AND T.eliminado = ?2 AND T.tipoEvento= ?3 AND T.personaId = ?4 ORDER BY T.fechaEvento DESC")
	//List<TextoEntity> ComunicacionIdAndEliminadoAndTipoEventoOrPersonaId(Long idCalendario, boolean eliminado,String tipoEvento,Long idPersona);
	
	//Retorna la comunicacion(Noticia, pizarron, etc) idTexto de un aula que no este eliminada y que se pueda visualizar segun las fechas de publicacion 
	@Query(value = "SELECT * FROM TEXTO t inner join PUBLICACION p on t.PUBLICACION_ID = p.PUBLICACION_ID WHERE t.TEXTO_ID= ?1 AND t.ELIMINADO = ?2 AND (p.fecha_Apertura <= ?3 OR p.fecha_Apertura IS NULL) AND (p.fecha_Cierre >= ?3 OR p.fecha_Cierre IS NULL)", nativeQuery = true)
	List<TextoEntity> textoSegunPublicacion(Long idTexto,boolean eliminado,java.sql.Timestamp fechaHoy);
		
	
		
			
}