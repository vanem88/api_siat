package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "VALOR_CALIFICACION", schema = "datosEveliaMinimo", catalog = "")
public class ValorCalificacionEntity {
    private long valorCalificacionId;
    private Long id;
    private String nombre;
    private Integer orden;
    private Long tipoCalificacionId;
    private Long tipoCalificacionEncuestasId;
    private Collection<CalificacionActividadEntity> calificacionActividadsByValorCalificacionId;
    private Collection<NotaAprobarActividadEntity> notaAprobarActividadsByValorCalificacionId;
    private Collection<NotaAprobarActividadNotasCualitativasEntity> notaAprobarActividadNotasCualitativasByValorCalificacionId;
    private Collection<RespuestaPreguntaSiatEntity> respuestaPreguntaSiatsByValorCalificacionId;
    private TipoCalificacionEntity tipoCalificacionByTipoCalificacionId;
    private TipoCalificacionEncuestasEntity tipoCalificacionEncuestasByTipoCalificacionEncuestasId;

    @Id
    @Column(name = "VALOR_CALIFICACION_ID")
    public long getValorCalificacionId() {
        return valorCalificacionId;
    }

    public void setValorCalificacionId(long valorCalificacionId) {
        this.valorCalificacionId = valorCalificacionId;
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
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "ORDEN")
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
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

        ValorCalificacionEntity that = (ValorCalificacionEntity) o;

        if (valorCalificacionId != that.valorCalificacionId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (orden != null ? !orden.equals(that.orden) : that.orden != null) return false;
        if (tipoCalificacionId != null ? !tipoCalificacionId.equals(that.tipoCalificacionId) : that.tipoCalificacionId != null)
            return false;
        if (tipoCalificacionEncuestasId != null ? !tipoCalificacionEncuestasId.equals(that.tipoCalificacionEncuestasId) : that.tipoCalificacionEncuestasId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (valorCalificacionId ^ (valorCalificacionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (orden != null ? orden.hashCode() : 0);
        result = 31 * result + (tipoCalificacionId != null ? tipoCalificacionId.hashCode() : 0);
        result = 31 * result + (tipoCalificacionEncuestasId != null ? tipoCalificacionEncuestasId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "valorCalificacionByValorCalificacionId")
    public Collection<CalificacionActividadEntity> getCalificacionActividadsByValorCalificacionId() {
        return calificacionActividadsByValorCalificacionId;
    }

    public void setCalificacionActividadsByValorCalificacionId(Collection<CalificacionActividadEntity> calificacionActividadsByValorCalificacionId) {
        this.calificacionActividadsByValorCalificacionId = calificacionActividadsByValorCalificacionId;
    }

    @OneToMany(mappedBy = "valorCalificacionByNotaNumericaId")
    public Collection<NotaAprobarActividadEntity> getNotaAprobarActividadsByValorCalificacionId() {
        return notaAprobarActividadsByValorCalificacionId;
    }

    public void setNotaAprobarActividadsByValorCalificacionId(Collection<NotaAprobarActividadEntity> notaAprobarActividadsByValorCalificacionId) {
        this.notaAprobarActividadsByValorCalificacionId = notaAprobarActividadsByValorCalificacionId;
    }

    @OneToMany(mappedBy = "valorCalificacionByValorCalificacionId")
    public Collection<NotaAprobarActividadNotasCualitativasEntity> getNotaAprobarActividadNotasCualitativasByValorCalificacionId() {
        return notaAprobarActividadNotasCualitativasByValorCalificacionId;
    }

    public void setNotaAprobarActividadNotasCualitativasByValorCalificacionId(Collection<NotaAprobarActividadNotasCualitativasEntity> notaAprobarActividadNotasCualitativasByValorCalificacionId) {
        this.notaAprobarActividadNotasCualitativasByValorCalificacionId = notaAprobarActividadNotasCualitativasByValorCalificacionId;
    }

    @OneToMany(mappedBy = "valorCalificacionByValorCalificacionId")
    public Collection<RespuestaPreguntaSiatEntity> getRespuestaPreguntaSiatsByValorCalificacionId() {
        return respuestaPreguntaSiatsByValorCalificacionId;
    }

    public void setRespuestaPreguntaSiatsByValorCalificacionId(Collection<RespuestaPreguntaSiatEntity> respuestaPreguntaSiatsByValorCalificacionId) {
        this.respuestaPreguntaSiatsByValorCalificacionId = respuestaPreguntaSiatsByValorCalificacionId;
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
}
