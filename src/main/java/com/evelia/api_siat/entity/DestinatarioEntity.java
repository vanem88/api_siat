package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "DESTINATARIO", schema = "datosEveliaMinimo", catalog = "")
public class DestinatarioEntity {
    private long destinatarioId;
    private long mensajeId;
    private long receptorId;
    private Long id;
    private Boolean leido;
    private Timestamp fecha;
    private Boolean eliminado;
    private Boolean borrado;
    private MensajeEntity mensajeByMensajeId;
    private PersonaEntity personaByReceptorId;

    @Id
    @Column(name = "DESTINATARIO_ID")
    public long getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(long destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    @Basic
    @Column(name = "MENSAJE_ID")
    public long getMensajeId() {
        return mensajeId;
    }

    public void setMensajeId(long mensajeId) {
        this.mensajeId = mensajeId;
    }

    @Basic
    @Column(name = "RECEPTOR_ID")
    public long getReceptorId() {
        return receptorId;
    }

    public void setReceptorId(long receptorId) {
        this.receptorId = receptorId;
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
    @Column(name = "LEIDO")
    public Boolean getLeido() {
        return leido;
    }

    public void setLeido(Boolean leido) {
        this.leido = leido;
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
    @Column(name = "ELIMINADO")
    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Basic
    @Column(name = "BORRADO")
    public Boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(Boolean borrado) {
        this.borrado = borrado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DestinatarioEntity that = (DestinatarioEntity) o;

        if (destinatarioId != that.destinatarioId) return false;
        if (mensajeId != that.mensajeId) return false;
        if (receptorId != that.receptorId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (leido != null ? !leido.equals(that.leido) : that.leido != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (eliminado != null ? !eliminado.equals(that.eliminado) : that.eliminado != null) return false;
        if (borrado != null ? !borrado.equals(that.borrado) : that.borrado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (destinatarioId ^ (destinatarioId >>> 32));
        result = 31 * result + (int) (mensajeId ^ (mensajeId >>> 32));
        result = 31 * result + (int) (receptorId ^ (receptorId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (leido != null ? leido.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (eliminado != null ? eliminado.hashCode() : 0);
        result = 31 * result + (borrado != null ? borrado.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MENSAJE_ID", referencedColumnName = "MENSAJE_ID", nullable = false, insertable=false, updatable=false)
    public MensajeEntity getMensajeByMensajeId() {
        return mensajeByMensajeId;
    }

    public void setMensajeByMensajeId(MensajeEntity mensajeByMensajeId) {
        this.mensajeByMensajeId = mensajeByMensajeId;
    }

    @ManyToOne
    @JoinColumn(name = "RECEPTOR_ID", referencedColumnName = "PERSONA_ID", nullable = false, insertable=false, updatable=false)
    public PersonaEntity getPersonaByReceptorId() {
        return personaByReceptorId;
    }

    public void setPersonaByReceptorId(PersonaEntity personaByReceptorId) {
        this.personaByReceptorId = personaByReceptorId;
    }
}
