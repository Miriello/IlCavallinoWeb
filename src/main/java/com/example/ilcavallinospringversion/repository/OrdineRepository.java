package com.example.ilcavallinospringversion.repository;

import com.example.ilcavallinospringversion.model.entity.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;

public interface OrdineRepository extends JpaRepository<Ordine,Long> {
    List<Ordine> findAll();
    Ordine findById(long id);
    List<Ordine> findByUtente(long idUtente);
    List<Ordine> findByDate(LocalDate data);
    Ordine upload(long id, Ordine ordine);
    void deleteById(long id);
}
