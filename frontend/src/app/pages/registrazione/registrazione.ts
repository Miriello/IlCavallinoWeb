import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { AutenticazioneService } from '../../services/autenticazione';

@Component({
  selector: 'app-registrazione',
  imports: [FormsModule, RouterLink],
  templateUrl: './registrazione.html',
  styleUrl: './registrazione.css'
})
export class Registrazione {
  private autenticazioneService = inject(AutenticazioneService);
  username = '';
  email = '';
  password = '';
  messaggio = '';
  errore='';

  registrati(): void {
    this.autenticazioneService.registrazione({
      username:this.username,
      password: this.password,
      email: this.email}).subscribe({
        next: (risposta) => {
          this.autenticazioneService.impostaAutenticazione(risposta);
          this.messaggio='Registrazione completata, benvenuto' +risposta.username;
        },
        error:()=>{
          this.errore='Registrazione fallita';
        }
      })
    console.log('Username:', this.username);
    console.log('Email:', this.email);
    console.log('Password inserita:', !!this.password);
  }
}