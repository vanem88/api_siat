package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "POPCION_MULTIPLE", schema = "datosEveliaMinimo", catalog = "")
public class PopcionMultipleEntity {
    private long popcionMultipleId;
    private int cantOpciones;
    private byte[] pregunta;
    private int respuestaCorrecta;
    private boolean unaRespuesta;
    private boolean ordenAlfabetico;
    private PreguntaExEntity preguntaExByPopcionMultipleId;
    private Collection<PopcionMultipleOpcionesEntity> popcionMultipleOpcionesByPopcionMultipleId;

    @Id
    @Column(name = "POPCION_MULTIPLE_ID")
    public long getPopcionMultipleId() {
        return popcionMultipleId;
    }

    public void setPopcionMultipleId(long popcionMultipleId) {
        this.popcionMultipleId = popcionMultipleId;
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
    @Column(name = "PREGUNTA")
    public byte[] getPregunta() {
        return pregunta;
    }

    public void setPregunta(byte[] pregunta) {
        this.pregunta = pregunta;
    }

    @Basic
    @Column(name = "RESPUESTA_CORRECTA")
    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Basic
    @Column(name = "UNA_RESPUESTA")
    public boolean isUnaRespuesta() {
        return unaRespuesta;
    }

    public void setUnaRespuesta(boolean unaRespuesta) {
        this.unaRespuesta = unaRespuesta;
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

        PopcionMultipleEntity that = (PopcionMultipleEntity) o;

        if (popcionMultipleId != that.popcionMultipleId) return false;
        if (cantOpciones != that.cantOpciones) return false;
        if (respuestaCorrecta != that.respuestaCorrecta) return false;
        if (unaRespuesta != that.unaRespuesta) return false;
        if (ordenAlfabetico != that.ordenAlfabetico) return false;
        if (!Arrays.equals(pregunta, that.pregunta)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (popcionMultipleId ^ (popcionMultipleId >>> 32));
        result = 31 * result + cantOpciones;
        result = 31 * result + Arrays.hashCode(pregunta);
        result = 31 * result + respuestaCorrecta;
        result = 31 * result + (unaRespuesta ? 1 : 0);
        result = 31 * result + (ordenAlfabetico ? 1 : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "POPCION_MULTIPLE_ID", referencedColumnName = "PREGUNTA_EX_ID", nullable = false, insertable=false, updatable=false)
    public PreguntaExEntity getPreguntaExByPopcionMultipleId() {
        return preguntaExByPopcionMultipleId;
    }

    public void setPreguntaExByPopcionMultipleId(PreguntaExEntity preguntaExByPopcionMultipleId) {
        this.preguntaExByPopcionMultipleId = preguntaExByPopcionMultipleId;
    }

    @OneToMany(mappedBy = "popcionMultipleByPopcionMultipleId")
    public Collection<PopcionMultipleOpcionesEntity> getPopcionMultipleOpcionesByPopcionMultipleId() {
        return popcionMultipleOpcionesByPopcionMultipleId;
    }

    public void setPopcionMultipleOpcionesByPopcionMultipleId(Collection<PopcionMultipleOpcionesEntity> popcionMultipleOpcionesByPopcionMultipleId) {
        this.popcionMultipleOpcionesByPopcionMultipleId = popcionMultipleOpcionesByPopcionMultipleId;
    }
}
