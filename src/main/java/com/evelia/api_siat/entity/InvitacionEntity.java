package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "INVITACION", schema = "datosEveliaMinimo", catalog = "")
public class InvitacionEntity {
    private long invitacionId;
    private Long involucradoId;
    private TextoEntity textoByInvitacionId;
    private PersonaEntity personaByInvolucradoId;

    @Id
    @Column(name = "INVITACION_ID")
    public long getInvitacionId() {
        return invitacionId;
    }

    public void setInvitacionId(long invitacionId) {
        this.invitacionId = invitacionId;
    }

    @Basic
    @Column(name = "INVOLUCRADO_ID")
    public Long getInvolucradoId() {
        return involucradoId;
    }

    public void setInvolucradoId(Long involucradoId) {
        this.involucradoId = involucradoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvitacionEntity that = (InvitacionEntity) o;

        if (invitacionId != that.invitacionId) return false;
        if (involucradoId != null ? !involucradoId.equals(that.involucradoId) : that.involucradoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (invitacionId ^ (invitacionId >>> 32));
        result = 31 * result + (involucradoId != null ? involucradoId.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "INVITACION_ID", referencedColumnName = "TEXTO_ID", nullable = false, insertable=false, updatable=false)
    public TextoEntity getTextoByInvitacionId() {
        return textoByInvitacionId;
    }

    public void setTextoByInvitacionId(TextoEntity textoByInvitacionId) {
        this.textoByInvitacionId = textoByInvitacionId;
    }

    @ManyToOne
    @JoinColumn(name = "INVOLUCRADO_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByInvolucradoId() {
        return personaByInvolucradoId;
    }

    public void setPersonaByInvolucradoId(PersonaEntity personaByInvolucradoId) {
        this.personaByInvolucradoId = personaByInvolucradoId;
    }
}
