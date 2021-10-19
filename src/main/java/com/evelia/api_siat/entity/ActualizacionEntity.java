package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "ACTUALIZACION", schema = "datosEveliaMinimo", catalog = "")
public class ActualizacionEntity {
    private long actualizacionId;
    private byte[] detalle;
    private String estado;
    private Timestamp fecha;
    private Long id;
    private String nombre;
    private byte[] ubicFisicaArchActualiz;
    private Collection<ModuloEntity> modulosByActualizacionId;

    @Id
    @Column(name = "ACTUALIZACION_ID")
    public long getActualizacionId() {
        return actualizacionId;
    }

    public void setActualizacionId(long actualizacionId) {
        this.actualizacionId = actualizacionId;
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
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "FECHA")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
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
    @Column(name = "UBIC_FISICA_ARCH_ACTUALIZ")
    public byte[] getUbicFisicaArchActualiz() {
        return ubicFisicaArchActualiz;
    }

    public void setUbicFisicaArchActualiz(byte[] ubicFisicaArchActualiz) {
        this.ubicFisicaArchActualiz = ubicFisicaArchActualiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActualizacionEntity that = (ActualizacionEntity) o;

        if (actualizacionId != that.actualizacionId) return false;
        if (!Arrays.equals(detalle, that.detalle)) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (!Arrays.equals(ubicFisicaArchActualiz, that.ubicFisicaArchActualiz)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (actualizacionId ^ (actualizacionId >>> 32));
        result = 31 * result + Arrays.hashCode(detalle);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(ubicFisicaArchActualiz);
        return result;
    }

    @OneToMany(mappedBy = "actualizacionByActualizacionId")
    public Collection<ModuloEntity> getModulosByActualizacionId() {
        return modulosByActualizacionId;
    }

    public void setModulosByActualizacionId(Collection<ModuloEntity> modulosByActualizacionId) {
        this.modulosByActualizacionId = modulosByActualizacionId;
    }
}
