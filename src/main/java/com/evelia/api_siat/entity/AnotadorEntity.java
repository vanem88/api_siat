package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ANOTADOR", schema = "datosEveliaMinimo", catalog = "")
public class AnotadorEntity {
    private long anotadorId;
    private ComunicacionEntity comunicacionByAnotadorId;
    private Collection<GrupoEntity> gruposByAnotadorId;

    @Id
    @Column(name = "ANOTADOR_ID")
    public long getAnotadorId() {
        return anotadorId;
    }

    public void setAnotadorId(long anotadorId) {
        this.anotadorId = anotadorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnotadorEntity that = (AnotadorEntity) o;

        if (anotadorId != that.anotadorId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (anotadorId ^ (anotadorId >>> 32));
    }

    @OneToOne
    @JoinColumn(name = "ANOTADOR_ID", referencedColumnName = "COMUNICACION_ID", nullable = false, insertable=false, updatable=false)
    public ComunicacionEntity getComunicacionByAnotadorId() {
        return comunicacionByAnotadorId;
    }

    public void setComunicacionByAnotadorId(ComunicacionEntity comunicacionByAnotadorId) {
        this.comunicacionByAnotadorId = comunicacionByAnotadorId;
    }

    @OneToMany(mappedBy = "anotadorByAnotadorId")
    public Collection<GrupoEntity> getGruposByAnotadorId() {
        return gruposByAnotadorId;
    }

    public void setGruposByAnotadorId(Collection<GrupoEntity> gruposByAnotadorId) {
        this.gruposByAnotadorId = gruposByAnotadorId;
    }
}
