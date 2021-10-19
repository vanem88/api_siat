package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.AulaCompuestaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AulaCompuestaRepository extends JpaRepository<AulaCompuestaEntity, Long>{
	
	//Recupera todas las aulas activas en las que participa el usuario
	List<AulaCompuestaEntity> findDistinctByAulaByAulaCompuestaIdParticipantesByAulaIdPersonaIdAndEstadoAulaByEstadoAulaIdDescripcion(Long idUsuario,String estadoAula);

	
}