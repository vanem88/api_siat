package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.PermisoAccesoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisoAccesoRepository extends JpaRepository<PermisoAccesoEntity, Long>{
	
	//Recupera todos los permisos para un recurso que existe en un aula dada paa un tipo de usuario. 
	List<PermisoAccesoEntity> findByRecursoByRecursoIdNombreAndAulaIdAndTipoUsuarioId(String recurso, Long idAula, Long idTipoUsuario);
				
}