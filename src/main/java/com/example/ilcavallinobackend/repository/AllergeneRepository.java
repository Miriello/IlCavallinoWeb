package com.example.ilcavallinobackend.repository;

import com.example.ilcavallinobackend.model.entity.Allergene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AllergeneRepository extends JpaRepository<Allergene, Long> {

    @Query("SELECT a FROM allergeni a JOIN ingredienti i WHERE a.id = i.allergene AND i.id= :idIngrediente")
    List<Allergene> findByIngrediente(long idIngrediente);
}
