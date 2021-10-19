package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORGANIZACION", schema = "datosEveliaMinimo", catalog = "")
public class OrganizacionEntity {
    private long organizacionId;
    private Long plantillaPermisosAulasId;
    private AulaCompuestaEntity aulaCompuestaByOrganizacionId;
    private PlantillaPermisoEntity plantillaPermisoByPlantillaPermisosAulasId;

    @Id
    @Column(name = "ORGANIZACION_ID")
    public long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(long organizacionId) {
        this.organizacionId = organizacionId;
    }

    @Basic
    @Column(name = "PLANTILLA_PERMISOS_AULAS_ID")
    public Long getPlantillaPermisosAulasId() {
        return plantillaPermisosAulasId;
    }

    public void setPlantillaPermisosAulasId(Long plantillaPermisosAulasId) {
        this.plantillaPermisosAulasId = plantillaPermisosAulasId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizacionEntity that = (OrganizacionEntity) o;

        if (organizacionId != that.organizacionId) return false;
        if (plantillaPermisosAulasId != null ? !plantillaPermisosAulasId.equals(that.plantillaPermisosAulasId) : that.plantillaPermisosAulasId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (organizacionId ^ (organizacionId >>> 32));
        result = 31 * result + (plantillaPermisosAulasId != null ? plantillaPermisosAulasId.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "ORGANIZACION_ID", referencedColumnName = "AULA_COMPUESTA_ID", nullable = false, insertable=false, updatable=false)
    public AulaCompuestaEntity getAulaCompuestaByOrganizacionId() {
        return aulaCompuestaByOrganizacionId;
    }

    public void setAulaCompuestaByOrganizacionId(AulaCompuestaEntity aulaCompuestaByOrganizacionId) {
        this.aulaCompuestaByOrganizacionId = aulaCompuestaByOrganizacionId;
    }

    @ManyToOne
    @JoinColumn(name = "PLANTILLA_PERMISOS_AULAS_ID", referencedColumnName = "PLANTILLA_PERMISO_ID", insertable=false, updatable=false)
    public PlantillaPermisoEntity getPlantillaPermisoByPlantillaPermisosAulasId() {
        return plantillaPermisoByPlantillaPermisosAulasId;
    }

    public void setPlantillaPermisoByPlantillaPermisosAulasId(PlantillaPermisoEntity plantillaPermisoByPlantillaPermisosAulasId) {
        this.plantillaPermisoByPlantillaPermisosAulasId = plantillaPermisoByPlantillaPermisosAulasId;
    }
}
