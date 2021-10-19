package com.evelia.api_siat.security.dto;

import javax.validation.constraints.NotBlank;

import com.evelia.api_siat.utils.*;

public class User {
    @NotBlank
    private String usuario;
    @NotBlank
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        
        Util u = new Util();
        u.setString("100-3-248-97-234-56-100-241");
        
        return u.encrypt(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
}
