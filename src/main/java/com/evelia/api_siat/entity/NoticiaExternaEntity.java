package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "NOTICIA_EXTERNA", schema = "datosEveliaMinimo", catalog = "")
public class NoticiaExternaEntity {
    @Id
    private long noticiaExternaId;
    private Long id;
    private Timestamp fechaDesde;
    private Timestamp fechaHasta;
    private String tituloPpal;
    private Long archivoId;
    private String tituloLeerMas;
    private byte[] contenidoLeerMas;
    private Integer orden;
    private String enlace;
    private ArchivoEntity archivoByArchivoId;

    @Id
    @Column(name = "NOTICIA_EXTERNA_ID")
    public long getNoticiaExternaId() {
        return noticiaExternaId;
    }

    public void setNoticiaExternaId(long noticiaExternaId) {
        this.noticiaExternaId = noticiaExternaId;
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
    @Column(name = "FECHA_DESDE")
    public Timestamp getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Timestamp fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    @Basic
    @Column(name = "FECHA_HASTA")
    public Timestamp getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Timestamp fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Basic
    @Column(name = "TITULO_PPAL")
    public String getTituloPpal() {
        return tituloPpal;
    }

    public void setTituloPpal(String tituloPpal) {
        this.tituloPpal = tituloPpal;
    }

    @Basic
    @Column(name = "ARCHIVO_ID")
    public Long getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(Long archivoId) {
        this.archivoId = archivoId;
    }

    @Basic
    @Column(name = "TITULO_LEER_MAS")
    public String getTituloLeerMas() {
        return tituloLeerMas;
    }

    public void setTituloLeerMas(String tituloLeerMas) {
        this.tituloLeerMas = tituloLeerMas;
    }

    @Basic
    @Column(name = "CONTENIDO_LEER_MAS")
    public byte[] getContenidoLeerMas() {
        return contenidoLeerMas;
    }

    public void setContenidoLeerMas(byte[] contenidoLeerMas) {
        this.contenidoLeerMas = contenidoLeerMas;
    }

    @Basic
    @Column(name = "ORDEN")
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Basic
    @Column(name = "ENLACE")
    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoticiaExternaEntity that = (NoticiaExternaEntity) o;

        if (noticiaExternaId != that.noticiaExternaId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fechaDesde != null ? !fechaDesde.equals(that.fechaDesde) : that.fechaDesde != null) return false;
        if (fechaHasta != null ? !fechaHasta.equals(that.fechaHasta) : that.fechaHasta != null) return false;
        if (tituloPpal != null ? !tituloPpal.equals(that.tituloPpal) : that.tituloPpal != null) return false;
        if (archivoId != null ? !archivoId.equals(that.archivoId) : that.archivoId != null) return false;
        if (tituloLeerMas != null ? !tituloLeerMas.equals(that.tituloLeerMas) : that.tituloLeerMas != null)
            return false;
        if (!Arrays.equals(contenidoLeerMas, that.contenidoLeerMas)) return false;
        if (orden != null ? !orden.equals(that.orden) : that.orden != null) return false;
        if (enlace != null ? !enlace.equals(that.enlace) : that.enlace != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (noticiaExternaId ^ (noticiaExternaId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (fechaDesde != null ? fechaDesde.hashCode() : 0);
        result = 31 * result + (fechaHasta != null ? fechaHasta.hashCode() : 0);
        result = 31 * result + (tituloPpal != null ? tituloPpal.hashCode() : 0);
        result = 31 * result + (archivoId != null ? archivoId.hashCode() : 0);
        result = 31 * result + (tituloLeerMas != null ? tituloLeerMas.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(contenidoLeerMas);
        result = 31 * result + (orden != null ? orden.hashCode() : 0);
        result = 31 * result + (enlace != null ? enlace.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ARCHIVO_ID", referencedColumnName = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoId() {
        return archivoByArchivoId;
    }

    public void setArchivoByArchivoId(ArchivoEntity archivoByArchivoId) {
        this.archivoByArchivoId = archivoByArchivoId;
    }
}
