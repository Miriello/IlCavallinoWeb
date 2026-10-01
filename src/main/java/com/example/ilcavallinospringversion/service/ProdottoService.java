package com.example.ilcavallinospringversion.service;

import com.example.ilcavallinospringversion.model.entity.Prodotto;
import com.example.ilcavallinospringversion.model.responseDTO.ProdottoDTO;
import com.example.ilcavallinospringversion.repository.ProdottoRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.parameters.P;
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
        return toDTO(prodottoRepository.findById(id));
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

    public Prodotto toEntity (ProdottoDTO prodottoDTO){
        Prodotto p = new Prodotto();
        p.setId(prodottoDTO.getId());
        p.setNome(prodottoDTO.getNome());
        p.setCategoriaProdotto(prodottoDTO.getCategoriaProdotto());
        p.setDescrizione(prodottoDTO.getDescrizione());
        p.setPrezzo(prodottoDTO.getPrezzo());
        p.setIngredienti(prodottoDTO.getIngredienti());
        return p;
    }
    @Transactional
    public ProdottoDTO creaProdotto(ProdottoDTO prodottoDTO){
        Prodotto p = toEntity(prodottoDTO);
        Prodotto nuovo = prodottoRepository.save(p);
        return toDTO(nuovo);
    }
    @Transactional
    public ProdottoDTO aggiornaProdotto(long id, ProdottoDTO prodottoDTO){
        Prodotto p = toEntity(prodottoDTO);
        Prodotto nuovo = prodottoRepository.upload(id,p);
        return toDTO(p);
    }

    @Transactional
    public void eliminaProdotto(long id){
        prodottoRepository.delete(id);
    }
}
