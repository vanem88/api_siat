package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "ARCHIVO_COMPARTIDO_AULA", schema = "datosEveliaMinimo", catalog = "")
public class ArchivoCompartidoAulaEntity {
    private long archivoCompartidoAulaId;
    private Long archivoId;
    private Long aulaId;
    private Long carpetaId;
    private Boolean compartido;
    private Long id;
    private Long personaId;
    private ArchivoEntity archivoByArchivoId;
    private AulaEntity aulaByAulaId;
    private CarpetaEntity carpetaByCarpetaId;
    private PersonaEntity personaByPersonaId;

    @Id
    @Column(name = "ARCHIVO_COMPARTIDO_AULA_ID")
    public long getArchivoCompartidoAulaId() {
        return archivoCompartidoAulaId;
    }

    public void setArchivoCompartidoAulaId(long archivoCompartidoAulaId) {
        this.archivoCompartidoAulaId = archivoCompartidoAulaId;
    }

    @Basic
    @Column(name = "ARCHIVO_ID")
    public Long getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(Long archivoId) {
        this.archivoId = archivoId;
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
    @Column(name = "CARPETA_ID")
    public Long getCarpetaId() {
        return carpetaId;
    }

    public void setCarpetaId(Long carpetaId) {
        this.carpetaId = carpetaId;
    }

    @Basic
    @Column(name = "COMPARTIDO")
    public Boolean getCompartido() {
        return compartido;
    }

    public void setCompartido(Boolean compartido) {
        this.compartido = compartido;
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

        ArchivoCompartidoAulaEntity that = (ArchivoCompartidoAulaEntity) o;

        if (archivoCompartidoAulaId != that.archivoCompartidoAulaId) return false;
        if (archivoId != null ? !archivoId.equals(that.archivoId) : that.archivoId != null) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (carpetaId != null ? !carpetaId.equals(that.carpetaId) : that.carpetaId != null) return false;
        if (compartido != null ? !compartido.equals(that.compartido) : that.compartido != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (archivoCompartidoAulaId ^ (archivoCompartidoAulaId >>> 32));
        result = 31 * result + (archivoId != null ? archivoId.hashCode() : 0);
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (carpetaId != null ? carpetaId.hashCode() : 0);
        result = 31 * result + (compartido != null ? compartido.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ARCHIVO_ID", referencedColumnName = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoId() {
        return archivoByArchivoId;
    }

    public void setArchivoByArchivoId(ArchivoEntity archivoByArchivoId) {
        this.archivoByArchivoId = archivoByArchivoId;
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
    @JoinColumn(name = "CARPETA_ID", referencedColumnName = "CARPETA_ID", insertable=false, updatable=false)
    public CarpetaEntity getCarpetaByCarpetaId() {
        return carpetaByCarpetaId;
    }

    public void setCarpetaByCarpetaId(CarpetaEntity carpetaByCarpetaId) {
        this.carpetaByCarpetaId = carpetaByCarpetaId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
}
