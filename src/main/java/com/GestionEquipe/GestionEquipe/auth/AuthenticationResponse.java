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
public class AuthenticationResponse {

    private String token;
    private String firstName;
    private String lastName;
    private Role role;
    private String codeError;
    private String Aemail;
    private Integer cin;
}