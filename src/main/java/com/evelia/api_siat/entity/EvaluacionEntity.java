package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "EVALUACION", schema = "datosEveliaMinimo", catalog = "")
public class EvaluacionEntity {
    private long evaluacionId;
    private Long aulaId;
    private byte[] detalles;
    private boolean eliminado;
    private Timestamp fechaHoraFin;
    private Long id;
    private String nombre;
    private boolean publicado;
    private int cantidadPaleatorias;
    private int cantidadPobligatorias;
    private boolean ordenSecuencial;
    private boolean pregsAleatorias;
    private Timestamp fechaHoraInicio;
    private boolean mostrarRtasAlumno;
    private boolean publicacionAutomatica;
    private Long personaId;
    private boolean conPregCategorias;
    private Long eventoFinalizacionId;
    private boolean generarEvento;
    private boolean entregaAutomaticaFecha;
    private boolean enNivelAula;
    private boolean editarDesdeComision;
    private boolean alcanceAlgunos;
    private boolean duplicado;
    private AutoexamenEntity autoexamenByEvaluacionId;
    private CuestionarioEntity cuestionarioByEvaluacionId;
    private Collection<DescargaExamenEntity> descargaExamenByEvaluacionId;
    private AulaEntity aulaByAulaId;
    private TextoEntity textoByEventoFinalizacionId;
    private Collection<EvaluacionAlumnosEntity> evaluacionAlumnosByEvaluacionId;
    private Collection<EvaluacionCategoriasEvalEntity> evaluacionCategoriasEvalsByEvaluacionId;
    private Collection<EvaluacionCompartirConEntity> evaluacionCompartirConsByEvaluacionId;
    private Collection<EvaluacionFinalizadaEntity> evaluacionFinalizadasByEvaluacionId;
    private Collection<EvaluacionPreguntasEntity> evaluacionPreguntasByEvaluacionId;
    private ExamenEntity examenByEvaluacionId;

