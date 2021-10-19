package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "RESPUESTA_PREGUNTA_SIAT", schema = "datosEveliaMinimo", catalog = "")
public class RespuestaPreguntaSiatEntity {
    private long respuestaPreguntaSiatId;
    private byte[] detalle;
    private Long encuestaSiatPersonaId;
    private Long id;
    private Long preguntaSiatId;
    private Long valorCalificacionId;
    private EncuestaSiatPersonaEntity encuestaSiatPersonaByEncuestaSiatPersonaId;
    private PreguntaSiatEntity preguntaSiatByPreguntaSiatId;
    private ValorCalificacionEntity valorCalificacionByValorCalificacionId;

    @Id
    @Column(name = "RESPUESTA_PREGUNTA_SIAT_ID")
    public long getRespuestaPreguntaSiatId() {
        return respuestaPreguntaSiatId;
    }

    public void setRespuestaPreguntaSiatId(long respuestaPreguntaSiatId) {
        this.respuestaPreguntaSiatId = respuestaPreguntaSiatId;
    }

    @Basic
    @Column(name = "DETALLE")
    public byte[] getDetalle() {
        return detalle;
    }

    public void setDetalle(byte[] detalle) {
        this.detalle = detalle;
    }

    @Basic
    @Column(name = "ENCUESTA_SIAT_PERSONA_ID")
    public Long getEncuestaSiatPersonaId() {
        return encuestaSiatPersonaId;
    }

    public void setEncuestaSiatPersonaId(Long encuestaSiatPersonaId) {
        this.encuestaSiatPersonaId = encuestaSiatPersonaId;
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
    @Column(name = "PREGUNTA_SIAT_ID")
    public Long getPreguntaSiatId() {
        return preguntaSiatId;
    }

    public void setPreguntaSiatId(Long preguntaSiatId) {
        this.preguntaSiatId = preguntaSiatId;
    }

    @Basic
    @Column(name = "VALOR_CALIFICACION_ID")
    public Long getValorCalificacionId() {
        return valorCalificacionId;
    }

    public void setValorCalificacionId(Long valorCalificacionId) {
        this.valorCalificacionId = valorCalificacionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RespuestaPreguntaSiatEntity that = (RespuestaPreguntaSiatEntity) o;

        if (respuestaPreguntaSiatId != that.respuestaPreguntaSiatId) return false;
        if (!Arrays.equals(detalle, that.detalle)) return false;
        if (encuestaSiatPersonaId != null ? !encuestaSiatPersonaId.equals(that.encuestaSiatPersonaId) : that.encuestaSiatPersonaId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (preguntaSiatId != null ? !preguntaSiatId.equals(that.preguntaSiatId) : that.preguntaSiatId != null)
            return false;
        if (valorCalificacionId != null ? !valorCalificacionId.equals(that.valorCalificacionId) : that.valorCalificacionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (respuestaPreguntaSiatId ^ (respuestaPreguntaSiatId >>> 32));
        result = 31 * result + Arrays.hashCode(detalle);
        result = 31 * result + (encuestaSiatPersonaId != null ? encuestaSiatPersonaId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (preguntaSiatId != null ? preguntaSiatId.hashCode() : 0);
        result = 31 * result + (valorCalificacionId != null ? valorCalificacionId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ENCUESTA_SIAT_PERSONA_ID", referencedColumnName = "ENCUESTA_SIAT_PERSONA_ID", insertable=false, updatable=false)
    public EncuestaSiatPersonaEntity getEncuestaSiatPersonaByEncuestaSiatPersonaId() {
        return encuestaSiatPersonaByEncuestaSiatPersonaId;
    }

    public void setEncuestaSiatPersonaByEncuestaSiatPersonaId(EncuestaSiatPersonaEntity encuestaSiatPersonaByEncuestaSiatPersonaId) {
        this.encuestaSiatPersonaByEncuestaSiatPersonaId = encuestaSiatPersonaByEncuestaSiatPersonaId;
    }

    @ManyToOne
    @JoinColumn(name = "PREGUNTA_SIAT_ID", referencedColumnName = "PREGUNTA_SIAT_ID", insertable=false, updatable=false)
    public PreguntaSiatEntity getPreguntaSiatByPreguntaSiatId() {
        return preguntaSiatByPreguntaSiatId;
    }

    public void setPreguntaSiatByPreguntaSiatId(PreguntaSiatEntity preguntaSiatByPreguntaSiatId) {
        this.preguntaSiatByPreguntaSiatId = preguntaSiatByPreguntaSiatId;
    }

    @ManyToOne
    @JoinColumn(name = "VALOR_CALIFICACION_ID", referencedColumnName = "VALOR_CALIFICACION_ID", insertable=false, updatable=false)
    public ValorCalificacionEntity getValorCalificacionByValorCalificacionId() {
        return valorCalificacionByValorCalificacionId;
    }

    public void setValorCalificacionByValorCalificacionId(ValorCalificacionEntity valorCalificacionByValorCalificacionId) {
        this.valorCalificacionByValorCalificacionId = valorCalificacionByValorCalificacionId;
    }
}
