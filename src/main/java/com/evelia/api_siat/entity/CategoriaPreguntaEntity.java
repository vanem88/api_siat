package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "CATEGORIA_PREGUNTA", schema = "datosEveliaMinimo", catalog = "")
public class CategoriaPreguntaEntity {
    private long categoriaPreguntaId;
    private byte[] descripcion;
    private Long id;
    private int orden;
    private String titulo;
    private Collection<EvaluacionCategoriasEvalEntity> evaluacionCategoriasEvalsByCategoriaPreguntaId;
    private Collection<PuntuacionEntity> puntuacionsByCategoriaPreguntaId;

    @Id
    @Column(name = "CATEGORIA_PREGUNTA_ID")
    public long getCategoriaPreguntaId() {
        return categoriaPreguntaId;
    }

    public void setCategoriaPreguntaId(long categoriaPreguntaId) {
        this.categoriaPreguntaId = categoriaPreguntaId;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public byte[] getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(byte[] descripcion) {
        this.descripcion = descripcion;
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
    @Column(name = "ORDEN")
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
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

        CategoriaPreguntaEntity that = (CategoriaPreguntaEntity) o;

        if (categoriaPreguntaId != that.categoriaPreguntaId) return false;
        if (orden != that.orden) return false;
        if (!Arrays.equals(descripcion, that.descripcion)) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (categoriaPreguntaId ^ (categoriaPreguntaId >>> 32));
        result = 31 * result + Arrays.hashCode(descripcion);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + orden;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoriaPreguntaByCategoriaPreguntaId")
    public Collection<EvaluacionCategoriasEvalEntity> getEvaluacionCategoriasEvalsByCategoriaPreguntaId() {
        return evaluacionCategoriasEvalsByCategoriaPreguntaId;
    }

    public void setEvaluacionCategoriasEvalsByCategoriaPreguntaId(Collection<EvaluacionCategoriasEvalEntity> evaluacionCategoriasEvalsByCategoriaPreguntaId) {
        this.evaluacionCategoriasEvalsByCategoriaPreguntaId = evaluacionCategoriasEvalsByCategoriaPreguntaId;
    }

    @OneToMany(mappedBy = "categoriaPreguntaByCategoriaId")
    public Collection<PuntuacionEntity> getPuntuacionsByCategoriaPreguntaId() {
        return puntuacionsByCategoriaPreguntaId;
    }

    public void setPuntuacionsByCategoriaPreguntaId(Collection<PuntuacionEntity> puntuacionsByCategoriaPreguntaId) {
        this.puntuacionsByCategoriaPreguntaId = puntuacionsByCategoriaPreguntaId;
    }
}
