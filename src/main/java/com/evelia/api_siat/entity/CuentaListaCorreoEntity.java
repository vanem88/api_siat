package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "CUENTA_LISTA_CORREO", schema = "datosEveliaMinimo", catalog = "")
public class CuentaListaCorreoEntity {
    private long cuentaListaCorreoId;
    private Long cuentaCorreoId;
    private Long id;
    private Long listaCorreoId;
    private CuentaCorreoEntity cuentaCorreoByCuentaCorreoId;
    private ListaCorreoEntity listaCorreoByListaCorreoId;

    @Id
    @Column(name = "CUENTA_LISTA_CORREO_ID")
    public long getCuentaListaCorreoId() {
        return cuentaListaCorreoId;
    }

    public void setCuentaListaCorreoId(long cuentaListaCorreoId) {
        this.cuentaListaCorreoId = cuentaListaCorreoId;
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
    @Column(name = "LISTA_CORREO_ID")
    public Long getListaCorreoId() {
        return listaCorreoId;
    }

    public void setListaCorreoId(Long listaCorreoId) {
        this.listaCorreoId = listaCorreoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuentaListaCorreoEntity that = (CuentaListaCorreoEntity) o;

        if (cuentaListaCorreoId != that.cuentaListaCorreoId) return false;
        if (cuentaCorreoId != null ? !cuentaCorreoId.equals(that.cuentaCorreoId) : that.cuentaCorreoId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (listaCorreoId != null ? !listaCorreoId.equals(that.listaCorreoId) : that.listaCorreoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cuentaListaCorreoId ^ (cuentaListaCorreoId >>> 32));
        result = 31 * result + (cuentaCorreoId != null ? cuentaCorreoId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (listaCorreoId != null ? listaCorreoId.hashCode() : 0);
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
    @JoinColumn(name = "LISTA_CORREO_ID", referencedColumnName = "LISTA_CORREO_ID", insertable=false, updatable=false)
    public ListaCorreoEntity getListaCorreoByListaCorreoId() {
        return listaCorreoByListaCorreoId;
    }

    public void setListaCorreoByListaCorreoId(ListaCorreoEntity listaCorreoByListaCorreoId) {
        this.listaCorreoByListaCorreoId = listaCorreoByListaCorreoId;
    }
}
