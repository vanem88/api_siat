package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TIPO_LICENCIA_MATERIAL", schema = "datosEveliaMinimo", catalog = "")
public class TipoLicenciaMaterialEntity {
    private long tipoLicenciaMaterialId;
    private String descripcion;
    private Long id;
    private String nombre;
    private String pathLogoChico;
    private String pathLogoGrande;
    private String referencia;
    private Collection<CursoEntity> cursosByTipoLicenciaMaterialId;
    private Collection<SolicitudAulaEntity> solicitudAulasByTipoLicenciaMaterialId;

    @Id
    @Column(name = "TIPO_LICENCIA_MATERIAL_ID")
    public long getTipoLicenciaMaterialId() {
        return tipoLicenciaMaterialId;
    }

    public void setTipoLicenciaMaterialId(long tipoLicenciaMaterialId) {
        this.tipoLicenciaMaterialId = tipoLicenciaMaterialId;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    @Column(name = "PATH_LOGO_CHICO")
    public String getPathLogoChico() {
        return pathLogoChico;
    }

    public void setPathLogoChico(String pathLogoChico) {
        this.pathLogoChico = pathLogoChico;
    }

    @Basic
    @Column(name = "PATH_LOGO_GRANDE")
    public String getPathLogoGrande() {
        return pathLogoGrande;
    }

    public void setPathLogoGrande(String pathLogoGrande) {
        this.pathLogoGrande = pathLogoGrande;
    }

    @Basic
    @Column(name = "REFERENCIA")
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoLicenciaMaterialEntity that = (TipoLicenciaMaterialEntity) o;

        if (tipoLicenciaMaterialId != that.tipoLicenciaMaterialId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (pathLogoChico != null ? !pathLogoChico.equals(that.pathLogoChico) : that.pathLogoChico != null)
            return false;
        if (pathLogoGrande != null ? !pathLogoGrande.equals(that.pathLogoGrande) : that.pathLogoGrande != null)
            return false;
        if (referencia != null ? !referencia.equals(that.referencia) : that.referencia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoLicenciaMaterialId ^ (tipoLicenciaMaterialId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (pathLogoChico != null ? pathLogoChico.hashCode() : 0);
        result = 31 * result + (pathLogoGrande != null ? pathLogoGrande.hashCode() : 0);
        result = 31 * result + (referencia != null ? referencia.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tipoLicenciaMaterialByTipoLicenciaMaterialId")
    public Collection<CursoEntity> getCursosByTipoLicenciaMaterialId() {
        return cursosByTipoLicenciaMaterialId;
    }

    public void setCursosByTipoLicenciaMaterialId(Collection<CursoEntity> cursosByTipoLicenciaMaterialId) {
        this.cursosByTipoLicenciaMaterialId = cursosByTipoLicenciaMaterialId;
    }

    @OneToMany(mappedBy = "tipoLicenciaMaterialByTipoLicenciaMaterialId")
    public Collection<SolicitudAulaEntity> getSolicitudAulasByTipoLicenciaMaterialId() {
        return solicitudAulasByTipoLicenciaMaterialId;
    }

    public void setSolicitudAulasByTipoLicenciaMaterialId(Collection<SolicitudAulaEntity> solicitudAulasByTipoLicenciaMaterialId) {
        this.solicitudAulasByTipoLicenciaMaterialId = solicitudAulasByTipoLicenciaMaterialId;
    }
}
