import { Routes } from '@angular/router';
import { Menu } from './pages/menu/menu';
import { Login } from './pages/login/login';
import { Registrazione } from './pages/registrazione/registrazione';

export const routes: Routes = [
    { path: '', redirectTo: 'menu', pathMatch: 'full' },
    { path: 'menu', component: Menu },
    { path: 'login', component: Login },
    { path: 'registrazione', component: Registrazione }     
];