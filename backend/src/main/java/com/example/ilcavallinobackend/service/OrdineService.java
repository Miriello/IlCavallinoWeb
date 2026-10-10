package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.exception.NonPermessoException;
import com.example.ilcavallinobackend.exception.NonTrovatoExcepiton;
import com.example.ilcavallinobackend.exception.PermessoNegato;
import com.example.ilcavallinobackend.mapper.OrdineMapper;
import com.example.ilcavallinobackend.model.entity.*;
import com.example.ilcavallinobackend.model.dto.OrdineDTO;
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

    public OrdineService(OrdineRepository ordineRepository, CarrelloRepository carrelloRepository, UtenteRepository utenteRepository){
        this.ordineRepository=ordineRepository;
        this.carrelloRepository=carrelloRepository;
    }

    @Transactional
    public List<OrdineDTO> getOrdini(){
        List<Ordine> ordini = ordineRepository.findAll();
        List<OrdineDTO> ordiniDTO = new ArrayList<>();
        for(Ordine ordine: ordini){
            ordiniDTO.add(OrdineMapper.toDTO(ordine));
        }
        return ordiniDTO;
    }

    @Transactional
    public List<OrdineDTO> getMieiOrdini(Utente utente){
        List<Ordine> ordini = ordineRepository.findByUtente(utente);
        List<OrdineDTO> ordiniDTO = new ArrayList<>();
        for(Ordine ordine: ordini){
            ordiniDTO.add(OrdineMapper.toDTO(ordine));
        }
        return ordiniDTO;
    }


    @Transactional
    public OrdineDTO getOrdine(long id, Utente utente) {
        Ordine ordine = ordineRepository.findById(id)
                .orElseThrow(() ->
                        new NonTrovatoExcepiton("Ordine non trovato")
                );

        if (utente.getRuolo() != Ruolo.ADMIN &&
                ordine.getUtente().getId() != utente.getId()) {
            throw new PermessoNegato("Accesso non autorizzato");
        }

        return OrdineMapper.toDTO(ordine);
    }


    // RECUPERO IL CARRELLO DALL'UTENTE E APPLICO UN LOCK PESSIMISTICO.
    // CREO UN NUOVO ORDINE, AL SUO INTERNO NON INSERISCO IL CARRELLO
    // RECUPERATO DALL'UTENTE, MA UNA COPIA.
    // IN QUESTO MODO IL CARRELLO DELL'UTENTE VERRA' SEMPLICEMENTE SVUOTATO.

    @Transactional
    public OrdineDTO creaOrdine(Utente utente){
        Carrello carrello = carrelloRepository.attivaLock(utente);
        if(carrello.getElenco().isEmpty()){
            throw new NonPermessoException("Il carrello è vuoto!");
        }
        Ordine ordine = new Ordine();
        ordine.setData(LocalDate.now());
        ordine.setUtente(utente);
        Carrello nuovoCarrello = new Carrello();
        for(RigaCarrello rg : carrello.getElenco()){
            RigaCarrello nuovaRiga = new RigaCarrello();
            nuovaRiga.setProdotto(rg.getProdotto());
            nuovaRiga.setPrezzo(rg.getPrezzo());
            nuovaRiga.setUnita(rg.getUnita());
            nuovoCarrello.aggiungiRiga(nuovaRiga);
        }
        carrelloRepository.save(nuovoCarrello);
        ordine.setCarrello(nuovoCarrello);
        carrello.getElenco().clear();
        return OrdineMapper.toDTO(ordineRepository.save(ordine));
    }
    @Transactional
    public void eliminaOrdine(long id){
        Ordine daCancellare = ordineRepository.findById(id).orElseThrow(()-> new NonTrovatoExcepiton("Ordine non presente"));
        ordineRepository.delete(daCancellare);
        ordineRepository.flush();
        carrelloRepository.deleteById(daCancellare.getCarrello().getId());
    }
}
