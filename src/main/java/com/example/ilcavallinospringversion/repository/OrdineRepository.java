package com.example.ilcavallinospringversion.repository;

import com.example.ilcavallinospringversion.model.entity.Ordine;
import com.example.ilcavallinospringversion.model.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;

public interface OrdineRepository extends JpaRepository<Ordine,Long> {
    List<Ordine> findByUtente(Utente utente);
    List<Ordine> findByData(LocalDate data);
    Ordine upload(long id, Ordine ordine);
}
