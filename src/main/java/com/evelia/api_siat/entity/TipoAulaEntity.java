package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TIPO_AULA", schema = "datosEveliaMinimo", catalog = "")
public class TipoAulaEntity {
    private long tipoAulaId;
    private Long id;
    private String nombre;
    private Collection<AulaEntity> aulasByTipoAulaId;
    private Collection<TipoUsuarioEnNivelEntity> tipoUsuarioEnNivelsByTipoAulaId;

    @Id
    @Column(name = "TIPO_AULA_ID")
    public long getTipoAulaId() {
        return tipoAulaId;
    }

    public void setTipoAulaId(long tipoAulaId) {
        this.tipoAulaId = tipoAulaId;
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

        TipoAulaEntity that = (TipoAulaEntity) o;

        if (tipoAulaId != that.tipoAulaId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoAulaId ^ (tipoAulaId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tipoAulaByTipoAulaId")
    public Collection<AulaEntity> getAulasByTipoAulaId() {
        return aulasByTipoAulaId;
    }

    public void setAulasByTipoAulaId(Collection<AulaEntity> aulasByTipoAulaId) {
        this.aulasByTipoAulaId = aulasByTipoAulaId;
    }

    @OneToMany(mappedBy = "tipoAulaByTipoAulaId")
    public Collection<TipoUsuarioEnNivelEntity> getTipoUsuarioEnNivelsByTipoAulaId() {
        return tipoUsuarioEnNivelsByTipoAulaId;
    }

    public void setTipoUsuarioEnNivelsByTipoAulaId(Collection<TipoUsuarioEnNivelEntity> tipoUsuarioEnNivelsByTipoAulaId) {
        this.tipoUsuarioEnNivelsByTipoAulaId = tipoUsuarioEnNivelsByTipoAulaId;
    }
}
