package com.ekwateur.service;


import com.ekwateur.model.*;
import com.ekwateur.repository.ClientRepository;
import com.ekwateur.repository.EnergieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.Year;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    EnergieRepository energieRepository;

    public List<Client> listClients() {
        return clientRepository.findAll();
    }

    public List<Energie> listEnergiesByClient(Client client) {
        return energieRepository.findByClient(client);
    }

    public List<Energie> listEnergiesByClientMonth(Client client, Month month) {
        return energieRepository.findByClientMonth(client, month);
    }

    public List<Energie> listEnergiesByClientMonthYear(Client client, Month month, Year year) {
        return energieRepository.findByClientMonthYear(client, month, year);
    }

    public void createData() {
        Client particulier = new Particulier("EKW00000001", Civilite.MONSIEUR, "NOA", "Khed");
        Energie energie1 = new Energie(particulier, Month.AUGUST, Year.now(), 130, 70);
        Energie energie2 = new Energie(particulier, Month.JANUARY, Year.now(), 190, 80);

        Client pro1 = new Pro("EKW00000002", 36252187900034L, "SCEA Dupont", 800000);
        Energie energie3 = new Energie(pro1, Month.SEPTEMBER, Year.now(), 830, 650);

        Client pro2 = new Pro("EKW00000003", 36252187900055L, "SCM Centre medical", 1800000);
        Energie energie4 = new Energie(pro2, Month.SEPTEMBER, Year.now(), 830, 650);

        clientRepository.saveAll(List.of(particulier, pro1, pro2));
        energieRepository.saveAll(List.of(energie1, energie2, energie3, energie4));
    }
}
