package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "SEGUIMIENTO_MAIL", schema = "datosEveliaMinimo", catalog = "")
public class SeguimientoMailEntity {
    private long seguimientoMailId;
    private Long aulaId;
    private String categoria;
    private Long cuentaCorreoId;
    private Long id;
    private String pathMailEnviado;
    private String pathMailRecibido;
    private Long ultimoMailEnviadoId;
    private Long ultimoMailRecibidoId;
    private CuentaCorreoEntity cuentaCorreoByCuentaCorreoId;
    private MailEntity mailByUltimoMailEnviadoId;
    private MailEntity mailByUltimoMailRecibidoId;

    @Id
    @Column(name = "SEGUIMIENTO_MAIL_ID")
    public long getSeguimientoMailId() {
        return seguimientoMailId;
    }

    public void setSeguimientoMailId(long seguimientoMailId) {
        this.seguimientoMailId = seguimientoMailId;
    }

    @Basic
    @Column(name = "AULA_ID")
    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }

    @Basic
    @Column(name = "CATEGORIA")
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Basic
    @Column(name = "CUENTA_CORREO_ID")
    public Long getCuentaCorreoId() {
        return cuentaCorreoId;
    }

    public void setCuentaCorreoId(Long cuentaCorreoId) {
        this.cuentaCorreoId = cuentaCorreoId;
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
    @Column(name = "PATH_MAIL_ENVIADO")
    public String getPathMailEnviado() {
        return pathMailEnviado;
    }

    public void setPathMailEnviado(String pathMailEnviado) {
        this.pathMailEnviado = pathMailEnviado;
    }

    @Basic
    @Column(name = "PATH_MAIL_RECIBIDO")
    public String getPathMailRecibido() {
        return pathMailRecibido;
    }

    public void setPathMailRecibido(String pathMailRecibido) {
        this.pathMailRecibido = pathMailRecibido;
    }

    @Basic
    @Column(name = "ULTIMO_MAIL_ENVIADO_ID")
    public Long getUltimoMailEnviadoId() {
        return ultimoMailEnviadoId;
    }

    public void setUltimoMailEnviadoId(Long ultimoMailEnviadoId) {
        this.ultimoMailEnviadoId = ultimoMailEnviadoId;
    }

    @Basic
    @Column(name = "ULTIMO_MAIL_RECIBIDO_ID")
    public Long getUltimoMailRecibidoId() {
        return ultimoMailRecibidoId;
    }

    public void setUltimoMailRecibidoId(Long ultimoMailRecibidoId) {
        this.ultimoMailRecibidoId = ultimoMailRecibidoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeguimientoMailEntity that = (SeguimientoMailEntity) o;

        if (seguimientoMailId != that.seguimientoMailId) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (categoria != null ? !categoria.equals(that.categoria) : that.categoria != null) return false;
        if (cuentaCorreoId != null ? !cuentaCorreoId.equals(that.cuentaCorreoId) : that.cuentaCorreoId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (pathMailEnviado != null ? !pathMailEnviado.equals(that.pathMailEnviado) : that.pathMailEnviado != null)
            return false;
        if (pathMailRecibido != null ? !pathMailRecibido.equals(that.pathMailRecibido) : that.pathMailRecibido != null)
            return false;
        if (ultimoMailEnviadoId != null ? !ultimoMailEnviadoId.equals(that.ultimoMailEnviadoId) : that.ultimoMailEnviadoId != null)
            return false;
        if (ultimoMailRecibidoId != null ? !ultimoMailRecibidoId.equals(that.ultimoMailRecibidoId) : that.ultimoMailRecibidoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seguimientoMailId ^ (seguimientoMailId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        result = 31 * result + (cuentaCorreoId != null ? cuentaCorreoId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (pathMailEnviado != null ? pathMailEnviado.hashCode() : 0);
        result = 31 * result + (pathMailRecibido != null ? pathMailRecibido.hashCode() : 0);
        result = 31 * result + (ultimoMailEnviadoId != null ? ultimoMailEnviadoId.hashCode() : 0);
        result = 31 * result + (ultimoMailRecibidoId != null ? ultimoMailRecibidoId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CUENTA_CORREO_ID", referencedColumnName = "CUENTA_CORREO_ID", insertable=false, updatable=false)
    public CuentaCorreoEntity getCuentaCorreoByCuentaCorreoId() {
        return cuentaCorreoByCuentaCorreoId;
    }

    public void setCuentaCorreoByCuentaCorreoId(CuentaCorreoEntity cuentaCorreoByCuentaCorreoId) {
        this.cuentaCorreoByCuentaCorreoId = cuentaCorreoByCuentaCorreoId;
    }

    @ManyToOne
    @JoinColumn(name = "ULTIMO_MAIL_ENVIADO_ID", referencedColumnName = "MAIL_ID", insertable=false, updatable=false)
    public MailEntity getMailByUltimoMailEnviadoId() {
        return mailByUltimoMailEnviadoId;
    }

    public void setMailByUltimoMailEnviadoId(MailEntity mailByUltimoMailEnviadoId) {
        this.mailByUltimoMailEnviadoId = mailByUltimoMailEnviadoId;
    }

    @ManyToOne
    @JoinColumn(name = "ULTIMO_MAIL_RECIBIDO_ID", referencedColumnName = "MAIL_ID", insertable=false, updatable=false)
    public MailEntity getMailByUltimoMailRecibidoId() {
        return mailByUltimoMailRecibidoId;
    }

    public void setMailByUltimoMailRecibidoId(MailEntity mailByUltimoMailRecibidoId) {
        this.mailByUltimoMailRecibidoId = mailByUltimoMailRecibidoId;
    }
}
