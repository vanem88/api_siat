package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CHAT", schema = "datosEveliaMinimo", catalog = "")
public class ChatEntity {
    private long chatId;
    private Long id;
    private String nombre;
    private Collection<AulaEntity> aulasByChatId;
    private Collection<MensajeEntity> mensajesByChatId;
    private Collection<SesionChatEntity> sesionChatsByChatId;

    @Id
    @Column(name = "CHAT_ID")
    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
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
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatEntity that = (ChatEntity) o;

        if (chatId != that.chatId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (chatId ^ (chatId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "chatByChatId")
    public Collection<AulaEntity> getAulasByChatId() {
        return aulasByChatId;
    }

    public void setAulasByChatId(Collection<AulaEntity> aulasByChatId) {
        this.aulasByChatId = aulasByChatId;
    }

    @OneToMany(mappedBy = "chatByChatId")
    public Collection<MensajeEntity> getMensajesByChatId() {
        return mensajesByChatId;
    }

    public void setMensajesByChatId(Collection<MensajeEntity> mensajesByChatId) {
        this.mensajesByChatId = mensajesByChatId;
    }

    @OneToMany(mappedBy = "chatByChatId")
    public Collection<SesionChatEntity> getSesionChatsByChatId() {
        return sesionChatsByChatId;
    }

    public void setSesionChatsByChatId(Collection<SesionChatEntity> sesionChatsByChatId) {
        this.sesionChatsByChatId = sesionChatsByChatId;
    }
}
