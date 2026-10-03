package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.model.entity.Carrello;
import com.example.ilcavallinobackend.model.entity.Ordine;
import com.example.ilcavallinobackend.model.dto.OrdineDTO;
import com.example.ilcavallinobackend.model.entity.Utente;
import com.example.ilcavallinobackend.repository.CarrelloRepository;
import com.example.ilcavallinobackend.repository.OrdineRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdineService {

    private final OrdineRepository ordineRepository;
    private final CarrelloRepository carrelloRepository;

    public OrdineService(OrdineRepository ordineRepository, CarrelloRepository carrelloRepository){
        this.ordineRepository=ordineRepository;
        this.carrelloRepository=carrelloRepository;
    }

    @Transactional
    public List<OrdineDTO> getOrdini(){
        List<Ordine> ordini = ordineRepository.findAll();
        List<OrdineDTO> ordiniDTO = new ArrayList<>();
        for(Ordine ordine: ordini){
            ordiniDTO.add(toDTO(ordine));
        }
        return ordiniDTO;
    }

    @Transactional
    public List<OrdineDTO> getMieiOrdini(Utente utente){
        List<Ordine> ordini = ordineRepository.findByUtente(utente);
        List<OrdineDTO> ordiniDTO = new ArrayList<>();
        for(Ordine ordine: ordini){
            ordiniDTO.add(toDTO(ordine));
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

    @Transactional
    public OrdineDTO creaOrdine(Utente utente){
        Carrello carrello = carrelloRepository.attivaLock(utente);
        Ordine nuovo = new Ordine();
        nuovo.setCarrello(carrello);
        nuovo.setData(LocalDate.now());
        nuovo.setUtente(utente);
        return toDTO(ordineRepository.save(nuovo));
    }
    @Transactional
    public OrdineDTO aggiornaOrdine(long id, OrdineDTO ordineDTO){
       Ordine ordine = ordineRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Ordine non presente"));
       ordine.setData(ordineDTO.getData());
       ordine.setCarrello(ordineDTO.getCarrello());
       return toDTO(ordineRepository.save(ordine));
    }
    @Transactional
    public void eliminaOrdine(long id){
        ordineRepository.deleteById(id);
    }
}
