package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "GRUPO", schema = "datosEveliaMinimo", catalog = "")
public class GrupoEntity {
    private long grupoId;
    private Long anotadorId;
    private String autoinscripcion;
    private byte[] configurados;
    private String curioso;
    private String decide;
    private byte[] descripcion;
    private Long estadoGrupoId;
    private Timestamp fechaFin;
    private Timestamp fechaInicio;
    private Long idEnConfiguracion;
    private Long integracionId;
    private Byte interCom;
    private String invita;
    private Integer maxCantIntegr;
    private Byte multiGrupos;
    private String prohibido;
    private String rechazado;
    private Long tipoGrupoId;
    private Collection<ActividadGrupalEntity> actividadGrupalsByGrupoId;
    private Collection<ForoGrupalEntity> foroGrupalsByGrupoId;
    private ComisionEntity comisionByGrupoId;
    private AnotadorEntity anotadorByAnotadorId;
    private EstadoAulaEntity estadoAulaByEstadoGrupoId;
    private IntegracionEntity integracionByIntegracionId;
    private TipoGrupoEntity tipoGrupoByTipoGrupoId;
    private Collection<ParticipanteExcluidoEntity> participanteExcluidosByGrupoId;
    private Collection<TemaTratadoGrupoEntity> temaTratadoGruposByGrupoId;

    @Id
    @Column(name = "GRUPO_ID")
    public long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(long grupoId) {
        this.grupoId = grupoId;
    }

    @Basic
    @Column(name = "ANOTADOR_ID")
    public Long getAnotadorId() {
        return anotadorId;
    }

    public void setAnotadorId(Long anotadorId) {
        this.anotadorId = anotadorId;
    }

    @Basic
    @Column(name = "AUTOINSCRIPCION")
    public String getAutoinscripcion() {
        return autoinscripcion;
    }

    public void setAutoinscripcion(String autoinscripcion) {
        this.autoinscripcion = autoinscripcion;
    }

    @Basic
    @Column(name = "CONFIGURADOS")
    public byte[] getConfigurados() {
        return configurados;
    }

    public void setConfigurados(byte[] configurados) {
        this.configurados = configurados;
    }

    @Basic
    @Column(name = "CURIOSO")
    public String getCurioso() {
        return curioso;
    }

    public void setCurioso(String curioso) {
        this.curioso = curioso;
    }

    @Basic
    @Column(name = "DECIDE")
    public String getDecide() {
        return decide;
    }

