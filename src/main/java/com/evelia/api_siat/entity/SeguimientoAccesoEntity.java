package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SEGUIMIENTO_ACCESO", schema = "datosEveliaMinimo", catalog = "")
public class SeguimientoAccesoEntity {
    private long seguimientoAccesoId;
    private Long aulaId;
    private Timestamp fechaYhoraEntrada;
    private Timestamp fechaYhoraSalida;
    private String host;
    private Long id;
    private Long personaId;
    private Long recursoId;
    private AulaEntity aulaByAulaId;
    private PersonaEntity personaByPersonaId;
    private RecursoEntity recursoByRecursoId;

    @Id
    @Column(name = "SEGUIMIENTO_ACCESO_ID")
    public long getSeguimientoAccesoId() {
        return seguimientoAccesoId;
    }

    public void setSeguimientoAccesoId(long seguimientoAccesoId) {
        this.seguimientoAccesoId = seguimientoAccesoId;
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
    @Column(name = "FECHA_YHORA_ENTRADA")
    public Timestamp getFechaYhoraEntrada() {
        return fechaYhoraEntrada;
    }

    public void setFechaYhoraEntrada(Timestamp fechaYhoraEntrada) {
        this.fechaYhoraEntrada = fechaYhoraEntrada;
    }

    @Basic
    @Column(name = "FECHA_YHORA_SALIDA")
    public Timestamp getFechaYhoraSalida() {
        return fechaYhoraSalida;
    }

    public void setFechaYhoraSalida(Timestamp fechaYhoraSalida) {
        this.fechaYhoraSalida = fechaYhoraSalida;
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

    @Basic
    @Column(name = "RECURSO_ID")
    public Long getRecursoId() {
        return recursoId;
    }

    public void setRecursoId(Long recursoId) {
        this.recursoId = recursoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeguimientoAccesoEntity that = (SeguimientoAccesoEntity) o;

        if (seguimientoAccesoId != that.seguimientoAccesoId) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (fechaYhoraEntrada != null ? !fechaYhoraEntrada.equals(that.fechaYhoraEntrada) : that.fechaYhoraEntrada != null)
            return false;
        if (fechaYhoraSalida != null ? !fechaYhoraSalida.equals(that.fechaYhoraSalida) : that.fechaYhoraSalida != null)
            return false;
        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (recursoId != null ? !recursoId.equals(that.recursoId) : that.recursoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seguimientoAccesoId ^ (seguimientoAccesoId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (fechaYhoraEntrada != null ? fechaYhoraEntrada.hashCode() : 0);
        result = 31 * result + (fechaYhoraSalida != null ? fechaYhoraSalida.hashCode() : 0);
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (recursoId != null ? recursoId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "AULA_ID", referencedColumnName = "AULA_ID", insertable=false, updatable=false)
    public AulaEntity getAulaByAulaId() {
        return aulaByAulaId;
    }

    public void setAulaByAulaId(AulaEntity aulaByAulaId) {
        this.aulaByAulaId = aulaByAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @ManyToOne
    @JoinColumn(name = "RECURSO_ID", referencedColumnName = "RECURSO_ID", insertable=false, updatable=false)
    public RecursoEntity getRecursoByRecursoId() {
        return recursoByRecursoId;
    }

    public void setRecursoByRecursoId(RecursoEntity recursoByRecursoId) {
        this.recursoByRecursoId = recursoByRecursoId;
    }
}
