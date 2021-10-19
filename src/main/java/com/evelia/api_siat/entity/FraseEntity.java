package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "FRASE", schema = "datosEveliaMinimo", catalog = "")
public class FraseEntity {
    private long fraseId;
    private Long id;
    private int orden;
    private String texto;
    private Long adjuntoId;
    private ArchivoEntity archivoByAdjuntoId;
    private Collection<PasociacionParejaAEntity> pasociacionParejaASByFraseId;
    private Collection<PasociacionParejaBEntity> pasociacionParejaBSByFraseId;
    private Collection<PcompletarFraseBlancosEntity> pcompletarFraseBlancosByFraseId;
    private Collection<PformatoTablaPreguntasEntity> pformatoTablaPreguntasByFraseId;
    private Collection<PformatoTablaRespuestasEntity> pformatoTablaRespuestasByFraseId;
    private Collection<PformatoTablaRespCorrectasEntity> pformatoTablaRespCorrectasByFraseId;
    private Collection<PopcionMultipleOpcionesEntity> popcionMultipleOpcionesByFraseId;
    private Collection<RespuestaExConjRespuestaEntity> respuestaExConjRespuestasByFraseId;
    private Collection<RespuestaExOrdenOpcionEntity> respuestaExOrdenOpcionsByFraseId;

    @Id
    @Column(name = "FRASE_ID")
    public long getFraseId() {
        return fraseId;
    }

    public void setFraseId(long fraseId) {
        this.fraseId = fraseId;
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
    @Column(name = "ORDEN")
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Basic
    @Column(name = "TEXTO")
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Basic
    @Column(name = "ADJUNTO_ID")
    public Long getAdjuntoId() {
        return adjuntoId;
    }

    public void setAdjuntoId(Long adjuntoId) {
        this.adjuntoId = adjuntoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FraseEntity that = (FraseEntity) o;

        if (fraseId != that.fraseId) return false;
        if (orden != that.orden) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (texto != null ? !texto.equals(that.texto) : that.texto != null) return false;
        if (adjuntoId != null ? !adjuntoId.equals(that.adjuntoId) : that.adjuntoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (fraseId ^ (fraseId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + orden;
        result = 31 * result + (texto != null ? texto.hashCode() : 0);
        result = 31 * result + (adjuntoId != null ? adjuntoId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ADJUNTO_ID", referencedColumnName = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByAdjuntoId() {
        return archivoByAdjuntoId;
    }

    public void setArchivoByAdjuntoId(ArchivoEntity archivoByAdjuntoId) {
        this.archivoByAdjuntoId = archivoByAdjuntoId;
    }

    @OneToMany(mappedBy = "fraseByFraseId")
    public Collection<PasociacionParejaAEntity> getPasociacionParejaASByFraseId() {
        return pasociacionParejaASByFraseId;
    }

    public void setPasociacionParejaASByFraseId(Collection<PasociacionParejaAEntity> pasociacionParejaASByFraseId) {
        this.pasociacionParejaASByFraseId = pasociacionParejaASByFraseId;
    }

    @OneToMany(mappedBy = "fraseByFraseId")
    public Collection<PasociacionParejaBEntity> getPasociacionParejaBSByFraseId() {
        return pasociacionParejaBSByFraseId;
    }

    public void setPasociacionParejaBSByFraseId(Collection<PasociacionParejaBEntity> pasociacionParejaBSByFraseId) {
        this.pasociacionParejaBSByFraseId = pasociacionParejaBSByFraseId;
    }

    @OneToMany(mappedBy = "fraseByFraseId")
    public Collection<PcompletarFraseBlancosEntity> getPcompletarFraseBlancosByFraseId() {
        return pcompletarFraseBlancosByFraseId;
    }

    public void setPcompletarFraseBlancosByFraseId(Collection<PcompletarFraseBlancosEntity> pcompletarFraseBlancosByFraseId) {
        this.pcompletarFraseBlancosByFraseId = pcompletarFraseBlancosByFraseId;
    }

    @OneToMany(mappedBy = "fraseByFraseId")
    public Collection<PformatoTablaPreguntasEntity> getPformatoTablaPreguntasByFraseId() {
        return pformatoTablaPreguntasByFraseId;
    }

    public void setPformatoTablaPreguntasByFraseId(Collection<PformatoTablaPreguntasEntity> pformatoTablaPreguntasByFraseId) {
        this.pformatoTablaPreguntasByFraseId = pformatoTablaPreguntasByFraseId;
    }

    @OneToMany(mappedBy = "fraseByFraseId")
    public Collection<PformatoTablaRespuestasEntity> getPformatoTablaRespuestasByFraseId() {
        return pformatoTablaRespuestasByFraseId;
    }

    public void setPformatoTablaRespuestasByFraseId(Collection<PformatoTablaRespuestasEntity> pformatoTablaRespuestasByFraseId) {
        this.pformatoTablaRespuestasByFraseId = pformatoTablaRespuestasByFraseId;
    }

    @OneToMany(mappedBy = "fraseByFraseId")
    public Collection<PformatoTablaRespCorrectasEntity> getPformatoTablaRespCorrectasByFraseId() {
        return pformatoTablaRespCorrectasByFraseId;
    }

    public void setPformatoTablaRespCorrectasByFraseId(Collection<PformatoTablaRespCorrectasEntity> pformatoTablaRespCorrectasByFraseId) {
        this.pformatoTablaRespCorrectasByFraseId = pformatoTablaRespCorrectasByFraseId;
    }

    @OneToMany(mappedBy = "fraseByFraseId")
    public Collection<PopcionMultipleOpcionesEntity> getPopcionMultipleOpcionesByFraseId() {
        return popcionMultipleOpcionesByFraseId;
    }

    public void setPopcionMultipleOpcionesByFraseId(Collection<PopcionMultipleOpcionesEntity> popcionMultipleOpcionesByFraseId) {
        this.popcionMultipleOpcionesByFraseId = popcionMultipleOpcionesByFraseId;
    }

    @OneToMany(mappedBy = "fraseByFraseId")
    public Collection<RespuestaExConjRespuestaEntity> getRespuestaExConjRespuestasByFraseId() {
        return respuestaExConjRespuestasByFraseId;
    }

    public void setRespuestaExConjRespuestasByFraseId(Collection<RespuestaExConjRespuestaEntity> respuestaExConjRespuestasByFraseId) {
        this.respuestaExConjRespuestasByFraseId = respuestaExConjRespuestasByFraseId;
    }

    @OneToMany(mappedBy = "fraseByFraseId")
    public Collection<RespuestaExOrdenOpcionEntity> getRespuestaExOrdenOpcionsByFraseId() {
        return respuestaExOrdenOpcionsByFraseId;
    }

    public void setRespuestaExOrdenOpcionsByFraseId(Collection<RespuestaExOrdenOpcionEntity> respuestaExOrdenOpcionsByFraseId) {
        this.respuestaExOrdenOpcionsByFraseId = respuestaExOrdenOpcionsByFraseId;
    }
}
