import { Component } from '@angular/core';
import { GestioneProdotti } from '../../components/gestione-prodotti/gestione-prodotti';

@Component({
  imports: [GestioneProdotti],
  selector: 'app-prodotti',
  styleUrl: './prodotti.css',
  templateUrl: './prodotti.html',
})
export class Prodotti {}
