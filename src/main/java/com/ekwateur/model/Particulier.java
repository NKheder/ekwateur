package com.ekwateur.model;

import jakarta.persistence.*;

@Entity
@Table(name = "particulier")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Particulier extends Client {

    @Enumerated(EnumType.STRING)
    private Civilite civilite;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;

    public Particulier() {
    }

    public Particulier(String reference, Civilite civilite, String nom, String prenom) {
        super(reference);
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
