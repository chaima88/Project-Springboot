package com.GestionEquipe.GestionEquipe.Controller;
import com.GestionEquipe.GestionEquipe.Repository.ChefProjetRepository;
import com.GestionEquipe.GestionEquipe.Services.IChefProjetService;
import com.GestionEquipe.GestionEquipe.auth.AuthenticationResponse;
import com.GestionEquipe.GestionEquipe.auth.AuthenticationService;
import com.GestionEquipe.GestionEquipe.auth.RegisterRequest;
import com.GestionEquipe.GestionEquipe.model.ChefProjet;
import com.GestionEquipe.GestionEquipe.model.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/chef")

public class ChefProjetController {

    @Autowired
    private IChefProjetService iChefProjetService;
    @Autowired
    private ChefProjetRepository chefProjetRepository;



    @PostMapping("/chefProjet")
    public ChefProjet SaveChefProjet(@RequestBody ChefProjet chefProjet){
        ChefProjet chefProjetToReturn = iChefProjetService.saveChef(chefProjet);
        return chefProjetToReturn;
    }
    @PutMapping("/chefProjet/{id}")
    public ChefProjet updateChefProjet(@RequestBody ChefProjet chefProjet,
                                         @PathVariable("id") Integer id)
    {
        return iChefProjetService.updateChef(chefProjet,id);
    }


    // Read raw by id

    @GetMapping("/allChef")

    public List<ChefProjet> fetchChefProjetList()
    {
        return iChefProjetService.fetchChefList();
    }

    // Read All Raws
    @GetMapping("/chefProjet/{id}")

    public ChefProjet getChefProjet(@PathVariable("id")
                                      Integer id)
    {
        return iChefProjetService.getChefById(id);

    }
    // Delete raw by id
    @DeleteMapping("/chefProjet/{id}")

    public String deleteChefProjetById(@PathVariable("id")
                                        Integer id)
    {
        iChefProjetService.deleteChefById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/chefProjet")
    public String deleteChefProjet(ChefProjet chefProjet)
    {
        iChefProjetService.deleteChef(chefProjet);
        return "Deleted Successfully";
    }




}


