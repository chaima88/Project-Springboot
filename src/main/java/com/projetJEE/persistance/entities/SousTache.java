package com.projetJEE.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;




@Entity
public class SousTache implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSousTache;
    @Column
    private Date dateDebSTache;
    @Column
    private Date echeance;
    @Column
    private String descriptSTache;
    @Column
    private String etatSTache;

    @Column
    private Integer tauxAvancement;
    @Column
    private String titreSTache;
    @ManyToOne
    @JoinColumn(name = "idTache")
    Tache tache;

    public Integer getIdSousTache() {
        return idSousTache;
    }

    public void setIdSousTache(Integer idSousTache) {
        this.idSousTache = idSousTache;
    }

    public Date getDateDebSTache() {
        return dateDebSTache;
    }

    public void setDateDebSTache(Date dateDebSTache) {
        this.dateDebSTache = dateDebSTache;
    }

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }


    public String getDescriptSTache() {
        return descriptSTache;
    }

    public void setDescriptSTache(String descriptSTache) {
        this.descriptSTache = descriptSTache;
    }

    public String getEtatSTache() {
        return etatSTache;
    }

    public void setEtatSTache(String etatSTache) {
        this.etatSTache = etatSTache;
    }




    public Integer getTauxAvancement() {
        return tauxAvancement;
    }

    public void setTauxAvancement(Integer tauxAvancement) {
        this.tauxAvancement = tauxAvancement;
    }

    public String getTitreSTache() {
        return titreSTache;
    }

    public void setTitreSTache(String titreSTache) {
        this.titreSTache = titreSTache;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public SousTache() {
    }

    public SousTache(Integer idSousTache, Date dateDebSTache, Date echeance, String descriptSTache, String etatSTache, String priorité, Integer tauxAvancement, String titreSTache, Tache tache) {
        this.idSousTache = idSousTache;
        this.dateDebSTache = dateDebSTache;
        this.echeance = echeance;
        this.descriptSTache = descriptSTache;
        this.etatSTache = etatSTache;

        this.tauxAvancement = tauxAvancement;
        this.titreSTache = titreSTache;
        this.tache = tache;
    }
}




