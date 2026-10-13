import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { AutenticazioneService } from '../../services/autenticazione';

@Component({
  selector: 'app-login',
  imports: [FormsModule, RouterLink],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  private AutenticazioneService = inject(AutenticazioneService);
  errore = '';
  username = '';
  password = '';

  accedi(): void {
    this.AutenticazioneService.login({
      username : this.username,
      password : this.password
    }).subscribe({
      next:(risposta) => {
        console.log('Login riuscito: ', risposta.username);
        console.log('Ruolo: ', risposta.ruolo);
      },
      error: () => {
        this.errore='Credenziali non valide';
      }
    });
  }
}