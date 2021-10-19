package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "DESCARGA_EXAMEN", schema = "datosEveliaMinimo", catalog = "")
public class DescargaExamenEntity {
    private long descargaExamenId;
    private Long id;
    private Long examenId;
    private Long examenFinalizadoId;
    private Long archivoId;
    private byte[] comentario;
    private Timestamp fecha;
    private String tipo;
    private EvaluacionEntity evaluacionByExamenId;
    private EvaluacionFinalizadaEntity evaluacionFinalizadaByExamenFinalizadoId;
    private ArchivoEntity archivoByArchivoId;

    @Id
    @Column(name = "DESCARGA_EXAMEN_ID")
    public long getDescargaExamenId() {
        return descargaExamenId;
    }

    public void setDescargaExamenId(long descargaExamenId) {
        this.descargaExamenId = descargaExamenId;
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
    @Column(name = "EXAMEN_ID")
    public Long getExamenId() {
        return examenId;
    }

    public void setExamenId(Long examenId) {
        this.examenId = examenId;
    }

    @Basic
    @Column(name = "EXAMEN_FINALIZADO_ID")
    public Long getExamenFinalizadoId() {
        return examenFinalizadoId;
    }

    public void setExamenFinalizadoId(Long examenFinalizadoId) {
        this.examenFinalizadoId = examenFinalizadoId;
    }

    @Basic
    @Column(name = "ARCHIVO_ID")
    public Long getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(Long archivoId) {
        this.archivoId = archivoId;
    }

    @Basic
    @Column(name = "COMENTARIO")
    public byte[] getComentario() {
        return comentario;
    }

    public void setComentario(byte[] comentario) {
        this.comentario = comentario;
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
    @Column(name = "TIPO")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DescargaExamenEntity that = (DescargaExamenEntity) o;

        if (descargaExamenId != that.descargaExamenId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (examenId != null ? !examenId.equals(that.examenId) : that.examenId != null) return false;
        if (examenFinalizadoId != null ? !examenFinalizadoId.equals(that.examenFinalizadoId) : that.examenFinalizadoId != null)
            return false;
        if (archivoId != null ? !archivoId.equals(that.archivoId) : that.archivoId != null) return false;
        if (!Arrays.equals(comentario, that.comentario)) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (descargaExamenId ^ (descargaExamenId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (examenId != null ? examenId.hashCode() : 0);
        result = 31 * result + (examenFinalizadoId != null ? examenFinalizadoId.hashCode() : 0);
        result = 31 * result + (archivoId != null ? archivoId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(comentario);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "EXAMEN_ID", insertable=false, updatable=false)
    public EvaluacionEntity getEvaluacionByExamenId() {
        return evaluacionByExamenId;
    }

    public void setEvaluacionByExamenId(EvaluacionEntity evaluacionByExamenId) {
        this.evaluacionByExamenId = evaluacionByExamenId;
    }

    @ManyToOne
    @JoinColumn(name = "EXAMEN_FINALIZADO_ID", insertable=false, updatable=false)
    public EvaluacionFinalizadaEntity getEvaluacionFinalizadaByExamenFinalizadoId() {
        return evaluacionFinalizadaByExamenFinalizadoId;
    }

    public void setEvaluacionFinalizadaByExamenFinalizadoId(EvaluacionFinalizadaEntity evaluacionFinalizadaByExamenFinalizadoId) {
        this.evaluacionFinalizadaByExamenFinalizadoId = evaluacionFinalizadaByExamenFinalizadoId;
    }

    @ManyToOne
    @JoinColumn(name = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoId() {
        return archivoByArchivoId;
    }

    public void setArchivoByArchivoId(ArchivoEntity archivoByArchivoId) {
        this.archivoByArchivoId = archivoByArchivoId;
    }
}
