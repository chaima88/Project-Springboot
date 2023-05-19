package com.GestionEquipe.GestionEquipe.model;

import jakarta.persistence.*;

import java.util.Date;



@Entity
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRap;
    @Column
    private Date dateCreat;
    @Column
    private String description;
    @OneToOne(mappedBy = "rapport")
    private Tache tache;

    public Integer getIdRapport() {
        return idRap;
    }

    public void setIdRap(Integer idRap) {
        this.idRap = idRap;
    }

    public Rapport(Integer idRapport, Date dateCreat, String description, Tache tache) {
        this.idRap = idRap;
        this.dateCreat = dateCreat;
        this.description = description;
        this.tache = tache;
    }

    public Date getDateCreat() {
        return dateCreat;
    }

    public void setDateCreat(Date dateCreat) {
        this.dateCreat = dateCreat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Rapport() {
    }
}