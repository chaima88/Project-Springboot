package com.GestionEquipe.GestionEquipe.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Calendrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalendar;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String titre;

    public Integer getId() {
        return idCalendar;
    }

    public void setId(Integer id) {
        this.idCalendar = idCalendar;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }
    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Calendrier(Integer idCalendar, String titre, String description, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.idCalendar = idCalendar;
        this.titre = titre;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }


    public Calendrier() {
    }
}
