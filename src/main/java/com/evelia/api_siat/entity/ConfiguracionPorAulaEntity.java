package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CONFIGURACION_POR_AULA", schema = "datosEveliaMinimo", catalog = "")
public class ConfiguracionPorAulaEntity {
    private long configuracionPorAulaId;
    private Long id;
    private Long configuracionPersonalId;
    private Long aulaId;
    private Boolean mostrarCalendarioPersonal;
    private String colorCalendarioPersonal;
    private Long configuracionNotificacionId;
    private Collection<ConfiguracionCalendarioEntity> configuracionCalendariosByConfiguracionPorAulaId;
    private ConfiguracionPersonalEntity configuracionPersonalByConfiguracionPersonalId;
    private AulaEntity aulaByAulaId;
    private ConfiguracionNotificacionEntity configuracionNotificacionByConfiguracionNotificacionId;

    @Id
    @Column(name = "CONFIGURACION_POR_AULA_ID")
    public long getConfiguracionPorAulaId() {
        return configuracionPorAulaId;
    }

    public void setConfiguracionPorAulaId(long configuracionPorAulaId) {
        this.configuracionPorAulaId = configuracionPorAulaId;
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
    @Column(name = "CONFIGURACION_PERSONAL_ID")
    public Long getConfiguracionPersonalId() {
        return configuracionPersonalId;
    }

    public void setConfiguracionPersonalId(Long configuracionPersonalId) {
        this.configuracionPersonalId = configuracionPersonalId;
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
    @Column(name = "MOSTRAR_CALENDARIO_PERSONAL")
    public Boolean getMostrarCalendarioPersonal() {
        return mostrarCalendarioPersonal;
    }

    public void setMostrarCalendarioPersonal(Boolean mostrarCalendarioPersonal) {
        this.mostrarCalendarioPersonal = mostrarCalendarioPersonal;
    }

    @Basic
    @Column(name = "COLOR_CALENDARIO_PERSONAL")
    public String getColorCalendarioPersonal() {
        return colorCalendarioPersonal;
    }

    public void setColorCalendarioPersonal(String colorCalendarioPersonal) {
        this.colorCalendarioPersonal = colorCalendarioPersonal;
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

        ConfiguracionPorAulaEntity that = (ConfiguracionPorAulaEntity) o;

        if (configuracionPorAulaId != that.configuracionPorAulaId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (configuracionPersonalId != null ? !configuracionPersonalId.equals(that.configuracionPersonalId) : that.configuracionPersonalId != null)
            return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (mostrarCalendarioPersonal != null ? !mostrarCalendarioPersonal.equals(that.mostrarCalendarioPersonal) : that.mostrarCalendarioPersonal != null)
            return false;
        if (colorCalendarioPersonal != null ? !colorCalendarioPersonal.equals(that.colorCalendarioPersonal) : that.colorCalendarioPersonal != null)
            return false;
        if (configuracionNotificacionId != null ? !configuracionNotificacionId.equals(that.configuracionNotificacionId) : that.configuracionNotificacionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (configuracionPorAulaId ^ (configuracionPorAulaId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (configuracionPersonalId != null ? configuracionPersonalId.hashCode() : 0);
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (mostrarCalendarioPersonal != null ? mostrarCalendarioPersonal.hashCode() : 0);
        result = 31 * result + (colorCalendarioPersonal != null ? colorCalendarioPersonal.hashCode() : 0);
        result = 31 * result + (configuracionNotificacionId != null ? configuracionNotificacionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "configuracionPorAulaByConfiguracionPorAulaId")
    public Collection<ConfiguracionCalendarioEntity> getConfiguracionCalendariosByConfiguracionPorAulaId() {
        return configuracionCalendariosByConfiguracionPorAulaId;
    }

    public void setConfiguracionCalendariosByConfiguracionPorAulaId(Collection<ConfiguracionCalendarioEntity> configuracionCalendariosByConfiguracionPorAulaId) {
        this.configuracionCalendariosByConfiguracionPorAulaId = configuracionCalendariosByConfiguracionPorAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "CONFIGURACION_PERSONAL_ID", referencedColumnName = "CONFIGURACION_PERSONAL_ID", insertable=false, updatable=false)
    public ConfiguracionPersonalEntity getConfiguracionPersonalByConfiguracionPersonalId() {
        return configuracionPersonalByConfiguracionPersonalId;
    }

    public void setConfiguracionPersonalByConfiguracionPersonalId(ConfiguracionPersonalEntity configuracionPersonalByConfiguracionPersonalId) {
        this.configuracionPersonalByConfiguracionPersonalId = configuracionPersonalByConfiguracionPersonalId;
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
    @JoinColumn(name = "CONFIGURACION_NOTIFICACION_ID", referencedColumnName = "CONFIGURACION_NOTIFICACION_ID", insertable=false, updatable=false)
    public ConfiguracionNotificacionEntity getConfiguracionNotificacionByConfiguracionNotificacionId() {
        return configuracionNotificacionByConfiguracionNotificacionId;
    }

    public void setConfiguracionNotificacionByConfiguracionNotificacionId(ConfiguracionNotificacionEntity configuracionNotificacionByConfiguracionNotificacionId) {
        this.configuracionNotificacionByConfiguracionNotificacionId = configuracionNotificacionByConfiguracionNotificacionId;
    }
}
