package com.GestionEquipe.GestionEquipe.Repository;

import com.GestionEquipe.GestionEquipe.model.Projet;
import com.GestionEquipe.GestionEquipe.model.SousTache;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Integer> {
    List<Projet> findByEquipe_idEquipe(Integer idEquipe);

}
