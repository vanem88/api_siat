package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "LISTA_CONTACTOS_PERSONAS", schema = "datosEveliaMinimo", catalog = "")
public class ListaContactosPersonasEntity {
    
    private long listaContactosId;
    private long personaId;
    private ListaContactosEntity listaContactosByListaContactosId;
    private PersonaEntity personaByPersonaId;

    @Basic
    @Id
    @Column(name = "LISTA_CONTACTOS_ID")
    public long getListaContactosId() {
        return listaContactosId;
    }

    public void setListaContactosId(long listaContactosId) {
        this.listaContactosId = listaContactosId;
    }

    @Basic
    @Column(name = "PERSONA_ID")
    public long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(long personaId) {
        this.personaId = personaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaContactosPersonasEntity that = (ListaContactosPersonasEntity) o;

        if (listaContactosId != that.listaContactosId) return false;
        if (personaId != that.personaId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (listaContactosId ^ (listaContactosId >>> 32));
        result = 31 * result + (int) (personaId ^ (personaId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "LISTA_CONTACTOS_ID", referencedColumnName = "LISTA_CONTACTOS_ID", nullable = false, insertable=false, updatable=false)
    public ListaContactosEntity getListaContactosByListaContactosId() {
        return listaContactosByListaContactosId;
    }

    public void setListaContactosByListaContactosId(ListaContactosEntity listaContactosByListaContactosId) {
        this.listaContactosByListaContactosId = listaContactosByListaContactosId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", nullable = false, insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
}
