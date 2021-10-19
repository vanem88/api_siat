package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "COMUNICACION", schema = "datosEveliaMinimo", catalog = "")
public class ComunicacionEntity {
    private long comunicacionId;
    private Long id;
    private String tipo;
    private AnotadorEntity anotadorByComunicacionId;
    private CalendarioEntity calendarioByComunicacionId;
    private FaqEntity faqByComunicacionId;
    private NovedadEntity novedadByComunicacionId;
    private PizarronEntity pizarronByComunicacionId;
    private Collection<TextoEntity> textosByComunicacionId;

    @Id
    @Column(name = "COMUNICACION_ID")
    public long getComunicacionId() {
        return comunicacionId;
    }

    public void setComunicacionId(long comunicacionId) {
        this.comunicacionId = comunicacionId;
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
    @Column(name = "TIPO")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComunicacionEntity that = (ComunicacionEntity) o;

        if (comunicacionId != that.comunicacionId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (comunicacionId ^ (comunicacionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "comunicacionByAnotadorId")
    public AnotadorEntity getAnotadorByComunicacionId() {
        return anotadorByComunicacionId;
    }

    public void setAnotadorByComunicacionId(AnotadorEntity anotadorByComunicacionId) {
        this.anotadorByComunicacionId = anotadorByComunicacionId;
    }

    @OneToOne(mappedBy = "comunicacionByCalendarioId")
    public CalendarioEntity getCalendarioByComunicacionId() {
        return calendarioByComunicacionId;
    }

    public void setCalendarioByComunicacionId(CalendarioEntity calendarioByComunicacionId) {
        this.calendarioByComunicacionId = calendarioByComunicacionId;
    }

    @OneToOne(mappedBy = "comunicacionByFaqId")
    public FaqEntity getFaqByComunicacionId() {
        return faqByComunicacionId;
    }

    public void setFaqByComunicacionId(FaqEntity faqByComunicacionId) {
        this.faqByComunicacionId = faqByComunicacionId;
    }

    @OneToOne(mappedBy = "comunicacionByNovedadId")
    public NovedadEntity getNovedadByComunicacionId() {
        return novedadByComunicacionId;
    }

    public void setNovedadByComunicacionId(NovedadEntity novedadByComunicacionId) {
        this.novedadByComunicacionId = novedadByComunicacionId;
    }

    @OneToOne(mappedBy = "comunicacionByPizarronId")
    public PizarronEntity getPizarronByComunicacionId() {
        return pizarronByComunicacionId;
    }

    public void setPizarronByComunicacionId(PizarronEntity pizarronByComunicacionId) {
        this.pizarronByComunicacionId = pizarronByComunicacionId;
    }

    @OneToMany(mappedBy = "comunicacionByComunicacionId")
    public Collection<TextoEntity> getTextosByComunicacionId() {
        return textosByComunicacionId;
    }

    public void setTextosByComunicacionId(Collection<TextoEntity> textosByComunicacionId) {
        this.textosByComunicacionId = textosByComunicacionId;
    }
}
