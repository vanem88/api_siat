package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PAGINA_ESTILO", schema = "datosEveliaMinimo", catalog = "")
public class PaginaEstiloEntity {
    private long paginaEstiloId;
    private Collection<AulaEntity> aulasByPaginaEstiloId;
    private Collection<AulaEntity> aulasByPaginaEstiloId_0;
    private PropiedadPaginaEntity propiedadPaginaByPaginaEstiloId;

    @Id
    @Column(name = "PAGINA_ESTILO_ID")
    public long getPaginaEstiloId() {
        return paginaEstiloId;
    }

    public void setPaginaEstiloId(long paginaEstiloId) {
        this.paginaEstiloId = paginaEstiloId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaginaEstiloEntity that = (PaginaEstiloEntity) o;

        if (paginaEstiloId != that.paginaEstiloId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (paginaEstiloId ^ (paginaEstiloId >>> 32));
    }

    @OneToMany(mappedBy = "paginaEstiloByEstiloImpresionId")
    public Collection<AulaEntity> getAulasByPaginaEstiloId() {
        return aulasByPaginaEstiloId;
    }

    public void setAulasByPaginaEstiloId(Collection<AulaEntity> aulasByPaginaEstiloId) {
        this.aulasByPaginaEstiloId = aulasByPaginaEstiloId;
    }

    @OneToMany(mappedBy = "paginaEstiloByEstiloVistaId")
    public Collection<AulaEntity> getAulasByPaginaEstiloId_0() {
        return aulasByPaginaEstiloId_0;
    }

    public void setAulasByPaginaEstiloId_0(Collection<AulaEntity> aulasByPaginaEstiloId_0) {
        this.aulasByPaginaEstiloId_0 = aulasByPaginaEstiloId_0;
    }

    @OneToOne
    @JoinColumn(name = "PAGINA_ESTILO_ID", referencedColumnName = "PROPIEDAD_PAGINA_ID", nullable = false, insertable=false, updatable=false)
    public PropiedadPaginaEntity getPropiedadPaginaByPaginaEstiloId() {
        return propiedadPaginaByPaginaEstiloId;
    }

    public void setPropiedadPaginaByPaginaEstiloId(PropiedadPaginaEntity propiedadPaginaByPaginaEstiloId) {
        this.propiedadPaginaByPaginaEstiloId = propiedadPaginaByPaginaEstiloId;
    }
}
