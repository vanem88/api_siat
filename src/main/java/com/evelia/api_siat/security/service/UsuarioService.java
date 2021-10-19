package com.evelia.api_siat.security.service;

import com.evelia.api_siat.security.entity.Usuario;
import com.evelia.api_siat.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByUsuario(String usuario){
        return usuarioRepository.findByUsuario(usuario);
    }

    public boolean existsByusuario(String usuario){
        return usuarioRepository.existsByUsuario(usuario);
    }

    public boolean existsByNumeroDoc(String numeroDoc){
        return usuarioRepository.existsByNumeroDoc(numeroDoc);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