    public void setDecide(String decide) {
        this.decide = decide;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public byte[] getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(byte[] descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ESTADO_GRUPO_ID")
    public Long getEstadoGrupoId() {
        return estadoGrupoId;
    }

    public void setEstadoGrupoId(Long estadoGrupoId) {
        this.estadoGrupoId = estadoGrupoId;
    }

    @Basic
    @Column(name = "FECHA_FIN")
    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Basic
    @Column(name = "FECHA_INICIO")
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "ID_EN_CONFIGURACION")
    public Long getIdEnConfiguracion() {
        return idEnConfiguracion;
    }

    public void setIdEnConfiguracion(Long idEnConfiguracion) {
        this.idEnConfiguracion = idEnConfiguracion;
    }

    @Basic
    @Column(name = "INTEGRACION_ID")
    public Long getIntegracionId() {
        return integracionId;
    }

    public void setIntegracionId(Long integracionId) {
        this.integracionId = integracionId;
    }

    @Basic
    @Column(name = "INTER_COM")
    public Byte getInterCom() {
        return interCom;
    }

    public void setInterCom(Byte interCom) {
        this.interCom = interCom;
    }

    @Basic
    @Column(name = "INVITA")
    public String getInvita() {
        return invita;
    }

    public void setInvita(String invita) {
        this.invita = invita;
    }

    @Basic
    @Column(name = "MAX_CANT_INTEGR")
    public Integer getMaxCantIntegr() {
        return maxCantIntegr;
    }

    public void setMaxCantIntegr(Integer maxCantIntegr) {
        this.maxCantIntegr = maxCantIntegr;
    }

    @Basic
    @Column(name = "MULTI_GRUPOS")
    public Byte getMultiGrupos() {
        return multiGrupos;
    }

    public void setMultiGrupos(Byte multiGrupos) {
        this.multiGrupos = multiGrupos;
    }

    @Basic
    @Column(name = "PROHIBIDO")
    public String getProhibido() {
        return prohibido;
    }

    public void setProhibido(String prohibido) {
        this.prohibido = prohibido;
    }

    @Basic
    @Column(name = "RECHAZADO")
    public String getRechazado() {
        return rechazado;
    }

    public void setRechazado(String rechazado) {
        this.rechazado = rechazado;
    }

    @Basic
    @Column(name = "TIPO_GRUPO_ID")
    public Long getTipoGrupoId() {
        return tipoGrupoId;
    }

    public void setTipoGrupoId(Long tipoGrupoId) {
        this.tipoGrupoId = tipoGrupoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrupoEntity that = (GrupoEntity) o;

        if (grupoId != that.grupoId) return false;
        if (anotadorId != null ? !anotadorId.equals(that.anotadorId) : that.anotadorId != null) return false;
        if (autoinscripcion != null ? !autoinscripcion.equals(that.autoinscripcion) : that.autoinscripcion != null)
            return false;
        if (!Arrays.equals(configurados, that.configurados)) return false;
        if (curioso != null ? !curioso.equals(that.curioso) : that.curioso != null) return false;
        if (decide != null ? !decide.equals(that.decide) : that.decide != null) return false;
        if (!Arrays.equals(descripcion, that.descripcion)) return false;
        if (estadoGrupoId != null ? !estadoGrupoId.equals(that.estadoGrupoId) : that.estadoGrupoId != null)
            return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (idEnConfiguracion != null ? !idEnConfiguracion.equals(that.idEnConfiguracion) : that.idEnConfiguracion != null)
            return false;
        if (integracionId != null ? !integracionId.equals(that.integracionId) : that.integracionId != null)
            return false;
        if (interCom != null ? !interCom.equals(that.interCom) : that.interCom != null) return false;
        if (invita != null ? !invita.equals(that.invita) : that.invita != null) return false;
        if (maxCantIntegr != null ? !maxCantIntegr.equals(that.maxCantIntegr) : that.maxCantIntegr != null)
            return false;
        if (multiGrupos != null ? !multiGrupos.equals(that.multiGrupos) : that.multiGrupos != null) return false;
        if (prohibido != null ? !prohibido.equals(that.prohibido) : that.prohibido != null) return false;
        if (rechazado != null ? !rechazado.equals(that.rechazado) : that.rechazado != null) return false;
        if (tipoGrupoId != null ? !tipoGrupoId.equals(that.tipoGrupoId) : that.tipoGrupoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (grupoId ^ (grupoId >>> 32));
        result = 31 * result + (anotadorId != null ? anotadorId.hashCode() : 0);
        result = 31 * result + (autoinscripcion != null ? autoinscripcion.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(configurados);
        result = 31 * result + (curioso != null ? curioso.hashCode() : 0);
        result = 31 * result + (decide != null ? decide.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(descripcion);
        result = 31 * result + (estadoGrupoId != null ? estadoGrupoId.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (idEnConfiguracion != null ? idEnConfiguracion.hashCode() : 0);
        result = 31 * result + (integracionId != null ? integracionId.hashCode() : 0);
        result = 31 * result + (interCom != null ? interCom.hashCode() : 0);
        result = 31 * result + (invita != null ? invita.hashCode() : 0);
        result = 31 * result + (maxCantIntegr != null ? maxCantIntegr.hashCode() : 0);
        result = 31 * result + (multiGrupos != null ? multiGrupos.hashCode() : 0);
        result = 31 * result + (prohibido != null ? prohibido.hashCode() : 0);
        result = 31 * result + (rechazado != null ? rechazado.hashCode() : 0);
        result = 31 * result + (tipoGrupoId != null ? tipoGrupoId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "grupoByGrupoId")
    public Collection<ActividadGrupalEntity> getActividadGrupalsByGrupoId() {
        return actividadGrupalsByGrupoId;
    }

    public void setActividadGrupalsByGrupoId(Collection<ActividadGrupalEntity> actividadGrupalsByGrupoId) {
        this.actividadGrupalsByGrupoId = actividadGrupalsByGrupoId;
    }

    @OneToMany(mappedBy = "grupoByGrupoId")
    public Collection<ForoGrupalEntity> getForoGrupalsByGrupoId() {
        return foroGrupalsByGrupoId;
    }

    public void setForoGrupalsByGrupoId(Collection<ForoGrupalEntity> foroGrupalsByGrupoId) {
        this.foroGrupalsByGrupoId = foroGrupalsByGrupoId;
    }

    @OneToOne
    @JoinColumn(name = "GRUPO_ID", referencedColumnName = "COMISION_ID", nullable = false, insertable=false, updatable=false)
    public ComisionEntity getComisionByGrupoId() {
        return comisionByGrupoId;
    }

    public void setComisionByGrupoId(ComisionEntity comisionByGrupoId) {
        this.comisionByGrupoId = comisionByGrupoId;
    }

    @ManyToOne
    @JoinColumn(name = "ANOTADOR_ID", referencedColumnName = "ANOTADOR_ID", insertable=false, updatable=false)
    public AnotadorEntity getAnotadorByAnotadorId() {
        return anotadorByAnotadorId;
    }

    public void setAnotadorByAnotadorId(AnotadorEntity anotadorByAnotadorId) {
        this.anotadorByAnotadorId = anotadorByAnotadorId;
    }

    @ManyToOne
    @JoinColumn(name = "ESTADO_GRUPO_ID", referencedColumnName = "ESTADO_AULA_ID", insertable=false, updatable=false)
    public EstadoAulaEntity getEstadoAulaByEstadoGrupoId() {
        return estadoAulaByEstadoGrupoId;
    }

    public void setEstadoAulaByEstadoGrupoId(EstadoAulaEntity estadoAulaByEstadoGrupoId) {
        this.estadoAulaByEstadoGrupoId = estadoAulaByEstadoGrupoId;
    }

    @ManyToOne
    @JoinColumn(name = "INTEGRACION_ID", referencedColumnName = "INTEGRACION_ID", insertable=false, updatable=false)
    public IntegracionEntity getIntegracionByIntegracionId() {
        return integracionByIntegracionId;
    }

    public void setIntegracionByIntegracionId(IntegracionEntity integracionByIntegracionId) {
        this.integracionByIntegracionId = integracionByIntegracionId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_GRUPO_ID", referencedColumnName = "TIPO_GRUPO_ID", insertable=false, updatable=false)
    public TipoGrupoEntity getTipoGrupoByTipoGrupoId() {
        return tipoGrupoByTipoGrupoId;
    }

    public void setTipoGrupoByTipoGrupoId(TipoGrupoEntity tipoGrupoByTipoGrupoId) {
        this.tipoGrupoByTipoGrupoId = tipoGrupoByTipoGrupoId;
    }

    @OneToMany(mappedBy = "grupoByGrupoId")
    public Collection<ParticipanteExcluidoEntity> getParticipanteExcluidosByGrupoId() {
        return participanteExcluidosByGrupoId;
    }

    public void setParticipanteExcluidosByGrupoId(Collection<ParticipanteExcluidoEntity> participanteExcluidosByGrupoId) {
        this.participanteExcluidosByGrupoId = participanteExcluidosByGrupoId;
    }

    @OneToMany(mappedBy = "grupoByGrupoId")
    public Collection<TemaTratadoGrupoEntity> getTemaTratadoGruposByGrupoId() {
        return temaTratadoGruposByGrupoId;
    }

    public void setTemaTratadoGruposByGrupoId(Collection<TemaTratadoGrupoEntity> temaTratadoGruposByGrupoId) {
        this.temaTratadoGruposByGrupoId = temaTratadoGruposByGrupoId;
    }
}
