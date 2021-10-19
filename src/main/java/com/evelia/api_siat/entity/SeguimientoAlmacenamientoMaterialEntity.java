package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SEGUIMIENTO_ALMACENAMIENTO_MATERIAL", schema = "datosEveliaMinimo", catalog = "")
public class SeguimientoAlmacenamientoMaterialEntity {
    private long seguimientoAlmacenamientoMaterialId;
    private long responsableId;
    private Long personaId;
    private Long aulaId;
    private Timestamp fecha;
    private Long id;
    private boolean almacenamientoPersonal;
    private Double limiteNuevo;
    private Double limiteAnterior;
    private String nivel;
    private boolean ultimoCambio;
    private boolean solicitud;
    private PersonaEntity personaByResponsableId;
    private PersonaEntity personaByPersonaId;
    private AulaEntity aulaByAulaId;

    @Id
    @Column(name = "SEGUIMIENTO_ALMACENAMIENTO_MATERIAL_ID")
    public long getSeguimientoAlmacenamientoMaterialId() {
        return seguimientoAlmacenamientoMaterialId;
    }

    public void setSeguimientoAlmacenamientoMaterialId(long seguimientoAlmacenamientoMaterialId) {
        this.seguimientoAlmacenamientoMaterialId = seguimientoAlmacenamientoMaterialId;
    }

    @Basic
    @Column(name = "RESPONSABLE_ID")
    public long getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(long responsableId) {
        this.responsableId = responsableId;
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
    @Column(name = "FECHA")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
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
    @Column(name = "ALMACENAMIENTO_PERSONAL")
    public boolean isAlmacenamientoPersonal() {
        return almacenamientoPersonal;
    }

    public void setAlmacenamientoPersonal(boolean almacenamientoPersonal) {
        this.almacenamientoPersonal = almacenamientoPersonal;
    }

    @Basic
    @Column(name = "LIMITE_NUEVO")
    public Double getLimiteNuevo() {
        return limiteNuevo;
    }

    public void setLimiteNuevo(Double limiteNuevo) {
        this.limiteNuevo = limiteNuevo;
    }

    @Basic
    @Column(name = "LIMITE_ANTERIOR")
    public Double getLimiteAnterior() {
        return limiteAnterior;
    }

    public void setLimiteAnterior(Double limiteAnterior) {
        this.limiteAnterior = limiteAnterior;
    }

    @Basic
    @Column(name = "NIVEL")
    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Basic
    @Column(name = "ULTIMO_CAMBIO")
    public boolean isUltimoCambio() {
        return ultimoCambio;
    }

    public void setUltimoCambio(boolean ultimoCambio) {
        this.ultimoCambio = ultimoCambio;
    }

    @Basic
    @Column(name = "SOLICITUD")
    public boolean isSolicitud() {
        return solicitud;
    }

    public void setSolicitud(boolean solicitud) {
        this.solicitud = solicitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeguimientoAlmacenamientoMaterialEntity that = (SeguimientoAlmacenamientoMaterialEntity) o;

        if (seguimientoAlmacenamientoMaterialId != that.seguimientoAlmacenamientoMaterialId) return false;
        if (responsableId != that.responsableId) return false;
        if (almacenamientoPersonal != that.almacenamientoPersonal) return false;
        if (ultimoCambio != that.ultimoCambio) return false;
        if (solicitud != that.solicitud) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (limiteNuevo != null ? !limiteNuevo.equals(that.limiteNuevo) : that.limiteNuevo != null) return false;
        if (limiteAnterior != null ? !limiteAnterior.equals(that.limiteAnterior) : that.limiteAnterior != null)
            return false;
        if (nivel != null ? !nivel.equals(that.nivel) : that.nivel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seguimientoAlmacenamientoMaterialId ^ (seguimientoAlmacenamientoMaterialId >>> 32));
        result = 31 * result + (int) (responsableId ^ (responsableId >>> 32));
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (almacenamientoPersonal ? 1 : 0);
        result = 31 * result + (limiteNuevo != null ? limiteNuevo.hashCode() : 0);
        result = 31 * result + (limiteAnterior != null ? limiteAnterior.hashCode() : 0);
        result = 31 * result + (nivel != null ? nivel.hashCode() : 0);
        result = 31 * result + (ultimoCambio ? 1 : 0);
        result = 31 * result + (solicitud ? 1 : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "RESPONSABLE_ID", referencedColumnName = "PERSONA_ID", nullable = false, insertable=false, updatable=false)
    public PersonaEntity getPersonaByResponsableId() {
        return personaByResponsableId;
    }

    public void setPersonaByResponsableId(PersonaEntity personaByResponsableId) {
        this.personaByResponsableId = personaByResponsableId;
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
    @JoinColumn(name = "AULA_ID", referencedColumnName = "AULA_ID", insertable=false, updatable=false)
    public AulaEntity getAulaByAulaId() {
        return aulaByAulaId;
    }

    public void setAulaByAulaId(AulaEntity aulaByAulaId) {
        this.aulaByAulaId = aulaByAulaId;
    }
}
