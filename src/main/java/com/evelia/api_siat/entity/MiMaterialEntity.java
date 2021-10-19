package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "MI_MATERIAL", schema = "datosEveliaMinimo", catalog = "")
public class MiMaterialEntity {
    private long miMaterialId;
    private CarpetaEntity carpetaByMiMaterialId;
    private Collection<PersonaEntity> personasByMiMaterialId;

    @Id
    @Column(name = "MI_MATERIAL_ID")
    public long getMiMaterialId() {
        return miMaterialId;
    }

    public void setMiMaterialId(long miMaterialId) {
        this.miMaterialId = miMaterialId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiMaterialEntity that = (MiMaterialEntity) o;

        if (miMaterialId != that.miMaterialId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (miMaterialId ^ (miMaterialId >>> 32));
    }

    @OneToOne
    @JoinColumn(name = "MI_MATERIAL_ID", referencedColumnName = "CARPETA_ID", nullable = false, insertable=false, updatable=false)
    public CarpetaEntity getCarpetaByMiMaterialId() {
        return carpetaByMiMaterialId;
    }

    public void setCarpetaByMiMaterialId(CarpetaEntity carpetaByMiMaterialId) {
        this.carpetaByMiMaterialId = carpetaByMiMaterialId;
    }

    @OneToMany(mappedBy = "miMaterialByCarpetaPersonalId")
    public Collection<PersonaEntity> getPersonasByMiMaterialId() {
        return personasByMiMaterialId;
    }

    public void setPersonasByMiMaterialId(Collection<PersonaEntity> personasByMiMaterialId) {
        this.personasByMiMaterialId = personasByMiMaterialId;
    }
}
