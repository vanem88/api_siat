package com.evelia.api_siat.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.NoOp;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
//import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
    private Long id;
    private String usuario;
    private String numeroDoc;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(Long id, String usuario, String numeroDoc, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.usuario = usuario;
        this.numeroDoc = numeroDoc;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
                
        return new UsuarioPrincipal(usuario.getId(), usuario.getUsuario(), usuario.getNumeroDoc(), usuario.getEmail(), usuario.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public String getEmail() {
        return email;
    }
    
    public Long getId(){
        return id;
    }
}
