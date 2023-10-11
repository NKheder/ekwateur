package com.ekwateur;

import com.ekwateur.model.Client;
import com.ekwateur.model.Particulier;
import com.ekwateur.model.Pro;
import com.ekwateur.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DecimalFormat;

@SpringBootApplication
public class EkwateurApplication implements CommandLineRunner {

    @Autowired
    ClientService clientService;
    public static final float PARTICULIER_GAZ = 0.115f;
    public static final float PARTICULIER_ELECTRICITY = 0.121f;
    public static final float CA_SUP_GAZ = 0.111f;
    public static final float CA_SUP_ELECTRICITY = 0.114f;
    public static final float CA_INF_GAZ = 0.113f;
    public static final float CA_INF_ELECTRICITY = 0.118f;
    public static final int CA = 1000000;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EkwateurApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    @Override
    public void run(String... args) {
        clientService.createData();
        Iterable<Client> clients = clientService.listClients();
        clients.forEach(this::calculFacture);
    }

    public void calculFacture(Client client) {
        DecimalFormat df = new DecimalFormat("0.00");
        if (client instanceof Particulier) {
            client.getEnergies().forEach(
                    energie ->
                            System.out.println(((Particulier) client).getNom() + " " + energie.getMonth() + "/" + energie.getYear() + " : " +
                                    df.format(energie.getGaz() * PARTICULIER_GAZ + energie.getElectricity() * PARTICULIER_ELECTRICITY) + " euros"));
        } else if (((Pro) client).getCa() > CA) {
            client.getEnergies().forEach(
                    energie ->
                            System.out.println(((Pro) client).getNumSIRET() + " " + energie.getMonth() + "/" + energie.getYear() + " : " +
                                    df.format(energie.getGaz() * CA_SUP_GAZ + energie.getElectricity() * CA_SUP_ELECTRICITY) + " euros"));
        } else if (((Pro) client).getCa() <= CA) {
            client.getEnergies().forEach(
                    energie ->
                            System.out.println(((Pro) client).getNumSIRET() + " " + energie.getMonth() + "/" + energie.getYear() + " : " +
                                    df.format(energie.getGaz() * CA_INF_GAZ + energie.getElectricity() * CA_INF_ELECTRICITY) + " euros"));
        }
    }
}
