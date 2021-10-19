package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "LISTA_CORREO", schema = "datosEveliaMinimo", catalog = "")
public class ListaCorreoEntity {
    private long listaCorreoId;
    private Long aulaId;
    private Collection<CuentaListaCorreoEntity> cuentaListaCorreosByListaCorreoId;
    private AulaEntity aulaByAulaId;

    @Id
    @Column(name = "LISTA_CORREO_ID")
    public long getListaCorreoId() {
        return listaCorreoId;
    }

    public void setListaCorreoId(long listaCorreoId) {
        this.listaCorreoId = listaCorreoId;
    }

    @Basic
    @Column(name = "AULA_ID")
    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaCorreoEntity that = (ListaCorreoEntity) o;

        if (listaCorreoId != that.listaCorreoId) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (listaCorreoId ^ (listaCorreoId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "listaCorreoByListaCorreoId")
    public Collection<CuentaListaCorreoEntity> getCuentaListaCorreosByListaCorreoId() {
        return cuentaListaCorreosByListaCorreoId;
    }

    public void setCuentaListaCorreosByListaCorreoId(Collection<CuentaListaCorreoEntity> cuentaListaCorreosByListaCorreoId) {
        this.cuentaListaCorreosByListaCorreoId = cuentaListaCorreosByListaCorreoId;
    }

    @ManyToOne
    @JoinColumn(name = "AULA_ID", referencedColumnName = "AULA_ID", insertable=false, updatable=false)
    public AulaEntity getAulaByAulaId() {
        return aulaByAulaId;
    }

    public void setAulaByAulaId(AulaEntity aulaByAulaId) {
        this.aulaByAulaId = aulaByAulaId;
    }
}
