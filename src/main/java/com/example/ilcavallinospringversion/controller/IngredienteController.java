package com.example.ilcavallinospringversion.controller;

import com.example.ilcavallinospringversion.model.dto.IngredienteDTO;
import com.example.ilcavallinospringversion.model.entity.Ingrediente;
import com.example.ilcavallinospringversion.service.IngredienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ingredienti")
public class IngredienteController {
    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService){
        this.ingredienteService=ingredienteService;
    }

    public ResponseEntity<List<IngredienteDTO>> getIngredienti(){
        List<IngredienteDTO> ingredienti = ingredienteService.getIngredienti();
        return ResponseEntity.ok(ingredienti);

    }
    @RequestMapping("/{id}")
    @PreAuthorize("hasAnyRole('CUCINA','SOCIO','ADMIN')")
    public ResponseEntity<IngredienteDTO> getIngrediente(@PathVariable long id){
        IngredienteDTO ingrediente= ingredienteService.getIngrediente(id);
        return ResponseEntity.ok(ingrediente);
    }
    @PostMapping
    @PreAuthorize("hasAnyRole('CUCINA','SOCIO','ADMIN')")
    public  ResponseEntity<IngredienteDTO> aggiungiIngrediente(@RequestBody IngredienteDTO ingredienteDTO){
        IngredienteDTO nuovo= ingredienteService.aggiungiIngrediente(ingredienteDTO);
        return ResponseEntity.ok(nuovo);

    }
    @PutMapping
    @PreAuthorize("hasAnyRole('CUCINA','SOCIO','ADMIN')")
    public  ResponseEntity<IngredienteDTO> aggiornaIngrediente(@PathVariable long id, @RequestBody IngredienteDTO ingredienteDTO){
        IngredienteDTO modificato = ingredienteService.aggiornaIngrediente(id, ingredienteDTO);
        return ResponseEntity.ok(modificato);
    }
    @DeleteMapping
    @PreAuthorize("hasAnyRole('CUCINA','SOCIO','ADMIN')")
    public void eliminaIngrediente(@PathVariable long id){
        ingredienteService.eliminaIngrediente(id);
    }
}
