package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "FAVORITO", schema = "datosEveliaMinimo", catalog = "")
public class FavoritoEntity {
    private long favoritoId;
    private Long aulaId;
    private Timestamp fechaAlta;
    private Long id;
    private String observaciones;
    private Long personaId;

    @Id
    @Column(name = "FAVORITO_ID")
    public long getFavoritoId() {
        return favoritoId;
    }

    public void setFavoritoId(long favoritoId) {
        this.favoritoId = favoritoId;
    }

    @Basic
    @Column(name = "AULA_ID")
    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }

    @Basic
    @Column(name = "FECHA_ALTA")
    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
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
    @Column(name = "OBSERVACIONES")
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Basic
    @Column(name = "PERSONA_ID")
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoritoEntity that = (FavoritoEntity) o;

        if (favoritoId != that.favoritoId) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (fechaAlta != null ? !fechaAlta.equals(that.fechaAlta) : that.fechaAlta != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (observaciones != null ? !observaciones.equals(that.observaciones) : that.observaciones != null)
            return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (favoritoId ^ (favoritoId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (fechaAlta != null ? fechaAlta.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (observaciones != null ? observaciones.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result;
    }
}
