package com.example.ilcavallinospringversion.controller;

import com.example.ilcavallinospringversion.service.AllergeneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/allergeni")
public class AllergeneController {
    private final AllergeneService allergeneService;

    public AllergeneController(AllergeneService allergeneService){
        this.allergeneService=allergeneService;
    }
    @RequestMapping
    public void getAllergeni(){

    }
    @RequestMapping
    public void getAllergene(@PathVariable long id){

    }
    @PostMapping
    public void aggiungiAllergene(){

    }
    @PutMapping
    public void aggiornaAllergene(){

    }
    @DeleteMapping
    public void eliminaAllergene(@PathVariable long id){

    }
}
