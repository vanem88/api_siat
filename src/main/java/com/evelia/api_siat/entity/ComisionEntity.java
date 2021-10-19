package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "COMISION", schema = "datosEveliaMinimo", catalog = "")
public class ComisionEntity {
    private long comisionId;
    private Long cuentaTutorId;
    private int cupo;
    private Collection<ClonarInfoComisionEntity> clonarInfoComisionsByComisionId;
    private AulaEntity aulaByComisionId;
    private GrupoEntity grupoByComisionId;
    private Collection<ParticipanteComisionEntity> participanteComisionsByComisionId;

    @Id
    @Column(name = "COMISION_ID")
    public long getComisionId() {
        return comisionId;
    }

    public void setComisionId(long comisionId) {
        this.comisionId = comisionId;
    }

    @Basic
    @Column(name = "CUENTA_TUTOR_ID")
    public Long getCuentaTutorId() {
        return cuentaTutorId;
    }

    public void setCuentaTutorId(Long cuentaTutorId) {
        this.cuentaTutorId = cuentaTutorId;
    }

    @Basic
    @Column(name = "CUPO")
    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComisionEntity that = (ComisionEntity) o;

        if (comisionId != that.comisionId) return false;
        if (cupo != that.cupo) return false;
        if (cuentaTutorId != null ? !cuentaTutorId.equals(that.cuentaTutorId) : that.cuentaTutorId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (comisionId ^ (comisionId >>> 32));
        result = 31 * result + (cuentaTutorId != null ? cuentaTutorId.hashCode() : 0);
        result = 31 * result + cupo;
        return result;
    }

    @OneToMany(mappedBy = "comisionByComisionOrigenId")
    public Collection<ClonarInfoComisionEntity> getClonarInfoComisionsByComisionId() {
        return clonarInfoComisionsByComisionId;
    }

    public void setClonarInfoComisionsByComisionId(Collection<ClonarInfoComisionEntity> clonarInfoComisionsByComisionId) {
        this.clonarInfoComisionsByComisionId = clonarInfoComisionsByComisionId;
    }

    @OneToOne
    @JoinColumn(name = "COMISION_ID", referencedColumnName = "AULA_ID", nullable = false, insertable=false, updatable=false)
    public AulaEntity getAulaByComisionId() {
        return aulaByComisionId;
    }

    public void setAulaByComisionId(AulaEntity aulaByComisionId) {
        this.aulaByComisionId = aulaByComisionId;
    }

    @OneToOne(mappedBy = "comisionByGrupoId")
    public GrupoEntity getGrupoByComisionId() {
        return grupoByComisionId;
    }

    public void setGrupoByComisionId(GrupoEntity grupoByComisionId) {
        this.grupoByComisionId = grupoByComisionId;
    }

    @OneToMany(mappedBy = "comisionByComisionId")
    public Collection<ParticipanteComisionEntity> getParticipanteComisionsByComisionId() {
        return participanteComisionsByComisionId;
    }

    public void setParticipanteComisionsByComisionId(Collection<ParticipanteComisionEntity> participanteComisionsByComisionId) {
        this.participanteComisionsByComisionId = participanteComisionsByComisionId;
    }
}
