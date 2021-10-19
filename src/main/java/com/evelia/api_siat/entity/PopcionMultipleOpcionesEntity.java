package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "POPCION_MULTIPLE_OPCIONES", schema = "datosEveliaMinimo", catalog = "")
@IdClass(PopcionMultipleOpcionesEntityPK.class)
public class PopcionMultipleOpcionesEntity {
    private long popcionMultipleId;
    private long fraseId;
    private PopcionMultipleEntity popcionMultipleByPopcionMultipleId;
    private FraseEntity fraseByFraseId;

    @Id
    @Column(name = "POPCION_MULTIPLE_ID")
    public long getPopcionMultipleId() {
        return popcionMultipleId;
    }

    public void setPopcionMultipleId(long popcionMultipleId) {
        this.popcionMultipleId = popcionMultipleId;
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

        PopcionMultipleOpcionesEntity that = (PopcionMultipleOpcionesEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "POPCION_MULTIPLE_ID", referencedColumnName = "POPCION_MULTIPLE_ID", nullable = false, insertable=false, updatable=false)
    public PopcionMultipleEntity getPopcionMultipleByPopcionMultipleId() {
        return popcionMultipleByPopcionMultipleId;
    }

    public void setPopcionMultipleByPopcionMultipleId(PopcionMultipleEntity popcionMultipleByPopcionMultipleId) {
        this.popcionMultipleByPopcionMultipleId = popcionMultipleByPopcionMultipleId;
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
