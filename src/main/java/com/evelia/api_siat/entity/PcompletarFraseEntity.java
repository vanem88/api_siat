package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "PCOMPLETAR_FRASE", schema = "datosEveliaMinimo", catalog = "")
public class PcompletarFraseEntity {
    private long pcompletarFraseId;
    private byte[] descripcion;
    private boolean mostrarOpciones;
    private byte[] texto;
    private PreguntaExEntity preguntaExByPcompletarFraseId;
    private Collection<PcompletarFraseBlancosEntity> pcompletarFraseBlancosByPcompletarFraseId;

    @Id
    @Column(name = "PCOMPLETAR_FRASE_ID")
    public long getPcompletarFraseId() {
        return pcompletarFraseId;
    }

    public void setPcompletarFraseId(long pcompletarFraseId) {
        this.pcompletarFraseId = pcompletarFraseId;
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
    @Column(name = "MOSTRAR_OPCIONES")
    public boolean isMostrarOpciones() {
        return mostrarOpciones;
    }

    public void setMostrarOpciones(boolean mostrarOpciones) {
        this.mostrarOpciones = mostrarOpciones;
    }

    @Basic
    @Column(name = "TEXTO")
    public byte[] getTexto() {
        return texto;
    }

    public void setTexto(byte[] texto) {
        this.texto = texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PcompletarFraseEntity that = (PcompletarFraseEntity) o;

        if (pcompletarFraseId != that.pcompletarFraseId) return false;
        if (mostrarOpciones != that.mostrarOpciones) return false;
        if (!Arrays.equals(descripcion, that.descripcion)) return false;
        if (!Arrays.equals(texto, that.texto)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pcompletarFraseId ^ (pcompletarFraseId >>> 32));
        result = 31 * result + Arrays.hashCode(descripcion);
        result = 31 * result + (mostrarOpciones ? 1 : 0);
        result = 31 * result + Arrays.hashCode(texto);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "PCOMPLETAR_FRASE_ID", referencedColumnName = "PREGUNTA_EX_ID", nullable = false, insertable=false, updatable=false)
    public PreguntaExEntity getPreguntaExByPcompletarFraseId() {
        return preguntaExByPcompletarFraseId;
    }

    public void setPreguntaExByPcompletarFraseId(PreguntaExEntity preguntaExByPcompletarFraseId) {
        this.preguntaExByPcompletarFraseId = preguntaExByPcompletarFraseId;
    }

    @OneToMany(mappedBy = "pcompletarFraseByPcompletarFraseId")
    public Collection<PcompletarFraseBlancosEntity> getPcompletarFraseBlancosByPcompletarFraseId() {
        return pcompletarFraseBlancosByPcompletarFraseId;
    }

    public void setPcompletarFraseBlancosByPcompletarFraseId(Collection<PcompletarFraseBlancosEntity> pcompletarFraseBlancosByPcompletarFraseId) {
        this.pcompletarFraseBlancosByPcompletarFraseId = pcompletarFraseBlancosByPcompletarFraseId;
    }
}
