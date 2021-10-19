package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ENCUESTA_SIAT_PERSONA", schema = "datosEveliaMinimo", catalog = "")
public class EncuestaSiatPersonaEntity {
    private long encuestaSiatPersonaId;
    private Long encuestaSiatId;
    private String estado;
    private Long id;
    private Long personaId;
    private String edad;
    private EncuestaSiatEntity encuestaSiatByEncuestaSiatId;
    private PersonaEntity personaByPersonaId;
    private Collection<RespuestaPreguntaSiatEntity> respuestaPreguntaSiatsByEncuestaSiatPersonaId;

    @Id
    @Column(name = "ENCUESTA_SIAT_PERSONA_ID")
    public long getEncuestaSiatPersonaId() {
        return encuestaSiatPersonaId;
    }

    public void setEncuestaSiatPersonaId(long encuestaSiatPersonaId) {
        this.encuestaSiatPersonaId = encuestaSiatPersonaId;
    }

    @Basic
    @Column(name = "ENCUESTA_SIAT_ID")
    public Long getEncuestaSiatId() {
        return encuestaSiatId;
    }

    public void setEncuestaSiatId(Long encuestaSiatId) {
        this.encuestaSiatId = encuestaSiatId;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
    @Column(name = "PERSONA_ID")
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    @Basic
    @Column(name = "EDAD")
    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EncuestaSiatPersonaEntity that = (EncuestaSiatPersonaEntity) o;

        if (encuestaSiatPersonaId != that.encuestaSiatPersonaId) return false;
        if (encuestaSiatId != null ? !encuestaSiatId.equals(that.encuestaSiatId) : that.encuestaSiatId != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (edad != null ? !edad.equals(that.edad) : that.edad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (encuestaSiatPersonaId ^ (encuestaSiatPersonaId >>> 32));
        result = 31 * result + (encuestaSiatId != null ? encuestaSiatId.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (edad != null ? edad.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ENCUESTA_SIAT_ID", referencedColumnName = "ENCUESTA_SIAT_ID", insertable=false, updatable=false)
    public EncuestaSiatEntity getEncuestaSiatByEncuestaSiatId() {
        return encuestaSiatByEncuestaSiatId;
    }

    public void setEncuestaSiatByEncuestaSiatId(EncuestaSiatEntity encuestaSiatByEncuestaSiatId) {
        this.encuestaSiatByEncuestaSiatId = encuestaSiatByEncuestaSiatId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @OneToMany(mappedBy = "encuestaSiatPersonaByEncuestaSiatPersonaId")
    public Collection<RespuestaPreguntaSiatEntity> getRespuestaPreguntaSiatsByEncuestaSiatPersonaId() {
        return respuestaPreguntaSiatsByEncuestaSiatPersonaId;
    }

    public void setRespuestaPreguntaSiatsByEncuestaSiatPersonaId(Collection<RespuestaPreguntaSiatEntity> respuestaPreguntaSiatsByEncuestaSiatPersonaId) {
        this.respuestaPreguntaSiatsByEncuestaSiatPersonaId = respuestaPreguntaSiatsByEncuestaSiatPersonaId;
    }
}
