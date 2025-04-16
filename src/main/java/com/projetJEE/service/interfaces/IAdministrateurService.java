package com.projetJEE.Services;

import com.projetJEE.model.Administrateur;

import java.util.List;

public interface IAdministrateurService {
    public Administrateur saveAdmin(Administrateur administrateur);
public Administrateur updateAdmin(Administrateur administrateur, Integer id);
    public void deleteAdminById(Integer id);
    public Administrateur getAdminById(Integer id);
    public void deleteAdmin(Administrateur administrateur);
    public List<Administrateur> fetchAdminList();
    public Administrateur findByEmail(String email);
}
