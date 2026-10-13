import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-registrazione',
  imports: [FormsModule, RouterLink],
  templateUrl: './registrazione.html',
  styleUrl: './registrazione.css'
})
export class Registrazione {

  username = '';
  email = '';
  password = '';

  registrati(): void {
    console.log('Username:', this.username);
    console.log('Email:', this.email);
    console.log('Password inserita:', !!this.password);
  }
}