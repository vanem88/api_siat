package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "COMISION_SOLICITUD", schema = "datosEveliaMinimo", catalog = "")
public class ComisionSolicitudEntity {
    private long comisionSolicitudId;
    private Long id;
    private String nombre;
    private Integer numero;
    private Long solicitudAulaId;
    private Collection<ClonarInfoComisionEntity> clonarInfoComisionsByComisionSolicitudId;
    private SolicitudAulaEntity solicitudAulaBySolicitudAulaId;
    private Collection<ComisionSolicitudDocenteAulaEntity> comisionSolicitudDocenteAulasByComisionSolicitudId;

    @Id
    @Column(name = "COMISION_SOLICITUD_ID")
    public long getComisionSolicitudId() {
        return comisionSolicitudId;
    }

    public void setComisionSolicitudId(long comisionSolicitudId) {
        this.comisionSolicitudId = comisionSolicitudId;
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
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "NUMERO")
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "SOLICITUD_AULA_ID")
    public Long getSolicitudAulaId() {
        return solicitudAulaId;
    }

    public void setSolicitudAulaId(Long solicitudAulaId) {
        this.solicitudAulaId = solicitudAulaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComisionSolicitudEntity that = (ComisionSolicitudEntity) o;

        if (comisionSolicitudId != that.comisionSolicitudId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (numero != null ? !numero.equals(that.numero) : that.numero != null) return false;
        if (solicitudAulaId != null ? !solicitudAulaId.equals(that.solicitudAulaId) : that.solicitudAulaId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (comisionSolicitudId ^ (comisionSolicitudId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (solicitudAulaId != null ? solicitudAulaId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "comisionSolicitudByComisionDestinoId")
    public Collection<ClonarInfoComisionEntity> getClonarInfoComisionsByComisionSolicitudId() {
        return clonarInfoComisionsByComisionSolicitudId;
    }

    public void setClonarInfoComisionsByComisionSolicitudId(Collection<ClonarInfoComisionEntity> clonarInfoComisionsByComisionSolicitudId) {
        this.clonarInfoComisionsByComisionSolicitudId = clonarInfoComisionsByComisionSolicitudId;
    }

    @ManyToOne
    @JoinColumn(name = "SOLICITUD_AULA_ID", referencedColumnName = "SOLICITUD_AULA_ID", insertable=false, updatable=false)
    public SolicitudAulaEntity getSolicitudAulaBySolicitudAulaId() {
        return solicitudAulaBySolicitudAulaId;
    }

    public void setSolicitudAulaBySolicitudAulaId(SolicitudAulaEntity solicitudAulaBySolicitudAulaId) {
        this.solicitudAulaBySolicitudAulaId = solicitudAulaBySolicitudAulaId;
    }

    @OneToMany(mappedBy = "comisionSolicitudByComisionSolicitudId")
    public Collection<ComisionSolicitudDocenteAulaEntity> getComisionSolicitudDocenteAulasByComisionSolicitudId() {
        return comisionSolicitudDocenteAulasByComisionSolicitudId;
    }

    public void setComisionSolicitudDocenteAulasByComisionSolicitudId(Collection<ComisionSolicitudDocenteAulaEntity> comisionSolicitudDocenteAulasByComisionSolicitudId) {
        this.comisionSolicitudDocenteAulasByComisionSolicitudId = comisionSolicitudDocenteAulasByComisionSolicitudId;
    }
}
