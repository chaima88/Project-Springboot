package com.GestionEquipe.GestionEquipe.ServicesImpl;
import com.GestionEquipe.GestionEquipe.Repository.RapportRepository;
import com.GestionEquipe.GestionEquipe.Services.IRapportService;
import com.GestionEquipe.GestionEquipe.model.Rapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RapportService implements IRapportService {
    @Autowired
    private RapportRepository rapportRepository;

    @Override
    public Rapport saveRap(Rapport rapport) {
        Rapport rapportToReturn = rapportRepository.save(rapport);
        return rapportToReturn;
    }

    @Override
    public Rapport updateRap(Rapport rapport, Integer id) {
        Rapport rapportDB
                = rapportRepository.findById(id).get();

        if (Objects.nonNull(rapport.getDescription())
                && !"".equalsIgnoreCase(rapport.getDescription())) {
            rapportDB.setDescription(
                    rapport.getDescription());
        }
        if (Objects.nonNull(rapport.getDateCreat())
                && !"".equalsIgnoreCase(String.valueOf(rapport.getDateCreat()))) {
            rapportDB.setDateCreat(
                    rapport.getDateCreat());
        }
        return rapportRepository.save(rapportDB);
    }
    // Read all raws

    @Override public List<Rapport> fetchRapList()
    {
        return (List<Rapport>)
                rapportRepository.findAll();
    }

    //read raw by id
    @Override

    public Rapport getRapById(Integer id)
    {
        return rapportRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deleteRapById(Integer id)
    {
        rapportRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteRap(Rapport rapport)
    {
        rapportRepository.deleteAll();
    }
}
