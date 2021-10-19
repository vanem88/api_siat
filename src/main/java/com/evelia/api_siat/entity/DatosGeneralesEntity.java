package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "DATOS_GENERALES", schema = "datosEveliaMinimo", catalog = "")
public class DatosGeneralesEntity {
    private long datosGeneralesId;
    private Long id;
    private Boolean habilitarMensajeriaInterna;
    private Boolean notificarPorMail;
    private Boolean notificarPorMensajeInterno;
    private Integer primerAnioHistorial;
    private String nombreInstitucion;
    private String siglaInstitucion;
    private String direccionPostal;
    private String ubicacionOficina;
    private String horarioAtencion;
    private String telefonoOficina;
    private byte[] saludoMailGenerico;
    private Boolean habilitarNotificaciones;
    private String nombreSistema;
    private String siglaSistema;
    private String claveCorreo;
    private String usuarioCorreo;
    private String hostCorreo;
    private String port;
    private int cantidadCorreosPorMail;
    private String versionCkeditor;
    private String limiteArchivosPersonal;
    private String limiteArchivosAula;
    private String limiteArchivosComision;
    private String mailContacto;
    private String mailAlmacenamiento;
    private String mailCreacionAulas;
    private String versionSistema;
    private String versionTomcat;
    private String versionMysql;
    private Integer maxConeccionesMysql;
    private Integer minutosMaxInactiveInterval;
    private Integer accesosSimultaneosEstudiantesEvaluacion;
    private Integer accesosSimultaneosGrabacionesVideoconferencias;
    private boolean habilitarPdfExamenfinalizado;
    private String servidorVideoconferencias;

    @Id
    @Column(name = "DATOS_GENERALES_ID")
    public long getDatosGeneralesId() {
        return datosGeneralesId;
    }

