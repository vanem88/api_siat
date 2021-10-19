package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "NOTA_APROBAR_ACTIVIDAD", schema = "datosEveliaMinimo", catalog = "")
public class NotaAprobarActividadEntity {
    private long notaAprobarActividadId;
    private String tipoNota;
    private Long id;
    private Long notaNumericaId;
    private Collection<ActividadEntity> actividadsByNotaAprobarActividadId;
    private ValorCalificacionEntity valorCalificacionByNotaNumericaId;
    private Collection<NotaAprobarActividadNotasCualitativasEntity> notaAprobarActividadNotasCualitativasByNotaAprobarActividadId;

    @Id
    @Column(name = "NOTA_APROBAR_ACTIVIDAD_ID")
    public long getNotaAprobarActividadId() {
        return notaAprobarActividadId;
    }

    public void setNotaAprobarActividadId(long notaAprobarActividadId) {
        this.notaAprobarActividadId = notaAprobarActividadId;
    }

    @Basic
    @Column(name = "TIPO_NOTA")
    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
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
    @Column(name = "NOTA_NUMERICA_ID")
    public Long getNotaNumericaId() {
        return notaNumericaId;
    }

    public void setNotaNumericaId(Long notaNumericaId) {
        this.notaNumericaId = notaNumericaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaAprobarActividadEntity that = (NotaAprobarActividadEntity) o;

        if (notaAprobarActividadId != that.notaAprobarActividadId) return false;
        if (tipoNota != null ? !tipoNota.equals(that.tipoNota) : that.tipoNota != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (notaNumericaId != null ? !notaNumericaId.equals(that.notaNumericaId) : that.notaNumericaId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (notaAprobarActividadId ^ (notaAprobarActividadId >>> 32));
        result = 31 * result + (tipoNota != null ? tipoNota.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (notaNumericaId != null ? notaNumericaId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "notaAprobarActividadByNotaAprobarId")
    public Collection<ActividadEntity> getActividadsByNotaAprobarActividadId() {
        return actividadsByNotaAprobarActividadId;
    }

    public void setActividadsByNotaAprobarActividadId(Collection<ActividadEntity> actividadsByNotaAprobarActividadId) {
        this.actividadsByNotaAprobarActividadId = actividadsByNotaAprobarActividadId;
    }

    @ManyToOne
    @JoinColumn(name = "NOTA_NUMERICA_ID", referencedColumnName = "VALOR_CALIFICACION_ID", insertable=false, updatable=false)
    public ValorCalificacionEntity getValorCalificacionByNotaNumericaId() {
        return valorCalificacionByNotaNumericaId;
    }

    public void setValorCalificacionByNotaNumericaId(ValorCalificacionEntity valorCalificacionByNotaNumericaId) {
        this.valorCalificacionByNotaNumericaId = valorCalificacionByNotaNumericaId;
    }

    @OneToMany(mappedBy = "notaAprobarActividadByNotaAprobarActividadId")
    public Collection<NotaAprobarActividadNotasCualitativasEntity> getNotaAprobarActividadNotasCualitativasByNotaAprobarActividadId() {
        return notaAprobarActividadNotasCualitativasByNotaAprobarActividadId;
    }

    public void setNotaAprobarActividadNotasCualitativasByNotaAprobarActividadId(Collection<NotaAprobarActividadNotasCualitativasEntity> notaAprobarActividadNotasCualitativasByNotaAprobarActividadId) {
        this.notaAprobarActividadNotasCualitativasByNotaAprobarActividadId = notaAprobarActividadNotasCualitativasByNotaAprobarActividadId;
    }
}
