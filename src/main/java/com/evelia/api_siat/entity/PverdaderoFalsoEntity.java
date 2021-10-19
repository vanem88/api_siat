package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "PVERDADERO_FALSO", schema = "datosEveliaMinimo", catalog = "")
public class PverdaderoFalsoEntity {
    private long pverdaderoFalsoId;
    private byte[] pregunta;
    private boolean respuesta;
    private PreguntaExEntity preguntaExByPverdaderoFalsoId;

    @Id
    @Column(name = "PVERDADERO_FALSO_ID")
    public long getPverdaderoFalsoId() {
        return pverdaderoFalsoId;
    }

    public void setPverdaderoFalsoId(long pverdaderoFalsoId) {
        this.pverdaderoFalsoId = pverdaderoFalsoId;
    }

    @Basic
    @Column(name = "PREGUNTA")
    public byte[] getPregunta() {
        return pregunta;
    }

    public void setPregunta(byte[] pregunta) {
        this.pregunta = pregunta;
    }

    @Basic
    @Column(name = "RESPUESTA")
    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PverdaderoFalsoEntity that = (PverdaderoFalsoEntity) o;

        if (pverdaderoFalsoId != that.pverdaderoFalsoId) return false;
        if (respuesta != that.respuesta) return false;
        if (!Arrays.equals(pregunta, that.pregunta)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pverdaderoFalsoId ^ (pverdaderoFalsoId >>> 32));
        result = 31 * result + Arrays.hashCode(pregunta);
        result = 31 * result + (respuesta ? 1 : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "PVERDADERO_FALSO_ID", referencedColumnName = "PREGUNTA_EX_ID", nullable = false, insertable=false, updatable=false)
    public PreguntaExEntity getPreguntaExByPverdaderoFalsoId() {
        return preguntaExByPverdaderoFalsoId;
    }

    public void setPreguntaExByPverdaderoFalsoId(PreguntaExEntity preguntaExByPverdaderoFalsoId) {
        this.preguntaExByPverdaderoFalsoId = preguntaExByPverdaderoFalsoId;
    }
}
