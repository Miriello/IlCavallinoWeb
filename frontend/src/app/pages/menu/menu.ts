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
    this.prodottoService.getProdottil().subscribe({
      next: (prodotti) => {
        this.prodotti.set(prodotti);
        this.caricamento.set(false);
      },
      error: () => {
        this.errore.set(true);
        this.caricamento.set(false);
      }
    });
  }

  aggiungiAlCarrello(idProdotto: number): void {
    console.log('Prodotto selezionato:', idProdotto);
  }
}