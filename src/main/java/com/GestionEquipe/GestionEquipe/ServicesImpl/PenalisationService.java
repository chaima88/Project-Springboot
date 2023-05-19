package com.GestionEquipe.GestionEquipe.ServicesImpl;
import com.GestionEquipe.GestionEquipe.Repository.PenalisationRepository;
import com.GestionEquipe.GestionEquipe.Services.IPenalisationService;
import com.GestionEquipe.GestionEquipe.model.Penalisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PenalisationService implements IPenalisationService {
    @Autowired
    private PenalisationRepository penalisationRepository;
    @Override
    public Penalisation savePen(Penalisation ressource) {
        Penalisation ressourceToReturn = penalisationRepository.save(ressource);
        return ressourceToReturn;
    }
    @Override
    public Penalisation updatePen(Penalisation penalisation, Integer id) {
        Penalisation penalisationDB
                = penalisationRepository.findById(id).get();


        if (Objects.nonNull(penalisation.getTypePena())
                && !"".equalsIgnoreCase(penalisation.getTypePena())) {
            penalisationDB.setTypePena(
                    penalisation.getTypePena());
        }
        if (Objects.nonNull(penalisation.getNomPena())
                && !"".equalsIgnoreCase(penalisation.getNomPena())) {
            penalisationDB.setNomPena(
                    penalisation.getNomPena());
        }
        return penalisationRepository.save(penalisationDB);
    }
    // Read all raws

    @Override public List<Penalisation> fetchPenList()
    {
        return (List<Penalisation>)
                penalisationRepository.findAll();
    }

    //read raw by id
    @Override

    public Penalisation getPenById(Integer id)
    {
        return penalisationRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deletePenById(Integer id)
    {
        penalisationRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deletePen(Penalisation penalisation)
    {
        penalisationRepository.deleteAll();
    }
}
