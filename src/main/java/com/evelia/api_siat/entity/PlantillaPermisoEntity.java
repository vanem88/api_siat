package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "PLANTILLA_PERMISO", schema = "datosEveliaMinimo", catalog = "")
public class PlantillaPermisoEntity {
    private long plantillaPermisoId;
    private Long id;
    private String nombre;
    private Timestamp fecha;
    private String tipoPlantilla;
    private Long aulaCreacionId;
    private Long autorId;
    private Long modificadoPorId;
    private Collection<AulaCompuestaEntity> aulaCompuestasByPlantillaPermisoId;
    private Collection<DatosCreacionAulaEntity> datosCreacionAulasByPlantillaPermisoId;
    private Collection<ItemPlantillaPermisoEntity> itemPlantillaPermisosByPlantillaPermisoId;
    private Collection<OrganizacionEntity> organizacionsByPlantillaPermisoId;
    private AulaEntity aulaByAulaCreacionId;
    private PersonaEntity personaByAutorId;
    private PersonaEntity personaByModificadoPorId;

    @Id
    @Column(name = "PLANTILLA_PERMISO_ID")
    public long getPlantillaPermisoId() {
        return plantillaPermisoId;
    }

    public void setPlantillaPermisoId(long plantillaPermisoId) {
        this.plantillaPermisoId = plantillaPermisoId;
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
    @Column(name = "FECHA")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "TIPO_PLANTILLA")
    public String getTipoPlantilla() {
        return tipoPlantilla;
    }

    public void setTipoPlantilla(String tipoPlantilla) {
        this.tipoPlantilla = tipoPlantilla;
    }

    @Basic
    @Column(name = "AULA_CREACION_ID")
    public Long getAulaCreacionId() {
        return aulaCreacionId;
    }

    public void setAulaCreacionId(Long aulaCreacionId) {
        this.aulaCreacionId = aulaCreacionId;
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
    @Column(name = "MODIFICADO_POR_ID")
    public Long getModificadoPorId() {
        return modificadoPorId;
    }

    public void setModificadoPorId(Long modificadoPorId) {
        this.modificadoPorId = modificadoPorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlantillaPermisoEntity that = (PlantillaPermisoEntity) o;

        if (plantillaPermisoId != that.plantillaPermisoId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (tipoPlantilla != null ? !tipoPlantilla.equals(that.tipoPlantilla) : that.tipoPlantilla != null)
            return false;
        if (aulaCreacionId != null ? !aulaCreacionId.equals(that.aulaCreacionId) : that.aulaCreacionId != null)
            return false;
        if (autorId != null ? !autorId.equals(that.autorId) : that.autorId != null) return false;
        if (modificadoPorId != null ? !modificadoPorId.equals(that.modificadoPorId) : that.modificadoPorId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (plantillaPermisoId ^ (plantillaPermisoId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (tipoPlantilla != null ? tipoPlantilla.hashCode() : 0);
        result = 31 * result + (aulaCreacionId != null ? aulaCreacionId.hashCode() : 0);
        result = 31 * result + (autorId != null ? autorId.hashCode() : 0);
        result = 31 * result + (modificadoPorId != null ? modificadoPorId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "plantillaPermisoByPlantillaPermisoId")
    public Collection<AulaCompuestaEntity> getAulaCompuestasByPlantillaPermisoId() {
        return aulaCompuestasByPlantillaPermisoId;
    }

    public void setAulaCompuestasByPlantillaPermisoId(Collection<AulaCompuestaEntity> aulaCompuestasByPlantillaPermisoId) {
        this.aulaCompuestasByPlantillaPermisoId = aulaCompuestasByPlantillaPermisoId;
    }

    @OneToMany(mappedBy = "plantillaPermisoByPlantillaId")
    public Collection<DatosCreacionAulaEntity> getDatosCreacionAulasByPlantillaPermisoId() {
        return datosCreacionAulasByPlantillaPermisoId;
    }

    public void setDatosCreacionAulasByPlantillaPermisoId(Collection<DatosCreacionAulaEntity> datosCreacionAulasByPlantillaPermisoId) {
        this.datosCreacionAulasByPlantillaPermisoId = datosCreacionAulasByPlantillaPermisoId;
    }

    @OneToMany(mappedBy = "plantillaPermisoByPlantillaPermisoId")
    public Collection<ItemPlantillaPermisoEntity> getItemPlantillaPermisosByPlantillaPermisoId() {
        return itemPlantillaPermisosByPlantillaPermisoId;
    }

    public void setItemPlantillaPermisosByPlantillaPermisoId(Collection<ItemPlantillaPermisoEntity> itemPlantillaPermisosByPlantillaPermisoId) {
        this.itemPlantillaPermisosByPlantillaPermisoId = itemPlantillaPermisosByPlantillaPermisoId;
    }

    @OneToMany(mappedBy = "plantillaPermisoByPlantillaPermisosAulasId")
    public Collection<OrganizacionEntity> getOrganizacionsByPlantillaPermisoId() {
        return organizacionsByPlantillaPermisoId;
    }

    public void setOrganizacionsByPlantillaPermisoId(Collection<OrganizacionEntity> organizacionsByPlantillaPermisoId) {
        this.organizacionsByPlantillaPermisoId = organizacionsByPlantillaPermisoId;
    }

    @ManyToOne
    @JoinColumn(name = "AULA_CREACION_ID", referencedColumnName = "AULA_ID", insertable=false, updatable=false)
    public AulaEntity getAulaByAulaCreacionId() {
        return aulaByAulaCreacionId;
    }

    public void setAulaByAulaCreacionId(AulaEntity aulaByAulaCreacionId) {
        this.aulaByAulaCreacionId = aulaByAulaCreacionId;
    }

    @ManyToOne
    @JoinColumn(name = "AUTOR_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByAutorId() {
        return personaByAutorId;
    }

    public void setPersonaByAutorId(PersonaEntity personaByAutorId) {
        this.personaByAutorId = personaByAutorId;
    }

    @ManyToOne
    @JoinColumn(name = "MODIFICADO_POR_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByModificadoPorId() {
        return personaByModificadoPorId;
    }

    public void setPersonaByModificadoPorId(PersonaEntity personaByModificadoPorId) {
        this.personaByModificadoPorId = personaByModificadoPorId;
    }
}
