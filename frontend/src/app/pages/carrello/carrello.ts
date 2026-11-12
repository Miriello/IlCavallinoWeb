import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CarrelloService } from '../../services/carrello';
import { OrdineService } from '../../services/ordine';
import { inject } from '@angular/core';
import { signal } from '@angular/core';
import { RigaCarrello } from '../../models/rigaCarrello';

@Component({
  imports: [RouterLink],
  selector: 'app-carrello',
  styleUrl: './carrello.css',
  templateUrl: './carrello.html',
})
export class Carrello {
  private carrelloService = inject(CarrelloService);
  private ordineService = inject(OrdineService);
  carrello = signal<RigaCarrello[]>([]);

  
 ngOnInit(): void {
  this.carrelloService.getCarrello().subscribe({
    next: (carrello) => {
      console.log('Carrello:', carrello);
      this.carrello.set(carrello.elenco);
    },
    error: (errore) => {
      console.error('Errore nel caricamento del carrello:', errore);
    }
  });
}
}
