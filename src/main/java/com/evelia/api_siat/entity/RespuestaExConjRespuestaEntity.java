package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "RESPUESTA_EX_CONJ_RESPUESTA", schema = "datosEveliaMinimo", catalog = "")
@IdClass(RespuestaExConjRespuestaEntityPK.class)
public class RespuestaExConjRespuestaEntity {
    private long respuestaExId;
    private long fraseId;
    private RespuestaExEntity respuestaExByRespuestaExId;
    private FraseEntity fraseByFraseId;

    @Id
    @Column(name = "RESPUESTA_EX_ID")
    public long getRespuestaExId() {
        return respuestaExId;
    }

    public void setRespuestaExId(long respuestaExId) {
        this.respuestaExId = respuestaExId;
    }

    @Id
    @Column(name = "FRASE_ID")
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

        RespuestaExConjRespuestaEntity that = (RespuestaExConjRespuestaEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "RESPUESTA_EX_ID", referencedColumnName = "RESPUESTA_EX_ID", nullable = false, insertable=false, updatable=false)
    public RespuestaExEntity getRespuestaExByRespuestaExId() {
        return respuestaExByRespuestaExId;
    }

    public void setRespuestaExByRespuestaExId(RespuestaExEntity respuestaExByRespuestaExId) {
        this.respuestaExByRespuestaExId = respuestaExByRespuestaExId;
    }

    @ManyToOne
    @JoinColumn(name = "FRASE_ID", referencedColumnName = "FRASE_ID", nullable = false, insertable=false, updatable=false)
    public FraseEntity getFraseByFraseId() {
        return fraseByFraseId;
    }

    public void setFraseByFraseId(FraseEntity fraseByFraseId) {
        this.fraseByFraseId = fraseByFraseId;
    }
}
