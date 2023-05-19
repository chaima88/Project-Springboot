package com.GestionEquipe.GestionEquipe.ServicesImpl;

import com.GestionEquipe.GestionEquipe.Repository.*;
import com.GestionEquipe.GestionEquipe.Services.IDAshboardService;
import com.GestionEquipe.GestionEquipe.model.DashboardModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService implements IDAshboardService {

    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private ChefProjetRepository chefProjetRepository;

    @Autowired
    private RessourceRepository ressourceRepository;

    @Autowired
    private RapportRepository rapportRepository;

    @Override
    public DashboardModel genrateDashboard() {
        DashboardModel dashboardModel = new DashboardModel();
        dashboardModel.setChef(chefProjetRepository.findAll().size());
        dashboardModel.setEquipe(equipeRepository.findAll().size());
        dashboardModel.setProjet(projetRepository.findAll().size());
        dashboardModel.setRapport(rapportRepository.findAll().size());
        dashboardModel.setTache(tacheRepository.findAll().size());
        dashboardModel.setRessource(ressourceRepository.findAll().size());
        return dashboardModel;
    }
}
