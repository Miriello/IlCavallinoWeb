package com.example.ilcavallinobackend.repository;

import com.example.ilcavallinobackend.model.entity.Ruolo;
import com.example.ilcavallinobackend.model.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Long> {
    List<Utente> findAll();
    Utente findById(long id);
    Utente findByUsername(String username);
    Utente findByRuolo(Ruolo ruolo);
    Utente findByEmail(String email);
}
