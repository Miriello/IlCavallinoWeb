import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { IngredienteService } from '../../services/ingrediente';

@Component({
  imports: [FormsModule],
  selector: 'app-gestione-ingredienti',
  styleUrl: './gestione-ingredienti.css',
  templateUrl: './gestione-ingredienti.html',
})
export class GestioneIngredienti {
  private readonly IngredienteService = inject(IngredienteService);
}
