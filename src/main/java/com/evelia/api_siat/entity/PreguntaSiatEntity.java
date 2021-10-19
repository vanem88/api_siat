package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "PREGUNTA_SIAT", schema = "datosEveliaMinimo", catalog = "")
public class PreguntaSiatEntity {
    private long preguntaSiatId;
    private byte[] detalle;
    private Long encuestaSiatId;
    private Long id;
    private int orden;
    private String tipo;
    private Long tipoCalificacionId;
    private Long tipoCalificacionEncuestasId;
    private EncuestaSiatEntity encuestaSiatByEncuestaSiatId;
    private TipoCalificacionEntity tipoCalificacionByTipoCalificacionId;
    private TipoCalificacionEncuestasEntity tipoCalificacionEncuestasByTipoCalificacionEncuestasId;
    private Collection<RespuestaPreguntaSiatEntity> respuestaPreguntaSiatsByPreguntaSiatId;

    @Id
    @Column(name = "PREGUNTA_SIAT_ID")
    public long getPreguntaSiatId() {
        return preguntaSiatId;
    }

    public void setPreguntaSiatId(long preguntaSiatId) {
        this.preguntaSiatId = preguntaSiatId;
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
    @Column(name = "ENCUESTA_SIAT_ID")
    public Long getEncuestaSiatId() {
        return encuestaSiatId;
    }

    public void setEncuestaSiatId(Long encuestaSiatId) {
        this.encuestaSiatId = encuestaSiatId;
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

    @Basic
    @Column(name = "TIPO")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "TIPO_CALIFICACION_ID")
    public Long getTipoCalificacionId() {
        return tipoCalificacionId;
    }

    public void setTipoCalificacionId(Long tipoCalificacionId) {
        this.tipoCalificacionId = tipoCalificacionId;
    }

    @Basic
    @Column(name = "TIPO_CALIFICACION_ENCUESTAS_ID")
    public Long getTipoCalificacionEncuestasId() {
        return tipoCalificacionEncuestasId;
    }

    public void setTipoCalificacionEncuestasId(Long tipoCalificacionEncuestasId) {
        this.tipoCalificacionEncuestasId = tipoCalificacionEncuestasId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreguntaSiatEntity that = (PreguntaSiatEntity) o;

        if (preguntaSiatId != that.preguntaSiatId) return false;
        if (orden != that.orden) return false;
        if (!Arrays.equals(detalle, that.detalle)) return false;
        if (encuestaSiatId != null ? !encuestaSiatId.equals(that.encuestaSiatId) : that.encuestaSiatId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (tipoCalificacionId != null ? !tipoCalificacionId.equals(that.tipoCalificacionId) : that.tipoCalificacionId != null)
            return false;
        if (tipoCalificacionEncuestasId != null ? !tipoCalificacionEncuestasId.equals(that.tipoCalificacionEncuestasId) : that.tipoCalificacionEncuestasId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (preguntaSiatId ^ (preguntaSiatId >>> 32));
        result = 31 * result + Arrays.hashCode(detalle);
        result = 31 * result + (encuestaSiatId != null ? encuestaSiatId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + orden;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (tipoCalificacionId != null ? tipoCalificacionId.hashCode() : 0);
        result = 31 * result + (tipoCalificacionEncuestasId != null ? tipoCalificacionEncuestasId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ENCUESTA_SIAT_ID", referencedColumnName = "ENCUESTA_SIAT_ID", insertable=false, updatable=false)
    public EncuestaSiatEntity getEncuestaSiatByEncuestaSiatId() {
        return encuestaSiatByEncuestaSiatId;
    }

    public void setEncuestaSiatByEncuestaSiatId(EncuestaSiatEntity encuestaSiatByEncuestaSiatId) {
        this.encuestaSiatByEncuestaSiatId = encuestaSiatByEncuestaSiatId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_CALIFICACION_ID", referencedColumnName = "TIPO_CALIFICACION_ID", insertable=false, updatable=false)
    public TipoCalificacionEntity getTipoCalificacionByTipoCalificacionId() {
        return tipoCalificacionByTipoCalificacionId;
    }

    public void setTipoCalificacionByTipoCalificacionId(TipoCalificacionEntity tipoCalificacionByTipoCalificacionId) {
        this.tipoCalificacionByTipoCalificacionId = tipoCalificacionByTipoCalificacionId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_CALIFICACION_ENCUESTAS_ID", referencedColumnName = "TIPO_CALIFICACION_ENCUESTAS_ID", insertable=false, updatable=false)
    public TipoCalificacionEncuestasEntity getTipoCalificacionEncuestasByTipoCalificacionEncuestasId() {
        return tipoCalificacionEncuestasByTipoCalificacionEncuestasId;
    }

    public void setTipoCalificacionEncuestasByTipoCalificacionEncuestasId(TipoCalificacionEncuestasEntity tipoCalificacionEncuestasByTipoCalificacionEncuestasId) {
        this.tipoCalificacionEncuestasByTipoCalificacionEncuestasId = tipoCalificacionEncuestasByTipoCalificacionEncuestasId;
    }

    @OneToMany(mappedBy = "preguntaSiatByPreguntaSiatId")
    public Collection<RespuestaPreguntaSiatEntity> getRespuestaPreguntaSiatsByPreguntaSiatId() {
        return respuestaPreguntaSiatsByPreguntaSiatId;
    }

    public void setRespuestaPreguntaSiatsByPreguntaSiatId(Collection<RespuestaPreguntaSiatEntity> respuestaPreguntaSiatsByPreguntaSiatId) {
        this.respuestaPreguntaSiatsByPreguntaSiatId = respuestaPreguntaSiatsByPreguntaSiatId;
    }
}
