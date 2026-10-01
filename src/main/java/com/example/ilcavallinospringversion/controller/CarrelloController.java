package com.example.ilcavallinospringversion.controller;

import com.example.ilcavallinospringversion.service.CarrelloService;
import com.example.ilcavallinospringversion.service.UtenteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/carrello")
public class CarrelloController {
    private final CarrelloService carrelloService;
    private final UtenteService utenteService;

    public CarrelloController(CarrelloService carrelloService, UtenteService utenteService){
        this.carrelloService=carrelloService;
        this.utenteService=utenteService;
    }
    @RequestMapping
    public void getCarrello(@PathVariable long id){

    }

    @PostMapping
    public void aggiungiAlCarrello() {

    }

    @PutMapping
    public void aggiornaCarrello(){

    }

    @DeleteMapping
    public void rimuoviDalCarrello(){

    }
}
