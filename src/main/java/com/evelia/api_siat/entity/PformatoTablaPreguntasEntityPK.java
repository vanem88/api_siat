package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PformatoTablaPreguntasEntityPK implements Serializable {
  
	private static final long serialVersionUID = 1L;
	private long pformatoTablaId;
    private long fraseId;

    @Column(name = "PFORMATO_TABLA_ID")
    @Id
    public long getPformatoTablaId() {
        return pformatoTablaId;
    }

    public void setPformatoTablaId(long pformatoTablaId) {
        this.pformatoTablaId = pformatoTablaId;
    }

    @Column(name = "FRASE_ID")
    @Id
    public long getFraseId() {
        return fraseId;
    }

    public void setFraseId(long fraseId) {
        this.fraseId = fraseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PformatoTablaPreguntasEntityPK that = (PformatoTablaPreguntasEntityPK) o;

        if (pformatoTablaId != that.pformatoTablaId) return false;
        if (fraseId != that.fraseId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pformatoTablaId ^ (pformatoTablaId >>> 32));
        result = 31 * result + (int) (fraseId ^ (fraseId >>> 32));
        return result;
    }
}
