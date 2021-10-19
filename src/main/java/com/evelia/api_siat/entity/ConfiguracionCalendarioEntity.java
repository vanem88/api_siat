package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "CONFIGURACION_CALENDARIO", schema = "datosEveliaMinimo", catalog = "")
public class ConfiguracionCalendarioEntity {
    private long configuracionCalendarioId;
    private Long id;
    private Long configuracionPorAulaId;
    private Long aulaId;
    private Boolean mostrar;
    private String color;
    private ConfiguracionPorAulaEntity configuracionPorAulaByConfiguracionPorAulaId;

    @Id
    @Column(name = "CONFIGURACION_CALENDARIO_ID")
    public long getConfiguracionCalendarioId() {
        return configuracionCalendarioId;
    }

    public void setConfiguracionCalendarioId(long configuracionCalendarioId) {
        this.configuracionCalendarioId = configuracionCalendarioId;
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
    @Column(name = "CONFIGURACION_POR_AULA_ID")
    public Long getConfiguracionPorAulaId() {
        return configuracionPorAulaId;
    }

    public void setConfiguracionPorAulaId(Long configuracionPorAulaId) {
        this.configuracionPorAulaId = configuracionPorAulaId;
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
    @Column(name = "MOSTRAR")
    public Boolean getMostrar() {
        return mostrar;
    }

    public void setMostrar(Boolean mostrar) {
        this.mostrar = mostrar;
    }

    @Basic
    @Column(name = "COLOR")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfiguracionCalendarioEntity that = (ConfiguracionCalendarioEntity) o;

        if (configuracionCalendarioId != that.configuracionCalendarioId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (configuracionPorAulaId != null ? !configuracionPorAulaId.equals(that.configuracionPorAulaId) : that.configuracionPorAulaId != null)
            return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (mostrar != null ? !mostrar.equals(that.mostrar) : that.mostrar != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (configuracionCalendarioId ^ (configuracionCalendarioId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (configuracionPorAulaId != null ? configuracionPorAulaId.hashCode() : 0);
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (mostrar != null ? mostrar.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CONFIGURACION_POR_AULA_ID", referencedColumnName = "CONFIGURACION_POR_AULA_ID", insertable=false, updatable=false)
    public ConfiguracionPorAulaEntity getConfiguracionPorAulaByConfiguracionPorAulaId() {
        return configuracionPorAulaByConfiguracionPorAulaId;
    }

    public void setConfiguracionPorAulaByConfiguracionPorAulaId(ConfiguracionPorAulaEntity configuracionPorAulaByConfiguracionPorAulaId) {
        this.configuracionPorAulaByConfiguracionPorAulaId = configuracionPorAulaByConfiguracionPorAulaId;
    }
}
