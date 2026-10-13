import { Component, inject } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { AutenticazioneService } from '../../services/autenticazione';

@Component({
  imports: [RouterLink,RouterLinkActive],
  selector: 'app-navbar-admin',
  styleUrl: './navbar-admin.css',
  templateUrl: './navbar-admin.html',
})
export class NavbarAdmin {
  private autenticazioneService = inject(AutenticazioneService);
  private router = inject(Router);

   logout(): void {
    localStorage.removeItem('sessione');
    this.autenticazioneService.logout();
    this.router.navigate(['/homepage']);
  }
}
