package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "RESPUESTA_EX_ORDEN_OPCION", schema = "datosEveliaMinimo", catalog = "")
public class RespuestaExOrdenOpcionEntity {
    private long respuestaExOrdenOpcionId;
    private long respuestaExId;
    private long fraseId;
    private Long id;
    private int orden;
    private RespuestaExEntity respuestaExByRespuestaExId;
    private FraseEntity fraseByFraseId;

    @Id
    @Column(name = "RESPUESTA_EX_ORDEN_OPCION_ID")
    public long getRespuestaExOrdenOpcionId() {
        return respuestaExOrdenOpcionId;
    }

    public void setRespuestaExOrdenOpcionId(long respuestaExOrdenOpcionId) {
        this.respuestaExOrdenOpcionId = respuestaExOrdenOpcionId;
    }

    @Basic
    @Column(name = "RESPUESTA_EX_ID")
    public long getRespuestaExId() {
        return respuestaExId;
    }

    public void setRespuestaExId(long respuestaExId) {
        this.respuestaExId = respuestaExId;
    }

    @Basic
    @Column(name = "FRASE_ID")
    public long getFraseId() {
        return fraseId;
    }

    public void setFraseId(long fraseId) {
        this.fraseId = fraseId;
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
    @Column(name = "ORDEN")
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RespuestaExOrdenOpcionEntity that = (RespuestaExOrdenOpcionEntity) o;

        if (respuestaExOrdenOpcionId != that.respuestaExOrdenOpcionId) return false;
        if (respuestaExId != that.respuestaExId) return false;
        if (fraseId != that.fraseId) return false;
        if (orden != that.orden) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (respuestaExOrdenOpcionId ^ (respuestaExOrdenOpcionId >>> 32));
        result = 31 * result + (int) (respuestaExId ^ (respuestaExId >>> 32));
        result = 31 * result + (int) (fraseId ^ (fraseId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + orden;
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
