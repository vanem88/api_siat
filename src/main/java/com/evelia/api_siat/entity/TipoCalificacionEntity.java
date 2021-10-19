package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TIPO_CALIFICACION", schema = "datosEveliaMinimo", catalog = "")
public class TipoCalificacionEntity {
    private long tipoCalificacionId;
    private Long id;
    private String nombre;
    private Long autorId;
    private String tipo;
    private Collection<ActividadEntity> actividadsByTipoCalificacionId;
    private Collection<CursoEntity> cursosByTipoCalificacionId;
    private Collection<PreguntaSiatEntity> preguntaSiatsByTipoCalificacionId;
    private PersonaEntity personaByAutorId;
    private Collection<ValorCalificacionEntity> valorCalificacionsByTipoCalificacionId;

    @Id
    @Column(name = "TIPO_CALIFICACION_ID")
    public long getTipoCalificacionId() {
        return tipoCalificacionId;
    }

    public void setTipoCalificacionId(long tipoCalificacionId) {
        this.tipoCalificacionId = tipoCalificacionId;
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
    @Column(name = "AUTOR_ID")
    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    @Basic
    @Column(name = "TIPO")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoCalificacionEntity that = (TipoCalificacionEntity) o;

        if (tipoCalificacionId != that.tipoCalificacionId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (autorId != null ? !autorId.equals(that.autorId) : that.autorId != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoCalificacionId ^ (tipoCalificacionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (autorId != null ? autorId.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tipoCalificacionByTipoCalificacionId")
    public Collection<ActividadEntity> getActividadsByTipoCalificacionId() {
        return actividadsByTipoCalificacionId;
    }

    public void setActividadsByTipoCalificacionId(Collection<ActividadEntity> actividadsByTipoCalificacionId) {
        this.actividadsByTipoCalificacionId = actividadsByTipoCalificacionId;
    }

    @OneToMany(mappedBy = "tipoCalificacionByTipoCalificacionId")
    public Collection<CursoEntity> getCursosByTipoCalificacionId() {
        return cursosByTipoCalificacionId;
    }

    public void setCursosByTipoCalificacionId(Collection<CursoEntity> cursosByTipoCalificacionId) {
        this.cursosByTipoCalificacionId = cursosByTipoCalificacionId;
    }

    @OneToMany(mappedBy = "tipoCalificacionByTipoCalificacionId")
    public Collection<PreguntaSiatEntity> getPreguntaSiatsByTipoCalificacionId() {
        return preguntaSiatsByTipoCalificacionId;
    }

    public void setPreguntaSiatsByTipoCalificacionId(Collection<PreguntaSiatEntity> preguntaSiatsByTipoCalificacionId) {
        this.preguntaSiatsByTipoCalificacionId = preguntaSiatsByTipoCalificacionId;
    }

    @ManyToOne
    @JoinColumn(name = "AUTOR_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByAutorId() {
        return personaByAutorId;
    }

    public void setPersonaByAutorId(PersonaEntity personaByAutorId) {
        this.personaByAutorId = personaByAutorId;
    }

    @OneToMany(mappedBy = "tipoCalificacionByTipoCalificacionId")
    public Collection<ValorCalificacionEntity> getValorCalificacionsByTipoCalificacionId() {
        return valorCalificacionsByTipoCalificacionId;
    }

    public void setValorCalificacionsByTipoCalificacionId(Collection<ValorCalificacionEntity> valorCalificacionsByTipoCalificacionId) {
        this.valorCalificacionsByTipoCalificacionId = valorCalificacionsByTipoCalificacionId;
    }
}
