package com.example.ilcavallinobackend.service;

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
        Allergene nuovo = new Allergene();
        nuovo.setNome(allergeneDTO.getNome());
        Allergene a = allergeneRepository.save(nuovo);
        return toDTO(a);
    }
    @Transactional
    public AllergeneDTO aggiornaAllergene(long id, AllergeneDTO allergeneDTO){
        Allergene allergene = allergeneRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Allergene non trovato"));
        allergene.setNome(allergeneDTO.getNome());
        return toDTO(allergeneRepository.save(allergene));
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

}
