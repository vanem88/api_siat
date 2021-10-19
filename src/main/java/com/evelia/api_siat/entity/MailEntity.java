package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "MAIL", schema = "datosEveliaMinimo", catalog = "")
public class MailEntity {
    private long mailId;
    private String asunto;
    private Long aulaId;
    private Long cuentaCorreoId;
    private byte[] cuerpo;
    private Timestamp fecha;
    private Long id;
    private Collection<CuentasHastaEntity> cuentasHastasByMailId;
    private AulaEntity aulaByAulaId;
    private CuentaCorreoEntity cuentaCorreoByCuentaCorreoId;
    private Collection<SeguimientoMailEntity> seguimientoMailsByMailId;
    private Collection<SeguimientoMailEntity> seguimientoMailsByMailId_0;

    @Id
    @Column(name = "MAIL_ID")
    public long getMailId() {
        return mailId;
    }

    public void setMailId(long mailId) {
        this.mailId = mailId;
    }

    @Basic
    @Column(name = "ASUNTO")
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
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
    @Column(name = "CUENTA_CORREO_ID")
    public Long getCuentaCorreoId() {
        return cuentaCorreoId;
    }

    public void setCuentaCorreoId(Long cuentaCorreoId) {
        this.cuentaCorreoId = cuentaCorreoId;
    }

    @Basic
    @Column(name = "CUERPO")
    public byte[] getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(byte[] cuerpo) {
        this.cuerpo = cuerpo;
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
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MailEntity that = (MailEntity) o;

        if (mailId != that.mailId) return false;
        if (asunto != null ? !asunto.equals(that.asunto) : that.asunto != null) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (cuentaCorreoId != null ? !cuentaCorreoId.equals(that.cuentaCorreoId) : that.cuentaCorreoId != null)
            return false;
        if (!Arrays.equals(cuerpo, that.cuerpo)) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (mailId ^ (mailId >>> 32));
        result = 31 * result + (asunto != null ? asunto.hashCode() : 0);
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (cuentaCorreoId != null ? cuentaCorreoId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(cuerpo);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "mailByMailId")
    public Collection<CuentasHastaEntity> getCuentasHastasByMailId() {
        return cuentasHastasByMailId;
    }

    public void setCuentasHastasByMailId(Collection<CuentasHastaEntity> cuentasHastasByMailId) {
        this.cuentasHastasByMailId = cuentasHastasByMailId;
    }

    @ManyToOne
    @JoinColumn(name = "AULA_ID", referencedColumnName = "AULA_ID",insertable=false, updatable=false)
    public AulaEntity getAulaByAulaId() {
        return aulaByAulaId;
    }

    public void setAulaByAulaId(AulaEntity aulaByAulaId) {
        this.aulaByAulaId = aulaByAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "CUENTA_CORREO_ID", referencedColumnName = "CUENTA_CORREO_ID",insertable=false, updatable=false)
    public CuentaCorreoEntity getCuentaCorreoByCuentaCorreoId() {
        return cuentaCorreoByCuentaCorreoId;
    }

    public void setCuentaCorreoByCuentaCorreoId(CuentaCorreoEntity cuentaCorreoByCuentaCorreoId) {
        this.cuentaCorreoByCuentaCorreoId = cuentaCorreoByCuentaCorreoId;
    }

    @OneToMany(mappedBy = "mailByUltimoMailEnviadoId")
    public Collection<SeguimientoMailEntity> getSeguimientoMailsByMailId() {
        return seguimientoMailsByMailId;
    }

    public void setSeguimientoMailsByMailId(Collection<SeguimientoMailEntity> seguimientoMailsByMailId) {
        this.seguimientoMailsByMailId = seguimientoMailsByMailId;
    }

    @OneToMany(mappedBy = "mailByUltimoMailRecibidoId")
    public Collection<SeguimientoMailEntity> getSeguimientoMailsByMailId_0() {
        return seguimientoMailsByMailId_0;
    }

    public void setSeguimientoMailsByMailId_0(Collection<SeguimientoMailEntity> seguimientoMailsByMailId_0) {
        this.seguimientoMailsByMailId_0 = seguimientoMailsByMailId_0;
    }
}
