package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CONFIGURACION_NOTIFICACION", schema = "datosEveliaMinimo", catalog = "")
public class ConfiguracionNotificacionEntity {
    private long configuracionNotificacionId;
    private Long id;
    private boolean desactivarNotificaciones;
    private boolean actualizacionesSiat;
    private boolean altaEnAula;
    private boolean mensajeriaInterna;
    private boolean actividadCreada;
    private boolean actividadModificada;
    private boolean actividadCalificada;
    private boolean actividadCambioEstado;
    private boolean actividadProrroga;
    private boolean actividadRehacer;
    private boolean actividadDevolucion;
    private boolean actividadEntregas;
    private boolean actividadResumenEntregas;
    private boolean noticiaNueva;
    private boolean mensajePizarronNuevo;
    private boolean foroNuevo;
    private boolean foroModificado;
    private boolean foroPorCerrar;
    private boolean foroCerrado;
    private boolean foroNuevaOpinion;
    private boolean foroNuevaRespuesta;
    private boolean foroNuevoComentario;
    private boolean foroOpinionEliminada;
    private boolean foroResumenOpiniones;
    private boolean foroResumenRespuestas;
    private boolean foroResumenComentarios;
    private boolean materialNuevo;
    private boolean materialCompartidoMi;
    private boolean materialCompartidoAula;
    private boolean materialesResumenNuevo;
    private boolean materialesResumenModificadosEliminados;
    private boolean materialesResumenCompartidosMi;
    private boolean materialesResumenCompartidosAula;
    private boolean secretariaAlumnosInscriptos;
    private boolean secretariaAlumnosSinComision;
    private boolean secretariaInscripcionPorCaducar;
    private boolean secretariaAulaHistorial;
    private Collection<ConfiguracionPersonalEntity> configuracionPersonalsByConfiguracionNotificacionId;
    private Collection<ConfiguracionPorAulaEntity> configuracionPorAulasByConfiguracionNotificacionId;

    @Id
    @Column(name = "CONFIGURACION_NOTIFICACION_ID")
    public long getConfiguracionNotificacionId() {
        return configuracionNotificacionId;
    }

