package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "AULA_TIPO_USUARIO", schema = "datosEveliaMinimo", catalog = "")
public class AulaTipoUsuarioEntity {
    private long aulaTipoUsuarioId;
    private Long aulaId;
    private Long id;
    private Integer orden;
    private Long tipoUsuarioId;
    private String nomenclaturaSingular;
    private String nomenclaturaPlural;
    private AulaEntity aulaByAulaId;
    private TipoUsuarioEntity tipoUsuarioByTipoUsuarioId;

    @Id
    @Column(name = "AULA_TIPO_USUARIO_ID")
    public long getAulaTipoUsuarioId() {
        return aulaTipoUsuarioId;
    }

    public void setAulaTipoUsuarioId(long aulaTipoUsuarioId) {
        this.aulaTipoUsuarioId = aulaTipoUsuarioId;
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
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ORDEN")
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Basic
    @Column(name = "TIPO_USUARIO_ID")
    public Long getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Long tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    @Basic
    @Column(name = "NOMENCLATURA_SINGULAR")
    public String getNomenclaturaSingular() {
        return nomenclaturaSingular;
    }

    public void setNomenclaturaSingular(String nomenclaturaSingular) {
        this.nomenclaturaSingular = nomenclaturaSingular;
    }

    @Basic
    @Column(name = "NOMENCLATURA_PLURAL")
    public String getNomenclaturaPlural() {
        return nomenclaturaPlural;
    }

    public void setNomenclaturaPlural(String nomenclaturaPlural) {
        this.nomenclaturaPlural = nomenclaturaPlural;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AulaTipoUsuarioEntity that = (AulaTipoUsuarioEntity) o;

        if (aulaTipoUsuarioId != that.aulaTipoUsuarioId) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (orden != null ? !orden.equals(that.orden) : that.orden != null) return false;
        if (tipoUsuarioId != null ? !tipoUsuarioId.equals(that.tipoUsuarioId) : that.tipoUsuarioId != null)
            return false;
        if (nomenclaturaSingular != null ? !nomenclaturaSingular.equals(that.nomenclaturaSingular) : that.nomenclaturaSingular != null)
            return false;
        if (nomenclaturaPlural != null ? !nomenclaturaPlural.equals(that.nomenclaturaPlural) : that.nomenclaturaPlural != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (aulaTipoUsuarioId ^ (aulaTipoUsuarioId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (orden != null ? orden.hashCode() : 0);
        result = 31 * result + (tipoUsuarioId != null ? tipoUsuarioId.hashCode() : 0);
        result = 31 * result + (nomenclaturaSingular != null ? nomenclaturaSingular.hashCode() : 0);
        result = 31 * result + (nomenclaturaPlural != null ? nomenclaturaPlural.hashCode() : 0);
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
    @JoinColumn(name = "TIPO_USUARIO_ID", referencedColumnName = "TIPO_USUARIO_ID", insertable=false, updatable=false)
    public TipoUsuarioEntity getTipoUsuarioByTipoUsuarioId() {
        return tipoUsuarioByTipoUsuarioId;
    }

    public void setTipoUsuarioByTipoUsuarioId(TipoUsuarioEntity tipoUsuarioByTipoUsuarioId) {
        this.tipoUsuarioByTipoUsuarioId = tipoUsuarioByTipoUsuarioId;
    }
}
