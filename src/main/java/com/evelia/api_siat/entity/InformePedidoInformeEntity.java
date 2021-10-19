package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "INFORME_PEDIDO_INFORME", schema = "datosEveliaMinimo", catalog = "")
public class InformePedidoInformeEntity {
    private long informePedidoInformeId;
    private Long id;
    private Long informeId;
    private Long pedidoInformeId;
    private InformeEntity informeByInformeId;
    private PedidoInformeEntity pedidoInformeByPedidoInformeId;

    @Id
    @Column(name = "INFORME_PEDIDO_INFORME_ID")
    public long getInformePedidoInformeId() {
        return informePedidoInformeId;
    }

    public void setInformePedidoInformeId(long informePedidoInformeId) {
        this.informePedidoInformeId = informePedidoInformeId;
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
    @Column(name = "INFORME_ID")
    public Long getInformeId() {
        return informeId;
    }

    public void setInformeId(Long informeId) {
        this.informeId = informeId;
    }

    @Basic
    @Column(name = "PEDIDO_INFORME_ID")
    public Long getPedidoInformeId() {
        return pedidoInformeId;
    }

    public void setPedidoInformeId(Long pedidoInformeId) {
        this.pedidoInformeId = pedidoInformeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InformePedidoInformeEntity that = (InformePedidoInformeEntity) o;

        if (informePedidoInformeId != that.informePedidoInformeId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (informeId != null ? !informeId.equals(that.informeId) : that.informeId != null) return false;
        if (pedidoInformeId != null ? !pedidoInformeId.equals(that.pedidoInformeId) : that.pedidoInformeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (informePedidoInformeId ^ (informePedidoInformeId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (informeId != null ? informeId.hashCode() : 0);
        result = 31 * result + (pedidoInformeId != null ? pedidoInformeId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "INFORME_ID", referencedColumnName = "INFORME_ID",insertable=false, updatable=false)
    public InformeEntity getInformeByInformeId() {
        return informeByInformeId;
    }

    public void setInformeByInformeId(InformeEntity informeByInformeId) {
        this.informeByInformeId = informeByInformeId;
    }

    @ManyToOne
    @JoinColumn(name = "PEDIDO_INFORME_ID", referencedColumnName = "PEDIDO_INFORME_ID",insertable=false, updatable=false)
    public PedidoInformeEntity getPedidoInformeByPedidoInformeId() {
        return pedidoInformeByPedidoInformeId;
    }

    public void setPedidoInformeByPedidoInformeId(PedidoInformeEntity pedidoInformeByPedidoInformeId) {
        this.pedidoInformeByPedidoInformeId = pedidoInformeByPedidoInformeId;
    }
}
