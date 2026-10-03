package com.example.ilcavallinospringversion.repository;

import com.example.ilcavallinospringversion.model.entity.Carrello;
import com.example.ilcavallinospringversion.model.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
    void delete(Optional<Carrello> byId);
    Carrello deleteProdottoByIdProdotto(long idProdotto);
    Carrello findByUtente(Utente utente);
}
