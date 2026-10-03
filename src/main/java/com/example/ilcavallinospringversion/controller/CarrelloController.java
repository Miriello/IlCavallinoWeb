package com.example.ilcavallinospringversion.controller;

import com.example.ilcavallinospringversion.model.dto.CarrelloDTO;
import com.example.ilcavallinospringversion.model.entity.Utente;
import com.example.ilcavallinospringversion.service.CarrelloService;
import com.example.ilcavallinospringversion.service.UtenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public void getCarrello(@AuthenticationPrincipal Utente utente){
        carrelloService.trovaCarrello(utente);
    }

    @PostMapping
    public void aggiungiAlCarrello(@AuthenticationPrincipal Utente utente, long idProdotto, int quantita) {
        carrelloService.aggiungiAlCarrello(utente, idProdotto, quantita);
    }

    @DeleteMapping
    public void rimuoviDalCarrello(@AuthenticationPrincipal Utente utente, long idProdotto){
        carrelloService.rimuoviProdotto(utente, idProdotto);
    }

    public ResponseEntity<CarrelloDTO> svuotaCarrello(@AuthenticationPrincipal Utente utente){
       return carrelloService.svuotaCarrello(utente);
    }
}
