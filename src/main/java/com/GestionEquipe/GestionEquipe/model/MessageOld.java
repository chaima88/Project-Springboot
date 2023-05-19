package com.GestionEquipe.GestionEquipe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;


//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageOld implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMsg;
    @Column
    private String destinataire;
    @Column
    private Date dateCreation;

//    @ManyToOne
//    Discussion discussion;
    @ManyToOne
    @JoinColumn(name = "idMemb")
    MembreEquipe membre;
    @Column
    private String texteMsg;
    @Column
    private String destinateur;

    
}
