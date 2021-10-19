package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "JDO_TABLE", schema = "datosEveliaMinimo", catalog = "")
public class JdoTableEntity {
    private int tableId;
    private int nextId;
    private String javaName;
    private String tableName;
    private Collection<AuditoriaOperacionEntity> auditoriaOperacionsByTableId;

    @Id
    @Column(name = "TABLE_ID")
    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    @Basic
    @Column(name = "NEXT_ID")
    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    @Basic
    @Column(name = "JAVA_NAME")
    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    @Basic
    @Column(name = "TABLE_NAME")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JdoTableEntity that = (JdoTableEntity) o;

        if (tableId != that.tableId) return false;
        if (nextId != that.nextId) return false;
        if (javaName != null ? !javaName.equals(that.javaName) : that.javaName != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableId;
        result = 31 * result + nextId;
        result = 31 * result + (javaName != null ? javaName.hashCode() : 0);
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "jdoTableByTablaId")
    public Collection<AuditoriaOperacionEntity> getAuditoriaOperacionsByTableId() {
        return auditoriaOperacionsByTableId;
    }

    public void setAuditoriaOperacionsByTableId(Collection<AuditoriaOperacionEntity> auditoriaOperacionsByTableId) {
        this.auditoriaOperacionsByTableId = auditoriaOperacionsByTableId;
    }
}
