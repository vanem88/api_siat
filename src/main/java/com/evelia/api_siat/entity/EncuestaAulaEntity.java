package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "ENCUESTA_AULA", schema = "datosEveliaMinimo", catalog = "")
public class EncuestaAulaEntity {
    private long encuestaAulaId;
    private Long aulaId;
    private Long encuestaId;
    private Long id;
    private AulaEntity aulaByAulaId;
    private EncuestaEntity encuestaByEncuestaId;

    @Id
    @Column(name = "ENCUESTA_AULA_ID")
    public long getEncuestaAulaId() {
        return encuestaAulaId;
    }

    public void setEncuestaAulaId(long encuestaAulaId) {
        this.encuestaAulaId = encuestaAulaId;
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
    @Column(name = "ENCUESTA_ID")
    public Long getEncuestaId() {
        return encuestaId;
    }

    public void setEncuestaId(Long encuestaId) {
        this.encuestaId = encuestaId;
    }

    @Basic
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EncuestaAulaEntity that = (EncuestaAulaEntity) o;

        if (encuestaAulaId != that.encuestaAulaId) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (encuestaId != null ? !encuestaId.equals(that.encuestaId) : that.encuestaId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (encuestaAulaId ^ (encuestaAulaId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (encuestaId != null ? encuestaId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
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
    @JoinColumn(name = "ENCUESTA_ID", referencedColumnName = "ENCUESTA_ID", insertable=false, updatable=false)
    public EncuestaEntity getEncuestaByEncuestaId() {
        return encuestaByEncuestaId;
    }

    public void setEncuestaByEncuestaId(EncuestaEntity encuestaByEncuestaId) {
        this.encuestaByEncuestaId = encuestaByEncuestaId;
    }
}
