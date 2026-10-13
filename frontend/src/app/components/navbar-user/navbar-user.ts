import { Component, inject } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { AutenticazioneService } from '../../services/autenticazione';

@Component({
  imports: [RouterLink, RouterLinkActive],
  selector: 'app-navbar-user',
  styleUrl: './navbar-user.css',
  templateUrl: './navbar-user.html',
})
export class NavbarUser {
  private autenticazioneService = inject(AutenticazioneService);
  private router = inject(Router)

  logout(): void {
    this.autenticazioneService.logout();
    this.router.navigate(['/homepage']);
  }
}
