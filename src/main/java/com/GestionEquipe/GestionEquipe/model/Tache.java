package com.GestionEquipe.GestionEquipe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.Collection;
import java.util.Date;

@Entity
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTache;
    @Column
    private Date dateDeb;
    @Column
    private Date dateFin;
    @ManyToOne
    @JoinColumn(name = "idProjet")
    Projet projet;
    @Column
    private String titreTache;
    @Column
    private String status;
    @OneToOne
    private Rapport rapport;

    @OneToMany(mappedBy = "tache")
    @JsonIgnore
    private Collection<SousTache> sousTaches;

    public Integer getIdTache() {
        return idTache;
    }

    public void setIdTache(Integer idTache) {
        this.idTache = idTache;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Rapport getRapport() {
        return rapport;
    }

    public void setRapport(Rapport rapport) {
        this.rapport = rapport;
    }

    public String getTitreTache() {
        return titreTache;
    }

    public void setTitreTache(String titreTache) {
        this.titreTache = titreTache;
    }

    public Collection<SousTache> getSousTaches() {
        return sousTaches;
    }

    public void setSousTaches(Collection<SousTache> sousTaches) {
        this.sousTaches = sousTaches;
    }

    public Tache(Integer idTache, Date dateDeb, Date dateFin,String status, Projet projet, String titreTache, Rapport rapport, Collection<SousTache> sousTaches) {
        this.idTache = idTache;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.projet = projet;
        this.titreTache = titreTache;
        this.status = status;
        this.rapport = rapport;
        this.sousTaches = sousTaches;
    }

    public Tache() {
    }
}
