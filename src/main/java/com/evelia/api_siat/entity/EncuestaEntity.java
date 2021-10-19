package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ENCUESTA", schema = "datosEveliaMinimo", catalog = "")
public class EncuestaEntity {
    private long encuestaId;
    private String descripcion;
    private Long id;
    private Collection<EncuestaAulaEntity> encuestaAulasByEncuestaId;
    private Collection<GrupoPreguntaEntity> grupoPreguntasByEncuestaId;

    @Id
    @Column(name = "ENCUESTA_ID")
    public long getEncuestaId() {
        return encuestaId;
    }

    public void setEncuestaId(long encuestaId) {
        this.encuestaId = encuestaId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EncuestaEntity that = (EncuestaEntity) o;

        if (encuestaId != that.encuestaId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (encuestaId ^ (encuestaId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "encuestaByEncuestaId")
    public Collection<EncuestaAulaEntity> getEncuestaAulasByEncuestaId() {
        return encuestaAulasByEncuestaId;
    }

    public void setEncuestaAulasByEncuestaId(Collection<EncuestaAulaEntity> encuestaAulasByEncuestaId) {
        this.encuestaAulasByEncuestaId = encuestaAulasByEncuestaId;
    }

    @OneToMany(mappedBy = "encuestaByEncuestaId")
    public Collection<GrupoPreguntaEntity> getGrupoPreguntasByEncuestaId() {
        return grupoPreguntasByEncuestaId;
    }

    public void setGrupoPreguntasByEncuestaId(Collection<GrupoPreguntaEntity> grupoPreguntasByEncuestaId) {
        this.grupoPreguntasByEncuestaId = grupoPreguntasByEncuestaId;
    }
}
