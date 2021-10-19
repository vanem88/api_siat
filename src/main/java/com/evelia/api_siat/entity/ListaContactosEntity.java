package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "LISTA_CONTACTOS", schema = "datosEveliaMinimo", catalog = "")
public class ListaContactosEntity {
    private long listaContactosId;
    private Long id;
    private String nombre;
    private Long autorId;
    private PersonaEntity personaByAutorId;
    private Collection<ListaContactosPersonasEntity> listaContactosPersonasByListaContactosId;

    @Id
    @Column(name = "LISTA_CONTACTOS_ID")
    public long getListaContactosId() {
        return listaContactosId;
    }

    public void setListaContactosId(long listaContactosId) {
        this.listaContactosId = listaContactosId;
    }

    @Basic
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "AUTOR_ID")
    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaContactosEntity that = (ListaContactosEntity) o;

        if (listaContactosId != that.listaContactosId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (autorId != null ? !autorId.equals(that.autorId) : that.autorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (listaContactosId ^ (listaContactosId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (autorId != null ? autorId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "AUTOR_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByAutorId() {
        return personaByAutorId;
    }

    public void setPersonaByAutorId(PersonaEntity personaByAutorId) {
        this.personaByAutorId = personaByAutorId;
    }

    @OneToMany(mappedBy = "listaContactosByListaContactosId")
    public Collection<ListaContactosPersonasEntity> getListaContactosPersonasByListaContactosId() {
        return listaContactosPersonasByListaContactosId;
    }

    public void setListaContactosPersonasByListaContactosId(Collection<ListaContactosPersonasEntity> listaContactosPersonasByListaContactosId) {
        this.listaContactosPersonasByListaContactosId = listaContactosPersonasByListaContactosId;
    }
}
