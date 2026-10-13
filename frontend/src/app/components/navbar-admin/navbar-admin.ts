import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  imports: [RouterLink,RouterLinkActive],
  selector: 'app-navbar-admin',
  styleUrl: './navbar-admin.css',
  templateUrl: './navbar-admin.html',
})
export class NavbarAdmin {}
