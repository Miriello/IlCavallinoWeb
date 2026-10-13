import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  imports: [RouterLink, RouterLinkActive],
  selector: 'app-navbar-user',
  styleUrl: './navbar-user.css',
  templateUrl: './navbar-user.html',
})
export class NavbarUser {}
