package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "PARTICIPANTE", schema = "datosEveliaMinimo", catalog = "")
public class ParticipanteEntity {
    private long participanteId;
    private Long aulaId;
    private Integer comparteCarpeta;
    private Long cuentaCorreoId;
    private String emailEad;
    private Long estadoParticipanteId;
    private Timestamp fechaAlta;
    private Timestamp fechaUltimoAcceso;
    private Long id;
    private String inscriptoSial;
    private String observaciones;
    private Long personaId;
    private Long tipoUsuarioId;
    private String condicion;
    private boolean replicar;
    private String agregadoDesde;
    private Long agregadoPorId;
    private Collection<LecturasForoEntity> lecturasForosByParticipanteId;
    private AulaEntity aulaByAulaId;
    private CuentaCorreoEntity cuentaCorreoByCuentaCorreoId;
    private EstadoParticipanteEntity estadoParticipanteByEstadoParticipanteId;
    private PersonaEntity personaByPersonaId;
    private TipoUsuarioEntity tipoUsuarioByTipoUsuarioId;
    private PersonaEntity personaByAgregadoPorId;
    private Collection<ParticipanteComisionEntity> participanteComisionsByParticipanteId;
    private Collection<ParticipanteExcluidoEntity> participanteExcluidosByParticipanteId;

