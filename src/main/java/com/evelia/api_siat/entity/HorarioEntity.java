package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "HORARIO", schema = "datosEveliaMinimo", catalog = "")
public class HorarioEntity {
    private long horarioId;
    private String tipo;
    private String descripcion;
    private Long id;
    private String responsable;
    private String dia;
    private String horario;
    private String aulaPab;
    private Long aulaCompuestaId;
    private Integer orden;
    private AulaCompuestaEntity aulaCompuestaByAulaCompuestaId;

    @Id
    @Column(name = "HORARIO_ID")
    public long getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(long horarioId) {
        this.horarioId = horarioId;
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
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    @Column(name = "RESPONSABLE")
    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @Basic
    @Column(name = "DIA")
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Basic
    @Column(name = "HORARIO")
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Basic
    @Column(name = "AULA_PAB")
    public String getAulaPab() {
        return aulaPab;
    }

    public void setAulaPab(String aulaPab) {
        this.aulaPab = aulaPab;
    }

    @Basic
    @Column(name = "AULA_COMPUESTA_ID")
    public Long getAulaCompuestaId() {
        return aulaCompuestaId;
    }

    public void setAulaCompuestaId(Long aulaCompuestaId) {
        this.aulaCompuestaId = aulaCompuestaId;
    }

    @Basic
    @Column(name = "ORDEN")
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HorarioEntity that = (HorarioEntity) o;

        if (horarioId != that.horarioId) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (responsable != null ? !responsable.equals(that.responsable) : that.responsable != null) return false;
        if (dia != null ? !dia.equals(that.dia) : that.dia != null) return false;
        if (horario != null ? !horario.equals(that.horario) : that.horario != null) return false;
        if (aulaPab != null ? !aulaPab.equals(that.aulaPab) : that.aulaPab != null) return false;
        if (aulaCompuestaId != null ? !aulaCompuestaId.equals(that.aulaCompuestaId) : that.aulaCompuestaId != null)
            return false;
        if (orden != null ? !orden.equals(that.orden) : that.orden != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (horarioId ^ (horarioId >>> 32));
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (responsable != null ? responsable.hashCode() : 0);
        result = 31 * result + (dia != null ? dia.hashCode() : 0);
        result = 31 * result + (horario != null ? horario.hashCode() : 0);
        result = 31 * result + (aulaPab != null ? aulaPab.hashCode() : 0);
        result = 31 * result + (aulaCompuestaId != null ? aulaCompuestaId.hashCode() : 0);
        result = 31 * result + (orden != null ? orden.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "AULA_COMPUESTA_ID", referencedColumnName = "AULA_COMPUESTA_ID", insertable=false, updatable=false)
    public AulaCompuestaEntity getAulaCompuestaByAulaCompuestaId() {
        return aulaCompuestaByAulaCompuestaId;
    }

    public void setAulaCompuestaByAulaCompuestaId(AulaCompuestaEntity aulaCompuestaByAulaCompuestaId) {
        this.aulaCompuestaByAulaCompuestaId = aulaCompuestaByAulaCompuestaId;
    }
}
