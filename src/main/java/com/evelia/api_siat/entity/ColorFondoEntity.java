package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "COLOR_FONDO", schema = "datosEveliaMinimo", catalog = "")
public class ColorFondoEntity {
    private long colorFondoId;
    private Collection<AulaEntity> aulasByColorFondoId;
    private PropiedadPaginaEntity propiedadPaginaByColorFondoId;

    @Id
    @Column(name = "COLOR_FONDO_ID")
    public long getColorFondoId() {
        return colorFondoId;
    }

    public void setColorFondoId(long colorFondoId) {
        this.colorFondoId = colorFondoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColorFondoEntity that = (ColorFondoEntity) o;

        if (colorFondoId != that.colorFondoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (colorFondoId ^ (colorFondoId >>> 32));
    }

    @OneToMany(mappedBy = "colorFondoByColorFondoId")
    public Collection<AulaEntity> getAulasByColorFondoId() {
        return aulasByColorFondoId;
    }

    public void setAulasByColorFondoId(Collection<AulaEntity> aulasByColorFondoId) {
        this.aulasByColorFondoId = aulasByColorFondoId;
    }

    @OneToOne
    @JoinColumn(name = "COLOR_FONDO_ID", referencedColumnName = "PROPIEDAD_PAGINA_ID", nullable = false, insertable=false, updatable=false)
    public PropiedadPaginaEntity getPropiedadPaginaByColorFondoId() {
        return propiedadPaginaByColorFondoId;
    }

    public void setPropiedadPaginaByColorFondoId(PropiedadPaginaEntity propiedadPaginaByColorFondoId) {
        this.propiedadPaginaByColorFondoId = propiedadPaginaByColorFondoId;
    }
}
