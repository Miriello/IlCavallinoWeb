import { Component, inject } from '@angular/core';
import { ProdottoService } from '../../services/prodotto';

@Component({
  imports: [],
  selector: 'app-gestione-prodotti',
  styleUrl: './gestione-prodotti.css',
  templateUrl: './gestione-prodotti.html',
})
export class GestioneProdotti {
  private readonly prodottiService = inject(ProdottoService);
}
