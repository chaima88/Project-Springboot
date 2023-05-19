package com.GestionEquipe.GestionEquipe.Repository;

import com.GestionEquipe.GestionEquipe.model.ChefProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefProjetRepository extends JpaRepository<ChefProjet,Integer> {
}
