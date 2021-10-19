package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ACCESO_PAGINA", schema = "datosEveliaMinimo", catalog = "")
public class AccesoPaginaEntity {
    private long accesoPaginaId;
    private Timestamp fechaHoraEntrada;
    private Timestamp fechaHoraSalida;
    private String host;
    private Long id;
    private Long personaId;
    private PersonaEntity personaByPersonaId;

    @Id
    @Column(name = "ACCESO_PAGINA_ID")
    public long getAccesoPaginaId() {
        return accesoPaginaId;
    }

    public void setAccesoPaginaId(long accesoPaginaId) {
        this.accesoPaginaId = accesoPaginaId;
    }

    @Basic
    @Column(name = "FECHA_HORA_ENTRADA")
    public Timestamp getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(Timestamp fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    @Basic
    @Column(name = "FECHA_HORA_SALIDA")
    public Timestamp getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Timestamp fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    @Basic
    @Column(name = "HOST")
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
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

        AccesoPaginaEntity that = (AccesoPaginaEntity) o;

        if (accesoPaginaId != that.accesoPaginaId) return false;
        if (fechaHoraEntrada != null ? !fechaHoraEntrada.equals(that.fechaHoraEntrada) : that.fechaHoraEntrada != null)
            return false;
        if (fechaHoraSalida != null ? !fechaHoraSalida.equals(that.fechaHoraSalida) : that.fechaHoraSalida != null)
            return false;
        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (accesoPaginaId ^ (accesoPaginaId >>> 32));
        result = 31 * result + (fechaHoraEntrada != null ? fechaHoraEntrada.hashCode() : 0);
        result = 31 * result + (fechaHoraSalida != null ? fechaHoraSalida.hashCode() : 0);
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    //@JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID")
    @JoinColumn(name = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
}
