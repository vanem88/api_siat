package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "CONFIGURACION_GRUPO", schema = "datosEveliaMinimo", catalog = "")
public class ConfiguracionGrupoEntity {
    private long configuracionGrupoId;
    private Integer atributoGralCupo;
    private String atributoGralCurioso;
    private Byte atributoGralMultigrupo;
    private String atributoGralProhibido;
    private String atributoGralRechazado;
    private String atributoGralTipo;
    private Byte configuracionGralAtributoCupo;
    private Byte configuracionGralAtributoCurioso;
    private Byte configuracionGralAtributoMultigrupo;
    private Byte configuracionGralAtributoProhibido;
    private Byte configuracionGralAtributoRechazado;
    private Byte configuracionGralAtributoTipo;
    private Byte configuracionGralHerramientas;
    private Long id;
    private byte[] observacion;
    private Collection<AulaEntity> aulasByConfiguracionGrupoId;
    private Collection<AulaEntity> aulasByConfiguracionGrupoId_0;
    private Collection<AulaEntity> aulasByConfiguracionGrupoId_1;
    private Collection<AulaEntity> aulasByConfiguracionGrupoId_2;

    @Id
    @Column(name = "CONFIGURACION_GRUPO_ID")
    public long getConfiguracionGrupoId() {
        return configuracionGrupoId;
    }

    public void setConfiguracionGrupoId(long configuracionGrupoId) {
        this.configuracionGrupoId = configuracionGrupoId;
    }

    @Basic
    @Column(name = "ATRIBUTO_GRAL_CUPO")
    public Integer getAtributoGralCupo() {
        return atributoGralCupo;
    }

    public void setAtributoGralCupo(Integer atributoGralCupo) {
        this.atributoGralCupo = atributoGralCupo;
    }

    @Basic
    @Column(name = "ATRIBUTO_GRAL_CURIOSO")
    public String getAtributoGralCurioso() {
        return atributoGralCurioso;
    }

    public void setAtributoGralCurioso(String atributoGralCurioso) {
        this.atributoGralCurioso = atributoGralCurioso;
    }

    @Basic
    @Column(name = "ATRIBUTO_GRAL_MULTIGRUPO")
    public Byte getAtributoGralMultigrupo() {
        return atributoGralMultigrupo;
    }

    public void setAtributoGralMultigrupo(Byte atributoGralMultigrupo) {
        this.atributoGralMultigrupo = atributoGralMultigrupo;
    }

    @Basic
    @Column(name = "ATRIBUTO_GRAL_PROHIBIDO")
    public String getAtributoGralProhibido() {
        return atributoGralProhibido;
    }

    public void setAtributoGralProhibido(String atributoGralProhibido) {
        this.atributoGralProhibido = atributoGralProhibido;
    }

    @Basic
    @Column(name = "ATRIBUTO_GRAL_RECHAZADO")
    public String getAtributoGralRechazado() {
        return atributoGralRechazado;
    }

    public void setAtributoGralRechazado(String atributoGralRechazado) {
        this.atributoGralRechazado = atributoGralRechazado;
    }

    @Basic
    @Column(name = "ATRIBUTO_GRAL_TIPO")
    public String getAtributoGralTipo() {
        return atributoGralTipo;
    }

    public void setAtributoGralTipo(String atributoGralTipo) {
        this.atributoGralTipo = atributoGralTipo;
    }

    @Basic
    @Column(name = "CONFIGURACION_GRAL_ATRIBUTO_CUPO")
    public Byte getConfiguracionGralAtributoCupo() {
        return configuracionGralAtributoCupo;
    }

    public void setConfiguracionGralAtributoCupo(Byte configuracionGralAtributoCupo) {
        this.configuracionGralAtributoCupo = configuracionGralAtributoCupo;
    }

    @Basic
    @Column(name = "CONFIGURACION_GRAL_ATRIBUTO_CURIOSO")
    public Byte getConfiguracionGralAtributoCurioso() {
        return configuracionGralAtributoCurioso;
    }

    public void setConfiguracionGralAtributoCurioso(Byte configuracionGralAtributoCurioso) {
        this.configuracionGralAtributoCurioso = configuracionGralAtributoCurioso;
    }

