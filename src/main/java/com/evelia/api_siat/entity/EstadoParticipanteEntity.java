package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ESTADO_PARTICIPANTE", schema = "datosEveliaMinimo", catalog = "")
public class EstadoParticipanteEntity {
    private long estadoParticipanteId;
    private String descripcion;
    private Long id;
    private Collection<ParticipanteEntity> participantesByEstadoParticipanteId;

    @Id
    @Column(name = "ESTADO_PARTICIPANTE_ID")
    public long getEstadoParticipanteId() {
        return estadoParticipanteId;
    }

    public void setEstadoParticipanteId(long estadoParticipanteId) {
        this.estadoParticipanteId = estadoParticipanteId;
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

        EstadoParticipanteEntity that = (EstadoParticipanteEntity) o;

        if (estadoParticipanteId != that.estadoParticipanteId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (estadoParticipanteId ^ (estadoParticipanteId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "estadoParticipanteByEstadoParticipanteId")
    public Collection<ParticipanteEntity> getParticipantesByEstadoParticipanteId() {
        return participantesByEstadoParticipanteId;
    }

    public void setParticipantesByEstadoParticipanteId(Collection<ParticipanteEntity> participantesByEstadoParticipanteId) {
        this.participantesByEstadoParticipanteId = participantesByEstadoParticipanteId;
    }
}
