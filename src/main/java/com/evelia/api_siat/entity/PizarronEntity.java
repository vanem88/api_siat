package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PIZARRON", schema = "datosEveliaMinimo", catalog = "")
public class PizarronEntity {
    private long pizarronId;
    private Collection<AulaEntity> aulasByPizarronId;
    private ComunicacionEntity comunicacionByPizarronId;

    @Id
    @Column(name = "PIZARRON_ID")
    public long getPizarronId() {
        return pizarronId;
    }

    public void setPizarronId(long pizarronId) {
        this.pizarronId = pizarronId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PizarronEntity that = (PizarronEntity) o;

        if (pizarronId != that.pizarronId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (pizarronId ^ (pizarronId >>> 32));
    }

    @OneToMany(mappedBy = "pizarronByPizarronId")
    public Collection<AulaEntity> getAulasByPizarronId() {
        return aulasByPizarronId;
    }

    public void setAulasByPizarronId(Collection<AulaEntity> aulasByPizarronId) {
        this.aulasByPizarronId = aulasByPizarronId;
    }

    @OneToOne
    @JoinColumn(name = "PIZARRON_ID", referencedColumnName = "COMUNICACION_ID", nullable = false, insertable=false, updatable=false)
    public ComunicacionEntity getComunicacionByPizarronId() {
        return comunicacionByPizarronId;
    }

    public void setComunicacionByPizarronId(ComunicacionEntity comunicacionByPizarronId) {
        this.comunicacionByPizarronId = comunicacionByPizarronId;
    }
}
