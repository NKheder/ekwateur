package com.ekwateur.repository;


import com.ekwateur.model.Client;
import com.ekwateur.model.Energie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.time.Year;
import java.util.List;

@Repository

public interface EnergieRepository extends JpaRepository<Energie, Long> {
    List<Energie> findByClient(Client client);

    @Query("SELECT e FROM Energie e " +
            "WHERE e.client = :client and e.month = :month")
    List<Energie> findByClientMonth(Client client, Month month);

    @Query("SELECT e FROM Energie e " +
            "WHERE e.client = :client and e.month = :month and e.year = :year")
    List<Energie> findByClientMonthYear(Client client, Month month, Year year);

}
