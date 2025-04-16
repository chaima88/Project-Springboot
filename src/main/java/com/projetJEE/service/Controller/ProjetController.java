package com.projetJEE.Controller;

import com.projetJEE.Services.IProjetService;
import com.projetJEE.model.Projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/proj")
public class ProjetController {

    @Autowired
    private IProjetService iProjetService;

    @PostMapping("/projet")
    public Projet SaveProjet(@RequestBody Projet projet){
        Projet projetToReturn = iProjetService.saveProj(projet);
        return projetToReturn;
    }
    @PutMapping("/projet/{id}")
    public Projet updateProjet(@RequestBody Projet projet,
                                         @PathVariable("id") Integer id)
    {
        return iProjetService.updateProj(projet,id);
    }


    // Read raw by id

    @GetMapping("/projet")

    public List<Projet> fetchProjetList()
    {
        return iProjetService.fetchProjList();
    }

    // Read All Raws
    @GetMapping("/projet/{id}")

    public Projet getProjet(@PathVariable("id")
                                      Integer id)
    {
        return iProjetService.getProjById(id);

    }
    // Delete raw by id
    @DeleteMapping("/projet/{id}")

    public String deleteProjetById(@PathVariable("id")
                                        Integer id)
    {
        iProjetService.deleteProjById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/projet")
    public String deleteProjet(Projet projet)
    {
        iProjetService.deleteProj(projet);
        return "Deleted Successfully";
    }

    @GetMapping("/projet/projetByIdEquipe/{idEquipe}")

    public List<Projet> getEquipeListByIdEquipe(@PathVariable Integer idEquipe)
    {
        return iProjetService.fetchProjetListByEquipe(idEquipe);
    }
}
