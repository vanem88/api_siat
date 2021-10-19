package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "PEDIDO_INFORME", schema = "datosEveliaMinimo", catalog = "")
public class PedidoInformeEntity {
    private long pedidoInformeId;
    private Long aulaId;
    private Date fecha;
    private Date fechaDesde;
    private Date fechaHasta;
    private Long id;
    private String nombre;
    private String pathArchivoSalida;
    private String pendiente;
    private Long personaId;
    private Collection<InformePedidoInformeEntity> informePedidoInformesByPedidoInformeId;
    private AulaEntity aulaByAulaId;
    private PersonaEntity personaByPersonaId;

    @Id
    @Column(name = "PEDIDO_INFORME_ID")
    public long getPedidoInformeId() {
        return pedidoInformeId;
    }

    public void setPedidoInformeId(long pedidoInformeId) {
        this.pedidoInformeId = pedidoInformeId;
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
    @Column(name = "FECHA")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "FECHA_DESDE")
    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    @Basic
    @Column(name = "FECHA_HASTA")
    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
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
    @Column(name = "PATH_ARCHIVO_SALIDA")
    public String getPathArchivoSalida() {
        return pathArchivoSalida;
    }

    public void setPathArchivoSalida(String pathArchivoSalida) {
        this.pathArchivoSalida = pathArchivoSalida;
    }

    @Basic
    @Column(name = "PENDIENTE")
    public String getPendiente() {
        return pendiente;
    }

    public void setPendiente(String pendiente) {
        this.pendiente = pendiente;
    }

    @Basic
    @Column(name = "PERSONA_ID")
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidoInformeEntity that = (PedidoInformeEntity) o;

        if (pedidoInformeId != that.pedidoInformeId) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (fechaDesde != null ? !fechaDesde.equals(that.fechaDesde) : that.fechaDesde != null) return false;
        if (fechaHasta != null ? !fechaHasta.equals(that.fechaHasta) : that.fechaHasta != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (pathArchivoSalida != null ? !pathArchivoSalida.equals(that.pathArchivoSalida) : that.pathArchivoSalida != null)
            return false;
        if (pendiente != null ? !pendiente.equals(that.pendiente) : that.pendiente != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pedidoInformeId ^ (pedidoInformeId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (fechaDesde != null ? fechaDesde.hashCode() : 0);
        result = 31 * result + (fechaHasta != null ? fechaHasta.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (pathArchivoSalida != null ? pathArchivoSalida.hashCode() : 0);
        result = 31 * result + (pendiente != null ? pendiente.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "pedidoInformeByPedidoInformeId")
    public Collection<InformePedidoInformeEntity> getInformePedidoInformesByPedidoInformeId() {
        return informePedidoInformesByPedidoInformeId;
    }

    public void setInformePedidoInformesByPedidoInformeId(Collection<InformePedidoInformeEntity> informePedidoInformesByPedidoInformeId) {
        this.informePedidoInformesByPedidoInformeId = informePedidoInformesByPedidoInformeId;
    }

    @ManyToOne
    @JoinColumn(name = "AULA_ID", referencedColumnName = "AULA_ID", insertable=false, updatable=false)
    public AulaEntity getAulaByAulaId() {
        return aulaByAulaId;
    }

    public void setAulaByAulaId(AulaEntity aulaByAulaId) {
        this.aulaByAulaId = aulaByAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
}
