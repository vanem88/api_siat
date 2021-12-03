package com.evelia.api_siat.repositories;

import com.evelia.api_siat.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface PersonaRepository extends JpaRepository<PersonaEntity, Long>{
	
	//Recupera una persona segun su tipo y numero de docuemtno.
	PersonaEntity findByTipoDocAndNumeroDoc(String tipoDoc,String numeroDoc);
	
	@Transactional
	@Modifying
    //@Query(value = "UPDATE PERSONA p SET p.NOMBRE = ?2 WHERE p.NUMERO_DOC = ?1", nativeQuery = true)
	@Query("update PersonaEntity SET nombre = ?2 WHERE id = ?1")	
    void actualizarUsuario(Long id, String nombre);
  
	
}