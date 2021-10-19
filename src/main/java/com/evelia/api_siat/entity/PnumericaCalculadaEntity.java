package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "PNUMERICA_CALCULADA", schema = "datosEveliaMinimo", catalog = "")
public class PnumericaCalculadaEntity {
    private long pnumericaCalculadaId;
    private byte[] pregunta;
    private double respuesta;
    private PreguntaExEntity preguntaExByPnumericaCalculadaId;

    @Id
    @Column(name = "PNUMERICA_CALCULADA_ID")
    public long getPnumericaCalculadaId() {
        return pnumericaCalculadaId;
    }

    public void setPnumericaCalculadaId(long pnumericaCalculadaId) {
        this.pnumericaCalculadaId = pnumericaCalculadaId;
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
    public double getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(double respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PnumericaCalculadaEntity that = (PnumericaCalculadaEntity) o;

        if (pnumericaCalculadaId != that.pnumericaCalculadaId) return false;
        if (Double.compare(that.respuesta, respuesta) != 0) return false;
        if (!Arrays.equals(pregunta, that.pregunta)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (pnumericaCalculadaId ^ (pnumericaCalculadaId >>> 32));
        result = 31 * result + Arrays.hashCode(pregunta);
        temp = Double.doubleToLongBits(respuesta);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToOne
    @JoinColumn(name = "PNUMERICA_CALCULADA_ID", referencedColumnName = "PREGUNTA_EX_ID", nullable = false, insertable=false, updatable=false)
    public PreguntaExEntity getPreguntaExByPnumericaCalculadaId() {
        return preguntaExByPnumericaCalculadaId;
    }

    public void setPreguntaExByPnumericaCalculadaId(PreguntaExEntity preguntaExByPnumericaCalculadaId) {
        this.preguntaExByPnumericaCalculadaId = preguntaExByPnumericaCalculadaId;
    }
}
