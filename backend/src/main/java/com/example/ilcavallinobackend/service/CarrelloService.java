package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.mapper.CarrelloMapper;
import com.example.ilcavallinobackend.model.dto.CarrelloDTO;
import com.example.ilcavallinobackend.model.entity.Carrello;
import com.example.ilcavallinobackend.model.entity.Prodotto;
import com.example.ilcavallinobackend.model.entity.Utente;
import com.example.ilcavallinobackend.repository.CarrelloRepository;
import com.example.ilcavallinobackend.repository.ProdottoRepository;
import com.example.ilcavallinobackend.model.entity.RigaCarrello;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


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
       return CarrelloMapper.toDTO(carrelloRepository.findByUtente(utente));
    }

    @Transactional
    public CarrelloDTO aggiungiAlCarrello(Utente utente, long idProdotto, int unita){
        if(unita <= 0){
            throw new IllegalArgumentException("La quantità non può essere negativa");
        }
        Prodotto prodotto = prodottoRepository.findById(idProdotto).orElseThrow(() -> new IllegalArgumentException("Prodotto non trovato"));
        Carrello carrello = carrelloRepository.attivaLock(utente);
        if(carrello.prodottoPresente(prodotto)){
           carrello.modificaQuantita(prodotto, carrello.getQuantitaProdotto(prodotto)+unita);
        }
        else{
            RigaCarrello rg = new RigaCarrello();
            rg.setPrezzo(prodotto.getPrezzo());
            rg.setProdotto(prodotto);
            rg.setUnita(unita);
            carrello.aggiungiRiga(rg);
        }
        Carrello nuovo = carrelloRepository.save(carrello);
        CarrelloDTO nuovoDTO = CarrelloMapper.toDTO(nuovo);
        return nuovoDTO;
    }

    @Transactional
    public CarrelloDTO rimuoviProdotto(Utente utente, long idProdotto){
        Carrello carrello = carrelloRepository.attivaLock(utente);
        Prodotto prodotto = prodottoRepository.findById(idProdotto).orElseThrow(()-> new IllegalArgumentException("Prodotto non trovato"));
        if(carrello.prodottoPresente(prodotto)){
            carrello.rimuoviRiga(prodotto);
            CarrelloDTO modificato = CarrelloMapper.toDTO(carrelloRepository.save(carrello));
            return modificato;
        }
        else {
            return CarrelloMapper.toDTO(carrello);
        }
    }
    @Transactional
    public CarrelloDTO svuotaCarrello(Utente utente){
        Carrello carrello= carrelloRepository.attivaLock(utente);
        carrello.getElenco().clear();
        return CarrelloMapper.toDTO(carrelloRepository.save(carrello));
    }

}
