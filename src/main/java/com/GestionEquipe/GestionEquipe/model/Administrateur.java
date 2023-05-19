package com.GestionEquipe.GestionEquipe.model;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Administrateur extends Utilisateur {

    @OneToMany(mappedBy = "administrateur")
    private Collection<Projet> projet;







}