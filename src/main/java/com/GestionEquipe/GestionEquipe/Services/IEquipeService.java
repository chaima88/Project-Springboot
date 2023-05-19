package com.GestionEquipe.GestionEquipe.Services;

import com.GestionEquipe.GestionEquipe.model.Equipe;

import java.util.List;

public interface IEquipeService {
    public Equipe saveEqui(Equipe equipe);
    public Equipe updateEqui(Equipe equipe, Integer id);
    public void deleteEquiById(Integer id);
    public Equipe getEquiById(Integer id);
    public void deleteEqui(Equipe equipe);
    public List<Equipe> fetchEquiList();
}
