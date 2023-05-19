package com.GestionEquipe.GestionEquipe.auth;

import com.GestionEquipe.GestionEquipe.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {


    private String nom;
    private String prenom;
    private String login;
    private String password;
    private String email;
    private Integer cin;
    private Role role;


}