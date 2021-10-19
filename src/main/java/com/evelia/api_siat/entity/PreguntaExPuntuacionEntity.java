package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "PREGUNTA_EX_PUNTUACION", schema = "datosEveliaMinimo", catalog = "")
@IdClass(PreguntaExPuntuacionEntityPK.class)
public class PreguntaExPuntuacionEntity {
    private long preguntaExId;
    private long puntuacionId;
    private PreguntaExEntity preguntaExByPreguntaExId;
    private PuntuacionEntity puntuacionByPuntuacionId;

    @Id
    @Column(name = "PREGUNTA_EX_ID")
    public long getPreguntaExId() {
        return preguntaExId;
    }

    public void setPreguntaExId(long preguntaExId) {
        this.preguntaExId = preguntaExId;
    }

    @Id
    @Column(name = "PUNTUACION_ID")
    public long getPuntuacionId() {
        return puntuacionId;
    }

    public void setPuntuacionId(long puntuacionId) {
        this.puntuacionId = puntuacionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreguntaExPuntuacionEntity that = (PreguntaExPuntuacionEntity) o;

        if (preguntaExId != that.preguntaExId) return false;
        if (puntuacionId != that.puntuacionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (preguntaExId ^ (preguntaExId >>> 32));
        result = 31 * result + (int) (puntuacionId ^ (puntuacionId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PREGUNTA_EX_ID", referencedColumnName = "PREGUNTA_EX_ID", nullable = false, insertable=false, updatable=false)
    public PreguntaExEntity getPreguntaExByPreguntaExId() {
        return preguntaExByPreguntaExId;
    }

    public void setPreguntaExByPreguntaExId(PreguntaExEntity preguntaExByPreguntaExId) {
        this.preguntaExByPreguntaExId = preguntaExByPreguntaExId;
    }

    @ManyToOne
    @JoinColumn(name = "PUNTUACION_ID", referencedColumnName = "PUNTUACION_ID", nullable = false, insertable=false, updatable=false)
    public PuntuacionEntity getPuntuacionByPuntuacionId() {
        return puntuacionByPuntuacionId;
    }

    public void setPuntuacionByPuntuacionId(PuntuacionEntity puntuacionByPuntuacionId) {
        this.puntuacionByPuntuacionId = puntuacionByPuntuacionId;
    }
}
