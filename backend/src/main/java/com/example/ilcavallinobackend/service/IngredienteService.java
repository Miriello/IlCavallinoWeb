package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.exception.NonTrovatoExcepiton;
import com.example.ilcavallinobackend.mapper.AllergeneMapper;
import com.example.ilcavallinobackend.mapper.IngredienteMapper;
import com.example.ilcavallinobackend.model.dto.AllergeneDTO;
import com.example.ilcavallinobackend.model.dto.IngredienteDTO;
import com.example.ilcavallinobackend.model.entity.Allergene;
import com.example.ilcavallinobackend.model.entity.Ingrediente;
import com.example.ilcavallinobackend.repository.AllergeneRepository;
import com.example.ilcavallinobackend.repository.IngrendienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredienteService {
    private IngrendienteRepository ingrendienteRepository;
    private AllergeneRepository allergeneRepository;

    public IngredienteService(IngrendienteRepository ingrendienteRepository, AllergeneRepository allergeneRepository){
        this.ingrendienteRepository=ingrendienteRepository;
        this.allergeneRepository=allergeneRepository;
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
        return IngredienteMapper.toDTO(ingrendienteRepository.findById(id).orElseThrow(()-> new NonTrovatoExcepiton("Ingrediente non trovato")));
    }
    @Transactional
    public IngredienteDTO aggiungiIngrediente(IngredienteDTO ingredienteDTO){
        Ingrediente ingrediente = IngredienteMapper.toEntity(ingredienteDTO);
        ingrediente.setAllergeni(recuperaAllergeni(ingredienteDTO));
        return IngredienteMapper.toDTO(ingrendienteRepository.save(ingrediente));
    }
    @Transactional
    public IngredienteDTO aggiornaIngrediente(long id, IngredienteDTO ingredienteDTO) {
        Ingrediente ingrediente = ingrendienteRepository.findById(id).orElseThrow(() -> new NonTrovatoExcepiton("Ingrediente non trovato"));
        IngredienteMapper.update(ingrediente, ingredienteDTO);
        ingrediente.setAllergeni(recuperaAllergeni(ingredienteDTO));
        return IngredienteMapper.toDTO(ingrendienteRepository.save(ingrediente));
    }
    @Transactional
    public void eliminaIngrediente(long id){
        ingrendienteRepository.deleteById(id);
    }

    private List<Allergene> recuperaAllergeni(IngredienteDTO ingredienteDTO){
        List<Allergene> allergeni = new ArrayList<>();
        if(ingredienteDTO.getAllergeni()==null){
            return allergeni;
        }
        for (AllergeneDTO allergeneDTO : ingredienteDTO.getAllergeni()){
            Allergene allergene = allergeneRepository.findById(allergeneDTO.getId()).orElseThrow(()-> new NonTrovatoExcepiton("Allergene non trovato"));
            allergeni.add(allergene);
        }
        return allergeni;
    }
}
