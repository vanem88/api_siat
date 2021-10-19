package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "OPCION_RESPUESTA", schema = "datosEveliaMinimo", catalog = "")
public class OpcionRespuestaEntity {
    private long opcionRespuestaId;
    private String descripcion;
    private Long id;
    private Collection<PreguntaOpcionRespuestaEntity> preguntaOpcionRespuestasByOpcionRespuestaId;

    @Id
    @Column(name = "OPCION_RESPUESTA_ID")
    public long getOpcionRespuestaId() {
        return opcionRespuestaId;
    }

    public void setOpcionRespuestaId(long opcionRespuestaId) {
        this.opcionRespuestaId = opcionRespuestaId;
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

        OpcionRespuestaEntity that = (OpcionRespuestaEntity) o;

        if (opcionRespuestaId != that.opcionRespuestaId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (opcionRespuestaId ^ (opcionRespuestaId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "opcionRespuestaByOpcionRespuestaId")
    public Collection<PreguntaOpcionRespuestaEntity> getPreguntaOpcionRespuestasByOpcionRespuestaId() {
        return preguntaOpcionRespuestasByOpcionRespuestaId;
    }

    public void setPreguntaOpcionRespuestasByOpcionRespuestaId(Collection<PreguntaOpcionRespuestaEntity> preguntaOpcionRespuestasByOpcionRespuestaId) {
        this.preguntaOpcionRespuestasByOpcionRespuestaId = preguntaOpcionRespuestasByOpcionRespuestaId;
    }
}
