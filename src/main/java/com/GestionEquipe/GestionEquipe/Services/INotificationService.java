package com.GestionEquipe.GestionEquipe.Services;


import com.GestionEquipe.GestionEquipe.model.Notification;

import java.util.List;

public interface INotificationService {
    public Notification saveNot(Notification notification);
    public Notification updateNot(Notification notification, Integer id);
    // Read operation
    public List<Notification> fetchNotList();
    public Notification getNotById(Integer id);
    // Delete operation by id
    public void deleteNotById(Integer id);
    public void deleteNot(Notification notification);



}
