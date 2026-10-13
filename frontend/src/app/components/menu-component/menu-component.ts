import { Component, input, output, signal, computed } from '@angular/core';
import { Prodotto, CategoriaProdotto } from '../../models/prodotto';
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

  categorie = Object.values(CategoriaProdotto);

  categoriaSelezionata = signal<CategoriaProdotto | null>(null);

  prodottiFiltrati = computed(() => {
    const categoria = this.categoriaSelezionata();

    return categoria === null
      ? this.prodotti()
      : this.prodotti().filter(
          prodotto => prodotto.categoriaProdotto === categoria
        );
  });

  selezionaCategoria(categoria: CategoriaProdotto | null): void {
    this.categoriaSelezionata.set(categoria);
  }

  aggiungiAlCarrello(idProdotto: number): void {
    this.aggiungi.emit(idProdotto);
  }
}