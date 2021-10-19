package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "TIPO_CALIFICACION_ENCUESTAS", schema = "datosEveliaMinimo", catalog = "")
public class TipoCalificacionEncuestasEntity {
    private long tipoCalificacionEncuestasId;
    private Long id;
    private byte[] nombre;
    private Collection<PreguntaSiatEntity> preguntaSiatsByTipoCalificacionEncuestasId;
    private Collection<ValorCalificacionEntity> valorCalificacionsByTipoCalificacionEncuestasId;

    @Id
    @Column(name = "TIPO_CALIFICACION_ENCUESTAS_ID")
    public long getTipoCalificacionEncuestasId() {
        return tipoCalificacionEncuestasId;
    }

    public void setTipoCalificacionEncuestasId(long tipoCalificacionEncuestasId) {
        this.tipoCalificacionEncuestasId = tipoCalificacionEncuestasId;
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
    public byte[] getNombre() {
        return nombre;
    }

    public void setNombre(byte[] nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoCalificacionEncuestasEntity that = (TipoCalificacionEncuestasEntity) o;

        if (tipoCalificacionEncuestasId != that.tipoCalificacionEncuestasId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!Arrays.equals(nombre, that.nombre)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoCalificacionEncuestasId ^ (tipoCalificacionEncuestasId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(nombre);
        return result;
    }

    @OneToMany(mappedBy = "tipoCalificacionEncuestasByTipoCalificacionEncuestasId")
    public Collection<PreguntaSiatEntity> getPreguntaSiatsByTipoCalificacionEncuestasId() {
        return preguntaSiatsByTipoCalificacionEncuestasId;
    }

    public void setPreguntaSiatsByTipoCalificacionEncuestasId(Collection<PreguntaSiatEntity> preguntaSiatsByTipoCalificacionEncuestasId) {
        this.preguntaSiatsByTipoCalificacionEncuestasId = preguntaSiatsByTipoCalificacionEncuestasId;
    }

    @OneToMany(mappedBy = "tipoCalificacionEncuestasByTipoCalificacionEncuestasId")
    public Collection<ValorCalificacionEntity> getValorCalificacionsByTipoCalificacionEncuestasId() {
        return valorCalificacionsByTipoCalificacionEncuestasId;
    }

    public void setValorCalificacionsByTipoCalificacionEncuestasId(Collection<ValorCalificacionEntity> valorCalificacionsByTipoCalificacionEncuestasId) {
        this.valorCalificacionsByTipoCalificacionEncuestasId = valorCalificacionsByTipoCalificacionEncuestasId;
    }
}
