package com.example.ilcavallinospringversion.repository;

import com.example.ilcavallinospringversion.model.entity.Allergene;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllergeneRepository extends JpaRepository<Allergene, Long> {

    Allergene findByNome(String nome);
    Allergene findById(long id);
    List<Allergene> findAll();
    List<Allergene> findByIngrediente(long idIngrediente);
}
