package com.example.ilcavallinospringversion.controller;

import com.example.ilcavallinospringversion.model.dto.OrdineDTO;
import com.example.ilcavallinospringversion.model.entity.Utente;
import com.example.ilcavallinospringversion.service.OrdineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/ordini")
public class OrdineController {

    private final OrdineService ordineService;

    public OrdineController(OrdineService ordineService){
        this.ordineService=ordineService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('SOCIO','ADMIN')")
    public ResponseEntity<List<OrdineDTO>> getOrdini(){
        List<OrdineDTO> ordini = ordineService.getOrdini();
        return ResponseEntity.ok(ordini);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<OrdineDTO>> getMieiOrdini(@AuthenticationPrincipal Utente utente){
        List<OrdineDTO> ordini = ordineService.getMieiOrdini(utente);
        return ResponseEntity.ok(ordini);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdineDTO> getOrdine(@PathVariable long id){
        OrdineDTO ordine = ordineService.getOrdine(id);
        return ResponseEntity.ok(ordine);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<OrdineDTO> creaOrdine(@AuthenticationPrincipal Utente utente){
        OrdineDTO nuovo = ordineService.creaOrdine(utente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('CUCINA','SOCIO','ADMIN')")
    public ResponseEntity<OrdineDTO> aggiornaOrdine(@PathVariable long id , @RequestBody OrdineDTO ordineDTO){
        OrdineDTO nuovo = ordineService.aggiornaOrdine(id, ordineDTO);
        return ResponseEntity.ok(nuovo);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('CUCINA','SOCIO','ADMIN')")
    public ResponseEntity<Void> eliminaOrdine(@PathVariable long id){
        ordineService.eliminaOrdine(id);
        return ResponseEntity.noContent().build();
    }

}
