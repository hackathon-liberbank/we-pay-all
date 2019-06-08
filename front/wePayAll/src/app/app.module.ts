import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { appRoutingProviders, routing } from './app.route';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegistreComponent } from './components/registre/registre.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { BlockchainComponent } from './components/blockchain/blockchain.component';
import { AltaEventoComponent } from './components/alta-evento/alta-evento.component';
import { SearchComponent } from './components/search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistreComponent,
    UserProfileComponent,
    BlockchainComponent,
    AltaEventoComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    routing
  ],
  providers: [appRoutingProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
