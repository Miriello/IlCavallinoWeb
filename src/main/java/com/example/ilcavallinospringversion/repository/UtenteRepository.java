package com.example.ilcavallinospringversion.repository;

import com.example.ilcavallinospringversion.model.entity.Ruolo;
import com.example.ilcavallinospringversion.model.entity.Utente;
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
