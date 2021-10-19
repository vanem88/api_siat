package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TIPO_RECURSO", schema = "datosEveliaMinimo", catalog = "")
public class TipoRecursoEntity {
    private long tipoRecursoId;
    private Long id;
    private String nombre;
    private Boolean orden;
    private String descripcion;
    private Boolean solicitudAulaNuevaClonada;
    private Boolean solicitudAulaEstandar;
    private String solicitudAulaPublica;
    private Boolean recursosGrupo;
    private Boolean recursosAula;
    private Boolean recursosOrganizacion;
    private Boolean recursosCampus;
    private Boolean permisosGrupo;
    private Boolean permisosAula;
    private Boolean permisosOrganizacion;
    private Boolean permisosCampus;
    private Boolean soloComision;
    private Collection<AulaHerramientaEntity> aulaHerramientasByTipoRecursoId;
    private Collection<RecursoEntity> recursosByTipoRecursoId;
    private Collection<RecursoSolicitadoEntity> recursoSolicitadosByTipoRecursoId;

    @Id
    @Column(name = "TIPO_RECURSO_ID")
    public long getTipoRecursoId() {
        return tipoRecursoId;
    }

    public void setTipoRecursoId(long tipoRecursoId) {
        this.tipoRecursoId = tipoRecursoId;
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
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "ORDEN")
    public Boolean getOrden() {
        return orden;
    }

    public void setOrden(Boolean orden) {
        this.orden = orden;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "SOLICITUD_AULA_NUEVA_CLONADA")
    public Boolean getSolicitudAulaNuevaClonada() {
        return solicitudAulaNuevaClonada;
    }

    public void setSolicitudAulaNuevaClonada(Boolean solicitudAulaNuevaClonada) {
        this.solicitudAulaNuevaClonada = solicitudAulaNuevaClonada;
    }

    @Basic
    @Column(name = "SOLICITUD_AULA_ESTANDAR")
    public Boolean getSolicitudAulaEstandar() {
        return solicitudAulaEstandar;
    }

    public void setSolicitudAulaEstandar(Boolean solicitudAulaEstandar) {
        this.solicitudAulaEstandar = solicitudAulaEstandar;
    }

    @Basic
    @Column(name = "SOLICITUD_AULA_PUBLICA")
    public String getSolicitudAulaPublica() {
        return solicitudAulaPublica;
    }

    public void setSolicitudAulaPublica(String solicitudAulaPublica) {
        this.solicitudAulaPublica = solicitudAulaPublica;
    }

    @Basic
    @Column(name = "RECURSOS_GRUPO")
    public Boolean getRecursosGrupo() {
        return recursosGrupo;
    }

    public void setRecursosGrupo(Boolean recursosGrupo) {
        this.recursosGrupo = recursosGrupo;
    }

    @Basic
    @Column(name = "RECURSOS_AULA")
    public Boolean getRecursosAula() {
        return recursosAula;
    }

    public void setRecursosAula(Boolean recursosAula) {
        this.recursosAula = recursosAula;
    }

    @Basic
    @Column(name = "RECURSOS_ORGANIZACION")
    public Boolean getRecursosOrganizacion() {
        return recursosOrganizacion;
    }

    public void setRecursosOrganizacion(Boolean recursosOrganizacion) {
        this.recursosOrganizacion = recursosOrganizacion;
    }

    @Basic
    @Column(name = "RECURSOS_CAMPUS")
    public Boolean getRecursosCampus() {
        return recursosCampus;
    }

    public void setRecursosCampus(Boolean recursosCampus) {
        this.recursosCampus = recursosCampus;
    }

    @Basic
    @Column(name = "PERMISOS_GRUPO")
    public Boolean getPermisosGrupo() {
        return permisosGrupo;
    }

    public void setPermisosGrupo(Boolean permisosGrupo) {
        this.permisosGrupo = permisosGrupo;
    }

    @Basic
    @Column(name = "PERMISOS_AULA")
    public Boolean getPermisosAula() {
        return permisosAula;
    }

    public void setPermisosAula(Boolean permisosAula) {
        this.permisosAula = permisosAula;
    }

    @Basic
    @Column(name = "PERMISOS_ORGANIZACION")
    public Boolean getPermisosOrganizacion() {
        return permisosOrganizacion;
    }

    public void setPermisosOrganizacion(Boolean permisosOrganizacion) {
        this.permisosOrganizacion = permisosOrganizacion;
    }

    @Basic
    @Column(name = "PERMISOS_CAMPUS")
    public Boolean getPermisosCampus() {
        return permisosCampus;
    }

    public void setPermisosCampus(Boolean permisosCampus) {
        this.permisosCampus = permisosCampus;
    }

