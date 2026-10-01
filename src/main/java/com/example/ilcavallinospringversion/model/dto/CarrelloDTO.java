package com.example.ilcavallinospringversion.model.dto;


import com.example.ilcavallinospringversion.model.entity.Prodotto;

import java.util.Map;

public class CarrelloDTO {
    private Map<Prodotto, Integer> carrello;

    public CarrelloDTO(Map<Prodotto, Integer> carrello){

    }
}
