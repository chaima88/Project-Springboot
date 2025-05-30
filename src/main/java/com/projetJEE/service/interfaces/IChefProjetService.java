package com.projetJEE.Services;

import com.projetJEE.model.ChefProjet;

import java.util.List;


public interface IChefProjetService {
    public ChefProjet saveChef(ChefProjet chefProjet);
    public ChefProjet updateChef(ChefProjet chefProjet, Integer id);
    public void deleteChefById(Integer id);
    public ChefProjet getChefById(Integer id);
    public void deleteChef(ChefProjet chefProjet);
    public List<ChefProjet> fetchChefList();


}
