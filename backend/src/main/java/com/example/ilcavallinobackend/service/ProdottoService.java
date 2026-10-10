package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.exception.NonTrovatoExcepiton;
import com.example.ilcavallinobackend.mapper.ProdottoMapper;
import com.example.ilcavallinobackend.model.dto.IngredienteDTO;
import com.example.ilcavallinobackend.model.entity.Ingrediente;
import com.example.ilcavallinobackend.model.entity.Prodotto;
import com.example.ilcavallinobackend.model.dto.ProdottoDTO;
import com.example.ilcavallinobackend.repository.ProdottoRepository;
import com.example.ilcavallinobackend.repository.IngrendienteRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdottoService {

    private final ProdottoRepository prodottoRepository;
    private final IngrendienteRepository ingredienteRepository;

    public ProdottoService(ProdottoRepository prodottoRepository, IngrendienteRepository ingredienteRepository){
        this.prodottoRepository=prodottoRepository;
        this.ingredienteRepository=ingredienteRepository;
    }

    @Transactional
    public ProdottoDTO getProdotto (long id){
        return ProdottoMapper.toDTO(prodottoRepository.findById(id).orElseThrow(()-> new NonTrovatoExcepiton("Prodotto non trovato")));
    }

    @Transactional
    public List<ProdottoDTO> getProdotti(){
        List<Prodotto> prodotti = prodottoRepository.findAll();
        List<ProdottoDTO> prodottiDTO = new ArrayList<>();
        for(Prodotto p : prodotti){
            ProdottoDTO prodottoDTO = new ProdottoDTO();
            prodottoDTO = ProdottoMapper.toDTO(p);
            prodottiDTO.add(prodottoDTO);
        }
        return prodottiDTO;
    }


    @Transactional
    public ProdottoDTO creaProdotto(ProdottoDTO prodottoDTO){
        Prodotto prodotto = ProdottoMapper.toEntity(prodottoDTO);
        prodotto.setIngredienti(recuperaIngredienti(prodottoDTO));
        return ProdottoMapper.toDTO(prodottoRepository.save(prodotto));
    }
    @Transactional
    public ProdottoDTO aggiornaProdotto(long id, ProdottoDTO prodottoDTO) {
        Prodotto prodotto = prodottoRepository.findById(id).orElseThrow(() -> new NonTrovatoExcepiton("Prodotto non trovato"));
        ProdottoMapper.update(prodotto, prodottoDTO);
        prodotto.setIngredienti(recuperaIngredienti(prodottoDTO));
        return ProdottoMapper.toDTO(prodotto);
    }
    @Transactional
    public void eliminaProdotto(long id){
        prodottoRepository.deleteById(id);
    }

    private List<Ingrediente> recuperaIngredienti(ProdottoDTO prodottoDTO){
        List<Ingrediente> ingredienti = new ArrayList<>();
        if(prodottoDTO.getIngredienti() == null ){
            return ingredienti;
        }
        for(IngredienteDTO ingredienteDTO : prodottoDTO.getIngredienti()){
            Ingrediente ingrediente = ingredienteRepository.findById(ingredienteDTO.getId()).orElseThrow(()-> new NonTrovatoExcepiton("Ingrediente non trovato"));
            ingredienti.add(ingrediente);
        }
        return ingredienti;
    }
}
