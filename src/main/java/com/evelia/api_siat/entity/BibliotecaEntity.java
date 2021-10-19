package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "BIBLIOTECA", schema = "datosEveliaMinimo", catalog = "")
public class BibliotecaEntity {
    private long bibliotecaId;
    private Long aulaId;
    private LinkEntity linkByBibliotecaId;
    private AulaEntity aulaByAulaId;

    @Id
    @Column(name = "BIBLIOTECA_ID")
    public long getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(long bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
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

        BibliotecaEntity that = (BibliotecaEntity) o;

        if (bibliotecaId != that.bibliotecaId) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (bibliotecaId ^ (bibliotecaId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "BIBLIOTECA_ID", referencedColumnName = "LINK_ID", nullable = false, insertable=false, updatable=false)
    public LinkEntity getLinkByBibliotecaId() {
        return linkByBibliotecaId;
    }

    public void setLinkByBibliotecaId(LinkEntity linkByBibliotecaId) {
        this.linkByBibliotecaId = linkByBibliotecaId;
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
