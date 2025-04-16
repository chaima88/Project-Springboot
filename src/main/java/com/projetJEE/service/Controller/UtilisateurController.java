package com.projetJEE.Controller;

import com.projetJEE.Repository.UtilisateurRepository;
import com.projetJEE.Services.IUtilisateurService;
import com.projetJEE.model.Utilisateur;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Builder
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Users")
public class UtilisateurController {

    @Autowired
    private IUtilisateurService iUtilisateurService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @PutMapping("/user/{id}")
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur,
                                   @PathVariable("id") Integer id)
    {
        return iUtilisateurService.updateUser(utilisateur,id);
    }


    @GetMapping("/getAll")
    public List<Utilisateur> fetchUtilisateurList()
    {
        return iUtilisateurService.fetchUserList();
    }


    @GetMapping("/user/{id}")
    public Utilisateur getUtilisateur(@PathVariable("id")
                                       Integer id)
    {
        return iUtilisateurService.getUserById(id);
    }


    @DeleteMapping("/user/{id}")
    public String deleteUtilisateurById(@PathVariable("id")
                                       Integer id)
    {
        iUtilisateurService.deleteUserById(
                id);
        return "Deleted by id Successfully";
    }



    @DeleteMapping("/deleteAll")
    public String deleteUtilisateur(Utilisateur utilisateur)
    {
        iUtilisateurService.deleteUser(utilisateur);
        return "Deleted Successfully";
    }


    @GetMapping("/listerUser")
    public List<Utilisateur> getallusr(){
        return utilisateurRepository.findAll();
    }

}



// controller ---->Service -------> Repository