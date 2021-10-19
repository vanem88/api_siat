package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "PERSONA_MENSAJE_INGRESO", schema = "datosEveliaMinimo", catalog = "")
public class PersonaMensajeIngresoEntity {
    private long personaMensajeIngresoId;
    private Long id;
    private Long mensajeId;
    private byte[] observacion;
    private Long personaId;
    private Long aulaId;
    private Byte visualizo;
    private MensajeIngresoEntity mensajeIngresoByMensajeId;
    private PersonaEntity personaByPersonaId;
    private AulaEntity aulaByAulaId;

    @Id
    @Column(name = "PERSONA_MENSAJE_INGRESO_ID")
    public long getPersonaMensajeIngresoId() {
        return personaMensajeIngresoId;
    }

    public void setPersonaMensajeIngresoId(long personaMensajeIngresoId) {
        this.personaMensajeIngresoId = personaMensajeIngresoId;
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
    @Column(name = "MENSAJE_ID")
    public Long getMensajeId() {
        return mensajeId;
    }

    public void setMensajeId(Long mensajeId) {
        this.mensajeId = mensajeId;
    }

    @Basic
    @Column(name = "OBSERVACION")
    public byte[] getObservacion() {
        return observacion;
    }

    public void setObservacion(byte[] observacion) {
        this.observacion = observacion;
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
    @Column(name = "AULA_ID")
    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }

    @Basic
    @Column(name = "VISUALIZO")
    public Byte getVisualizo() {
        return visualizo;
    }

    public void setVisualizo(Byte visualizo) {
        this.visualizo = visualizo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonaMensajeIngresoEntity that = (PersonaMensajeIngresoEntity) o;

        if (personaMensajeIngresoId != that.personaMensajeIngresoId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (mensajeId != null ? !mensajeId.equals(that.mensajeId) : that.mensajeId != null) return false;
        if (!Arrays.equals(observacion, that.observacion)) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (visualizo != null ? !visualizo.equals(that.visualizo) : that.visualizo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personaMensajeIngresoId ^ (personaMensajeIngresoId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (mensajeId != null ? mensajeId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(observacion);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (visualizo != null ? visualizo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MENSAJE_ID", referencedColumnName = "MENSAJE_INGRESO_ID", insertable=false, updatable=false)
    public MensajeIngresoEntity getMensajeIngresoByMensajeId() {
        return mensajeIngresoByMensajeId;
    }

    public void setMensajeIngresoByMensajeId(MensajeIngresoEntity mensajeIngresoByMensajeId) {
        this.mensajeIngresoByMensajeId = mensajeIngresoByMensajeId;
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
    @JoinColumn(name = "AULA_ID", referencedColumnName = "AULA_ID",insertable=false, updatable=false)
    public AulaEntity getAulaByAulaId() {
        return aulaByAulaId;
    }

    public void setAulaByAulaId(AulaEntity aulaByAulaId) {
        this.aulaByAulaId = aulaByAulaId;
    }
}
