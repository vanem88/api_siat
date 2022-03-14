package com.evelia.api_siat.repositories;


import com.evelia.api_siat.entity.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<ComentarioEntity, Long>{

	ComentarioEntity findByComentarioId(long idComentario);          	                 
}