    @Id
    @Column(name = "EVALUACION_ID")
    public long getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(long evaluacionId) {
        this.evaluacionId = evaluacionId;
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
    @Column(name = "DETALLES")
    public byte[] getDetalles() {
        return detalles;
    }

    public void setDetalles(byte[] detalles) {
        this.detalles = detalles;
    }

    @Basic
    @Column(name = "ELIMINADO")
    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Basic
    @Column(name = "FECHA_HORA_FIN")
    public Timestamp getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Timestamp fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
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
    @Column(name = "PUBLICADO")
    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    @Basic
    @Column(name = "CANTIDAD_PALEATORIAS")
    public int getCantidadPaleatorias() {
        return cantidadPaleatorias;
    }

    public void setCantidadPaleatorias(int cantidadPaleatorias) {
        this.cantidadPaleatorias = cantidadPaleatorias;
    }

    @Basic
    @Column(name = "CANTIDAD_POBLIGATORIAS")
    public int getCantidadPobligatorias() {
        return cantidadPobligatorias;
    }

    public void setCantidadPobligatorias(int cantidadPobligatorias) {
        this.cantidadPobligatorias = cantidadPobligatorias;
    }

    @Basic
    @Column(name = "ORDEN_SECUENCIAL")
    public boolean isOrdenSecuencial() {
        return ordenSecuencial;
    }

    public void setOrdenSecuencial(boolean ordenSecuencial) {
        this.ordenSecuencial = ordenSecuencial;
    }

    @Basic
    @Column(name = "PREGS_ALEATORIAS")
    public boolean isPregsAleatorias() {
        return pregsAleatorias;
    }

    public void setPregsAleatorias(boolean pregsAleatorias) {
        this.pregsAleatorias = pregsAleatorias;
    }

    @Basic
    @Column(name = "FECHA_HORA_INICIO")
    public Timestamp getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Timestamp fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    @Basic
    @Column(name = "MOSTRAR_RTAS_ALUMNO")
    public boolean isMostrarRtasAlumno() {
        return mostrarRtasAlumno;
    }

    public void setMostrarRtasAlumno(boolean mostrarRtasAlumno) {
        this.mostrarRtasAlumno = mostrarRtasAlumno;
    }

    @Basic
    @Column(name = "PUBLICACION_AUTOMATICA")
    public boolean isPublicacionAutomatica() {
        return publicacionAutomatica;
    }

    public void setPublicacionAutomatica(boolean publicacionAutomatica) {
        this.publicacionAutomatica = publicacionAutomatica;
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
    @Column(name = "CON_PREG_CATEGORIAS")
    public boolean isConPregCategorias() {
        return conPregCategorias;
    }

    public void setConPregCategorias(boolean conPregCategorias) {
        this.conPregCategorias = conPregCategorias;
    }

    @Basic
    @Column(name = "EVENTO_FINALIZACION_ID")
    public Long getEventoFinalizacionId() {
        return eventoFinalizacionId;
    }

    public void setEventoFinalizacionId(Long eventoFinalizacionId) {
        this.eventoFinalizacionId = eventoFinalizacionId;
    }

    @Basic
    @Column(name = "GENERAR_EVENTO")
    public boolean isGenerarEvento() {
        return generarEvento;
    }

    public void setGenerarEvento(boolean generarEvento) {
        this.generarEvento = generarEvento;
    }

    @Basic
    @Column(name = "ENTREGA_AUTOMATICA_FECHA")
    public boolean isEntregaAutomaticaFecha() {
        return entregaAutomaticaFecha;
    }

    public void setEntregaAutomaticaFecha(boolean entregaAutomaticaFecha) {
        this.entregaAutomaticaFecha = entregaAutomaticaFecha;
    }

    @Basic
    @Column(name = "EN_NIVEL_AULA")
    public boolean isEnNivelAula() {
        return enNivelAula;
    }

    public void setEnNivelAula(boolean enNivelAula) {
        this.enNivelAula = enNivelAula;
    }

    @Basic
    @Column(name = "EDITAR_DESDE_COMISION")
    public boolean isEditarDesdeComision() {
        return editarDesdeComision;
    }

    public void setEditarDesdeComision(boolean editarDesdeComision) {
        this.editarDesdeComision = editarDesdeComision;
    }

    @Basic
    @Column(name = "ALCANCE_ALGUNOS")
    public boolean isAlcanceAlgunos() {
        return alcanceAlgunos;
    }

    public void setAlcanceAlgunos(boolean alcanceAlgunos) {
        this.alcanceAlgunos = alcanceAlgunos;
    }

    @Basic
    @Column(name = "DUPLICADO")
    public boolean isDuplicado() {
        return duplicado;
    }

    public void setDuplicado(boolean duplicado) {
        this.duplicado = duplicado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluacionEntity that = (EvaluacionEntity) o;

        if (evaluacionId != that.evaluacionId) return false;
        if (eliminado != that.eliminado) return false;
        if (publicado != that.publicado) return false;
        if (cantidadPaleatorias != that.cantidadPaleatorias) return false;
        if (cantidadPobligatorias != that.cantidadPobligatorias) return false;
        if (ordenSecuencial != that.ordenSecuencial) return false;
        if (pregsAleatorias != that.pregsAleatorias) return false;
        if (mostrarRtasAlumno != that.mostrarRtasAlumno) return false;
        if (publicacionAutomatica != that.publicacionAutomatica) return false;
        if (conPregCategorias != that.conPregCategorias) return false;
        if (generarEvento != that.generarEvento) return false;
        if (entregaAutomaticaFecha != that.entregaAutomaticaFecha) return false;
        if (enNivelAula != that.enNivelAula) return false;
        if (editarDesdeComision != that.editarDesdeComision) return false;
        if (alcanceAlgunos != that.alcanceAlgunos) return false;
        if (duplicado != that.duplicado) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (!Arrays.equals(detalles, that.detalles)) return false;
        if (fechaHoraFin != null ? !fechaHoraFin.equals(that.fechaHoraFin) : that.fechaHoraFin != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (fechaHoraInicio != null ? !fechaHoraInicio.equals(that.fechaHoraInicio) : that.fechaHoraInicio != null)
            return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (eventoFinalizacionId != null ? !eventoFinalizacionId.equals(that.eventoFinalizacionId) : that.eventoFinalizacionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (evaluacionId ^ (evaluacionId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(detalles);
        result = 31 * result + (eliminado ? 1 : 0);
        result = 31 * result + (fechaHoraFin != null ? fechaHoraFin.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (publicado ? 1 : 0);
        result = 31 * result + cantidadPaleatorias;
        result = 31 * result + cantidadPobligatorias;
        result = 31 * result + (ordenSecuencial ? 1 : 0);
        result = 31 * result + (pregsAleatorias ? 1 : 0);
        result = 31 * result + (fechaHoraInicio != null ? fechaHoraInicio.hashCode() : 0);
        result = 31 * result + (mostrarRtasAlumno ? 1 : 0);
        result = 31 * result + (publicacionAutomatica ? 1 : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (conPregCategorias ? 1 : 0);
        result = 31 * result + (eventoFinalizacionId != null ? eventoFinalizacionId.hashCode() : 0);
        result = 31 * result + (generarEvento ? 1 : 0);
        result = 31 * result + (entregaAutomaticaFecha ? 1 : 0);
        result = 31 * result + (enNivelAula ? 1 : 0);
        result = 31 * result + (editarDesdeComision ? 1 : 0);
        result = 31 * result + (alcanceAlgunos ? 1 : 0);
        result = 31 * result + (duplicado ? 1 : 0);
        return result;
    }

    @OneToOne(mappedBy = "evaluacionByAutoexamenId")
    public AutoexamenEntity getAutoexamenByEvaluacionId() {
        return autoexamenByEvaluacionId;
    }

    public void setAutoexamenByEvaluacionId(AutoexamenEntity autoexamenByEvaluacionId) {
        this.autoexamenByEvaluacionId = autoexamenByEvaluacionId;
    }

    @OneToOne(mappedBy = "evaluacionByCuestionarioId")
    public CuestionarioEntity getCuestionarioByEvaluacionId() {
        return cuestionarioByEvaluacionId;
    }

    public void setCuestionarioByEvaluacionId(CuestionarioEntity cuestionarioByEvaluacionId) {
        this.cuestionarioByEvaluacionId = cuestionarioByEvaluacionId;
    }

    @OneToMany(mappedBy = "evaluacionByExamenId")
    public Collection<DescargaExamenEntity> getDescargaExamenByEvaluacionId() {
        return descargaExamenByEvaluacionId;
    }

    public void setDescargaExamenByEvaluacionId(Collection<DescargaExamenEntity> descargaExamenByEvaluacionId) {
        this.descargaExamenByEvaluacionId = descargaExamenByEvaluacionId;
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
    @JoinColumn(name = "EVENTO_FINALIZACION_ID", referencedColumnName = "TEXTO_ID", insertable=false, updatable=false)
    public TextoEntity getTextoByEventoFinalizacionId() {
        return textoByEventoFinalizacionId;
    }

    public void setTextoByEventoFinalizacionId(TextoEntity textoByEventoFinalizacionId) {
        this.textoByEventoFinalizacionId = textoByEventoFinalizacionId;
    }

    @OneToMany(mappedBy = "evaluacionByEvaluacionId")
    public Collection<EvaluacionAlumnosEntity> getEvaluacionAlumnosByEvaluacionId() {
        return evaluacionAlumnosByEvaluacionId;
    }

    public void setEvaluacionAlumnosByEvaluacionId(Collection<EvaluacionAlumnosEntity> evaluacionAlumnosByEvaluacionId) {
        this.evaluacionAlumnosByEvaluacionId = evaluacionAlumnosByEvaluacionId;
    }

    @OneToMany(mappedBy = "evaluacionByEvaluacionId")
    public Collection<EvaluacionCategoriasEvalEntity> getEvaluacionCategoriasEvalsByEvaluacionId() {
        return evaluacionCategoriasEvalsByEvaluacionId;
    }

    public void setEvaluacionCategoriasEvalsByEvaluacionId(Collection<EvaluacionCategoriasEvalEntity> evaluacionCategoriasEvalsByEvaluacionId) {
        this.evaluacionCategoriasEvalsByEvaluacionId = evaluacionCategoriasEvalsByEvaluacionId;
    }

    @OneToMany(mappedBy = "evaluacionByEvaluacionId")
    public Collection<EvaluacionCompartirConEntity> getEvaluacionCompartirConsByEvaluacionId() {
        return evaluacionCompartirConsByEvaluacionId;
    }

    public void setEvaluacionCompartirConsByEvaluacionId(Collection<EvaluacionCompartirConEntity> evaluacionCompartirConsByEvaluacionId) {
        this.evaluacionCompartirConsByEvaluacionId = evaluacionCompartirConsByEvaluacionId;
    }

    @OneToMany(mappedBy = "evaluacionByEvaluacionId")
    public Collection<EvaluacionFinalizadaEntity> getEvaluacionFinalizadasByEvaluacionId() {
        return evaluacionFinalizadasByEvaluacionId;
    }

    public void setEvaluacionFinalizadasByEvaluacionId(Collection<EvaluacionFinalizadaEntity> evaluacionFinalizadasByEvaluacionId) {
        this.evaluacionFinalizadasByEvaluacionId = evaluacionFinalizadasByEvaluacionId;
    }

    @OneToMany(mappedBy = "evaluacionByEvaluacionId")
    public Collection<EvaluacionPreguntasEntity> getEvaluacionPreguntasByEvaluacionId() {
        return evaluacionPreguntasByEvaluacionId;
    }

    public void setEvaluacionPreguntasByEvaluacionId(Collection<EvaluacionPreguntasEntity> evaluacionPreguntasByEvaluacionId) {
        this.evaluacionPreguntasByEvaluacionId = evaluacionPreguntasByEvaluacionId;
    }

    @OneToOne(mappedBy = "evaluacionByExamenId")
    public ExamenEntity getExamenByEvaluacionId() {
        return examenByEvaluacionId;
    }

    public void setExamenByEvaluacionId(ExamenEntity examenByEvaluacionId) {
        this.examenByEvaluacionId = examenByEvaluacionId;
    }
}
