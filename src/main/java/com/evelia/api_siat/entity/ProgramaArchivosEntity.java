package com.evelia.api_siat.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "PROGRAMA_ARCHIVOS", schema = "datosEveliaMinimo", catalog = "")
public class ProgramaArchivosEntity implements Serializable {
    
    private long programaId;
    private long archivoId;
    private ProgramaEntity programaByProgramaId;
    private ArchivoEntity archivoByArchivoId;

    @Basic
    @Id
    @Column(name = "PROGRAMA_ID")
    public long getProgramaId() {
        return programaId;
    }

    public void setProgramaId(long programaId) {
        this.programaId = programaId;
    }

    @Basic
    @Id
    @Column(name = "ARCHIVO_ID")
    public long getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(long archivoId) {
        this.archivoId = archivoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgramaArchivosEntity that = (ProgramaArchivosEntity) o;

        if (programaId != that.programaId) return false;
        if (archivoId != that.archivoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (programaId ^ (programaId >>> 32));
        result = 31 * result + (int) (archivoId ^ (archivoId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PROGRAMA_ID", referencedColumnName = "PROGRAMA_ID", nullable = false, insertable=false, updatable=false)
    public ProgramaEntity getProgramaByProgramaId() {
        return programaByProgramaId;
    }

    public void setProgramaByProgramaId(ProgramaEntity programaByProgramaId) {
        this.programaByProgramaId = programaByProgramaId;
    }

    @ManyToOne
    @JoinColumn(name = "ARCHIVO_ID", referencedColumnName = "ARCHIVO_ID", nullable = false, insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoId() {
        return archivoByArchivoId;
    }

    public void setArchivoByArchivoId(ArchivoEntity archivoByArchivoId) {
        this.archivoByArchivoId = archivoByArchivoId;
    }
}
