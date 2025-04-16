package com.projetJEE.Controller;

import com.projetJEE.Services.ISousTacheService;
import com.projetJEE.model.SousTache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/soustask")
public class SousTacheController {

    @Autowired
    private ISousTacheService iSousTacheService;
    @PostMapping("/soustache")
    public SousTache SaveSousTache(@RequestBody SousTache sousTache){
        SousTache soustacheToReturn = iSousTacheService.saveSousTask(sousTache);
        return soustacheToReturn;
    }
    @PutMapping("/soustache/{id}")
    public SousTache updateSousTache(@RequestBody SousTache sousTache,
                             @PathVariable("id") Integer id)
    {
        return iSousTacheService.updateSousTask(sousTache,id);
    }


    @GetMapping("/soustache")

    public List<SousTache> getTacheList()
    {
        return iSousTacheService.fetchSousTaskList();
    }


    @GetMapping("/soustache/{id}")

    public SousTache getTacheById(@PathVariable("id")
                              Integer id)
    {
        return iSousTacheService.getSousTaskById(id);

    }
    // Delete raw by id
    @DeleteMapping("/soustache/{id}")

    public String deleteSousTacheById(@PathVariable("id")
                                  Integer id)
    {
        iSousTacheService.deleteSousTaskById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/soustache")
    public String deleteSousTache(SousTache sousTache)
    {
        iSousTacheService.deleteSousTask(sousTache);
        return "Deleted Successfully";
    }


    @GetMapping("/soustache/soustacheByIdTache/{idTache}")

    public List<SousTache> getTacheListByIdTache(@PathVariable Integer idTache)
    {
        return iSousTacheService.fetchSousTaskListByTache(idTache);
    }

}