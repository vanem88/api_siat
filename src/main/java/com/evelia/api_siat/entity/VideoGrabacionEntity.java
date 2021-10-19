package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "VIDEO_GRABACION", schema = "datosEveliaMinimo", catalog = "")
public class VideoGrabacionEntity {
    @Id
    private long videoGrabacionId;
    private Long id;
    private String nombre;
    private Long videoconferenciaId;
    private VideoconferenciaEntity videoconferenciaByVideoconferenciaId;

    @Id
    @Column(name = "VIDEO_GRABACION_ID")
    public long getVideoGrabacionId() {
        return videoGrabacionId;
    }

    public void setVideoGrabacionId(long videoGrabacionId) {
        this.videoGrabacionId = videoGrabacionId;
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
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "VIDEOCONFERENCIA_ID")
    public Long getVideoconferenciaId() {
        return videoconferenciaId;
    }

    public void setVideoconferenciaId(Long videoconferenciaId) {
        this.videoconferenciaId = videoconferenciaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoGrabacionEntity that = (VideoGrabacionEntity) o;

        if (videoGrabacionId != that.videoGrabacionId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (videoconferenciaId != null ? !videoconferenciaId.equals(that.videoconferenciaId) : that.videoconferenciaId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (videoGrabacionId ^ (videoGrabacionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (videoconferenciaId != null ? videoconferenciaId.hashCode() : 0);
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
