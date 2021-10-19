package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "RED_SOCIAL_RECURSO", schema = "datosEveliaMinimo", catalog = "")
public class RedSocialRecursoEntity {
    private long redSocialRecursoId;
    private Long id;
    private Boolean recursoFacebook;
    private Boolean recursoTwitter;
    private Long recursoId;
    private Long aulaId;
    private RecursoEntity recursoByRecursoId;
    private AulaEntity aulaByAulaId;

    @Id
    @Column(name = "RED_SOCIAL_RECURSO_ID")
    public long getRedSocialRecursoId() {
        return redSocialRecursoId;
    }

    public void setRedSocialRecursoId(long redSocialRecursoId) {
        this.redSocialRecursoId = redSocialRecursoId;
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
    @Column(name = "RECURSO_FACEBOOK")
    public Boolean getRecursoFacebook() {
        return recursoFacebook;
    }

    public void setRecursoFacebook(Boolean recursoFacebook) {
        this.recursoFacebook = recursoFacebook;
    }

    @Basic
    @Column(name = "RECURSO_TWITTER")
    public Boolean getRecursoTwitter() {
        return recursoTwitter;
    }

    public void setRecursoTwitter(Boolean recursoTwitter) {
        this.recursoTwitter = recursoTwitter;
    }

    @Basic
    @Column(name = "RECURSO_ID")
    public Long getRecursoId() {
        return recursoId;
    }

    public void setRecursoId(Long recursoId) {
        this.recursoId = recursoId;
    }

    @Basic
    @Column(name = "AULA_ID")
    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RedSocialRecursoEntity that = (RedSocialRecursoEntity) o;

        if (redSocialRecursoId != that.redSocialRecursoId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recursoFacebook != null ? !recursoFacebook.equals(that.recursoFacebook) : that.recursoFacebook != null)
            return false;
        if (recursoTwitter != null ? !recursoTwitter.equals(that.recursoTwitter) : that.recursoTwitter != null)
            return false;
        if (recursoId != null ? !recursoId.equals(that.recursoId) : that.recursoId != null) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (redSocialRecursoId ^ (redSocialRecursoId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (recursoFacebook != null ? recursoFacebook.hashCode() : 0);
        result = 31 * result + (recursoTwitter != null ? recursoTwitter.hashCode() : 0);
        result = 31 * result + (recursoId != null ? recursoId.hashCode() : 0);
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "RECURSO_ID", referencedColumnName = "RECURSO_ID", insertable=false, updatable=false)
    public RecursoEntity getRecursoByRecursoId() {
        return recursoByRecursoId;
    }

    public void setRecursoByRecursoId(RecursoEntity recursoByRecursoId) {
        this.recursoByRecursoId = recursoByRecursoId;
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
