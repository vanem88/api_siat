package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "PFORMATO_TABLA", schema = "datosEveliaMinimo", catalog = "")
public class PformatoTablaEntity {
    private long pformatoTablaId;
    private int cantPreguntas;
    private int cantRespuestas;
    private byte[] descripcion;
    private boolean ordenAlfabetico;
    private PreguntaExEntity preguntaExByPformatoTablaId;
    private Collection<PformatoTablaPreguntasEntity> pformatoTablaPreguntasByPformatoTablaId;
    private Collection<PformatoTablaRespuestasEntity> pformatoTablaRespuestasByPformatoTablaId;
    private Collection<PformatoTablaRespCorrectasEntity> pformatoTablaRespCorrectasByPformatoTablaId;

    @Id
    @Column(name = "PFORMATO_TABLA_ID")
    public long getPformatoTablaId() {
        return pformatoTablaId;
    }

    public void setPformatoTablaId(long pformatoTablaId) {
        this.pformatoTablaId = pformatoTablaId;
    }

    @Basic
    @Column(name = "CANT_PREGUNTAS")
    public int getCantPreguntas() {
        return cantPreguntas;
    }

    public void setCantPreguntas(int cantPreguntas) {
        this.cantPreguntas = cantPreguntas;
    }

    @Basic
    @Column(name = "CANT_RESPUESTAS")
    public int getCantRespuestas() {
        return cantRespuestas;
    }

    public void setCantRespuestas(int cantRespuestas) {
        this.cantRespuestas = cantRespuestas;
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
    @Column(name = "ORDEN_ALFABETICO")
    public boolean isOrdenAlfabetico() {
        return ordenAlfabetico;
    }

    public void setOrdenAlfabetico(boolean ordenAlfabetico) {
        this.ordenAlfabetico = ordenAlfabetico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PformatoTablaEntity that = (PformatoTablaEntity) o;

        if (pformatoTablaId != that.pformatoTablaId) return false;
        if (cantPreguntas != that.cantPreguntas) return false;
        if (cantRespuestas != that.cantRespuestas) return false;
        if (ordenAlfabetico != that.ordenAlfabetico) return false;
        if (!Arrays.equals(descripcion, that.descripcion)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pformatoTablaId ^ (pformatoTablaId >>> 32));
        result = 31 * result + cantPreguntas;
        result = 31 * result + cantRespuestas;
        result = 31 * result + Arrays.hashCode(descripcion);
        result = 31 * result + (ordenAlfabetico ? 1 : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "PFORMATO_TABLA_ID", referencedColumnName = "PREGUNTA_EX_ID", nullable = false, insertable=false, updatable=false)
    public PreguntaExEntity getPreguntaExByPformatoTablaId() {
        return preguntaExByPformatoTablaId;
    }

    public void setPreguntaExByPformatoTablaId(PreguntaExEntity preguntaExByPformatoTablaId) {
        this.preguntaExByPformatoTablaId = preguntaExByPformatoTablaId;
    }

    @OneToMany(mappedBy = "pformatoTablaByPformatoTablaId")
    public Collection<PformatoTablaPreguntasEntity> getPformatoTablaPreguntasByPformatoTablaId() {
        return pformatoTablaPreguntasByPformatoTablaId;
    }

    public void setPformatoTablaPreguntasByPformatoTablaId(Collection<PformatoTablaPreguntasEntity> pformatoTablaPreguntasByPformatoTablaId) {
        this.pformatoTablaPreguntasByPformatoTablaId = pformatoTablaPreguntasByPformatoTablaId;
    }

    @OneToMany(mappedBy = "pformatoTablaByPformatoTablaId")
    public Collection<PformatoTablaRespuestasEntity> getPformatoTablaRespuestasByPformatoTablaId() {
        return pformatoTablaRespuestasByPformatoTablaId;
    }

    public void setPformatoTablaRespuestasByPformatoTablaId(Collection<PformatoTablaRespuestasEntity> pformatoTablaRespuestasByPformatoTablaId) {
        this.pformatoTablaRespuestasByPformatoTablaId = pformatoTablaRespuestasByPformatoTablaId;
    }

    @OneToMany(mappedBy = "pformatoTablaByPformatoTablaId")
    public Collection<PformatoTablaRespCorrectasEntity> getPformatoTablaRespCorrectasByPformatoTablaId() {
        return pformatoTablaRespCorrectasByPformatoTablaId;
    }

    public void setPformatoTablaRespCorrectasByPformatoTablaId(Collection<PformatoTablaRespCorrectasEntity> pformatoTablaRespCorrectasByPformatoTablaId) {
        this.pformatoTablaRespCorrectasByPformatoTablaId = pformatoTablaRespCorrectasByPformatoTablaId;
    }
}
