package com.example.ilcavallinospringversion.controller;

import com.example.ilcavallinospringversion.model.dto.CarrelloDTO;
import com.example.ilcavallinospringversion.service.CarrelloService;
import com.example.ilcavallinospringversion.service.UtenteService;
import org.springframework.http.ResponseEntity;
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
        carrelloService.trovaCarrello(id);
    }

    @PostMapping
    public void aggiungiAlCarrello(ProdottoDTO prodottoDTO) {
        carrelloService.aggiungiAlCarrello(prodottoDTO);
    }

    @PutMapping
    public void aggiornaCarrello(CarrelloDTO carrelloDTO){
        carrelloService.aggiornaCarrello(carrelloDTO);
    }

    @DeleteMapping
    public void rimuoviDalCarrello(long idProdotto){
        carrelloService.rimuoviProdotto(id);
    }

    public ResponseEntity<CarrelloDTO> svuotaCarrello(long idCarrello){
       return carrelloService.svuotaCarrello(idCarrello);
    }
}
