package com.GestionEquipe.GestionEquipe.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;




@Entity
public class SousTache implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSousTache;
    @Column
    private Date dateDebSTache;
    @Column
    private Date echéance;
    @Column
    private String descriptSTache;
    @Column
    private String etatSTache;
    @Column
    private String priorité;
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

    public Date getEchéance() {
        return echéance;
    }

    public void setEchéance(Date echéance) {
        this.echéance = echéance;
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

    public String getPriorité() {
        return priorité;
    }

    public void setPriorité(String priorité) {
        this.priorité = priorité;
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

    public SousTache(Integer idSousTache, Date dateDebSTache, Date echéance, String descriptSTache, String etatSTache, String priorité, Integer tauxAvancement, String titreSTache, Tache tache) {
        this.idSousTache = idSousTache;
        this.dateDebSTache = dateDebSTache;
        this.echéance = echéance;
        this.descriptSTache = descriptSTache;
        this.etatSTache = etatSTache;
        this.priorité = priorité;
        this.tauxAvancement = tauxAvancement;
        this.titreSTache = titreSTache;
        this.tache = tache;
    }
}




