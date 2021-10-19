package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "PREGUNTA_OPCION_RESPUESTA", schema = "datosEveliaMinimo", catalog = "")
public class PreguntaOpcionRespuestaEntity {
    private long preguntaOpcionRespuestaId;
    private Long id;
    private Long opcionRespuestaId;
    private Long preguntaId;
    private OpcionRespuestaEntity opcionRespuestaByOpcionRespuestaId;
    private PreguntaEntity preguntaByPreguntaId;

    @Id
    @Column(name = "PREGUNTA_OPCION_RESPUESTA_ID")
    public long getPreguntaOpcionRespuestaId() {
        return preguntaOpcionRespuestaId;
    }

    public void setPreguntaOpcionRespuestaId(long preguntaOpcionRespuestaId) {
        this.preguntaOpcionRespuestaId = preguntaOpcionRespuestaId;
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
    @Column(name = "OPCION_RESPUESTA_ID")
    public Long getOpcionRespuestaId() {
        return opcionRespuestaId;
    }

    public void setOpcionRespuestaId(Long opcionRespuestaId) {
        this.opcionRespuestaId = opcionRespuestaId;
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

        PreguntaOpcionRespuestaEntity that = (PreguntaOpcionRespuestaEntity) o;

        if (preguntaOpcionRespuestaId != that.preguntaOpcionRespuestaId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (opcionRespuestaId != null ? !opcionRespuestaId.equals(that.opcionRespuestaId) : that.opcionRespuestaId != null)
            return false;
        if (preguntaId != null ? !preguntaId.equals(that.preguntaId) : that.preguntaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (preguntaOpcionRespuestaId ^ (preguntaOpcionRespuestaId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (opcionRespuestaId != null ? opcionRespuestaId.hashCode() : 0);
        result = 31 * result + (preguntaId != null ? preguntaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "OPCION_RESPUESTA_ID", referencedColumnName = "OPCION_RESPUESTA_ID", insertable=false, updatable=false)
    public OpcionRespuestaEntity getOpcionRespuestaByOpcionRespuestaId() {
        return opcionRespuestaByOpcionRespuestaId;
    }

    public void setOpcionRespuestaByOpcionRespuestaId(OpcionRespuestaEntity opcionRespuestaByOpcionRespuestaId) {
        this.opcionRespuestaByOpcionRespuestaId = opcionRespuestaByOpcionRespuestaId;
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
