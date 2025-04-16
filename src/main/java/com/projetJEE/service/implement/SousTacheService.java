
package com.projetJEE.ServicesImpl;
import com.projetJEE.Repository.SousTacheRepository;
import com.projetJEE.Services.ISousTacheService;
import com.projetJEE.model.SousTache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SousTacheService implements ISousTacheService {
    @Autowired
    private SousTacheRepository soustacheRepository;
    @Override
    public SousTache saveSousTask(SousTache sousTache) {
        SousTache soustacheToReturn = soustacheRepository.save(sousTache);
        return soustacheToReturn;
    }
    @Override
    public SousTache updateSousTask(SousTache sousTache, Integer id) {
        SousTache soustacheDB
                = soustacheRepository.findById(id).get();


        if (Objects.nonNull(sousTache.getDescriptSTache())
                && !"".equalsIgnoreCase(sousTache.getDescriptSTache())) {
            soustacheDB.setDescriptSTache(
                    sousTache.getDescriptSTache());
        }
        if (Objects.nonNull(sousTache.getEtatSTache())
                && !"".equalsIgnoreCase(sousTache.getEtatSTache())) {
            soustacheDB.setEtatSTache(
                    sousTache.getEtatSTache());
        }

        if (Objects.nonNull(sousTache.getTitreSTache())
                && !"".equalsIgnoreCase(sousTache.getTitreSTache())) {
            soustacheDB.setTitreSTache(
                    sousTache.getTitreSTache());
        }
        if (Objects.nonNull(sousTache.getTauxAvancement())
                && !"".equalsIgnoreCase(String.valueOf(sousTache.getTauxAvancement()))) {
            soustacheDB.setTauxAvancement(
                    sousTache.getTauxAvancement());
        }
        if (Objects.nonNull(sousTache.getDateDebSTache())
                && !"".equalsIgnoreCase(String.valueOf(sousTache.getDateDebSTache()))) {
            soustacheDB.setDateDebSTache(
                    sousTache.getDateDebSTache());
        }
        if (Objects.nonNull(sousTache.getEcheance())
                && !"".equalsIgnoreCase(String.valueOf(sousTache.getEcheance()))) {
            soustacheDB.setEcheance(
                    sousTache.getEcheance());
        }





        return soustacheRepository.save(soustacheDB);
    }
    // Read all raws

    @Override public List<SousTache> fetchSousTaskList()
    {
        return (List<SousTache>)
                soustacheRepository.findAll();
    }

    //read raw by id
    @Override

    public SousTache getSousTaskById(Integer id)
    {
        return soustacheRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deleteSousTaskById(Integer id)
    {
        soustacheRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteSousTask(SousTache sousTache)
    {
        soustacheRepository.deleteAll();
    }

    @Override
    public List<SousTache> fetchSousTaskListByTache(Integer idTache) {
        return soustacheRepository.findByTache_idTache(idTache);
    }
}