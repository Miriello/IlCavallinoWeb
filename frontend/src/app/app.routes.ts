import { Routes } from '@angular/router';
import { Menu } from './pages/menu/menu';
import { Login } from './pages/login/login';
import { Registrazione } from './pages/registrazione/registrazione';
import { Carrello } from './pages/carrello/carrello';
import { Ordini } from './pages/ordini/ordini';
import { Dashboard} from './pages/dashboard/dashboard';
import { OrdiniAdmin } from './pages/ordini-admin/ordini-admin';
import { Allergeni } from './pages/allergeni/allergeni';
import { Ingredienti } from './pages/ingredienti/ingredienti';
import { Prodotti } from './pages/prodotti/prodotti';
import { Homepage } from './pages/homepage/homepage';


export const routes: Routes = [
    { path: '', redirectTo: 'homepage', pathMatch: 'full' },
    { path: 'homepage', component: Homepage},
    { path: 'menu', component: Menu },
    { path: 'login', component: Login },
    { path: 'registrazione', component: Registrazione },
    { path: 'carrello', component: Carrello},
    { path: 'mieiOrdini', component: Ordini},
    { path: 'dashboard', component: Dashboard},
    { path: 'allergeni', component: Allergeni},
    { path: 'ingredienti', component: Ingredienti},
    { path: 'prodotti', component: Prodotti},
    { path: 'ordiniAdmin', component: OrdiniAdmin}
];