    @Basic
    @Column(name = "SOLO_COMISION")
    public Boolean getSoloComision() {
        return soloComision;
    }

    public void setSoloComision(Boolean soloComision) {
        this.soloComision = soloComision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoRecursoEntity that = (TipoRecursoEntity) o;

        if (tipoRecursoId != that.tipoRecursoId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (orden != null ? !orden.equals(that.orden) : that.orden != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (solicitudAulaNuevaClonada != null ? !solicitudAulaNuevaClonada.equals(that.solicitudAulaNuevaClonada) : that.solicitudAulaNuevaClonada != null)
            return false;
        if (solicitudAulaEstandar != null ? !solicitudAulaEstandar.equals(that.solicitudAulaEstandar) : that.solicitudAulaEstandar != null)
            return false;
        if (solicitudAulaPublica != null ? !solicitudAulaPublica.equals(that.solicitudAulaPublica) : that.solicitudAulaPublica != null)
            return false;
        if (recursosGrupo != null ? !recursosGrupo.equals(that.recursosGrupo) : that.recursosGrupo != null)
            return false;
        if (recursosAula != null ? !recursosAula.equals(that.recursosAula) : that.recursosAula != null) return false;
        if (recursosOrganizacion != null ? !recursosOrganizacion.equals(that.recursosOrganizacion) : that.recursosOrganizacion != null)
            return false;
        if (recursosCampus != null ? !recursosCampus.equals(that.recursosCampus) : that.recursosCampus != null)
            return false;
        if (permisosGrupo != null ? !permisosGrupo.equals(that.permisosGrupo) : that.permisosGrupo != null)
            return false;
        if (permisosAula != null ? !permisosAula.equals(that.permisosAula) : that.permisosAula != null) return false;
        if (permisosOrganizacion != null ? !permisosOrganizacion.equals(that.permisosOrganizacion) : that.permisosOrganizacion != null)
            return false;
        if (permisosCampus != null ? !permisosCampus.equals(that.permisosCampus) : that.permisosCampus != null)
            return false;
        if (soloComision != null ? !soloComision.equals(that.soloComision) : that.soloComision != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoRecursoId ^ (tipoRecursoId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (orden != null ? orden.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (solicitudAulaNuevaClonada != null ? solicitudAulaNuevaClonada.hashCode() : 0);
        result = 31 * result + (solicitudAulaEstandar != null ? solicitudAulaEstandar.hashCode() : 0);
        result = 31 * result + (solicitudAulaPublica != null ? solicitudAulaPublica.hashCode() : 0);
        result = 31 * result + (recursosGrupo != null ? recursosGrupo.hashCode() : 0);
        result = 31 * result + (recursosAula != null ? recursosAula.hashCode() : 0);
        result = 31 * result + (recursosOrganizacion != null ? recursosOrganizacion.hashCode() : 0);
        result = 31 * result + (recursosCampus != null ? recursosCampus.hashCode() : 0);
        result = 31 * result + (permisosGrupo != null ? permisosGrupo.hashCode() : 0);
        result = 31 * result + (permisosAula != null ? permisosAula.hashCode() : 0);
        result = 31 * result + (permisosOrganizacion != null ? permisosOrganizacion.hashCode() : 0);
        result = 31 * result + (permisosCampus != null ? permisosCampus.hashCode() : 0);
        result = 31 * result + (soloComision != null ? soloComision.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tipoRecursoByTipoRecursoId")
    public Collection<AulaHerramientaEntity> getAulaHerramientasByTipoRecursoId() {
        return aulaHerramientasByTipoRecursoId;
    }

    public void setAulaHerramientasByTipoRecursoId(Collection<AulaHerramientaEntity> aulaHerramientasByTipoRecursoId) {
        this.aulaHerramientasByTipoRecursoId = aulaHerramientasByTipoRecursoId;
    }

    @OneToMany(mappedBy = "tipoRecursoByTipoRecursoId")
    public Collection<RecursoEntity> getRecursosByTipoRecursoId() {
        return recursosByTipoRecursoId;
    }

    public void setRecursosByTipoRecursoId(Collection<RecursoEntity> recursosByTipoRecursoId) {
        this.recursosByTipoRecursoId = recursosByTipoRecursoId;
    }

    @OneToMany(mappedBy = "tipoRecursoByHerramientaUsarId")
    public Collection<RecursoSolicitadoEntity> getRecursoSolicitadosByTipoRecursoId() {
        return recursoSolicitadosByTipoRecursoId;
    }

    public void setRecursoSolicitadosByTipoRecursoId(Collection<RecursoSolicitadoEntity> recursoSolicitadosByTipoRecursoId) {
        this.recursoSolicitadosByTipoRecursoId = recursoSolicitadosByTipoRecursoId;
    }
}
