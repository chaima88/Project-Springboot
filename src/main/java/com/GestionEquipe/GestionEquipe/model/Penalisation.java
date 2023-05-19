package com.GestionEquipe.GestionEquipe.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;


@Entity
public class Penalisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPenalisation;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<MembreEquipe> membree=new ArrayList<>();

    public Integer getIdPenalisation() {
        return idPenalisation;
    }

    public void setIdPenalisation(Integer idPenalisation) {
        this.idPenalisation = idPenalisation;
    }

    public Collection<MembreEquipe> getMembree() {
        return membree;
    }

    public void setMembree(Collection<MembreEquipe> membree) {
        this.membree = membree;
    }

    public ChefProjet getChefProjet() {
        return chefProjet;
    }

    public void setChefProjet(ChefProjet chefProjet) {
        this.chefProjet = chefProjet;
    }

    public String getNomPena() {
        return nomPena;
    }

    public void setNomPena(String nomPena) {
        this.nomPena = nomPena;
    }

    public Penalisation() {
    }

    public String getTypePena() {
        return typePena;
    }

    public void setTypePena(String typePena) {
        this.typePena = typePena;
    }

    public Penalisation(Integer idPenalisation, Collection<MembreEquipe> membree, ChefProjet chefProjet, String nomPena, String typePena) {
        this.idPenalisation = idPenalisation;
        this.membree = membree;
        this.chefProjet = chefProjet;
        this.nomPena = nomPena;
        this.typePena = typePena;
    }

    @ManyToOne
    @JoinColumn(name = "idChef")
    ChefProjet chefProjet;
    @Column
    private String nomPena;
    @Column
    private String typePena;

}
