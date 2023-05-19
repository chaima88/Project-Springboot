package com.GestionEquipe.GestionEquipe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipe;
    @Column
    private String nomEqui;
    @Column
    private String descriptionEqui;
    @ManyToMany(mappedBy = "equipe",fetch = FetchType.EAGER)
    private Collection<ChefProjet> chefProjets=new ArrayList<>();
    @OneToOne
    private ChefProjet chefProjet;
//    @OneToOne
//    @JsonIgnore
//    private Discussion discussion;
    @OneToMany(mappedBy = "equipe")
    @JsonIgnore
    private List<MembreEquipe> membreEquipes;


    @OneToMany(mappedBy = "equipe")
    @JsonIgnore
    private Collection<Projet> projet ;

 
}
