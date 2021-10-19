package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.ComisionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComisionRepository extends JpaRepository<ComisionEntity, Long>{
	
	//Dado el participante recupera todas las comisiones de un aula en las que participa.
	List<ComisionEntity> findDistinctByParticipanteComisionsByComisionIdParticipanteIdAndAulaByComisionIdAulaCompuestaId(Long idParticipante,Long idAula);
	
	//Dada una persona recupera todas las comisiones de un aula en las que participa.
	List<ComisionEntity> findByParticipanteComisionsByComisionIdParticipanteByParticipanteIdPersonaByPersonaIdPersonaIdAndAulaByComisionIdAulaCompuestaId(Long idPersona,Long idAula);
	
	                	                 
}