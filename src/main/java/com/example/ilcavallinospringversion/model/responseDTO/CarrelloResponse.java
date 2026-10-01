package com.example.ilcavallinospringversion.model.responseDTO;


import com.example.ilcavallinospringversion.model.entity.Prodotto;

import java.util.Map;

public class CarrelloResponse {
    private Map<Prodotto, Integer> carrello;

    public CarrelloResponse(Map<Prodotto, Integer> carrello){

    }
}
