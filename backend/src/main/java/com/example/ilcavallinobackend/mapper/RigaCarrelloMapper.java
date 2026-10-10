package com.example.ilcavallinobackend.mapper;

import com.example.ilcavallinobackend.model.dto.RigaCarrelloDTO;
import com.example.ilcavallinobackend.model.entity.RigaCarrello;

public class RigaCarrelloMapper {

    public static RigaCarrelloDTO toDTO (RigaCarrello rigaCarrello){
        RigaCarrelloDTO rigaCarrelloDTO = new RigaCarrelloDTO();
        rigaCarrelloDTO.setProdottoDTO(ProdottoMapper.toDTO(rigaCarrello.getProdotto()));
        rigaCarrelloDTO.setUnita(rigaCarrello.getUnita());
        rigaCarrelloDTO.setPrezzo(rigaCarrello.getPrezzo());
        return rigaCarrelloDTO;
    }
}
