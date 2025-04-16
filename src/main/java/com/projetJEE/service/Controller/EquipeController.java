package com.projetJEE.Controller;

import com.projetJEE.Services.IEquipeService;
import com.projetJEE.model.Equipe;

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
    @PutMapping("/equipe/{id}")
    public Equipe updateEquipe(@RequestBody Equipe equipe,
                                         @PathVariable("id") Integer id)
    {
        return iEquipeService.updateEqui(equipe,id);
    }


    // Read raw by id

    @GetMapping("/equipe")

    public List<Equipe> fetchEquipeList()
    {
        return iEquipeService.fetchEquiList();
    }

    // Read All Raws
    @GetMapping("/equipe/{id}")

    public Equipe getEquipe(@PathVariable("id")
                                      Integer id)
    {
        return iEquipeService.getEquiById(id);

    }
    // Delete raw by id
    @DeleteMapping("/equipe/{id}")

    public String deleteEquipeById(@PathVariable("id")
                                        Integer id)
    {
        iEquipeService.deleteEquiById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/equipe")
    public String deleteEquipe(Equipe equipe)
    {
        iEquipeService.deleteEqui(equipe);
        return "Deleted Successfully";
    }




}