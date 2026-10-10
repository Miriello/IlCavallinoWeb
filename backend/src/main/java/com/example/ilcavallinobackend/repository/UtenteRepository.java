package com.example.ilcavallinobackend.repository;

import com.example.ilcavallinobackend.model.entity.Ruolo;
import com.example.ilcavallinobackend.model.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Long> {
    List<Utente> findAll();
    Optional<Utente> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Utente findByRuolo(Ruolo ruolo);
    Utente findByEmail(String email);
}
