import { Component, inject, OnInit, signal } from '@angular/core';
import { Prodotto } from '../../models/prodotto';
import { ProdottoService } from '../../services/prodotto';
import { MenuComponent } from '../../components/menu-component/menu-component';

@Component({
  selector: 'app-menu',
  imports: [MenuComponent],
  templateUrl: './menu.html',
  styleUrl: './menu.css'
})
export class Menu implements OnInit {

  private prodottoService = inject(ProdottoService);

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
    console.log('Prodotto selezionato:', idProdotto);
  }

  /*prodotti = signal<Prodotto[]>([
  {
    id: 1,
    nome: 'Pizza Margherita',
    categoriaProdotto: CategoriaProdotto.ROSTICCERIA,
    descrizione: 'Pomodoro, mozzarella e basilico',
    prezzo: 7.00,
    ingredienti: [],
    urlImg: 'https://images.unsplash.com/photo-1574071318508-1cdbab80d002'
  },
  {
    id: 2,
    nome: 'Pizza Diavola',
    categoriaProdotto: CategoriaProdotto.ROSTICCERIA,
    descrizione: 'Pomodoro, mozzarella e salame piccante',
    prezzo: 9.00,
    ingredienti: [],
    urlImg: 'https://images.unsplash.com/photo-1513104890138-7c749659a591'
  },
  {
    id: 3,
    nome: 'Pizza Diavola',
    categoriaProdotto: CategoriaProdotto.ROSTICCERIA,
    descrizione: 'Pomodoro, mozzarella e salame piccante',
    prezzo: 9.00,
    ingredienti: [],
    urlImg: 'https://images.unsplash.com/photo-1513104890138-7c749659a591'
  }
]);
*/
}