package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "VALOR_SECCION", schema = "datosEveliaMinimo", catalog = "")
public class ValorSeccionEntity {
    private long valorSeccionId;
    private Long aulaCompuestaId;
    private Long id;
    private Long tipoSeccionId;
    private byte[] valor;

    @Id
    @Column(name = "VALOR_SECCION_ID")
    public long getValorSeccionId() {
        return valorSeccionId;
    }

    public void setValorSeccionId(long valorSeccionId) {
        this.valorSeccionId = valorSeccionId;
    }

    @Basic
    @Column(name = "AULA_COMPUESTA_ID")
    public Long getAulaCompuestaId() {
        return aulaCompuestaId;
    }

    public void setAulaCompuestaId(Long aulaCompuestaId) {
        this.aulaCompuestaId = aulaCompuestaId;
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
    @Column(name = "TIPO_SECCION_ID")
    public Long getTipoSeccionId() {
        return tipoSeccionId;
    }

    public void setTipoSeccionId(Long tipoSeccionId) {
        this.tipoSeccionId = tipoSeccionId;
    }

    @Basic
    @Column(name = "VALOR")
    public byte[] getValor() {
        return valor;
    }

    public void setValor(byte[] valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValorSeccionEntity that = (ValorSeccionEntity) o;

        if (valorSeccionId != that.valorSeccionId) return false;
        if (aulaCompuestaId != null ? !aulaCompuestaId.equals(that.aulaCompuestaId) : that.aulaCompuestaId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipoSeccionId != null ? !tipoSeccionId.equals(that.tipoSeccionId) : that.tipoSeccionId != null)
            return false;
        if (!Arrays.equals(valor, that.valor)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (valorSeccionId ^ (valorSeccionId >>> 32));
        result = 31 * result + (aulaCompuestaId != null ? aulaCompuestaId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (tipoSeccionId != null ? tipoSeccionId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(valor);
        return result;
    }
}
