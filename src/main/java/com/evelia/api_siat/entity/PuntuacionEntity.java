package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PUNTUACION", schema = "datosEveliaMinimo", catalog = "")
public class PuntuacionEntity {
    private long puntuacionId;
    private Long id;
    private Long idExAutoex;
    private int orden;
    private double valor;
    private boolean obligatoria;
    private Long categoriaId;
    private Collection<PreguntaExPuntuacionEntity> preguntaExPuntuacionsByPuntuacionId;
    private CategoriaPreguntaEntity categoriaPreguntaByCategoriaId;

    @Id
    @Column(name = "PUNTUACION_ID")
    public long getPuntuacionId() {
        return puntuacionId;
    }

    public void setPuntuacionId(long puntuacionId) {
        this.puntuacionId = puntuacionId;
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
    @Column(name = "ID_EX_AUTOEX")
    public Long getIdExAutoex() {
        return idExAutoex;
    }

    public void setIdExAutoex(Long idExAutoex) {
        this.idExAutoex = idExAutoex;
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
    @Column(name = "VALOR")
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "OBLIGATORIA")
    public boolean isObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    @Basic
    @Column(name = "CATEGORIA_ID")
    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PuntuacionEntity that = (PuntuacionEntity) o;

        if (puntuacionId != that.puntuacionId) return false;
        if (orden != that.orden) return false;
        if (Double.compare(that.valor, valor) != 0) return false;
        if (obligatoria != that.obligatoria) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idExAutoex != null ? !idExAutoex.equals(that.idExAutoex) : that.idExAutoex != null) return false;
        if (categoriaId != null ? !categoriaId.equals(that.categoriaId) : that.categoriaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (puntuacionId ^ (puntuacionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (idExAutoex != null ? idExAutoex.hashCode() : 0);
        result = 31 * result + orden;
        temp = Double.doubleToLongBits(valor);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (obligatoria ? 1 : 0);
        result = 31 * result + (categoriaId != null ? categoriaId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "puntuacionByPuntuacionId")
    public Collection<PreguntaExPuntuacionEntity> getPreguntaExPuntuacionsByPuntuacionId() {
        return preguntaExPuntuacionsByPuntuacionId;
    }

    public void setPreguntaExPuntuacionsByPuntuacionId(Collection<PreguntaExPuntuacionEntity> preguntaExPuntuacionsByPuntuacionId) {
        this.preguntaExPuntuacionsByPuntuacionId = preguntaExPuntuacionsByPuntuacionId;
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "CATEGORIA_PREGUNTA_ID", insertable=false, updatable=false)
    public CategoriaPreguntaEntity getCategoriaPreguntaByCategoriaId() {
        return categoriaPreguntaByCategoriaId;
    }

    public void setCategoriaPreguntaByCategoriaId(CategoriaPreguntaEntity categoriaPreguntaByCategoriaId) {
        this.categoriaPreguntaByCategoriaId = categoriaPreguntaByCategoriaId;
    }
}
