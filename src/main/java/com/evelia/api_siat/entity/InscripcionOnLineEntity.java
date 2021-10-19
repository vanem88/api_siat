package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "INSCRIPCION_ON_LINE", schema = "datosEveliaMinimo", catalog = "")
public class InscripcionOnLineEntity {
    private long inscripcionOnLineId;
    private String codigo;
    private byte[] descripcion;
    private String estado;
    private Timestamp fechaFin;
    private Timestamp fechaInicio;
    private Long id;
    private Collection<AulaCompuestaEntity> aulaCompuestasByInscripcionOnLineId;

    @Id
    @Column(name = "INSCRIPCION_ON_LINE_ID")
    public long getInscripcionOnLineId() {
        return inscripcionOnLineId;
    }

    public void setInscripcionOnLineId(long inscripcionOnLineId) {
        this.inscripcionOnLineId = inscripcionOnLineId;
    }

    @Basic
    @Column(name = "CODIGO")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public byte[] getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(byte[] descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "FECHA_FIN")
    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Basic
    @Column(name = "FECHA_INICIO")
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscripcionOnLineEntity that = (InscripcionOnLineEntity) o;

        if (inscripcionOnLineId != that.inscripcionOnLineId) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (!Arrays.equals(descripcion, that.descripcion)) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (inscripcionOnLineId ^ (inscripcionOnLineId >>> 32));
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(descripcion);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "inscripcionOnLineByInscripcionOnlineId")
    public Collection<AulaCompuestaEntity> getAulaCompuestasByInscripcionOnLineId() {
        return aulaCompuestasByInscripcionOnLineId;
    }

    public void setAulaCompuestasByInscripcionOnLineId(Collection<AulaCompuestaEntity> aulaCompuestasByInscripcionOnLineId) {
        this.aulaCompuestasByInscripcionOnLineId = aulaCompuestasByInscripcionOnLineId;
    }
}
