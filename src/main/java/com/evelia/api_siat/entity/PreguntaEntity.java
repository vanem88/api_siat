package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PREGUNTA", schema = "datosEveliaMinimo", catalog = "")
public class PreguntaEntity {
    private long preguntaId;
    private String descripcion;
    private Long grupoPreguntaId;
    private Long id;
    private GrupoPreguntaEntity grupoPreguntaByGrupoPreguntaId;
    private Collection<PreguntaOpcionRespuestaEntity> preguntaOpcionRespuestasByPreguntaId;
    private Collection<RespuestaEntity> respuestasByPreguntaId;

    @Id
    @Column(name = "PREGUNTA_ID")
    public long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(long preguntaId) {
        this.preguntaId = preguntaId;
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
    @Column(name = "GRUPO_PREGUNTA_ID")
    public Long getGrupoPreguntaId() {
        return grupoPreguntaId;
    }

    public void setGrupoPreguntaId(Long grupoPreguntaId) {
        this.grupoPreguntaId = grupoPreguntaId;
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

        PreguntaEntity that = (PreguntaEntity) o;

        if (preguntaId != that.preguntaId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (grupoPreguntaId != null ? !grupoPreguntaId.equals(that.grupoPreguntaId) : that.grupoPreguntaId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (preguntaId ^ (preguntaId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (grupoPreguntaId != null ? grupoPreguntaId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "GRUPO_PREGUNTA_ID", referencedColumnName = "GRUPO_PREGUNTA_ID", insertable=false, updatable=false)
    public GrupoPreguntaEntity getGrupoPreguntaByGrupoPreguntaId() {
        return grupoPreguntaByGrupoPreguntaId;
    }

    public void setGrupoPreguntaByGrupoPreguntaId(GrupoPreguntaEntity grupoPreguntaByGrupoPreguntaId) {
        this.grupoPreguntaByGrupoPreguntaId = grupoPreguntaByGrupoPreguntaId;
    }

    @OneToMany(mappedBy = "preguntaByPreguntaId")
    public Collection<PreguntaOpcionRespuestaEntity> getPreguntaOpcionRespuestasByPreguntaId() {
        return preguntaOpcionRespuestasByPreguntaId;
    }

    public void setPreguntaOpcionRespuestasByPreguntaId(Collection<PreguntaOpcionRespuestaEntity> preguntaOpcionRespuestasByPreguntaId) {
        this.preguntaOpcionRespuestasByPreguntaId = preguntaOpcionRespuestasByPreguntaId;
    }

    @OneToMany(mappedBy = "preguntaByPreguntaId")
    public Collection<RespuestaEntity> getRespuestasByPreguntaId() {
        return respuestasByPreguntaId;
    }

    public void setRespuestasByPreguntaId(Collection<RespuestaEntity> respuestasByPreguntaId) {
        this.respuestasByPreguntaId = respuestasByPreguntaId;
    }
}
