package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "RECURSO_MIGRACION", schema = "datosEveliaMinimo", catalog = "")
public class RecursoMigracionEntity {
    private long recursoMigracionId;
    private Long id;
    private MigrandoMaterialEntity migrandoMaterialByRecursoMigracionId;
    private MigrandoRecursoEntity migrandoRecursoByRecursoMigracionId;
    private Collection<RecursoSolicitadoEntity> recursoSolicitadosByRecursoMigracionId;

    @Id
    @Column(name = "RECURSO_MIGRACION_ID")
    public long getRecursoMigracionId() {
        return recursoMigracionId;
    }

    public void setRecursoMigracionId(long recursoMigracionId) {
        this.recursoMigracionId = recursoMigracionId;
    }

    @Basic
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecursoMigracionEntity that = (RecursoMigracionEntity) o;

        if (recursoMigracionId != that.recursoMigracionId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (recursoMigracionId ^ (recursoMigracionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "recursoMigracionByMigrandoMaterialId")
    public MigrandoMaterialEntity getMigrandoMaterialByRecursoMigracionId() {
        return migrandoMaterialByRecursoMigracionId;
    }

    public void setMigrandoMaterialByRecursoMigracionId(MigrandoMaterialEntity migrandoMaterialByRecursoMigracionId) {
        this.migrandoMaterialByRecursoMigracionId = migrandoMaterialByRecursoMigracionId;
    }

    @OneToOne(mappedBy = "recursoMigracionByMigrandoRecursoId")
    public MigrandoRecursoEntity getMigrandoRecursoByRecursoMigracionId() {
        return migrandoRecursoByRecursoMigracionId;
    }

    public void setMigrandoRecursoByRecursoMigracionId(MigrandoRecursoEntity migrandoRecursoByRecursoMigracionId) {
        this.migrandoRecursoByRecursoMigracionId = migrandoRecursoByRecursoMigracionId;
    }

    @OneToMany(mappedBy = "recursoMigracionByRecursoMigracionId")
    public Collection<RecursoSolicitadoEntity> getRecursoSolicitadosByRecursoMigracionId() {
        return recursoSolicitadosByRecursoMigracionId;
    }

    public void setRecursoSolicitadosByRecursoMigracionId(Collection<RecursoSolicitadoEntity> recursoSolicitadosByRecursoMigracionId) {
        this.recursoSolicitadosByRecursoMigracionId = recursoSolicitadosByRecursoMigracionId;
    }
}
