package com.GestionEquipe.GestionEquipe.ServicesImpl;
import com.GestionEquipe.GestionEquipe.Repository.NotificationRepository;
import com.GestionEquipe.GestionEquipe.Services.INotificationService;
import com.GestionEquipe.GestionEquipe.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NotificationService implements INotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Override
    public Notification saveNot(Notification notification) {
        Notification notificationToReturn = notificationRepository.save(notification);
        return notificationToReturn;
    }
    @Override
    public Notification updateNot(Notification notification, Integer id) {
        Notification notificationDB
                = notificationRepository.findById(id).get();


        if (Objects.nonNull(notification.getTypeNot())
                && !"".equalsIgnoreCase(notification.getTypeNot())) {
            notificationDB.setTypeNot(
                    notification.getTypeNot());
        }
        if (Objects.nonNull(notification.getNomNot())
                && !"".equalsIgnoreCase(notification.getNomNot())) {
            notificationDB.setNomNot(
                    notification.getNomNot());
        }
        return notificationRepository.save(notificationDB);
    }
    // Read all raws

    @Override public List<Notification> fetchNotList()
    {
        return (List<Notification>)
                notificationRepository.findAll();
    }

    //read raw by id
    @Override

    public Notification getNotById(Integer id)
    {
        return notificationRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deleteNotById(Integer id)
    {
        notificationRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteNot(Notification notification)
    {
        notificationRepository.deleteAll();
    }
}
