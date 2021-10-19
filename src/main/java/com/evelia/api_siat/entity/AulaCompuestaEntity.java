package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "AULA_COMPUESTA", schema = "datosEveliaMinimo", catalog = "")
public class AulaCompuestaEntity{
    private long aulaCompuestaId;
    private Long areaId;
    private String codigo;
    private Byte esOferta;
    private Long estadoAulaId;
    private byte[] informacion;
    private String modalidad;
    private String pathLogo;
    private Long programaId;
    private byte[] textoPromocion;
    private String tipoAcceso;
    private Long inscripcionOnlineId;
    private Boolean informacionPublica;
    private Integer cantNoticiasMostrar;
    private Integer cantMensajesMostrar;
    private boolean mostrarMiniCalendario;
    private Integer cantDiasAlertaActividad;
    private Integer cantDiasAlertaCalendario;
    private Integer cantDiasAlertaEvaluacion;
    private Integer cantDiasAlertaIniForo;
    private Integer cantDiasAlertaFinForo;
    private Timestamp fechaInicioUso;
    private Timestamp fechaPasoHistorial;
    private boolean inscripcionComisiones;
    private boolean inscripcionUnicaComision;
    private Long plantillaPermisoId;
    private String versionSiat;
    private Timestamp fechaModifInformacion;
    private boolean infoDuplicado;
    private boolean infoBorrador;
    private Collection<AulaEntity> aulasByAulaCompuestaId;
    private AulaEntity aulaByAulaCompuestaId;
    private AreaEntity areaByAreaId;
    private EstadoAulaEntity estadoAulaByEstadoAulaId;
    private ProgramaEntity programaByProgramaId;
    private InscripcionOnLineEntity inscripcionOnLineByInscripcionOnlineId;
    private PlantillaPermisoEntity plantillaPermisoByPlantillaPermisoId;
    private CursoEntity cursoByAulaCompuestaId;
    private FacultadEntity facultadByAulaCompuestaId;
    private Collection<HorarioEntity> horariosByAulaCompuestaId;
    private OrganizacionEntity organizacionByAulaCompuestaId;

    @Id
    @Column(name = "AULA_COMPUESTA_ID")
    public long getAulaCompuestaId() {  
           return aulaCompuestaId;
    }

    public void setAulaCompuestaId(long aulaCompuestaId) {
        this.aulaCompuestaId = aulaCompuestaId;
    }

