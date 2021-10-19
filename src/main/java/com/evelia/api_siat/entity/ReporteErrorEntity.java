package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "REPORTE_ERROR", schema = "datosEveliaMinimo", catalog = "")
public class ReporteErrorEntity {
    private long reporteErrorId;
    private Long id;
    private String mensajeError;
    private String clase;
    private String archivo;
    private String metodo;
    private int linea;
    private Timestamp fecha;
    private Integer cantidad;

    @Id
    @Column(name = "REPORTE_ERROR_ID")
    public long getReporteErrorId() {
        return reporteErrorId;
    }

    public void setReporteErrorId(long reporteErrorId) {
        this.reporteErrorId = reporteErrorId;
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
    @Column(name = "MENSAJE_ERROR")
    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Basic
    @Column(name = "CLASE")
    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Basic
    @Column(name = "ARCHIVO")
    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    @Basic
    @Column(name = "METODO")
    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    @Basic
    @Column(name = "LINEA")
    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
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
    @Column(name = "CANTIDAD")
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReporteErrorEntity that = (ReporteErrorEntity) o;

        if (reporteErrorId != that.reporteErrorId) return false;
        if (linea != that.linea) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (mensajeError != null ? !mensajeError.equals(that.mensajeError) : that.mensajeError != null) return false;
        if (clase != null ? !clase.equals(that.clase) : that.clase != null) return false;
        if (archivo != null ? !archivo.equals(that.archivo) : that.archivo != null) return false;
        if (metodo != null ? !metodo.equals(that.metodo) : that.metodo != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (cantidad != null ? !cantidad.equals(that.cantidad) : that.cantidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (reporteErrorId ^ (reporteErrorId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (mensajeError != null ? mensajeError.hashCode() : 0);
        result = 31 * result + (clase != null ? clase.hashCode() : 0);
        result = 31 * result + (archivo != null ? archivo.hashCode() : 0);
        result = 31 * result + (metodo != null ? metodo.hashCode() : 0);
        result = 31 * result + linea;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        return result;
    }
}
