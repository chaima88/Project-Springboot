package com.projetJEE.ServicesImpl;
import com.projetJEE.Repository.*;
import com.projetJEE.Services.IDAshboardService;
import com.projetJEE.model.DashboardModel;
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
    private SousTacheRepository sousTacheRepository;


    @Override
    public DashboardModel genrateDashboard() {
        DashboardModel dashboardModel = new DashboardModel();
        dashboardModel.setChef(chefProjetRepository.findAll().size());
        dashboardModel.setEquipe(equipeRepository.findAll().size());
        dashboardModel.setProjet(projetRepository.findAll().size());

        dashboardModel.setTache(tacheRepository.findAll().size());

        dashboardModel.setSousTache(sousTacheRepository.findAll().size());
      
        return dashboardModel;
    }
}
