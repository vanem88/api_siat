package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "AULA_HERRAMIENTA", schema = "datosEveliaMinimo", catalog = "")
public class AulaHerramientaEntity {
    private long aulaHerramientaId;
    private Long id;
    private Long aulaId;
    private Long tipoRecursoId;
    private AulaEntity aulaByAulaId;
    private TipoRecursoEntity tipoRecursoByTipoRecursoId;

    @Id
    @Column(name = "AULA_HERRAMIENTA_ID")
    public long getAulaHerramientaId() {
        return aulaHerramientaId;
    }

    public void setAulaHerramientaId(long aulaHerramientaId) {
        this.aulaHerramientaId = aulaHerramientaId;
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
    @Column(name = "AULA_ID")
    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }

    @Basic
    @Column(name = "TIPO_RECURSO_ID")
    public Long getTipoRecursoId() {
        return tipoRecursoId;
    }

    public void setTipoRecursoId(Long tipoRecursoId) {
        this.tipoRecursoId = tipoRecursoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AulaHerramientaEntity that = (AulaHerramientaEntity) o;

        if (aulaHerramientaId != that.aulaHerramientaId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (tipoRecursoId != null ? !tipoRecursoId.equals(that.tipoRecursoId) : that.tipoRecursoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (aulaHerramientaId ^ (aulaHerramientaId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (tipoRecursoId != null ? tipoRecursoId.hashCode() : 0);
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
    @JoinColumn(name = "TIPO_RECURSO_ID", referencedColumnName = "TIPO_RECURSO_ID", insertable=false, updatable=false)
    public TipoRecursoEntity getTipoRecursoByTipoRecursoId() {
        return tipoRecursoByTipoRecursoId;
    }

    public void setTipoRecursoByTipoRecursoId(TipoRecursoEntity tipoRecursoByTipoRecursoId) {
        this.tipoRecursoByTipoRecursoId = tipoRecursoByTipoRecursoId;
    }
}
