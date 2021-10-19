package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "RESPUESTA", schema = "datosEveliaMinimo", catalog = "")
public class RespuestaEntity {
    private long respuestaId;
    private Long aulaId;
    private Long id;
    private Long personaId;
    private Long preguntaId;
    private AulaEntity aulaByAulaId;
    private PersonaEntity personaByPersonaId;
    private PreguntaEntity preguntaByPreguntaId;

    @Id
    @Column(name = "RESPUESTA_ID")
    public long getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(long respuestaId) {
        this.respuestaId = respuestaId;
    }

    @Basic
    @Column(name = "AULA_ID")
    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
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
    @Column(name = "PREGUNTA_ID")
    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RespuestaEntity that = (RespuestaEntity) o;

        if (respuestaId != that.respuestaId) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (preguntaId != null ? !preguntaId.equals(that.preguntaId) : that.preguntaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (respuestaId ^ (respuestaId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (preguntaId != null ? preguntaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "AULA_ID", referencedColumnName = "AULA_ID", insertable=false, updatable=false)
    public AulaEntity getAulaByAulaId() {
        return aulaByAulaId;
    }

    public void setAulaByAulaId(AulaEntity aulaByAulaId) {
        this.aulaByAulaId = aulaByAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @ManyToOne
    @JoinColumn(name = "PREGUNTA_ID", referencedColumnName = "PREGUNTA_ID", insertable=false, updatable=false)
    public PreguntaEntity getPreguntaByPreguntaId() {
        return preguntaByPreguntaId;
    }

    public void setPreguntaByPreguntaId(PreguntaEntity preguntaByPreguntaId) {
        this.preguntaByPreguntaId = preguntaByPreguntaId;
    }
}
