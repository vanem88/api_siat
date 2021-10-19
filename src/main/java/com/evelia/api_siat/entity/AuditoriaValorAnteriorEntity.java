package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "AUDITORIA_VALOR_ANTERIOR", schema = "datosEveliaMinimo", catalog = "")
public class AuditoriaValorAnteriorEntity {
    private long auditoriaValorAnteriorId;
    private String operacion;
    private long auditoriaOperacionId;
    private String atributo;
    private String valor;
    private byte[] valorEditor;
    private AuditoriaOperacionEntity auditoriaOperacionByAuditoriaOperacionId;

    @Id
    @Column(name = "AUDITORIA_VALOR_ANTERIOR_ID")
    public long getAuditoriaValorAnteriorId() {
        return auditoriaValorAnteriorId;
    }

    public void setAuditoriaValorAnteriorId(long auditoriaValorAnteriorId) {
        this.auditoriaValorAnteriorId = auditoriaValorAnteriorId;
    }

    @Basic
    @Column(name = "OPERACION")
    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Basic
    @Column(name = "AUDITORIA_OPERACION_ID")
    public long getAuditoriaOperacionId() {
        return auditoriaOperacionId;
    }

    public void setAuditoriaOperacionId(long auditoriaOperacionId) {
        this.auditoriaOperacionId = auditoriaOperacionId;
    }

    @Basic
    @Column(name = "ATRIBUTO")
    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    @Basic
    @Column(name = "VALOR")
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "VALOR_EDITOR")
    public byte[] getValorEditor() {
        return valorEditor;
    }

    public void setValorEditor(byte[] valorEditor) {
        this.valorEditor = valorEditor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuditoriaValorAnteriorEntity that = (AuditoriaValorAnteriorEntity) o;

        if (auditoriaValorAnteriorId != that.auditoriaValorAnteriorId) return false;
        if (auditoriaOperacionId != that.auditoriaOperacionId) return false;
        if (operacion != null ? !operacion.equals(that.operacion) : that.operacion != null) return false;
        if (atributo != null ? !atributo.equals(that.atributo) : that.atributo != null) return false;
        if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;
        if (!Arrays.equals(valorEditor, that.valorEditor)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (auditoriaValorAnteriorId ^ (auditoriaValorAnteriorId >>> 32));
        result = 31 * result + (operacion != null ? operacion.hashCode() : 0);
        result = 31 * result + (int) (auditoriaOperacionId ^ (auditoriaOperacionId >>> 32));
        result = 31 * result + (atributo != null ? atributo.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(valorEditor);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "AUDITORIA_OPERACION_ID", referencedColumnName = "AUDITORIA_OPERACION_ID", nullable = false, insertable=false, updatable=false)
    public AuditoriaOperacionEntity getAuditoriaOperacionByAuditoriaOperacionId() {
        return auditoriaOperacionByAuditoriaOperacionId;
    }

    public void setAuditoriaOperacionByAuditoriaOperacionId(AuditoriaOperacionEntity auditoriaOperacionByAuditoriaOperacionId) {
        this.auditoriaOperacionByAuditoriaOperacionId = auditoriaOperacionByAuditoriaOperacionId;
    }
}
