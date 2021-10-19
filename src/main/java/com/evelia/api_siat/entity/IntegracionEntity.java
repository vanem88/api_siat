package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "INTEGRACION", schema = "datosEveliaMinimo", catalog = "")
public class IntegracionEntity {
    private long integracionId;
    private Long id;
    private Collection<GrupoEntity> gruposByIntegracionId;
    private Collection<TextoEntity> textosByIntegracionId;

    @Id
    @Column(name = "INTEGRACION_ID")
    public long getIntegracionId() {
        return integracionId;
    }

    public void setIntegracionId(long integracionId) {
        this.integracionId = integracionId;
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

        IntegracionEntity that = (IntegracionEntity) o;

        if (integracionId != that.integracionId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (integracionId ^ (integracionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "integracionByIntegracionId")
    public Collection<GrupoEntity> getGruposByIntegracionId() {
        return gruposByIntegracionId;
    }

    public void setGruposByIntegracionId(Collection<GrupoEntity> gruposByIntegracionId) {
        this.gruposByIntegracionId = gruposByIntegracionId;
    }

    @OneToMany(mappedBy = "integracionByIntegracionId")
    public Collection<TextoEntity> getTextosByIntegracionId() {
        return textosByIntegracionId;
    }

    public void setTextosByIntegracionId(Collection<TextoEntity> textosByIntegracionId) {
        this.textosByIntegracionId = textosByIntegracionId;
    }
}
