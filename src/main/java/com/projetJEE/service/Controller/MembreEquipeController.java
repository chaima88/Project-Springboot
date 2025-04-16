package com.projetJEE.Controller;

import com.projetJEE.Services.IMembreEquipeService;
import com.projetJEE.model.MembreEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/memb")
public class MembreEquipeController {

    @Autowired
    private IMembreEquipeService iMembreEquipeService;



    @PostMapping("/membre")
    public MembreEquipe SaveMembreEquipe(@RequestBody MembreEquipe membre){
        MembreEquipe membreToReturn = iMembreEquipeService.saveMemb(membre);
        return membreToReturn;
    }
    @PutMapping("/membre/{id}")
    public MembreEquipe updateMembreEquipe(@RequestBody MembreEquipe membre,
                                         @PathVariable("id") Integer id)
    {
        return iMembreEquipeService.updateMemb(membre,id);
    }

    // Read raw by id

    @GetMapping("/membre")

    public List<MembreEquipe> fetchMembreEquipeList()
    {
        return iMembreEquipeService.fetchMembList();
    }

    // Read All Raws
    @GetMapping("/membre/{id}")

    public MembreEquipe getMembreEquipe(@PathVariable("id")
                                      Integer id)
    {
        return iMembreEquipeService.getMembById(id);

    }
    // Delete raw by id
    @DeleteMapping("/membre/{id}")

    public String deleteMembreEquipeById(@PathVariable("id")
                                        Integer id)
    {
        iMembreEquipeService.deleteMembById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/membre")
    public String deleteMembreEquipe(MembreEquipe membre)
    {
        iMembreEquipeService.deleteMemb(membre);
        return "Deleted Successfully";
    }
}




