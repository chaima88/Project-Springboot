package com.GestionEquipe.GestionEquipe.Services;

import com.GestionEquipe.GestionEquipe.model.Calendrier;
import com.GestionEquipe.GestionEquipe.model.Utilisateur;

import java.util.List;

public interface ICalendrierService {


    public Calendrier saveCalendar(Calendrier calendrier);
    public Calendrier updateCalendar(Calendrier calendrier, Integer id);
    // Read operation
    public List<Calendrier> fetchCalendarList();
    public Calendrier getCalendarById(Integer id);
    // Delete operation by id
    public void deleteCalendarById(Integer id);
    public void deleteCalendar(Calendrier calendrier);



}


