import { Component, inject } from '@angular/core';
import { OrdineService } from '../../services/ordine';

@Component({
  imports: [],
  selector: 'app-gestione-ordini',
  styleUrl: './gestione-ordini.css',
  templateUrl: './gestione-ordini.html',
})
export class GestioneOrdini {
  private readonly ordineServive = inject(OrdineService);
}
