package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PasociacionParejaBEntityPK implements Serializable {
    private long pasociacionId;
    private long fraseId;

    @Column(name = "PASOCIACION_ID")
    @Id
    public long getPasociacionId() {
        return pasociacionId;
    }

    public void setPasociacionId(long pasociacionId) {
        this.pasociacionId = pasociacionId;
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

        PasociacionParejaBEntityPK that = (PasociacionParejaBEntityPK) o;

        if (pasociacionId != that.pasociacionId) return false;
        if (fraseId != that.fraseId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pasociacionId ^ (pasociacionId >>> 32));
        result = 31 * result + (int) (fraseId ^ (fraseId >>> 32));
        return result;
    }
}
