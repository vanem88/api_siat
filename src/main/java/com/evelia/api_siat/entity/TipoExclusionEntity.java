package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TIPO_EXCLUSION", schema = "datosEveliaMinimo", catalog = "")
public class TipoExclusionEntity {
    private long tipoExclusionId;
    private Long id;
    private String nombre;
    private String nombrePlural;
    private Collection<ParticipanteExcluidoEntity> participanteExcluidosByTipoExclusionId;

    @Id
    @Column(name = "TIPO_EXCLUSION_ID")
    public long getTipoExclusionId() {
        return tipoExclusionId;
    }

    public void setTipoExclusionId(long tipoExclusionId) {
        this.tipoExclusionId = tipoExclusionId;
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
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "NOMBRE_PLURAL")
    public String getNombrePlural() {
        return nombrePlural;
    }

    public void setNombrePlural(String nombrePlural) {
        this.nombrePlural = nombrePlural;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoExclusionEntity that = (TipoExclusionEntity) o;

        if (tipoExclusionId != that.tipoExclusionId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (nombrePlural != null ? !nombrePlural.equals(that.nombrePlural) : that.nombrePlural != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoExclusionId ^ (tipoExclusionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (nombrePlural != null ? nombrePlural.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tipoExclusionByTipoExclusionId")
    public Collection<ParticipanteExcluidoEntity> getParticipanteExcluidosByTipoExclusionId() {
        return participanteExcluidosByTipoExclusionId;
    }

    public void setParticipanteExcluidosByTipoExclusionId(Collection<ParticipanteExcluidoEntity> participanteExcluidosByTipoExclusionId) {
        this.participanteExcluidosByTipoExclusionId = participanteExcluidosByTipoExclusionId;
    }
}
