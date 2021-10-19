package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ENCABEZADO_PAGINA", schema = "datosEveliaMinimo", catalog = "")
public class EncabezadoPaginaEntity {
    private long encabezadoPaginaId;
    private Collection<AulaEntity> aulasByEncabezadoPaginaId;
    private PropiedadPaginaEntity propiedadPaginaByEncabezadoPaginaId;

    @Id
    @Column(name = "ENCABEZADO_PAGINA_ID")
    public long getEncabezadoPaginaId() {
        return encabezadoPaginaId;
    }

    public void setEncabezadoPaginaId(long encabezadoPaginaId) {
        this.encabezadoPaginaId = encabezadoPaginaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EncabezadoPaginaEntity that = (EncabezadoPaginaEntity) o;

        if (encabezadoPaginaId != that.encabezadoPaginaId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (encabezadoPaginaId ^ (encabezadoPaginaId >>> 32));
    }

    @OneToMany(mappedBy = "encabezadoPaginaByEncabezadoPaginaId")
    public Collection<AulaEntity> getAulasByEncabezadoPaginaId() {
        return aulasByEncabezadoPaginaId;
    }

    public void setAulasByEncabezadoPaginaId(Collection<AulaEntity> aulasByEncabezadoPaginaId) {
        this.aulasByEncabezadoPaginaId = aulasByEncabezadoPaginaId;
    }

    @OneToOne
    @JoinColumn(name = "ENCABEZADO_PAGINA_ID", referencedColumnName = "PROPIEDAD_PAGINA_ID", nullable = false, insertable=false, updatable=false)
    public PropiedadPaginaEntity getPropiedadPaginaByEncabezadoPaginaId() {
        return propiedadPaginaByEncabezadoPaginaId;
    }

    public void setPropiedadPaginaByEncabezadoPaginaId(PropiedadPaginaEntity propiedadPaginaByEncabezadoPaginaId) {
        this.propiedadPaginaByEncabezadoPaginaId = propiedadPaginaByEncabezadoPaginaId;
    }
}
