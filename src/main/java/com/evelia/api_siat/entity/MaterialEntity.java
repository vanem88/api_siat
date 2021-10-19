package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "MATERIAL", schema = "datosEveliaMinimo", catalog = "")
public class MaterialEntity {
    private long materialId;
    private Collection<AulaEntity> aulasByMaterialId;
    private CarpetaEntity carpetaByMaterialId;

    @Id
    @Column(name = "MATERIAL_ID")
    public long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(long materialId) {
        this.materialId = materialId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialEntity that = (MaterialEntity) o;

        if (materialId != that.materialId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (materialId ^ (materialId >>> 32));
    }

    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<AulaEntity> getAulasByMaterialId() {
        return aulasByMaterialId;
    }

    public void setAulasByMaterialId(Collection<AulaEntity> aulasByMaterialId) {
        this.aulasByMaterialId = aulasByMaterialId;
    }

    @OneToOne
    @JoinColumn(name = "MATERIAL_ID", referencedColumnName = "CARPETA_ID", nullable = false, insertable=false, updatable=false)
    public CarpetaEntity getCarpetaByMaterialId() {
        return carpetaByMaterialId;
    }

    public void setCarpetaByMaterialId(CarpetaEntity carpetaByMaterialId) {
        this.carpetaByMaterialId = carpetaByMaterialId;
    }
}
