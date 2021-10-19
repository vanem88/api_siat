package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PREGUNTA_EX", schema = "datosEveliaMinimo", catalog = "")
public class PreguntaExEntity {
    private long preguntaExId;
    private boolean deCuestionario;
    private Long id;
    private Long personaId;
    private String tipoPreg;
    private Collection<EvaluacionPreguntasEntity> evaluacionPreguntasByPreguntaExId;
    private PasociacionEntity pasociacionByPreguntaExId;
    private PcompletarFraseEntity pcompletarFraseByPreguntaExId;
    private PformatoTablaEntity pformatoTablaByPreguntaExId;
    private PnumericaCalculadaEntity pnumericaCalculadaByPreguntaExId;
    private PopcionMultipleEntity popcionMultipleByPreguntaExId;
    private PersonaEntity personaByPersonaId;
    private Collection<PreguntaExAdjuntosEntity> preguntaExAdjuntosByPreguntaExId;
    private Collection<PreguntaExPuntuacionEntity> preguntaExPuntuacionsByPreguntaExId;
    private PrespuestaAbiertaEntity prespuestaAbiertaByPreguntaExId;
    private PrespuestaCerradaEntity prespuestaCerradaByPreguntaExId;
    private PverdaderoFalsoEntity pverdaderoFalsoByPreguntaExId;
    private Collection<RespuestaExEntity> respuestaExesByPreguntaExId;

    @Id
    @Column(name = "PREGUNTA_EX_ID")
    public long getPreguntaExId() {
        return preguntaExId;
    }

    public void setPreguntaExId(long preguntaExId) {
        this.preguntaExId = preguntaExId;
    }

    @Basic
    @Column(name = "DE_CUESTIONARIO")
    public boolean isDeCuestionario() {
        return deCuestionario;
    }

