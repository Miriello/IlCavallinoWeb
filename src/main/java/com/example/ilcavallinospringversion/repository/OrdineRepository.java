package com.example.ilcavallinospringversion.repository;

import com.example.ilcavallinospringversion.model.entity.Ordine;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrdineRepository {
    List<Ordine> findAll();
    Ordine findById();
    List<Ordine> findByUtente(long idUtente);
    List<Ordine> findByDate(LocalDate data);
    @Query
}
