package com.ekwateur.model;

import jakarta.persistence.*;

import java.time.Month;
import java.time.Year;


@Entity
@Table(name = "energie")
public class Energie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_ref", nullable = false)
    private Client client;
    @Column(name = "month")
    private Month month;
    @Column(name = "year")
    private Year year;
    @Column(name = "electricity")
    private int electricity;
    @Column(name = "gaz")
    private int gaz;

    public Energie() {
    }

    public Energie(Client client, Month month, Year year, int electricity, int gaz) {
        this.client = client;
        this.month = month;
        this.year = year;
        this.electricity = electricity;
        this.gaz = gaz;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }

    public int getGaz() {
        return gaz;
    }

    public void setGaz(int gaz) {
        this.gaz = gaz;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
}
