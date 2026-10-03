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
    @GetMapping
    public ResponseEntity<CarrelloDTO> getCarrello(@AuthenticationPrincipal Utente utente){
        CarrelloDTO carrello = carrelloService.trovaCarrello(utente);
        return ResponseEntity.ok(carrello);
    }

    @PostMapping
    public ResponseEntity<CarrelloDTO> aggiungiAlCarrello(@AuthenticationPrincipal Utente utente, long idProdotto, int quantita) {
        CarrelloDTO carrello =  carrelloService.aggiungiAlCarrello(utente, idProdotto, quantita);
        return ResponseEntity.ok(carrello);
    }

    @DeleteMapping("/elimina/{idProdotto}")
    public ResponseEntity<CarrelloDTO> rimuoviDalCarrello(@AuthenticationPrincipal Utente utente, long idProdotto){
        CarrelloDTO carrello = carrelloService.rimuoviProdotto(utente, idProdotto);
        return ResponseEntity.ok(carrello);
    }
    @DeleteMapping("/svuota")
    public ResponseEntity<CarrelloDTO> svuotaCarrello(@AuthenticationPrincipal Utente utente){
        CarrelloDTO carrello = carrelloService.svuotaCarrello(utente);
        return ResponseEntity.ok(carrello);
    }
}
