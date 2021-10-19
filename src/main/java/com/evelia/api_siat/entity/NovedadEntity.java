package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "NOVEDAD", schema = "datosEveliaMinimo", catalog = "")
public class NovedadEntity {
    private long novedadId;
    private Collection<AulaEntity> aulasByNovedadId;
    private ComunicacionEntity comunicacionByNovedadId;

    @Id
    @Column(name = "NOVEDAD_ID")
    public long getNovedadId() {
        return novedadId;
    }

    public void setNovedadId(long novedadId) {
        this.novedadId = novedadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NovedadEntity that = (NovedadEntity) o;

        if (novedadId != that.novedadId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (novedadId ^ (novedadId >>> 32));
    }

    @OneToMany(mappedBy = "novedadByNovedadId")
    public Collection<AulaEntity> getAulasByNovedadId() {
        return aulasByNovedadId;
    }

    public void setAulasByNovedadId(Collection<AulaEntity> aulasByNovedadId) {
        this.aulasByNovedadId = aulasByNovedadId;
    }

    @OneToOne
    @JoinColumn(name = "NOVEDAD_ID", referencedColumnName = "COMUNICACION_ID", nullable = false, insertable=false, updatable=false)
    public ComunicacionEntity getComunicacionByNovedadId() {
        return comunicacionByNovedadId;
    }

    public void setComunicacionByNovedadId(ComunicacionEntity comunicacionByNovedadId) {
        this.comunicacionByNovedadId = comunicacionByNovedadId;
    }
}
