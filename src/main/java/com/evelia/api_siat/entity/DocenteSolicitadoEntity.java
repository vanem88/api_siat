package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "DOCENTE_SOLICITADO", schema = "datosEveliaMinimo", catalog = "")
public class DocenteSolicitadoEntity {
    private long docenteSolicitadoId;
    private String apellido;
    private String numeroDoc;
    private String email;
    private Long id;
    private String interno;
    private String nombre;
    private String tipoDoc;
    private String emailSiat;
    private Byte quiereEmailSiat;
    private Long docenteRegistradoId;
    private PersonaEntity personaByDocenteRegistradoId;
    private Collection<SolicitudAulaEntity> solicitudAulasByDocenteSolicitadoId;
    private Collection<SolicitudDocenteAulaEntity> solicitudDocenteAulasByDocenteSolicitadoId;

    @Id
    @Column(name = "DOCENTE_SOLICITADO_ID")
    public long getDocenteSolicitadoId() {
        return docenteSolicitadoId;
    }

    public void setDocenteSolicitadoId(long docenteSolicitadoId) {
        this.docenteSolicitadoId = docenteSolicitadoId;
    }

    @Basic
    @Column(name = "APELLIDO")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "NUMERO_DOC")
    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "INTERNO")
    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
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
    @Column(name = "TIPO_DOC")
    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    @Basic
    @Column(name = "EMAIL_SIAT")
    public String getEmailSiat() {
        return emailSiat;
    }

    public void setEmailSiat(String emailSiat) {
        this.emailSiat = emailSiat;
    }

    @Basic
    @Column(name = "QUIERE_EMAIL_SIAT")
    public Byte getQuiereEmailSiat() {
        return quiereEmailSiat;
    }

    public void setQuiereEmailSiat(Byte quiereEmailSiat) {
        this.quiereEmailSiat = quiereEmailSiat;
    }

    @Basic
    @Column(name = "DOCENTE_REGISTRADO_ID")
    public Long getDocenteRegistradoId() {
        return docenteRegistradoId;
    }

    public void setDocenteRegistradoId(Long docenteRegistradoId) {
        this.docenteRegistradoId = docenteRegistradoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocenteSolicitadoEntity that = (DocenteSolicitadoEntity) o;

        if (docenteSolicitadoId != that.docenteSolicitadoId) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (numeroDoc != null ? !numeroDoc.equals(that.numeroDoc) : that.numeroDoc != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (interno != null ? !interno.equals(that.interno) : that.interno != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (tipoDoc != null ? !tipoDoc.equals(that.tipoDoc) : that.tipoDoc != null) return false;
        if (emailSiat != null ? !emailSiat.equals(that.emailSiat) : that.emailSiat != null) return false;
        if (quiereEmailSiat != null ? !quiereEmailSiat.equals(that.quiereEmailSiat) : that.quiereEmailSiat != null)
            return false;
        if (docenteRegistradoId != null ? !docenteRegistradoId.equals(that.docenteRegistradoId) : that.docenteRegistradoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (docenteSolicitadoId ^ (docenteSolicitadoId >>> 32));
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (numeroDoc != null ? numeroDoc.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (interno != null ? interno.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (tipoDoc != null ? tipoDoc.hashCode() : 0);
        result = 31 * result + (emailSiat != null ? emailSiat.hashCode() : 0);
        result = 31 * result + (quiereEmailSiat != null ? quiereEmailSiat.hashCode() : 0);
        result = 31 * result + (docenteRegistradoId != null ? docenteRegistradoId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "DOCENTE_REGISTRADO_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByDocenteRegistradoId() {
        return personaByDocenteRegistradoId;
    }

    public void setPersonaByDocenteRegistradoId(PersonaEntity personaByDocenteRegistradoId) {
        this.personaByDocenteRegistradoId = personaByDocenteRegistradoId;
    }

    @OneToMany(mappedBy = "docenteSolicitadoByResponsableId")
    public Collection<SolicitudAulaEntity> getSolicitudAulasByDocenteSolicitadoId() {
        return solicitudAulasByDocenteSolicitadoId;
    }

    public void setSolicitudAulasByDocenteSolicitadoId(Collection<SolicitudAulaEntity> solicitudAulasByDocenteSolicitadoId) {
        this.solicitudAulasByDocenteSolicitadoId = solicitudAulasByDocenteSolicitadoId;
    }

    @OneToMany(mappedBy = "docenteSolicitadoByDocenteSolicitadoId")
    public Collection<SolicitudDocenteAulaEntity> getSolicitudDocenteAulasByDocenteSolicitadoId() {
        return solicitudDocenteAulasByDocenteSolicitadoId;
    }

    public void setSolicitudDocenteAulasByDocenteSolicitadoId(Collection<SolicitudDocenteAulaEntity> solicitudDocenteAulasByDocenteSolicitadoId) {
        this.solicitudDocenteAulasByDocenteSolicitadoId = solicitudDocenteAulasByDocenteSolicitadoId;
    }
}
