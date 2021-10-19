package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.ParticipanteEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ParticipanteRepository extends JpaRepository<ParticipanteEntity, Long>{
	
	//Recupera todos los participantes de un aula.
	List<ParticipanteEntity> findByAulaId(Long idAula);
	
	//Devuelve el participante de un aula segun el tipo de usuario dado.
	ParticipanteEntity findByAulaIdAndTipoUsuarioByTipoUsuarioIdNombre(Long idAula,String tipoUsuario);
	
	//Recupera todos los participantes de un aula relacionados con una persona.
	List<ParticipanteEntity> findByAulaIdAndPersonaId(Long idAula,Long idPersona);
	
	//Si existe, devuelve el participante del aula 'idAula' con el rol "tipoUsuario"
	ParticipanteEntity findByAulaIdAndPersonaIdAndTipoUsuarioByTipoUsuarioIdNombre(Long idAula,Long idPersona,String tipoUsuario);
	
	
	@Query(value = "SELECT * FROM PARTICIPANTE P inner join PARTICIPANTE_COMISION PC ON (P.PARTICIPANTE_ID = PC.PARTICIPANTE_ID) WHERE PC.COMISION_ID = ?1 AND P.TIPO_USUARIO_ID = ?2", nativeQuery = true)
	List<ParticipanteEntity> recuperarParticipantesSegunTipoUsuarioEnComision(Long idComision,Long idTipoUsuario);
	
	
}