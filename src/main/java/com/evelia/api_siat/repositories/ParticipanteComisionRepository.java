package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.ParticipanteComisionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParticipanteComisionRepository extends JpaRepository<ParticipanteComisionEntity, Long>{
	
	//Retorna el participante de la comision 
	List<ParticipanteComisionEntity> findByComisionIdAndParticipanteId(Long idComision,Long idParticipante);
	
	//Retorna todos los paraticipantes de la comision segun su rol
	List<ParticipanteComisionEntity> findByComisionIdAndTipoUsuarioId(Long idComision,Long tipoUsuarioId);
	
	List<ParticipanteComisionEntity> findByComisionId(Long idComision);
	
}