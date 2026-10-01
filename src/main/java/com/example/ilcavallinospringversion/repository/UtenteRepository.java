package com.example.ilcavallinospringversion.repository;

import com.example.ilcavallinospringversion.model.entity.Ruolo;
import com.example.ilcavallinospringversion.model.entity.Utente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteRepository {
    List<Utente> findAll();
    Utente findById(long id);
    Utente findByUsername(String username);
    Utente findByRole(Ruolo ruolo);
    Utente findByEmail(String email);
}
