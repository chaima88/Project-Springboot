package com.projetJEE.ServicesImpl;

import com.projetJEE.Repository.UtilisateurRepository;
import com.projetJEE.Services.IUtilisateurService;
import com.projetJEE.model.Utilisateur;
import com.projetJEE.utils.SecurityUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class UtilisateurService implements IUtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder ;

    @Override
    public Utilisateur saveUser(Utilisateur utilisateur) {
    	utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        Utilisateur utilisateurToReturn = utilisateurRepository.save(utilisateur);
        return utilisateurToReturn;
    }

    @Override
    public Utilisateur updateUser(Utilisateur utilisateur, Integer id) {
        Utilisateur userDB
                = utilisateurRepository.findById(id).get();
        if (Objects.nonNull(utilisateur.getLogin())
                && !"".equalsIgnoreCase(utilisateur.getLogin())) {
            userDB.setLogin(
                    utilisateur.getLogin());
        }
        if (Objects.nonNull(utilisateur.getPassword())
                && !"".equalsIgnoreCase(utilisateur.getPassword())) {
            userDB.setPassword(
                    utilisateur.getPassword());
        }

        if (Objects.nonNull(utilisateur.getNom())
                && !"".equalsIgnoreCase(utilisateur.getNom())) {
            userDB.setNom(
                    utilisateur.getNom());
        }
        if (Objects.nonNull(utilisateur.getPrenom())
                && !"".equalsIgnoreCase(utilisateur.getPrenom())) {
            userDB.setPrenom(
                    utilisateur.getPrenom());
        }
        if (Objects.nonNull(utilisateur.getEmail())
                && !"".equalsIgnoreCase(utilisateur.getEmail())) {
            userDB.setEmail(
                    utilisateur.getEmail());
        }
        return utilisateurRepository.save(userDB);

    }


    // Read all raws

    @Override public List<Utilisateur> fetchUserList()
    {
    	Integer currentuserId = SecurityUtil.getCurrentUserId();
        return (List<Utilisateur>)
                utilisateurRepository.findAll().stream().filter(user -> user.getId() != currentuserId).toList();
    }

    //read raw by id
    @Override

    public Utilisateur getUserById(Integer id)
    {
       return utilisateurRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deleteUserById(Integer id)
    {
        utilisateurRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteUser(Utilisateur utilisateur)
    {
         utilisateurRepository.deleteAll();
    }

	@Override
	public Utilisateur getCurrentUser() {
		Integer currentuserId = SecurityUtil.getCurrentUserId();
		return getUserById(currentuserId);
	}

	@Override
	public void saveUserInDataBase(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
		
	}
}