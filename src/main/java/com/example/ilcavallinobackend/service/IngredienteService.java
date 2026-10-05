package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.model.dto.IngredienteDTO;
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
            ingredientiDTO.add(toDTO(i));
        }
        return ingredientiDTO;
    }
    @Transactional
    public IngredienteDTO getIngrediente(long id){
        return toDTO(ingrendienteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Ingrediente non trovato")));
    }
    @Transactional
    public IngredienteDTO aggiungiIngrediente(IngredienteDTO ingredienteDTO){
        Ingrediente nuovo = new Ingrediente();
        nuovo.setAllergeni(ingredienteDTO.getAllergeni());
        nuovo.setNome(ingredienteDTO.getNome());
        nuovo.setScadenza(ingredienteDTO.getScadenza());
        return toDTO(ingrendienteRepository.save(nuovo));
    }
    @Transactional
    public IngredienteDTO aggiornaIngrediente(long id, IngredienteDTO ingredienteDTO){
        Ingrediente ingrediente= ingrendienteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Ingrediente non trovato"));
        ingrediente.setAllergeni(ingredienteDTO.getAllergeni());
        ingrediente.setNome(ingredienteDTO.getNome());
        ingrediente.setScadenza(ingredienteDTO.getScadenza());
        return toDTO(ingrendienteRepository.save(ingrediente));
    }
    @Transactional
    public void eliminaIngrediente(long id){
        ingrendienteRepository.deleteById(id);
    }
    public IngredienteDTO toDTO(Ingrediente ingrediente){
        IngredienteDTO ingredienteDTO = new IngredienteDTO();
        ingredienteDTO.setId(ingrediente.getId());
        ingredienteDTO.setNome(ingrediente.getNome());
        ingredienteDTO.setScadenza(ingrediente.getScadenza());
        ingredienteDTO.setAllergeni(ingrediente.getAllergeni());
        return ingredienteDTO;
    }
}
