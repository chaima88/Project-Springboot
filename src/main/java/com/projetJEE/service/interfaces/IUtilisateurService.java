package com.projetJEE.Services;

import com.projetJEE.model.Utilisateur;

import java.util.List;

public interface IUtilisateurService {
    public Utilisateur saveUser(Utilisateur utilisateur);
    public void saveUserInDataBase(Utilisateur utilisateur);
    public Utilisateur updateUser(Utilisateur utilisateur, Integer id);
    // Read operation
     public List<Utilisateur> fetchUserList();
     public Utilisateur getUserById(Integer id);
    // Delete operation by id
     public void deleteUserById(Integer id);
    public void deleteUser(Utilisateur utilisateur);
    public Utilisateur getCurrentUser();



}