    public void setDatosGeneralesId(long datosGeneralesId) {
        this.datosGeneralesId = datosGeneralesId;
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
    @Column(name = "HABILITAR_MENSAJERIA_INTERNA")
    public Boolean getHabilitarMensajeriaInterna() {
        return habilitarMensajeriaInterna;
    }

    public void setHabilitarMensajeriaInterna(Boolean habilitarMensajeriaInterna) {
        this.habilitarMensajeriaInterna = habilitarMensajeriaInterna;
    }

    @Basic
    @Column(name = "NOTIFICAR_POR_MAIL")
    public Boolean getNotificarPorMail() {
        return notificarPorMail;
    }

    public void setNotificarPorMail(Boolean notificarPorMail) {
        this.notificarPorMail = notificarPorMail;
    }

    @Basic
    @Column(name = "NOTIFICAR_POR_MENSAJE_INTERNO")
    public Boolean getNotificarPorMensajeInterno() {
        return notificarPorMensajeInterno;
    }

    public void setNotificarPorMensajeInterno(Boolean notificarPorMensajeInterno) {
        this.notificarPorMensajeInterno = notificarPorMensajeInterno;
    }

    @Basic
    @Column(name = "PRIMER_ANIO_HISTORIAL")
    public Integer getPrimerAnioHistorial() {
        return primerAnioHistorial;
    }

    public void setPrimerAnioHistorial(Integer primerAnioHistorial) {
        this.primerAnioHistorial = primerAnioHistorial;
    }

    @Basic
    @Column(name = "NOMBRE_INSTITUCION")
    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    @Basic
    @Column(name = "SIGLA_INSTITUCION")
    public String getSiglaInstitucion() {
        return siglaInstitucion;
    }

    public void setSiglaInstitucion(String siglaInstitucion) {
        this.siglaInstitucion = siglaInstitucion;
    }

    @Basic
    @Column(name = "DIRECCION_POSTAL")
    public String getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    @Basic
    @Column(name = "UBICACION_OFICINA")
    public String getUbicacionOficina() {
        return ubicacionOficina;
    }

    public void setUbicacionOficina(String ubicacionOficina) {
        this.ubicacionOficina = ubicacionOficina;
    }

    @Basic
    @Column(name = "HORARIO_ATENCION")
    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    @Basic
    @Column(name = "TELEFONO_OFICINA")
    public String getTelefonoOficina() {
        return telefonoOficina;
    }

    public void setTelefonoOficina(String telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    @Basic
    @Column(name = "SALUDO_MAIL_GENERICO")
    public byte[] getSaludoMailGenerico() {
        return saludoMailGenerico;
    }

    public void setSaludoMailGenerico(byte[] saludoMailGenerico) {
        this.saludoMailGenerico = saludoMailGenerico;
    }

    @Basic
    @Column(name = "HABILITAR_NOTIFICACIONES")
    public Boolean getHabilitarNotificaciones() {
        return habilitarNotificaciones;
    }

    public void setHabilitarNotificaciones(Boolean habilitarNotificaciones) {
        this.habilitarNotificaciones = habilitarNotificaciones;
    }

    @Basic
    @Column(name = "NOMBRE_SISTEMA")
    public String getNombreSistema() {
        return nombreSistema;
    }

    public void setNombreSistema(String nombreSistema) {
        this.nombreSistema = nombreSistema;
    }

    @Basic
    @Column(name = "SIGLA_SISTEMA")
    public String getSiglaSistema() {
        return siglaSistema;
    }

    public void setSiglaSistema(String siglaSistema) {
        this.siglaSistema = siglaSistema;
    }

    @Basic
    @Column(name = "CLAVE_CORREO")
    public String getClaveCorreo() {
        return claveCorreo;
    }

    public void setClaveCorreo(String claveCorreo) {
        this.claveCorreo = claveCorreo;
    }

    @Basic
    @Column(name = "USUARIO_CORREO")
    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    @Basic
    @Column(name = "HOST_CORREO")
    public String getHostCorreo() {
        return hostCorreo;
    }

    public void setHostCorreo(String hostCorreo) {
        this.hostCorreo = hostCorreo;
    }

    @Basic
    @Column(name = "PORT")
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Basic
    @Column(name = "CANTIDAD_CORREOS_POR_MAIL")
    public int getCantidadCorreosPorMail() {
        return cantidadCorreosPorMail;
    }

    public void setCantidadCorreosPorMail(int cantidadCorreosPorMail) {
        this.cantidadCorreosPorMail = cantidadCorreosPorMail;
    }

    @Basic
    @Column(name = "VERSION_CKEDITOR")
    public String getVersionCkeditor() {
        return versionCkeditor;
    }

    public void setVersionCkeditor(String versionCkeditor) {
        this.versionCkeditor = versionCkeditor;
    }

    @Basic
    @Column(name = "LIMITE_ARCHIVOS_PERSONAL")
    public String getLimiteArchivosPersonal() {
        return limiteArchivosPersonal;
    }

    public void setLimiteArchivosPersonal(String limiteArchivosPersonal) {
        this.limiteArchivosPersonal = limiteArchivosPersonal;
    }

    @Basic
    @Column(name = "LIMITE_ARCHIVOS_AULA")
    public String getLimiteArchivosAula() {
        return limiteArchivosAula;
    }

    public void setLimiteArchivosAula(String limiteArchivosAula) {
        this.limiteArchivosAula = limiteArchivosAula;
    }

    @Basic
    @Column(name = "LIMITE_ARCHIVOS_COMISION")
    public String getLimiteArchivosComision() {
        return limiteArchivosComision;
    }

    public void setLimiteArchivosComision(String limiteArchivosComision) {
        this.limiteArchivosComision = limiteArchivosComision;
    }

    @Basic
    @Column(name = "MAIL_CONTACTO")
    public String getMailContacto() {
        return mailContacto;
    }

    public void setMailContacto(String mailContacto) {
        this.mailContacto = mailContacto;
    }

    @Basic
    @Column(name = "MAIL_ALMACENAMIENTO")
    public String getMailAlmacenamiento() {
        return mailAlmacenamiento;
    }

    public void setMailAlmacenamiento(String mailAlmacenamiento) {
        this.mailAlmacenamiento = mailAlmacenamiento;
    }

    @Basic
    @Column(name = "MAIL_CREACION_AULAS")
    public String getMailCreacionAulas() {
        return mailCreacionAulas;
    }

    public void setMailCreacionAulas(String mailCreacionAulas) {
        this.mailCreacionAulas = mailCreacionAulas;
    }

    @Basic
    @Column(name = "VERSION_SISTEMA")
    public String getVersionSistema() {
        return versionSistema;
    }

    public void setVersionSistema(String versionSistema) {
        this.versionSistema = versionSistema;
    }

    @Basic
    @Column(name = "VERSION_TOMCAT")
    public String getVersionTomcat() {
        return versionTomcat;
    }

    public void setVersionTomcat(String versionTomcat) {
        this.versionTomcat = versionTomcat;
    }

    @Basic
    @Column(name = "VERSION_MYSQL")
    public String getVersionMysql() {
        return versionMysql;
    }

    public void setVersionMysql(String versionMysql) {
        this.versionMysql = versionMysql;
    }

    @Basic
    @Column(name = "MAX_CONECCIONES_MYSQL")
    public Integer getMaxConeccionesMysql() {
        return maxConeccionesMysql;
    }

    public void setMaxConeccionesMysql(Integer maxConeccionesMysql) {
        this.maxConeccionesMysql = maxConeccionesMysql;
    }

    @Basic
    @Column(name = "MINUTOS_MAX_INACTIVE_INTERVAL")
    public Integer getMinutosMaxInactiveInterval() {
        return minutosMaxInactiveInterval;
    }

    public void setMinutosMaxInactiveInterval(Integer minutosMaxInactiveInterval) {
        this.minutosMaxInactiveInterval = minutosMaxInactiveInterval;
    }

    @Basic
    @Column(name = "ACCESOS_SIMULTANEOS_ESTUDIANTES_EVALUACION")
    public Integer getAccesosSimultaneosEstudiantesEvaluacion() {
        return accesosSimultaneosEstudiantesEvaluacion;
    }

    public void setAccesosSimultaneosEstudiantesEvaluacion(Integer accesosSimultaneosEstudiantesEvaluacion) {
        this.accesosSimultaneosEstudiantesEvaluacion = accesosSimultaneosEstudiantesEvaluacion;
    }

    @Basic
    @Column(name = "ACCESOS_SIMULTANEOS_GRABACIONES_VIDEOCONFERENCIAS")
    public Integer getAccesosSimultaneosGrabacionesVideoconferencias() {
        return accesosSimultaneosGrabacionesVideoconferencias;
    }

    public void setAccesosSimultaneosGrabacionesVideoconferencias(Integer accesosSimultaneosGrabacionesVideoconferencias) {
        this.accesosSimultaneosGrabacionesVideoconferencias = accesosSimultaneosGrabacionesVideoconferencias;
    }

    @Basic
    @Column(name = "HABILITAR_PDF_EXAMENFINALIZADO")
    public boolean isHabilitarPdfExamenfinalizado() {
        return habilitarPdfExamenfinalizado;
    }

    public void setHabilitarPdfExamenfinalizado(boolean habilitarPdfExamenfinalizado) {
        this.habilitarPdfExamenfinalizado = habilitarPdfExamenfinalizado;
    }

    @Basic
    @Column(name = "SERVIDOR_VIDEOCONFERENCIAS")
    public String getServidorVideoconferencias() {
        return servidorVideoconferencias;
    }

    public void setServidorVideoconferencias(String servidorVideoconferencias) {
        this.servidorVideoconferencias = servidorVideoconferencias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatosGeneralesEntity that = (DatosGeneralesEntity) o;

        if (datosGeneralesId != that.datosGeneralesId) return false;
        if (cantidadCorreosPorMail != that.cantidadCorreosPorMail) return false;
        if (habilitarPdfExamenfinalizado != that.habilitarPdfExamenfinalizado) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (habilitarMensajeriaInterna != null ? !habilitarMensajeriaInterna.equals(that.habilitarMensajeriaInterna) : that.habilitarMensajeriaInterna != null)
            return false;
        if (notificarPorMail != null ? !notificarPorMail.equals(that.notificarPorMail) : that.notificarPorMail != null)
            return false;
        if (notificarPorMensajeInterno != null ? !notificarPorMensajeInterno.equals(that.notificarPorMensajeInterno) : that.notificarPorMensajeInterno != null)
            return false;
        if (primerAnioHistorial != null ? !primerAnioHistorial.equals(that.primerAnioHistorial) : that.primerAnioHistorial != null)
            return false;
        if (nombreInstitucion != null ? !nombreInstitucion.equals(that.nombreInstitucion) : that.nombreInstitucion != null)
            return false;
        if (siglaInstitucion != null ? !siglaInstitucion.equals(that.siglaInstitucion) : that.siglaInstitucion != null)
            return false;
        if (direccionPostal != null ? !direccionPostal.equals(that.direccionPostal) : that.direccionPostal != null)
            return false;
        if (ubicacionOficina != null ? !ubicacionOficina.equals(that.ubicacionOficina) : that.ubicacionOficina != null)
            return false;
        if (horarioAtencion != null ? !horarioAtencion.equals(that.horarioAtencion) : that.horarioAtencion != null)
            return false;
        if (telefonoOficina != null ? !telefonoOficina.equals(that.telefonoOficina) : that.telefonoOficina != null)
            return false;
        if (!Arrays.equals(saludoMailGenerico, that.saludoMailGenerico)) return false;
        if (habilitarNotificaciones != null ? !habilitarNotificaciones.equals(that.habilitarNotificaciones) : that.habilitarNotificaciones != null)
            return false;
        if (nombreSistema != null ? !nombreSistema.equals(that.nombreSistema) : that.nombreSistema != null)
            return false;
        if (siglaSistema != null ? !siglaSistema.equals(that.siglaSistema) : that.siglaSistema != null) return false;
        if (claveCorreo != null ? !claveCorreo.equals(that.claveCorreo) : that.claveCorreo != null) return false;
        if (usuarioCorreo != null ? !usuarioCorreo.equals(that.usuarioCorreo) : that.usuarioCorreo != null)
            return false;
        if (hostCorreo != null ? !hostCorreo.equals(that.hostCorreo) : that.hostCorreo != null) return false;
        if (port != null ? !port.equals(that.port) : that.port != null) return false;
        if (versionCkeditor != null ? !versionCkeditor.equals(that.versionCkeditor) : that.versionCkeditor != null)
            return false;
        if (limiteArchivosPersonal != null ? !limiteArchivosPersonal.equals(that.limiteArchivosPersonal) : that.limiteArchivosPersonal != null)
            return false;
        if (limiteArchivosAula != null ? !limiteArchivosAula.equals(that.limiteArchivosAula) : that.limiteArchivosAula != null)
            return false;
        if (limiteArchivosComision != null ? !limiteArchivosComision.equals(that.limiteArchivosComision) : that.limiteArchivosComision != null)
            return false;
        if (mailContacto != null ? !mailContacto.equals(that.mailContacto) : that.mailContacto != null) return false;
        if (mailAlmacenamiento != null ? !mailAlmacenamiento.equals(that.mailAlmacenamiento) : that.mailAlmacenamiento != null)
            return false;
        if (mailCreacionAulas != null ? !mailCreacionAulas.equals(that.mailCreacionAulas) : that.mailCreacionAulas != null)
            return false;
        if (versionSistema != null ? !versionSistema.equals(that.versionSistema) : that.versionSistema != null)
            return false;
        if (versionTomcat != null ? !versionTomcat.equals(that.versionTomcat) : that.versionTomcat != null)
            return false;
        if (versionMysql != null ? !versionMysql.equals(that.versionMysql) : that.versionMysql != null) return false;
        if (maxConeccionesMysql != null ? !maxConeccionesMysql.equals(that.maxConeccionesMysql) : that.maxConeccionesMysql != null)
            return false;
        if (minutosMaxInactiveInterval != null ? !minutosMaxInactiveInterval.equals(that.minutosMaxInactiveInterval) : that.minutosMaxInactiveInterval != null)
            return false;
        if (accesosSimultaneosEstudiantesEvaluacion != null ? !accesosSimultaneosEstudiantesEvaluacion.equals(that.accesosSimultaneosEstudiantesEvaluacion) : that.accesosSimultaneosEstudiantesEvaluacion != null)
            return false;
        if (accesosSimultaneosGrabacionesVideoconferencias != null ? !accesosSimultaneosGrabacionesVideoconferencias.equals(that.accesosSimultaneosGrabacionesVideoconferencias) : that.accesosSimultaneosGrabacionesVideoconferencias != null)
            return false;
        if (servidorVideoconferencias != null ? !servidorVideoconferencias.equals(that.servidorVideoconferencias) : that.servidorVideoconferencias != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (datosGeneralesId ^ (datosGeneralesId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (habilitarMensajeriaInterna != null ? habilitarMensajeriaInterna.hashCode() : 0);
        result = 31 * result + (notificarPorMail != null ? notificarPorMail.hashCode() : 0);
        result = 31 * result + (notificarPorMensajeInterno != null ? notificarPorMensajeInterno.hashCode() : 0);
        result = 31 * result + (primerAnioHistorial != null ? primerAnioHistorial.hashCode() : 0);
        result = 31 * result + (nombreInstitucion != null ? nombreInstitucion.hashCode() : 0);
        result = 31 * result + (siglaInstitucion != null ? siglaInstitucion.hashCode() : 0);
        result = 31 * result + (direccionPostal != null ? direccionPostal.hashCode() : 0);
        result = 31 * result + (ubicacionOficina != null ? ubicacionOficina.hashCode() : 0);
        result = 31 * result + (horarioAtencion != null ? horarioAtencion.hashCode() : 0);
        result = 31 * result + (telefonoOficina != null ? telefonoOficina.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(saludoMailGenerico);
        result = 31 * result + (habilitarNotificaciones != null ? habilitarNotificaciones.hashCode() : 0);
        result = 31 * result + (nombreSistema != null ? nombreSistema.hashCode() : 0);
        result = 31 * result + (siglaSistema != null ? siglaSistema.hashCode() : 0);
        result = 31 * result + (claveCorreo != null ? claveCorreo.hashCode() : 0);
        result = 31 * result + (usuarioCorreo != null ? usuarioCorreo.hashCode() : 0);
        result = 31 * result + (hostCorreo != null ? hostCorreo.hashCode() : 0);
        result = 31 * result + (port != null ? port.hashCode() : 0);
        result = 31 * result + cantidadCorreosPorMail;
        result = 31 * result + (versionCkeditor != null ? versionCkeditor.hashCode() : 0);
        result = 31 * result + (limiteArchivosPersonal != null ? limiteArchivosPersonal.hashCode() : 0);
        result = 31 * result + (limiteArchivosAula != null ? limiteArchivosAula.hashCode() : 0);
        result = 31 * result + (limiteArchivosComision != null ? limiteArchivosComision.hashCode() : 0);
        result = 31 * result + (mailContacto != null ? mailContacto.hashCode() : 0);
        result = 31 * result + (mailAlmacenamiento != null ? mailAlmacenamiento.hashCode() : 0);
        result = 31 * result + (mailCreacionAulas != null ? mailCreacionAulas.hashCode() : 0);
        result = 31 * result + (versionSistema != null ? versionSistema.hashCode() : 0);
        result = 31 * result + (versionTomcat != null ? versionTomcat.hashCode() : 0);
        result = 31 * result + (versionMysql != null ? versionMysql.hashCode() : 0);
        result = 31 * result + (maxConeccionesMysql != null ? maxConeccionesMysql.hashCode() : 0);
        result = 31 * result + (minutosMaxInactiveInterval != null ? minutosMaxInactiveInterval.hashCode() : 0);
        result = 31 * result + (accesosSimultaneosEstudiantesEvaluacion != null ? accesosSimultaneosEstudiantesEvaluacion.hashCode() : 0);
        result = 31 * result + (accesosSimultaneosGrabacionesVideoconferencias != null ? accesosSimultaneosGrabacionesVideoconferencias.hashCode() : 0);
        result = 31 * result + (habilitarPdfExamenfinalizado ? 1 : 0);
        result = 31 * result + (servidorVideoconferencias != null ? servidorVideoconferencias.hashCode() : 0);
        return result;
    }
}
