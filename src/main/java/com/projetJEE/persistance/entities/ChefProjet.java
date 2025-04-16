package com.projetJEE.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Collection;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class ChefProjet extends Utilisateur {


    @OneToMany(mappedBy = "chefProjet")
    private Collection<Projet> projet;



    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Equipe> equipe=new ArrayList<>();


}
