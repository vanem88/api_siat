package com.evelia.api_siat.security.entity;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "PERSONA")
public class Usuario implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSONA_ID")
    //@Column(name = "ID")
    private Long id;
    @Column(name = "LOGIN")
    private String usuario;
    @Column(name = "NUMERO_DOC")
    private String numeroDoc;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    // @ManyToMany(fetch = FetchType.EAGER)
    // @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    // inverseJoinColumns = @JoinColumn(name = "rol_id"))
    //private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(@NotNull String usuario, @NotNull String numeroDoc, @NotNull String email, @NotNull String password) {
        this.numeroDoc = numeroDoc;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
    }

    public String getNumeroDoc() {
		return numeroDoc;
	}
	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public Set<Rol> getRoles() {
    //     return roles;
    // }

    // public void setRoles(Set<Rol> roles) {
    //     this.roles = roles;
    // }
}
