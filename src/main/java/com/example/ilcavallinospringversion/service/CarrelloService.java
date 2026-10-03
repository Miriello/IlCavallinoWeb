package com.example.ilcavallinospringversion.service;

import com.example.ilcavallinospringversion.model.dto.CarrelloDTO;
import com.example.ilcavallinospringversion.model.entity.Carrello;
import com.example.ilcavallinospringversion.model.entity.Prodotto;
import com.example.ilcavallinospringversion.model.entity.Utente;
import com.example.ilcavallinospringversion.repository.CarrelloRepository;
import com.example.ilcavallinospringversion.repository.ProdottoRepository;
import com.example.ilcavallinospringversion.utility.RigaCarrello;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrelloService {

    private final CarrelloRepository carrelloRepository;
    private final ProdottoRepository prodottoRepository;

    public CarrelloService(CarrelloRepository carrelloRepository, ProdottoRepository prodottoRepository){
        this.carrelloRepository= carrelloRepository;
        this.prodottoRepository=prodottoRepository;
    }

    public CarrelloDTO trovaCarrello(Utente utente){
       return toDTO(carrelloRepository.findByUtente(utente));
    }

    public CarrelloDTO svuotaCarrello(long idCarrello){
        CarrelloDTO c = new CarrelloDTO();
        carrelloRepository.delete(carrelloRepository.findById(idCarrello));
        return c;
    }

    public CarrelloDTO aggiungiAlCarrello(Utente utente, long idProdotto, int unita){
        Prodotto prodotto = prodottoRepository.findById(idProdotto).orElseThrow(() -> new IllegalArgumentException("Prodotto non trovato"));
        CarrelloDTO carrelloDTO = toDTO(carrelloRepository.findByUtente(utente));
        if(carrelloDTO.prodottoPresente(prodotto)){
           carrelloDTO.modificaQuantita(prodotto, carrelloDTO.getQuantitaProdotto(prodotto)+unita);
        }
        else{
            carrelloDTO.aggiungiRiga(new RigaCarrello(prodotto,unita,prodotto.getPrezzo()));
        }
        Carrello nuovo = carrelloRepository.save(toEntity(carrelloDTO));
        CarrelloDTO nuovoDTO = toDTO(nuovo);
        return nuovoDTO;
    }


    public CarrelloDTO rimuoviProdotto(Utente utente, long idProdotto){
        CarrelloDTO carrelloDTO = toDTO(carrelloRepository.findByUtente(utente));
        Prodotto prodotto = prodottoRepository.findById(idProdotto).orElseThrow(()-> new IllegalArgumentException("Prodotto non trovato"));
        if(carrelloDTO.prodottoPresente(prodotto)){
            carrelloDTO.rimuoviRiga(prodotto);
            CarrelloDTO modificato = toDTO(carrelloRepository.save(toEntity(carrelloDTO)));
            return modificato;
        }
        else {
            return carrelloDTO;
        }
    }

    public CarrelloDTO svuotaCarrello(Utente utente){
        CarrelloDTO nuovo = new CarrelloDTO();
        nuovo.setUtente(utente);
        carrelloRepository.save(toEntity(nuovo));
        return nuovo;
    }

    public Carrello toEntity(CarrelloDTO carrelloDTO){
        Carrello c = new Carrello();
        c.setId(carrelloDTO.getId());
        c.setElenco((carrelloDTO.getElenco()));
        c.setUtente(carrelloDTO.getUtente());
        return c;
    }

    public CarrelloDTO toDTO(Carrello carrello){
        CarrelloDTO carrelloDTO = new CarrelloDTO();
        carrelloDTO.setId(carrello.getId());
        carrelloDTO.setElenco(carrello.getElenco());
        carrelloDTO.setUtente(carrello.getUtente());
        return carrelloDTO;
    }
}
