package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "PCOMPLETAR_FRASE_BLANCOS", schema = "datosEveliaMinimo", catalog = "")
@IdClass(PcompletarFraseBlancosEntityPK.class)
public class PcompletarFraseBlancosEntity {
    private long pcompletarFraseId;
    private long fraseId;
    private PcompletarFraseEntity pcompletarFraseByPcompletarFraseId;
    private FraseEntity fraseByFraseId;

    @Id
    @Column(name = "PCOMPLETAR_FRASE_ID")
    public long getPcompletarFraseId() {
        return pcompletarFraseId;
    }

    public void setPcompletarFraseId(long pcompletarFraseId) {
        this.pcompletarFraseId = pcompletarFraseId;
    }

    @Id
    @Column(name = "FRASE_ID")
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

        PcompletarFraseBlancosEntity that = (PcompletarFraseBlancosEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "PCOMPLETAR_FRASE_ID", referencedColumnName = "PCOMPLETAR_FRASE_ID", nullable = false, insertable=false, updatable=false)
    public PcompletarFraseEntity getPcompletarFraseByPcompletarFraseId() {
        return pcompletarFraseByPcompletarFraseId;
    }

    public void setPcompletarFraseByPcompletarFraseId(PcompletarFraseEntity pcompletarFraseByPcompletarFraseId) {
        this.pcompletarFraseByPcompletarFraseId = pcompletarFraseByPcompletarFraseId;
    }

    @ManyToOne
    @JoinColumn(name = "FRASE_ID", referencedColumnName = "FRASE_ID", nullable = false, insertable=false, updatable=false)
    public FraseEntity getFraseByFraseId() {
        return fraseByFraseId;
    }

    public void setFraseByFraseId(FraseEntity fraseByFraseId) {
        this.fraseByFraseId = fraseByFraseId;
    }
}
