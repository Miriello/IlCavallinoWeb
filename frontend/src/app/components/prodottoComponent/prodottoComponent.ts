import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Prodotto } from '.app/models/prodotto';
import { ProdottoService } from '.app/services/prodottoService';

@Component({
  imports: [CommonModule],
  selector: 'app-prodotto',
  styleUrl: './prodottoComponent.css',
  templateUrl: './prodottoComponenr.html',
})
export class ProdottoComponent implements OnInit {
  private prodottoService = inject(ProdottoService);

  prodotti: Prodotto[] = [];
  ngOnInit(): void{
    this.caricaProdotti();
  }

  caricaProdotti(): void {
    this.prodottoService.getProdotti().subscribe({
      next:(dati) => {
        this.prodotti=dati;
      },
      error: (errore) => {
        console.error('Errore nel caricamento dei prodotti', errore);
      }
    })
  }

  caricaProdotto(id:number): void{
    this.prodottoService.getProdotto(id).subscribe({
      next:(dato) => {
        this.prodotti=dato;
      },
      error:(errore) =>{
        console.error('Errore nel caricamento del prodotto', errore)
      }
    })
  }
}
