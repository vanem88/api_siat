package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "GRUPO_PREGUNTA", schema = "datosEveliaMinimo", catalog = "")
public class GrupoPreguntaEntity {
    private long grupoPreguntaId;
    private String descripcion;
    private Long encuestaId;
    private Long id;
    private EncuestaEntity encuestaByEncuestaId;
    private Collection<PreguntaEntity> preguntasByGrupoPreguntaId;

    @Id
    @Column(name = "GRUPO_PREGUNTA_ID")
    public long getGrupoPreguntaId() {
        return grupoPreguntaId;
    }

    public void setGrupoPreguntaId(long grupoPreguntaId) {
        this.grupoPreguntaId = grupoPreguntaId;
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
    @Column(name = "ENCUESTA_ID")
    public Long getEncuestaId() {
        return encuestaId;
    }

    public void setEncuestaId(Long encuestaId) {
        this.encuestaId = encuestaId;
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

        GrupoPreguntaEntity that = (GrupoPreguntaEntity) o;

        if (grupoPreguntaId != that.grupoPreguntaId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (encuestaId != null ? !encuestaId.equals(that.encuestaId) : that.encuestaId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (grupoPreguntaId ^ (grupoPreguntaId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (encuestaId != null ? encuestaId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ENCUESTA_ID", referencedColumnName = "ENCUESTA_ID", insertable=false, updatable=false)
    public EncuestaEntity getEncuestaByEncuestaId() {
        return encuestaByEncuestaId;
    }

    public void setEncuestaByEncuestaId(EncuestaEntity encuestaByEncuestaId) {
        this.encuestaByEncuestaId = encuestaByEncuestaId;
    }

    @OneToMany(mappedBy = "grupoPreguntaByGrupoPreguntaId")
    public Collection<PreguntaEntity> getPreguntasByGrupoPreguntaId() {
        return preguntasByGrupoPreguntaId;
    }

    public void setPreguntasByGrupoPreguntaId(Collection<PreguntaEntity> preguntasByGrupoPreguntaId) {
        this.preguntasByGrupoPreguntaId = preguntasByGrupoPreguntaId;
    }
}
