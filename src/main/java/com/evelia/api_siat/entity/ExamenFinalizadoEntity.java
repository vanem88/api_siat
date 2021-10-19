package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "EXAMEN_FINALIZADO", schema = "datosEveliaMinimo", catalog = "")
public class ExamenFinalizadoEntity {
    private long examenFinalizadoId;
    private boolean corregido;
    private double notaFinal;
    private String reasignar;
    private Timestamp fechaCalificado;
    private Timestamp tiempoRestante;
    private Timestamp fechaProrrogaInicio;
    private Timestamp fechaProrrogaFin;
    private Long personaId;
    private Timestamp primerIngreso;
    private int cantidadIngresos;
    private Long tiempoRealizacion;
    private String host;
    private String guardadoDesde;
    private Timestamp ultimoIngreso;
    private EvaluacionFinalizadaConRespuestasEntity evaluacionFinalizadaConRespuestasByExamenFinalizadoId;
    private PersonaEntity personaByPersonaId;

    @Id
    @Column(name = "EXAMEN_FINALIZADO_ID")
    public long getExamenFinalizadoId() {
        return examenFinalizadoId;
    }

    public void setExamenFinalizadoId(long examenFinalizadoId) {
        this.examenFinalizadoId = examenFinalizadoId;
    }

    @Basic
    @Column(name = "CORREGIDO")
    public boolean isCorregido() {
        return corregido;
    }

    public void setCorregido(boolean corregido) {
        this.corregido = corregido;
    }

    @Basic
    @Column(name = "NOTA_FINAL")
    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Basic
    @Column(name = "REASIGNAR")
    public String getReasignar() {
        return reasignar;
    }

    public void setReasignar(String reasignar) {
        this.reasignar = reasignar;
    }

    @Basic
    @Column(name = "FECHA_CALIFICADO")
    public Timestamp getFechaCalificado() {
        return fechaCalificado;
    }

    public void setFechaCalificado(Timestamp fechaCalificado) {
        this.fechaCalificado = fechaCalificado;
    }

