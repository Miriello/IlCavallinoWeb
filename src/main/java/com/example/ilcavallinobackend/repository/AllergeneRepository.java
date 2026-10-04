package com.example.ilcavallinobackend.repository;

import com.example.ilcavallinobackend.model.entity.Allergene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AllergeneRepository extends JpaRepository<Allergene, Long> {

    @Query("SELECT a FROM ingredienti i JOIN i.allergeni a WHERE i.id = :idIngrediente")
    List<Allergene> findByIngrediente(@Param("idIngrediente")long idIngrediente);
}