    @Basic
    @Column(name = "CONFIGURACION_GRAL_ATRIBUTO_MULTIGRUPO")
    public Byte getConfiguracionGralAtributoMultigrupo() {
        return configuracionGralAtributoMultigrupo;
    }

    public void setConfiguracionGralAtributoMultigrupo(Byte configuracionGralAtributoMultigrupo) {
        this.configuracionGralAtributoMultigrupo = configuracionGralAtributoMultigrupo;
    }

    @Basic
    @Column(name = "CONFIGURACION_GRAL_ATRIBUTO_PROHIBIDO")
    public Byte getConfiguracionGralAtributoProhibido() {
        return configuracionGralAtributoProhibido;
    }

    public void setConfiguracionGralAtributoProhibido(Byte configuracionGralAtributoProhibido) {
        this.configuracionGralAtributoProhibido = configuracionGralAtributoProhibido;
    }

    @Basic
    @Column(name = "CONFIGURACION_GRAL_ATRIBUTO_RECHAZADO")
    public Byte getConfiguracionGralAtributoRechazado() {
        return configuracionGralAtributoRechazado;
    }

    public void setConfiguracionGralAtributoRechazado(Byte configuracionGralAtributoRechazado) {
        this.configuracionGralAtributoRechazado = configuracionGralAtributoRechazado;
    }

    @Basic
    @Column(name = "CONFIGURACION_GRAL_ATRIBUTO_TIPO")
    public Byte getConfiguracionGralAtributoTipo() {
        return configuracionGralAtributoTipo;
    }

    public void setConfiguracionGralAtributoTipo(Byte configuracionGralAtributoTipo) {
        this.configuracionGralAtributoTipo = configuracionGralAtributoTipo;
    }

    @Basic
    @Column(name = "CONFIGURACION_GRAL_HERRAMIENTAS")
    public Byte getConfiguracionGralHerramientas() {
        return configuracionGralHerramientas;
    }

