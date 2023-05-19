
package com.GestionEquipe.GestionEquipe.Controller;

import com.GestionEquipe.GestionEquipe.Services.IRecompenseService;
import com.GestionEquipe.GestionEquipe.model.Recompense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/recomp")
public class RecompenseController {

    @Autowired
    private IRecompenseService iRecompenseService;
    @PostMapping("/save")
    public Recompense SaveRecompense(@RequestBody Recompense recompense){
        Recompense recompenseToReturn = iRecompenseService.saveRecom(recompense);
        return recompenseToReturn;
    }
    @PutMapping("/update/{id}")
    public Recompense updateRecompense(@RequestBody Recompense recompense,
                                 @PathVariable("id") Integer id)
    {
        return iRecompenseService.updateRecom(recompense,id);
    }

    // Read raw by id

    @GetMapping("/getAll")

    public List<Recompense> getRapportList()
    {
        return iRecompenseService.fetchRecomList();
    }

    // Read All Raws
    @GetMapping("/getByid/{id}")

    public Recompense getRecompenseById(@PathVariable("id")
                                  Integer id)
    {
        return iRecompenseService.getRecomById(id);

    }
    // Delete raw by id
    @DeleteMapping("/delByid/{id}")

    public String deleteRecompenseById(@PathVariable("id")
                                    Integer id)
    {
        iRecompenseService.deleteRecomById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/deleteAll")
    public String deleteRecompense(Recompense recompense)
    {
        iRecompenseService.deleteRecom(recompense);
        return "Deleted Successfully";
    }
}


