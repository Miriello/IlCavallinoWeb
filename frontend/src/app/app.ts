import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarPubblica } from './components/navbar-pubblica/navbar-pubblica';

@Component({
    selector: 'app-root',
    imports: [RouterOutlet, NavbarPubblica],
    templateUrl: './app.html',
    styleUrl: './app.css'
})
export class App {}