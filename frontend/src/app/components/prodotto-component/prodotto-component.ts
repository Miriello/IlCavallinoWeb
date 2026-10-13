import { Component, input, output } from '@angular/core';
import { Prodotto } from '../../models/prodotto';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-prodotto-component',
  imports: [CurrencyPipe],
  templateUrl: './prodotto-component.html',
  styleUrl: './prodotto-component.css'
})
export class ProdottoComponent {

  prodotto = input.required<Prodotto>();
  aggiungi = output<number>();

  mostraAllergeni = false;
  mostraIngredienti=false;

  mostraAllergeniFunc(){
    this.mostraAllergeni=!this.mostraAllergeni;
    this.mostraIngredienti= false;
  }

  mostraIngredientiFunc(){
    this.mostraIngredienti= !this.mostraIngredienti
    this.mostraAllergeni= false;
  }


  aggiungiAlCarrello(): void {
    this.aggiungi.emit(this.prodotto().id);
  }
}