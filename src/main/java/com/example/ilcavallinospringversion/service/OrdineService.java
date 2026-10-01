package com.example.ilcavallinospringversion.service;

import com.example.ilcavallinospringversion.model.entity.Ordine;
import com.example.ilcavallinospringversion.model.dto.OrdineDTO;
import com.example.ilcavallinospringversion.repository.OrdineRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdineService {

    private final OrdineRepository ordineRepository;

    public OrdineService(OrdineRepository ordineRepository){
        this.ordineRepository=ordineRepository;
    }

    @Transactional
    public List<OrdineDTO> getOrdini(){
        List<Ordine> ordini = ordineRepository.findAll();
        List<OrdineDTO> ordiniDTO = new ArrayList<>();
        for (Ordine o : ordini){
            OrdineDTO ordineDTO = new OrdineDTO();
            ordineDTO = toDTO(o);
            ordiniDTO.add(ordineDTO);
        }
        return ordiniDTO;
    }
    @Transactional
    public OrdineDTO getOrdine(long id){
        return toDTO(ordineRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Ordine non trovato")));
    }

    public OrdineDTO toDTO (Ordine ordine){
        OrdineDTO ordineDTO = new OrdineDTO();
        ordineDTO.setId(ordine.getId());
        return ordineDTO;
    }

    public Ordine toEntity(OrdineDTO ordineDTO){
        Ordine ordine = new Ordine();
        ordine.setData(ordineDTO.getData());
        ordine.setProdottiOrdine(ordineDTO.getProdottiOrdine());
        return ordine;
    }
    @Transactional
    public OrdineDTO creaOrdine(OrdineDTO ordineDTO){
        Ordine o = toEntity(ordineDTO);
        Ordine nuovo = ordineRepository.save(o);
        return toDTO(nuovo);
    }
    @Transactional
    public OrdineDTO aggiornaOrdine(long id, OrdineDTO ordineDTO){
        Ordine o = toEntity(ordineDTO);
        Ordine nuovo = ordineRepository.upload(id, o);
        return toDTO(nuovo);
    }
    @Transactional
    public void eliminaOrdine(long id){
        ordineRepository.deleteById(id);
    }
}
