package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "RESPUESTA_EX", schema = "datosEveliaMinimo", catalog = "")
public class RespuestaExEntity {
    private long respuestaExId;
    private Long id;
    private byte[] justificacion;
    private double nota;
    private Long pregId;
    private byte[] respuesta;
    private String tipoPreg;
    private int orden;
    private Timestamp fecha;
    private Long evaluacionFinalizadaConRespuestasId;
    private double notaAutomatica;
    private PreguntaExEntity preguntaExByPregId;
    private EvaluacionFinalizadaConRespuestasEntity evaluacionFinalizadaConRespuestasByEvaluacionFinalizadaConRespuestasId;
    private Collection<RespuestaExConjRespuestaEntity> respuestaExConjRespuestasByRespuestaExId;
    private Collection<RespuestaExOrdenOpcionEntity> respuestaExOrdenOpcionsByRespuestaExId;

    @Id
    @Column(name = "RESPUESTA_EX_ID")
    public long getRespuestaExId() {
        return respuestaExId;
    }

    public void setRespuestaExId(long respuestaExId) {
        this.respuestaExId = respuestaExId;
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
    @Column(name = "JUSTIFICACION")
    public byte[] getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(byte[] justificacion) {
        this.justificacion = justificacion;
    }

    @Basic
    @Column(name = "NOTA")
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Basic
    @Column(name = "PREG_ID")
    public Long getPregId() {
        return pregId;
    }

    public void setPregId(Long pregId) {
        this.pregId = pregId;
    }

    @Basic
    @Column(name = "RESPUESTA")
    public byte[] getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(byte[] respuesta) {
        this.respuesta = respuesta;
    }

    @Basic
    @Column(name = "TIPO_PREG")
    public String getTipoPreg() {
        return tipoPreg;
    }

    public void setTipoPreg(String tipoPreg) {
        this.tipoPreg = tipoPreg;
    }

    @Basic
    @Column(name = "ORDEN")
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
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
    @Column(name = "EVALUACION_FINALIZADA_CON_RESPUESTAS_ID")
    public Long getEvaluacionFinalizadaConRespuestasId() {
        return evaluacionFinalizadaConRespuestasId;
    }

    public void setEvaluacionFinalizadaConRespuestasId(Long evaluacionFinalizadaConRespuestasId) {
        this.evaluacionFinalizadaConRespuestasId = evaluacionFinalizadaConRespuestasId;
    }

    @Basic
    @Column(name = "NOTA_AUTOMATICA")
    public double getNotaAutomatica() {
        return notaAutomatica;
    }

    public void setNotaAutomatica(double notaAutomatica) {
        this.notaAutomatica = notaAutomatica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RespuestaExEntity that = (RespuestaExEntity) o;

        if (respuestaExId != that.respuestaExId) return false;
        if (Double.compare(that.nota, nota) != 0) return false;
        if (orden != that.orden) return false;
        if (Double.compare(that.notaAutomatica, notaAutomatica) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!Arrays.equals(justificacion, that.justificacion)) return false;
        if (pregId != null ? !pregId.equals(that.pregId) : that.pregId != null) return false;
        if (!Arrays.equals(respuesta, that.respuesta)) return false;
        if (tipoPreg != null ? !tipoPreg.equals(that.tipoPreg) : that.tipoPreg != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (evaluacionFinalizadaConRespuestasId != null ? !evaluacionFinalizadaConRespuestasId.equals(that.evaluacionFinalizadaConRespuestasId) : that.evaluacionFinalizadaConRespuestasId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (respuestaExId ^ (respuestaExId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(justificacion);
        temp = Double.doubleToLongBits(nota);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (pregId != null ? pregId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(respuesta);
        result = 31 * result + (tipoPreg != null ? tipoPreg.hashCode() : 0);
        result = 31 * result + orden;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (evaluacionFinalizadaConRespuestasId != null ? evaluacionFinalizadaConRespuestasId.hashCode() : 0);
        temp = Double.doubleToLongBits(notaAutomatica);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PREG_ID", referencedColumnName = "PREGUNTA_EX_ID", insertable=false, updatable=false)
    public PreguntaExEntity getPreguntaExByPregId() {
        return preguntaExByPregId;
    }

    public void setPreguntaExByPregId(PreguntaExEntity preguntaExByPregId) {
        this.preguntaExByPregId = preguntaExByPregId;
    }

    @ManyToOne
    @JoinColumn(name = "EVALUACION_FINALIZADA_CON_RESPUESTAS_ID", referencedColumnName = "EVALUACION_FINALIZADA_CON_RESPUESTAS_ID", insertable=false, updatable=false)
    public EvaluacionFinalizadaConRespuestasEntity getEvaluacionFinalizadaConRespuestasByEvaluacionFinalizadaConRespuestasId() {
        return evaluacionFinalizadaConRespuestasByEvaluacionFinalizadaConRespuestasId;
    }

    public void setEvaluacionFinalizadaConRespuestasByEvaluacionFinalizadaConRespuestasId(EvaluacionFinalizadaConRespuestasEntity evaluacionFinalizadaConRespuestasByEvaluacionFinalizadaConRespuestasId) {
        this.evaluacionFinalizadaConRespuestasByEvaluacionFinalizadaConRespuestasId = evaluacionFinalizadaConRespuestasByEvaluacionFinalizadaConRespuestasId;
    }

    @OneToMany(mappedBy = "respuestaExByRespuestaExId")
    public Collection<RespuestaExConjRespuestaEntity> getRespuestaExConjRespuestasByRespuestaExId() {
        return respuestaExConjRespuestasByRespuestaExId;
    }

    public void setRespuestaExConjRespuestasByRespuestaExId(Collection<RespuestaExConjRespuestaEntity> respuestaExConjRespuestasByRespuestaExId) {
        this.respuestaExConjRespuestasByRespuestaExId = respuestaExConjRespuestasByRespuestaExId;
    }

    @OneToMany(mappedBy = "respuestaExByRespuestaExId")
    public Collection<RespuestaExOrdenOpcionEntity> getRespuestaExOrdenOpcionsByRespuestaExId() {
        return respuestaExOrdenOpcionsByRespuestaExId;
    }

    public void setRespuestaExOrdenOpcionsByRespuestaExId(Collection<RespuestaExOrdenOpcionEntity> respuestaExOrdenOpcionsByRespuestaExId) {
        this.respuestaExOrdenOpcionsByRespuestaExId = respuestaExOrdenOpcionsByRespuestaExId;
    }
}
