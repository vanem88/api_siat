package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "AUDITORIA_OPERACION", schema = "datosEveliaMinimo", catalog = "")
public class AuditoriaOperacionEntity {
    private long auditoriaOperacionId;
    private Timestamp fecha;
    private String desde;
    private Long idPersona;
    private Integer tablaId;
    private Long idObjeto;
    private String operacion;
    private JdoTableEntity jdoTableByTablaId;
    private Collection<AuditoriaValorAnteriorEntity> auditoriaValorAnteriorsByAuditoriaOperacionId;

    @Id
    @Column(name = "AUDITORIA_OPERACION_ID")
    public long getAuditoriaOperacionId() {
        return auditoriaOperacionId;
    }

    public void setAuditoriaOperacionId(long auditoriaOperacionId) {
        this.auditoriaOperacionId = auditoriaOperacionId;
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
    @Column(name = "DESDE")
    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    @Basic
    @Column(name = "ID_PERSONA")
    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    @Basic
    @Column(name = "TABLA_ID")
    public Integer getTablaId() {
        return tablaId;
    }

    public void setTablaId(Integer tablaId) {
        this.tablaId = tablaId;
    }

    @Basic
    @Column(name = "ID_OBJETO")
    public Long getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Long idObjeto) {
        this.idObjeto = idObjeto;
    }

    @Basic
    @Column(name = "OPERACION")
    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuditoriaOperacionEntity that = (AuditoriaOperacionEntity) o;

        if (auditoriaOperacionId != that.auditoriaOperacionId) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (desde != null ? !desde.equals(that.desde) : that.desde != null) return false;
        if (idPersona != null ? !idPersona.equals(that.idPersona) : that.idPersona != null) return false;
        if (tablaId != null ? !tablaId.equals(that.tablaId) : that.tablaId != null) return false;
        if (idObjeto != null ? !idObjeto.equals(that.idObjeto) : that.idObjeto != null) return false;
        if (operacion != null ? !operacion.equals(that.operacion) : that.operacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (auditoriaOperacionId ^ (auditoriaOperacionId >>> 32));
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (desde != null ? desde.hashCode() : 0);
        result = 31 * result + (idPersona != null ? idPersona.hashCode() : 0);
        result = 31 * result + (tablaId != null ? tablaId.hashCode() : 0);
        result = 31 * result + (idObjeto != null ? idObjeto.hashCode() : 0);
        result = 31 * result + (operacion != null ? operacion.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TABLA_ID", referencedColumnName = "TABLE_ID", insertable=false, updatable=false)
    public JdoTableEntity getJdoTableByTablaId() {
        return jdoTableByTablaId;
    }

    public void setJdoTableByTablaId(JdoTableEntity jdoTableByTablaId) {
        this.jdoTableByTablaId = jdoTableByTablaId;
    }

    @OneToMany(mappedBy = "auditoriaOperacionByAuditoriaOperacionId")
    public Collection<AuditoriaValorAnteriorEntity> getAuditoriaValorAnteriorsByAuditoriaOperacionId() {
        return auditoriaValorAnteriorsByAuditoriaOperacionId;
    }

    public void setAuditoriaValorAnteriorsByAuditoriaOperacionId(Collection<AuditoriaValorAnteriorEntity> auditoriaValorAnteriorsByAuditoriaOperacionId) {
        this.auditoriaValorAnteriorsByAuditoriaOperacionId = auditoriaValorAnteriorsByAuditoriaOperacionId;
    }
}
