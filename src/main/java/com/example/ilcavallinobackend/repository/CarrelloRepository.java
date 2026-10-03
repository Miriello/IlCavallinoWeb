package com.example.ilcavallinobackend.repository;

import com.example.ilcavallinobackend.model.entity.Carrello;
import com.example.ilcavallinobackend.model.entity.Utente;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
    Carrello findByUtente(Utente utente);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT c FROM Carrello c WHERE c.utente = :utente")
    Carrello attivaLock(@Param("utente") Utente utente);
}
