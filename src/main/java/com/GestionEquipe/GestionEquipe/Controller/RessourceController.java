package com.GestionEquipe.GestionEquipe.Controller;



import com.GestionEquipe.GestionEquipe.Services.IRessourceService;
import com.GestionEquipe.GestionEquipe.model.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ress")
public class RessourceController {

    @Autowired
    private IRessourceService iRessourceService;
    @PostMapping("/ressource")
    public Ressource SaveRessource(@RequestBody Ressource ressource){
       Ressource ressourceToReturn = iRessourceService.saveRess(ressource);
        return ressourceToReturn;
    }
    @PutMapping("/ressource/{id}")
    public Ressource updateRess(@RequestBody Ressource ressource,
                                         @PathVariable("id") Integer id)
    {
        return iRessourceService.updateRess(ressource,id);
    }
    // Read raw by id

    @GetMapping("/ressource")

    public List<Ressource> getRessourceList()
    {
        return iRessourceService.fetchRessList();
    }

    // Read All Raws
    @GetMapping("/ressource/{id}")

    public Ressource getRessourceById(@PathVariable("id")
                                      Integer id)
    {
        return iRessourceService.getRessById(id);

    }
    // Delete raw by id
    @DeleteMapping("/ressource/{id}")

    public String deleteRessourceById(@PathVariable("id")
                                        Integer id)
    {
        iRessourceService.deleteRessById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/ressource")
    public String deleteRessource(Ressource ressource)
    {
        iRessourceService.deleteRess(ressource);
        return "Deleted Successfully";
    }
}