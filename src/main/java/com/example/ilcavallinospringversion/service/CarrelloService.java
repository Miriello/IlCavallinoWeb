package com.example.ilcavallinospringversion.service;

import com.example.ilcavallinospringversion.model.dto.CarrelloDTO;
import com.example.ilcavallinospringversion.model.entity.Carrello;
import com.example.ilcavallinospringversion.model.entity.Prodotto;
import com.example.ilcavallinospringversion.model.entity.Utente;
import com.example.ilcavallinospringversion.repository.CarrelloRepository;
import com.example.ilcavallinospringversion.repository.ProdottoRepository;
import com.example.ilcavallinospringversion.model.entity.RigaCarrello;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarrelloService {

    private final CarrelloRepository carrelloRepository;
    private final ProdottoRepository prodottoRepository;

    public CarrelloService(CarrelloRepository carrelloRepository, ProdottoRepository prodottoRepository){
        this.carrelloRepository= carrelloRepository;
        this.prodottoRepository=prodottoRepository;
    }

    @Transactional
    public CarrelloDTO trovaCarrello(Utente utente){
       return toDTO(carrelloRepository.findByUtente(utente));
    }

    @Transactional
    public CarrelloDTO aggiungiAlCarrello(Utente utente, long idProdotto, int unita){
        Prodotto prodotto = prodottoRepository.findById(idProdotto).orElseThrow(() -> new IllegalArgumentException("Prodotto non trovato"));
        Carrello carrello = carrelloRepository.findByUtente(utente);
        if(carrello.prodottoPresente(prodotto)){
           carrello.modificaQuantita(prodotto, carrello.getQuantitaProdotto(prodotto)+unita);
        }
        else{
            carrello.aggiungiRiga(new RigaCarrello(prodotto,unita,prodotto.getPrezzo()));
        }
        Carrello nuovo = carrelloRepository.save(carrello);
        CarrelloDTO nuovoDTO = toDTO(nuovo);
        return nuovoDTO;
    }

    @Transactional
    public CarrelloDTO rimuoviProdotto(Utente utente, long idProdotto){
        Carrello carrello = carrelloRepository.findByUtente(utente);
        Prodotto prodotto = prodottoRepository.findById(idProdotto).orElseThrow(()-> new IllegalArgumentException("Prodotto non trovato"));
        if(carrello.prodottoPresente(prodotto)){
            carrello.rimuoviRiga(prodotto);
            CarrelloDTO modificato = toDTO(carrelloRepository.save(carrello));
            return modificato;
        }
        else {
            return toDTO(carrello);
        }
    }
    @Transactional
    public CarrelloDTO svuotaCarrello(Utente utente){
        Carrello carrello= carrelloRepository.findByUtente(utente);
        carrello.setElenco(new ArrayList<>());
        return toDTO(carrelloRepository.save(carrello));
    }


    public CarrelloDTO toDTO(Carrello carrello){
        CarrelloDTO carrelloDTO = new CarrelloDTO();
        carrelloDTO.setId(carrello.getId());
        carrelloDTO.setElenco(carrello.getElenco());
        carrelloDTO.setUsername(carrello.getUtente().getUsername());
        return carrelloDTO;
    }
}
