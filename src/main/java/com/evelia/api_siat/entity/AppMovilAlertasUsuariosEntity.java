package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "APP_MOVIL_ALERTAS_USUARIOS", schema = "datosEveliaMinimo", catalog = "")
public class AppMovilAlertasUsuariosEntity {
    private long alertaUsuariosId;
    private Long personaId;
    private Long alertaId;
    private PersonaEntity personaByPersonaId;
    private AppMovilAlertasEntity AppMovilAlertasEntityByalertaId;
    
  

    @Id
    @Column(name = "ALERTA_USUARIOS_ID")
    public long getAlertaUsuariosId() {
        return alertaUsuariosId;
    }

    public void setAlertaUsuariosId(long alertaUsuariosId) {
        this.alertaUsuariosId = alertaUsuariosId;
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
    @Column(name = "ALERTA_ID")
    public Long getAlertaId() {
        return alertaId;
    }

    public void setAlertaId(Long alertaId) {
        this.alertaId = alertaId;
    }

   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppMovilAlertasUsuariosEntity that = (AppMovilAlertasUsuariosEntity) o;

        if (alertaUsuariosId != that.alertaUsuariosId) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (alertaId != null ? !alertaId.equals(that.alertaId) : that.alertaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (alertaUsuariosId ^ (alertaUsuariosId >>> 32));
        result = 31 * result + (alertaId != null ? alertaId.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result;
    }
    
    
    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
    
    @ManyToOne
    @JoinColumn(name = "ALERTA_ID", referencedColumnName = "ALERTA_ID", insertable=false, updatable=false)
    public AppMovilAlertasEntity getAlertaByAlertaId() {
        return AppMovilAlertasEntityByalertaId;
    }

    public void setAlertaByAlertaId(AppMovilAlertasEntity AppMovilAlertasEntityByalertaId) {
        this.AppMovilAlertasEntityByalertaId = AppMovilAlertasEntityByalertaId;
    }


  
}
