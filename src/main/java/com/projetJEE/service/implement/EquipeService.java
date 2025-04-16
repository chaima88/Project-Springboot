package com.projetJEE.ServicesImpl;
import com.projetJEE.Repository.EquipeRepository;
import com.projetJEE.Services.IEquipeService;
import com.projetJEE.model.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EquipeService implements IEquipeService {
    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    public Equipe saveEqui(Equipe equipe) {
        Equipe equipeToReturn = equipeRepository.save(equipe);
        return equipeToReturn;
    }

    @Override
    public Equipe updateEqui(Equipe equipe, Integer id) {
        Equipe equipeDB
                = equipeRepository.findById(id).get();
        if (Objects.nonNull(equipe.getNomEqui())
                && !"".equalsIgnoreCase(equipe.getNomEqui())) {
            equipeDB.setNomEqui(
                    equipe.getNomEqui());
        }

        if (Objects.nonNull(equipe.getDescriptionEqui())
                && !"".equalsIgnoreCase(equipe.getDescriptionEqui())) {
            equipeDB.setDescriptionEqui(
                    equipe.getDescriptionEqui());
        }
        return equipeRepository.save(equipeDB);

    }

    // Read all raws

    @Override
    public List<Equipe> fetchEquiList()
    {
        return (List<Equipe>)
                equipeRepository.findAll();
    }

    //read raw by id
    @Override

    public Equipe getEquiById(Integer id)
    {
        return equipeRepository.findById(id).get();
    }
    // Delete raw by id
    @Override
    public void deleteEquiById(Integer id)
    {
        equipeRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteEqui(Equipe equipe)
    {
        equipeRepository.deleteAll();
    }
}
