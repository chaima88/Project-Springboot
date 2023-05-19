package com.GestionEquipe.GestionEquipe.Controller;

import com.GestionEquipe.GestionEquipe.Services.IEquipeService;
import com.GestionEquipe.GestionEquipe.model.Equipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/equi")
public class EquipeController {

    @Autowired
    private IEquipeService iEquipeService;
    @PostMapping("/save")
    public Equipe SaveEquipe(@RequestBody Equipe equipe){
        Equipe equipeToReturn = iEquipeService.saveEqui(equipe);
        return equipeToReturn;
    }
    @PutMapping("/update/{id}")
    public Equipe updateEquipe(@RequestBody Equipe equipe,
                                         @PathVariable("id") Integer id)
    {
        return iEquipeService.updateEqui(equipe,id);
    }


    // Read raw by id

    @GetMapping("/allEquipe")

    public List<Equipe> fetchEquipeList()
    {
        return iEquipeService.fetchEquiList();
    }

    // Read All Raws
    @GetMapping("/equiById/{id}")

    public Equipe getEquipe(@PathVariable("id")
                                      Integer id)
    {
        return iEquipeService.getEquiById(id);

    }
    // Delete raw by id
    @DeleteMapping("/delById/{id}")

    public String deleteEquipeById(@PathVariable("id")
                                        Integer id)
    {
        iEquipeService.deleteEquiById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/delete")
    public String deleteEquipe(Equipe equipe)
    {
        iEquipeService.deleteEqui(equipe);
        return "Deleted Successfully";
    }




}