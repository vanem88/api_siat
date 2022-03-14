package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PreguntaExPuntuacionEntityPK implements Serializable {
  
	private static final long serialVersionUID = 1L;
	private long preguntaExId;
    private long puntuacionId;

    @Column(name = "PREGUNTA_EX_ID")
    @Id
    public long getPreguntaExId() {
        return preguntaExId;
    }

    public void setPreguntaExId(long preguntaExId) {
        this.preguntaExId = preguntaExId;
    }

    @Column(name = "PUNTUACION_ID")
    @Id
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

        PreguntaExPuntuacionEntityPK that = (PreguntaExPuntuacionEntityPK) o;

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
}
