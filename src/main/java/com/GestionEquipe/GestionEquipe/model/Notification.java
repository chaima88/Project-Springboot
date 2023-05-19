package com.GestionEquipe.GestionEquipe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;



@Entity
public class Notification {
    public Integer getIdNotif() {
        return idNotif;
    }

    public Notification() {
    }

    public void setIdNotif(Integer idNotif) {
        this.idNotif = idNotif;
    }

    public Collection<MembreEquipe> getMembr() {
        return membr;
    }

    public void setMembr(Collection<MembreEquipe> membr) {
        this.membr = membr;
    }

    public ChefProjet getChefProjet() {
        return chefProjet;
    }

    public void setChefProjet(ChefProjet chefProjet) {
        this.chefProjet = chefProjet;
    }

    public String getNomNot() {
        return nomNot;
    }

    public void setNomNot(String nomNot) {
        this.nomNot = nomNot;
    }

    public String getTypeNot() {
        return typeNot;
    }

    public void setTypeNot(String typeNot) {
        this.typeNot = typeNot;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotif;

    public Notification(Integer idNotif, Collection<MembreEquipe> membr, ChefProjet chefProjet, String nomNot, String typeNot) {
        this.idNotif = idNotif;
        this.membr = membr;
        this.chefProjet = chefProjet;
        this.nomNot = nomNot;
        this.typeNot = typeNot;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<MembreEquipe> membr=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "idChef")
    ChefProjet chefProjet;
    @Column
    private String nomNot;
    @Column
    private String typeNot;
}


