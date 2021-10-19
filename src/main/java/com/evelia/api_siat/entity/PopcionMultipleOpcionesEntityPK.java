package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PopcionMultipleOpcionesEntityPK implements Serializable {
    private long popcionMultipleId;
    private long fraseId;

    @Column(name = "POPCION_MULTIPLE_ID")
    @Id
    public long getPopcionMultipleId() {
        return popcionMultipleId;
    }

    public void setPopcionMultipleId(long popcionMultipleId) {
        this.popcionMultipleId = popcionMultipleId;
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

        PopcionMultipleOpcionesEntityPK that = (PopcionMultipleOpcionesEntityPK) o;

        if (popcionMultipleId != that.popcionMultipleId) return false;
        if (fraseId != that.fraseId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (popcionMultipleId ^ (popcionMultipleId >>> 32));
        result = 31 * result + (int) (fraseId ^ (fraseId >>> 32));
        return result;
    }
}
