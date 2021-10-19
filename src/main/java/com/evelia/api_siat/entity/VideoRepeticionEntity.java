package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "VIDEO_REPETICION", schema = "datosEveliaMinimo", catalog = "")
public class VideoRepeticionEntity {
    @Id
    private long videoRepeticionId;
    private Long id;
    private String tipoRepeticion;
    private Timestamp fechaInicio;
    private Timestamp fechaLimite;
    private boolean repDom;
    private boolean repLun;
    private boolean repMar;
    private boolean repMie;
    private boolean repJue;
    private boolean repVie;
    private boolean repSab;
    private Collection<VideoconferenciaEntity> videoconferenciasByVideoRepeticionId;

    @Id
    @Column(name = "VIDEO_REPETICION_ID")
    public long getVideoRepeticionId() {
        return videoRepeticionId;
    }

    public void setVideoRepeticionId(long videoRepeticionId) {
        this.videoRepeticionId = videoRepeticionId;
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
    @Column(name = "TIPO_REPETICION")
    public String getTipoRepeticion() {
        return tipoRepeticion;
    }

    public void setTipoRepeticion(String tipoRepeticion) {
        this.tipoRepeticion = tipoRepeticion;
    }

    @Basic
    @Column(name = "FECHA_INICIO")
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "FECHA_LIMITE")
    public Timestamp getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Timestamp fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    @Basic
    @Column(name = "REP_DOM")
    public boolean isRepDom() {
        return repDom;
    }

    public void setRepDom(boolean repDom) {
        this.repDom = repDom;
    }

    @Basic
    @Column(name = "REP_LUN")
    public boolean isRepLun() {
        return repLun;
    }

    public void setRepLun(boolean repLun) {
        this.repLun = repLun;
    }

    @Basic
    @Column(name = "REP_MAR")
    public boolean isRepMar() {
        return repMar;
    }

    public void setRepMar(boolean repMar) {
        this.repMar = repMar;
    }

    @Basic
    @Column(name = "REP_MIE")
    public boolean isRepMie() {
        return repMie;
    }

    public void setRepMie(boolean repMie) {
        this.repMie = repMie;
    }

    @Basic
    @Column(name = "REP_JUE")
    public boolean isRepJue() {
        return repJue;
    }

    public void setRepJue(boolean repJue) {
        this.repJue = repJue;
    }

    @Basic
    @Column(name = "REP_VIE")
    public boolean isRepVie() {
        return repVie;
    }

    public void setRepVie(boolean repVie) {
        this.repVie = repVie;
    }

    @Basic
    @Column(name = "REP_SAB")
    public boolean isRepSab() {
        return repSab;
    }

    public void setRepSab(boolean repSab) {
        this.repSab = repSab;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoRepeticionEntity that = (VideoRepeticionEntity) o;

        if (videoRepeticionId != that.videoRepeticionId) return false;
        if (repDom != that.repDom) return false;
        if (repLun != that.repLun) return false;
        if (repMar != that.repMar) return false;
        if (repMie != that.repMie) return false;
        if (repJue != that.repJue) return false;
        if (repVie != that.repVie) return false;
        if (repSab != that.repSab) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipoRepeticion != null ? !tipoRepeticion.equals(that.tipoRepeticion) : that.tipoRepeticion != null)
            return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaLimite != null ? !fechaLimite.equals(that.fechaLimite) : that.fechaLimite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (videoRepeticionId ^ (videoRepeticionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (tipoRepeticion != null ? tipoRepeticion.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaLimite != null ? fechaLimite.hashCode() : 0);
        result = 31 * result + (repDom ? 1 : 0);
        result = 31 * result + (repLun ? 1 : 0);
        result = 31 * result + (repMar ? 1 : 0);
        result = 31 * result + (repMie ? 1 : 0);
        result = 31 * result + (repJue ? 1 : 0);
        result = 31 * result + (repVie ? 1 : 0);
        result = 31 * result + (repSab ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "videoRepeticionByVideoRepeticionId")
    public Collection<VideoconferenciaEntity> getVideoconferenciasByVideoRepeticionId() {
        return videoconferenciasByVideoRepeticionId;
    }

    public void setVideoconferenciasByVideoRepeticionId(Collection<VideoconferenciaEntity> videoconferenciasByVideoRepeticionId) {
        this.videoconferenciasByVideoRepeticionId = videoconferenciasByVideoRepeticionId;
    }
}
