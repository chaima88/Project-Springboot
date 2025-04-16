package com.projetJEE.Controller;

import com.projetJEE.Services.ITacheService;
import com.projetJEE.model.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/task")
public class TacheController {

    @Autowired
    private ITacheService iTacheService;
    @PostMapping("/taches")
    public Tache SaveTache(@RequestBody Tache tache){
        Tache tacheToReturn = iTacheService.saveT(tache);
        return tacheToReturn;
    }
    @PutMapping("/taches/{id}")
    public Tache updateTache(@RequestBody Tache tache,
                                         @PathVariable("id") Integer id)
    {
        return iTacheService.updateTask(tache,id);
    }
    // Read raw by id

    @GetMapping("/taches")

    public List<Tache> getTacheList()
    {
        return iTacheService.fetchTaskList();
    }

    // Read All Raws
    @GetMapping("/taches/{id}")

    public Tache getTacheById(@PathVariable("id")
                                      Integer id)
    {
        return iTacheService.getTaskById(id);

    }
    // Delete raw by id
    @DeleteMapping("/taches/{id}")

    public String deleteTacheById(@PathVariable("id")
                                        Integer id)
    {
        iTacheService.deleteTaskById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/taches")
    public String deleteTache(Tache tache)
    {
        iTacheService.deleteTask(tache);
        return "Deleted Successfully";
    }
}