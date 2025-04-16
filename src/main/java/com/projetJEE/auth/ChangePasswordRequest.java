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
public class ChangePasswordRequest {


    private String oldPassword;
    private String newPassword;

}