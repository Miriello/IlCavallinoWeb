package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.mapper.AllergeneMapper;
import com.example.ilcavallinobackend.model.dto.AllergeneDTO;
import com.example.ilcavallinobackend.model.entity.Allergene;
import com.example.ilcavallinobackend.repository.AllergeneRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AllergeneService {

    private final AllergeneRepository allergeneRepository;

    public AllergeneService(AllergeneRepository allergeneRepository){
        this.allergeneRepository=allergeneRepository;
    }

    public AllergeneDTO getAllergene(long id){
        return AllergeneMapper.toDTO(allergeneRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Allergene non trovato")));
    }

    public List<AllergeneDTO> getAllergeni(){
        List<AllergeneDTO> allergeni = new ArrayList<>();
        for(Allergene a : allergeneRepository.findAll()){
            allergeni.add(AllergeneMapper.toDTO(a));
        }
        return allergeni;
    }
    @Transactional
    public AllergeneDTO aggiungiAllergene(AllergeneDTO allergeneDTO){
        Allergene nuovo = new Allergene();
        nuovo.setNome(allergeneDTO.getNome());
        return AllergeneMapper.toDTO(allergeneRepository.save(nuovo));
    }
    @Transactional
    public AllergeneDTO aggiornaAllergene(long id, AllergeneDTO allergeneDTO){
        Allergene allergene = allergeneRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Allergene non trovato"));
        AllergeneMapper.update(allergene, allergeneDTO);
        return AllergeneMapper.toDTO(allergene);
    }

    @Transactional
    public void eliminaAllergene(long id){
        allergeneRepository.deleteById(id);
    }

}