    public void setConfiguracionGralHerramientas(Byte configuracionGralHerramientas) {
        this.configuracionGralHerramientas = configuracionGralHerramientas;
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
    @Column(name = "OBSERVACION")
    public byte[] getObservacion() {
        return observacion;
    }

    public void setObservacion(byte[] observacion) {
        this.observacion = observacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfiguracionGrupoEntity that = (ConfiguracionGrupoEntity) o;

        if (configuracionGrupoId != that.configuracionGrupoId) return false;
        if (atributoGralCupo != null ? !atributoGralCupo.equals(that.atributoGralCupo) : that.atributoGralCupo != null)
            return false;
        if (atributoGralCurioso != null ? !atributoGralCurioso.equals(that.atributoGralCurioso) : that.atributoGralCurioso != null)
            return false;
        if (atributoGralMultigrupo != null ? !atributoGralMultigrupo.equals(that.atributoGralMultigrupo) : that.atributoGralMultigrupo != null)
            return false;
        if (atributoGralProhibido != null ? !atributoGralProhibido.equals(that.atributoGralProhibido) : that.atributoGralProhibido != null)
            return false;
        if (atributoGralRechazado != null ? !atributoGralRechazado.equals(that.atributoGralRechazado) : that.atributoGralRechazado != null)
            return false;
        if (atributoGralTipo != null ? !atributoGralTipo.equals(that.atributoGralTipo) : that.atributoGralTipo != null)
            return false;
        if (configuracionGralAtributoCupo != null ? !configuracionGralAtributoCupo.equals(that.configuracionGralAtributoCupo) : that.configuracionGralAtributoCupo != null)
            return false;
        if (configuracionGralAtributoCurioso != null ? !configuracionGralAtributoCurioso.equals(that.configuracionGralAtributoCurioso) : that.configuracionGralAtributoCurioso != null)
            return false;
        if (configuracionGralAtributoMultigrupo != null ? !configuracionGralAtributoMultigrupo.equals(that.configuracionGralAtributoMultigrupo) : that.configuracionGralAtributoMultigrupo != null)
            return false;
        if (configuracionGralAtributoProhibido != null ? !configuracionGralAtributoProhibido.equals(that.configuracionGralAtributoProhibido) : that.configuracionGralAtributoProhibido != null)
            return false;
        if (configuracionGralAtributoRechazado != null ? !configuracionGralAtributoRechazado.equals(that.configuracionGralAtributoRechazado) : that.configuracionGralAtributoRechazado != null)
            return false;
        if (configuracionGralAtributoTipo != null ? !configuracionGralAtributoTipo.equals(that.configuracionGralAtributoTipo) : that.configuracionGralAtributoTipo != null)
            return false;
        if (configuracionGralHerramientas != null ? !configuracionGralHerramientas.equals(that.configuracionGralHerramientas) : that.configuracionGralHerramientas != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!Arrays.equals(observacion, that.observacion)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (configuracionGrupoId ^ (configuracionGrupoId >>> 32));
        result = 31 * result + (atributoGralCupo != null ? atributoGralCupo.hashCode() : 0);
        result = 31 * result + (atributoGralCurioso != null ? atributoGralCurioso.hashCode() : 0);
        result = 31 * result + (atributoGralMultigrupo != null ? atributoGralMultigrupo.hashCode() : 0);
        result = 31 * result + (atributoGralProhibido != null ? atributoGralProhibido.hashCode() : 0);
        result = 31 * result + (atributoGralRechazado != null ? atributoGralRechazado.hashCode() : 0);
        result = 31 * result + (atributoGralTipo != null ? atributoGralTipo.hashCode() : 0);
        result = 31 * result + (configuracionGralAtributoCupo != null ? configuracionGralAtributoCupo.hashCode() : 0);
        result = 31 * result + (configuracionGralAtributoCurioso != null ? configuracionGralAtributoCurioso.hashCode() : 0);
        result = 31 * result + (configuracionGralAtributoMultigrupo != null ? configuracionGralAtributoMultigrupo.hashCode() : 0);
        result = 31 * result + (configuracionGralAtributoProhibido != null ? configuracionGralAtributoProhibido.hashCode() : 0);
        result = 31 * result + (configuracionGralAtributoRechazado != null ? configuracionGralAtributoRechazado.hashCode() : 0);
        result = 31 * result + (configuracionGralAtributoTipo != null ? configuracionGralAtributoTipo.hashCode() : 0);
        result = 31 * result + (configuracionGralHerramientas != null ? configuracionGralHerramientas.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(observacion);
        return result;
    }

    @OneToMany(mappedBy = "configuracionGrupoByConfiguracionGrupoId")
    public Collection<AulaEntity> getAulasByConfiguracionGrupoId() {
        return aulasByConfiguracionGrupoId;
    }

    public void setAulasByConfiguracionGrupoId(Collection<AulaEntity> aulasByConfiguracionGrupoId) {
        this.aulasByConfiguracionGrupoId = aulasByConfiguracionGrupoId;
    }

    @OneToMany(mappedBy = "configuracionGrupoByConfiguracionGrupoBorradorId")
    public Collection<AulaEntity> getAulasByConfiguracionGrupoId_0() {
        return aulasByConfiguracionGrupoId_0;
    }

    public void setAulasByConfiguracionGrupoId_0(Collection<AulaEntity> aulasByConfiguracionGrupoId_0) {
        this.aulasByConfiguracionGrupoId_0 = aulasByConfiguracionGrupoId_0;
    }

    @OneToMany(mappedBy = "configuracionGrupoByConfiguracionGrupoTodosId")
    public Collection<AulaEntity> getAulasByConfiguracionGrupoId_1() {
        return aulasByConfiguracionGrupoId_1;
    }

    public void setAulasByConfiguracionGrupoId_1(Collection<AulaEntity> aulasByConfiguracionGrupoId_1) {
        this.aulasByConfiguracionGrupoId_1 = aulasByConfiguracionGrupoId_1;
    }

    @OneToMany(mappedBy = "configuracionGrupoByConfiguracionGrupoBorradorTodosId")
    public Collection<AulaEntity> getAulasByConfiguracionGrupoId_2() {
        return aulasByConfiguracionGrupoId_2;
    }

    public void setAulasByConfiguracionGrupoId_2(Collection<AulaEntity> aulasByConfiguracionGrupoId_2) {
        this.aulasByConfiguracionGrupoId_2 = aulasByConfiguracionGrupoId_2;
    }
}
