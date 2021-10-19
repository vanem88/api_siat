package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "CONFIGURACION_PERSONAL", schema = "datosEveliaMinimo", catalog = "")
public class ConfiguracionPersonalEntity {
    private long configuracionPersonalId;
    private Timestamp fechaNacimiento;
    private Long id;
    private String editorFavorito;
    private Boolean activarMailPersonal;
    private Byte activarRecepcionMensajes;
    private Timestamp ultimoCambioClave;
    private Timestamp ultimaActualizacionCuentaMail;
    private int cantidadFilasEnTablas;
    private Double espacioFisicoDisponible;
    private String envioMailsResponderA;
    private Long configuracionNotificacionId;
    private ConfiguracionNotificacionEntity configuracionNotificacionByConfiguracionNotificacionId;
    private Collection<ConfiguracionPorAulaEntity> configuracionPorAulasByConfiguracionPersonalId;
    private Collection<PersonaEntity> personasByConfiguracionPersonalId;

    @Id
    @Column(name = "CONFIGURACION_PERSONAL_ID")
    public long getConfiguracionPersonalId() {
        return configuracionPersonalId;
    }

    public void setConfiguracionPersonalId(long configuracionPersonalId) {
        this.configuracionPersonalId = configuracionPersonalId;
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
    @Column(name = "EDITOR_FAVORITO")
    public String getEditorFavorito() {
        return editorFavorito;
    }

    public void setEditorFavorito(String editorFavorito) {
        this.editorFavorito = editorFavorito;
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
    @Column(name = "ULTIMO_CAMBIO_CLAVE")
    public Timestamp getUltimoCambioClave() {
        return ultimoCambioClave;
    }

    public void setUltimoCambioClave(Timestamp ultimoCambioClave) {
        this.ultimoCambioClave = ultimoCambioClave;
    }

    @Basic
    @Column(name = "ULTIMA_ACTUALIZACION_CUENTA_MAIL")
    public Timestamp getUltimaActualizacionCuentaMail() {
        return ultimaActualizacionCuentaMail;
    }

    public void setUltimaActualizacionCuentaMail(Timestamp ultimaActualizacionCuentaMail) {
        this.ultimaActualizacionCuentaMail = ultimaActualizacionCuentaMail;
    }

    @Basic
    @Column(name = "CANTIDAD_FILAS_EN_TABLAS")
    public int getCantidadFilasEnTablas() {
        return cantidadFilasEnTablas;
    }

    public void setCantidadFilasEnTablas(int cantidadFilasEnTablas) {
        this.cantidadFilasEnTablas = cantidadFilasEnTablas;
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
    @Column(name = "ENVIO_MAILS_RESPONDER_A")
    public String getEnvioMailsResponderA() {
        return envioMailsResponderA;
    }

    public void setEnvioMailsResponderA(String envioMailsResponderA) {
        this.envioMailsResponderA = envioMailsResponderA;
    }

    @Basic
    @Column(name = "CONFIGURACION_NOTIFICACION_ID")
    public Long getConfiguracionNotificacionId() {
        return configuracionNotificacionId;
    }

    public void setConfiguracionNotificacionId(Long configuracionNotificacionId) {
        this.configuracionNotificacionId = configuracionNotificacionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfiguracionPersonalEntity that = (ConfiguracionPersonalEntity) o;

        if (configuracionPersonalId != that.configuracionPersonalId) return false;
        if (cantidadFilasEnTablas != that.cantidadFilasEnTablas) return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(that.fechaNacimiento) : that.fechaNacimiento != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (editorFavorito != null ? !editorFavorito.equals(that.editorFavorito) : that.editorFavorito != null)
            return false;
        if (activarMailPersonal != null ? !activarMailPersonal.equals(that.activarMailPersonal) : that.activarMailPersonal != null)
            return false;
        if (activarRecepcionMensajes != null ? !activarRecepcionMensajes.equals(that.activarRecepcionMensajes) : that.activarRecepcionMensajes != null)
            return false;
        if (ultimoCambioClave != null ? !ultimoCambioClave.equals(that.ultimoCambioClave) : that.ultimoCambioClave != null)
            return false;
        if (ultimaActualizacionCuentaMail != null ? !ultimaActualizacionCuentaMail.equals(that.ultimaActualizacionCuentaMail) : that.ultimaActualizacionCuentaMail != null)
            return false;
        if (espacioFisicoDisponible != null ? !espacioFisicoDisponible.equals(that.espacioFisicoDisponible) : that.espacioFisicoDisponible != null)
            return false;
        if (envioMailsResponderA != null ? !envioMailsResponderA.equals(that.envioMailsResponderA) : that.envioMailsResponderA != null)
            return false;
        if (configuracionNotificacionId != null ? !configuracionNotificacionId.equals(that.configuracionNotificacionId) : that.configuracionNotificacionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (configuracionPersonalId ^ (configuracionPersonalId >>> 32));
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (editorFavorito != null ? editorFavorito.hashCode() : 0);
        result = 31 * result + (activarMailPersonal != null ? activarMailPersonal.hashCode() : 0);
        result = 31 * result + (activarRecepcionMensajes != null ? activarRecepcionMensajes.hashCode() : 0);
        result = 31 * result + (ultimoCambioClave != null ? ultimoCambioClave.hashCode() : 0);
        result = 31 * result + (ultimaActualizacionCuentaMail != null ? ultimaActualizacionCuentaMail.hashCode() : 0);
        result = 31 * result + cantidadFilasEnTablas;
        result = 31 * result + (espacioFisicoDisponible != null ? espacioFisicoDisponible.hashCode() : 0);
        result = 31 * result + (envioMailsResponderA != null ? envioMailsResponderA.hashCode() : 0);
        result = 31 * result + (configuracionNotificacionId != null ? configuracionNotificacionId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CONFIGURACION_NOTIFICACION_ID", referencedColumnName = "CONFIGURACION_NOTIFICACION_ID",insertable=false, updatable=false)
    public ConfiguracionNotificacionEntity getConfiguracionNotificacionByConfiguracionNotificacionId() {
        return configuracionNotificacionByConfiguracionNotificacionId;
    }

    public void setConfiguracionNotificacionByConfiguracionNotificacionId(ConfiguracionNotificacionEntity configuracionNotificacionByConfiguracionNotificacionId) {
        this.configuracionNotificacionByConfiguracionNotificacionId = configuracionNotificacionByConfiguracionNotificacionId;
    }

    @OneToMany(mappedBy = "configuracionPersonalByConfiguracionPersonalId")
    public Collection<ConfiguracionPorAulaEntity> getConfiguracionPorAulasByConfiguracionPersonalId() {
        return configuracionPorAulasByConfiguracionPersonalId;
    }

    public void setConfiguracionPorAulasByConfiguracionPersonalId(Collection<ConfiguracionPorAulaEntity> configuracionPorAulasByConfiguracionPersonalId) {
        this.configuracionPorAulasByConfiguracionPersonalId = configuracionPorAulasByConfiguracionPersonalId;
    }

    @OneToMany(mappedBy = "configuracionPersonalByConfiguracionPersonalId")
    public Collection<PersonaEntity> getPersonasByConfiguracionPersonalId() {
        return personasByConfiguracionPersonalId;
    }

    public void setPersonasByConfiguracionPersonalId(Collection<PersonaEntity> personasByConfiguracionPersonalId) {
        this.personasByConfiguracionPersonalId = personasByConfiguracionPersonalId;
    }
}
