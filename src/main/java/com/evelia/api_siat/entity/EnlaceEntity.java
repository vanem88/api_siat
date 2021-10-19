package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "ENLACE", schema = "datosEveliaMinimo", catalog = "")
public class EnlaceEntity {
    private long enlaceId;
    private Long aulaId;
    private LinkEntity linkByEnlaceId;
    private AulaEntity aulaByAulaId;

    @Id
    @Column(name = "ENLACE_ID")
    public long getEnlaceId() {
        return enlaceId;
    }

    public void setEnlaceId(long enlaceId) {
        this.enlaceId = enlaceId;
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

        EnlaceEntity that = (EnlaceEntity) o;

        if (enlaceId != that.enlaceId) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (enlaceId ^ (enlaceId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "ENLACE_ID", referencedColumnName = "LINK_ID", nullable = false)
    public LinkEntity getLinkByEnlaceId() {
        return linkByEnlaceId;
    }

    public void setLinkByEnlaceId(LinkEntity linkByEnlaceId) {
        this.linkByEnlaceId = linkByEnlaceId;
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
