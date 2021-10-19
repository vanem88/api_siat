package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "LISTADO_TEMAS", schema = "datosEveliaMinimo", catalog = "")
public class ListadoTemasEntity {
    private long listadoTemasId;
    private Long id;
    private byte[] observacion;
    private Byte temasExcluyentes;
    private Collection<AulaEntity> aulasByListadoTemasId;
    private Collection<TemaEntity> temasByListadoTemasId;

    @Id
    @Column(name = "LISTADO_TEMAS_ID")
    public long getListadoTemasId() {
        return listadoTemasId;
    }

    public void setListadoTemasId(long listadoTemasId) {
        this.listadoTemasId = listadoTemasId;
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
    @Column(name = "OBSERVACION")
    public byte[] getObservacion() {
        return observacion;
    }

    public void setObservacion(byte[] observacion) {
        this.observacion = observacion;
    }

    @Basic
    @Column(name = "TEMAS_EXCLUYENTES")
    public Byte getTemasExcluyentes() {
        return temasExcluyentes;
    }

    public void setTemasExcluyentes(Byte temasExcluyentes) {
        this.temasExcluyentes = temasExcluyentes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListadoTemasEntity that = (ListadoTemasEntity) o;

        if (listadoTemasId != that.listadoTemasId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!Arrays.equals(observacion, that.observacion)) return false;
        if (temasExcluyentes != null ? !temasExcluyentes.equals(that.temasExcluyentes) : that.temasExcluyentes != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (listadoTemasId ^ (listadoTemasId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(observacion);
        result = 31 * result + (temasExcluyentes != null ? temasExcluyentes.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "listadoTemasByListadoTemasId")
    public Collection<AulaEntity> getAulasByListadoTemasId() {
        return aulasByListadoTemasId;
    }

    public void setAulasByListadoTemasId(Collection<AulaEntity> aulasByListadoTemasId) {
        this.aulasByListadoTemasId = aulasByListadoTemasId;
    }

    @OneToMany(mappedBy = "listadoTemasByListadoTemasId")
    public Collection<TemaEntity> getTemasByListadoTemasId() {
        return temasByListadoTemasId;
    }

    public void setTemasByListadoTemasId(Collection<TemaEntity> temasByListadoTemasId) {
        this.temasByListadoTemasId = temasByListadoTemasId;
    }
}
