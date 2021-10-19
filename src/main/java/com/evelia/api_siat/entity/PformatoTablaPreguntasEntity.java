package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "PFORMATO_TABLA_PREGUNTAS", schema = "datosEveliaMinimo", catalog = "")
@IdClass(PformatoTablaPreguntasEntityPK.class)
public class PformatoTablaPreguntasEntity {
    private long pformatoTablaId;
    private long fraseId;
    private PformatoTablaEntity pformatoTablaByPformatoTablaId;
    private FraseEntity fraseByFraseId;

    @Id
    @Column(name = "PFORMATO_TABLA_ID")
    public long getPformatoTablaId() {
        return pformatoTablaId;
    }

    public void setPformatoTablaId(long pformatoTablaId) {
        this.pformatoTablaId = pformatoTablaId;
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

        PformatoTablaPreguntasEntity that = (PformatoTablaPreguntasEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "PFORMATO_TABLA_ID", referencedColumnName = "PFORMATO_TABLA_ID", nullable = false, insertable=false, updatable=false)
    public PformatoTablaEntity getPformatoTablaByPformatoTablaId() {
        return pformatoTablaByPformatoTablaId;
    }

    public void setPformatoTablaByPformatoTablaId(PformatoTablaEntity pformatoTablaByPformatoTablaId) {
        this.pformatoTablaByPformatoTablaId = pformatoTablaByPformatoTablaId;
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
