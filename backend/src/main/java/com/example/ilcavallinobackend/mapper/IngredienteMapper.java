package com.example.ilcavallinobackend.mapper;

import com.example.ilcavallinobackend.model.dto.IngredienteDTO;
import com.example.ilcavallinobackend.model.entity.Ingrediente;

public class IngredienteMapper {

    public static IngredienteDTO toDTO(Ingrediente ingrediente){
        IngredienteDTO ingredienteDTO = new IngredienteDTO();
        ingredienteDTO.setId(ingrediente.getId());
        ingredienteDTO.setNome(ingrediente.getNome());
        ingredienteDTO.setAllergeni(ingrediente.getAllergeni().stream().map(AllergeneMapper::toDTO).toList());
        ingredienteDTO.setScadenza(ingrediente.getScadenza());
        return ingredienteDTO;
    }

    public static Ingrediente toEntity(IngredienteDTO ingredienteDTO){
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome(ingredienteDTO.getNome());
        ingrediente.setAllergeni(ingredienteDTO.getAllergeni().stream().map(AllergeneMapper::toEntity).toList());
        ingrediente.setScadenza(ingredienteDTO.getScadenza());
        return ingrediente;
    }

    public static void update(Ingrediente ingrediente, IngredienteDTO ingredienteDTO){
        ingrediente.setNome(ingredienteDTO.getNome());
        ingrediente.setAllergeni(ingredienteDTO.getAllergeni().stream().map(AllergeneMapper::toEntity).toList());
        ingrediente.setScadenza(ingredienteDTO.getScadenza());
    }
}
