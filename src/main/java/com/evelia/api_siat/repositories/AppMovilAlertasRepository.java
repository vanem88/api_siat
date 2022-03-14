package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.AppMovilAlertasEntity;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppMovilAlertasRepository extends JpaRepository<AppMovilAlertasEntity, Long>{
	
	@Query(value = "SELECT * FROM APP_MOVIL_ALERTAS as ama inner join APP_MOVIL_ALERTAS_USUARIO as amau on ama.ALERTA_ID=amau.ALERTA_ID where ama.AULA_ID= ?1 and amau.PERSONA_ID= ?2 order by ama.FECHA DESC", nativeQuery = true)
	List<AppMovilAlertasEntity> ObtenerAlertasAulaPorParticipante(Long idAula,Long idPersona);
	
	@Query(value = "SELECT * FROM APP_MOVIL_ALERTAS as ama inner join APP_MOVIL_ALERTAS_USUARIO as amau on ama.ALERTA_ID=amau.ALERTA_ID where ama.AULA_ID= ?1 and ama.COMISION_ID= ?2 and amau.PERSONA_ID= ?3 order by ama.FECHA DESC", nativeQuery = true)
	List<AppMovilAlertasEntity> ObtenerAlertasComisionPorParticipante(Long idAula,Long idComision,Long idPersona);
	
	
}