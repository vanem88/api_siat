package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity, Long>{
	
	//Recupera el tipo de usuario segun su nombre.
	TipoUsuarioEntity findByNombre(String TipoUsuario);
	
}