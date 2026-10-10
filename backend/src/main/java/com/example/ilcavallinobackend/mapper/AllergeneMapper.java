package com.example.ilcavallinobackend.mapper;

import com.example.ilcavallinobackend.model.dto.AllergeneDTO;
import com.example.ilcavallinobackend.model.entity.Allergene;

public class AllergeneMapper {

    public static AllergeneDTO toDTO(Allergene allergene) {
        AllergeneDTO dto = new AllergeneDTO();
        dto.setId(allergene.getId());
        dto.setNome(allergene.getNome());
        return dto;
    }

    public static Allergene toEntity(AllergeneDTO allergeneDTO){
        Allergene allergene = new Allergene();
        allergene.setNome((allergeneDTO.getNome()));
        return allergene;
    }

    public static void update(Allergene allergene, AllergeneDTO allergeneDTO){
        allergene.setNome(allergeneDTO.getNome());
    }
}
