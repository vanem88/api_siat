package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "AULA", schema = "datosEveliaMinimo", catalog = "")
public class AulaEntity {
    private long aulaId;
    private Long aulaCompuestaId;
    private Long calendarioId;
    private Long chatId;
    private Long colorFondoId;
    private Long encabezadoPaginaId;
    private Long estiloImpresionId;
    private Long estiloVistaId;
    private Long faqId;
    private Long id;
    private Long materialId;
    private Long materialAdicionalId;
    private String nombre;
    private Long novedadId;
    private Long pizarronId;
    private Long softwareId;
    private Long tipoAulaId;
    private Timestamp fechaCreacion;
    private Long listadoTemasId;
    private Long configuracionGrupoId;
    private Long configuracionGrupoBorradorId;
    private Long configuracionGrupoTodosId;
    private Long configuracionGrupoBorradorTodosId;
    private Double espacioFisicoDisponible;
    private boolean enviarMailsNotificacion;
    private Long creadaPorId;
    private Long tipoOrganizacionId;
    private Collection<ActividadEntity> actividadsByAulaId;
    private Collection<ArchivoCompartidoAulaEntity> archivoCompartidoAulasByAulaId;
    private AulaCompuestaEntity aulaCompuestaByAulaCompuestaId;
    private CalendarioEntity calendarioByCalendarioId;
    private ChatEntity chatByChatId;
    private ColorFondoEntity colorFondoByColorFondoId;
    private EncabezadoPaginaEntity encabezadoPaginaByEncabezadoPaginaId;
    private PaginaEstiloEntity paginaEstiloByEstiloImpresionId;
    private PaginaEstiloEntity paginaEstiloByEstiloVistaId;
    private FaqEntity faqByFaqId;
    private MaterialEntity materialByMaterialId;
    private MaterialAdicionalEntity materialAdicionalByMaterialAdicionalId;
    private NovedadEntity novedadByNovedadId;
    private PizarronEntity pizarronByPizarronId;
    private SoftwareEntity softwareBySoftwareId;
    private TipoAulaEntity tipoAulaByTipoAulaId;
    private ListadoTemasEntity listadoTemasByListadoTemasId;
    private ConfiguracionGrupoEntity configuracionGrupoByConfiguracionGrupoId;
    private ConfiguracionGrupoEntity configuracionGrupoByConfiguracionGrupoBorradorId;
    private ConfiguracionGrupoEntity configuracionGrupoByConfiguracionGrupoTodosId;
    private ConfiguracionGrupoEntity configuracionGrupoByConfiguracionGrupoBorradorTodosId;
    private PersonaEntity personaByCreadaPorId;
    private TipoOrganizacionEntity tipoOrganizacionByTipoOrganizacionId;
    private AulaCompuestaEntity aulaCompuestaByAulaId;
    private Collection<AulaHerramientaEntity> aulaHerramientasByAulaId;
    private Collection<AulaTipoUsuarioEntity> aulaTipoUsuariosByAulaId;
    private Collection<BibliotecaEntity> bibliotecasByAulaId;
    private ComisionEntity comisionByAulaId;
    private Collection<ConfiguracionPorAulaEntity> configuracionPorAulasByAulaId;
    private Collection<EncuestaAulaEntity> encuestaAulasByAulaId;
    private Collection<EnlaceEntity> enlacesByAulaId;
    private Collection<EvaluacionEntity> evaluacionsByAulaId;
    private Collection<ForoEntity> forosByAulaId;
    private Collection<ItemAulaPermisoEntity> itemAulaPermisosByAulaId;
    private Collection<ListaCorreoEntity> listaCorreosByAulaId;
    private Collection<MailEntity> mailByAulaId;
    private Collection<MensajeIngresoEntity> mensajeIngresosByAulaId;
    private Collection<MensajeIngresoEntity> mensajeIngresosByAulaId_0;
    private Collection<ParticipanteEntity> participantesByAulaId;
    private Collection<PedidoInformeEntity> pedidoInformesByAulaId;
    private Collection<PermisoAccesoEntity> permisoAccesosByAulaId;
    private Collection<PersonaMensajeIngresoEntity> personaMensajeIngresosByAulaId;
    private Collection<PlantillaPermisoEntity> plantillaPermisosByAulaId;
    private Collection<RedSocialRecursoEntity> redSocialRecursosByAulaId;
    private Collection<RegistroPersonaEntity> registroPersonasByAulaId;
    private Collection<RespuestaEntity> respuestasByAulaId;
    private Collection<SeguimientoAccesoEntity> seguimientoAccesosByAulaId;
    private Collection<SeguimientoAlmacenamientoMaterialEntity> seguimientoAlmacenamientoMaterialsByAulaId;
    private Collection<VideoconferenciaEntity> videoconferenciasByAulaId;

