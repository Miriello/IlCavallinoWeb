import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AutenticazioneService } from '../../services/autenticazione';

@Component({
  selector: 'app-login',
  imports: [FormsModule, RouterLink],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  private autenticazioneService = inject(AutenticazioneService);
  private router = inject(Router);
  errore = '';
  username = '';
  password = '';

  accedi(): void {
    this.autenticazioneService.login({
      username : this.username,
      password : this.password
    }).subscribe({
      next: async (risposta) => {
        this.autenticazioneService.impostaAutenticazione(risposta);
        console.log('Login riuscito: ', risposta.username);
        console.log('Ruolo: ', risposta.ruolo);
        if(risposta.ruolo== 'USER'){
          this.router.navigate(['/menu']);
        }
        if(risposta.ruolo == 'ADMIN'){
          this.router.navigate(['/dashboard']);
        }
      },
      error: () => {
        this.errore='Credenziali non valide';
      }
    });
  }
}