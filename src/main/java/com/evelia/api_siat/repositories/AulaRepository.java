package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.AulaEntity;
import com.evelia.api_siat.entity.ComisionEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AulaRepository extends JpaRepository<AulaEntity, Long>{
	
	//Retorna todas las comisiones de un aula
	List<AulaEntity> findDistinctByAulaCompuestaId(Long idAula);
	
	AulaEntity findByAulaId(long idAula);
	
	
	//Java Persistence Query (JPQ)
	//@Query(value = "SELECT * FROM PARTICIPANTE P inner join PARTICIPANTE_COMISION PC ON (P.PARTICIPANTE_ID = PC.PARTICIPANTE_ID) WHERE PC.COMISION_ID = ?1 AND P.TIPO_USUARIO_ID = ?2", nativeQuery = true)
	//@Query("SELECT C FROM AulaEntity C inner join ParticipanteComisionEntity PC ON (C.aulaId = PC.comisionId) inner join ParticipanteEntity P ON (PC.participanteId = P.participanteId) WHERE C.aulaCompuestaId = ?2 AND P.personaId = ?1")
	@Query(value = "SELECT * FROM AULA C inner join PARTICIPANTE_COMISION PC ON (C.AULA_ID = PC.COMISION_ID) inner join PARTICIPANTE P ON (PC.PARTICIPANTE_ID = P.PARTICIPANTE_ID) WHERE C.AULA_COMPUESTA_ID = ?2 AND P.PERSONA_ID = ?1", nativeQuery = true)
	//@Query(value = "SELECT * FROM AULA C inner join PARTICIPANTE_COMISION PC ON (C.AULA_ID = PC.COMISION_ID) WHERE C.AULA_COMPUESTA_ID = ?2", nativeQuery = true)
	List<ComisionEntity> EncontrarComisiones(Long idPersona,Long idAula);

}