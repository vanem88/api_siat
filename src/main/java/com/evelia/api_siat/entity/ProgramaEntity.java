package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "PROGRAMA", schema = "datosEveliaMinimo", catalog = "")
public class ProgramaEntity {
    private long programaId;
    private Long id;
    private byte[] descripcionOnLine;
    private String titulo;
    private Collection<AulaCompuestaEntity> aulaCompuestasByProgramaId;
    private Collection<ProgramaArchivosEntity> programaArchivosByProgramaId;

    @Id
    @Column(name = "PROGRAMA_ID")
    public long getProgramaId() {
        return programaId;
    }

    public void setProgramaId(long programaId) {
        this.programaId = programaId;
    }

    @Basic
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DESCRIPCION_ON_LINE")
    public byte[] getDescripcionOnLine() {
        return descripcionOnLine;
    }

    public void setDescripcionOnLine(byte[] descripcionOnLine) {
        this.descripcionOnLine = descripcionOnLine;
    }

    @Basic
    @Column(name = "TITULO")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgramaEntity that = (ProgramaEntity) o;

        if (programaId != that.programaId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!Arrays.equals(descripcionOnLine, that.descripcionOnLine)) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (programaId ^ (programaId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(descripcionOnLine);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "programaByProgramaId")
    public Collection<AulaCompuestaEntity> getAulaCompuestasByProgramaId() {
        return aulaCompuestasByProgramaId;
    }

    public void setAulaCompuestasByProgramaId(Collection<AulaCompuestaEntity> aulaCompuestasByProgramaId) {
        this.aulaCompuestasByProgramaId = aulaCompuestasByProgramaId;
    }

    @OneToMany(mappedBy = "programaByProgramaId")
    public Collection<ProgramaArchivosEntity> getProgramaArchivosByProgramaId() {
        return programaArchivosByProgramaId;
    }

    public void setProgramaArchivosByProgramaId(Collection<ProgramaArchivosEntity> programaArchivosByProgramaId) {
        this.programaArchivosByProgramaId = programaArchivosByProgramaId;
    }
}