    public void setConfiguracionNotificacionId(long configuracionNotificacionId) {
        this.configuracionNotificacionId = configuracionNotificacionId;
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
    @Column(name = "DESACTIVAR_NOTIFICACIONES")
    public boolean isDesactivarNotificaciones() {
        return desactivarNotificaciones;
    }

    public void setDesactivarNotificaciones(boolean desactivarNotificaciones) {
        this.desactivarNotificaciones = desactivarNotificaciones;
    }

    @Basic
    @Column(name = "ACTUALIZACIONES_SIAT")
    public boolean isActualizacionesSiat() {
        return actualizacionesSiat;
    }

    public void setActualizacionesSiat(boolean actualizacionesSiat) {
        this.actualizacionesSiat = actualizacionesSiat;
    }

    @Basic
    @Column(name = "ALTA_EN_AULA")
    public boolean isAltaEnAula() {
        return altaEnAula;
    }

    public void setAltaEnAula(boolean altaEnAula) {
        this.altaEnAula = altaEnAula;
    }

    @Basic
    @Column(name = "MENSAJERIA_INTERNA")
    public boolean isMensajeriaInterna() {
        return mensajeriaInterna;
    }

    public void setMensajeriaInterna(boolean mensajeriaInterna) {
        this.mensajeriaInterna = mensajeriaInterna;
    }

    @Basic
    @Column(name = "ACTIVIDAD_CREADA")
    public boolean isActividadCreada() {
        return actividadCreada;
    }

    public void setActividadCreada(boolean actividadCreada) {
        this.actividadCreada = actividadCreada;
    }

    @Basic
    @Column(name = "ACTIVIDAD_MODIFICADA")
    public boolean isActividadModificada() {
        return actividadModificada;
    }

    public void setActividadModificada(boolean actividadModificada) {
        this.actividadModificada = actividadModificada;
    }

    @Basic
    @Column(name = "ACTIVIDAD_CALIFICADA")
    public boolean isActividadCalificada() {
        return actividadCalificada;
    }

    public void setActividadCalificada(boolean actividadCalificada) {
        this.actividadCalificada = actividadCalificada;
    }

    @Basic
    @Column(name = "ACTIVIDAD_CAMBIO_ESTADO")
    public boolean isActividadCambioEstado() {
        return actividadCambioEstado;
    }

    public void setActividadCambioEstado(boolean actividadCambioEstado) {
        this.actividadCambioEstado = actividadCambioEstado;
    }

    @Basic
    @Column(name = "ACTIVIDAD_PRORROGA")
    public boolean isActividadProrroga() {
        return actividadProrroga;
    }

    public void setActividadProrroga(boolean actividadProrroga) {
        this.actividadProrroga = actividadProrroga;
    }

    @Basic
    @Column(name = "ACTIVIDAD_REHACER")
    public boolean isActividadRehacer() {
        return actividadRehacer;
    }

    public void setActividadRehacer(boolean actividadRehacer) {
        this.actividadRehacer = actividadRehacer;
    }

    @Basic
    @Column(name = "ACTIVIDAD_DEVOLUCION")
    public boolean isActividadDevolucion() {
        return actividadDevolucion;
    }

    public void setActividadDevolucion(boolean actividadDevolucion) {
        this.actividadDevolucion = actividadDevolucion;
    }

    @Basic
    @Column(name = "ACTIVIDAD_ENTREGAS")
    public boolean isActividadEntregas() {
        return actividadEntregas;
    }

    public void setActividadEntregas(boolean actividadEntregas) {
        this.actividadEntregas = actividadEntregas;
    }

    @Basic
    @Column(name = "ACTIVIDAD_RESUMEN_ENTREGAS")
    public boolean isActividadResumenEntregas() {
        return actividadResumenEntregas;
    }

    public void setActividadResumenEntregas(boolean actividadResumenEntregas) {
        this.actividadResumenEntregas = actividadResumenEntregas;
    }

    @Basic
    @Column(name = "NOTICIA_NUEVA")
    public boolean isNoticiaNueva() {
        return noticiaNueva;
    }

    public void setNoticiaNueva(boolean noticiaNueva) {
        this.noticiaNueva = noticiaNueva;
    }

    @Basic
    @Column(name = "MENSAJE_PIZARRON_NUEVO")
    public boolean isMensajePizarronNuevo() {
        return mensajePizarronNuevo;
    }

    public void setMensajePizarronNuevo(boolean mensajePizarronNuevo) {
        this.mensajePizarronNuevo = mensajePizarronNuevo;
    }

    @Basic
    @Column(name = "FORO_NUEVO")
    public boolean isForoNuevo() {
        return foroNuevo;
    }

    public void setForoNuevo(boolean foroNuevo) {
        this.foroNuevo = foroNuevo;
    }

    @Basic
    @Column(name = "FORO_MODIFICADO")
    public boolean isForoModificado() {
        return foroModificado;
    }

    public void setForoModificado(boolean foroModificado) {
        this.foroModificado = foroModificado;
    }

    @Basic
    @Column(name = "FORO_POR_CERRAR")
    public boolean isForoPorCerrar() {
        return foroPorCerrar;
    }

    public void setForoPorCerrar(boolean foroPorCerrar) {
        this.foroPorCerrar = foroPorCerrar;
    }

    @Basic
    @Column(name = "FORO_CERRADO")
    public boolean isForoCerrado() {
        return foroCerrado;
    }

    public void setForoCerrado(boolean foroCerrado) {
        this.foroCerrado = foroCerrado;
    }

    @Basic
    @Column(name = "FORO_NUEVA_OPINION")
    public boolean isForoNuevaOpinion() {
        return foroNuevaOpinion;
    }

    public void setForoNuevaOpinion(boolean foroNuevaOpinion) {
        this.foroNuevaOpinion = foroNuevaOpinion;
    }

    @Basic
    @Column(name = "FORO_NUEVA_RESPUESTA")
    public boolean isForoNuevaRespuesta() {
        return foroNuevaRespuesta;
    }

    public void setForoNuevaRespuesta(boolean foroNuevaRespuesta) {
        this.foroNuevaRespuesta = foroNuevaRespuesta;
    }

    @Basic
    @Column(name = "FORO_NUEVO_COMENTARIO")
    public boolean isForoNuevoComentario() {
        return foroNuevoComentario;
    }

    public void setForoNuevoComentario(boolean foroNuevoComentario) {
        this.foroNuevoComentario = foroNuevoComentario;
    }

    @Basic
    @Column(name = "FORO_OPINION_ELIMINADA")
    public boolean isForoOpinionEliminada() {
        return foroOpinionEliminada;
    }

    public void setForoOpinionEliminada(boolean foroOpinionEliminada) {
        this.foroOpinionEliminada = foroOpinionEliminada;
    }

    @Basic
    @Column(name = "FORO_RESUMEN_OPINIONES")
    public boolean isForoResumenOpiniones() {
        return foroResumenOpiniones;
    }

    public void setForoResumenOpiniones(boolean foroResumenOpiniones) {
        this.foroResumenOpiniones = foroResumenOpiniones;
    }

    @Basic
    @Column(name = "FORO_RESUMEN_RESPUESTAS")
    public boolean isForoResumenRespuestas() {
        return foroResumenRespuestas;
    }

    public void setForoResumenRespuestas(boolean foroResumenRespuestas) {
        this.foroResumenRespuestas = foroResumenRespuestas;
    }

    @Basic
    @Column(name = "FORO_RESUMEN_COMENTARIOS")
    public boolean isForoResumenComentarios() {
        return foroResumenComentarios;
    }

    public void setForoResumenComentarios(boolean foroResumenComentarios) {
        this.foroResumenComentarios = foroResumenComentarios;
    }

    @Basic
    @Column(name = "MATERIAL_NUEVO")
    public boolean isMaterialNuevo() {
        return materialNuevo;
    }

    public void setMaterialNuevo(boolean materialNuevo) {
        this.materialNuevo = materialNuevo;
    }

    @Basic
    @Column(name = "MATERIAL_COMPARTIDO_MI")
    public boolean isMaterialCompartidoMi() {
        return materialCompartidoMi;
    }

    public void setMaterialCompartidoMi(boolean materialCompartidoMi) {
        this.materialCompartidoMi = materialCompartidoMi;
    }

    @Basic
    @Column(name = "MATERIAL_COMPARTIDO_AULA")
    public boolean isMaterialCompartidoAula() {
        return materialCompartidoAula;
    }

    public void setMaterialCompartidoAula(boolean materialCompartidoAula) {
        this.materialCompartidoAula = materialCompartidoAula;
    }

    @Basic
    @Column(name = "MATERIALES_RESUMEN_NUEVO")
    public boolean isMaterialesResumenNuevo() {
        return materialesResumenNuevo;
    }

    public void setMaterialesResumenNuevo(boolean materialesResumenNuevo) {
        this.materialesResumenNuevo = materialesResumenNuevo;
    }

    @Basic
    @Column(name = "MATERIALES_RESUMEN_MODIFICADOS_ELIMINADOS")
    public boolean isMaterialesResumenModificadosEliminados() {
        return materialesResumenModificadosEliminados;
    }

    public void setMaterialesResumenModificadosEliminados(boolean materialesResumenModificadosEliminados) {
        this.materialesResumenModificadosEliminados = materialesResumenModificadosEliminados;
    }

    @Basic
    @Column(name = "MATERIALES_RESUMEN_COMPARTIDOS_MI")
    public boolean isMaterialesResumenCompartidosMi() {
        return materialesResumenCompartidosMi;
    }

    public void setMaterialesResumenCompartidosMi(boolean materialesResumenCompartidosMi) {
        this.materialesResumenCompartidosMi = materialesResumenCompartidosMi;
    }

    @Basic
    @Column(name = "MATERIALES_RESUMEN_COMPARTIDOS_AULA")
    public boolean isMaterialesResumenCompartidosAula() {
        return materialesResumenCompartidosAula;
    }

    public void setMaterialesResumenCompartidosAula(boolean materialesResumenCompartidosAula) {
        this.materialesResumenCompartidosAula = materialesResumenCompartidosAula;
    }

    @Basic
    @Column(name = "SECRETARIA_ALUMNOS_INSCRIPTOS")
    public boolean isSecretariaAlumnosInscriptos() {
        return secretariaAlumnosInscriptos;
    }

    public void setSecretariaAlumnosInscriptos(boolean secretariaAlumnosInscriptos) {
        this.secretariaAlumnosInscriptos = secretariaAlumnosInscriptos;
    }

    @Basic
    @Column(name = "SECRETARIA_ALUMNOS_SIN_COMISION")
    public boolean isSecretariaAlumnosSinComision() {
        return secretariaAlumnosSinComision;
    }

    public void setSecretariaAlumnosSinComision(boolean secretariaAlumnosSinComision) {
        this.secretariaAlumnosSinComision = secretariaAlumnosSinComision;
    }

    @Basic
    @Column(name = "SECRETARIA_INSCRIPCION_POR_CADUCAR")
    public boolean isSecretariaInscripcionPorCaducar() {
        return secretariaInscripcionPorCaducar;
    }

    public void setSecretariaInscripcionPorCaducar(boolean secretariaInscripcionPorCaducar) {
        this.secretariaInscripcionPorCaducar = secretariaInscripcionPorCaducar;
    }

    @Basic
    @Column(name = "SECRETARIA_AULA_HISTORIAL")
    public boolean isSecretariaAulaHistorial() {
        return secretariaAulaHistorial;
    }

    public void setSecretariaAulaHistorial(boolean secretariaAulaHistorial) {
        this.secretariaAulaHistorial = secretariaAulaHistorial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfiguracionNotificacionEntity that = (ConfiguracionNotificacionEntity) o;

        if (configuracionNotificacionId != that.configuracionNotificacionId) return false;
        if (desactivarNotificaciones != that.desactivarNotificaciones) return false;
        if (actualizacionesSiat != that.actualizacionesSiat) return false;
        if (altaEnAula != that.altaEnAula) return false;
        if (mensajeriaInterna != that.mensajeriaInterna) return false;
        if (actividadCreada != that.actividadCreada) return false;
        if (actividadModificada != that.actividadModificada) return false;
        if (actividadCalificada != that.actividadCalificada) return false;
        if (actividadCambioEstado != that.actividadCambioEstado) return false;
        if (actividadProrroga != that.actividadProrroga) return false;
        if (actividadRehacer != that.actividadRehacer) return false;
        if (actividadDevolucion != that.actividadDevolucion) return false;
        if (actividadEntregas != that.actividadEntregas) return false;
        if (actividadResumenEntregas != that.actividadResumenEntregas) return false;
        if (noticiaNueva != that.noticiaNueva) return false;
        if (mensajePizarronNuevo != that.mensajePizarronNuevo) return false;
        if (foroNuevo != that.foroNuevo) return false;
        if (foroModificado != that.foroModificado) return false;
        if (foroPorCerrar != that.foroPorCerrar) return false;
        if (foroCerrado != that.foroCerrado) return false;
        if (foroNuevaOpinion != that.foroNuevaOpinion) return false;
        if (foroNuevaRespuesta != that.foroNuevaRespuesta) return false;
        if (foroNuevoComentario != that.foroNuevoComentario) return false;
        if (foroOpinionEliminada != that.foroOpinionEliminada) return false;
        if (foroResumenOpiniones != that.foroResumenOpiniones) return false;
        if (foroResumenRespuestas != that.foroResumenRespuestas) return false;
        if (foroResumenComentarios != that.foroResumenComentarios) return false;
        if (materialNuevo != that.materialNuevo) return false;
        if (materialCompartidoMi != that.materialCompartidoMi) return false;
        if (materialCompartidoAula != that.materialCompartidoAula) return false;
        if (materialesResumenNuevo != that.materialesResumenNuevo) return false;
        if (materialesResumenModificadosEliminados != that.materialesResumenModificadosEliminados) return false;
        if (materialesResumenCompartidosMi != that.materialesResumenCompartidosMi) return false;
        if (materialesResumenCompartidosAula != that.materialesResumenCompartidosAula) return false;
        if (secretariaAlumnosInscriptos != that.secretariaAlumnosInscriptos) return false;
        if (secretariaAlumnosSinComision != that.secretariaAlumnosSinComision) return false;
        if (secretariaInscripcionPorCaducar != that.secretariaInscripcionPorCaducar) return false;
        if (secretariaAulaHistorial != that.secretariaAulaHistorial) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (configuracionNotificacionId ^ (configuracionNotificacionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (desactivarNotificaciones ? 1 : 0);
        result = 31 * result + (actualizacionesSiat ? 1 : 0);
        result = 31 * result + (altaEnAula ? 1 : 0);
        result = 31 * result + (mensajeriaInterna ? 1 : 0);
        result = 31 * result + (actividadCreada ? 1 : 0);
        result = 31 * result + (actividadModificada ? 1 : 0);
        result = 31 * result + (actividadCalificada ? 1 : 0);
        result = 31 * result + (actividadCambioEstado ? 1 : 0);
        result = 31 * result + (actividadProrroga ? 1 : 0);
        result = 31 * result + (actividadRehacer ? 1 : 0);
        result = 31 * result + (actividadDevolucion ? 1 : 0);
        result = 31 * result + (actividadEntregas ? 1 : 0);
        result = 31 * result + (actividadResumenEntregas ? 1 : 0);
        result = 31 * result + (noticiaNueva ? 1 : 0);
        result = 31 * result + (mensajePizarronNuevo ? 1 : 0);
        result = 31 * result + (foroNuevo ? 1 : 0);
        result = 31 * result + (foroModificado ? 1 : 0);
        result = 31 * result + (foroPorCerrar ? 1 : 0);
        result = 31 * result + (foroCerrado ? 1 : 0);
        result = 31 * result + (foroNuevaOpinion ? 1 : 0);
        result = 31 * result + (foroNuevaRespuesta ? 1 : 0);
        result = 31 * result + (foroNuevoComentario ? 1 : 0);
        result = 31 * result + (foroOpinionEliminada ? 1 : 0);
        result = 31 * result + (foroResumenOpiniones ? 1 : 0);
        result = 31 * result + (foroResumenRespuestas ? 1 : 0);
        result = 31 * result + (foroResumenComentarios ? 1 : 0);
        result = 31 * result + (materialNuevo ? 1 : 0);
        result = 31 * result + (materialCompartidoMi ? 1 : 0);
        result = 31 * result + (materialCompartidoAula ? 1 : 0);
        result = 31 * result + (materialesResumenNuevo ? 1 : 0);
        result = 31 * result + (materialesResumenModificadosEliminados ? 1 : 0);
        result = 31 * result + (materialesResumenCompartidosMi ? 1 : 0);
        result = 31 * result + (materialesResumenCompartidosAula ? 1 : 0);
        result = 31 * result + (secretariaAlumnosInscriptos ? 1 : 0);
        result = 31 * result + (secretariaAlumnosSinComision ? 1 : 0);
        result = 31 * result + (secretariaInscripcionPorCaducar ? 1 : 0);
        result = 31 * result + (secretariaAulaHistorial ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "configuracionNotificacionByConfiguracionNotificacionId")
    public Collection<ConfiguracionPersonalEntity> getConfiguracionPersonalsByConfiguracionNotificacionId() {
        return configuracionPersonalsByConfiguracionNotificacionId;
    }

    public void setConfiguracionPersonalsByConfiguracionNotificacionId(Collection<ConfiguracionPersonalEntity> configuracionPersonalsByConfiguracionNotificacionId) {
        this.configuracionPersonalsByConfiguracionNotificacionId = configuracionPersonalsByConfiguracionNotificacionId;
    }

    @OneToMany(mappedBy = "configuracionNotificacionByConfiguracionNotificacionId")
    public Collection<ConfiguracionPorAulaEntity> getConfiguracionPorAulasByConfiguracionNotificacionId() {
        return configuracionPorAulasByConfiguracionNotificacionId;
    }

    public void setConfiguracionPorAulasByConfiguracionNotificacionId(Collection<ConfiguracionPorAulaEntity> configuracionPorAulasByConfiguracionNotificacionId) {
        this.configuracionPorAulasByConfiguracionNotificacionId = configuracionPorAulasByConfiguracionNotificacionId;
    }
}