    @Basic
    @Column(name = "AREA_ID")
    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "CODIGO")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "ES_OFERTA")
    public Byte getEsOferta() {
        return esOferta;
    }

    public void setEsOferta(Byte esOferta) {
        this.esOferta = esOferta;
    }

    @Basic
    @Column(name = "ESTADO_AULA_ID")
    public Long getEstadoAulaId() {
        return estadoAulaId;
    }

    public void setEstadoAulaId(Long estadoAulaId) {
        this.estadoAulaId = estadoAulaId;
    }

    @Basic
    @Column(name = "INFORMACION")
    public byte[] getInformacion() {
        return informacion;
    }

    public void setInformacion(byte[] informacion) {
        this.informacion = informacion;
    }

    @Basic
    @Column(name = "MODALIDAD")
    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @Basic
    @Column(name = "PATH_LOGO")
    public String getPathLogo() {
        return pathLogo;
    }

    public void setPathLogo(String pathLogo) {
        this.pathLogo = pathLogo;
    }

    @Basic
    @Column(name = "PROGRAMA_ID")
    public Long getProgramaId() {
        return programaId;
    }

    public void setProgramaId(Long programaId) {
        this.programaId = programaId;
    }

    @Basic
    @Column(name = "TEXTO_PROMOCION")
    public byte[] getTextoPromocion() {
        return textoPromocion;
    }

    public void setTextoPromocion(byte[] textoPromocion) {
        this.textoPromocion = textoPromocion;
    }

    @Basic
    @Column(name = "TIPO_ACCESO")
    public String getTipoAcceso() {
        return tipoAcceso;
    }

    public void setTipoAcceso(String tipoAcceso) {
        this.tipoAcceso = tipoAcceso;
    }

    @Basic
    @Column(name = "INSCRIPCION_ONLINE_ID")
    public Long getInscripcionOnlineId() {
        return inscripcionOnlineId;
    }

    public void setInscripcionOnlineId(Long inscripcionOnlineId) {
        this.inscripcionOnlineId = inscripcionOnlineId;
    }

    @Basic
    @Column(name = "INFORMACION_PUBLICA")
    public Boolean getInformacionPublica() {
        return informacionPublica;
    }

    public void setInformacionPublica(Boolean informacionPublica) {
        this.informacionPublica = informacionPublica;
    }

    @Basic
    @Column(name = "CANT_NOTICIAS_MOSTRAR")
    public Integer getCantNoticiasMostrar() {
        return cantNoticiasMostrar;
    }

    public void setCantNoticiasMostrar(Integer cantNoticiasMostrar) {
        this.cantNoticiasMostrar = cantNoticiasMostrar;
    }

    @Basic
    @Column(name = "CANT_MENSAJES_MOSTRAR")
    public Integer getCantMensajesMostrar() {
        return cantMensajesMostrar;
    }

    public void setCantMensajesMostrar(Integer cantMensajesMostrar) {
        this.cantMensajesMostrar = cantMensajesMostrar;
    }

    @Basic
    @Column(name = "MOSTRAR_MINI_CALENDARIO")
    public boolean isMostrarMiniCalendario() {
        return mostrarMiniCalendario;
    }

    public void setMostrarMiniCalendario(boolean mostrarMiniCalendario) {
        this.mostrarMiniCalendario = mostrarMiniCalendario;
    }

    @Basic
    @Column(name = "CANT_DIAS_ALERTA_ACTIVIDAD")
    public Integer getCantDiasAlertaActividad() {
        return cantDiasAlertaActividad;
    }

    public void setCantDiasAlertaActividad(Integer cantDiasAlertaActividad) {
        this.cantDiasAlertaActividad = cantDiasAlertaActividad;
    }

    @Basic
    @Column(name = "CANT_DIAS_ALERTA_CALENDARIO")
    public Integer getCantDiasAlertaCalendario() {
        return cantDiasAlertaCalendario;
    }

    public void setCantDiasAlertaCalendario(Integer cantDiasAlertaCalendario) {
        this.cantDiasAlertaCalendario = cantDiasAlertaCalendario;
    }

    @Basic
    @Column(name = "CANT_DIAS_ALERTA_EVALUACION")
    public Integer getCantDiasAlertaEvaluacion() {
        return cantDiasAlertaEvaluacion;
    }

    public void setCantDiasAlertaEvaluacion(Integer cantDiasAlertaEvaluacion) {
        this.cantDiasAlertaEvaluacion = cantDiasAlertaEvaluacion;
    }

    @Basic
    @Column(name = "CANT_DIAS_ALERTA_INI_FORO")
    public Integer getCantDiasAlertaIniForo() {
        return cantDiasAlertaIniForo;
    }

    public void setCantDiasAlertaIniForo(Integer cantDiasAlertaIniForo) {
        this.cantDiasAlertaIniForo = cantDiasAlertaIniForo;
    }

    @Basic
    @Column(name = "CANT_DIAS_ALERTA_FIN_FORO")
    public Integer getCantDiasAlertaFinForo() {
        return cantDiasAlertaFinForo;
    }

    public void setCantDiasAlertaFinForo(Integer cantDiasAlertaFinForo) {
        this.cantDiasAlertaFinForo = cantDiasAlertaFinForo;
    }

    @Basic
    @Column(name = "FECHA_INICIO_USO")
    public Timestamp getFechaInicioUso() {
        return fechaInicioUso;
    }

    public void setFechaInicioUso(Timestamp fechaInicioUso) {
        this.fechaInicioUso = fechaInicioUso;
    }

    @Basic
    @Column(name = "FECHA_PASO_HISTORIAL")
    public Timestamp getFechaPasoHistorial() {
        return fechaPasoHistorial;
    }

    public void setFechaPasoHistorial(Timestamp fechaPasoHistorial) {
        this.fechaPasoHistorial = fechaPasoHistorial;
    }

    @Basic
    @Column(name = "INSCRIPCION_COMISIONES")
    public boolean isInscripcionComisiones() {
        return inscripcionComisiones;
    }

    public void setInscripcionComisiones(boolean inscripcionComisiones) {
        this.inscripcionComisiones = inscripcionComisiones;
    }

    @Basic
    @Column(name = "INSCRIPCION_UNICA_COMISION")
    public boolean isInscripcionUnicaComision() {
        return inscripcionUnicaComision;
    }

    public void setInscripcionUnicaComision(boolean inscripcionUnicaComision) {
        this.inscripcionUnicaComision = inscripcionUnicaComision;
    }

    @Basic
    @Column(name = "PLANTILLA_PERMISO_ID")
    public Long getPlantillaPermisoId() {
        return plantillaPermisoId;
    }

    public void setPlantillaPermisoId(Long plantillaPermisoId) {
        this.plantillaPermisoId = plantillaPermisoId;
    }

    @Basic
    @Column(name = "VERSION_SIAT")
    public String getVersionSiat() {
        return versionSiat;
    }

    public void setVersionSiat(String versionSiat) {
        this.versionSiat = versionSiat;
    }

    @Basic
    @Column(name = "FECHA_MODIF_INFORMACION")
    public Timestamp getFechaModifInformacion() {
        return fechaModifInformacion;
    }

    public void setFechaModifInformacion(Timestamp fechaModifInformacion) {
        this.fechaModifInformacion = fechaModifInformacion;
    }

    @Basic
    @Column(name = "INFO_DUPLICADO")
    public boolean isInfoDuplicado() {
        return infoDuplicado;
    }

    public void setInfoDuplicado(boolean infoDuplicado) {
        this.infoDuplicado = infoDuplicado;
    }

    @Basic
    @Column(name = "INFO_BORRADOR")
    public boolean isInfoBorrador() {
        return infoBorrador;
    }

    public void setInfoBorrador(boolean infoBorrador) {
        this.infoBorrador = infoBorrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AulaCompuestaEntity that = (AulaCompuestaEntity) o;

        if (aulaCompuestaId != that.aulaCompuestaId) return false;
        if (mostrarMiniCalendario != that.mostrarMiniCalendario) return false;
        if (inscripcionComisiones != that.inscripcionComisiones) return false;
        if (inscripcionUnicaComision != that.inscripcionUnicaComision) return false;
        if (infoDuplicado != that.infoDuplicado) return false;
        if (infoBorrador != that.infoBorrador) return false;
        if (areaId != null ? !areaId.equals(that.areaId) : that.areaId != null) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (esOferta != null ? !esOferta.equals(that.esOferta) : that.esOferta != null) return false;
        if (estadoAulaId != null ? !estadoAulaId.equals(that.estadoAulaId) : that.estadoAulaId != null) return false;
        if (!Arrays.equals(informacion, that.informacion)) return false;
        if (modalidad != null ? !modalidad.equals(that.modalidad) : that.modalidad != null) return false;
        if (pathLogo != null ? !pathLogo.equals(that.pathLogo) : that.pathLogo != null) return false;
        if (programaId != null ? !programaId.equals(that.programaId) : that.programaId != null) return false;
        if (!Arrays.equals(textoPromocion, that.textoPromocion)) return false;
        if (tipoAcceso != null ? !tipoAcceso.equals(that.tipoAcceso) : that.tipoAcceso != null) return false;
        if (inscripcionOnlineId != null ? !inscripcionOnlineId.equals(that.inscripcionOnlineId) : that.inscripcionOnlineId != null)
            return false;
        if (informacionPublica != null ? !informacionPublica.equals(that.informacionPublica) : that.informacionPublica != null)
            return false;
        if (cantNoticiasMostrar != null ? !cantNoticiasMostrar.equals(that.cantNoticiasMostrar) : that.cantNoticiasMostrar != null)
            return false;
        if (cantMensajesMostrar != null ? !cantMensajesMostrar.equals(that.cantMensajesMostrar) : that.cantMensajesMostrar != null)
            return false;
        if (cantDiasAlertaActividad != null ? !cantDiasAlertaActividad.equals(that.cantDiasAlertaActividad) : that.cantDiasAlertaActividad != null)
            return false;
        if (cantDiasAlertaCalendario != null ? !cantDiasAlertaCalendario.equals(that.cantDiasAlertaCalendario) : that.cantDiasAlertaCalendario != null)
            return false;
        if (cantDiasAlertaEvaluacion != null ? !cantDiasAlertaEvaluacion.equals(that.cantDiasAlertaEvaluacion) : that.cantDiasAlertaEvaluacion != null)
            return false;
        if (cantDiasAlertaIniForo != null ? !cantDiasAlertaIniForo.equals(that.cantDiasAlertaIniForo) : that.cantDiasAlertaIniForo != null)
            return false;
        if (cantDiasAlertaFinForo != null ? !cantDiasAlertaFinForo.equals(that.cantDiasAlertaFinForo) : that.cantDiasAlertaFinForo != null)
            return false;
        if (fechaInicioUso != null ? !fechaInicioUso.equals(that.fechaInicioUso) : that.fechaInicioUso != null)
            return false;
        if (fechaPasoHistorial != null ? !fechaPasoHistorial.equals(that.fechaPasoHistorial) : that.fechaPasoHistorial != null)
            return false;
        if (plantillaPermisoId != null ? !plantillaPermisoId.equals(that.plantillaPermisoId) : that.plantillaPermisoId != null)
            return false;
        if (versionSiat != null ? !versionSiat.equals(that.versionSiat) : that.versionSiat != null) return false;
        if (fechaModifInformacion != null ? !fechaModifInformacion.equals(that.fechaModifInformacion) : that.fechaModifInformacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (aulaCompuestaId ^ (aulaCompuestaId >>> 32));
        result = 31 * result + (areaId != null ? areaId.hashCode() : 0);
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (esOferta != null ? esOferta.hashCode() : 0);
        result = 31 * result + (estadoAulaId != null ? estadoAulaId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(informacion);
        result = 31 * result + (modalidad != null ? modalidad.hashCode() : 0);
        result = 31 * result + (pathLogo != null ? pathLogo.hashCode() : 0);
        result = 31 * result + (programaId != null ? programaId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(textoPromocion);
        result = 31 * result + (tipoAcceso != null ? tipoAcceso.hashCode() : 0);
        result = 31 * result + (inscripcionOnlineId != null ? inscripcionOnlineId.hashCode() : 0);
        result = 31 * result + (informacionPublica != null ? informacionPublica.hashCode() : 0);
        result = 31 * result + (cantNoticiasMostrar != null ? cantNoticiasMostrar.hashCode() : 0);
        result = 31 * result + (cantMensajesMostrar != null ? cantMensajesMostrar.hashCode() : 0);
        result = 31 * result + (mostrarMiniCalendario ? 1 : 0);
        result = 31 * result + (cantDiasAlertaActividad != null ? cantDiasAlertaActividad.hashCode() : 0);
        result = 31 * result + (cantDiasAlertaCalendario != null ? cantDiasAlertaCalendario.hashCode() : 0);
        result = 31 * result + (cantDiasAlertaEvaluacion != null ? cantDiasAlertaEvaluacion.hashCode() : 0);
        result = 31 * result + (cantDiasAlertaIniForo != null ? cantDiasAlertaIniForo.hashCode() : 0);
        result = 31 * result + (cantDiasAlertaFinForo != null ? cantDiasAlertaFinForo.hashCode() : 0);
        result = 31 * result + (fechaInicioUso != null ? fechaInicioUso.hashCode() : 0);
        result = 31 * result + (fechaPasoHistorial != null ? fechaPasoHistorial.hashCode() : 0);
        result = 31 * result + (inscripcionComisiones ? 1 : 0);
        result = 31 * result + (inscripcionUnicaComision ? 1 : 0);
        result = 31 * result + (plantillaPermisoId != null ? plantillaPermisoId.hashCode() : 0);
        result = 31 * result + (versionSiat != null ? versionSiat.hashCode() : 0);
        result = 31 * result + (fechaModifInformacion != null ? fechaModifInformacion.hashCode() : 0);
        result = 31 * result + (infoDuplicado ? 1 : 0);
        result = 31 * result + (infoBorrador ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "aulaCompuestaByAulaCompuestaId")
    public Collection<AulaEntity> getAulasByAulaCompuestaId() {
        return aulasByAulaCompuestaId;
    }

    public void setAulasByAulaCompuestaId(Collection<AulaEntity> aulasByAulaCompuestaId) {
        this.aulasByAulaCompuestaId = aulasByAulaCompuestaId;
    }

    @OneToOne
    @JoinColumn(name = "AULA_COMPUESTA_ID", referencedColumnName = "AULA_ID", nullable = false, insertable=false, updatable=false)
    public AulaEntity getAulaByAulaCompuestaId() {
        return aulaByAulaCompuestaId;
    }

    public void setAulaByAulaCompuestaId(AulaEntity aulaByAulaCompuestaId) {
        this.aulaByAulaCompuestaId = aulaByAulaCompuestaId;
    }

    @ManyToOne
    @JoinColumn(name = "AREA_ID", referencedColumnName = "AREA_ID", insertable=false, updatable=false)
    public AreaEntity getAreaByAreaId() {
        return areaByAreaId;
    }

    public void setAreaByAreaId(AreaEntity areaByAreaId) {
        this.areaByAreaId = areaByAreaId;
    }

    @ManyToOne
    @JoinColumn(name = "ESTADO_AULA_ID", referencedColumnName = "ESTADO_AULA_ID", insertable=false, updatable=false)
    public EstadoAulaEntity getEstadoAulaByEstadoAulaId() {
        return estadoAulaByEstadoAulaId;
    }

    public void setEstadoAulaByEstadoAulaId(EstadoAulaEntity estadoAulaByEstadoAulaId) {
        this.estadoAulaByEstadoAulaId = estadoAulaByEstadoAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "PROGRAMA_ID", referencedColumnName = "PROGRAMA_ID", insertable=false, updatable=false)
    public ProgramaEntity getProgramaByProgramaId() {
        return programaByProgramaId;
    }

    public void setProgramaByProgramaId(ProgramaEntity programaByProgramaId) {
        this.programaByProgramaId = programaByProgramaId;
    }

    @ManyToOne
    @JoinColumn(name = "INSCRIPCION_ONLINE_ID", referencedColumnName = "INSCRIPCION_ON_LINE_ID", insertable=false, updatable=false)
    public InscripcionOnLineEntity getInscripcionOnLineByInscripcionOnlineId() {
        return inscripcionOnLineByInscripcionOnlineId;
    }

    public void setInscripcionOnLineByInscripcionOnlineId(InscripcionOnLineEntity inscripcionOnLineByInscripcionOnlineId) {
        this.inscripcionOnLineByInscripcionOnlineId = inscripcionOnLineByInscripcionOnlineId;
    }

    @ManyToOne
    @JoinColumn(name = "PLANTILLA_PERMISO_ID", referencedColumnName = "PLANTILLA_PERMISO_ID", insertable=false, updatable=false)
    public PlantillaPermisoEntity getPlantillaPermisoByPlantillaPermisoId() {
        return plantillaPermisoByPlantillaPermisoId;
    }

    public void setPlantillaPermisoByPlantillaPermisoId(PlantillaPermisoEntity plantillaPermisoByPlantillaPermisoId) {
        this.plantillaPermisoByPlantillaPermisoId = plantillaPermisoByPlantillaPermisoId;
    }

    @OneToOne(mappedBy = "aulaCompuestaByCursoId")
    public CursoEntity getCursoByAulaCompuestaId() {
        return cursoByAulaCompuestaId;
    }

    public void setCursoByAulaCompuestaId(CursoEntity cursoByAulaCompuestaId) {
        this.cursoByAulaCompuestaId = cursoByAulaCompuestaId;
    }

    @OneToOne(mappedBy = "aulaCompuestaByFacultadId")
    public FacultadEntity getFacultadByAulaCompuestaId() {
        return facultadByAulaCompuestaId;
    }

    public void setFacultadByAulaCompuestaId(FacultadEntity facultadByAulaCompuestaId) {
        this.facultadByAulaCompuestaId = facultadByAulaCompuestaId;
    }

    @OneToMany(mappedBy = "aulaCompuestaByAulaCompuestaId")
    public Collection<HorarioEntity> getHorariosByAulaCompuestaId() {
        return horariosByAulaCompuestaId;
    }

    public void setHorariosByAulaCompuestaId(Collection<HorarioEntity> horariosByAulaCompuestaId) {
        this.horariosByAulaCompuestaId = horariosByAulaCompuestaId;
    }

    @OneToOne(mappedBy = "aulaCompuestaByOrganizacionId")
    public OrganizacionEntity getOrganizacionByAulaCompuestaId() {
        return organizacionByAulaCompuestaId;
    }

    public void setOrganizacionByAulaCompuestaId(OrganizacionEntity organizacionByAulaCompuestaId) {
        this.organizacionByAulaCompuestaId = organizacionByAulaCompuestaId;
    }
}
