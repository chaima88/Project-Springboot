package com.GestionEquipe.GestionEquipe.Repository;


import com.GestionEquipe.GestionEquipe.model.SousTache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SousTacheRepository extends JpaRepository<SousTache, Integer> {

    List<SousTache> findByTache_idTache(Integer idTache);

}
