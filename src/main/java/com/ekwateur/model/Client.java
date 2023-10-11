package com.ekwateur.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Client {
    @Id
    @Column(length = 11)
    private String reference;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "client_ref")
    private final List<Energie> energies = new ArrayList<>();

    public Client() {
    }

    public Client(String reference) {
        setReference(reference);
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        if (verifyID(reference)) {
            this.reference = reference;
        } else {
            throw new RuntimeException("La reference client doit commencer par EKW et contient 8 caractères numériques ");
        }
    }

    private boolean verifyID(String id) {
        return id != null && id.length() == 11 && id.startsWith("EKW") && id.substring(3).matches("\\d+");
    }

    public List<Energie> getEnergies() {
        return energies;
    }
}
