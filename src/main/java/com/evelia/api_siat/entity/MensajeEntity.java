package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "MENSAJE", schema = "datosEveliaMinimo", catalog = "")
public class MensajeEntity {
    private long mensajeId;
    private Long archivoId;
    private Long chatId;
    private byte[] contenido;
    private Timestamp fecha;
    private Long foroId;
    private Long id;
    private Long personaId;
    private String titulo;
    private Long msjPadreId;
    private Boolean valoracion;
    private Boolean eliminado;
    private Boolean borrado;
    private String tipoMensaje;
    private byte[] para;
    private byte[] conCopia;
    private byte[] conCopiaOculta;
    private byte[] nombreAdjuntos;
    private Collection<DestinatarioEntity> destinatariosByMensajeId;
    private ArchivoEntity archivoByArchivoId;
    private ChatEntity chatByChatId;
    private ForoEntity foroByForoId;
    private PersonaEntity personaByPersonaId;
    private MensajeEntity mensajeByMsjPadreId;
    private Collection<MensajeEntity> mensajesByMensajeId;
    private Collection<MensajeAdjuntosEntity> mensajeAdjuntosByMensajeId;

    @Id
    @Column(name = "MENSAJE_ID")
    public long getMensajeId() {
        return mensajeId;
    }

    public void setMensajeId(long mensajeId) {
        this.mensajeId = mensajeId;
    }

    @Basic
    @Column(name = "ARCHIVO_ID")
    public Long getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(Long archivoId) {
        this.archivoId = archivoId;
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
    @Column(name = "CONTENIDO")
    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
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
    @Column(name = "FORO_ID")
    public Long getForoId() {
        return foroId;
    }

    public void setForoId(Long foroId) {
        this.foroId = foroId;
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
    @Column(name = "TITULO")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "MSJ_PADRE_ID")
    public Long getMsjPadreId() {
        return msjPadreId;
    }

    public void setMsjPadreId(Long msjPadreId) {
        this.msjPadreId = msjPadreId;
    }

    @Basic
    @Column(name = "VALORACION")
    public Boolean getValoracion() {
        return valoracion;
    }

    public void setValoracion(Boolean valoracion) {
        this.valoracion = valoracion;
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

    @Basic
    @Column(name = "TIPO_MENSAJE")
    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    @Basic
    @Column(name = "PARA")
    public byte[] getPara() {
        return para;
    }

    public void setPara(byte[] para) {
        this.para = para;
    }

    @Basic
    @Column(name = "CON_COPIA")
    public byte[] getConCopia() {
        return conCopia;
    }

    public void setConCopia(byte[] conCopia) {
        this.conCopia = conCopia;
    }

    @Basic
    @Column(name = "CON_COPIA_OCULTA")
    public byte[] getConCopiaOculta() {
        return conCopiaOculta;
    }

    public void setConCopiaOculta(byte[] conCopiaOculta) {
        this.conCopiaOculta = conCopiaOculta;
    }

    @Basic
    @Column(name = "NOMBRE_ADJUNTOS")
    public byte[] getNombreAdjuntos() {
        return nombreAdjuntos;
    }

    public void setNombreAdjuntos(byte[] nombreAdjuntos) {
        this.nombreAdjuntos = nombreAdjuntos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MensajeEntity that = (MensajeEntity) o;

        if (mensajeId != that.mensajeId) return false;
        if (archivoId != null ? !archivoId.equals(that.archivoId) : that.archivoId != null) return false;
        if (chatId != null ? !chatId.equals(that.chatId) : that.chatId != null) return false;
        if (!Arrays.equals(contenido, that.contenido)) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (foroId != null ? !foroId.equals(that.foroId) : that.foroId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (msjPadreId != null ? !msjPadreId.equals(that.msjPadreId) : that.msjPadreId != null) return false;
        if (valoracion != null ? !valoracion.equals(that.valoracion) : that.valoracion != null) return false;
        if (eliminado != null ? !eliminado.equals(that.eliminado) : that.eliminado != null) return false;
        if (borrado != null ? !borrado.equals(that.borrado) : that.borrado != null) return false;
        if (tipoMensaje != null ? !tipoMensaje.equals(that.tipoMensaje) : that.tipoMensaje != null) return false;
        if (!Arrays.equals(para, that.para)) return false;
        if (!Arrays.equals(conCopia, that.conCopia)) return false;
        if (!Arrays.equals(conCopiaOculta, that.conCopiaOculta)) return false;
        if (!Arrays.equals(nombreAdjuntos, that.nombreAdjuntos)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (mensajeId ^ (mensajeId >>> 32));
        result = 31 * result + (archivoId != null ? archivoId.hashCode() : 0);
        result = 31 * result + (chatId != null ? chatId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(contenido);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (foroId != null ? foroId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (msjPadreId != null ? msjPadreId.hashCode() : 0);
        result = 31 * result + (valoracion != null ? valoracion.hashCode() : 0);
        result = 31 * result + (eliminado != null ? eliminado.hashCode() : 0);
        result = 31 * result + (borrado != null ? borrado.hashCode() : 0);
        result = 31 * result + (tipoMensaje != null ? tipoMensaje.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(para);
        result = 31 * result + Arrays.hashCode(conCopia);
        result = 31 * result + Arrays.hashCode(conCopiaOculta);
        result = 31 * result + Arrays.hashCode(nombreAdjuntos);
        return result;
    }

    @OneToMany(mappedBy = "mensajeByMensajeId")
    public Collection<DestinatarioEntity> getDestinatariosByMensajeId() {
        return destinatariosByMensajeId;
    }

    public void setDestinatariosByMensajeId(Collection<DestinatarioEntity> destinatariosByMensajeId) {
        this.destinatariosByMensajeId = destinatariosByMensajeId;
    }

    @ManyToOne
    @JoinColumn(name = "ARCHIVO_ID", referencedColumnName = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoId() {
        return archivoByArchivoId;
    }

    public void setArchivoByArchivoId(ArchivoEntity archivoByArchivoId) {
        this.archivoByArchivoId = archivoByArchivoId;
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
    @JoinColumn(name = "FORO_ID", referencedColumnName = "FORO_ID", insertable=false, updatable=false)
    public ForoEntity getForoByForoId() {
        return foroByForoId;
    }

    public void setForoByForoId(ForoEntity foroByForoId) {
        this.foroByForoId = foroByForoId;
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
    @JoinColumn(name = "MSJ_PADRE_ID", referencedColumnName = "MENSAJE_ID", insertable=false, updatable=false)
    public MensajeEntity getMensajeByMsjPadreId() {
        return mensajeByMsjPadreId;
    }

    public void setMensajeByMsjPadreId(MensajeEntity mensajeByMsjPadreId) {
        this.mensajeByMsjPadreId = mensajeByMsjPadreId;
    }

    @OneToMany(mappedBy = "mensajeByMsjPadreId")
    public Collection<MensajeEntity> getMensajesByMensajeId() {
        return mensajesByMensajeId;
    }

    public void setMensajesByMensajeId(Collection<MensajeEntity> mensajesByMensajeId) {
        this.mensajesByMensajeId = mensajesByMensajeId;
    }

    @OneToMany(mappedBy = "mensajeByMensajeId")
    public Collection<MensajeAdjuntosEntity> getMensajeAdjuntosByMensajeId() {
        return mensajeAdjuntosByMensajeId;
    }

    public void setMensajeAdjuntosByMensajeId(Collection<MensajeAdjuntosEntity> mensajeAdjuntosByMensajeId) {
        this.mensajeAdjuntosByMensajeId = mensajeAdjuntosByMensajeId;
    }
}
