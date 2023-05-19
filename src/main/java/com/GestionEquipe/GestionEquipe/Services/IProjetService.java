package com.GestionEquipe.GestionEquipe.Services;

import com.GestionEquipe.GestionEquipe.model.Projet;
import com.GestionEquipe.GestionEquipe.model.SousTache;

import java.util.List;

public interface IProjetService {
    public Projet saveProj(Projet projet);
    public Projet updateProj(Projet projet, Integer id);
    public void deleteProjById(Integer id);
    public Projet getProjById(Integer id);
    public void deleteProj(Projet projet);
    public List<Projet> fetchProjList();
    public List<Projet> fetchProjetListByEquipe(Integer idEquipe);
}
