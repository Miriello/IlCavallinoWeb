package com.example.ilcavallinospringversion.service;

import com.example.ilcavallinospringversion.model.dto.CarrelloDTO;
import com.example.ilcavallinospringversion.model.entity.Carrello;
import com.example.ilcavallinospringversion.model.entity.Prodotto;
import com.example.ilcavallinospringversion.repository.CarrelloRepository;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService {

    private final CarrelloRepository carrelloRepository;

    public CarrelloService(CarrelloRepository carrelloRepository, ProdottoService prodottoService){
        this.carrelloRepository= carrelloRepository;
    }

    public CarrelloDTO svuotaCarrello(long idCarrello){
        CarrelloDTO c = new CarrelloDTO();
        carrelloRepository.delete(carrelloRepository.findById(idCarrello));
        return c;
    }

    public CarrelloDTO aggiungiAlCarrello(CarrelloDTO carrelloDTO, long idProdotto){

    }

    public CarrelloDTO aggiornaCarrello(CarrelloDTO carrelloDTO){

    }

    public CarrelloDTO rimuoviDalCarrello(CarrelloDTO carrelloDTO, long idProdotto){
        return toDTO(carrelloRepository.deleteProdottoByIdProdotto(idProdotto));
    }

    public Carrello toEntity(CarrelloDTO carrelloDTO){
        Carrello c = new Carrello();
        c.setId(carrelloDTO.getId());
        c.setProdotti((carrelloDTO.getElenco()));
        c.setUtente(carrelloDTO.getUtente());
        return c;
    }

    public CarrelloDTO toDTO(Carrello carrello){
        CarrelloDTO carrelloDTO = new CarrelloDTO();
        carrelloDTO.setId(carrello.getId());
        carrelloDTO.setElenco(carrello.getProdotti());
        carrelloDTO.setUtente(carrello.getUtente());
        return carrelloDTO;
    }
}
