package com.GestionEquipe.GestionEquipe.ServicesImpl;
import com.GestionEquipe.GestionEquipe.Repository.RecompenseRepository;
import com.GestionEquipe.GestionEquipe.Services.IRecompenseService;
import com.GestionEquipe.GestionEquipe.model.Recompense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RecompenseService implements IRecompenseService {
    @Autowired
    private RecompenseRepository recompenseRepository;
    @Override
    public Recompense saveRecom(Recompense recompense) {
        Recompense recompenseToReturn = recompenseRepository.save(recompense);
        return recompenseToReturn;
    }
    @Override
    public Recompense updateRecom(Recompense recompense, Integer id) {
        Recompense recompenseDB
                = recompenseRepository.findById(id).get();


        if (Objects.nonNull(recompense.getTypeRecomp())
                && !"".equalsIgnoreCase(recompenseDB.getTypeRecomp())) {
            recompenseDB.setTypeRecomp(
                    recompense.getTypeRecomp());
        }
        if (Objects.nonNull(recompense.getNomRecomp())
                && !"".equalsIgnoreCase(recompenseDB.getNomRecomp())) {
            recompenseDB.setNomRecomp(
                    recompense.getNomRecomp());
        }
        return recompenseRepository.save(recompenseDB);
    }
    // Read all raws

    @Override public List<Recompense> fetchRecomList()
    {
        return (List<Recompense>)
                recompenseRepository.findAll();
    }

    //read raw by id
    @Override

    public Recompense getRecomById(Integer id)
    {
        return recompenseRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deleteRecomById(Integer id)
    {
        recompenseRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteRecom(Recompense utilisateur)
    {
        recompenseRepository.deleteAll();
    }
}
