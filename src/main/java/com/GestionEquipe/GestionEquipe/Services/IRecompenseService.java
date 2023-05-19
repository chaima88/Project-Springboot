package com.GestionEquipe.GestionEquipe.Services;



import com.GestionEquipe.GestionEquipe.model.Recompense;

import java.util.List;

public interface IRecompenseService {
    public Recompense saveRecom(Recompense recompense);
    public Recompense updateRecom(Recompense recompense, Integer id);
    // Read operation
    public List<Recompense> fetchRecomList();
    public Recompense getRecomById(Integer id);
    // Delete operation by id
    public void deleteRecomById(Integer id);
    public void deleteRecom(Recompense recompense);



}
