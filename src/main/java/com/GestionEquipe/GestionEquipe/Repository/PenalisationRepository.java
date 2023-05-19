package com.GestionEquipe.GestionEquipe.Repository;

import com.GestionEquipe.GestionEquipe.model.Notification;
import com.GestionEquipe.GestionEquipe.model.Penalisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenalisationRepository extends JpaRepository<Penalisation, Integer> {
}
