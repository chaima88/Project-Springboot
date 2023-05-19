package com.GestionEquipe.GestionEquipe.ServicesImpl;


import com.GestionEquipe.GestionEquipe.Repository.CalendrierRepository;
import com.GestionEquipe.GestionEquipe.Services.ICalendrierService;

import com.GestionEquipe.GestionEquipe.model.Calendrier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CalendrierService implements ICalendrierService {
    @Autowired
    private CalendrierRepository calendrierRepository;

    @Override
    public Calendrier saveCalendar(Calendrier calendrier) {
        Calendrier calendrierToReturn = calendrierRepository.save(calendrier);
        return calendrierToReturn;
    }

    @Override
    public Calendrier updateCalendar(Calendrier calendrier, Integer id) {
        Calendrier calendarDB
                = calendrierRepository.findById(id).get();
        if (Objects.nonNull(calendrier.getTitre())
                && !"".equalsIgnoreCase(calendrier.getTitre())) {
            calendarDB.setTitre(
                    calendrier.getTitre());
        }
        if (Objects.nonNull(calendrier.getDescription())
                && !"".equalsIgnoreCase(calendrier.getDescription())) {
            calendarDB.setDescription(
                    calendrier.getDescription());
        }

        if (Objects.nonNull(calendrier.getEndDateTime())
                && !"".equalsIgnoreCase(String.valueOf(calendrier.getEndDateTime()))) {
            calendarDB.setEndDateTime(
                    calendrier.getEndDateTime());
        }
        if (Objects.nonNull(calendrier.getStartDateTime())
                && !"".equalsIgnoreCase(String.valueOf(calendrier.getStartDateTime()))) {
            calendarDB.setStartDateTime(
                    calendrier.getStartDateTime());
        }

        return calendrierRepository.save(calendarDB);

    }


    // Read all raws

    @Override public List<Calendrier> fetchCalendarList()
    {
        return (List<Calendrier>)
                calendrierRepository.findAll();
    }

    //read raw by id
    @Override

    public Calendrier getCalendarById(Integer id)
    {
        return calendrierRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deleteCalendarById(Integer id)
    {
        calendrierRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteCalendar(Calendrier calendrier)
    {
        calendrierRepository.deleteAll();
    }

}
