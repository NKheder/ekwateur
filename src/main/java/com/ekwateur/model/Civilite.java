package com.ekwateur.model;

public enum Civilite {

    MADAME("MME"), MADEMOISELLE("MLLE"), MONSIEUR("MR");

    private final String abreviation;

    Civilite(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getAbreviation() {
        return this.abreviation;
    }
}
