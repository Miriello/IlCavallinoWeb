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
        Prodotto p = new Prodotto();
        p.setCategoriaProdotto(prodottoDTO.getCategoriaProdotto());
        p.setDescrizione(prodottoDTO.getDescrizione());
        p.setPrezzo(prodottoDTO.getPrezzo());
        p.setNome(prodottoDTO.getNome());
        p.setUrlImg(prodottoDTO.getUrlImg());
        p.setIngredienti(prodottoDTO.getIngredienti());
        Prodotto nuovo = prodottoRepository.save(p);
        return toDTO(nuovo);
    }
    @Transactional
    public ProdottoDTO aggiornaProdotto(long id, ProdottoDTO prodottoDTO){
        Prodotto prodotto = prodottoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Prodotto non trovato"));
        prodotto.setCategoriaProdotto(prodottoDTO.getCategoriaProdotto());
        prodotto.setPrezzo(prodottoDTO.getPrezzo());
        prodotto.setDescrizione(prodottoDTO.getDescrizione());
        prodotto.setIngredienti(prodottoDTO.getIngredienti());
        prodotto.setNome(prodottoDTO.getNome());
        return toDTO(prodottoRepository.save(prodotto));
    }

    @Transactional
    public void eliminaProdotto(long id){
        prodottoRepository.deleteById(id);
    }
}
