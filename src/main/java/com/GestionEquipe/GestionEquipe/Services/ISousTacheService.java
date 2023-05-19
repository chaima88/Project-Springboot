package com.GestionEquipe.GestionEquipe.Services;

import com.GestionEquipe.GestionEquipe.model.SousTache;


import java.util.List;

public interface ISousTacheService {
    public SousTache saveSousTask(SousTache sousTache);
    public SousTache updateSousTask(SousTache sousTache, Integer id);
    // Read operation
    public List<SousTache> fetchSousTaskList();
    public SousTache getSousTaskById(Integer id);
    // Delete operation by id
    public void deleteSousTaskById(Integer id);
    public void deleteSousTask(SousTache sousTache);
    public List<SousTache> fetchSousTaskListByTache(Integer idTache);



}
