package com.example.ilcavallinobackend.repository;

import com.example.ilcavallinobackend.model.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IngrendienteRepository extends JpaRepository<Ingrediente, Long> {

    List<Ingrediente> findAll();
    Ingrediente findById();
    List<Ingrediente> findByPiatto(long idPiatto);
    @Query("SELECT i FROM ingredienti i WHERE i.scadenza < :data")
    List<Ingrediente> findScaduti(@Param("data")LocalDate data);
    Ingrediente upload(long id, Ingrediente i);
    Ingrediente save(Ingrediente i);
}
