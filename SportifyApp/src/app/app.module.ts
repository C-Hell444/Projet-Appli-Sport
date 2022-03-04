import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MenuPrincipaleComponent } from './componenets/menu-principale/menu-principale.component';
import { ActualitesComponent } from './componenets/actualites/actualites.component';
import { NotFoundPageComponent } from './componenets/not-found-page/not-found-page.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { routes } from './routes';
import { HttpClientModule } from '@angular/common/http';
import { MentionLegaleComponent } from './componenets/mention-legale/mention-legale.component';
import { AProposComponent } from './componenets/a-propos/a-propos.component';
import { FaqComponent } from './componenets/faq/faq.component';
import { InscriptionClubComponent } from './componenets/inscription-club/inscription-club.component';
import { InscriptionUtilisateurComponent } from './componenets/inscription-utilisateur/inscription-utilisateur.component';
import { ConnexionComponent } from './componenets/connexion/connexion.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuPrincipaleComponent,
    ActualitesComponent,
    NotFoundPageComponent,
    MentionLegaleComponent,
    AProposComponent,
    FaqComponent,
    InscriptionClubComponent,
    InscriptionUtilisateurComponent,
    ConnexionComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
