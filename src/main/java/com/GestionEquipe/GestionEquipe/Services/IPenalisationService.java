package com.GestionEquipe.GestionEquipe.Services;



import com.GestionEquipe.GestionEquipe.model.Penalisation;

import java.util.List;

public interface IPenalisationService {
    public Penalisation savePen(Penalisation penalisation);
    public Penalisation updatePen(Penalisation penalisation, Integer id);
    // Read operation
    public List<Penalisation> fetchPenList();
    public Penalisation getPenById(Integer id);
    // Delete operation by id
    public void deletePenById(Integer id);
    public void deletePen(Penalisation penalisation);



}
