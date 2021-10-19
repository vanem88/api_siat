package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "SOLICITUD_CLAVE", schema = "datosEveliaMinimo", catalog = "")
public class SolicitudClaveEntity {
    private long solicitudClaveId;
    private Long id;
    private String estadoSolicitud;
    private String apellido;
    private String nombre;
    private String numeroDoc;
    private String email;
    private Long dniEscaneadoId;
    private Timestamp fechaSolicitud;
    private Timestamp fechaResuelto;
    private Long numeroPedido;
    private byte[] observacion;
    private ArchivoEntity archivoByDniEscaneadoId;

    @Id
    @Column(name = "SOLICITUD_CLAVE_ID")
    public long getSolicitudClaveId() {
        return solicitudClaveId;
    }

    public void setSolicitudClaveId(long solicitudClaveId) {
        this.solicitudClaveId = solicitudClaveId;
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
    @Column(name = "ESTADO_SOLICITUD")
    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    @Basic
    @Column(name = "APELLIDO")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
    @Column(name = "NUMERO_DOC")
    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "DNI_ESCANEADO_ID")
    public Long getDniEscaneadoId() {
        return dniEscaneadoId;
    }

    public void setDniEscaneadoId(Long dniEscaneadoId) {
        this.dniEscaneadoId = dniEscaneadoId;
    }

    @Basic
    @Column(name = "FECHA_SOLICITUD")
    public Timestamp getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Timestamp fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    @Basic
    @Column(name = "FECHA_RESUELTO")
    public Timestamp getFechaResuelto() {
        return fechaResuelto;
    }

    public void setFechaResuelto(Timestamp fechaResuelto) {
        this.fechaResuelto = fechaResuelto;
    }

    @Basic
    @Column(name = "NUMERO_PEDIDO")
    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    @Basic
    @Column(name = "OBSERVACION")
    public byte[] getObservacion() {
        return observacion;
    }

    public void setObservacion(byte[] observacion) {
        this.observacion = observacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SolicitudClaveEntity that = (SolicitudClaveEntity) o;

        if (solicitudClaveId != that.solicitudClaveId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (estadoSolicitud != null ? !estadoSolicitud.equals(that.estadoSolicitud) : that.estadoSolicitud != null)
            return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (numeroDoc != null ? !numeroDoc.equals(that.numeroDoc) : that.numeroDoc != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (dniEscaneadoId != null ? !dniEscaneadoId.equals(that.dniEscaneadoId) : that.dniEscaneadoId != null)
            return false;
        if (fechaSolicitud != null ? !fechaSolicitud.equals(that.fechaSolicitud) : that.fechaSolicitud != null)
            return false;
        if (fechaResuelto != null ? !fechaResuelto.equals(that.fechaResuelto) : that.fechaResuelto != null)
            return false;
        if (numeroPedido != null ? !numeroPedido.equals(that.numeroPedido) : that.numeroPedido != null) return false;
        if (!Arrays.equals(observacion, that.observacion)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (solicitudClaveId ^ (solicitudClaveId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (estadoSolicitud != null ? estadoSolicitud.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (numeroDoc != null ? numeroDoc.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dniEscaneadoId != null ? dniEscaneadoId.hashCode() : 0);
        result = 31 * result + (fechaSolicitud != null ? fechaSolicitud.hashCode() : 0);
        result = 31 * result + (fechaResuelto != null ? fechaResuelto.hashCode() : 0);
        result = 31 * result + (numeroPedido != null ? numeroPedido.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(observacion);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "DNI_ESCANEADO_ID", referencedColumnName = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByDniEscaneadoId() {
        return archivoByDniEscaneadoId;
    }

    public void setArchivoByDniEscaneadoId(ArchivoEntity archivoByDniEscaneadoId) {
        this.archivoByDniEscaneadoId = archivoByDniEscaneadoId;
    }
}
