package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "OID", schema = "datosEveliaMinimo", catalog = "")
public class OidEntity {
    private long oidId;
    private Long oid;

    @Id
    @Column(name = "OID_ID")
    public long getOidId() {
        return oidId;
    }

    public void setOidId(long oidId) {
        this.oidId = oidId;
    }

    @Basic
    @Column(name = "OID")
    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OidEntity oidEntity = (OidEntity) o;

        if (oidId != oidEntity.oidId) return false;
        if (oid != null ? !oid.equals(oidEntity.oid) : oidEntity.oid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (oidId ^ (oidId >>> 32));
        result = 31 * result + (oid != null ? oid.hashCode() : 0);
        return result;
    }
}
