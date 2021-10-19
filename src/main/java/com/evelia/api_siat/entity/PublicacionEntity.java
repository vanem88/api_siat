package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "PUBLICACION", schema = "datosEveliaMinimo", catalog = "")
public class PublicacionEntity {
    
    private long publicacionId;
    private Long id;
    private boolean borrador;
    private String tipoPublicacion;
    private Timestamp fechaApertura;
    private Timestamp fechaCierre;
    private String generadoPor;
    private String idsGenera;
    private ActividadEntity actividadByPublicacionId;
    private ForoEntity foroByPublicacionId;
    private TextoEntity textoByPublicacionId;
    private VideoconferenciaEntity videoconferenciaByPublicacionId;

    @Basic
    @Id
    @Column(name = "PUBLICACION_ID")
    public long getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(long publicacionId) {
        this.publicacionId = publicacionId;
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
    @Column(name = "BORRADOR")
    public boolean isBorrador() {
        return borrador;
    }

    public void setBorrador(boolean borrador) {
        this.borrador = borrador;
    }

    @Basic
    @Column(name = "TIPO_PUBLICACION")
    public String getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(String tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    @Basic
    @Column(name = "FECHA_APERTURA")
    public Timestamp getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Timestamp fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Basic
    @Column(name = "FECHA_CIERRE")
    public Timestamp getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Timestamp fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    @Basic
    @Column(name = "GENERADO_POR")
    public String getGeneradoPor() {
        return generadoPor;
    }

    public void setGeneradoPor(String generadoPor) {
        this.generadoPor = generadoPor;
    }

    @Basic
    @Column(name = "IDS_GENERA")
    public String getIdsGenera() {
        return idsGenera;
    }

    public void setIdsGenera(String idsGenera) {
        this.idsGenera = idsGenera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PublicacionEntity that = (PublicacionEntity) o;

        if (publicacionId != that.publicacionId) return false;
        if (borrador != that.borrador) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipoPublicacion != null ? !tipoPublicacion.equals(that.tipoPublicacion) : that.tipoPublicacion != null)
            return false;
        if (fechaApertura != null ? !fechaApertura.equals(that.fechaApertura) : that.fechaApertura != null)
            return false;
        if (fechaCierre != null ? !fechaCierre.equals(that.fechaCierre) : that.fechaCierre != null) return false;
        if (generadoPor != null ? !generadoPor.equals(that.generadoPor) : that.generadoPor != null) return false;
        if (idsGenera != null ? !idsGenera.equals(that.idsGenera) : that.idsGenera != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (publicacionId ^ (publicacionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (borrador ? 1 : 0);
        result = 31 * result + (tipoPublicacion != null ? tipoPublicacion.hashCode() : 0);
        result = 31 * result + (fechaApertura != null ? fechaApertura.hashCode() : 0);
        result = 31 * result + (fechaCierre != null ? fechaCierre.hashCode() : 0);
        result = 31 * result + (generadoPor != null ? generadoPor.hashCode() : 0);
        result = 31 * result + (idsGenera != null ? idsGenera.hashCode() : 0);
        return result;
    }

    //@ManyToOne
    @OneToOne
    @JoinColumn(name = "PUBLICACION_ID", referencedColumnName = "PUBLICACION_ID", nullable = false, insertable=false, updatable=false)
    public ActividadEntity getActividadByPublicacionId() {
        return actividadByPublicacionId;
    }

    public void setActividadByPublicacionId(ActividadEntity actividadByPublicacionId) {
        this.actividadByPublicacionId = actividadByPublicacionId;
    }

    //@ManyToOne
    @OneToOne
    @JoinColumn(name = "PUBLICACION_ID", referencedColumnName = "PUBLICACION_ID", nullable = false, insertable=false, updatable=false)
    public ForoEntity getForoByPublicacionId() {
        return foroByPublicacionId;
    }

    public void setForoByPublicacionId(ForoEntity foroByPublicacionId) {
        this.foroByPublicacionId = foroByPublicacionId;
    }

    //@ManyToOne
    @OneToOne
    @JoinColumn(name = "PUBLICACION_ID", referencedColumnName = "PUBLICACION_ID", nullable = false, insertable=false, updatable=false)
    public TextoEntity getTextoByPublicacionId() {
        return textoByPublicacionId;
    }

    public void setTextoByPublicacionId(TextoEntity textoByPublicacionId) {
        this.textoByPublicacionId = textoByPublicacionId;
    }

    //@ManyToOne
    @OneToOne
    @JoinColumn(name = "PUBLICACION_ID", referencedColumnName = "PUBLICACION_ID", nullable = false, insertable=false, updatable=false)
    public VideoconferenciaEntity getVideoconferenciaByPublicacionId() {
        return videoconferenciaByPublicacionId;
    }

    public void setVideoconferenciaByPublicacionId(VideoconferenciaEntity videoconferenciaByPublicacionId) {
        this.videoconferenciaByPublicacionId = videoconferenciaByPublicacionId;
    }
}
