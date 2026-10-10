package com.example.ilcavallinobackend.controller;

import com.example.ilcavallinobackend.model.dto.AllergeneDTO;
import com.example.ilcavallinobackend.service.AllergeneService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/allergeni")
public class AllergeneController {

    private final AllergeneService allergeneService;

    public AllergeneController(AllergeneService allergeneService){
        this.allergeneService=allergeneService;
    }

    @GetMapping
    public ResponseEntity<List<AllergeneDTO>> getAllergeni(){
        List<AllergeneDTO> allergeni = allergeneService.getAllergeni();
        return ResponseEntity.ok(allergeni);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<AllergeneDTO> getAllergene(@PathVariable long id){
       AllergeneDTO allergene = allergeneService.getAllergene(id);
       return ResponseEntity.ok(allergene);
    }
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<AllergeneDTO> aggiungiAllergene(@Valid @RequestBody AllergeneDTO allergeneDTO){
        AllergeneDTO nuovo = allergeneService.aggiungiAllergene(allergeneDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<AllergeneDTO> aggiornaAllergene(@PathVariable long id, @Valid @RequestBody AllergeneDTO allergeneDTO ){
        AllergeneDTO modificato = allergeneService.aggiornaAllergene(id,allergeneDTO);
        return ResponseEntity.ok(modificato);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void eliminaAllergene(@PathVariable long id){
        allergeneService.eliminaAllergene(id);
    }
}