    @Id
    @Column(name = "PARTICIPANTE_ID")
    public long getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(long participanteId) {
        this.participanteId = participanteId;
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
    @Column(name = "COMPARTE_CARPETA")
    public Integer getComparteCarpeta() {
        return comparteCarpeta;
    }

    public void setComparteCarpeta(Integer comparteCarpeta) {
        this.comparteCarpeta = comparteCarpeta;
    }

    @Basic
    @Column(name = "CUENTA_CORREO_ID")
    public Long getCuentaCorreoId() {
        return cuentaCorreoId;
    }

    public void setCuentaCorreoId(Long cuentaCorreoId) {
        this.cuentaCorreoId = cuentaCorreoId;
    }

    @Basic
    @Column(name = "EMAIL_EAD")
    public String getEmailEad() {
        return emailEad;
    }

    public void setEmailEad(String emailEad) {
        this.emailEad = emailEad;
    }

    @Basic
    @Column(name = "ESTADO_PARTICIPANTE_ID")
    public Long getEstadoParticipanteId() {
        return estadoParticipanteId;
    }

    public void setEstadoParticipanteId(Long estadoParticipanteId) {
        this.estadoParticipanteId = estadoParticipanteId;
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
    @Column(name = "INSCRIPTO_SIAL")
    public String getInscriptoSial() {
        return inscriptoSial;
    }

    public void setInscriptoSial(String inscriptoSial) {
        this.inscriptoSial = inscriptoSial;
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

    @Basic
    @Column(name = "TIPO_USUARIO_ID")
    public Long getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Long tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    @Basic
    @Column(name = "CONDICION")
    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    @Basic
    @Column(name = "REPLICAR")
    public boolean isReplicar() {
        return replicar;
    }

    public void setReplicar(boolean replicar) {
        this.replicar = replicar;
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

        ParticipanteEntity that = (ParticipanteEntity) o;

        if (participanteId != that.participanteId) return false;
        if (replicar != that.replicar) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (comparteCarpeta != null ? !comparteCarpeta.equals(that.comparteCarpeta) : that.comparteCarpeta != null)
            return false;
        if (cuentaCorreoId != null ? !cuentaCorreoId.equals(that.cuentaCorreoId) : that.cuentaCorreoId != null)
            return false;
        if (emailEad != null ? !emailEad.equals(that.emailEad) : that.emailEad != null) return false;
        if (estadoParticipanteId != null ? !estadoParticipanteId.equals(that.estadoParticipanteId) : that.estadoParticipanteId != null)
            return false;
        if (fechaAlta != null ? !fechaAlta.equals(that.fechaAlta) : that.fechaAlta != null) return false;
        if (fechaUltimoAcceso != null ? !fechaUltimoAcceso.equals(that.fechaUltimoAcceso) : that.fechaUltimoAcceso != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (inscriptoSial != null ? !inscriptoSial.equals(that.inscriptoSial) : that.inscriptoSial != null)
            return false;
        if (observaciones != null ? !observaciones.equals(that.observaciones) : that.observaciones != null)
            return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (tipoUsuarioId != null ? !tipoUsuarioId.equals(that.tipoUsuarioId) : that.tipoUsuarioId != null)
            return false;
        if (condicion != null ? !condicion.equals(that.condicion) : that.condicion != null) return false;
        if (agregadoDesde != null ? !agregadoDesde.equals(that.agregadoDesde) : that.agregadoDesde != null)
            return false;
        if (agregadoPorId != null ? !agregadoPorId.equals(that.agregadoPorId) : that.agregadoPorId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (participanteId ^ (participanteId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (comparteCarpeta != null ? comparteCarpeta.hashCode() : 0);
        result = 31 * result + (cuentaCorreoId != null ? cuentaCorreoId.hashCode() : 0);
        result = 31 * result + (emailEad != null ? emailEad.hashCode() : 0);
        result = 31 * result + (estadoParticipanteId != null ? estadoParticipanteId.hashCode() : 0);
        result = 31 * result + (fechaAlta != null ? fechaAlta.hashCode() : 0);
        result = 31 * result + (fechaUltimoAcceso != null ? fechaUltimoAcceso.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (inscriptoSial != null ? inscriptoSial.hashCode() : 0);
        result = 31 * result + (observaciones != null ? observaciones.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (tipoUsuarioId != null ? tipoUsuarioId.hashCode() : 0);
        result = 31 * result + (condicion != null ? condicion.hashCode() : 0);
        result = 31 * result + (replicar ? 1 : 0);
        result = 31 * result + (agregadoDesde != null ? agregadoDesde.hashCode() : 0);
        result = 31 * result + (agregadoPorId != null ? agregadoPorId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "participanteByParticipanteId")
    public Collection<LecturasForoEntity> getLecturasForosByParticipanteId() {
        return lecturasForosByParticipanteId;
    }

    public void setLecturasForosByParticipanteId(Collection<LecturasForoEntity> lecturasForosByParticipanteId) {
        this.lecturasForosByParticipanteId = lecturasForosByParticipanteId;
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
    @JoinColumn(name = "CUENTA_CORREO_ID", referencedColumnName = "CUENTA_CORREO_ID", insertable=false, updatable=false)
    public CuentaCorreoEntity getCuentaCorreoByCuentaCorreoId() {
        return cuentaCorreoByCuentaCorreoId;
    }

    public void setCuentaCorreoByCuentaCorreoId(CuentaCorreoEntity cuentaCorreoByCuentaCorreoId) {
        this.cuentaCorreoByCuentaCorreoId = cuentaCorreoByCuentaCorreoId;
    }

    @ManyToOne
    @JoinColumn(name = "ESTADO_PARTICIPANTE_ID", referencedColumnName = "ESTADO_PARTICIPANTE_ID", insertable=false, updatable=false)
    public EstadoParticipanteEntity getEstadoParticipanteByEstadoParticipanteId() {
        return estadoParticipanteByEstadoParticipanteId;
    }

    public void setEstadoParticipanteByEstadoParticipanteId(EstadoParticipanteEntity estadoParticipanteByEstadoParticipanteId) {
        this.estadoParticipanteByEstadoParticipanteId = estadoParticipanteByEstadoParticipanteId;
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
    @JoinColumn(name = "TIPO_USUARIO_ID", referencedColumnName = "TIPO_USUARIO_ID", insertable=false, updatable=false)
    public TipoUsuarioEntity getTipoUsuarioByTipoUsuarioId() {
        return tipoUsuarioByTipoUsuarioId;
    }

    public void setTipoUsuarioByTipoUsuarioId(TipoUsuarioEntity tipoUsuarioByTipoUsuarioId) {
        this.tipoUsuarioByTipoUsuarioId = tipoUsuarioByTipoUsuarioId;
    }

    @ManyToOne
    @JoinColumn(name = "AGREGADO_POR_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByAgregadoPorId() {
        return personaByAgregadoPorId;
    }

    public void setPersonaByAgregadoPorId(PersonaEntity personaByAgregadoPorId) {
        this.personaByAgregadoPorId = personaByAgregadoPorId;
    }

    @OneToMany(mappedBy = "participanteByParticipanteId")
    public Collection<ParticipanteComisionEntity> getParticipanteComisionsByParticipanteId() {
        return participanteComisionsByParticipanteId;
    }

    public void setParticipanteComisionsByParticipanteId(Collection<ParticipanteComisionEntity> participanteComisionsByParticipanteId) {
        this.participanteComisionsByParticipanteId = participanteComisionsByParticipanteId;
    }

    @OneToMany(mappedBy = "participanteByParticipanteId")
    public Collection<ParticipanteExcluidoEntity> getParticipanteExcluidosByParticipanteId() {
        return participanteExcluidosByParticipanteId;
    }

    public void setParticipanteExcluidosByParticipanteId(Collection<ParticipanteExcluidoEntity> participanteExcluidosByParticipanteId) {
        this.participanteExcluidosByParticipanteId = participanteExcluidosByParticipanteId;
    }
}
