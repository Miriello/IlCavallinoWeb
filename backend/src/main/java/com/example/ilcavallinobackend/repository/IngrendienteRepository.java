package com.example.ilcavallinobackend.repository;

import com.example.ilcavallinobackend.model.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IngrendienteRepository extends JpaRepository<Ingrediente, Long> {

}
