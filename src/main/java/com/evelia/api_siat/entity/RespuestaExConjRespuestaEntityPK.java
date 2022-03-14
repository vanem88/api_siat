package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RespuestaExConjRespuestaEntityPK implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private long respuestaExId;
    private long fraseId;

    @Column(name = "RESPUESTA_EX_ID")
    @Id
    public long getRespuestaExId() {
        return respuestaExId;
    }

    public void setRespuestaExId(long respuestaExId) {
        this.respuestaExId = respuestaExId;
    }

    @Column(name = "FRASE_ID")
    @Id
    public long getFraseId() {
        return fraseId;
    }

    public void setFraseId(long fraseId) {
        this.fraseId = fraseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RespuestaExConjRespuestaEntityPK that = (RespuestaExConjRespuestaEntityPK) o;

        if (respuestaExId != that.respuestaExId) return false;
        if (fraseId != that.fraseId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (respuestaExId ^ (respuestaExId >>> 32));
        result = 31 * result + (int) (fraseId ^ (fraseId >>> 32));
        return result;
    }
}
