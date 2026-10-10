package com.example.ilcavallinobackend.controller;

import com.example.ilcavallinobackend.model.dto.IngredienteDTO;
import com.example.ilcavallinobackend.service.IngredienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ingredienti")
public class IngredienteController {
    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService){
        this.ingredienteService=ingredienteService;
    }

    @GetMapping
    public ResponseEntity<List<IngredienteDTO>> getIngredienti(){
        List<IngredienteDTO> ingredienti = ingredienteService.getIngredienti();
        return ResponseEntity.ok(ingredienti);

    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<IngredienteDTO> getIngrediente(@PathVariable long id){
        IngredienteDTO ingrediente= ingredienteService.getIngrediente(id);
        return ResponseEntity.ok(ingrediente);
    }
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public  ResponseEntity<IngredienteDTO> aggiungiIngrediente(@RequestBody IngredienteDTO ingredienteDTO){
        IngredienteDTO nuovo= ingredienteService.aggiungiIngrediente(ingredienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo);

    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public  ResponseEntity<IngredienteDTO> aggiornaIngrediente(@PathVariable long id, @RequestBody IngredienteDTO ingredienteDTO){
        IngredienteDTO modificato = ingredienteService.aggiornaIngrediente(id, ingredienteDTO);
        return ResponseEntity.ok(modificato);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void eliminaIngrediente(@PathVariable long id){
        ingredienteService.eliminaIngrediente(id);
    }
}
