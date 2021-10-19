package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.ParticipanteComisionEntity;
import com.evelia.api_siat.entity.ParticipanteEntity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ParticipanteComisionRepository extends JpaRepository<ParticipanteComisionEntity, Long>{
	
	//Retorna el participante de la comision 
	List<ParticipanteComisionEntity> findByComisionIdAndParticipanteId(Long idComision,Long idParticipante);
	
	//Retorna todos los paraticipantes de la comision segun su rol
	List<ParticipanteComisionEntity> findByComisionIdAndTipoUsuarioId(Long idComision,Long tipoUsuarioId);
	
	
	
	List<ParticipanteComisionEntity> findByComisionId(Long idComision);
	
	@Query(value = "SELECT * FROM PARTICIPANTE_COMISION WHERE COMISION_ID = ?1", nativeQuery = true)
	List<ParticipanteComisionEntity> participantesDeUnaComision(Long idComision);
	
	
}