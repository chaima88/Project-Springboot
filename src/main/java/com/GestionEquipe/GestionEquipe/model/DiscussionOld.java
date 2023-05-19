package com.GestionEquipe.GestionEquipe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;


//@Entity
//requete entre user1 et user 2 ou le contraire
public class DiscussionOld implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDicuss;
    @OneToMany(mappedBy = "discussion")
    @JsonIgnore
    private Collection<Message> message;
    @OneToOne(mappedBy = "discussion")
    @JsonIgnore
    private Equipe equipe;

    public Integer getIdDicuss() {
        return idDicuss;
    }

    public void setIdDicuss(Integer idDicuss) {
        this.idDicuss = idDicuss;
    }

    public Collection<Message> getMessage() {
        return message;
    }

    public void setMessage(Collection<Message> message) {
        this.message = message;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public DiscussionOld(Integer idDicuss, Collection<Message> message, Equipe equipe) {
        this.idDicuss = idDicuss;
        this.message = message;
        this.equipe = equipe;
    }

    public DiscussionOld() {
    }
}