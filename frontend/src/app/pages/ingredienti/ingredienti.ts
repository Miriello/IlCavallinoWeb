import { Component } from '@angular/core';
import { GestioneIngredienti } from '../../components/gestione-ingredienti/gestione-ingredienti';

@Component({
  imports: [GestioneIngredienti],
  selector: 'app-ingredienti',
  styleUrl: './ingredienti.css',
  templateUrl: './ingredienti.html',
})
export class Ingredienti {}
