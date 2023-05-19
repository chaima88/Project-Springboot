package com.GestionEquipe.GestionEquipe.Repository;

import com.GestionEquipe.GestionEquipe.model.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource,Integer> {
}
