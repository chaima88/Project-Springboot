package com.GestionEquipe.GestionEquipe.Controller;

import com.GestionEquipe.GestionEquipe.Services.INotificationService;
import com.GestionEquipe.GestionEquipe.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private INotificationService iNotificationService;
    @PostMapping("/save")
    public Notification SaveNotification(@RequestBody Notification notification){
        Notification notificationToReturn = iNotificationService.saveNot(notification);
        return notificationToReturn;
    }
    @PutMapping("/update/{id}")
    public Notification updateNotification(@RequestBody Notification notification,
                                 @PathVariable("id") Integer id)
    {
        return iNotificationService.updateNot(notification,id);
    }

    // Read raw by id

    @GetMapping("/getAll")

    public List<Notification> getNotificationList()
    {
        return iNotificationService.fetchNotList();
    }

    // Read All Raws
    @GetMapping("/getById/{id}")

    public Notification getNotificationById(@PathVariable("id")
                                  Integer id)
    {
        return iNotificationService.getNotById(id);

    }
    // Delete raw by id
    @DeleteMapping("/deleteById/{id}")

    public String deleteNotificationById(@PathVariable("id")
                                    Integer id)
    {
        iNotificationService.deleteNotById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/deleteAll")
    public String deleteNotification(Notification notification)
    {
        iNotificationService.deleteNot(notification);
        return "Deleted Successfully";
    }
}


