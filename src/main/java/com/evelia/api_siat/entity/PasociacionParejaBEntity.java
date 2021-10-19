package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "PASOCIACION_PAREJA_B", schema = "datosEveliaMinimo", catalog = "")
@IdClass(PasociacionParejaBEntityPK.class)
public class PasociacionParejaBEntity {
    private long pasociacionId;
    private long fraseId;
    private PasociacionEntity pasociacionByPasociacionId;
    private FraseEntity fraseByFraseId;

    @Id
    @Column(name = "PASOCIACION_ID")
    public long getPasociacionId() {
        return pasociacionId;
    }

    public void setPasociacionId(long pasociacionId) {
        this.pasociacionId = pasociacionId;
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

        PasociacionParejaBEntity that = (PasociacionParejaBEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "PASOCIACION_ID", referencedColumnName = "PASOCIACION_ID", nullable = false, insertable=false, updatable=false)
    public PasociacionEntity getPasociacionByPasociacionId() {
        return pasociacionByPasociacionId;
    }

    public void setPasociacionByPasociacionId(PasociacionEntity pasociacionByPasociacionId) {
        this.pasociacionByPasociacionId = pasociacionByPasociacionId;
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
