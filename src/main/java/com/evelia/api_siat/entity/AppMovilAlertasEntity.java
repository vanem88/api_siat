package com.evelia.api_siat.entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "APP_MOVIL_ALERTAS", schema = "datosEveliaMinimo", catalog = "")
public class AppMovilAlertasEntity {
   
	private long alertaId;
	private Long aulaId;
	private Long comisionId;
	private String tipoElemento;
	private Long referenciaElementoId;
	private String textoAlerta;
	private Timestamp fecha;
    private Long personaId;  
    
    private AulaEntity aulaByaulaId;
    private ComisionEntity comisionBycomisionId;
    //private TextoEntity referenciaElementoByreferenciaElementoId;
    private PersonaEntity personaByPersonaId;
    
    @Id
    @Column(name = "ALERTA_ID")
    public long getAlertaId() {
        return alertaId;
    }

    public void setAlertaId(long alertaId) {
        this.alertaId = alertaId;
    }
    
    @Basic
    @Column(name = "AULA_ID")
    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }
    
    @Basic
    @Column(name = "COMISION_ID")
    public Long getComisionId() {
        return comisionId;
    }

    public void setComisionId(Long comisionId) {
        this.comisionId = comisionId;
    }
    
    @Basic
    @Column(name = "TIPO_ELEMENTO")
    public String getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(String tipoElemento) {
        this.tipoElemento = tipoElemento;
    }
    
    @Basic
    @Column(name = "REFERENCIA_ELEMENTO_ID")
    public Long getReferenciaElementoId() {
        return referenciaElementoId;
    }

    public void setReferenciaElementoId(Long referenciaElementoId) {
        this.referenciaElementoId = referenciaElementoId;
    }
    
    @Basic
    @Column(name = "TEXTO_ALERTA")
    public String getTextoAlerta() {
        return textoAlerta;
    }

    public void setTextoAlerta(String textoAlerta) {
        this.textoAlerta = textoAlerta;
    }
    
    @Basic
    @Column(name = "FECHA")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
    @Basic
    @Column(name = "PERSONA_ID")
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }
      

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppMovilAlertasEntity that = (AppMovilAlertasEntity) o;

        if (alertaId != that.alertaId) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (comisionId != null ? !comisionId.equals(that.comisionId) : that.comisionId != null) return false;
        if (tipoElemento != null ? !tipoElemento.equals(that.tipoElemento) : that.tipoElemento != null)return false;
        if (referenciaElementoId != null ? !referenciaElementoId.equals(that.referenciaElementoId) : that.referenciaElementoId != null) return false;
        if (textoAlerta != null ? !textoAlerta.equals(that.textoAlerta) : that.textoAlerta != null)return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
       
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (alertaId ^ (alertaId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (comisionId != null ? comisionId.hashCode() : 0);
        result = 31 * result + (tipoElemento != null ? tipoElemento.hashCode() : 0);
        result = 31 * result + (referenciaElementoId != null ? referenciaElementoId.hashCode() : 0);
        result = 31 * result + (textoAlerta != null ? textoAlerta.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result;
    }
    
    @ManyToOne
    @JoinColumn(name = "AULA_ID", referencedColumnName = "AULA_ID", insertable=false, updatable=false)
    public AulaEntity getAulaByaulaId() {
        return aulaByaulaId;
    }

    public void setAulaByaulaId(AulaEntity aulaByaulaId) {
        this.aulaByaulaId = aulaByaulaId;
    }
    
    @ManyToOne
    @JoinColumn(name = "COMISION_ID", referencedColumnName = "COMISION_ID", insertable=false, updatable=false)
    public ComisionEntity getComisionBycomisionId() {
        return comisionBycomisionId;
    }

    public void setComisionBycomisionId(ComisionEntity comisionBycomisionId) {
        this.comisionBycomisionId = comisionBycomisionId;
    }
    
  /*  @ManyToOne
    @JoinColumn(name = "REFERENCIA_ELEMENTO_ID", referencedColumnName = "TEXTO_ID", nullable = false,insertable=false, updatable=false)
    public TextoEntity getReferenciaElementoByreferenciaElementoId() {
        return referenciaElementoByreferenciaElementoId;
    }

    public void setReferenciaElementoByreferenciaElementoId(TextoEntity referenciaElementoByreferenciaElementoId) {
        this.referenciaElementoByreferenciaElementoId = referenciaElementoByreferenciaElementoId;
    }*/
    
    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
   
    

  
}
