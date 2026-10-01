package com.example.ilcavallinospringversion.repository;

import com.example.ilcavallinospringversion.model.entity.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {

    Carrello findById(long id);
    void clear(long id);
}
