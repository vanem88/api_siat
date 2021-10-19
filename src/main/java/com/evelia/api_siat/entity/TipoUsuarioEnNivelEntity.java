package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "TIPO_USUARIO_EN_NIVEL", schema = "datosEveliaMinimo", catalog = "")
public class TipoUsuarioEnNivelEntity {
    private long tipoUsuarioEnNivelId;
    private Long id;
    private Long tipoAulaId;
    private Long tipoUsuarioId;
    private TipoAulaEntity tipoAulaByTipoAulaId;
    private TipoUsuarioEntity tipoUsuarioByTipoUsuarioId;

    @Id
    @Column(name = "TIPO_USUARIO_EN_NIVEL_ID")
    public long getTipoUsuarioEnNivelId() {
        return tipoUsuarioEnNivelId;
    }

    public void setTipoUsuarioEnNivelId(long tipoUsuarioEnNivelId) {
        this.tipoUsuarioEnNivelId = tipoUsuarioEnNivelId;
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
    @Column(name = "TIPO_AULA_ID")
    public Long getTipoAulaId() {
        return tipoAulaId;
    }

    public void setTipoAulaId(Long tipoAulaId) {
        this.tipoAulaId = tipoAulaId;
    }

    @Basic
    @Column(name = "TIPO_USUARIO_ID")
    public Long getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Long tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoUsuarioEnNivelEntity that = (TipoUsuarioEnNivelEntity) o;

        if (tipoUsuarioEnNivelId != that.tipoUsuarioEnNivelId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipoAulaId != null ? !tipoAulaId.equals(that.tipoAulaId) : that.tipoAulaId != null) return false;
        if (tipoUsuarioId != null ? !tipoUsuarioId.equals(that.tipoUsuarioId) : that.tipoUsuarioId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoUsuarioEnNivelId ^ (tipoUsuarioEnNivelId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (tipoAulaId != null ? tipoAulaId.hashCode() : 0);
        result = 31 * result + (tipoUsuarioId != null ? tipoUsuarioId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_AULA_ID", referencedColumnName = "TIPO_AULA_ID", insertable=false, updatable=false)
    public TipoAulaEntity getTipoAulaByTipoAulaId() {
        return tipoAulaByTipoAulaId;
    }

    public void setTipoAulaByTipoAulaId(TipoAulaEntity tipoAulaByTipoAulaId) {
        this.tipoAulaByTipoAulaId = tipoAulaByTipoAulaId;
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
