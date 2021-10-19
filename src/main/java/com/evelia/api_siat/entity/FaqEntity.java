package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "FAQ", schema = "datosEveliaMinimo", catalog = "")
public class FaqEntity {
    private long faqId;
    private Collection<AulaEntity> aulasByFaqId;
    private ComunicacionEntity comunicacionByFaqId;

    @Id
    @Column(name = "FAQ_ID")
    public long getFaqId() {
        return faqId;
    }

    public void setFaqId(long faqId) {
        this.faqId = faqId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FaqEntity faqEntity = (FaqEntity) o;

        if (faqId != faqEntity.faqId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (faqId ^ (faqId >>> 32));
    }

    @OneToMany(mappedBy = "faqByFaqId")
    public Collection<AulaEntity> getAulasByFaqId() {
        return aulasByFaqId;
    }

    public void setAulasByFaqId(Collection<AulaEntity> aulasByFaqId) {
        this.aulasByFaqId = aulasByFaqId;
    }

    @OneToOne
    @JoinColumn(name = "FAQ_ID", referencedColumnName = "COMUNICACION_ID", nullable = false, insertable=false, updatable=false)
    public ComunicacionEntity getComunicacionByFaqId() {
        return comunicacionByFaqId;
    }

    public void setComunicacionByFaqId(ComunicacionEntity comunicacionByFaqId) {
        this.comunicacionByFaqId = comunicacionByFaqId;
    }
}
