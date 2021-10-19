package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "MIGRANDO_MATERIAL", schema = "datosEveliaMinimo", catalog = "")
public class MigrandoMaterialEntity {
    private long migrandoMaterialId;
    private Timestamp fechaCreacionMateriales;
    private byte materialesAdicional;
    private byte materialesBibliografia;
    private byte materialesEnlaces;
    private byte materialesPrincipales;
    private byte materialesSoftwares;
    private RecursoMigracionEntity recursoMigracionByMigrandoMaterialId;

    @Id
    @Column(name = "MIGRANDO_MATERIAL_ID")
    public long getMigrandoMaterialId() {
        return migrandoMaterialId;
    }

    public void setMigrandoMaterialId(long migrandoMaterialId) {
        this.migrandoMaterialId = migrandoMaterialId;
    }

    @Basic
    @Column(name = "FECHA_CREACION_MATERIALES")
    public Timestamp getFechaCreacionMateriales() {
        return fechaCreacionMateriales;
    }

    public void setFechaCreacionMateriales(Timestamp fechaCreacionMateriales) {
        this.fechaCreacionMateriales = fechaCreacionMateriales;
    }

    @Basic
    @Column(name = "MATERIALES_ADICIONAL")
    public byte getMaterialesAdicional() {
        return materialesAdicional;
    }

    public void setMaterialesAdicional(byte materialesAdicional) {
        this.materialesAdicional = materialesAdicional;
    }

    @Basic
    @Column(name = "MATERIALES_BIBLIOGRAFIA")
    public byte getMaterialesBibliografia() {
        return materialesBibliografia;
    }

    public void setMaterialesBibliografia(byte materialesBibliografia) {
        this.materialesBibliografia = materialesBibliografia;
    }

    @Basic
    @Column(name = "MATERIALES_ENLACES")
    public byte getMaterialesEnlaces() {
        return materialesEnlaces;
    }

    public void setMaterialesEnlaces(byte materialesEnlaces) {
        this.materialesEnlaces = materialesEnlaces;
    }

    @Basic
    @Column(name = "MATERIALES_PRINCIPALES")
    public byte getMaterialesPrincipales() {
        return materialesPrincipales;
    }

    public void setMaterialesPrincipales(byte materialesPrincipales) {
        this.materialesPrincipales = materialesPrincipales;
    }

    @Basic
    @Column(name = "MATERIALES_SOFTWARES")
    public byte getMaterialesSoftwares() {
        return materialesSoftwares;
    }

    public void setMaterialesSoftwares(byte materialesSoftwares) {
        this.materialesSoftwares = materialesSoftwares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MigrandoMaterialEntity that = (MigrandoMaterialEntity) o;

        if (migrandoMaterialId != that.migrandoMaterialId) return false;
        if (materialesAdicional != that.materialesAdicional) return false;
        if (materialesBibliografia != that.materialesBibliografia) return false;
        if (materialesEnlaces != that.materialesEnlaces) return false;
        if (materialesPrincipales != that.materialesPrincipales) return false;
        if (materialesSoftwares != that.materialesSoftwares) return false;
        if (fechaCreacionMateriales != null ? !fechaCreacionMateriales.equals(that.fechaCreacionMateriales) : that.fechaCreacionMateriales != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (migrandoMaterialId ^ (migrandoMaterialId >>> 32));
        result = 31 * result + (fechaCreacionMateriales != null ? fechaCreacionMateriales.hashCode() : 0);
        result = 31 * result + (int) materialesAdicional;
        result = 31 * result + (int) materialesBibliografia;
        result = 31 * result + (int) materialesEnlaces;
        result = 31 * result + (int) materialesPrincipales;
        result = 31 * result + (int) materialesSoftwares;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "MIGRANDO_MATERIAL_ID", referencedColumnName = "RECURSO_MIGRACION_ID", nullable = false, insertable=false, updatable=false)
    public RecursoMigracionEntity getRecursoMigracionByMigrandoMaterialId() {
        return recursoMigracionByMigrandoMaterialId;
    }

    public void setRecursoMigracionByMigrandoMaterialId(RecursoMigracionEntity recursoMigracionByMigrandoMaterialId) {
        this.recursoMigracionByMigrandoMaterialId = recursoMigracionByMigrandoMaterialId;
    }
}
