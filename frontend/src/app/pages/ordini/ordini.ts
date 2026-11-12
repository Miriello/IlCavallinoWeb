import { Component, inject, signal } from '@angular/core';
import { OrdiniComponent } from '../../components/ordini-component/ordini-component';
import { OrdineService } from '../../services/ordine';
import { Ordine } from '../../models/ordine';

@Component({
  imports: [OrdiniComponent],
  selector: 'app-ordini',
  styleUrl: './ordini.css',
  templateUrl: './ordini.html',
})
export class Ordini {
  private ordiniService = inject(OrdineService);

  ordini= signal<Ordine[]>([]);

  ngOnInit(): void {
    this.ordiniService.getMieiOrdini;
  }
}
