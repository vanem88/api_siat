package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "PRESPUESTA_CERRADA", schema = "datosEveliaMinimo", catalog = "")
public class PrespuestaCerradaEntity {
    private long prespuestaCerradaId;
    private byte[] pregunta;
    private String respuesta;
    private PreguntaExEntity preguntaExByPrespuestaCerradaId;

    @Id
    @Column(name = "PRESPUESTA_CERRADA_ID")
    public long getPrespuestaCerradaId() {
        return prespuestaCerradaId;
    }

    public void setPrespuestaCerradaId(long prespuestaCerradaId) {
        this.prespuestaCerradaId = prespuestaCerradaId;
    }

    @Basic
    @Column(name = "PREGUNTA")
    public byte[] getPregunta() {
        return pregunta;
    }

    public void setPregunta(byte[] pregunta) {
        this.pregunta = pregunta;
    }

    @Basic
    @Column(name = "RESPUESTA")
    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrespuestaCerradaEntity that = (PrespuestaCerradaEntity) o;

        if (prespuestaCerradaId != that.prespuestaCerradaId) return false;
        if (!Arrays.equals(pregunta, that.pregunta)) return false;
        if (respuesta != null ? !respuesta.equals(that.respuesta) : that.respuesta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (prespuestaCerradaId ^ (prespuestaCerradaId >>> 32));
        result = 31 * result + Arrays.hashCode(pregunta);
        result = 31 * result + (respuesta != null ? respuesta.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "PRESPUESTA_CERRADA_ID", referencedColumnName = "PREGUNTA_EX_ID", nullable = false, insertable=false, updatable=false)
    public PreguntaExEntity getPreguntaExByPrespuestaCerradaId() {
        return preguntaExByPrespuestaCerradaId;
    }

    public void setPreguntaExByPrespuestaCerradaId(PreguntaExEntity preguntaExByPrespuestaCerradaId) {
        this.preguntaExByPrespuestaCerradaId = preguntaExByPrespuestaCerradaId;
    }
}
