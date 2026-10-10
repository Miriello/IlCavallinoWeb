package com.example.ilcavallinobackend.mapper;

import com.example.ilcavallinobackend.model.dto.OrdineDTO;
import com.example.ilcavallinobackend.model.entity.Ordine;

public class OrdineMapper {
    public static OrdineDTO toDTO (Ordine ordine){
        OrdineDTO ordineDTO = new OrdineDTO();
        ordineDTO.setId(ordine.getId());
        ordineDTO.setUsername(ordine.getUtente().getUsername());
        ordineDTO.setData(ordine.getData());
        ordineDTO.setCarrello(CarrelloMapper.toDTO(ordine.getCarrello()));
        return ordineDTO;
    }
}
