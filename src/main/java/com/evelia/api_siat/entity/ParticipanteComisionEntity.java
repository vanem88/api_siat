package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "PARTICIPANTE_COMISION", schema = "datosEveliaMinimo", catalog = "")
public class ParticipanteComisionEntity {
    private long participanteComisionId;
    private Long comisionId;
    private Timestamp fechaUltimoAcceso;
    private Long id;
    private Long participanteId;
    private Timestamp fechaAlta;
    private Long tipoUsuarioId;
    private byte[] observacionAutoinscripcion;
    private String agregadoDesde;
    private Long agregadoPorId;
    private ComisionEntity comisionByComisionId;
    private ParticipanteEntity participanteByParticipanteId;
    private PersonaEntity personaByAgregadoPorId;

    @Id
    @Column(name = "PARTICIPANTE_COMISION_ID")
    public long getParticipanteComisionId() {
        return participanteComisionId;
    }

    public void setParticipanteComisionId(long participanteComisionId) {
        this.participanteComisionId = participanteComisionId;
    }

    @Basic
    @Column(name = "COMISION_ID")
    public Long getComisionId() {
        return comisionId;
    }

    public void setComisionId(Long comisionId) {
        this.comisionId = comisionId;
    }

    @Basic
    @Column(name = "FECHA_ULTIMO_ACCESO")
    public Timestamp getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(Timestamp fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
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
    @Column(name = "PARTICIPANTE_ID")
    public Long getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Long participanteId) {
        this.participanteId = participanteId;
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
    @Column(name = "TIPO_USUARIO_ID")
    public Long getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Long tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    @Basic
    @Column(name = "OBSERVACION_AUTOINSCRIPCION")
    public byte[] getObservacionAutoinscripcion() {
        return observacionAutoinscripcion;
    }

    public void setObservacionAutoinscripcion(byte[] observacionAutoinscripcion) {
        this.observacionAutoinscripcion = observacionAutoinscripcion;
    }

    @Basic
    @Column(name = "AGREGADO_DESDE")
    public String getAgregadoDesde() {
        return agregadoDesde;
    }

    public void setAgregadoDesde(String agregadoDesde) {
        this.agregadoDesde = agregadoDesde;
    }

    @Basic
    @Column(name = "AGREGADO_POR_ID")
    public Long getAgregadoPorId() {
        return agregadoPorId;
    }

    public void setAgregadoPorId(Long agregadoPorId) {
        this.agregadoPorId = agregadoPorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipanteComisionEntity that = (ParticipanteComisionEntity) o;

        if (participanteComisionId != that.participanteComisionId) return false;
        if (comisionId != null ? !comisionId.equals(that.comisionId) : that.comisionId != null) return false;
        if (fechaUltimoAcceso != null ? !fechaUltimoAcceso.equals(that.fechaUltimoAcceso) : that.fechaUltimoAcceso != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (participanteId != null ? !participanteId.equals(that.participanteId) : that.participanteId != null)
            return false;
        if (fechaAlta != null ? !fechaAlta.equals(that.fechaAlta) : that.fechaAlta != null) return false;
        if (tipoUsuarioId != null ? !tipoUsuarioId.equals(that.tipoUsuarioId) : that.tipoUsuarioId != null)
            return false;
        if (!Arrays.equals(observacionAutoinscripcion, that.observacionAutoinscripcion)) return false;
        if (agregadoDesde != null ? !agregadoDesde.equals(that.agregadoDesde) : that.agregadoDesde != null)
            return false;
        if (agregadoPorId != null ? !agregadoPorId.equals(that.agregadoPorId) : that.agregadoPorId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (participanteComisionId ^ (participanteComisionId >>> 32));
        result = 31 * result + (comisionId != null ? comisionId.hashCode() : 0);
        result = 31 * result + (fechaUltimoAcceso != null ? fechaUltimoAcceso.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (participanteId != null ? participanteId.hashCode() : 0);
        result = 31 * result + (fechaAlta != null ? fechaAlta.hashCode() : 0);
        result = 31 * result + (tipoUsuarioId != null ? tipoUsuarioId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(observacionAutoinscripcion);
        result = 31 * result + (agregadoDesde != null ? agregadoDesde.hashCode() : 0);
        result = 31 * result + (agregadoPorId != null ? agregadoPorId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "COMISION_ID", referencedColumnName = "COMISION_ID", insertable=false, updatable=false)
    public ComisionEntity getComisionByComisionId() {
        return comisionByComisionId;
    }

    public void setComisionByComisionId(ComisionEntity comisionByComisionId) {
        this.comisionByComisionId = comisionByComisionId;
    }

    @ManyToOne
    @JoinColumn(name = "PARTICIPANTE_ID", referencedColumnName = "PARTICIPANTE_ID", insertable=false, updatable=false)
    public ParticipanteEntity getParticipanteByParticipanteId() {
        return participanteByParticipanteId;
    }

    public void setParticipanteByParticipanteId(ParticipanteEntity participanteByParticipanteId) {
        this.participanteByParticipanteId = participanteByParticipanteId;
    }

    @ManyToOne
    @JoinColumn(name = "AGREGADO_POR_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByAgregadoPorId() {
        return personaByAgregadoPorId;
    }

    public void setPersonaByAgregadoPorId(PersonaEntity personaByAgregadoPorId) {
        this.personaByAgregadoPorId = personaByAgregadoPorId;
    }
}
