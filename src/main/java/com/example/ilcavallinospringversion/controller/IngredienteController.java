package com.example.ilcavallinospringversion.controller;

import com.example.ilcavallinospringversion.model.dto.IngredienteDTO;
import com.example.ilcavallinospringversion.service.IngredienteService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ingredienti")
public class IngredienteController {
    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService){
        this.ingredienteService=ingredienteService;
    }
    public void getIngredienti(){

    }
    @RequestMapping("/{id}")
    public void getIngrediente(@PathVariable long id){

    }
    public void aggiungiIngrediente(@RequestBody IngredienteDTO ingredienteDTO){

    }

    public void aggiornaIngrediente(@PathVariable long id, @RequestBody IngredienteDTO ingredienteDTO){

    }

    public void rimuoviIngrediente(@PathVariable long id){

    }
}
