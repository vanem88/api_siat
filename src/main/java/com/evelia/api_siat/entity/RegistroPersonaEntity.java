package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "REGISTRO_PERSONA", schema = "datosEveliaMinimo", catalog = "")
public class RegistroPersonaEntity {
    private long registroPersonaId;
    private String nombre;
    private String apellido;
    private Long id;
    private String tipoDoc;
    private String numeroDoc;
    private String nacionalidad;
    private Timestamp fechaRegistro;
    private Long ciudadId;
    private String email;
    private Long inscribirEnId;
    private CiudadEntity ciudadByCiudadId;
    private AulaEntity aulaByInscribirEnId;

    @Id
    @Column(name = "REGISTRO_PERSONA_ID")
    public long getRegistroPersonaId() {
        return registroPersonaId;
    }

    public void setRegistroPersonaId(long registroPersonaId) {
        this.registroPersonaId = registroPersonaId;
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
    @Column(name = "APELLIDO")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
    @Column(name = "TIPO_DOC")
    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
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
    @Column(name = "NACIONALIDAD")
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Basic
    @Column(name = "FECHA_REGISTRO")
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Basic
    @Column(name = "CIUDAD_ID")
    public Long getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Long ciudadId) {
        this.ciudadId = ciudadId;
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
    @Column(name = "INSCRIBIR_EN_ID")
    public Long getInscribirEnId() {
        return inscribirEnId;
    }

    public void setInscribirEnId(Long inscribirEnId) {
        this.inscribirEnId = inscribirEnId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistroPersonaEntity that = (RegistroPersonaEntity) o;

        if (registroPersonaId != that.registroPersonaId) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipoDoc != null ? !tipoDoc.equals(that.tipoDoc) : that.tipoDoc != null) return false;
        if (numeroDoc != null ? !numeroDoc.equals(that.numeroDoc) : that.numeroDoc != null) return false;
        if (nacionalidad != null ? !nacionalidad.equals(that.nacionalidad) : that.nacionalidad != null) return false;
        if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
            return false;
        if (ciudadId != null ? !ciudadId.equals(that.ciudadId) : that.ciudadId != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (inscribirEnId != null ? !inscribirEnId.equals(that.inscribirEnId) : that.inscribirEnId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (registroPersonaId ^ (registroPersonaId >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (tipoDoc != null ? tipoDoc.hashCode() : 0);
        result = 31 * result + (numeroDoc != null ? numeroDoc.hashCode() : 0);
        result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
        result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
        result = 31 * result + (ciudadId != null ? ciudadId.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (inscribirEnId != null ? inscribirEnId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CIUDAD_ID", referencedColumnName = "CIUDAD_ID", insertable=false, updatable=false)
    public CiudadEntity getCiudadByCiudadId() {
        return ciudadByCiudadId;
    }

    public void setCiudadByCiudadId(CiudadEntity ciudadByCiudadId) {
        this.ciudadByCiudadId = ciudadByCiudadId;
    }

    @ManyToOne
    @JoinColumn(name = "INSCRIBIR_EN_ID", referencedColumnName = "AULA_ID", insertable=false, updatable=false)
    public AulaEntity getAulaByInscribirEnId() {
        return aulaByInscribirEnId;
    }

    public void setAulaByInscribirEnId(AulaEntity aulaByInscribirEnId) {
        this.aulaByInscribirEnId = aulaByInscribirEnId;
    }
}
