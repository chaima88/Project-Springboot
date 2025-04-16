package com.projetJEE.ServicesImpl;

import com.projetJEE.Repository.MembreEquipeRepository;
import com.projetJEE.Services.IMembreEquipeService;
import com.projetJEE.model.MembreEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MembreEquipeService implements IMembreEquipeService {
    @Autowired
    private MembreEquipeRepository membreRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder ;

    @Override
    public MembreEquipe saveMemb(MembreEquipe membre) {
        membre.setPassword(passwordEncoder.encode(membre.getPassword()));
        return membreRepository.save(membre);
    }
    @Override
    public MembreEquipe updateMemb(MembreEquipe membre, Integer id) {
        MembreEquipe membreDB
                = membreRepository.findById(id).get();


        if (Objects.nonNull(membre.getMatricule())
                && !"".equalsIgnoreCase(String.valueOf(membre.getMatricule()))) {
            membreDB.setMatricule(
                    membre.getMatricule());
        }
        if (Objects.nonNull(membre.getCin())
                && !"".equalsIgnoreCase(String.valueOf(membre.getCin()))) {
            membreDB.setCin(
                    membre.getCin());
        }
        if (Objects.nonNull(membre.getNumTel())
                && !"".equalsIgnoreCase(String.valueOf(membre.getNumTel()))) {
            membreDB.setNumTel(
                    membre.getNumTel());

        }
        if (Objects.nonNull(membre.getEmail())
                && !"".equalsIgnoreCase(membre.getEmail())) {
            membreDB.setEmail(
                    membre.getEmail());
        }
        if (Objects.nonNull(membre.getLogin())
                && !"".equalsIgnoreCase(membre.getLogin())) {
            membreDB.setLogin(
                    membre.getLogin());
        }
        if (Objects.nonNull(membre.getPassword())
                && !"".equalsIgnoreCase(membre.getPassword())) {
            membreDB.setPassword(
                    membre.getPassword());
        }

        if (Objects.nonNull(membre.getNom())
                && !"".equalsIgnoreCase(membre.getNom())) {
            membreDB.setNom(
                    membre.getNom());
        }
        if (Objects.nonNull(membre.getPrenom())
                && !"".equalsIgnoreCase(membre.getPrenom())) {
            membreDB.setPrenom(
                    membre.getPrenom());
        }

        return membreRepository.save(membreDB);

    }

    // Read all raws

    @Override public List<MembreEquipe> fetchMembList()
    {
        return (List<MembreEquipe>)
                membreRepository.findAll();
    }

    //read raw by id
    @Override

    public MembreEquipe getMembById(Integer id)
    {
        return membreRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deleteMembById(Integer id)
    {
        membreRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteMemb(MembreEquipe membre)
    {
        membreRepository.deleteAll();
    }

}
