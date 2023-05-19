package com.GestionEquipe.GestionEquipe.Controller;
import com.GestionEquipe.GestionEquipe.Services.IAdministrateurService;
import com.GestionEquipe.GestionEquipe.auth.AuthenticationResponse;
import com.GestionEquipe.GestionEquipe.auth.AuthenticationService;
import com.GestionEquipe.GestionEquipe.auth.RegisterRequest;
import com.GestionEquipe.GestionEquipe.model.Administrateur;
import com.GestionEquipe.GestionEquipe.model.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin")

public class AdministrateurController {

    @Autowired
    private IAdministrateurService iAdministrateurService;


    @PostMapping("/save")
    public Administrateur SaveAdministrateur(@RequestBody Administrateur administrateur){
        Administrateur administrateurToReturn = iAdministrateurService.saveAdmin(administrateur);
        return administrateurToReturn;
    }
    @PutMapping("/update/{id}")
    public Administrateur updateAdministrateur(@RequestBody Administrateur administrateur,
                                         @PathVariable("id") Integer id)
    {
        return iAdministrateurService.updateAdmin(administrateur,id);
    }



    // Read raw by id

    @GetMapping("/get")

    public List<Administrateur> fetchAdministrateurList()
    {
        return iAdministrateurService.fetchAdminList();
    }

    // Read All Raws
    @GetMapping("/getbyid/{id}")

    public Utilisateur getAdministrateurById(@PathVariable("id")
                                      Integer id)
    {
        return iAdministrateurService.getAdminById(id);

    }
    // Delete raw by id
    @DeleteMapping("/delbyid/{id}")

    public String deleteadministrateurById(@PathVariable("id")
                                        Integer id)
    {
        iAdministrateurService.deleteAdminById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/delete")
    public String deleteAdministrateur(Administrateur administrateur)
    {
        iAdministrateurService.deleteAdmin(administrateur);
        return "Deleted Successfully";
    }
}


