package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "MIGRANDO_RECURSO", schema = "datosEveliaMinimo", catalog = "")
public class MigrandoRecursoEntity {
    private long migrandoRecursoId;
    private Timestamp fechaCreacionRecursos;
    private byte migrarRecurso;
    private RecursoMigracionEntity recursoMigracionByMigrandoRecursoId;

    @Id
    @Column(name = "MIGRANDO_RECURSO_ID")
    public long getMigrandoRecursoId() {
        return migrandoRecursoId;
    }

    public void setMigrandoRecursoId(long migrandoRecursoId) {
        this.migrandoRecursoId = migrandoRecursoId;
    }

    @Basic
    @Column(name = "FECHA_CREACION_RECURSOS")
    public Timestamp getFechaCreacionRecursos() {
        return fechaCreacionRecursos;
    }

    public void setFechaCreacionRecursos(Timestamp fechaCreacionRecursos) {
        this.fechaCreacionRecursos = fechaCreacionRecursos;
    }

    @Basic
    @Column(name = "MIGRAR_RECURSO")
    public byte getMigrarRecurso() {
        return migrarRecurso;
    }

    public void setMigrarRecurso(byte migrarRecurso) {
        this.migrarRecurso = migrarRecurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MigrandoRecursoEntity that = (MigrandoRecursoEntity) o;

        if (migrandoRecursoId != that.migrandoRecursoId) return false;
        if (migrarRecurso != that.migrarRecurso) return false;
        if (fechaCreacionRecursos != null ? !fechaCreacionRecursos.equals(that.fechaCreacionRecursos) : that.fechaCreacionRecursos != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (migrandoRecursoId ^ (migrandoRecursoId >>> 32));
        result = 31 * result + (fechaCreacionRecursos != null ? fechaCreacionRecursos.hashCode() : 0);
        result = 31 * result + (int) migrarRecurso;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "MIGRANDO_RECURSO_ID", referencedColumnName = "RECURSO_MIGRACION_ID", nullable = false, insertable=false, updatable=false)
    public RecursoMigracionEntity getRecursoMigracionByMigrandoRecursoId() {
        return recursoMigracionByMigrandoRecursoId;
    }

    public void setRecursoMigracionByMigrandoRecursoId(RecursoMigracionEntity recursoMigracionByMigrandoRecursoId) {
        this.recursoMigracionByMigrandoRecursoId = recursoMigracionByMigrandoRecursoId;
    }
}
