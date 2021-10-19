package com.evelia.api_siat.repositories;


import com.evelia.api_siat.entity.ForoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ForoRepository extends JpaRepository<ForoEntity, Long>{
	
	//@Query(value = "SELECT * FROM foro F inner join publicacion P WHERE (F.id = P.ids_Genera) AND F.aula_Id = ?1 AND (P.fecha_Cierre >= ?2 OR P.fecha_Cierre IS NULL) ORDER BY P.fecha_Cierre DESC", nativeQuery = true)
	//List<ForoEntity> ForosConCierrePosteriorA(Long idAula, java.sql.Timestamp fechaCierre);
	
	//Recupera todos los foros de una aula con fecha de cierre posterior a la fecha dada
	@Query(value = "SELECT * FROM FORO F inner join PUBLICACION P WHERE (F.id = P.ids_Genera) AND F.aula_Id = ?1 AND (P.fecha_Apertura <= ?2 OR P.fecha_Apertura IS NULL) AND (P.fecha_Cierre >= ?2 OR P.fecha_Cierre IS NULL) ORDER BY P.fecha_Cierre DESC", nativeQuery = true)
	List<ForoEntity> ForosConCierrePosteriorA(Long idAula, java.sql.Timestamp fechaHoy);
	
	//Recupera todos los foros de una aula
	List<ForoEntity> findByAulaId(Long idAula);
}