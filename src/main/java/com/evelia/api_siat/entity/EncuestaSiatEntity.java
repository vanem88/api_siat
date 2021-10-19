package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "ENCUESTA_SIAT", schema = "datosEveliaMinimo", catalog = "")
public class EncuestaSiatEntity {
    private long encuestaSiatId;
    private byte[] descripcion;
    private String estado;
    private Long id;
    private String nombre;
    private Long paraQuienId;
    private String periodo;
    private TipoUsuarioEntity tipoUsuarioByParaQuienId;
    private Collection<EncuestaSiatPersonaEntity> encuestaSiatPersonasByEncuestaSiatId;
    private Collection<PreguntaSiatEntity> preguntaSiatsByEncuestaSiatId;

    @Id
    @Column(name = "ENCUESTA_SIAT_ID")
    public long getEncuestaSiatId() {
        return encuestaSiatId;
    }

    public void setEncuestaSiatId(long encuestaSiatId) {
        this.encuestaSiatId = encuestaSiatId;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public byte[] getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(byte[] descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
    @Column(name = "PARA_QUIEN_ID")
    public Long getParaQuienId() {
        return paraQuienId;
    }

    public void setParaQuienId(Long paraQuienId) {
        this.paraQuienId = paraQuienId;
    }

    @Basic
    @Column(name = "PERIODO")
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EncuestaSiatEntity that = (EncuestaSiatEntity) o;

        if (encuestaSiatId != that.encuestaSiatId) return false;
        if (!Arrays.equals(descripcion, that.descripcion)) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (paraQuienId != null ? !paraQuienId.equals(that.paraQuienId) : that.paraQuienId != null) return false;
        if (periodo != null ? !periodo.equals(that.periodo) : that.periodo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (encuestaSiatId ^ (encuestaSiatId >>> 32));
        result = 31 * result + Arrays.hashCode(descripcion);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (paraQuienId != null ? paraQuienId.hashCode() : 0);
        result = 31 * result + (periodo != null ? periodo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PARA_QUIEN_ID", referencedColumnName = "TIPO_USUARIO_ID", insertable=false, updatable=false)
    public TipoUsuarioEntity getTipoUsuarioByParaQuienId() {
        return tipoUsuarioByParaQuienId;
    }

    public void setTipoUsuarioByParaQuienId(TipoUsuarioEntity tipoUsuarioByParaQuienId) {
        this.tipoUsuarioByParaQuienId = tipoUsuarioByParaQuienId;
    }

    @OneToMany(mappedBy = "encuestaSiatByEncuestaSiatId")
    public Collection<EncuestaSiatPersonaEntity> getEncuestaSiatPersonasByEncuestaSiatId() {
        return encuestaSiatPersonasByEncuestaSiatId;
    }

    public void setEncuestaSiatPersonasByEncuestaSiatId(Collection<EncuestaSiatPersonaEntity> encuestaSiatPersonasByEncuestaSiatId) {
        this.encuestaSiatPersonasByEncuestaSiatId = encuestaSiatPersonasByEncuestaSiatId;
    }

    @OneToMany(mappedBy = "encuestaSiatByEncuestaSiatId")
    public Collection<PreguntaSiatEntity> getPreguntaSiatsByEncuestaSiatId() {
        return preguntaSiatsByEncuestaSiatId;
    }

    public void setPreguntaSiatsByEncuestaSiatId(Collection<PreguntaSiatEntity> preguntaSiatsByEncuestaSiatId) {
        this.preguntaSiatsByEncuestaSiatId = preguntaSiatsByEncuestaSiatId;
    }
}
