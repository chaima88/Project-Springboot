package com.GestionEquipe.GestionEquipe.ServicesImpl;

import com.GestionEquipe.GestionEquipe.Repository.ChefProjetRepository;
import com.GestionEquipe.GestionEquipe.Services.IChefProjetService;
import com.GestionEquipe.GestionEquipe.model.ChefProjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ChefProjetService implements IChefProjetService {
    @Autowired
    private ChefProjetRepository chefProjetRepository;
    @Override
    public ChefProjet saveChef(ChefProjet chefProjet) {
        // encoder password
        ChefProjet chefProjetToReturn = chefProjetRepository.save(chefProjet);
        return chefProjetToReturn;
    }
    @Override
    public ChefProjet updateChef(ChefProjet chefProjet, Integer id) {
        ChefProjet chefDB
                = chefProjetRepository.findById(id).get();


        if (Objects.nonNull(chefProjet.getProjet())
                && !"".equalsIgnoreCase(String.valueOf(chefProjet.getProjet()))) {
            chefDB.setProjet(
                    chefProjet.getProjet());
        }
        if (Objects.nonNull(chefProjet.getPenalisation())
                && !"".equalsIgnoreCase(String.valueOf(chefProjet.getPenalisation()))) {
            chefDB.setPenalisation(
                    chefProjet.getPenalisation());
        }
        if (Objects.nonNull(chefProjet.getRecompense())
                && !"".equalsIgnoreCase(String.valueOf(chefProjet.getRecompense()))) {
            chefDB.setRecompense(
                    chefProjet.getRecompense());

        }
        if (Objects.nonNull(chefProjet.getNotification())
                && !"".equalsIgnoreCase(String.valueOf(chefProjet.getNotification()))) {
            chefDB.setNotification(
                    chefProjet.getNotification());
        }
        if (Objects.nonNull(chefProjet.getEquipe())
                && !"".equalsIgnoreCase(String.valueOf(chefProjet.getEquipe()))) {
            chefDB.setEquipe(
                    chefProjet.getEquipe());
        }
        if (Objects.nonNull(chefProjet.getEmail())
                && !"".equalsIgnoreCase(chefProjet.getEmail())) {
            chefDB.setEmail(
                    chefProjet.getEmail());
        }
        if (Objects.nonNull(chefProjet.getLogin())
                && !"".equalsIgnoreCase(chefProjet.getLogin())) {
            chefDB.setLogin(
                    chefProjet.getLogin());
        }
        if (Objects.nonNull(chefProjet.getPassword())
                && !"".equalsIgnoreCase(chefProjet.getPassword())) {
            chefDB.setPassword(
                    chefProjet.getPassword());
        }

        if (Objects.nonNull(chefProjet.getNom())
                && !"".equalsIgnoreCase(chefProjet.getNom())) {
            chefDB.setNom(
                    chefProjet.getNom());
        }
        if (Objects.nonNull(chefProjet.getPrenom())
                && !"".equalsIgnoreCase(chefProjet.getPrenom())) {
            chefDB.setPrenom(
                    chefProjet.getPrenom());
        }

        return chefProjetRepository.save(chefDB);

    }

    // Read all raws

    @Override public List<ChefProjet> fetchChefList()
    {
        return (List<ChefProjet>)
                chefProjetRepository.findAll();
    }

    //read raw by id
    @Override

    public ChefProjet getChefById(Integer id)
    {
        return chefProjetRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deleteChefById(Integer id)
    {
        chefProjetRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteChef(ChefProjet chefProjet)
    {
        chefProjetRepository.deleteAll();
    }


}