    @Id
    @Column(name = "AULA_ID")
    public long getAulaId() {
        return aulaId;
    }

    public void setAulaId(long aulaId) {
        this.aulaId = aulaId;
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
    @Column(name = "CALENDARIO_ID")
    public Long getCalendarioId() {
        return calendarioId;
    }

    public void setCalendarioId(Long calendarioId) {
        this.calendarioId = calendarioId;
    }

    @Basic
    @Column(name = "CHAT_ID")
    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    @Basic
    @Column(name = "COLOR_FONDO_ID")
    public Long getColorFondoId() {
        return colorFondoId;
    }

    public void setColorFondoId(Long colorFondoId) {
        this.colorFondoId = colorFondoId;
    }

    @Basic
    @Column(name = "ENCABEZADO_PAGINA_ID")
    public Long getEncabezadoPaginaId() {
        return encabezadoPaginaId;
    }

    public void setEncabezadoPaginaId(Long encabezadoPaginaId) {
        this.encabezadoPaginaId = encabezadoPaginaId;
    }

    @Basic
    @Column(name = "ESTILO_IMPRESION_ID")
    public Long getEstiloImpresionId() {
        return estiloImpresionId;
    }

    public void setEstiloImpresionId(Long estiloImpresionId) {
        this.estiloImpresionId = estiloImpresionId;
    }

    @Basic
    @Column(name = "ESTILO_VISTA_ID")
    public Long getEstiloVistaId() {
        return estiloVistaId;
    }

    public void setEstiloVistaId(Long estiloVistaId) {
        this.estiloVistaId = estiloVistaId;
    }

    @Basic
    @Column(name = "FAQ_ID")
    public Long getFaqId() {
        return faqId;
    }

    public void setFaqId(Long faqId) {
        this.faqId = faqId;
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
    @Column(name = "MATERIAL_ID")
    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    @Basic
    @Column(name = "MATERIAL_ADICIONAL_ID")
    public Long getMaterialAdicionalId() {
        return materialAdicionalId;
    }

    public void setMaterialAdicionalId(Long materialAdicionalId) {
        this.materialAdicionalId = materialAdicionalId;
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
    @Column(name = "NOVEDAD_ID")
    public Long getNovedadId() {
        return novedadId;
    }

    public void setNovedadId(Long novedadId) {
        this.novedadId = novedadId;
    }

    @Basic
    @Column(name = "PIZARRON_ID")
    public Long getPizarronId() {
        return pizarronId;
    }

    public void setPizarronId(Long pizarronId) {
        this.pizarronId = pizarronId;
    }

    @Basic
    @Column(name = "SOFTWARE_ID")
    public Long getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(Long softwareId) {
        this.softwareId = softwareId;
    }

    @Basic
    @Column(name = "TIPO_AULA_ID")
    public Long getTipoAulaId() {
        return tipoAulaId;
    }

    public void setTipoAulaId(Long tipoAulaId) {
        this.tipoAulaId = tipoAulaId;
    }

    @Basic
    @Column(name = "FECHA_CREACION")
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "LISTADO_TEMAS_ID")
    public Long getListadoTemasId() {
        return listadoTemasId;
    }

    public void setListadoTemasId(Long listadoTemasId) {
        this.listadoTemasId = listadoTemasId;
    }

    @Basic
    @Column(name = "CONFIGURACION_GRUPO_ID")
    public Long getConfiguracionGrupoId() {
        return configuracionGrupoId;
    }

    public void setConfiguracionGrupoId(Long configuracionGrupoId) {
        this.configuracionGrupoId = configuracionGrupoId;
    }

    @Basic
    @Column(name = "CONFIGURACION_GRUPO_BORRADOR_ID")
    public Long getConfiguracionGrupoBorradorId() {
        return configuracionGrupoBorradorId;
    }

    public void setConfiguracionGrupoBorradorId(Long configuracionGrupoBorradorId) {
        this.configuracionGrupoBorradorId = configuracionGrupoBorradorId;
    }

    @Basic
    @Column(name = "CONFIGURACION_GRUPO_TODOS_ID")
    public Long getConfiguracionGrupoTodosId() {
        return configuracionGrupoTodosId;
    }

    public void setConfiguracionGrupoTodosId(Long configuracionGrupoTodosId) {
        this.configuracionGrupoTodosId = configuracionGrupoTodosId;
    }

    @Basic
    @Column(name = "CONFIGURACION_GRUPO_BORRADOR_TODOS_ID")
    public Long getConfiguracionGrupoBorradorTodosId() {
        return configuracionGrupoBorradorTodosId;
    }

    public void setConfiguracionGrupoBorradorTodosId(Long configuracionGrupoBorradorTodosId) {
        this.configuracionGrupoBorradorTodosId = configuracionGrupoBorradorTodosId;
    }

    @Basic
    @Column(name = "ESPACIO_FISICO_DISPONIBLE")
    public Double getEspacioFisicoDisponible() {
        return espacioFisicoDisponible;
    }

    public void setEspacioFisicoDisponible(Double espacioFisicoDisponible) {
        this.espacioFisicoDisponible = espacioFisicoDisponible;
    }

    @Basic
    @Column(name = "ENVIAR_MAILS_NOTIFICACION")
    public boolean isEnviarMailsNotificacion() {
        return enviarMailsNotificacion;
    }

    public void setEnviarMailsNotificacion(boolean enviarMailsNotificacion) {
        this.enviarMailsNotificacion = enviarMailsNotificacion;
    }

    @Basic
    @Column(name = "CREADA_POR_ID")
    public Long getCreadaPorId() {
        return creadaPorId;
    }

    public void setCreadaPorId(Long creadaPorId) {
        this.creadaPorId = creadaPorId;
    }

    @Basic
    @Column(name = "TIPO_ORGANIZACION_ID")
    public Long getTipoOrganizacionId() {
        return tipoOrganizacionId;
    }

    public void setTipoOrganizacionId(Long tipoOrganizacionId) {
        this.tipoOrganizacionId = tipoOrganizacionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AulaEntity that = (AulaEntity) o;

        if (aulaId != that.aulaId) return false;
        if (enviarMailsNotificacion != that.enviarMailsNotificacion) return false;
        if (aulaCompuestaId != null ? !aulaCompuestaId.equals(that.aulaCompuestaId) : that.aulaCompuestaId != null)
            return false;
        if (calendarioId != null ? !calendarioId.equals(that.calendarioId) : that.calendarioId != null) return false;
        if (chatId != null ? !chatId.equals(that.chatId) : that.chatId != null) return false;
        if (colorFondoId != null ? !colorFondoId.equals(that.colorFondoId) : that.colorFondoId != null) return false;
        if (encabezadoPaginaId != null ? !encabezadoPaginaId.equals(that.encabezadoPaginaId) : that.encabezadoPaginaId != null)
            return false;
        if (estiloImpresionId != null ? !estiloImpresionId.equals(that.estiloImpresionId) : that.estiloImpresionId != null)
            return false;
        if (estiloVistaId != null ? !estiloVistaId.equals(that.estiloVistaId) : that.estiloVistaId != null)
            return false;
        if (faqId != null ? !faqId.equals(that.faqId) : that.faqId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (materialId != null ? !materialId.equals(that.materialId) : that.materialId != null) return false;
        if (materialAdicionalId != null ? !materialAdicionalId.equals(that.materialAdicionalId) : that.materialAdicionalId != null)
            return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (novedadId != null ? !novedadId.equals(that.novedadId) : that.novedadId != null) return false;
        if (pizarronId != null ? !pizarronId.equals(that.pizarronId) : that.pizarronId != null) return false;
        if (softwareId != null ? !softwareId.equals(that.softwareId) : that.softwareId != null) return false;
        if (tipoAulaId != null ? !tipoAulaId.equals(that.tipoAulaId) : that.tipoAulaId != null) return false;
        if (fechaCreacion != null ? !fechaCreacion.equals(that.fechaCreacion) : that.fechaCreacion != null)
            return false;
        if (listadoTemasId != null ? !listadoTemasId.equals(that.listadoTemasId) : that.listadoTemasId != null)
            return false;
        if (configuracionGrupoId != null ? !configuracionGrupoId.equals(that.configuracionGrupoId) : that.configuracionGrupoId != null)
            return false;
        if (configuracionGrupoBorradorId != null ? !configuracionGrupoBorradorId.equals(that.configuracionGrupoBorradorId) : that.configuracionGrupoBorradorId != null)
            return false;
        if (configuracionGrupoTodosId != null ? !configuracionGrupoTodosId.equals(that.configuracionGrupoTodosId) : that.configuracionGrupoTodosId != null)
            return false;
        if (configuracionGrupoBorradorTodosId != null ? !configuracionGrupoBorradorTodosId.equals(that.configuracionGrupoBorradorTodosId) : that.configuracionGrupoBorradorTodosId != null)
            return false;
        if (espacioFisicoDisponible != null ? !espacioFisicoDisponible.equals(that.espacioFisicoDisponible) : that.espacioFisicoDisponible != null)
            return false;
        if (creadaPorId != null ? !creadaPorId.equals(that.creadaPorId) : that.creadaPorId != null) return false;
        if (tipoOrganizacionId != null ? !tipoOrganizacionId.equals(that.tipoOrganizacionId) : that.tipoOrganizacionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (aulaId ^ (aulaId >>> 32));
        result = 31 * result + (aulaCompuestaId != null ? aulaCompuestaId.hashCode() : 0);
        result = 31 * result + (calendarioId != null ? calendarioId.hashCode() : 0);
        result = 31 * result + (chatId != null ? chatId.hashCode() : 0);
        result = 31 * result + (colorFondoId != null ? colorFondoId.hashCode() : 0);
        result = 31 * result + (encabezadoPaginaId != null ? encabezadoPaginaId.hashCode() : 0);
        result = 31 * result + (estiloImpresionId != null ? estiloImpresionId.hashCode() : 0);
        result = 31 * result + (estiloVistaId != null ? estiloVistaId.hashCode() : 0);
        result = 31 * result + (faqId != null ? faqId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (materialId != null ? materialId.hashCode() : 0);
        result = 31 * result + (materialAdicionalId != null ? materialAdicionalId.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (novedadId != null ? novedadId.hashCode() : 0);
        result = 31 * result + (pizarronId != null ? pizarronId.hashCode() : 0);
        result = 31 * result + (softwareId != null ? softwareId.hashCode() : 0);
        result = 31 * result + (tipoAulaId != null ? tipoAulaId.hashCode() : 0);
        result = 31 * result + (fechaCreacion != null ? fechaCreacion.hashCode() : 0);
        result = 31 * result + (listadoTemasId != null ? listadoTemasId.hashCode() : 0);
        result = 31 * result + (configuracionGrupoId != null ? configuracionGrupoId.hashCode() : 0);
        result = 31 * result + (configuracionGrupoBorradorId != null ? configuracionGrupoBorradorId.hashCode() : 0);
        result = 31 * result + (configuracionGrupoTodosId != null ? configuracionGrupoTodosId.hashCode() : 0);
        result = 31 * result + (configuracionGrupoBorradorTodosId != null ? configuracionGrupoBorradorTodosId.hashCode() : 0);
        result = 31 * result + (espacioFisicoDisponible != null ? espacioFisicoDisponible.hashCode() : 0);
        result = 31 * result + (enviarMailsNotificacion ? 1 : 0);
        result = 31 * result + (creadaPorId != null ? creadaPorId.hashCode() : 0);
        result = 31 * result + (tipoOrganizacionId != null ? tipoOrganizacionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<ActividadEntity> getActividadsByAulaId() {
        return actividadsByAulaId;
    }

    public void setActividadsByAulaId(Collection<ActividadEntity> actividadsByAulaId) {
        this.actividadsByAulaId = actividadsByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<ArchivoCompartidoAulaEntity> getArchivoCompartidoAulasByAulaId() {
        return archivoCompartidoAulasByAulaId;
    }

    public void setArchivoCompartidoAulasByAulaId(Collection<ArchivoCompartidoAulaEntity> archivoCompartidoAulasByAulaId) {
        this.archivoCompartidoAulasByAulaId = archivoCompartidoAulasByAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "AULA_COMPUESTA_ID", referencedColumnName = "AULA_COMPUESTA_ID", insertable=false, updatable=false)
    public AulaCompuestaEntity getAulaCompuestaByAulaCompuestaId() {
        return aulaCompuestaByAulaCompuestaId;
    }

    public void setAulaCompuestaByAulaCompuestaId(AulaCompuestaEntity aulaCompuestaByAulaCompuestaId) {
        this.aulaCompuestaByAulaCompuestaId = aulaCompuestaByAulaCompuestaId;
    }

    @ManyToOne
    @JoinColumn(name = "CALENDARIO_ID", referencedColumnName = "CALENDARIO_ID", insertable=false, updatable=false)
    public CalendarioEntity getCalendarioByCalendarioId() {
        return calendarioByCalendarioId;
    }

    public void setCalendarioByCalendarioId(CalendarioEntity calendarioByCalendarioId) {
        this.calendarioByCalendarioId = calendarioByCalendarioId;
    }

    @ManyToOne
    @JoinColumn(name = "CHAT_ID", referencedColumnName = "CHAT_ID", insertable=false, updatable=false)
    public ChatEntity getChatByChatId() {
        return chatByChatId;
    }

    public void setChatByChatId(ChatEntity chatByChatId) {
        this.chatByChatId = chatByChatId;
    }

    @ManyToOne
    @JoinColumn(name = "COLOR_FONDO_ID", referencedColumnName = "COLOR_FONDO_ID", insertable=false, updatable=false)
    public ColorFondoEntity getColorFondoByColorFondoId() {
        return colorFondoByColorFondoId;
    }

    public void setColorFondoByColorFondoId(ColorFondoEntity colorFondoByColorFondoId) {
        this.colorFondoByColorFondoId = colorFondoByColorFondoId;
    }

    @ManyToOne
    @JoinColumn(name = "ENCABEZADO_PAGINA_ID", referencedColumnName = "ENCABEZADO_PAGINA_ID", insertable=false, updatable=false)
    public EncabezadoPaginaEntity getEncabezadoPaginaByEncabezadoPaginaId() {
        return encabezadoPaginaByEncabezadoPaginaId;
    }

    public void setEncabezadoPaginaByEncabezadoPaginaId(EncabezadoPaginaEntity encabezadoPaginaByEncabezadoPaginaId) {
        this.encabezadoPaginaByEncabezadoPaginaId = encabezadoPaginaByEncabezadoPaginaId;
    }

    @ManyToOne
    @JoinColumn(name = "ESTILO_IMPRESION_ID", referencedColumnName = "PAGINA_ESTILO_ID", insertable=false, updatable=false)
    public PaginaEstiloEntity getPaginaEstiloByEstiloImpresionId() {
        return paginaEstiloByEstiloImpresionId;
    }

    public void setPaginaEstiloByEstiloImpresionId(PaginaEstiloEntity paginaEstiloByEstiloImpresionId) {
        this.paginaEstiloByEstiloImpresionId = paginaEstiloByEstiloImpresionId;
    }

    @ManyToOne
    @JoinColumn(name = "ESTILO_VISTA_ID", referencedColumnName = "PAGINA_ESTILO_ID", insertable=false, updatable=false)
    public PaginaEstiloEntity getPaginaEstiloByEstiloVistaId() {
        return paginaEstiloByEstiloVistaId;
    }

    public void setPaginaEstiloByEstiloVistaId(PaginaEstiloEntity paginaEstiloByEstiloVistaId) {
        this.paginaEstiloByEstiloVistaId = paginaEstiloByEstiloVistaId;
    }

    @ManyToOne
    @JoinColumn(name = "FAQ_ID", referencedColumnName = "FAQ_ID", insertable=false, updatable=false)
    public FaqEntity getFaqByFaqId() {
        return faqByFaqId;
    }

    public void setFaqByFaqId(FaqEntity faqByFaqId) {
        this.faqByFaqId = faqByFaqId;
    }

    @ManyToOne
    @JoinColumn(name = "MATERIAL_ID", referencedColumnName = "MATERIAL_ID", insertable=false, updatable=false)
    public MaterialEntity getMaterialByMaterialId() {
        return materialByMaterialId;
    }

    public void setMaterialByMaterialId(MaterialEntity materialByMaterialId) {
        this.materialByMaterialId = materialByMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "MATERIAL_ADICIONAL_ID", referencedColumnName = "MATERIAL_ADICIONAL_ID", insertable=false, updatable=false)
    public MaterialAdicionalEntity getMaterialAdicionalByMaterialAdicionalId() {
        return materialAdicionalByMaterialAdicionalId;
    }

    public void setMaterialAdicionalByMaterialAdicionalId(MaterialAdicionalEntity materialAdicionalByMaterialAdicionalId) {
        this.materialAdicionalByMaterialAdicionalId = materialAdicionalByMaterialAdicionalId;
    }

    @ManyToOne
    @JoinColumn(name = "NOVEDAD_ID", referencedColumnName = "NOVEDAD_ID", insertable=false, updatable=false)
    public NovedadEntity getNovedadByNovedadId() {
        return novedadByNovedadId;
    }

    public void setNovedadByNovedadId(NovedadEntity novedadByNovedadId) {
        this.novedadByNovedadId = novedadByNovedadId;
    }

    @ManyToOne
    @JoinColumn(name = "PIZARRON_ID", referencedColumnName = "PIZARRON_ID", insertable=false, updatable=false)
    public PizarronEntity getPizarronByPizarronId() {
        return pizarronByPizarronId;
    }

    public void setPizarronByPizarronId(PizarronEntity pizarronByPizarronId) {
        this.pizarronByPizarronId = pizarronByPizarronId;
    }

    @ManyToOne
    @JoinColumn(name = "SOFTWARE_ID", referencedColumnName = "SOFTWARE_ID", insertable=false, updatable=false)
    public SoftwareEntity getSoftwareBySoftwareId() {
        return softwareBySoftwareId;
    }

    public void setSoftwareBySoftwareId(SoftwareEntity softwareBySoftwareId) {
        this.softwareBySoftwareId = softwareBySoftwareId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_AULA_ID", referencedColumnName = "TIPO_AULA_ID", insertable=false, updatable=false)
    public TipoAulaEntity getTipoAulaByTipoAulaId() {
        return tipoAulaByTipoAulaId;
    }

    public void setTipoAulaByTipoAulaId(TipoAulaEntity tipoAulaByTipoAulaId) {
        this.tipoAulaByTipoAulaId = tipoAulaByTipoAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "LISTADO_TEMAS_ID", referencedColumnName = "LISTADO_TEMAS_ID", insertable=false, updatable=false)
    public ListadoTemasEntity getListadoTemasByListadoTemasId() {
        return listadoTemasByListadoTemasId;
    }

    public void setListadoTemasByListadoTemasId(ListadoTemasEntity listadoTemasByListadoTemasId) {
        this.listadoTemasByListadoTemasId = listadoTemasByListadoTemasId;
    }

    @ManyToOne
    @JoinColumn(name = "CONFIGURACION_GRUPO_ID", referencedColumnName = "CONFIGURACION_GRUPO_ID", insertable=false, updatable=false)
    public ConfiguracionGrupoEntity getConfiguracionGrupoByConfiguracionGrupoId() {
        return configuracionGrupoByConfiguracionGrupoId;
    }

    public void setConfiguracionGrupoByConfiguracionGrupoId(ConfiguracionGrupoEntity configuracionGrupoByConfiguracionGrupoId) {
        this.configuracionGrupoByConfiguracionGrupoId = configuracionGrupoByConfiguracionGrupoId;
    }

    @ManyToOne
    @JoinColumn(name = "CONFIGURACION_GRUPO_BORRADOR_ID", referencedColumnName = "CONFIGURACION_GRUPO_ID", insertable=false, updatable=false)
    public ConfiguracionGrupoEntity getConfiguracionGrupoByConfiguracionGrupoBorradorId() {
        return configuracionGrupoByConfiguracionGrupoBorradorId;
    }

    public void setConfiguracionGrupoByConfiguracionGrupoBorradorId(ConfiguracionGrupoEntity configuracionGrupoByConfiguracionGrupoBorradorId) {
        this.configuracionGrupoByConfiguracionGrupoBorradorId = configuracionGrupoByConfiguracionGrupoBorradorId;
    }

    @ManyToOne
    @JoinColumn(name = "CONFIGURACION_GRUPO_TODOS_ID", referencedColumnName = "CONFIGURACION_GRUPO_ID", insertable=false, updatable=false)
    public ConfiguracionGrupoEntity getConfiguracionGrupoByConfiguracionGrupoTodosId() {
        return configuracionGrupoByConfiguracionGrupoTodosId;
    }

    public void setConfiguracionGrupoByConfiguracionGrupoTodosId(ConfiguracionGrupoEntity configuracionGrupoByConfiguracionGrupoTodosId) {
        this.configuracionGrupoByConfiguracionGrupoTodosId = configuracionGrupoByConfiguracionGrupoTodosId;
    }

    @ManyToOne
    @JoinColumn(name = "CONFIGURACION_GRUPO_BORRADOR_TODOS_ID", referencedColumnName = "CONFIGURACION_GRUPO_ID", insertable=false, updatable=false)
    public ConfiguracionGrupoEntity getConfiguracionGrupoByConfiguracionGrupoBorradorTodosId() {
        return configuracionGrupoByConfiguracionGrupoBorradorTodosId;
    }

    public void setConfiguracionGrupoByConfiguracionGrupoBorradorTodosId(ConfiguracionGrupoEntity configuracionGrupoByConfiguracionGrupoBorradorTodosId) {
        this.configuracionGrupoByConfiguracionGrupoBorradorTodosId = configuracionGrupoByConfiguracionGrupoBorradorTodosId;
    }

    @ManyToOne
    @JoinColumn(name = "CREADA_POR_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByCreadaPorId() {
        return personaByCreadaPorId;
    }

    public void setPersonaByCreadaPorId(PersonaEntity personaByCreadaPorId) {
        this.personaByCreadaPorId = personaByCreadaPorId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_ORGANIZACION_ID", referencedColumnName = "TIPO_ORGANIZACION_ID", insertable=false, updatable=false)
    public TipoOrganizacionEntity getTipoOrganizacionByTipoOrganizacionId() {
        return tipoOrganizacionByTipoOrganizacionId;
    }

    public void setTipoOrganizacionByTipoOrganizacionId(TipoOrganizacionEntity tipoOrganizacionByTipoOrganizacionId) {
        this.tipoOrganizacionByTipoOrganizacionId = tipoOrganizacionByTipoOrganizacionId;
    }

    @OneToOne(mappedBy = "aulaByAulaCompuestaId")
    public AulaCompuestaEntity getAulaCompuestaByAulaId() {
        return aulaCompuestaByAulaId;
    }

    public void setAulaCompuestaByAulaId(AulaCompuestaEntity aulaCompuestaByAulaId) {
        this.aulaCompuestaByAulaId = aulaCompuestaByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<AulaHerramientaEntity> getAulaHerramientasByAulaId() {
        return aulaHerramientasByAulaId;
    }

    public void setAulaHerramientasByAulaId(Collection<AulaHerramientaEntity> aulaHerramientasByAulaId) {
        this.aulaHerramientasByAulaId = aulaHerramientasByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<AulaTipoUsuarioEntity> getAulaTipoUsuariosByAulaId() {
        return aulaTipoUsuariosByAulaId;
    }

    public void setAulaTipoUsuariosByAulaId(Collection<AulaTipoUsuarioEntity> aulaTipoUsuariosByAulaId) {
        this.aulaTipoUsuariosByAulaId = aulaTipoUsuariosByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<BibliotecaEntity> getBibliotecasByAulaId() {
        return bibliotecasByAulaId;
    }

    public void setBibliotecasByAulaId(Collection<BibliotecaEntity> bibliotecasByAulaId) {
        this.bibliotecasByAulaId = bibliotecasByAulaId;
    }

    @OneToOne(mappedBy = "aulaByComisionId")
    public ComisionEntity getComisionByAulaId() {
        return comisionByAulaId;
    }

    public void setComisionByAulaId(ComisionEntity comisionByAulaId) {
        this.comisionByAulaId = comisionByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<ConfiguracionPorAulaEntity> getConfiguracionPorAulasByAulaId() {
        return configuracionPorAulasByAulaId;
    }

    public void setConfiguracionPorAulasByAulaId(Collection<ConfiguracionPorAulaEntity> configuracionPorAulasByAulaId) {
        this.configuracionPorAulasByAulaId = configuracionPorAulasByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<EncuestaAulaEntity> getEncuestaAulasByAulaId() {
        return encuestaAulasByAulaId;
    }

    public void setEncuestaAulasByAulaId(Collection<EncuestaAulaEntity> encuestaAulasByAulaId) {
        this.encuestaAulasByAulaId = encuestaAulasByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<EnlaceEntity> getEnlacesByAulaId() {
        return enlacesByAulaId;
    }

    public void setEnlacesByAulaId(Collection<EnlaceEntity> enlacesByAulaId) {
        this.enlacesByAulaId = enlacesByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<EvaluacionEntity> getEvaluacionsByAulaId() {
        return evaluacionsByAulaId;
    }

    public void setEvaluacionsByAulaId(Collection<EvaluacionEntity> evaluacionsByAulaId) {
        this.evaluacionsByAulaId = evaluacionsByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<ForoEntity> getForosByAulaId() {
        return forosByAulaId;
    }

    public void setForosByAulaId(Collection<ForoEntity> forosByAulaId) {
        this.forosByAulaId = forosByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<ItemAulaPermisoEntity> getItemAulaPermisosByAulaId() {
        return itemAulaPermisosByAulaId;
    }

    public void setItemAulaPermisosByAulaId(Collection<ItemAulaPermisoEntity> itemAulaPermisosByAulaId) {
        this.itemAulaPermisosByAulaId = itemAulaPermisosByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<ListaCorreoEntity> getListaCorreosByAulaId() {
        return listaCorreosByAulaId;
    }

    public void setListaCorreosByAulaId(Collection<ListaCorreoEntity> listaCorreosByAulaId) {
        this.listaCorreosByAulaId = listaCorreosByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<MailEntity> getMailByAulaId() {
        return mailByAulaId;
    }

    public void setMailByAulaId(Collection<MailEntity> mailByAulaId) {
        this.mailByAulaId = mailByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<MensajeIngresoEntity> getMensajeIngresosByAulaId() {
        return mensajeIngresosByAulaId;
    }

    public void setMensajeIngresosByAulaId(Collection<MensajeIngresoEntity> mensajeIngresosByAulaId) {
        this.mensajeIngresosByAulaId = mensajeIngresosByAulaId;
    }

    @OneToMany(mappedBy = "aulaByNivelAulaId")
    public Collection<MensajeIngresoEntity> getMensajeIngresosByAulaId_0() {
        return mensajeIngresosByAulaId_0;
    }

    public void setMensajeIngresosByAulaId_0(Collection<MensajeIngresoEntity> mensajeIngresosByAulaId_0) {
        this.mensajeIngresosByAulaId_0 = mensajeIngresosByAulaId_0;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<ParticipanteEntity> getParticipantesByAulaId() {
        return participantesByAulaId;
    }

    public void setParticipantesByAulaId(Collection<ParticipanteEntity> participantesByAulaId) {
        this.participantesByAulaId = participantesByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<PedidoInformeEntity> getPedidoInformesByAulaId() {
        return pedidoInformesByAulaId;
    }

    public void setPedidoInformesByAulaId(Collection<PedidoInformeEntity> pedidoInformesByAulaId) {
        this.pedidoInformesByAulaId = pedidoInformesByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<PermisoAccesoEntity> getPermisoAccesosByAulaId() {
        return permisoAccesosByAulaId;
    }

    public void setPermisoAccesosByAulaId(Collection<PermisoAccesoEntity> permisoAccesosByAulaId) {
        this.permisoAccesosByAulaId = permisoAccesosByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<PersonaMensajeIngresoEntity> getPersonaMensajeIngresosByAulaId() {
        return personaMensajeIngresosByAulaId;
    }

    public void setPersonaMensajeIngresosByAulaId(Collection<PersonaMensajeIngresoEntity> personaMensajeIngresosByAulaId) {
        this.personaMensajeIngresosByAulaId = personaMensajeIngresosByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaCreacionId")
    public Collection<PlantillaPermisoEntity> getPlantillaPermisosByAulaId() {
        return plantillaPermisosByAulaId;
    }

    public void setPlantillaPermisosByAulaId(Collection<PlantillaPermisoEntity> plantillaPermisosByAulaId) {
        this.plantillaPermisosByAulaId = plantillaPermisosByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<RedSocialRecursoEntity> getRedSocialRecursosByAulaId() {
        return redSocialRecursosByAulaId;
    }

    public void setRedSocialRecursosByAulaId(Collection<RedSocialRecursoEntity> redSocialRecursosByAulaId) {
        this.redSocialRecursosByAulaId = redSocialRecursosByAulaId;
    }

    @OneToMany(mappedBy = "aulaByInscribirEnId")
    public Collection<RegistroPersonaEntity> getRegistroPersonasByAulaId() {
        return registroPersonasByAulaId;
    }

    public void setRegistroPersonasByAulaId(Collection<RegistroPersonaEntity> registroPersonasByAulaId) {
        this.registroPersonasByAulaId = registroPersonasByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<RespuestaEntity> getRespuestasByAulaId() {
        return respuestasByAulaId;
    }

    public void setRespuestasByAulaId(Collection<RespuestaEntity> respuestasByAulaId) {
        this.respuestasByAulaId = respuestasByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<SeguimientoAccesoEntity> getSeguimientoAccesosByAulaId() {
        return seguimientoAccesosByAulaId;
    }

    public void setSeguimientoAccesosByAulaId(Collection<SeguimientoAccesoEntity> seguimientoAccesosByAulaId) {
        this.seguimientoAccesosByAulaId = seguimientoAccesosByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<SeguimientoAlmacenamientoMaterialEntity> getSeguimientoAlmacenamientoMaterialsByAulaId() {
        return seguimientoAlmacenamientoMaterialsByAulaId;
    }

    public void setSeguimientoAlmacenamientoMaterialsByAulaId(Collection<SeguimientoAlmacenamientoMaterialEntity> seguimientoAlmacenamientoMaterialsByAulaId) {
        this.seguimientoAlmacenamientoMaterialsByAulaId = seguimientoAlmacenamientoMaterialsByAulaId;
    }

    @OneToMany(mappedBy = "aulaByAulaId")
    public Collection<VideoconferenciaEntity> getVideoconferenciasByAulaId() {
        return videoconferenciasByAulaId;
    }

    public void setVideoconferenciasByAulaId(Collection<VideoconferenciaEntity> videoconferenciasByAulaId) {
        this.videoconferenciasByAulaId = videoconferenciasByAulaId;
    }
}
