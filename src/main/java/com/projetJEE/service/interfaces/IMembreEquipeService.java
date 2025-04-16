package com.projetJEE.Services;


import com.projetJEE.model.MembreEquipe;

import java.util.List;


public interface IMembreEquipeService {
    public MembreEquipe saveMemb(MembreEquipe membre);
    public MembreEquipe updateMemb(MembreEquipe membre, Integer id);
    public void deleteMembById(Integer id);
    public MembreEquipe getMembById(Integer id);
    public void deleteMemb(MembreEquipe membre);
    public List<MembreEquipe> fetchMembList();
}