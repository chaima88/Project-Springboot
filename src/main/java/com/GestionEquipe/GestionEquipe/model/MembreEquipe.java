package com.GestionEquipe.GestionEquipe.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembreEquipe extends Utilisateur {

	@Column
	private Integer matricule;


//    @OneToMany(mappedBy = "membre")
//    @JsonIgnore
//    private Collection<Message> message;
	@ManyToMany(mappedBy = "membree", fetch = FetchType.EAGER)
	private Collection<Penalisation> penalisations = new ArrayList<>();
	@ManyToMany(mappedBy = "memb", fetch = FetchType.EAGER)
	private Collection<Recompense> recompenses = new ArrayList<>();
	@ManyToMany(mappedBy = "membr", fetch = FetchType.EAGER)
	private Collection<Notification> notifications = new ArrayList<>();
	@ManyToOne
	private Equipe equipe;
}