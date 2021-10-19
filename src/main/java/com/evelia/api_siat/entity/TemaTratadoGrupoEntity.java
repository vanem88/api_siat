package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "TEMA_TRATADO_GRUPO", schema = "datosEveliaMinimo", catalog = "")
public class TemaTratadoGrupoEntity {
    private long temaTratadoGrupoId;
    private Long grupoId;
    private Long id;
    private Long temaId;
    private GrupoEntity grupoByGrupoId;
    private TemaEntity temaByTemaId;

    @Id
    @Column(name = "TEMA_TRATADO_GRUPO_ID")
    public long getTemaTratadoGrupoId() {
        return temaTratadoGrupoId;
    }

    public void setTemaTratadoGrupoId(long temaTratadoGrupoId) {
        this.temaTratadoGrupoId = temaTratadoGrupoId;
    }

    @Basic
    @Column(name = "GRUPO_ID")
    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
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
    @Column(name = "TEMA_ID")
    public Long getTemaId() {
        return temaId;
    }

    public void setTemaId(Long temaId) {
        this.temaId = temaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemaTratadoGrupoEntity that = (TemaTratadoGrupoEntity) o;

        if (temaTratadoGrupoId != that.temaTratadoGrupoId) return false;
        if (grupoId != null ? !grupoId.equals(that.grupoId) : that.grupoId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (temaId != null ? !temaId.equals(that.temaId) : that.temaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (temaTratadoGrupoId ^ (temaTratadoGrupoId >>> 32));
        result = 31 * result + (grupoId != null ? grupoId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (temaId != null ? temaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "GRUPO_ID", referencedColumnName = "GRUPO_ID", insertable=false, updatable=false)
    public GrupoEntity getGrupoByGrupoId() {
        return grupoByGrupoId;
    }

    public void setGrupoByGrupoId(GrupoEntity grupoByGrupoId) {
        this.grupoByGrupoId = grupoByGrupoId;
    }

    @ManyToOne
    @JoinColumn(name = "TEMA_ID", referencedColumnName = "TEMA_ID", insertable=false, updatable=false)
    public TemaEntity getTemaByTemaId() {
        return temaByTemaId;
    }

    public void setTemaByTemaId(TemaEntity temaByTemaId) {
        this.temaByTemaId = temaByTemaId;
    }
}
