package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.ActividadEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActividadRepository extends JpaRepository<ActividadEntity, Long>{
	
	//Retorna todas las actividades de una comision
	//List<ActividadEntity> findDistinctByAulaId(Long idComision);
	
	//Retorna todas las actividades de una comision que estan disponibles para visualizar
	@Query(value = "SELECT * FROM ACTIVIDAD A inner join PUBLICACION P WHERE (A.id = P.ids_Genera) AND A.aula_Id = ?1 AND (P.fecha_Apertura <= ?2 OR P.fecha_Apertura IS NULL) AND (P.fecha_Cierre >= ?2 OR P.fecha_Cierre IS NULL) ORDER BY P.fecha_Cierre DESC", nativeQuery = true)
	List<ActividadEntity> ActividadesDisponibles(Long idComision,java.sql.Timestamp fechaHoy);
	

}