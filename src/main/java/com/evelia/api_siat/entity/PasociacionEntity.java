package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "PASOCIACION", schema = "datosEveliaMinimo", catalog = "")
public class PasociacionEntity {
    private long pasociacionId;
    private int cantOpciones;
    private byte[] descripcion;
    private PreguntaExEntity preguntaExByPasociacionId;
    private Collection<PasociacionParejaAEntity> pasociacionParejaASByPasociacionId;
    private Collection<PasociacionParejaBEntity> pasociacionParejaBSByPasociacionId;

    @Id
    @Column(name = "PASOCIACION_ID")
    public long getPasociacionId() {
        return pasociacionId;
    }

    public void setPasociacionId(long pasociacionId) {
        this.pasociacionId = pasociacionId;
    }

    @Basic
    @Column(name = "CANT_OPCIONES")
    public int getCantOpciones() {
        return cantOpciones;
    }

    public void setCantOpciones(int cantOpciones) {
        this.cantOpciones = cantOpciones;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public byte[] getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(byte[] descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PasociacionEntity that = (PasociacionEntity) o;

        if (pasociacionId != that.pasociacionId) return false;
        if (cantOpciones != that.cantOpciones) return false;
        if (!Arrays.equals(descripcion, that.descripcion)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pasociacionId ^ (pasociacionId >>> 32));
        result = 31 * result + cantOpciones;
        result = 31 * result + Arrays.hashCode(descripcion);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "PASOCIACION_ID", referencedColumnName = "PREGUNTA_EX_ID", nullable = false, insertable=false, updatable=false)
    public PreguntaExEntity getPreguntaExByPasociacionId() {
        return preguntaExByPasociacionId;
    }

    public void setPreguntaExByPasociacionId(PreguntaExEntity preguntaExByPasociacionId) {
        this.preguntaExByPasociacionId = preguntaExByPasociacionId;
    }

    @OneToMany(mappedBy = "pasociacionByPasociacionId")
    public Collection<PasociacionParejaAEntity> getPasociacionParejaASByPasociacionId() {
        return pasociacionParejaASByPasociacionId;
    }

    public void setPasociacionParejaASByPasociacionId(Collection<PasociacionParejaAEntity> pasociacionParejaASByPasociacionId) {
        this.pasociacionParejaASByPasociacionId = pasociacionParejaASByPasociacionId;
    }

    @OneToMany(mappedBy = "pasociacionByPasociacionId")
    public Collection<PasociacionParejaBEntity> getPasociacionParejaBSByPasociacionId() {
        return pasociacionParejaBSByPasociacionId;
    }

    public void setPasociacionParejaBSByPasociacionId(Collection<PasociacionParejaBEntity> pasociacionParejaBSByPasociacionId) {
        this.pasociacionParejaBSByPasociacionId = pasociacionParejaBSByPasociacionId;
    }
}