    @Basic
    @Column(name = "TIEMPO_RESTANTE")
    public Timestamp getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(Timestamp tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    @Basic
    @Column(name = "FECHA_PRORROGA_INICIO")
    public Timestamp getFechaProrrogaInicio() {
        return fechaProrrogaInicio;
    }

    public void setFechaProrrogaInicio(Timestamp fechaProrrogaInicio) {
        this.fechaProrrogaInicio = fechaProrrogaInicio;
    }

    @Basic
    @Column(name = "FECHA_PRORROGA_FIN")
    public Timestamp getFechaProrrogaFin() {
        return fechaProrrogaFin;
    }

    public void setFechaProrrogaFin(Timestamp fechaProrrogaFin) {
        this.fechaProrrogaFin = fechaProrrogaFin;
    }

    @Basic
    @Column(name = "PERSONA_ID")
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    @Basic
    @Column(name = "PRIMER_INGRESO")
    public Timestamp getPrimerIngreso() {
        return primerIngreso;
    }

    public void setPrimerIngreso(Timestamp primerIngreso) {
        this.primerIngreso = primerIngreso;
    }

    @Basic
    @Column(name = "CANTIDAD_INGRESOS")
    public int getCantidadIngresos() {
        return cantidadIngresos;
    }

    public void setCantidadIngresos(int cantidadIngresos) {
        this.cantidadIngresos = cantidadIngresos;
    }

    @Basic
    @Column(name = "TIEMPO_REALIZACION")
    public Long getTiempoRealizacion() {
        return tiempoRealizacion;
    }

    public void setTiempoRealizacion(Long tiempoRealizacion) {
        this.tiempoRealizacion = tiempoRealizacion;
    }

    @Basic
    @Column(name = "HOST")
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Basic
    @Column(name = "GUARDADO_DESDE")
    public String getGuardadoDesde() {
        return guardadoDesde;
    }

    public void setGuardadoDesde(String guardadoDesde) {
        this.guardadoDesde = guardadoDesde;
    }

    @Basic
    @Column(name = "ULTIMO_INGRESO")
    public Timestamp getUltimoIngreso() {
        return ultimoIngreso;
    }

    public void setUltimoIngreso(Timestamp ultimoIngreso) {
        this.ultimoIngreso = ultimoIngreso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamenFinalizadoEntity that = (ExamenFinalizadoEntity) o;

        if (examenFinalizadoId != that.examenFinalizadoId) return false;
        if (corregido != that.corregido) return false;
        if (Double.compare(that.notaFinal, notaFinal) != 0) return false;
        if (cantidadIngresos != that.cantidadIngresos) return false;
        if (reasignar != null ? !reasignar.equals(that.reasignar) : that.reasignar != null) return false;
        if (fechaCalificado != null ? !fechaCalificado.equals(that.fechaCalificado) : that.fechaCalificado != null)
            return false;
        if (tiempoRestante != null ? !tiempoRestante.equals(that.tiempoRestante) : that.tiempoRestante != null)
            return false;
        if (fechaProrrogaInicio != null ? !fechaProrrogaInicio.equals(that.fechaProrrogaInicio) : that.fechaProrrogaInicio != null)
            return false;
        if (fechaProrrogaFin != null ? !fechaProrrogaFin.equals(that.fechaProrrogaFin) : that.fechaProrrogaFin != null)
            return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (primerIngreso != null ? !primerIngreso.equals(that.primerIngreso) : that.primerIngreso != null)
            return false;
        if (tiempoRealizacion != null ? !tiempoRealizacion.equals(that.tiempoRealizacion) : that.tiempoRealizacion != null)
            return false;
        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (guardadoDesde != null ? !guardadoDesde.equals(that.guardadoDesde) : that.guardadoDesde != null)
            return false;
        if (ultimoIngreso != null ? !ultimoIngreso.equals(that.ultimoIngreso) : that.ultimoIngreso != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (examenFinalizadoId ^ (examenFinalizadoId >>> 32));
        result = 31 * result + (corregido ? 1 : 0);
        temp = Double.doubleToLongBits(notaFinal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (reasignar != null ? reasignar.hashCode() : 0);
        result = 31 * result + (fechaCalificado != null ? fechaCalificado.hashCode() : 0);
        result = 31 * result + (tiempoRestante != null ? tiempoRestante.hashCode() : 0);
        result = 31 * result + (fechaProrrogaInicio != null ? fechaProrrogaInicio.hashCode() : 0);
        result = 31 * result + (fechaProrrogaFin != null ? fechaProrrogaFin.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (primerIngreso != null ? primerIngreso.hashCode() : 0);
        result = 31 * result + cantidadIngresos;
        result = 31 * result + (tiempoRealizacion != null ? tiempoRealizacion.hashCode() : 0);
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (guardadoDesde != null ? guardadoDesde.hashCode() : 0);
        result = 31 * result + (ultimoIngreso != null ? ultimoIngreso.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "EXAMEN_FINALIZADO_ID", referencedColumnName = "EVALUACION_FINALIZADA_CON_RESPUESTAS_ID", nullable = false, insertable=false, updatable=false)
    public EvaluacionFinalizadaConRespuestasEntity getEvaluacionFinalizadaConRespuestasByExamenFinalizadoId() {
        return evaluacionFinalizadaConRespuestasByExamenFinalizadoId;
    }

    public void setEvaluacionFinalizadaConRespuestasByExamenFinalizadoId(EvaluacionFinalizadaConRespuestasEntity evaluacionFinalizadaConRespuestasByExamenFinalizadoId) {
        this.evaluacionFinalizadaConRespuestasByExamenFinalizadoId = evaluacionFinalizadaConRespuestasByExamenFinalizadoId;
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
