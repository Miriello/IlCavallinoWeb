import { Component, inject, signal } from '@angular/core';
import { AllergeneService } from '../../services/allergene';
import { Allergene } from '../../models/allergene';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule],
  selector: 'app-gestione-allergeni',
  styleUrl: './gestione-allergeni.css',
  templateUrl: './gestione-allergeni.html',
})
export class GestioneAllergeni {
  private readonly allergeneService = inject(AllergeneService);
  allergeni = signal<Allergene[]>([]);
  nome='';
  errore='';
  idAllergene: number| null=null;

  ngOnInit():void{
    this.caricaAllergeni();
  }

  caricaAllergeni(){
    this.allergeneService.getAllergeni().subscribe({
      next: (risposta) => {
        this.allergeni.set(risposta);
      },
      error: () => {
        this.errore = 'Errore nel caricamento degli allergeni.';
      }
    });
  }


}
