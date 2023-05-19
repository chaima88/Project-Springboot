package com.GestionEquipe.GestionEquipe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;


@Entity
public class Recompense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecomp;

    public Recompense(Integer idRecomp, Collection<MembreEquipe> memb, ChefProjet chefProjet, String nomRecomp, String typeRecomp) {
        this.idRecomp = idRecomp;
        this.memb = memb;
        this.chefProjet = chefProjet;
        this.nomRecomp = nomRecomp;
        this.typeRecomp = typeRecomp;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<MembreEquipe> memb=new ArrayList<>();

    public Recompense() {
    }

    public Integer getIdRecomp() {
        return idRecomp;
    }

    public void setIdRecomp(Integer idRecomp) {
        this.idRecomp = idRecomp;
    }

    public Collection<MembreEquipe> getMemb() {
        return memb;
    }

    public void setMemb(Collection<MembreEquipe> memb) {
        this.memb = memb;
    }

    public ChefProjet getChefProjet() {
        return chefProjet;
    }

    public void setChefProjet(ChefProjet chefProjet) {
        this.chefProjet = chefProjet;
    }

    public String getNomRecomp() {
        return nomRecomp;
    }

    public void setNomRecomp(String nomRecomp) {
        this.nomRecomp = nomRecomp;
    }

    public String getTypeRecomp() {
        return typeRecomp;
    }

    public void setTypeRecomp(String typeRecomp) {
        this.typeRecomp = typeRecomp;
    }

    @ManyToOne
    @JoinColumn(name = "idChef")
    ChefProjet chefProjet;
    @Column
    private String nomRecomp;
    @Column
    private String typeRecomp;
}
