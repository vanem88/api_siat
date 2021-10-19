package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ACCESO_SIAT", schema = "datosEveliaMinimo", catalog = "")
public class AccesoSiatEntity {
    private long accesoSiatId;
    private Integer ayer;
    private Timestamp fecha;
    private Integer hoy;
    private Long id;
    private Integer totalesHastaLaFecha;

    @Id
    @Column(name = "ACCESO_SIAT_ID")
    public long getAccesoSiatId() {
        return accesoSiatId;
    }

    public void setAccesoSiatId(long accesoSiatId) {
        this.accesoSiatId = accesoSiatId;
    }

    @Basic
    @Column(name = "AYER")
    public Integer getAyer() {
        return ayer;
    }

    public void setAyer(Integer ayer) {
        this.ayer = ayer;
    }

    @Basic
    @Column(name = "FECHA")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "HOY")
    public Integer getHoy() {
        return hoy;
    }

    public void setHoy(Integer hoy) {
        this.hoy = hoy;
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
    @Column(name = "TOTALES_HASTA_LA_FECHA")
    public Integer getTotalesHastaLaFecha() {
        return totalesHastaLaFecha;
    }

    public void setTotalesHastaLaFecha(Integer totalesHastaLaFecha) {
        this.totalesHastaLaFecha = totalesHastaLaFecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccesoSiatEntity that = (AccesoSiatEntity) o;

        if (accesoSiatId != that.accesoSiatId) return false;
        if (ayer != null ? !ayer.equals(that.ayer) : that.ayer != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (hoy != null ? !hoy.equals(that.hoy) : that.hoy != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (totalesHastaLaFecha != null ? !totalesHastaLaFecha.equals(that.totalesHastaLaFecha) : that.totalesHastaLaFecha != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (accesoSiatId ^ (accesoSiatId >>> 32));
        result = 31 * result + (ayer != null ? ayer.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (hoy != null ? hoy.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (totalesHastaLaFecha != null ? totalesHastaLaFecha.hashCode() : 0);
        return result;
    }
}
