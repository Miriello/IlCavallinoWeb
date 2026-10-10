package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.mapper.AllergeneMapper;
import com.example.ilcavallinobackend.mapper.IngredienteMapper;
import com.example.ilcavallinobackend.model.dto.AllergeneDTO;
import com.example.ilcavallinobackend.model.dto.IngredienteDTO;
import com.example.ilcavallinobackend.model.entity.Allergene;
import com.example.ilcavallinobackend.model.entity.Ingrediente;
import com.example.ilcavallinobackend.repository.IngrendienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredienteService {
    private IngrendienteRepository ingrendienteRepository;

    public IngredienteService(IngrendienteRepository ingrendienteRepository){
        this.ingrendienteRepository=ingrendienteRepository;
    }
    @Transactional
    public List<IngredienteDTO> getIngredienti(){
        List<Ingrediente> ingredienti = ingrendienteRepository.findAll();
        List<IngredienteDTO> ingredientiDTO = new ArrayList<>();
        for(Ingrediente i : ingredienti){
            ingredientiDTO.add(IngredienteMapper.toDTO(i));
        }
        return ingredientiDTO;
    }
    @Transactional
    public IngredienteDTO getIngrediente(long id){
        return IngredienteMapper.toDTO(ingrendienteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Ingrediente non trovato")));
    }
    @Transactional
    public IngredienteDTO aggiungiIngrediente(IngredienteDTO ingredienteDTO){
        return IngredienteMapper.toDTO(ingrendienteRepository.save(IngredienteMapper.toEntity(ingredienteDTO)));
    }
    @Transactional
    public IngredienteDTO aggiornaIngrediente(long id, IngredienteDTO ingredienteDTO){
        Ingrediente ingrediente= ingrendienteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Ingrediente non trovato"));
        IngredienteMapper.update(ingrediente, ingredienteDTO);
        return IngredienteMapper.toDTO(ingrendienteRepository.save(ingrediente));
    }
    @Transactional
    public void eliminaIngrediente(long id){
        ingrendienteRepository.deleteById(id);
    }

}
