import { Component, input, output } from '@angular/core';
import { Prodotto } from '../../models/prodotto';
import { ProdottoComponent } from '../prodotto-component/prodotto-component';

@Component({
  selector: 'app-menu-component',
  imports: [ProdottoComponent],
  templateUrl: './menu-component.html',
  styleUrl: './menu-component.css'
})
export class MenuComponent {

  prodotti = input.required<Prodotto[]>();

  aggiungi = output<number>();

  aggiungiAlCarrello(idProdotto: number): void {
    this.aggiungi.emit(idProdotto);
  }
}