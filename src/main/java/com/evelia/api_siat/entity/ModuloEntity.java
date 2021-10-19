package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "MODULO", schema = "datosEveliaMinimo", catalog = "")
public class ModuloEntity {
    private long moduloId;
    private Long actualizacionId;
    private Long id;
    private String nombre;
    private Collection<LogEntity> logsByModuloId;
    private ActualizacionEntity actualizacionByActualizacionId;

    @Id
    @Column(name = "MODULO_ID")
    public long getModuloId() {
        return moduloId;
    }

    public void setModuloId(long moduloId) {
        this.moduloId = moduloId;
    }

    @Basic
    @Column(name = "ACTUALIZACION_ID")
    public Long getActualizacionId() {
        return actualizacionId;
    }

    public void setActualizacionId(Long actualizacionId) {
        this.actualizacionId = actualizacionId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuloEntity that = (ModuloEntity) o;

        if (moduloId != that.moduloId) return false;
        if (actualizacionId != null ? !actualizacionId.equals(that.actualizacionId) : that.actualizacionId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (moduloId ^ (moduloId >>> 32));
        result = 31 * result + (actualizacionId != null ? actualizacionId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "moduloByModuloId")
    public Collection<LogEntity> getLogsByModuloId() {
        return logsByModuloId;
    }

    public void setLogsByModuloId(Collection<LogEntity> logsByModuloId) {
        this.logsByModuloId = logsByModuloId;
    }

    @ManyToOne
    @JoinColumn(name = "ACTUALIZACION_ID", referencedColumnName = "ACTUALIZACION_ID", insertable=false, updatable=false)
    public ActualizacionEntity getActualizacionByActualizacionId() {
        return actualizacionByActualizacionId;
    }

    public void setActualizacionByActualizacionId(ActualizacionEntity actualizacionByActualizacionId) {
        this.actualizacionByActualizacionId = actualizacionByActualizacionId;
    }
}
