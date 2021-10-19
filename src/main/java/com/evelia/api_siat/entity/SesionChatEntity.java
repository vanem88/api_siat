package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SESION_CHAT", schema = "datosEveliaMinimo", catalog = "")
public class SesionChatEntity {
    private long sesionChatId;
    private Long chatId;
    private Timestamp fin;
    private Long id;
    private Timestamp inicio;
    private Long personaId;
    private ChatEntity chatByChatId;
    private PersonaEntity personaByPersonaId;

    @Id
    @Column(name = "SESION_CHAT_ID")
    public long getSesionChatId() {
        return sesionChatId;
    }

    public void setSesionChatId(long sesionChatId) {
        this.sesionChatId = sesionChatId;
    }

    @Basic
    @Column(name = "CHAT_ID")
    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    @Basic
    @Column(name = "FIN")
    public Timestamp getFin() {
        return fin;
    }

    public void setFin(Timestamp fin) {
        this.fin = fin;
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
    @Column(name = "INICIO")
    public Timestamp getInicio() {
        return inicio;
    }

    public void setInicio(Timestamp inicio) {
        this.inicio = inicio;
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

        SesionChatEntity that = (SesionChatEntity) o;

        if (sesionChatId != that.sesionChatId) return false;
        if (chatId != null ? !chatId.equals(that.chatId) : that.chatId != null) return false;
        if (fin != null ? !fin.equals(that.fin) : that.fin != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (inicio != null ? !inicio.equals(that.inicio) : that.inicio != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (sesionChatId ^ (sesionChatId >>> 32));
        result = 31 * result + (chatId != null ? chatId.hashCode() : 0);
        result = 31 * result + (fin != null ? fin.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (inicio != null ? inicio.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CHAT_ID", referencedColumnName = "CHAT_ID", insertable=false, updatable=false)
    public ChatEntity getChatByChatId() {
        return chatByChatId;
    }

    public void setChatByChatId(ChatEntity chatByChatId) {
        this.chatByChatId = chatByChatId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
}
