package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "COMENTARIO", schema = "datosEveliaMinimo", catalog = "")
public class ComentarioEntity {
    private long comentarioId;
    private Long id;
    private Timestamp fecha;
    private byte[] contenido;
    private Long personaId;
    private Long archivoId;
    private Long textoPadreId;
    private Long comentPadreId;
    private boolean eliminado;
    private boolean principal;
    private PersonaEntity personaByPersonaId;
    private ArchivoEntity archivoByArchivoId;
    private TextoEntity textoByTextoPadreId;
    private ComentarioEntity comentarioByComentPadreId;
    private Collection<ComentarioEntity> comentariosByComentarioId;

    @Id
    @Column(name = "COMENTARIO_ID")
    public long getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(long comentarioId) {
        this.comentarioId = comentarioId;
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
    @Column(name = "FECHA")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
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
    @Column(name = "PERSONA_ID")
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
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
    @Column(name = "TEXTO_PADRE_ID")
    public Long getTextoPadreId() {
        return textoPadreId;
    }

    public void setTextoPadreId(Long textoPadreId) {
        this.textoPadreId = textoPadreId;
    }

    @Basic
    @Column(name = "COMENT_PADRE_ID")
    public Long getComentPadreId() {
        return comentPadreId;
    }

    public void setComentPadreId(Long comentPadreId) {
        this.comentPadreId = comentPadreId;
    }

    @Basic
    @Column(name = "ELIMINADO")
    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Basic
    @Column(name = "PRINCIPAL")
    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComentarioEntity that = (ComentarioEntity) o;

        if (comentarioId != that.comentarioId) return false;
        if (eliminado != that.eliminado) return false;
        if (principal != that.principal) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (!Arrays.equals(contenido, that.contenido)) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (archivoId != null ? !archivoId.equals(that.archivoId) : that.archivoId != null) return false;
        if (textoPadreId != null ? !textoPadreId.equals(that.textoPadreId) : that.textoPadreId != null) return false;
        if (comentPadreId != null ? !comentPadreId.equals(that.comentPadreId) : that.comentPadreId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (comentarioId ^ (comentarioId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(contenido);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (archivoId != null ? archivoId.hashCode() : 0);
        result = 31 * result + (textoPadreId != null ? textoPadreId.hashCode() : 0);
        result = 31 * result + (comentPadreId != null ? comentPadreId.hashCode() : 0);
        result = 31 * result + (eliminado ? 1 : 0);
        result = 31 * result + (principal ? 1 : 0);
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
    @JoinColumn(name = "ARCHIVO_ID", referencedColumnName = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoId() {
        return archivoByArchivoId;
    }

    public void setArchivoByArchivoId(ArchivoEntity archivoByArchivoId) {
        this.archivoByArchivoId = archivoByArchivoId;
    }

    @ManyToOne
    @JoinColumn(name = "TEXTO_PADRE_ID", referencedColumnName = "TEXTO_ID", insertable=false, updatable=false)
    public TextoEntity getTextoByTextoPadreId() {
        return textoByTextoPadreId;
    }

    public void setTextoByTextoPadreId(TextoEntity textoByTextoPadreId) {
        this.textoByTextoPadreId = textoByTextoPadreId;
    }

    @ManyToOne
    @JoinColumn(name = "COMENT_PADRE_ID", referencedColumnName = "COMENTARIO_ID", insertable=false, updatable=false)
    public ComentarioEntity getComentarioByComentPadreId() {
        return comentarioByComentPadreId;
    }

    public void setComentarioByComentPadreId(ComentarioEntity comentarioByComentPadreId) {
        this.comentarioByComentPadreId = comentarioByComentPadreId;
    }

    @OneToMany(mappedBy = "comentarioByComentPadreId")
    public Collection<ComentarioEntity> getComentariosByComentarioId() {
        return comentariosByComentarioId;
    }

    public void setComentariosByComentarioId(Collection<ComentarioEntity> comentariosByComentarioId) {
        this.comentariosByComentarioId = comentariosByComentarioId;
    }
}
