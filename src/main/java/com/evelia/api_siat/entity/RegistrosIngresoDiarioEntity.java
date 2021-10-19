package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "REGISTROS_INGRESO_DIARIO", schema = "datosEveliaMinimo", catalog = "")
public class RegistrosIngresoDiarioEntity {
    private long registrosIngresoDiarioId;
    private Timestamp fechaHoraEntrada;
    private String host;
    private Long id;
    private long idPersona;
    private String nombreyApellidoPersona;

    @Id
    @Column(name = "REGISTROS_INGRESO_DIARIO_ID")
    public long getRegistrosIngresoDiarioId() {
        return registrosIngresoDiarioId;
    }

    public void setRegistrosIngresoDiarioId(long registrosIngresoDiarioId) {
        this.registrosIngresoDiarioId = registrosIngresoDiarioId;
    }

    @Basic
    @Column(name = "FECHA_HORA_ENTRADA")
    public Timestamp getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(Timestamp fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    @Basic
    @Column(name = "HOST")
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
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
    @Column(name = "ID_PERSONA")
    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    @Basic
    @Column(name = "NOMBREY_APELLIDO_PERSONA")
    public String getNombreyApellidoPersona() {
        return nombreyApellidoPersona;
    }

    public void setNombreyApellidoPersona(String nombreyApellidoPersona) {
        this.nombreyApellidoPersona = nombreyApellidoPersona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrosIngresoDiarioEntity that = (RegistrosIngresoDiarioEntity) o;

        if (registrosIngresoDiarioId != that.registrosIngresoDiarioId) return false;
        if (idPersona != that.idPersona) return false;
        if (fechaHoraEntrada != null ? !fechaHoraEntrada.equals(that.fechaHoraEntrada) : that.fechaHoraEntrada != null)
            return false;
        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombreyApellidoPersona != null ? !nombreyApellidoPersona.equals(that.nombreyApellidoPersona) : that.nombreyApellidoPersona != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (registrosIngresoDiarioId ^ (registrosIngresoDiarioId >>> 32));
        result = 31 * result + (fechaHoraEntrada != null ? fechaHoraEntrada.hashCode() : 0);
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (int) (idPersona ^ (idPersona >>> 32));
        result = 31 * result + (nombreyApellidoPersona != null ? nombreyApellidoPersona.hashCode() : 0);
        return result;
    }
}
