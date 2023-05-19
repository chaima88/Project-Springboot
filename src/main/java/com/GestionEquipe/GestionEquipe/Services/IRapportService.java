package com.GestionEquipe.GestionEquipe.Services;

import com.GestionEquipe.GestionEquipe.model.Rapport;

import java.util.List;


public interface IRapportService {
    public Rapport saveRap(Rapport rapport);
    public Rapport updateRap(Rapport rapport, Integer id);
    public void deleteRap(Rapport rapport);
    public Rapport getRapById(Integer id);
    public void deleteRapById(Integer id);
    public List<Rapport> fetchRapList();
}