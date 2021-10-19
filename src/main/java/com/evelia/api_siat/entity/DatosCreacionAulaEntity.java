package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "DATOS_CREACION_AULA", schema = "datosEveliaMinimo", catalog = "")
public class DatosCreacionAulaEntity {
    private long datosCreacionAulaId;
    private String estiloVisual;
    private Long id;
    private Byte inscripcionOnLine;
    private String modalidad;
    private Byte mostrarEnOfertaEducativa;
    private String plantillaPermisos;
    private String tipoAccesoAlAula;
    private Byte usoListaCorreo;
    private Long plantillaId;
    private PlantillaPermisoEntity plantillaPermisoByPlantillaId;
    private Collection<SolicitudAulaEntity> solicitudAulasByDatosCreacionAulaId;

    @Id
    @Column(name = "DATOS_CREACION_AULA_ID")
    public long getDatosCreacionAulaId() {
        return datosCreacionAulaId;
    }

    public void setDatosCreacionAulaId(long datosCreacionAulaId) {
        this.datosCreacionAulaId = datosCreacionAulaId;
    }

    @Basic
    @Column(name = "ESTILO_VISUAL")
    public String getEstiloVisual() {
        return estiloVisual;
    }

    public void setEstiloVisual(String estiloVisual) {
        this.estiloVisual = estiloVisual;
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
    @Column(name = "INSCRIPCION_ON_LINE")
    public Byte getInscripcionOnLine() {
        return inscripcionOnLine;
    }

    public void setInscripcionOnLine(Byte inscripcionOnLine) {
        this.inscripcionOnLine = inscripcionOnLine;
    }

    @Basic
    @Column(name = "MODALIDAD")
    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @Basic
    @Column(name = "MOSTRAR_EN_OFERTA_EDUCATIVA")
    public Byte getMostrarEnOfertaEducativa() {
        return mostrarEnOfertaEducativa;
    }

    public void setMostrarEnOfertaEducativa(Byte mostrarEnOfertaEducativa) {
        this.mostrarEnOfertaEducativa = mostrarEnOfertaEducativa;
    }

    @Basic
    @Column(name = "PLANTILLA_PERMISOS")
    public String getPlantillaPermisos() {
        return plantillaPermisos;
    }

    public void setPlantillaPermisos(String plantillaPermisos) {
        this.plantillaPermisos = plantillaPermisos;
    }

    @Basic
    @Column(name = "TIPO_ACCESO_AL_AULA")
    public String getTipoAccesoAlAula() {
        return tipoAccesoAlAula;
    }

    public void setTipoAccesoAlAula(String tipoAccesoAlAula) {
        this.tipoAccesoAlAula = tipoAccesoAlAula;
    }

    @Basic
    @Column(name = "USO_LISTA_CORREO")
    public Byte getUsoListaCorreo() {
        return usoListaCorreo;
    }

    public void setUsoListaCorreo(Byte usoListaCorreo) {
        this.usoListaCorreo = usoListaCorreo;
    }

    @Basic
    @Column(name = "PLANTILLA_ID")
    public Long getPlantillaId() {
        return plantillaId;
    }

    public void setPlantillaId(Long plantillaId) {
        this.plantillaId = plantillaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatosCreacionAulaEntity that = (DatosCreacionAulaEntity) o;

        if (datosCreacionAulaId != that.datosCreacionAulaId) return false;
        if (estiloVisual != null ? !estiloVisual.equals(that.estiloVisual) : that.estiloVisual != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (inscripcionOnLine != null ? !inscripcionOnLine.equals(that.inscripcionOnLine) : that.inscripcionOnLine != null)
            return false;
        if (modalidad != null ? !modalidad.equals(that.modalidad) : that.modalidad != null) return false;
        if (mostrarEnOfertaEducativa != null ? !mostrarEnOfertaEducativa.equals(that.mostrarEnOfertaEducativa) : that.mostrarEnOfertaEducativa != null)
            return false;
        if (plantillaPermisos != null ? !plantillaPermisos.equals(that.plantillaPermisos) : that.plantillaPermisos != null)
            return false;
        if (tipoAccesoAlAula != null ? !tipoAccesoAlAula.equals(that.tipoAccesoAlAula) : that.tipoAccesoAlAula != null)
            return false;
        if (usoListaCorreo != null ? !usoListaCorreo.equals(that.usoListaCorreo) : that.usoListaCorreo != null)
            return false;
        if (plantillaId != null ? !plantillaId.equals(that.plantillaId) : that.plantillaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (datosCreacionAulaId ^ (datosCreacionAulaId >>> 32));
        result = 31 * result + (estiloVisual != null ? estiloVisual.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (inscripcionOnLine != null ? inscripcionOnLine.hashCode() : 0);
        result = 31 * result + (modalidad != null ? modalidad.hashCode() : 0);
        result = 31 * result + (mostrarEnOfertaEducativa != null ? mostrarEnOfertaEducativa.hashCode() : 0);
        result = 31 * result + (plantillaPermisos != null ? plantillaPermisos.hashCode() : 0);
        result = 31 * result + (tipoAccesoAlAula != null ? tipoAccesoAlAula.hashCode() : 0);
        result = 31 * result + (usoListaCorreo != null ? usoListaCorreo.hashCode() : 0);
        result = 31 * result + (plantillaId != null ? plantillaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PLANTILLA_ID", referencedColumnName = "PLANTILLA_PERMISO_ID", insertable=false, updatable=false)
    public PlantillaPermisoEntity getPlantillaPermisoByPlantillaId() {
        return plantillaPermisoByPlantillaId;
    }

    public void setPlantillaPermisoByPlantillaId(PlantillaPermisoEntity plantillaPermisoByPlantillaId) {
        this.plantillaPermisoByPlantillaId = plantillaPermisoByPlantillaId;
    }

    @OneToMany(mappedBy = "datosCreacionAulaByDatosCreacionAulaId")
    public Collection<SolicitudAulaEntity> getSolicitudAulasByDatosCreacionAulaId() {
        return solicitudAulasByDatosCreacionAulaId;
    }

    public void setSolicitudAulasByDatosCreacionAulaId(Collection<SolicitudAulaEntity> solicitudAulasByDatosCreacionAulaId) {
        this.solicitudAulasByDatosCreacionAulaId = solicitudAulasByDatosCreacionAulaId;
    }
}
