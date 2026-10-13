import { Routes } from '@angular/router';
import { Menu } from './pages/menu/menu';
import { Login } from './pages/login/login';
import { Registrazione } from './pages/registrazione/registrazione';
import { Carrello } from './pages/carrello/carrello';
import { Ordini } from './pages/ordini/ordini';
import { Dashboard} from './pages/dashboard/dashboard';
import { OrdiniAdmin } from './pages/ordini-admin/ordini-admin';


export const routes: Routes = [
    { path: '', redirectTo: 'menu', pathMatch: 'full' },
    { path: 'menu', component: Menu },
    { path: 'login', component: Login },
    { path: 'registrazione', component: Registrazione },
    { path: 'carrello', component: Carrello},
    { path: 'mieiOrdini', component: Ordini},
    { path: 'dashboard', component: Dashboard},
    { path: 'ordiniAdmin', component: OrdiniAdmin}
];