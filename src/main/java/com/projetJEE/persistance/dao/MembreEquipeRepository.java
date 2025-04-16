package com.projetJEE.Repository;

import com.projetJEE.model.MembreEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembreEquipeRepository extends JpaRepository<MembreEquipe,Integer> {
}
