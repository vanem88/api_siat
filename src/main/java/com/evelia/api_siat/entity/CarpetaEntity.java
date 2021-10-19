package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "CARPETA", schema = "datosEveliaMinimo", catalog = "")
public class CarpetaEntity {
    private long carpetaId;
    private Timestamp fechaCreacion;
    private Long id;
    private String nombre;
    private Long padreId;
    private String nombreReal;
    private Collection<ArchivoEntity> archivosByCarpetaId;
    private Collection<ArchivoCompartidoAulaEntity> archivoCompartidoAulasByCarpetaId;
    private CarpetaEntity carpetaByPadreId;
    private Collection<CarpetaEntity> carpetasByCarpetaId;
    private MaterialEntity materialByCarpetaId;
    private MaterialAdicionalEntity materialAdicionalByCarpetaId;
    private MiMaterialEntity miMaterialByCarpetaId;
    private SoftwareEntity softwareByCarpetaId;

    @Id
    @Column(name = "CARPETA_ID")
    public long getCarpetaId() {
        return carpetaId;
    }

    public void setCarpetaId(long carpetaId) {
        this.carpetaId = carpetaId;
    }

    @Basic
    @Column(name = "FECHA_CREACION")
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "PADRE_ID")
    public Long getPadreId() {
        return padreId;
    }

    public void setPadreId(Long padreId) {
        this.padreId = padreId;
    }

    @Basic
    @Column(name = "NOMBRE_REAL")
    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarpetaEntity that = (CarpetaEntity) o;

        if (carpetaId != that.carpetaId) return false;
        if (fechaCreacion != null ? !fechaCreacion.equals(that.fechaCreacion) : that.fechaCreacion != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (padreId != null ? !padreId.equals(that.padreId) : that.padreId != null) return false;
        if (nombreReal != null ? !nombreReal.equals(that.nombreReal) : that.nombreReal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (carpetaId ^ (carpetaId >>> 32));
        result = 31 * result + (fechaCreacion != null ? fechaCreacion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (padreId != null ? padreId.hashCode() : 0);
        result = 31 * result + (nombreReal != null ? nombreReal.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "carpetaByCarpetaId")
    public Collection<ArchivoEntity> getArchivosByCarpetaId() {
        return archivosByCarpetaId;
    }

    public void setArchivosByCarpetaId(Collection<ArchivoEntity> archivosByCarpetaId) {
        this.archivosByCarpetaId = archivosByCarpetaId;
    }

    @OneToMany(mappedBy = "carpetaByCarpetaId")
    public Collection<ArchivoCompartidoAulaEntity> getArchivoCompartidoAulasByCarpetaId() {
        return archivoCompartidoAulasByCarpetaId;
    }

    public void setArchivoCompartidoAulasByCarpetaId(Collection<ArchivoCompartidoAulaEntity> archivoCompartidoAulasByCarpetaId) {
        this.archivoCompartidoAulasByCarpetaId = archivoCompartidoAulasByCarpetaId;
    }

    @ManyToOne
    @JoinColumn(name = "PADRE_ID", referencedColumnName = "CARPETA_ID", insertable=false, updatable=false)
    public CarpetaEntity getCarpetaByPadreId() {
        return carpetaByPadreId;
    }

    public void setCarpetaByPadreId(CarpetaEntity carpetaByPadreId) {
        this.carpetaByPadreId = carpetaByPadreId;
    }

    @OneToMany(mappedBy = "carpetaByPadreId")
    public Collection<CarpetaEntity> getCarpetasByCarpetaId() {
        return carpetasByCarpetaId;
    }

    public void setCarpetasByCarpetaId(Collection<CarpetaEntity> carpetasByCarpetaId) {
        this.carpetasByCarpetaId = carpetasByCarpetaId;
    }

    @OneToOne(mappedBy = "carpetaByMaterialId")
    public MaterialEntity getMaterialByCarpetaId() {
        return materialByCarpetaId;
    }

    public void setMaterialByCarpetaId(MaterialEntity materialByCarpetaId) {
        this.materialByCarpetaId = materialByCarpetaId;
    }

    @OneToOne(mappedBy = "carpetaByMaterialAdicionalId")
    public MaterialAdicionalEntity getMaterialAdicionalByCarpetaId() {
        return materialAdicionalByCarpetaId;
    }

    public void setMaterialAdicionalByCarpetaId(MaterialAdicionalEntity materialAdicionalByCarpetaId) {
        this.materialAdicionalByCarpetaId = materialAdicionalByCarpetaId;
    }

    @OneToOne(mappedBy = "carpetaByMiMaterialId")
    public MiMaterialEntity getMiMaterialByCarpetaId() {
        return miMaterialByCarpetaId;
    }

    public void setMiMaterialByCarpetaId(MiMaterialEntity miMaterialByCarpetaId) {
        this.miMaterialByCarpetaId = miMaterialByCarpetaId;
    }

    @OneToOne(mappedBy = "carpetaBySoftwareId")
    public SoftwareEntity getSoftwareByCarpetaId() {
        return softwareByCarpetaId;
    }

    public void setSoftwareByCarpetaId(SoftwareEntity softwareByCarpetaId) {
        this.softwareByCarpetaId = softwareByCarpetaId;
    }
}
