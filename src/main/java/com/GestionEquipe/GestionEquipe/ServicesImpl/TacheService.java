
package com.GestionEquipe.GestionEquipe.ServicesImpl;

import com.GestionEquipe.GestionEquipe.Repository.TacheRepository;
import com.GestionEquipe.GestionEquipe.Services.ITacheService;
import com.GestionEquipe.GestionEquipe.model.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TacheService implements ITacheService {
    @Autowired
    private TacheRepository tacheRepository;
    @Override
    public Tache saveT(Tache tache) {
        Tache tacheToReturn = tacheRepository.save(tache);
        return tacheToReturn;
    }
    @Override
    public Tache updateTask(Tache tache, Integer id) {
        Tache tacheDB
                = tacheRepository.findById(id).get();
        if (Objects.nonNull(tache.getDateDeb())
                && !"".equalsIgnoreCase(String.valueOf(tache.getDateDeb()))) {
            tacheDB.setDateDeb(
                    tache.getDateDeb());
        }
        if (Objects.nonNull(tache.getDateFin())
                && !"".equalsIgnoreCase(String.valueOf(tache.getDateFin()))) {
            tacheDB.setDateFin(
                    tache.getDateFin());
        }

        if (Objects.nonNull(tache.getTitreTache())
                && !"".equalsIgnoreCase(tache.getTitreTache())) {
            tacheDB.setTitreTache(
                    tache.getTitreTache());
        }
        if (Objects.nonNull(tache.getStatus())
                && !"".equalsIgnoreCase(tache.getStatus())) {
            tacheDB.setStatus(
                    tache.getStatus());
        }


        return tacheRepository.save(tacheDB);
    }
    // Read all raws

    @Override public List<Tache> fetchTaskList()
    {
        return (List<Tache>)
                tacheRepository.findAll();
    }

    //read raw by id
    @Override

    public Tache getTaskById(Integer id)
    {
        return tacheRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deleteTaskById(Integer id)
    {
        tacheRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteTask(Tache tache)
    {
        tacheRepository.deleteAll();
    }
}