package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.model.entity.Carrello;
import com.example.ilcavallinobackend.model.entity.Ordine;
import com.example.ilcavallinobackend.model.dto.OrdineDTO;
import com.example.ilcavallinobackend.model.entity.Utente;
import com.example.ilcavallinobackend.repository.CarrelloRepository;
import com.example.ilcavallinobackend.repository.OrdineRepository;
import com.example.ilcavallinobackend.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdineService {

    private final OrdineRepository ordineRepository;
    private final CarrelloRepository carrelloRepository;
    private final UtenteRepository utenteRepository;

    public OrdineService(OrdineRepository ordineRepository, CarrelloRepository carrelloRepository, UtenteRepository utenteRepository){
        this.ordineRepository=ordineRepository;
        this.carrelloRepository=carrelloRepository;
        this.utenteRepository = utenteRepository;
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
        ordineDTO.setUsername(ordine.getUtente().getUsername());
        ordineDTO.setData(ordine.getData());
        ordineDTO.setCarrello(ordine.getCarrello());
        return ordineDTO;
    }

    @Transactional
    public OrdineDTO creaOrdine(Utente utente){
        Carrello carrello = carrelloRepository.attivaLock(utente);
        Ordine nuovoOrdine = new Ordine();
        nuovoOrdine.setCarrello(carrello);
        nuovoOrdine.setData(LocalDate.now());
        nuovoOrdine.setUtente(utente);
        Ordine creato = ordineRepository.save(nuovoOrdine);
        Carrello nuovoCarrello = new Carrello();
        nuovoCarrello.setUtente(utente);
        utente.setCarrello(nuovoCarrello);
        carrelloRepository.save(nuovoCarrello);
        utenteRepository.save(utente);
        return toDTO(creato);
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
