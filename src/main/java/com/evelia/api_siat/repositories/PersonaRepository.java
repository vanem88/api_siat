package com.evelia.api_siat.repositories;


import com.evelia.api_siat.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long>{
	
	//Recupera una persona segun su tipo y numero de docuemtno.
	PersonaEntity findByTipoDocAndNumeroDoc(String tipoDoc,String numeroDoc);
	

	
	
}