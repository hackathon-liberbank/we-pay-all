// Importar módulos del router

import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Importar componentes

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegistreComponent } from './components/registre/registre.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { BlockchainComponent } from './components/blockchain/blockchain.component';
import { AltaEventoComponent } from './components/alta-evento/alta-evento.component';

// Array de routas

 const appRoutes: Routes = [

    { path: 'home', component: AppComponent },
    { path: 'login', component: LoginComponent },
    { path: 'registre', component: RegistreComponent },
    { path: 'user-profile', component: UserProfileComponent },
    { path: 'blockchain', component: BlockchainComponent },
    { path: 'alta-evento', component: AltaEventoComponent }
 ]

 //Exportar el módulo del router

 export const appRoutingProviders: any [] = [];
 export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
