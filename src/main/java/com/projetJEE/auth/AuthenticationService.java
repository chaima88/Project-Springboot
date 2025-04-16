package com.GestionEquipe.GestionEquipe.auth;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.GestionEquipe.GestionEquipe.Config.JwtService;
import com.GestionEquipe.GestionEquipe.Repository.ChefProjetRepository;
import com.GestionEquipe.GestionEquipe.Repository.MembreEquipeRepository;
import com.GestionEquipe.GestionEquipe.Repository.UtilisateurRepository;
import com.GestionEquipe.GestionEquipe.Services.IUtilisateurService;
import com.GestionEquipe.GestionEquipe.model.ChefProjet;
import com.GestionEquipe.GestionEquipe.model.MembreEquipe;
import com.GestionEquipe.GestionEquipe.model.Role;
import com.GestionEquipe.GestionEquipe.model.Utilisateur;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UtilisateurRepository repository;
    private final ChefProjetRepository managerRepository;
    private final MembreEquipeRepository memberRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final IUtilisateurService userService;

    public AuthenticationResponse register(RegisterRequest request) {


        Optional<Utilisateur> utilisateur = repository.findByEmail(request.getEmail());
        if(utilisateur.isPresent()){
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setCodeError("450 : user exist");
            return authenticationResponse;
        }
        else {
            if(request.getRole() == Role.CHEFPROJET) {
                var manager = ChefProjet.builder()

                        .nom(request.getNom())
                        .prenom(request.getPrenom())
                        .login(request.getLogin())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .email(request.getEmail())
                        .cin(request.getCin())
                        .numTel(request.getNumTel())
                        .role(request.getRole())
                        .build();
                var user =  managerRepository.save(manager);
                var jwtToken = jwtService.generateToken(user, user);

                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .codeError("200")
                        .build();
            } else if(request.getRole() == Role.MEMBRE) {
                var membre = MembreEquipe.builder()

                        .nom(request.getNom())
                        .prenom(request.getPrenom())
                        .login(request.getLogin())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .email(request.getEmail())
                        .cin(request.getCin())
                        .role(request.getRole())
                        .build();
                var user =  memberRepository.save(membre);
                var jwtToken = jwtService.generateToken(user, user);

                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .codeError("200")
                        .build();
            }
            else
                return null;

        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user, user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .firstName(user.getPrenom())
                .lastName(user.getNom())
                .role(user.getRole())
                .build();
    }

	public String changePassword(ChangePasswordRequest request) {
		Utilisateur user = userService.getCurrentUser();
		boolean isTheOldPasswordIsCorrect = passwordEncoder.matches(request.getOldPassword(), user.getPassword());
		if(!isTheOldPasswordIsCorrect) {
			return "WRONG_PASSWORD";
		}
		user.setPassword(passwordEncoder.encode(request.getNewPassword()));
		userService.saveUserInDataBase(user);
		return "OK";
	}


}