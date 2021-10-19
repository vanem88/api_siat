package com.evelia.api_siat.security.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private Long id;
    private String usuario;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token, Long id, String usuario, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.token = token;
        this.usuario = usuario;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getusuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
