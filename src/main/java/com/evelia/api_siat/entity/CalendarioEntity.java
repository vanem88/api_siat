package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CALENDARIO", schema = "datosEveliaMinimo", catalog = "")
public class CalendarioEntity {
    private long calendarioId;
    private Collection<AulaEntity> aulasByCalendarioId;
    private ComunicacionEntity comunicacionByCalendarioId;

    @Id
    @Column(name = "CALENDARIO_ID")
    public long getCalendarioId() {
        return calendarioId;
    }

    public void setCalendarioId(long calendarioId) {
        this.calendarioId = calendarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalendarioEntity that = (CalendarioEntity) o;

        if (calendarioId != that.calendarioId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (calendarioId ^ (calendarioId >>> 32));
    }

    @OneToMany(mappedBy = "calendarioByCalendarioId")
    public Collection<AulaEntity> getAulasByCalendarioId() {
        return aulasByCalendarioId;
    }

    public void setAulasByCalendarioId(Collection<AulaEntity> aulasByCalendarioId) {
        this.aulasByCalendarioId = aulasByCalendarioId;
    }

    @OneToOne
    @JoinColumn(name = "CALENDARIO_ID", referencedColumnName = "COMUNICACION_ID", nullable = false, insertable=false, updatable=false)
    public ComunicacionEntity getComunicacionByCalendarioId() {
        return comunicacionByCalendarioId;
    }

    public void setComunicacionByCalendarioId(ComunicacionEntity comunicacionByCalendarioId) {
        this.comunicacionByCalendarioId = comunicacionByCalendarioId;
    }
}
