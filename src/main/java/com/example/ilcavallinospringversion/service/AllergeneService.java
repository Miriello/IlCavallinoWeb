package com.example.ilcavallinospringversion.service;

import com.example.ilcavallinospringversion.model.dto.AllergeneDTO;
import com.example.ilcavallinospringversion.model.entity.Allergene;
import com.example.ilcavallinospringversion.repository.AllergeneRepository;
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
        return toDTO(allergeneRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Allergene non trovato")));
    }

    public List<AllergeneDTO> getAllergeni(){
        List<AllergeneDTO> allergeni = new ArrayList<>();
        for(Allergene a : allergeneRepository.findAll()){
            allergeni.add(toDTO(a));
        }
        return allergeni;
    }
    @Transactional
    public AllergeneDTO aggiungiAllergene(AllergeneDTO allergeneDTO){
        return toDTO(allergeneRepository.save(toEntity(allergeneDTO)));
    }
    @Transactional
    public AllergeneDTO aggiornaAllergene(long id, AllergeneDTO allergeneDTO){
        return toDTO(allergeneRepository.uploadById(id, toEntity(allergeneDTO)));
    }

    @Transactional
    public void eliminaAllergene(long id){
        allergeneRepository.deleteById(id);
    }

    public AllergeneDTO toDTO (Allergene allergene){
        AllergeneDTO allergeneDTO = new AllergeneDTO();
        allergeneDTO.setId(allergene.getId());
        allergeneDTO.setNome(allergene.getNome());
        return allergeneDTO;
    }

    public Allergene toEntity(AllergeneDTO allergeneDTO) {
        Allergene allergene = new Allergene();
        allergene.setId(allergeneDTO.getId());
        allergene.setNome(allergeneDTO.getNome());
        return allergene;
    }
}
