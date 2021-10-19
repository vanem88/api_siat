package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "LECTURAS_FORO", schema = "datosEveliaMinimo", catalog = "")
public class LecturasForoEntity {
    private long lecturasForoId;
    private Timestamp fechaHora;
    private Long foroId;
    private Long id;
    private Long participanteId;
    private ForoEntity foroByForoId;
    private ParticipanteEntity participanteByParticipanteId;

    @Id
    @Column(name = "LECTURAS_FORO_ID")
    public long getLecturasForoId() {
        return lecturasForoId;
    }

    public void setLecturasForoId(long lecturasForoId) {
        this.lecturasForoId = lecturasForoId;
    }

    @Basic
    @Column(name = "FECHA_HORA")
    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Basic
    @Column(name = "FORO_ID")
    public Long getForoId() {
        return foroId;
    }

    public void setForoId(Long foroId) {
        this.foroId = foroId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LecturasForoEntity that = (LecturasForoEntity) o;

        if (lecturasForoId != that.lecturasForoId) return false;
        if (fechaHora != null ? !fechaHora.equals(that.fechaHora) : that.fechaHora != null) return false;
        if (foroId != null ? !foroId.equals(that.foroId) : that.foroId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (participanteId != null ? !participanteId.equals(that.participanteId) : that.participanteId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (lecturasForoId ^ (lecturasForoId >>> 32));
        result = 31 * result + (fechaHora != null ? fechaHora.hashCode() : 0);
        result = 31 * result + (foroId != null ? foroId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (participanteId != null ? participanteId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "FORO_ID", referencedColumnName = "FORO_ID", insertable=false, updatable=false)
    public ForoEntity getForoByForoId() {
        return foroByForoId;
    }

    public void setForoByForoId(ForoEntity foroByForoId) {
        this.foroByForoId = foroByForoId;
    }

    @ManyToOne
    @JoinColumn(name = "PARTICIPANTE_ID", referencedColumnName = "PARTICIPANTE_ID", insertable=false, updatable=false)
    public ParticipanteEntity getParticipanteByParticipanteId() {
        return participanteByParticipanteId;
    }

    public void setParticipanteByParticipanteId(ParticipanteEntity participanteByParticipanteId) {
        this.participanteByParticipanteId = participanteByParticipanteId;
    }
}
