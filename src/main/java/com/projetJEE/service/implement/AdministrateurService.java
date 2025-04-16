package com.projetJEE.ServicesImpl;
import com.projetJEE.Repository.AdministrateurRepository;
import com.projetJEE.Services.IAdministrateurService;
import com.projetJEE.model.Administrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class AdministrateurService implements IAdministrateurService {
    @Autowired
    private AdministrateurRepository administrateurRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder ;

    @Override
    public Administrateur saveAdmin(Administrateur administrateur) {
        administrateur.setPassword(passwordEncoder.encode(administrateur.getPassword()));
        Administrateur administrateurToReturn = administrateurRepository.save(administrateur);
        return administrateurToReturn;
    }
    @Override
    public Administrateur updateAdmin(Administrateur administrateur, Integer id) {
        Administrateur administrateurDB
                = administrateurRepository.findById(id).get();

        if (Objects.nonNull(administrateur.getEmail())
                && !"".equalsIgnoreCase(administrateur.getEmail())) {
            administrateurDB.setEmail(
                    administrateur.getEmail());
        }
        if (Objects.nonNull(administrateur.getLogin())
                && !"".equalsIgnoreCase(administrateur.getLogin())) {
            administrateurDB.setLogin(
                    administrateur.getLogin());
        }
        if (Objects.nonNull(administrateur.getPassword())
                && !"".equalsIgnoreCase(administrateur.getPassword())) {
            administrateurDB.setPassword(
                    administrateur.getPassword());
        }

        if (Objects.nonNull(administrateur.getNom())
                && !"".equalsIgnoreCase(administrateur.getNom())) {
            administrateurDB.setNom(
                    administrateur.getNom());
        }
        if (Objects.nonNull(administrateur.getPrenom())
                && !"".equalsIgnoreCase(administrateur.getPrenom())) {
            administrateurDB.setPrenom(
                    administrateur.getPrenom());
        }

        return administrateurRepository.save(administrateurDB);

    }

    // Read all raws

    @Override public List<Administrateur> fetchAdminList()
    {
        return (List<Administrateur>)
                administrateurRepository.findAll();
    }

    //read raw by id
    @Override

    public Administrateur getAdminById(Integer id)
    {
        return administrateurRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deleteAdminById(Integer id)
    {
        administrateurRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteAdmin(Administrateur administrateur)
    {
        administrateurRepository.deleteAll();
    }
    @Override
    public Administrateur findByEmail(String email) {
        return administrateurRepository.findByEmail(email);
    }

}
