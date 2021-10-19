package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "ERROR_LOG", schema = "datosEveliaMinimo", catalog = "")
public class ErrorLogEntity {
    private long codigoErrorLog;
    private String mensaje;

    @Id
    @Column(name = "codigo_error_log")
    public long getCodigoErrorLog() {
        return codigoErrorLog;
    }

    public void setCodigoErrorLog(long codigoErrorLog) {
        this.codigoErrorLog = codigoErrorLog;
    }

    @Basic
    @Column(name = "mensaje")
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorLogEntity that = (ErrorLogEntity) o;

        if (codigoErrorLog != that.codigoErrorLog) return false;
        if (mensaje != null ? !mensaje.equals(that.mensaje) : that.mensaje != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codigoErrorLog ^ (codigoErrorLog >>> 32));
        result = 31 * result + (mensaje != null ? mensaje.hashCode() : 0);
        return result;
    }
}
