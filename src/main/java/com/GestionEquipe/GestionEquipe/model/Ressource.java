package com.GestionEquipe.GestionEquipe.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
public class Ressource implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRess;
    @Column
    private String nomRess;

    public Integer getIdRess() {
        return idRess;
    }

    public void setIdRess(Integer idRess) {
        this.idRess = idRess;
    }

    public String getNomRess() {
        return nomRess;
    }

    public void setNomRess(String nomRess) {
        this.nomRess = nomRess;
    }

    public String getTypeRess() {
        return typeRess;
    }

    public void setTypeRess(String typeRess) {
        this.typeRess = typeRess;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    @Column
    private String typeRess;
    @ManyToOne
    @JoinColumn(name = "idProjet")
    Projet projet;


    public Ressource(Integer idRess, String nomRess, String typeRess, Projet projet) {
        this.idRess = idRess;
        this.nomRess = nomRess;
        this.typeRess = typeRess;
        this.projet = projet;
    }

    public Ressource() {
    }
}