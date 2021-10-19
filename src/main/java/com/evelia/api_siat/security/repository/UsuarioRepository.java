package com.evelia.api_siat.security.repository;

import com.evelia.api_siat.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {
    Optional<Usuario> findByUsuario(String usuario);
    boolean existsByUsuario(String usuario);
    boolean existsByEmail(String email);
    boolean existsByNumeroDoc(String numeroDoc);

}
