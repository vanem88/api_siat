package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "PRESPUESTA_ABIERTA", schema = "datosEveliaMinimo", catalog = "")
public class PrespuestaAbiertaEntity {
    private long prespuestaAbiertaId;
    private byte[] pregunta;
    private PreguntaExEntity preguntaExByPrespuestaAbiertaId;

    @Id
    @Column(name = "PRESPUESTA_ABIERTA_ID")
    public long getPrespuestaAbiertaId() {
        return prespuestaAbiertaId;
    }

    public void setPrespuestaAbiertaId(long prespuestaAbiertaId) {
        this.prespuestaAbiertaId = prespuestaAbiertaId;
    }

    @Basic
    @Column(name = "PREGUNTA")
    public byte[] getPregunta() {
        return pregunta;
    }

    public void setPregunta(byte[] pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrespuestaAbiertaEntity that = (PrespuestaAbiertaEntity) o;

        if (prespuestaAbiertaId != that.prespuestaAbiertaId) return false;
        if (!Arrays.equals(pregunta, that.pregunta)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (prespuestaAbiertaId ^ (prespuestaAbiertaId >>> 32));
        result = 31 * result + Arrays.hashCode(pregunta);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "PRESPUESTA_ABIERTA_ID", referencedColumnName = "PREGUNTA_EX_ID", nullable = false, insertable=false, updatable=false)
    public PreguntaExEntity getPreguntaExByPrespuestaAbiertaId() {
        return preguntaExByPrespuestaAbiertaId;
    }

    public void setPreguntaExByPrespuestaAbiertaId(PreguntaExEntity preguntaExByPrespuestaAbiertaId) {
        this.preguntaExByPrespuestaAbiertaId = preguntaExByPrespuestaAbiertaId;
    }
}
