import { Routes } from '@angular/router';
import { Menu } from './pages/menu/menu';

export const routes: Routes = [
    { path: '', redirectTo: 'menu', pathMatch: 'full' },
    { path: 'menu', component: Menu }
];