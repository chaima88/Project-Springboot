package com.projetJEE.Repository;

import com.projetJEE.model.ChefProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefProjetRepository extends JpaRepository<ChefProjet,Integer> {
}
