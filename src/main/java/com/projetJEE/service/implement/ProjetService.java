package com.projetJEE.ServicesImpl;

import com.projetJEE.Repository.ProjetRepository;
import com.projetJEE.Services.IProjetService;
import com.projetJEE.model.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;



@Service
public class ProjetService implements IProjetService {
    @Autowired
    private ProjetRepository projetRepository;

    @Override
    public Projet saveProj(Projet projet) {
        Projet projetToReturn = projetRepository.save(projet);
        return projetToReturn;
    }

    @Override
    public Projet updateProj(Projet projet, Integer id) {
        Projet projetDB
                = projetRepository.findById(id).get();


        if (Objects.nonNull(projet.getDateDebProj())
                && !"".equalsIgnoreCase(String.valueOf(projet.getDateDebProj()))) {
            projetDB.setDateDebProj(
                    projet.getDateDebProj());
        }
        if (Objects.nonNull(projet.getDateFinProj())
                && !"".equalsIgnoreCase(String.valueOf(projet.getDateFinProj()))) {
            projetDB.setDateFinProj(
                    projet.getDateFinProj());
        }
        if (Objects.nonNull(projet.getDescriptProj())
                && !"".equalsIgnoreCase(String.valueOf(projet.getDescriptProj()))) {
            projetDB.setDescriptProj(
                    projet.getDescriptProj());
        }
        if (Objects.nonNull(projet.getEtatProj())
                && !"".equalsIgnoreCase(String.valueOf(projet.getEtatProj()))) {
            projetDB.setEtatProj(
                    projet.getEtatProj());
        }
        if (Objects.nonNull(projet.getNomProj())
                && !"".equalsIgnoreCase(String.valueOf(projet.getNomProj()))) {
            projetDB.setNomProj(
                    projet.getNomProj());
        }
        return projetRepository.save(projetDB);
    }

    // Read all raws

    @Override public List<Projet> fetchProjList()
    {
        return (List<Projet>)
                projetRepository.findAll();
    }

    //read raw by id
    @Override

    public Projet getProjById(Integer id)
    {
        return projetRepository.findById(id).get();
    }
    // Delete raw by id
    @Override
    public void deleteProjById(Integer id)
    {
        projetRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteProj(Projet projet)
    {
        projetRepository.deleteAll();
    }
    @Override
    public List<Projet> fetchProjetListByEquipe(Integer idEquipe) {
        return projetRepository.findByEquipe_idEquipe(idEquipe);
    }
}
