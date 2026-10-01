package com.example.ilcavallinospringversion.repository;

import com.example.ilcavallinospringversion.model.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto,Long>{
    Prodotto upload(long id, Prodotto p);
}
