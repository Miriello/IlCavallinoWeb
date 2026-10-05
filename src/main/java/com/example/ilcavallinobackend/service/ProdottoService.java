package com.example.ilcavallinobackend.service;

import com.example.ilcavallinobackend.model.entity.Prodotto;
import com.example.ilcavallinobackend.model.dto.ProdottoDTO;
import com.example.ilcavallinobackend.repository.ProdottoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdottoService {

    private final ProdottoRepository prodottoRepository;

    public ProdottoService(ProdottoRepository prodottoRepository){
        this.prodottoRepository=prodottoRepository;
    }

    @Transactional
    public ProdottoDTO getProdotto (long id){
        return toDTO(prodottoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Prodotto non trovato")));
    }

    @Transactional
    public List<ProdottoDTO> getProdotti(){
        List<Prodotto> prodotti = prodottoRepository.findAll();
        List<ProdottoDTO> prodottiDTO = new ArrayList<>();
        for(Prodotto p : prodotti){
            ProdottoDTO prodottoDTO = new ProdottoDTO();
            prodottoDTO = toDTO(p);
            prodottiDTO.add(prodottoDTO);
        }
        return prodottiDTO;
    }

    public ProdottoDTO toDTO(Prodotto prodotto) {
        ProdottoDTO pr = new ProdottoDTO();
        pr.setId(prodotto.getId());
        pr.setNome(prodotto.getNome());
        pr.setCategoriaProdotto(prodotto.getCategoriaProdotto());
        pr.setDescrizione(prodotto.getDescrizione());
        pr.setPrezzo(prodotto.getPrezzo());
        pr.setIngredienti(prodotto.getIngredienti());
        return pr;
    }

    @Transactional
    public ProdottoDTO creaProdotto(ProdottoDTO prodottoDTO){
        Prodotto nuovo = new Prodotto();
        nuovo.setCategoriaProdotto(prodottoDTO.getCategoriaProdotto());
        nuovo.setDescrizione(prodottoDTO.getDescrizione());
        nuovo.setPrezzo(prodottoDTO.getPrezzo());
        nuovo.setNome(prodottoDTO.getNome());
        nuovo.setUrlImg(prodottoDTO.getUrlImg());
        nuovo.setIngredienti(prodottoDTO.getIngredienti());
        return toDTO(prodottoRepository.save(nuovo));
    }
    @Transactional
    public ProdottoDTO aggiornaProdotto(long id, ProdottoDTO prodottoDTO){
        Prodotto prodotto = prodottoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Prodotto non trovato"));
        prodotto.setCategoriaProdotto(prodottoDTO.getCategoriaProdotto());
        prodotto.setPrezzo(prodottoDTO.getPrezzo());
        prodotto.setDescrizione(prodottoDTO.getDescrizione());
        prodotto.setIngredienti(prodottoDTO.getIngredienti());
        prodotto.setNome(prodottoDTO.getNome());
        prodotto.setUrlImg(prodottoDTO.getUrlImg());
        return toDTO(prodottoRepository.save(prodotto));
    }

    @Transactional
    public void eliminaProdotto(long id){
        prodottoRepository.deleteById(id);
    }
}
