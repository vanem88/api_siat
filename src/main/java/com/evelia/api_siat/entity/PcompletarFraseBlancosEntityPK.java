package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PcompletarFraseBlancosEntityPK implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private long pcompletarFraseId;
    private long fraseId;

    @Column(name = "PCOMPLETAR_FRASE_ID")
    @Id
    public long getPcompletarFraseId() {
        return pcompletarFraseId;
    }

    public void setPcompletarFraseId(long pcompletarFraseId) {
        this.pcompletarFraseId = pcompletarFraseId;
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

        PcompletarFraseBlancosEntityPK that = (PcompletarFraseBlancosEntityPK) o;

        if (pcompletarFraseId != that.pcompletarFraseId) return false;
        if (fraseId != that.fraseId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pcompletarFraseId ^ (pcompletarFraseId >>> 32));
        result = 31 * result + (int) (fraseId ^ (fraseId >>> 32));
        return result;
    }
}
