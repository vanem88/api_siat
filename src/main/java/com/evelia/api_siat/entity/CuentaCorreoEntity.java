package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CUENTA_CORREO", schema = "datosEveliaMinimo", catalog = "")
public class CuentaCorreoEntity {
    private long cuentaCorreoId;
    private String clave;
    private String cuenta;
    private Long id;
    private Long personaId;
    private Collection<CuentasHastaEntity> cuentasHastasByCuentaCorreoId;
    private PersonaEntity personaByPersonaId;
    private Collection<CuentaListaCorreoEntity> cuentaListaCorreosByCuentaCorreoId;
    private Collection<MailEntity> mailByCuentaCorreoId;
    private Collection<ParticipanteEntity> participantesByCuentaCorreoId;
    private Collection<SeguimientoMailEntity> seguimientoMailsByCuentaCorreoId;

    @Id
    @Column(name = "CUENTA_CORREO_ID")
    public long getCuentaCorreoId() {
        return cuentaCorreoId;
    }

    public void setCuentaCorreoId(long cuentaCorreoId) {
        this.cuentaCorreoId = cuentaCorreoId;
    }

    @Basic
    @Column(name = "CLAVE")
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Basic
    @Column(name = "CUENTA")
    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
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

        CuentaCorreoEntity that = (CuentaCorreoEntity) o;

        if (cuentaCorreoId != that.cuentaCorreoId) return false;
        if (clave != null ? !clave.equals(that.clave) : that.clave != null) return false;
        if (cuenta != null ? !cuenta.equals(that.cuenta) : that.cuenta != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cuentaCorreoId ^ (cuentaCorreoId >>> 32));
        result = 31 * result + (clave != null ? clave.hashCode() : 0);
        result = 31 * result + (cuenta != null ? cuenta.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cuentaCorreoByCuentaCorreoId")
    public Collection<CuentasHastaEntity> getCuentasHastasByCuentaCorreoId() {
        return cuentasHastasByCuentaCorreoId;
    }

    public void setCuentasHastasByCuentaCorreoId(Collection<CuentasHastaEntity> cuentasHastasByCuentaCorreoId) {
        this.cuentasHastasByCuentaCorreoId = cuentasHastasByCuentaCorreoId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @OneToMany(mappedBy = "cuentaCorreoByCuentaCorreoId")
    public Collection<CuentaListaCorreoEntity> getCuentaListaCorreosByCuentaCorreoId() {
        return cuentaListaCorreosByCuentaCorreoId;
    }

    public void setCuentaListaCorreosByCuentaCorreoId(Collection<CuentaListaCorreoEntity> cuentaListaCorreosByCuentaCorreoId) {
        this.cuentaListaCorreosByCuentaCorreoId = cuentaListaCorreosByCuentaCorreoId;
    }

    @OneToMany(mappedBy = "cuentaCorreoByCuentaCorreoId")
    public Collection<MailEntity> getMailByCuentaCorreoId() {
        return mailByCuentaCorreoId;
    }

    public void setMailByCuentaCorreoId(Collection<MailEntity> mailByCuentaCorreoId) {
        this.mailByCuentaCorreoId = mailByCuentaCorreoId;
    }

    @OneToMany(mappedBy = "cuentaCorreoByCuentaCorreoId")
    public Collection<ParticipanteEntity> getParticipantesByCuentaCorreoId() {
        return participantesByCuentaCorreoId;
    }

    public void setParticipantesByCuentaCorreoId(Collection<ParticipanteEntity> participantesByCuentaCorreoId) {
        this.participantesByCuentaCorreoId = participantesByCuentaCorreoId;
    }

    @OneToMany(mappedBy = "cuentaCorreoByCuentaCorreoId")
    public Collection<SeguimientoMailEntity> getSeguimientoMailsByCuentaCorreoId() {
        return seguimientoMailsByCuentaCorreoId;
    }

    public void setSeguimientoMailsByCuentaCorreoId(Collection<SeguimientoMailEntity> seguimientoMailsByCuentaCorreoId) {
        this.seguimientoMailsByCuentaCorreoId = seguimientoMailsByCuentaCorreoId;
    }
}
