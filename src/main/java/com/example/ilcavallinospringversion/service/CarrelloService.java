package com.example.ilcavallinospringversion.service;

import com.example.ilcavallinospringversion.model.dto.CarrelloDTO;
import com.example.ilcavallinospringversion.model.entity.Carrello;
import com.example.ilcavallinospringversion.model.entity.Prodotto;
import com.example.ilcavallinospringversion.model.entity.Utente;
import com.example.ilcavallinospringversion.repository.CarrelloRepository;
import com.example.ilcavallinospringversion.repository.ProdottoRepository;
import com.example.ilcavallinospringversion.utility.RigaCarrello;
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

    public CarrelloDTO svuotaCarrello(long idCarrello){
        CarrelloDTO c = new CarrelloDTO();
        carrelloRepository.delete(carrelloRepository.findById(idCarrello));
        return c;
    }

    public CarrelloDTO aggiungiAlCarrello(Utente utente, long idProdotto, int unita){
        Prodotto prodotto = prodottoRepository.findById(idProdotto).orElseThrow(() -> new IllegalArgumentException("Prodotto non trovato"));
        double prezzo = prodotto.getPrezzo();
        RigaCarrello rigaCarrello = new RigaCarrello(prodotto,unita,prezzo);
        return toDTO(carrelloRepository.save(utente, rigaCarrello));
    }

    public CarrelloDTO aggiornaCarrello(CarrelloDTO carrelloDTO){

    }

    public CarrelloDTO rimuoviDalCarrello(CarrelloDTO carrelloDTO, long idProdotto){
        return toDTO(carrelloRepository.deleteProdottoByIdProdotto(idProdotto));
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
