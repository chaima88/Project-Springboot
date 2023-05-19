package com.GestionEquipe.GestionEquipe.model;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;




@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProjet;
    @Column
    private Date dateDebProj;
    @Column
    private Date dateFinProj;
    @Column
    private String etatProj;
    @Column
    private String descriptProj;
    @OneToMany(mappedBy = "projet")
    private Collection<Ressource> ressource;
    @Column
    private String nomProj;

    @ManyToOne
    @JoinColumn(name = "idAdmin")
    Administrateur administrateur;
    @ManyToOne
    @JoinColumn(name = "idEquipe")
    Equipe equipe;
    @ManyToOne
    @JoinColumn(name = "idChef")
    ChefProjet chefProjet;
    @OneToMany(mappedBy = "projet")
    private Collection<Tache> tache;

    public Integer getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Integer idProjet) {
        this.idProjet = idProjet;
    }

    public Date getDateDebProj() {
        return dateDebProj;
    }

    public void setDateDebProj(Date dateDebProj) {
        this.dateDebProj = dateDebProj;
    }

    public Date getDateFinProj() {
        return dateFinProj;
    }

    public void setDateFinProj(Date dateFinProj) {
        this.dateFinProj = dateFinProj;
    }

    public String getEtatProj() {
        return etatProj;
    }

    public void setEtatProj(String etatProj) {
        this.etatProj = etatProj;
    }

    public String getDescriptProj() {
        return descriptProj;
    }

    public void setDescriptProj(String descriptProj) {
        this.descriptProj = descriptProj;
    }

    public String getNomProj() {
        return nomProj;
    }

    public void setNomProj(String nomProj) {
        this.nomProj = nomProj;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public ChefProjet getChefProjet() {
        return chefProjet;
    }

    public void setChefProjet(ChefProjet chefProjet) {
        this.chefProjet = chefProjet;
    }

    public Collection<Tache> getTache() {
        return tache;
    }

    public void setTache(Collection<Tache> tache) {
        this.tache = tache;
    }

    public Collection<Ressource> getRessource() {
        return ressource;
    }

    public void setRessource(Collection<Ressource> ressource) {
        this.ressource = ressource;
    }



    public Projet() {
    }

    public Projet(Integer idProjet, Date dateDebProj, Date dateFinProj, String etatProj, String descriptProj, String nomProj, Administrateur administrateur, Equipe equipe, ChefProjet chefProjet, Collection<Tache> tache, Collection<Ressource> ressource) {
        this.idProjet = idProjet;
        this.dateDebProj = dateDebProj;
        this.dateFinProj = dateFinProj;
        this.etatProj = etatProj;
        this.descriptProj = descriptProj;
        this.nomProj = nomProj;
        this.administrateur = administrateur;
        this.equipe = equipe;
        this.chefProjet = chefProjet;
        this.tache = tache;
        this.ressource = ressource;
    }
}
