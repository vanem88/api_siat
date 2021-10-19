package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "MATERIAL_ADICIONAL", schema = "datosEveliaMinimo", catalog = "")
public class MaterialAdicionalEntity {
    private long materialAdicionalId;
    private Collection<AulaEntity> aulasByMaterialAdicionalId;
    private CarpetaEntity carpetaByMaterialAdicionalId;

    @Id
    @Column(name = "MATERIAL_ADICIONAL_ID")
    public long getMaterialAdicionalId() {
        return materialAdicionalId;
    }

    public void setMaterialAdicionalId(long materialAdicionalId) {
        this.materialAdicionalId = materialAdicionalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialAdicionalEntity that = (MaterialAdicionalEntity) o;

        if (materialAdicionalId != that.materialAdicionalId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (materialAdicionalId ^ (materialAdicionalId >>> 32));
    }

    @OneToMany(mappedBy = "materialAdicionalByMaterialAdicionalId")
    public Collection<AulaEntity> getAulasByMaterialAdicionalId() {
        return aulasByMaterialAdicionalId;
    }

    public void setAulasByMaterialAdicionalId(Collection<AulaEntity> aulasByMaterialAdicionalId) {
        this.aulasByMaterialAdicionalId = aulasByMaterialAdicionalId;
    }

    @OneToOne
    @JoinColumn(name = "MATERIAL_ADICIONAL_ID", referencedColumnName = "CARPETA_ID", nullable = false)
    public CarpetaEntity getCarpetaByMaterialAdicionalId() {
        return carpetaByMaterialAdicionalId;
    }

    public void setCarpetaByMaterialAdicionalId(CarpetaEntity carpetaByMaterialAdicionalId) {
        this.carpetaByMaterialAdicionalId = carpetaByMaterialAdicionalId;
    }
}
