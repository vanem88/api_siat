package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "FORO_GRUPAL", schema = "datosEveliaMinimo", catalog = "")
public class ForoGrupalEntity {
    private long foroGrupalId;
    private Long foroId;
    private Long grupoId;
    private Long id;
    private Long eventoFinalizacionId;
    private ForoEntity foroByForoId;
    private GrupoEntity grupoByGrupoId;
    private TextoEntity textoByEventoFinalizacionId;

    @Id
    @Column(name = "FORO_GRUPAL_ID")
    public long getForoGrupalId() {
        return foroGrupalId;
    }

    public void setForoGrupalId(long foroGrupalId) {
        this.foroGrupalId = foroGrupalId;
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
    @Column(name = "GRUPO_ID")
    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
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
    @Column(name = "EVENTO_FINALIZACION_ID")
    public Long getEventoFinalizacionId() {
        return eventoFinalizacionId;
    }

    public void setEventoFinalizacionId(Long eventoFinalizacionId) {
        this.eventoFinalizacionId = eventoFinalizacionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForoGrupalEntity that = (ForoGrupalEntity) o;

        if (foroGrupalId != that.foroGrupalId) return false;
        if (foroId != null ? !foroId.equals(that.foroId) : that.foroId != null) return false;
        if (grupoId != null ? !grupoId.equals(that.grupoId) : that.grupoId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (eventoFinalizacionId != null ? !eventoFinalizacionId.equals(that.eventoFinalizacionId) : that.eventoFinalizacionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (foroGrupalId ^ (foroGrupalId >>> 32));
        result = 31 * result + (foroId != null ? foroId.hashCode() : 0);
        result = 31 * result + (grupoId != null ? grupoId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (eventoFinalizacionId != null ? eventoFinalizacionId.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "GRUPO_ID", referencedColumnName = "GRUPO_ID", insertable=false, updatable=false)
    public GrupoEntity getGrupoByGrupoId() {
        return grupoByGrupoId;
    }

    public void setGrupoByGrupoId(GrupoEntity grupoByGrupoId) {
        this.grupoByGrupoId = grupoByGrupoId;
    }

    @ManyToOne
    @JoinColumn(name = "EVENTO_FINALIZACION_ID", referencedColumnName = "TEXTO_ID", insertable=false, updatable=false)
    public TextoEntity getTextoByEventoFinalizacionId() {
        return textoByEventoFinalizacionId;
    }

    public void setTextoByEventoFinalizacionId(TextoEntity textoByEventoFinalizacionId) {
        this.textoByEventoFinalizacionId = textoByEventoFinalizacionId;
    }
}
