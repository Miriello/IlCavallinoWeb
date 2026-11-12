import { Component,input } from '@angular/core';
import { Ordine } from '../../models/ordine';

@Component({
  imports: [],
  selector: 'app-ordini-component',
  styleUrl: './ordini-component.css',
  templateUrl: './ordini-component.html',
})
export class OrdiniComponent {
  ordini = input.required<Ordine[]>();

}
