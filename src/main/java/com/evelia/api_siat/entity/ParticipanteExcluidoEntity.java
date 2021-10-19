package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "PARTICIPANTE_EXCLUIDO", schema = "datosEveliaMinimo", catalog = "")
public class ParticipanteExcluidoEntity {
    private long participanteExcluidoId;
    private Timestamp fechaAltaExclusion;
    private Timestamp fechaUltimoAcceso;
    private Long grupoId;
    private Long id;
    private Long participanteId;
    private Long tipoExclusionId;
    private GrupoEntity grupoByGrupoId;
    private ParticipanteEntity participanteByParticipanteId;
    private TipoExclusionEntity tipoExclusionByTipoExclusionId;

    @Id
    @Column(name = "PARTICIPANTE_EXCLUIDO_ID")
    public long getParticipanteExcluidoId() {
        return participanteExcluidoId;
    }

    public void setParticipanteExcluidoId(long participanteExcluidoId) {
        this.participanteExcluidoId = participanteExcluidoId;
    }

    @Basic
    @Column(name = "FECHA_ALTA_EXCLUSION")
    public Timestamp getFechaAltaExclusion() {
        return fechaAltaExclusion;
    }

    public void setFechaAltaExclusion(Timestamp fechaAltaExclusion) {
        this.fechaAltaExclusion = fechaAltaExclusion;
    }

    @Basic
    @Column(name = "FECHA_ULTIMO_ACCESO")
    public Timestamp getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(Timestamp fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
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
    @Column(name = "PARTICIPANTE_ID")
    public Long getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Long participanteId) {
        this.participanteId = participanteId;
    }

    @Basic
    @Column(name = "TIPO_EXCLUSION_ID")
    public Long getTipoExclusionId() {
        return tipoExclusionId;
    }

    public void setTipoExclusionId(Long tipoExclusionId) {
        this.tipoExclusionId = tipoExclusionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipanteExcluidoEntity that = (ParticipanteExcluidoEntity) o;

        if (participanteExcluidoId != that.participanteExcluidoId) return false;
        if (fechaAltaExclusion != null ? !fechaAltaExclusion.equals(that.fechaAltaExclusion) : that.fechaAltaExclusion != null)
            return false;
        if (fechaUltimoAcceso != null ? !fechaUltimoAcceso.equals(that.fechaUltimoAcceso) : that.fechaUltimoAcceso != null)
            return false;
        if (grupoId != null ? !grupoId.equals(that.grupoId) : that.grupoId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (participanteId != null ? !participanteId.equals(that.participanteId) : that.participanteId != null)
            return false;
        if (tipoExclusionId != null ? !tipoExclusionId.equals(that.tipoExclusionId) : that.tipoExclusionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (participanteExcluidoId ^ (participanteExcluidoId >>> 32));
        result = 31 * result + (fechaAltaExclusion != null ? fechaAltaExclusion.hashCode() : 0);
        result = 31 * result + (fechaUltimoAcceso != null ? fechaUltimoAcceso.hashCode() : 0);
        result = 31 * result + (grupoId != null ? grupoId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (participanteId != null ? participanteId.hashCode() : 0);
        result = 31 * result + (tipoExclusionId != null ? tipoExclusionId.hashCode() : 0);
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
    @JoinColumn(name = "PARTICIPANTE_ID", referencedColumnName = "PARTICIPANTE_ID", insertable=false, updatable=false)
    public ParticipanteEntity getParticipanteByParticipanteId() {
        return participanteByParticipanteId;
    }

    public void setParticipanteByParticipanteId(ParticipanteEntity participanteByParticipanteId) {
        this.participanteByParticipanteId = participanteByParticipanteId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_EXCLUSION_ID", referencedColumnName = "TIPO_EXCLUSION_ID", insertable=false, updatable=false)
    public TipoExclusionEntity getTipoExclusionByTipoExclusionId() {
        return tipoExclusionByTipoExclusionId;
    }

    public void setTipoExclusionByTipoExclusionId(TipoExclusionEntity tipoExclusionByTipoExclusionId) {
        this.tipoExclusionByTipoExclusionId = tipoExclusionByTipoExclusionId;
    }
}
