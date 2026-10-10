package com.example.ilcavallinobackend.mapper;

import com.example.ilcavallinobackend.model.dto.ProdottoDTO;
import com.example.ilcavallinobackend.model.entity.Prodotto;

public class ProdottoMapper {

    public static ProdottoDTO toDTO (Prodotto prodotto) {
        ProdottoDTO prodottoDTO = new ProdottoDTO();
        prodottoDTO.setId(prodotto.getId());
        prodottoDTO.setNome(prodotto.getNome());
        prodottoDTO.setCategoriaProdotto(prodotto.getCategoriaProdotto());
        prodottoDTO.setDescrizione(prodotto.getDescrizione());
        prodottoDTO.setPrezzo(prodotto.getPrezzo());
        prodottoDTO.setIngredienti(prodotto.getIngredienti().stream().map(IngredienteMapper::toDTO).toList());
        prodottoDTO.setUrlImg(prodotto.getUrlImg());
        return prodottoDTO;
    }

    public static Prodotto toEntity(ProdottoDTO prodottoDTO){
        Prodotto prodotto = new Prodotto();
        prodotto.setNome(prodottoDTO.getNome());
        prodotto.setCategoriaProdotto(prodottoDTO.getCategoriaProdotto());
        prodotto.setDescrizione(prodottoDTO.getDescrizione());
        prodotto.setPrezzo(prodottoDTO.getPrezzo());
        prodotto.setIngredienti(prodottoDTO.getIngredienti().stream().map(IngredienteMapper::toEntity).toList());
        prodotto.setUrlImg(prodottoDTO.getUrlImg());
        return prodotto;
    }

    public static void update(Prodotto prodotto, ProdottoDTO prodottoDTO){
        prodotto.setNome(prodottoDTO.getNome());
        prodotto.setCategoriaProdotto(prodottoDTO.getCategoriaProdotto());
        prodotto.setDescrizione(prodottoDTO.getDescrizione());
        prodotto.setPrezzo(prodottoDTO.getPrezzo());
        prodotto.setIngredienti(prodottoDTO.getIngredienti().stream().map(IngredienteMapper::toEntity).toList());
        prodotto.setUrlImg(prodottoDTO.getUrlImg());
    }
}
