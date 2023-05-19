package com.GestionEquipe.GestionEquipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.GestionEquipe.GestionEquipe.ServicesImpl.AdministrateurService;
import com.GestionEquipe.GestionEquipe.ServicesImpl.UtilisateurService;
import com.GestionEquipe.GestionEquipe.model.Administrateur;
import com.GestionEquipe.GestionEquipe.model.Role;
import com.GestionEquipe.GestionEquipe.model.Utilisateur;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class GestionEquipeApplication {
	
	@Autowired
	private AdministrateurService adminService;
	@Autowired
	private UtilisateurService userService;

	public static void main(String[] args) {
		SpringApplication.run(GestionEquipeApplication.class, args);
	}

	@PostConstruct
	public void initAdmins() {
		if(adminService.findByEmail("admin1@gestio-equipes.com") == null) {
			Administrateur admin1 = Administrateur.builder().email("admin1@gestio-equipes.com")
					.login("admin-001")
					.nom("Admin")
					.prenom("Admin")
					.password("Admin2023%1")
					.role(Role.ADMIN)
					.build();
			adminService.saveAdmin(admin1);
		}
		if(adminService.findByEmail("admin2@gestio-equipes.com") == null) {
			Administrateur admin2 = Administrateur.builder().email("admin2@gestio-equipes.com")
					.login("admin-002")
					.nom("Admin")
					.prenom("Admin")
					.password("Admin2023%2")
					.role(Role.ADMIN)
					.build();
			adminService.saveAdmin(admin2);
		}
		
	}
}
