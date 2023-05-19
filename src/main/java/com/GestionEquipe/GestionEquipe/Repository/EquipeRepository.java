package com.GestionEquipe.GestionEquipe.Repository;

import com.GestionEquipe.GestionEquipe.model.Equipe;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Transactional

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
}
