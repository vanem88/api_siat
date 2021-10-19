package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "VIDEOCONFERENCIA_COMPARTIR", schema = "datosEveliaMinimo", catalog = "")
public class VideoconferenciaCompartirEntity {
    private long videoconferenciaCompartirId;
    private Long id;
    private String nombrePersona;
    private String mailPersona;
    private String nombreSala;
    private boolean moderador;
    private Long videoconferenciaId;
    private Timestamp fecha;
    private VideoconferenciaEntity videoconferenciaByVideoconferenciaId;

    @Id
    @Column(name = "VIDEOCONFERENCIA_COMPARTIR_ID")
    public long getVideoconferenciaCompartirId() {
        return videoconferenciaCompartirId;
    }

    public void setVideoconferenciaCompartirId(long videoconferenciaCompartirId) {
        this.videoconferenciaCompartirId = videoconferenciaCompartirId;
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
    @Column(name = "NOMBRE_PERSONA")
    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    @Basic
    @Column(name = "MAIL_PERSONA")
    public String getMailPersona() {
        return mailPersona;
    }

    public void setMailPersona(String mailPersona) {
        this.mailPersona = mailPersona;
    }

    @Basic
    @Column(name = "NOMBRE_SALA")
    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    @Basic
    @Column(name = "MODERADOR")
    public boolean isModerador() {
        return moderador;
    }

    public void setModerador(boolean moderador) {
        this.moderador = moderador;
    }

    @Basic
    @Column(name = "VIDEOCONFERENCIA_ID")
    public Long getVideoconferenciaId() {
        return videoconferenciaId;
    }

    public void setVideoconferenciaId(Long videoconferenciaId) {
        this.videoconferenciaId = videoconferenciaId;
    }

    @Basic
    @Column(name = "FECHA")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoconferenciaCompartirEntity that = (VideoconferenciaCompartirEntity) o;

        if (videoconferenciaCompartirId != that.videoconferenciaCompartirId) return false;
        if (moderador != that.moderador) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombrePersona != null ? !nombrePersona.equals(that.nombrePersona) : that.nombrePersona != null)
            return false;
        if (mailPersona != null ? !mailPersona.equals(that.mailPersona) : that.mailPersona != null) return false;
        if (nombreSala != null ? !nombreSala.equals(that.nombreSala) : that.nombreSala != null) return false;
        if (videoconferenciaId != null ? !videoconferenciaId.equals(that.videoconferenciaId) : that.videoconferenciaId != null)
            return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (videoconferenciaCompartirId ^ (videoconferenciaCompartirId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombrePersona != null ? nombrePersona.hashCode() : 0);
        result = 31 * result + (mailPersona != null ? mailPersona.hashCode() : 0);
        result = 31 * result + (nombreSala != null ? nombreSala.hashCode() : 0);
        result = 31 * result + (moderador ? 1 : 0);
        result = 31 * result + (videoconferenciaId != null ? videoconferenciaId.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "VIDEOCONFERENCIA_ID", referencedColumnName = "VIDEOCONFERENCIA_ID", insertable=false, updatable=false)
    public VideoconferenciaEntity getVideoconferenciaByVideoconferenciaId() {
        return videoconferenciaByVideoconferenciaId;
    }

    public void setVideoconferenciaByVideoconferenciaId(VideoconferenciaEntity videoconferenciaByVideoconferenciaId) {
        this.videoconferenciaByVideoconferenciaId = videoconferenciaByVideoconferenciaId;
    }
}