    public void setDeCuestionario(boolean deCuestionario) {
        this.deCuestionario = deCuestionario;
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
    @Column(name = "PERSONA_ID")
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    @Basic
    @Column(name = "TIPO_PREG")
    public String getTipoPreg() {
        return tipoPreg;
    }

    public void setTipoPreg(String tipoPreg) {
        this.tipoPreg = tipoPreg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreguntaExEntity that = (PreguntaExEntity) o;

        if (preguntaExId != that.preguntaExId) return false;
        if (deCuestionario != that.deCuestionario) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (tipoPreg != null ? !tipoPreg.equals(that.tipoPreg) : that.tipoPreg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (preguntaExId ^ (preguntaExId >>> 32));
        result = 31 * result + (deCuestionario ? 1 : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (tipoPreg != null ? tipoPreg.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "preguntaExByPreguntaExId")
    public Collection<EvaluacionPreguntasEntity> getEvaluacionPreguntasByPreguntaExId() {
        return evaluacionPreguntasByPreguntaExId;
    }

    public void setEvaluacionPreguntasByPreguntaExId(Collection<EvaluacionPreguntasEntity> evaluacionPreguntasByPreguntaExId) {
        this.evaluacionPreguntasByPreguntaExId = evaluacionPreguntasByPreguntaExId;
    }

    @OneToOne(mappedBy = "preguntaExByPasociacionId")
    public PasociacionEntity getPasociacionByPreguntaExId() {
        return pasociacionByPreguntaExId;
    }

    public void setPasociacionByPreguntaExId(PasociacionEntity pasociacionByPreguntaExId) {
        this.pasociacionByPreguntaExId = pasociacionByPreguntaExId;
    }

    @OneToOne(mappedBy = "preguntaExByPcompletarFraseId")
    public PcompletarFraseEntity getPcompletarFraseByPreguntaExId() {
        return pcompletarFraseByPreguntaExId;
    }

    public void setPcompletarFraseByPreguntaExId(PcompletarFraseEntity pcompletarFraseByPreguntaExId) {
        this.pcompletarFraseByPreguntaExId = pcompletarFraseByPreguntaExId;
    }

    @OneToOne(mappedBy = "preguntaExByPformatoTablaId")
    public PformatoTablaEntity getPformatoTablaByPreguntaExId() {
        return pformatoTablaByPreguntaExId;
    }

    public void setPformatoTablaByPreguntaExId(PformatoTablaEntity pformatoTablaByPreguntaExId) {
        this.pformatoTablaByPreguntaExId = pformatoTablaByPreguntaExId;
    }

    @OneToOne(mappedBy = "preguntaExByPnumericaCalculadaId")
    public PnumericaCalculadaEntity getPnumericaCalculadaByPreguntaExId() {
        return pnumericaCalculadaByPreguntaExId;
    }

    public void setPnumericaCalculadaByPreguntaExId(PnumericaCalculadaEntity pnumericaCalculadaByPreguntaExId) {
        this.pnumericaCalculadaByPreguntaExId = pnumericaCalculadaByPreguntaExId;
    }

    @OneToOne(mappedBy = "preguntaExByPopcionMultipleId")
    public PopcionMultipleEntity getPopcionMultipleByPreguntaExId() {
        return popcionMultipleByPreguntaExId;
    }

    public void setPopcionMultipleByPreguntaExId(PopcionMultipleEntity popcionMultipleByPreguntaExId) {
        this.popcionMultipleByPreguntaExId = popcionMultipleByPreguntaExId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @OneToMany(mappedBy = "preguntaExByPreguntaExId")
    public Collection<PreguntaExAdjuntosEntity> getPreguntaExAdjuntosByPreguntaExId() {
        return preguntaExAdjuntosByPreguntaExId;
    }

    public void setPreguntaExAdjuntosByPreguntaExId(Collection<PreguntaExAdjuntosEntity> preguntaExAdjuntosByPreguntaExId) {
        this.preguntaExAdjuntosByPreguntaExId = preguntaExAdjuntosByPreguntaExId;
    }

    @OneToMany(mappedBy = "preguntaExByPreguntaExId")
    public Collection<PreguntaExPuntuacionEntity> getPreguntaExPuntuacionsByPreguntaExId() {
        return preguntaExPuntuacionsByPreguntaExId;
    }

    public void setPreguntaExPuntuacionsByPreguntaExId(Collection<PreguntaExPuntuacionEntity> preguntaExPuntuacionsByPreguntaExId) {
        this.preguntaExPuntuacionsByPreguntaExId = preguntaExPuntuacionsByPreguntaExId;
    }

    @OneToOne(mappedBy = "preguntaExByPrespuestaAbiertaId")
    public PrespuestaAbiertaEntity getPrespuestaAbiertaByPreguntaExId() {
        return prespuestaAbiertaByPreguntaExId;
    }

    public void setPrespuestaAbiertaByPreguntaExId(PrespuestaAbiertaEntity prespuestaAbiertaByPreguntaExId) {
        this.prespuestaAbiertaByPreguntaExId = prespuestaAbiertaByPreguntaExId;
    }

    @OneToOne(mappedBy = "preguntaExByPrespuestaCerradaId")
    public PrespuestaCerradaEntity getPrespuestaCerradaByPreguntaExId() {
        return prespuestaCerradaByPreguntaExId;
    }

    public void setPrespuestaCerradaByPreguntaExId(PrespuestaCerradaEntity prespuestaCerradaByPreguntaExId) {
        this.prespuestaCerradaByPreguntaExId = prespuestaCerradaByPreguntaExId;
    }

    @OneToOne(mappedBy = "preguntaExByPverdaderoFalsoId")
    public PverdaderoFalsoEntity getPverdaderoFalsoByPreguntaExId() {
        return pverdaderoFalsoByPreguntaExId;
    }

    public void setPverdaderoFalsoByPreguntaExId(PverdaderoFalsoEntity pverdaderoFalsoByPreguntaExId) {
        this.pverdaderoFalsoByPreguntaExId = pverdaderoFalsoByPreguntaExId;
    }

    @OneToMany(mappedBy = "preguntaExByPregId")
    public Collection<RespuestaExEntity> getRespuestaExesByPreguntaExId() {
        return respuestaExesByPreguntaExId;
    }

    public void setRespuestaExesByPreguntaExId(Collection<RespuestaExEntity> respuestaExesByPreguntaExId) {
        this.respuestaExesByPreguntaExId = respuestaExesByPreguntaExId;
    }
}
