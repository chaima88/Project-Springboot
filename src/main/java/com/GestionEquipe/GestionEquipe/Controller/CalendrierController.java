package com.GestionEquipe.GestionEquipe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionEquipe.GestionEquipe.Services.ICalendrierService;
import com.GestionEquipe.GestionEquipe.model.Calendrier;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cal")
public class CalendrierController {

    @Autowired
    private ICalendrierService iCalendrierService;
    @PostMapping("/calendar")
    public Calendrier SaveCalendrier(@RequestBody Calendrier calendrier){
        Calendrier calendrierToReturn = iCalendrierService.saveCalendar(calendrier);
        return calendrierToReturn;
    }
    @PutMapping("/calendar/{id}")
    public Calendrier updateCalendrier(@RequestBody Calendrier calendrier,
                               @PathVariable("id") Integer id)
    {
        return iCalendrierService.updateCalendar(calendrier,id);
    }


    // Read raw by id

    @GetMapping("/calendar")

    public List<Calendrier> fetchCalendrierList()
    {
        return iCalendrierService.fetchCalendarList();
    }

    // Read All Raws
    @GetMapping("/calendar/{id}")

    public Calendrier getCalendrier(@PathVariable("id")
                            Integer id)
    {
        return iCalendrierService.getCalendarById(id);

    }
    // Delete raw by id
    @DeleteMapping("/calendar/{id}")

    public String deleteCalendrierById(@PathVariable("id")
                                   Integer id)
    {
        iCalendrierService.deleteCalendarById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/calendar")
    public String deleteCalendar(Calendrier calendrier)
    {
        iCalendrierService.deleteCalendar(calendrier);
        return "Deleted Successfully";
    }
}
