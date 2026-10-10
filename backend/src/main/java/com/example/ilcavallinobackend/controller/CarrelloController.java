package com.example.ilcavallinobackend.controller;

import com.example.ilcavallinobackend.model.dto.CarrelloDTO;
import com.example.ilcavallinobackend.model.entity.Utente;
import com.example.ilcavallinobackend.service.CarrelloService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
@PreAuthorize("hasRole('USER')")
@RestController
@RequestMapping("api/carrello")
public class CarrelloController {
    private final CarrelloService carrelloService;

    public CarrelloController(CarrelloService carrelloService){
        this.carrelloService=carrelloService;
    }
    @GetMapping
    public ResponseEntity<CarrelloDTO> getCarrello(@AuthenticationPrincipal Utente utente){
        CarrelloDTO carrello = carrelloService.trovaCarrello(utente);
        return ResponseEntity.ok(carrello);
    }

    @PostMapping
    public ResponseEntity<CarrelloDTO> aggiungiAlCarrello(@AuthenticationPrincipal Utente utente, @RequestParam long idProdotto, @RequestParam int quantita) {
        CarrelloDTO carrello =  carrelloService.aggiungiAlCarrello(utente, idProdotto, quantita);
        return ResponseEntity.ok(carrello);
    }

    @DeleteMapping("/elimina/{idProdotto}")
    public ResponseEntity<CarrelloDTO> rimuoviDalCarrello(@AuthenticationPrincipal Utente utente, @PathVariable long idProdotto){
        CarrelloDTO carrello = carrelloService.rimuoviProdotto(utente, idProdotto);
        return ResponseEntity.ok(carrello);
    }
    @DeleteMapping("/svuota")
    public ResponseEntity<CarrelloDTO> svuotaCarrello(@AuthenticationPrincipal Utente utente){
        CarrelloDTO carrello = carrelloService.svuotaCarrello(utente);
        return ResponseEntity.ok(carrello);
    }
}
