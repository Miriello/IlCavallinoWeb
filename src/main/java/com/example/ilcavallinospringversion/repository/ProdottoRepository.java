package com.example.ilcavallinospringversion.repository;

import com.example.ilcavallinospringversion.model.entity.Prodotto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository {
    Prodotto findById(long id);
    List<Prodotto> findAll();
    Prodotto save(Prodotto p);
    Prodotto upload(long id, Prodotto p);
    void delete(long id);

}
