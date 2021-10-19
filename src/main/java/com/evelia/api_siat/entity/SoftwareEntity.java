package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "SOFTWARE", schema = "datosEveliaMinimo", catalog = "")
public class SoftwareEntity {
    private long softwareId;
    private Collection<AulaEntity> aulasBySoftwareId;
    private CarpetaEntity carpetaBySoftwareId;

    @Id
    @Column(name = "SOFTWARE_ID")
    public long getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(long softwareId) {
        this.softwareId = softwareId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoftwareEntity that = (SoftwareEntity) o;

        if (softwareId != that.softwareId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (softwareId ^ (softwareId >>> 32));
    }

    @OneToMany(mappedBy = "softwareBySoftwareId")
    public Collection<AulaEntity> getAulasBySoftwareId() {
        return aulasBySoftwareId;
    }

    public void setAulasBySoftwareId(Collection<AulaEntity> aulasBySoftwareId) {
        this.aulasBySoftwareId = aulasBySoftwareId;
    }

    @OneToOne
    @JoinColumn(name = "SOFTWARE_ID", referencedColumnName = "CARPETA_ID", nullable = false, insertable=false, updatable=false)
    public CarpetaEntity getCarpetaBySoftwareId() {
        return carpetaBySoftwareId;
    }

    public void setCarpetaBySoftwareId(CarpetaEntity carpetaBySoftwareId) {
        this.carpetaBySoftwareId = carpetaBySoftwareId;
    }
}
