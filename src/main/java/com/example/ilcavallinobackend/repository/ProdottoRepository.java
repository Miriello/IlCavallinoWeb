package com.example.ilcavallinobackend.repository;

import com.example.ilcavallinobackend.model.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto,Long>{
    Prodotto upload(long id, Prodotto p);
}
