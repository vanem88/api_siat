package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "CUENTAS_HASTA", schema = "datosEveliaMinimo", catalog = "")
public class CuentasHastaEntity {
    private long cuentasHastaId;
    private Long cuentaCorreoId;
    private Long id;
    private Long mailId;
    private CuentaCorreoEntity cuentaCorreoByCuentaCorreoId;
    private MailEntity mailByMailId;

    @Id
    @Column(name = "CUENTAS_HASTA_ID")
    public long getCuentasHastaId() {
        return cuentasHastaId;
    }

    public void setCuentasHastaId(long cuentasHastaId) {
        this.cuentasHastaId = cuentasHastaId;
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
    @Column(name = "MAIL_ID")
    public Long getMailId() {
        return mailId;
    }

    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuentasHastaEntity that = (CuentasHastaEntity) o;

        if (cuentasHastaId != that.cuentasHastaId) return false;
        if (cuentaCorreoId != null ? !cuentaCorreoId.equals(that.cuentaCorreoId) : that.cuentaCorreoId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (mailId != null ? !mailId.equals(that.mailId) : that.mailId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cuentasHastaId ^ (cuentasHastaId >>> 32));
        result = 31 * result + (cuentaCorreoId != null ? cuentaCorreoId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (mailId != null ? mailId.hashCode() : 0);
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
    @JoinColumn(name = "MAIL_ID", referencedColumnName = "MAIL_ID", insertable=false, updatable=false)
    public MailEntity getMailByMailId() {
        return mailByMailId;
    }

    public void setMailByMailId(MailEntity mailByMailId) {
        this.mailByMailId = mailByMailId;
    }
}
