package com.example.ilcavallinospringversion.controller;

import com.example.ilcavallinospringversion.model.responseDTO.ProdottoDTO;
import com.example.ilcavallinospringversion.service.ProdottoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prodotti")
public class ProdottoController {
    private final ProdottoService prodottoService;

    public ProdottoController(ProdottoService prodottoService){
        this.prodottoService=prodottoService;
    }


    @GetMapping
    public ResponseEntity<List<ProdottoDTO>> getProdotti(){
        List<ProdottoDTO> prodotti = prodottoService.getProdotti();
        return ResponseEntity.ok(prodotti);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdottoDTO> getProdotto(@PathVariable long id){
        ProdottoDTO prodotto = prodottoService.getProdotto(id);
        return ResponseEntity.ok(prodotto);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('CUCINA','SOCIO','ADMIN')")
    public ResponseEntity<ProdottoDTO> creaProdotto(@RequestBody ProdottoDTO prodottoDTO){
        ProdottoDTO nuovo = prodottoService.creaProdotto(prodottoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo);
    }

    @PostMapping
    @PreAuthorize("hasRole('CUCINA','SOCIO','ADMIN')")
    public ResponseEntity<ProdottoDTO> aggiornaProdotto(@PathVariable long id , @RequestBody ProdottoDTO prodottoDTO){
        ProdottoDTO nuovo = prodottoService.aggiornaProdotto(id, prodottoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('CUCINA','SOCIO','ADMIN')")
    public ResponseEntity<Void> eliminaProdotto(@PathVariable long id){
        prodottoService.eliminaProdotto(id);
        return ResponseEntity.noContent().build();
    }

}
