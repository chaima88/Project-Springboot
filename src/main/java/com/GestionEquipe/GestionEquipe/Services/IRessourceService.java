package com.GestionEquipe.GestionEquipe.Services;


import com.GestionEquipe.GestionEquipe.model.Ressource;

import java.util.List;


public interface IRessourceService {
    public Ressource saveRess(Ressource ressource);
    public Ressource updateRess(Ressource ressource, Integer id);
    public void deleteRess(Ressource ressource);
    public Ressource getRessById(Integer id);
    public void deleteRessById(Integer id);
    public List<Ressource> fetchRessList();
}
