import { Component } from '@angular/core';
import { GestioneAllergeni } from '../../components/gestione-allergeni/gestione-allergeni';

@Component({
  imports: [GestioneAllergeni],
  selector: 'app-allergeni',
  styleUrl: './allergeni.css',
  templateUrl: './allergeni.html',
})
export class Allergeni {}
