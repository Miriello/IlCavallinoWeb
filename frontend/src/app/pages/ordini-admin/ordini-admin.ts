import { Component } from '@angular/core';
import { GestioneOrdini } from '../../components/gestione-ordini/gestione-ordini';

@Component({
  imports: [GestioneOrdini],
  selector: 'app-ordini-admin',
  styleUrl: './ordini-admin.css',
  templateUrl: './ordini-admin.html',
})
export class OrdiniAdmin {}
