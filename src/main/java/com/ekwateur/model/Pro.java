package com.ekwateur.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pro")
public class Pro extends Client {

    @Column(name = "numSIRET")
    private long numSIRET;
    @Column(name = "raisonSociale")
    private String raisonSociale;
    @Column(name = "ca")
    private long ca;

    public Pro() {
    }

    public Pro(String reference, long numSIRET, String raisonSociale, long ca) {
        super(reference);
        this.numSIRET = numSIRET;
        this.raisonSociale = raisonSociale;
        this.ca = ca;
    }

    public long getNumSIRET() {
        return numSIRET;
    }

    public void setNumSIRET(long numSIRET) {
        this.numSIRET = numSIRET;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public long getCa() {
        return ca;
    }

    public void setCa(long ca) {
        this.ca = ca;
    }
}
