package com.GestionEquipe.GestionEquipe.Repository;

import com.GestionEquipe.GestionEquipe.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
