package com.GestionEquipe.GestionEquipe.Controller;

import com.GestionEquipe.GestionEquipe.Services.IPenalisationService;
import com.GestionEquipe.GestionEquipe.model.Penalisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pen")
public class PenalisationController {

    @Autowired
    private IPenalisationService ipenalisationService;
    @PostMapping("/save")
    public Penalisation SaveRapport(@RequestBody Penalisation penalisation){
        Penalisation rapportToReturn = ipenalisationService.savePen(penalisation);
        return rapportToReturn;
    }
    @PutMapping("/update/{id}")
    public Penalisation updatePenalisation(@RequestBody Penalisation penalisation,
                                 @PathVariable("id") Integer id)
    {
        return ipenalisationService.updatePen(penalisation,id);
    }

    // Read raw by id

    @GetMapping("/getAll")

    public List<Penalisation> getPenalisationList()
    {
        return ipenalisationService.fetchPenList();
    }

    // Read All Raws
    @GetMapping("/getbyid/{id}")

    public Penalisation getPenalisationById(@PathVariable("id")
                                  Integer id)
    {
        return ipenalisationService.getPenById(id);

    }
    // Delete raw by id
    @DeleteMapping("/deletebyid/{id}")

    public String deletePenById(@PathVariable("id")
                                    Integer id)
    {
        ipenalisationService.deletePenById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/deleteAll")
    public String deleteRapport(Penalisation rapport)
    {
        ipenalisationService.deletePen(rapport);
        return "Deleted Successfully";
    }
}



