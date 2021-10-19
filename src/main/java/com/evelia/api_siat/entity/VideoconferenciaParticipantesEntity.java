package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "VIDEOCONFERENCIA_PARTICIPANTES", schema = "datosEveliaMinimo", catalog = "")
public class VideoconferenciaParticipantesEntity {
    
    private long videoconferenciaId;
    private long personaId;
    private VideoconferenciaEntity videoconferenciaByVideoconferenciaId;
    private PersonaEntity personaByPersonaId;

    @Basic
    @Id
    @Column(name = "VIDEOCONFERENCIA_ID")
    public long getVideoconferenciaId() {
        return videoconferenciaId;
    }

    public void setVideoconferenciaId(long videoconferenciaId) {
        this.videoconferenciaId = videoconferenciaId;
    }

    @Basic
    @Column(name = "PERSONA_ID")
    public long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(long personaId) {
        this.personaId = personaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoconferenciaParticipantesEntity that = (VideoconferenciaParticipantesEntity) o;

        if (videoconferenciaId != that.videoconferenciaId) return false;
        if (personaId != that.personaId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (videoconferenciaId ^ (videoconferenciaId >>> 32));
        result = 31 * result + (int) (personaId ^ (personaId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "VIDEOCONFERENCIA_ID", referencedColumnName = "VIDEOCONFERENCIA_ID", nullable = false, insertable=false, updatable=false)
    public VideoconferenciaEntity getVideoconferenciaByVideoconferenciaId() {
        return videoconferenciaByVideoconferenciaId;
    }

    public void setVideoconferenciaByVideoconferenciaId(VideoconferenciaEntity videoconferenciaByVideoconferenciaId) {
        this.videoconferenciaByVideoconferenciaId = videoconferenciaByVideoconferenciaId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", nullable = false, insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
}
