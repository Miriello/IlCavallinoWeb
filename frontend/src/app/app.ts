import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { AutenticazioneService } from './services/autenticazione';
import { Ruolo } from './models/autenticazioneResponse';

import { NavbarPubblica } from './components/navbar-pubblica/navbar-pubblica';
import { NavbarUser } from './components/navbar-user/navbar-user';
import { NavbarAdmin } from './components/navbar-admin/navbar-admin';
import { Footer } from './components/footer/footer';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    NavbarPubblica,
    NavbarUser,
    NavbarAdmin,
    Footer
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  readonly autenticazioneService = inject(AutenticazioneService);
  readonly Ruolo = Ruolo;
}