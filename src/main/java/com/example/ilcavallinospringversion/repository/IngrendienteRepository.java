package com.example.ilcavallinospringversion.repository;

import com.example.ilcavallinospringversion.model.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngrendienteRepository extends JpaRepository<Ingrediente, Long> {

    List<Ingrediente> findAll();

    Ingrediente findById();
}
