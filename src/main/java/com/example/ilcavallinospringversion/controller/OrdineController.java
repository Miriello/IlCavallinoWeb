package com.example.ilcavallinospringversion.controller;

import com.example.ilcavallinospringversion.model.responseDTO.OrdineDTO;
import com.example.ilcavallinospringversion.service.OrdineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<List<OrdineDTO>> getOrdini(){
        List<OrdineDTO> ordini = ordineService.getOrdini();
        return ResponseEntity.ok(ordini);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdineDTO> getOrdine(@PathVariable long id){
        OrdineDTO ordine = ordineService.getOrdine(id);
        return ResponseEntity.ok(ordine);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('CUCINA','SOCIO','ADMIN')")
    public ResponseEntity<OrdineDTO> creaOrdine(@RequestBody OrdineDTO ordineDTO){
        OrdineDTO nuovo = ordineService.creaOrdine(ordineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('CUCINA','SOCIO','ADMIN')")
    public ResponseEntity<OrdineDTO> aggiornaOrdine(@PathVariable long id , @RequestBody OrdineDTO ordineDTO){
        OrdineDTO nuovo = ordineService.aggiornaOrdine(id, ordineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('CUCINA','SOCIO','ADMIN')")
    public ResponseEntity<Void> eliminaOrdine(@PathVariable long id){
        ordineService.eliminaOrdine(id);
        return ResponseEntity.noContent().build();
    }
}
