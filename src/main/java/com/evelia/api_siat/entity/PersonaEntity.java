package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "PERSONA", schema = "datosEveliaMinimo", catalog = "")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "PK_SEQ")
    //@TableGenerator(name = "PK_SEQ", table = "SEQUENCE_TABLE",pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_COUNT")    
   /* @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_SEQ")
    @SequenceGenerator(name = "PK_SEQ", sequenceName = "SEQUENCE_NAME", allocationSize = 10)
    @Column(name = "PERSONA_ID",updatable = false,nullable=false)*/
    private long personaId;
    private Boolean activarMailPersonal;
    private Byte activarRecepcionMensajes;
    private String alturaCalle;
    private String apellido;
    private String calle;
    private Long ciudadId;
    private String comparteInfo;
    private String email;
    private String empresaCelular;
    private Timestamp fechaCambioClave;
    private Timestamp fechaIngreso;
    private Timestamp fechaNacimiento;
    private Long id;
    private String login;
    private String nacionalidad;
    private String nombre;
    private String numeroCelular;
    private String numeroDoc;
    private String password;
    private String recibeInfoCelular;
    private String recibeInfoMail;
    private String sexo;
    private String telefono;
    private String tipoDoc;
    private String pathFoto;
    private String caracteristicaCelular;
    private Boolean desarrollador;
    private Long carpetaPersonalId;
    private Long configuracionPersonalId;
    private String creadaDesde;
    //private String observacion;
    private Collection<AccesoPaginaEntity> accesoPaginasByPersonaId;
    private Collection<ActividadEntity> actividadsByPersonaId;
    private Collection<AgendaEntity> agendaByPersonaId;
    private Collection<AgendaEntity> agendaByPersonaId_0;
    private Collection<ArchivoEntity> archivosByPersonaId;
    private Collection<ArchivoCompartidoAulaEntity> archivoCompartidoAulasByPersonaId;
    private Collection<ArchivoVersionadoEntity> archivoVersionadosByPersonaId;
    private Collection<AulaEntity> aulasByPersonaId;
    private Collection<CalificacionActividadEntity> calificacionActividadsByPersonaId;
    private Collection<CalificacionActividadEntity> calificacionActividadsByPersonaId_0;
    private Collection<ComentarioEntity> comentariosByPersonaId;
    private Collection<CuentaCorreoEntity> cuentaCorreosByPersonaId;
    private Collection<DescargaMaterialEntity> descargaMaterialsByPersonaId;
    private Collection<DestinatarioEntity> destinatariosByPersonaId;
    private Collection<DocenteSolicitadoEntity> docenteSolicitadosByPersonaId;
    private Collection<EncuestaSiatPersonaEntity> encuestaSiatPersonasByPersonaId;
    private Collection<EvaluacionAlumnosEntity> evaluacionAlumnosByPersonaId;
    private Collection<EvaluacionCompartirConEntity> evaluacionCompartirConsByPersonaId;
    private Collection<EvaluacionFinalizadaEntity> evaluacionFinalizadasByPersonaId;
    private Collection<ExamenFinalizadoEntity> examenFinalizadosByPersonaId;
    private Collection<ForoEntity> forosByPersonaId;
    private Collection<ForoModeradoresEntity> foroModeradoresByPersonaId;
    private Collection<InvitacionEntity> invitacionsByPersonaId;
    private Collection<ItemAulaPermisoEntity> itemAulaPermisosByPersonaId;
    private Collection<ListaContactosEntity> listaContactosByPersonaId;
    private Collection<ListaContactosPersonasEntity> listaContactosPersonasByPersonaId;
    private Collection<LogEntity> logsByPersonaId;
    private Collection<MensajeEntity> mensajesByPersonaId;
    private Collection<NotaEntity> notasByPersonaId;
    private Collection<ParticipanteEntity> participantesByPersonaId;
    private Collection<ParticipanteEntity> participantesByPersonaId_0;
    private Collection<ParticipanteComisionEntity> participanteComisionsByPersonaId;
    private Collection<PedidoInformeEntity> pedidoInformesByPersonaId;
    private CiudadEntity ciudadByCiudadId;
    private MiMaterialEntity miMaterialByCarpetaPersonalId;
    private ConfiguracionPersonalEntity configuracionPersonalByConfiguracionPersonalId;
    private Collection<PersonaArchivoCompartidaEntity> personaArchivoCompartidasByPersonaId;
    private Collection<PersonaArchivoCompartidaEntity> personaArchivoCompartidasByPersonaId_0;
    private Collection<PersonaAreaInteresEntity> personaAreaInteresByPersonaId;
    private Collection<PersonaMensajeIngresoEntity> personaMensajeIngresosByPersonaId;
    private Collection<PersonaPermisoAccesoEntity> personaPermisoAccesosByPersonaId;
    private Collection<PlantillaPermisoEntity> plantillaPermisosByPersonaId;
    private Collection<PlantillaPermisoEntity> plantillaPermisosByPersonaId_0;
    private Collection<PreguntaExEntity> preguntaExesByPersonaId;
    private Collection<RespuestaEntity> respuestasByPersonaId;
    private Collection<SeguimientoAccesoEntity> seguimientoAccesosByPersonaId;
    private Collection<SeguimientoAccesoElementoEntity> seguimientoAccesoElementosByPersonaId;
    private Collection<SeguimientoAlmacenamientoMaterialEntity> seguimientoAlmacenamientoMaterialsByPersonaId;
    private Collection<SeguimientoAlmacenamientoMaterialEntity> seguimientoAlmacenamientoMaterialsByPersonaId_0;
    private Collection<SeguimientoExamenEntity> seguimientoExamenByPersonaId;
    private Collection<SesionChatEntity> sesionChatsByPersonaId;
    private Collection<SolicitudAulaEntity> solicitudAulasByPersonaId;
    private Collection<TextoEntity> textosByPersonaId;
    private Collection<TipoCalificacionEntity> tipoCalificacionsByPersonaId;
    private Collection<VideoconferenciaEntity> videoconferenciasByPersonaId;
    private Collection<VideoconferenciaModeradoresEntity> videoconferenciaModeradoresByPersonaId;
    private Collection<VideoconferenciaParticipantesEntity> videoconferenciaParticipantesByPersonaId;

    @Id
    @Column(name = "PERSONA_ID")
    public long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(long personaId) {
        this.personaId = personaId;
    }

    @Basic
    @Column(name = "ACTIVAR_MAIL_PERSONAL")
    public Boolean getActivarMailPersonal() {
        return activarMailPersonal;
    }

    public void setActivarMailPersonal(Boolean activarMailPersonal) {
        this.activarMailPersonal = activarMailPersonal;
    }

    @Basic
    @Column(name = "ACTIVAR_RECEPCION_MENSAJES")
    public Byte getActivarRecepcionMensajes() {
        return activarRecepcionMensajes;
    }

    public void setActivarRecepcionMensajes(Byte activarRecepcionMensajes) {
        this.activarRecepcionMensajes = activarRecepcionMensajes;
    }

    @Basic
    @Column(name = "ALTURA_CALLE")
    public String getAlturaCalle() {
        return alturaCalle;
    }

    public void setAlturaCalle(String alturaCalle) {
        this.alturaCalle = alturaCalle;
    }

    @Basic
    @Column(name = "APELLIDO")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "CALLE")
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Basic
    @Column(name = "CIUDAD_ID")
    public Long getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Long ciudadId) {
        this.ciudadId = ciudadId;
    }

    @Basic
    @Column(name = "COMPARTE_INFO")
    public String getComparteInfo() {
        return comparteInfo;
    }

    public void setComparteInfo(String comparteInfo) {
        this.comparteInfo = comparteInfo;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "EMPRESA_CELULAR")
    public String getEmpresaCelular() {
        return empresaCelular;
    }

    public void setEmpresaCelular(String empresaCelular) {
        this.empresaCelular = empresaCelular;
    }

    @Basic
    @Column(name = "FECHA_CAMBIO_CLAVE")
    public Timestamp getFechaCambioClave() {
        return fechaCambioClave;
    }

    public void setFechaCambioClave(Timestamp fechaCambioClave) {
        this.fechaCambioClave = fechaCambioClave;
    }

    @Basic
    @Column(name = "FECHA_INGRESO")
    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Basic
    @Column(name = "FECHA_NACIMIENTO")
    public Timestamp getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Timestamp fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "NACIONALIDAD")
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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
    @Column(name = "NUMERO_CELULAR")
    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    @Basic
    @Column(name = "NUMERO_DOC")
    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "RECIBE_INFO_CELULAR")
    public String getRecibeInfoCelular() {
        return recibeInfoCelular;
    }

    public void setRecibeInfoCelular(String recibeInfoCelular) {
        this.recibeInfoCelular = recibeInfoCelular;
    }

    @Basic
    @Column(name = "RECIBE_INFO_MAIL")
    public String getRecibeInfoMail() {
        return recibeInfoMail;
    }

    public void setRecibeInfoMail(String recibeInfoMail) {
        this.recibeInfoMail = recibeInfoMail;
    }

    @Basic
    @Column(name = "SEXO")
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "TELEFONO")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "TIPO_DOC")
    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    @Basic
    @Column(name = "PATH_FOTO")
    public String getPathFoto() {
        return pathFoto;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }

    @Basic
    @Column(name = "CARACTERISTICA_CELULAR")
    public String getCaracteristicaCelular() {
        return caracteristicaCelular;
    }

    public void setCaracteristicaCelular(String caracteristicaCelular) {
        this.caracteristicaCelular = caracteristicaCelular;
    }

    @Basic
    @Column(name = "DESARROLLADOR")
    public Boolean getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Boolean desarrollador) {
        this.desarrollador = desarrollador;
    }

    @Basic
    @Column(name = "CARPETA_PERSONAL_ID")
    public Long getCarpetaPersonalId() {
        return carpetaPersonalId;
    }

    public void setCarpetaPersonalId(Long carpetaPersonalId) {
        this.carpetaPersonalId = carpetaPersonalId;
    }

    @Basic
    @Column(name = "CONFIGURACION_PERSONAL_ID")
    public Long getConfiguracionPersonalId() {
        return configuracionPersonalId;
    }

    public void setConfiguracionPersonalId(Long configuracionPersonalId) {
        this.configuracionPersonalId = configuracionPersonalId;
    }

    @Basic
    @Column(name = "CREADA_DESDE")
    public String getCreadaDesde() {
        return creadaDesde;
    }

    public void setCreadaDesde(String creadaDesde) {
        this.creadaDesde = creadaDesde;
    }

 /*   @Basic
    @Column(name = "OBSERVACION")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonaEntity that = (PersonaEntity) o;

        if (personaId != that.personaId) return false;
        if (activarMailPersonal != null ? !activarMailPersonal.equals(that.activarMailPersonal) : that.activarMailPersonal != null)
            return false;
        if (activarRecepcionMensajes != null ? !activarRecepcionMensajes.equals(that.activarRecepcionMensajes) : that.activarRecepcionMensajes != null)
            return false;
        if (alturaCalle != null ? !alturaCalle.equals(that.alturaCalle) : that.alturaCalle != null) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (calle != null ? !calle.equals(that.calle) : that.calle != null) return false;
        if (ciudadId != null ? !ciudadId.equals(that.ciudadId) : that.ciudadId != null) return false;
        if (comparteInfo != null ? !comparteInfo.equals(that.comparteInfo) : that.comparteInfo != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (empresaCelular != null ? !empresaCelular.equals(that.empresaCelular) : that.empresaCelular != null)
            return false;
        if (fechaCambioClave != null ? !fechaCambioClave.equals(that.fechaCambioClave) : that.fechaCambioClave != null)
            return false;
        if (fechaIngreso != null ? !fechaIngreso.equals(that.fechaIngreso) : that.fechaIngreso != null) return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(that.fechaNacimiento) : that.fechaNacimiento != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (nacionalidad != null ? !nacionalidad.equals(that.nacionalidad) : that.nacionalidad != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (numeroCelular != null ? !numeroCelular.equals(that.numeroCelular) : that.numeroCelular != null)
            return false;
        if (numeroDoc != null ? !numeroDoc.equals(that.numeroDoc) : that.numeroDoc != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (recibeInfoCelular != null ? !recibeInfoCelular.equals(that.recibeInfoCelular) : that.recibeInfoCelular != null)
            return false;
        if (recibeInfoMail != null ? !recibeInfoMail.equals(that.recibeInfoMail) : that.recibeInfoMail != null)
            return false;
        if (sexo != null ? !sexo.equals(that.sexo) : that.sexo != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (tipoDoc != null ? !tipoDoc.equals(that.tipoDoc) : that.tipoDoc != null) return false;
        if (pathFoto != null ? !pathFoto.equals(that.pathFoto) : that.pathFoto != null) return false;
        if (caracteristicaCelular != null ? !caracteristicaCelular.equals(that.caracteristicaCelular) : that.caracteristicaCelular != null)
            return false;
        if (desarrollador != null ? !desarrollador.equals(that.desarrollador) : that.desarrollador != null)
            return false;
        if (carpetaPersonalId != null ? !carpetaPersonalId.equals(that.carpetaPersonalId) : that.carpetaPersonalId != null)
            return false;
        if (configuracionPersonalId != null ? !configuracionPersonalId.equals(that.configuracionPersonalId) : that.configuracionPersonalId != null)
            return false;
        if (creadaDesde != null ? !creadaDesde.equals(that.creadaDesde) : that.creadaDesde != null) return false;
       // if (observacion != null ? !observacion.equals(that.observacion) : that.observacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personaId ^ (personaId >>> 32));
        result = 31 * result + (activarMailPersonal != null ? activarMailPersonal.hashCode() : 0);
        result = 31 * result + (activarRecepcionMensajes != null ? activarRecepcionMensajes.hashCode() : 0);
        result = 31 * result + (alturaCalle != null ? alturaCalle.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (calle != null ? calle.hashCode() : 0);
        result = 31 * result + (ciudadId != null ? ciudadId.hashCode() : 0);
        result = 31 * result + (comparteInfo != null ? comparteInfo.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (empresaCelular != null ? empresaCelular.hashCode() : 0);
        result = 31 * result + (fechaCambioClave != null ? fechaCambioClave.hashCode() : 0);
        result = 31 * result + (fechaIngreso != null ? fechaIngreso.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (numeroCelular != null ? numeroCelular.hashCode() : 0);
        result = 31 * result + (numeroDoc != null ? numeroDoc.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (recibeInfoCelular != null ? recibeInfoCelular.hashCode() : 0);
        result = 31 * result + (recibeInfoMail != null ? recibeInfoMail.hashCode() : 0);
        result = 31 * result + (sexo != null ? sexo.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (tipoDoc != null ? tipoDoc.hashCode() : 0);
        result = 31 * result + (pathFoto != null ? pathFoto.hashCode() : 0);
        result = 31 * result + (caracteristicaCelular != null ? caracteristicaCelular.hashCode() : 0);
        result = 31 * result + (desarrollador != null ? desarrollador.hashCode() : 0);
        result = 31 * result + (carpetaPersonalId != null ? carpetaPersonalId.hashCode() : 0);
        result = 31 * result + (configuracionPersonalId != null ? configuracionPersonalId.hashCode() : 0);
        result = 31 * result + (creadaDesde != null ? creadaDesde.hashCode() : 0);
       // result = 31 * result + (observacion != null ? observacion.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<AccesoPaginaEntity> getAccesoPaginasByPersonaId() {
        return accesoPaginasByPersonaId;
    }

    public void setAccesoPaginasByPersonaId(Collection<AccesoPaginaEntity> accesoPaginasByPersonaId) {
        this.accesoPaginasByPersonaId = accesoPaginasByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<ActividadEntity> getActividadsByPersonaId() {
        return actividadsByPersonaId;
    }

    public void setActividadsByPersonaId(Collection<ActividadEntity> actividadsByPersonaId) {
        this.actividadsByPersonaId = actividadsByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<AgendaEntity> getAgendaByPersonaId() {
        return agendaByPersonaId;
    }

    public void setAgendaByPersonaId(Collection<AgendaEntity> agendaByPersonaId) {
        this.agendaByPersonaId = agendaByPersonaId;
    }

    @OneToMany(mappedBy = "personaByContactoId")
    public Collection<AgendaEntity> getAgendaByPersonaId_0() {
        return agendaByPersonaId_0;
    }

    public void setAgendaByPersonaId_0(Collection<AgendaEntity> agendaByPersonaId_0) {
        this.agendaByPersonaId_0 = agendaByPersonaId_0;
    }

    @OneToMany(mappedBy = "personaByAutorId")
    public Collection<ArchivoEntity> getArchivosByPersonaId() {
        return archivosByPersonaId;
    }

    public void setArchivosByPersonaId(Collection<ArchivoEntity> archivosByPersonaId) {
        this.archivosByPersonaId = archivosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<ArchivoCompartidoAulaEntity> getArchivoCompartidoAulasByPersonaId() {
        return archivoCompartidoAulasByPersonaId;
    }

    public void setArchivoCompartidoAulasByPersonaId(Collection<ArchivoCompartidoAulaEntity> archivoCompartidoAulasByPersonaId) {
        this.archivoCompartidoAulasByPersonaId = archivoCompartidoAulasByPersonaId;
    }

    @OneToMany(mappedBy = "personaByAutorId")
    public Collection<ArchivoVersionadoEntity> getArchivoVersionadosByPersonaId() {
        return archivoVersionadosByPersonaId;
    }

    public void setArchivoVersionadosByPersonaId(Collection<ArchivoVersionadoEntity> archivoVersionadosByPersonaId) {
        this.archivoVersionadosByPersonaId = archivoVersionadosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByCreadaPorId")
    public Collection<AulaEntity> getAulasByPersonaId() {
        return aulasByPersonaId;
    }

    public void setAulasByPersonaId(Collection<AulaEntity> aulasByPersonaId) {
        this.aulasByPersonaId = aulasByPersonaId;
    }

    @OneToMany(mappedBy = "personaByAutorCalificacionId")
    public Collection<CalificacionActividadEntity> getCalificacionActividadsByPersonaId() {
        return calificacionActividadsByPersonaId;
    }

    public void setCalificacionActividadsByPersonaId(Collection<CalificacionActividadEntity> calificacionActividadsByPersonaId) {
        this.calificacionActividadsByPersonaId = calificacionActividadsByPersonaId;
    }

    @OneToMany(mappedBy = "personaByAutorDevolucionId")
    public Collection<CalificacionActividadEntity> getCalificacionActividadsByPersonaId_0() {
        return calificacionActividadsByPersonaId_0;
    }

    public void setCalificacionActividadsByPersonaId_0(Collection<CalificacionActividadEntity> calificacionActividadsByPersonaId_0) {
        this.calificacionActividadsByPersonaId_0 = calificacionActividadsByPersonaId_0;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<ComentarioEntity> getComentariosByPersonaId() {
        return comentariosByPersonaId;
    }

    public void setComentariosByPersonaId(Collection<ComentarioEntity> comentariosByPersonaId) {
        this.comentariosByPersonaId = comentariosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<CuentaCorreoEntity> getCuentaCorreosByPersonaId() {
        return cuentaCorreosByPersonaId;
    }

    public void setCuentaCorreosByPersonaId(Collection<CuentaCorreoEntity> cuentaCorreosByPersonaId) {
        this.cuentaCorreosByPersonaId = cuentaCorreosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<DescargaMaterialEntity> getDescargaMaterialsByPersonaId() {
        return descargaMaterialsByPersonaId;
    }

    public void setDescargaMaterialsByPersonaId(Collection<DescargaMaterialEntity> descargaMaterialsByPersonaId) {
        this.descargaMaterialsByPersonaId = descargaMaterialsByPersonaId;
    }

    @OneToMany(mappedBy = "personaByReceptorId")
    public Collection<DestinatarioEntity> getDestinatariosByPersonaId() {
        return destinatariosByPersonaId;
    }

    public void setDestinatariosByPersonaId(Collection<DestinatarioEntity> destinatariosByPersonaId) {
        this.destinatariosByPersonaId = destinatariosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByDocenteRegistradoId")
    public Collection<DocenteSolicitadoEntity> getDocenteSolicitadosByPersonaId() {
        return docenteSolicitadosByPersonaId;
    }

    public void setDocenteSolicitadosByPersonaId(Collection<DocenteSolicitadoEntity> docenteSolicitadosByPersonaId) {
        this.docenteSolicitadosByPersonaId = docenteSolicitadosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<EncuestaSiatPersonaEntity> getEncuestaSiatPersonasByPersonaId() {
        return encuestaSiatPersonasByPersonaId;
    }

    public void setEncuestaSiatPersonasByPersonaId(Collection<EncuestaSiatPersonaEntity> encuestaSiatPersonasByPersonaId) {
        this.encuestaSiatPersonasByPersonaId = encuestaSiatPersonasByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<EvaluacionAlumnosEntity> getEvaluacionAlumnosByPersonaId() {
        return evaluacionAlumnosByPersonaId;
    }

    public void setEvaluacionAlumnosByPersonaId(Collection<EvaluacionAlumnosEntity> evaluacionAlumnosByPersonaId) {
        this.evaluacionAlumnosByPersonaId = evaluacionAlumnosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<EvaluacionCompartirConEntity> getEvaluacionCompartirConsByPersonaId() {
        return evaluacionCompartirConsByPersonaId;
    }

    public void setEvaluacionCompartirConsByPersonaId(Collection<EvaluacionCompartirConEntity> evaluacionCompartirConsByPersonaId) {
        this.evaluacionCompartirConsByPersonaId = evaluacionCompartirConsByPersonaId;
    }

    @OneToMany(mappedBy = "personaByAlumnoId")
    public Collection<EvaluacionFinalizadaEntity> getEvaluacionFinalizadasByPersonaId() {
        return evaluacionFinalizadasByPersonaId;
    }

    public void setEvaluacionFinalizadasByPersonaId(Collection<EvaluacionFinalizadaEntity> evaluacionFinalizadasByPersonaId) {
        this.evaluacionFinalizadasByPersonaId = evaluacionFinalizadasByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<ExamenFinalizadoEntity> getExamenFinalizadosByPersonaId() {
        return examenFinalizadosByPersonaId;
    }

    public void setExamenFinalizadosByPersonaId(Collection<ExamenFinalizadoEntity> examenFinalizadosByPersonaId) {
        this.examenFinalizadosByPersonaId = examenFinalizadosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByAutorId")
    public Collection<ForoEntity> getForosByPersonaId() {
        return forosByPersonaId;
    }

    public void setForosByPersonaId(Collection<ForoEntity> forosByPersonaId) {
        this.forosByPersonaId = forosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<ForoModeradoresEntity> getForoModeradoresByPersonaId() {
        return foroModeradoresByPersonaId;
    }

    public void setForoModeradoresByPersonaId(Collection<ForoModeradoresEntity> foroModeradoresByPersonaId) {
        this.foroModeradoresByPersonaId = foroModeradoresByPersonaId;
    }

    @OneToMany(mappedBy = "personaByInvolucradoId")
    public Collection<InvitacionEntity> getInvitacionsByPersonaId() {
        return invitacionsByPersonaId;
    }

    public void setInvitacionsByPersonaId(Collection<InvitacionEntity> invitacionsByPersonaId) {
        this.invitacionsByPersonaId = invitacionsByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<ItemAulaPermisoEntity> getItemAulaPermisosByPersonaId() {
        return itemAulaPermisosByPersonaId;
    }

    public void setItemAulaPermisosByPersonaId(Collection<ItemAulaPermisoEntity> itemAulaPermisosByPersonaId) {
        this.itemAulaPermisosByPersonaId = itemAulaPermisosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByAutorId")
    public Collection<ListaContactosEntity> getListaContactosByPersonaId() {
        return listaContactosByPersonaId;
    }

    public void setListaContactosByPersonaId(Collection<ListaContactosEntity> listaContactosByPersonaId) {
        this.listaContactosByPersonaId = listaContactosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<ListaContactosPersonasEntity> getListaContactosPersonasByPersonaId() {
        return listaContactosPersonasByPersonaId;
    }

    public void setListaContactosPersonasByPersonaId(Collection<ListaContactosPersonasEntity> listaContactosPersonasByPersonaId) {
        this.listaContactosPersonasByPersonaId = listaContactosPersonasByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<LogEntity> getLogsByPersonaId() {
        return logsByPersonaId;
    }

    public void setLogsByPersonaId(Collection<LogEntity> logsByPersonaId) {
        this.logsByPersonaId = logsByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<MensajeEntity> getMensajesByPersonaId() {
        return mensajesByPersonaId;
    }

    public void setMensajesByPersonaId(Collection<MensajeEntity> mensajesByPersonaId) {
        this.mensajesByPersonaId = mensajesByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<NotaEntity> getNotasByPersonaId() {
        return notasByPersonaId;
    }

    public void setNotasByPersonaId(Collection<NotaEntity> notasByPersonaId) {
        this.notasByPersonaId = notasByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<ParticipanteEntity> getParticipantesByPersonaId() {
        return participantesByPersonaId;
    }

    public void setParticipantesByPersonaId(Collection<ParticipanteEntity> participantesByPersonaId) {
        this.participantesByPersonaId = participantesByPersonaId;
    }

    @OneToMany(mappedBy = "personaByAgregadoPorId")
    public Collection<ParticipanteEntity> getParticipantesByPersonaId_0() {
        return participantesByPersonaId_0;
    }

    public void setParticipantesByPersonaId_0(Collection<ParticipanteEntity> participantesByPersonaId_0) {
        this.participantesByPersonaId_0 = participantesByPersonaId_0;
    }

    @OneToMany(mappedBy = "personaByAgregadoPorId")
    public Collection<ParticipanteComisionEntity> getParticipanteComisionsByPersonaId() {
        return participanteComisionsByPersonaId;
    }

    public void setParticipanteComisionsByPersonaId(Collection<ParticipanteComisionEntity> participanteComisionsByPersonaId) {
        this.participanteComisionsByPersonaId = participanteComisionsByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<PedidoInformeEntity> getPedidoInformesByPersonaId() {
        return pedidoInformesByPersonaId;
    }

    public void setPedidoInformesByPersonaId(Collection<PedidoInformeEntity> pedidoInformesByPersonaId) {
        this.pedidoInformesByPersonaId = pedidoInformesByPersonaId;
    }

    @ManyToOne
    @JoinColumn(name = "CIUDAD_ID", referencedColumnName = "CIUDAD_ID", insertable=false, updatable=false)
    public CiudadEntity getCiudadByCiudadId() {
        return ciudadByCiudadId;
    }

    public void setCiudadByCiudadId(CiudadEntity ciudadByCiudadId) {
        this.ciudadByCiudadId = ciudadByCiudadId;
    }

    @ManyToOne
    @JoinColumn(name = "CARPETA_PERSONAL_ID", referencedColumnName = "MI_MATERIAL_ID", insertable=false, updatable=false)
    public MiMaterialEntity getMiMaterialByCarpetaPersonalId() {
        return miMaterialByCarpetaPersonalId;
    }

    public void setMiMaterialByCarpetaPersonalId(MiMaterialEntity miMaterialByCarpetaPersonalId) {
        this.miMaterialByCarpetaPersonalId = miMaterialByCarpetaPersonalId;
    }

    @ManyToOne
    @JoinColumn(name = "CONFIGURACION_PERSONAL_ID", referencedColumnName = "CONFIGURACION_PERSONAL_ID", insertable=false, updatable=false)
    public ConfiguracionPersonalEntity getConfiguracionPersonalByConfiguracionPersonalId() {
        return configuracionPersonalByConfiguracionPersonalId;
    }

    public void setConfiguracionPersonalByConfiguracionPersonalId(ConfiguracionPersonalEntity configuracionPersonalByConfiguracionPersonalId) {
        this.configuracionPersonalByConfiguracionPersonalId = configuracionPersonalByConfiguracionPersonalId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<PersonaArchivoCompartidaEntity> getPersonaArchivoCompartidasByPersonaId() {
        return personaArchivoCompartidasByPersonaId;
    }

    public void setPersonaArchivoCompartidasByPersonaId(Collection<PersonaArchivoCompartidaEntity> personaArchivoCompartidasByPersonaId) {
        this.personaArchivoCompartidasByPersonaId = personaArchivoCompartidasByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaDueniaDelArchivoId")
    public Collection<PersonaArchivoCompartidaEntity> getPersonaArchivoCompartidasByPersonaId_0() {
        return personaArchivoCompartidasByPersonaId_0;
    }

    public void setPersonaArchivoCompartidasByPersonaId_0(Collection<PersonaArchivoCompartidaEntity> personaArchivoCompartidasByPersonaId_0) {
        this.personaArchivoCompartidasByPersonaId_0 = personaArchivoCompartidasByPersonaId_0;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<PersonaAreaInteresEntity> getPersonaAreaInteresByPersonaId() {
        return personaAreaInteresByPersonaId;
    }

    public void setPersonaAreaInteresByPersonaId(Collection<PersonaAreaInteresEntity> personaAreaInteresByPersonaId) {
        this.personaAreaInteresByPersonaId = personaAreaInteresByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<PersonaMensajeIngresoEntity> getPersonaMensajeIngresosByPersonaId() {
        return personaMensajeIngresosByPersonaId;
    }

    public void setPersonaMensajeIngresosByPersonaId(Collection<PersonaMensajeIngresoEntity> personaMensajeIngresosByPersonaId) {
        this.personaMensajeIngresosByPersonaId = personaMensajeIngresosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<PersonaPermisoAccesoEntity> getPersonaPermisoAccesosByPersonaId() {
        return personaPermisoAccesosByPersonaId;
    }

    public void setPersonaPermisoAccesosByPersonaId(Collection<PersonaPermisoAccesoEntity> personaPermisoAccesosByPersonaId) {
        this.personaPermisoAccesosByPersonaId = personaPermisoAccesosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByAutorId")
    public Collection<PlantillaPermisoEntity> getPlantillaPermisosByPersonaId() {
        return plantillaPermisosByPersonaId;
    }

    public void setPlantillaPermisosByPersonaId(Collection<PlantillaPermisoEntity> plantillaPermisosByPersonaId) {
        this.plantillaPermisosByPersonaId = plantillaPermisosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByModificadoPorId")
    public Collection<PlantillaPermisoEntity> getPlantillaPermisosByPersonaId_0() {
        return plantillaPermisosByPersonaId_0;
    }

    public void setPlantillaPermisosByPersonaId_0(Collection<PlantillaPermisoEntity> plantillaPermisosByPersonaId_0) {
        this.plantillaPermisosByPersonaId_0 = plantillaPermisosByPersonaId_0;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<PreguntaExEntity> getPreguntaExesByPersonaId() {
        return preguntaExesByPersonaId;
    }

    public void setPreguntaExesByPersonaId(Collection<PreguntaExEntity> preguntaExesByPersonaId) {
        this.preguntaExesByPersonaId = preguntaExesByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<RespuestaEntity> getRespuestasByPersonaId() {
        return respuestasByPersonaId;
    }

    public void setRespuestasByPersonaId(Collection<RespuestaEntity> respuestasByPersonaId) {
        this.respuestasByPersonaId = respuestasByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<SeguimientoAccesoEntity> getSeguimientoAccesosByPersonaId() {
        return seguimientoAccesosByPersonaId;
    }

    public void setSeguimientoAccesosByPersonaId(Collection<SeguimientoAccesoEntity> seguimientoAccesosByPersonaId) {
        this.seguimientoAccesosByPersonaId = seguimientoAccesosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<SeguimientoAccesoElementoEntity> getSeguimientoAccesoElementosByPersonaId() {
        return seguimientoAccesoElementosByPersonaId;
    }

    public void setSeguimientoAccesoElementosByPersonaId(Collection<SeguimientoAccesoElementoEntity> seguimientoAccesoElementosByPersonaId) {
        this.seguimientoAccesoElementosByPersonaId = seguimientoAccesoElementosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByResponsableId")
    public Collection<SeguimientoAlmacenamientoMaterialEntity> getSeguimientoAlmacenamientoMaterialsByPersonaId() {
        return seguimientoAlmacenamientoMaterialsByPersonaId;
    }

    public void setSeguimientoAlmacenamientoMaterialsByPersonaId(Collection<SeguimientoAlmacenamientoMaterialEntity> seguimientoAlmacenamientoMaterialsByPersonaId) {
        this.seguimientoAlmacenamientoMaterialsByPersonaId = seguimientoAlmacenamientoMaterialsByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<SeguimientoAlmacenamientoMaterialEntity> getSeguimientoAlmacenamientoMaterialsByPersonaId_0() {
        return seguimientoAlmacenamientoMaterialsByPersonaId_0;
    }

    public void setSeguimientoAlmacenamientoMaterialsByPersonaId_0(Collection<SeguimientoAlmacenamientoMaterialEntity> seguimientoAlmacenamientoMaterialsByPersonaId_0) {
        this.seguimientoAlmacenamientoMaterialsByPersonaId_0 = seguimientoAlmacenamientoMaterialsByPersonaId_0;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<SeguimientoExamenEntity> getSeguimientoExamenByPersonaId() {
        return seguimientoExamenByPersonaId;
    }

    public void setSeguimientoExamenByPersonaId(Collection<SeguimientoExamenEntity> seguimientoExamenByPersonaId) {
        this.seguimientoExamenByPersonaId = seguimientoExamenByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<SesionChatEntity> getSesionChatsByPersonaId() {
        return sesionChatsByPersonaId;
    }

    public void setSesionChatsByPersonaId(Collection<SesionChatEntity> sesionChatsByPersonaId) {
        this.sesionChatsByPersonaId = sesionChatsByPersonaId;
    }

    @OneToMany(mappedBy = "personaBySolicitanteId")
    public Collection<SolicitudAulaEntity> getSolicitudAulasByPersonaId() {
        return solicitudAulasByPersonaId;
    }

    public void setSolicitudAulasByPersonaId(Collection<SolicitudAulaEntity> solicitudAulasByPersonaId) {
        this.solicitudAulasByPersonaId = solicitudAulasByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<TextoEntity> getTextosByPersonaId() {
        return textosByPersonaId;
    }

    public void setTextosByPersonaId(Collection<TextoEntity> textosByPersonaId) {
        this.textosByPersonaId = textosByPersonaId;
    }

    @OneToMany(mappedBy = "personaByAutorId")
    public Collection<TipoCalificacionEntity> getTipoCalificacionsByPersonaId() {
        return tipoCalificacionsByPersonaId;
    }

    public void setTipoCalificacionsByPersonaId(Collection<TipoCalificacionEntity> tipoCalificacionsByPersonaId) {
        this.tipoCalificacionsByPersonaId = tipoCalificacionsByPersonaId;
    }

    @OneToMany(mappedBy = "personaByAutorId")
    public Collection<VideoconferenciaEntity> getVideoconferenciasByPersonaId() {
        return videoconferenciasByPersonaId;
    }

    public void setVideoconferenciasByPersonaId(Collection<VideoconferenciaEntity> videoconferenciasByPersonaId) {
        this.videoconferenciasByPersonaId = videoconferenciasByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<VideoconferenciaModeradoresEntity> getVideoconferenciaModeradoresByPersonaId() {
        return videoconferenciaModeradoresByPersonaId;
    }

    public void setVideoconferenciaModeradoresByPersonaId(Collection<VideoconferenciaModeradoresEntity> videoconferenciaModeradoresByPersonaId) {
        this.videoconferenciaModeradoresByPersonaId = videoconferenciaModeradoresByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<VideoconferenciaParticipantesEntity> getVideoconferenciaParticipantesByPersonaId() {
        return videoconferenciaParticipantesByPersonaId;
    }

    public void setVideoconferenciaParticipantesByPersonaId(Collection<VideoconferenciaParticipantesEntity> videoconferenciaParticipantesByPersonaId) {
        this.videoconferenciaParticipantesByPersonaId = videoconferenciaParticipantesByPersonaId;
    }
}
