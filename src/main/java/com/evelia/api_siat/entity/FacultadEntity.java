package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "FACULTAD", schema = "datosEveliaMinimo", catalog = "")
public class FacultadEntity {
    private long facultadId;
    private AulaCompuestaEntity aulaCompuestaByFacultadId;

    @Id
    @Column(name = "FACULTAD_ID")
    public long getFacultadId() {
        return facultadId;
    }

    public void setFacultadId(long facultadId) {
        this.facultadId = facultadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacultadEntity that = (FacultadEntity) o;

        if (facultadId != that.facultadId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (facultadId ^ (facultadId >>> 32));
    }

    @OneToOne
    @JoinColumn(name = "FACULTAD_ID", referencedColumnName = "AULA_COMPUESTA_ID", nullable = false, insertable=false, updatable=false)
    public AulaCompuestaEntity getAulaCompuestaByFacultadId() {
        return aulaCompuestaByFacultadId;
    }

    public void setAulaCompuestaByFacultadId(AulaCompuestaEntity aulaCompuestaByFacultadId) {
        this.aulaCompuestaByFacultadId = aulaCompuestaByFacultadId;
    }
}
