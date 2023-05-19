package com.GestionEquipe.GestionEquipe.ServicesImpl;
import com.GestionEquipe.GestionEquipe.Repository.RessourceRepository;
import com.GestionEquipe.GestionEquipe.Services.IRessourceService;
import com.GestionEquipe.GestionEquipe.model.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RessourceService implements IRessourceService {
    @Autowired
    private RessourceRepository ressourceRepository;
    @Override
    public Ressource saveRess(Ressource ressource) {
        Ressource ressourceToReturn = ressourceRepository.save(ressource);
        return ressourceToReturn;
    }
    @Override
    public Ressource updateRess(Ressource ressource, Integer id) {
        Ressource ressourceDB
                = ressourceRepository.findById(id).get();


        if (Objects.nonNull(ressource.getTypeRess())
                && !"".equalsIgnoreCase(ressource.getTypeRess())) {
            ressourceDB.setTypeRess(
                    ressource.getTypeRess());
        }
        if (Objects.nonNull(ressource.getNomRess())
                && !"".equalsIgnoreCase(ressourceDB.getNomRess())) {
            ressourceDB.setNomRess(
                    ressource.getNomRess());
        }
        return ressourceRepository.save(ressourceDB);
    }
    // Read all raws

    @Override public List<Ressource> fetchRessList()
    {
        return (List<Ressource>)
                ressourceRepository.findAll();
    }

    //read raw by id
    @Override

    public Ressource getRessById(Integer id)
    {
        return ressourceRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deleteRessById(Integer id)
    {
        ressourceRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteRess(Ressource ressource)
    {
        ressourceRepository.deleteAll();
    }
}
