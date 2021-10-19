package com.evelia.api_siat.security.service;

import com.evelia.api_siat.security.entity.Usuario;
import com.evelia.api_siat.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
    	Usuario u = usuarioService.getByUsuario(usuario).get();
        return UsuarioPrincipal.build(u);
    }
}
