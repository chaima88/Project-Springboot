package com.GestionEquipe.GestionEquipe.model;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
@Data
@SuperBuilder

@Entity

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class  Utilisateur implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private Integer numTel;
    @Column
    private Integer cin;

    @Enumerated(EnumType.STRING)
    private Role role;
    
    private String avatar;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    

    public Utilisateur(Integer id, String nom, Integer numTel,  Integer cin, String prenom, String login, String password, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.cin = cin;
        this.numTel = numTel;
        this.email = email;
    }

    public Utilisateur(Integer id, String nom, Integer numTel, Integer cin, String prenom, String login, String password, String email, Role role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.email = email;
        this.cin = cin;
        this.numTel = numTel;
        this.role = role;
    }

    public Utilisateur() {
    }
    
    @PrePersist
    public void postConstruct() {
    	this.avatar = this.prenom.charAt(0) + " " + this.nom.charAt(0);
    }

}

