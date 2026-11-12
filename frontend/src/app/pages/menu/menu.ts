import { Component, inject, OnInit, signal } from '@angular/core';
import { Prodotto } from '../../models/prodotto';
import { ProdottoService } from '../../services/prodotto';
import { CarrelloService } from '../../services/carrello';
import { MenuComponent } from '../../components/menu-component/menu-component';

@Component({
  selector: 'app-menu',
  imports: [MenuComponent],
  templateUrl: './menu.html',
  styleUrl: './menu.css'
})
export class Menu implements OnInit {

  private prodottoService = inject(ProdottoService);
  private carrelloService = inject(CarrelloService);

  prodotti = signal<Prodotto[]>([]);
  caricamento = signal(true);
  errore = signal(false);

ngOnInit(): void {
  this.prodottoService.getProdotti().subscribe({
    next: (prodotti) => {
      console.log('Prodotti ricevuti:', prodotti);
      this.prodotti.set(prodotti);
      this.caricamento.set(false);
    },
    error: (errore) => {
      console.error('Errore chiamata API:', errore);
      this.errore.set(true);
      this.caricamento.set(false);
    }
  });
}

  aggiungiAlCarrello(idProdotto: number): void {
    this.carrelloService.aggiungiAlCarrello(idProdotto,1).subscribe();
  }

  
}