package com.example.ilcavallinobackend.mapper;

import com.example.ilcavallinobackend.model.dto.CarrelloDTO;
import com.example.ilcavallinobackend.model.entity.Carrello;

public class CarrelloMapper {
    public static CarrelloDTO toDTO(Carrello carrello){
        CarrelloDTO carrelloDTO = new CarrelloDTO();
        carrelloDTO.setId(carrello.getId());
        if(carrello.getUtente() != null){
            carrelloDTO.setUsername(carrello.getUtente().getUsername());
        }
        carrelloDTO.setElenco(carrello.getElenco().stream().map(RigaCarrelloMapper::toDTO).toList());
        return carrelloDTO;
    }
}
