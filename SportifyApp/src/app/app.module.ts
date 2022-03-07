import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MenuPrincipaleComponent } from './componenets/menu-principale/menu-principale.component';
import { ActualitesComponent } from './componenets/actualites/actualites.component';
import { NotFoundPageComponent } from './componenets/not-found-page/not-found-page.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { routes } from './routes';
import { HttpClientModule } from '@angular/common/http';
import { MentionLegaleComponent } from './componenets/mention-legale/mention-legale.component';
import { AProposComponent } from './componenets/a-propos/a-propos.component';
import { FaqComponent } from './componenets/faq/faq.component';
import { InscriptionClubComponent } from './componenets/inscription-club/inscription-club.component';
import { InscriptionUtilisateurComponent } from './componenets/inscription-utilisateur/inscription-utilisateur.component';
import { ConnexionComponent } from './componenets/connexion/connexion.component';
import { NosClubsComponent } from './componenets/nos-clubs/nos-clubs.component';
import { NosSportsComponent } from './componenets/nos-sports/nos-sports.component';
import { NosEvenementsComponent } from './componenets/nos-evenements/nos-evenements.component';
import { MenuAdminComponent } from './componenets/admin/menu-admin/menu-admin.component';
import { MenuUtilisateurComponent } from './componenets/utilisateur/menu-utilisateur/menu-utilisateur.component';
import { MenuClubComponent } from './componenets/club/menu-club/menu-club.component';
import { MenuClubMembresComponent } from './componenets/club/menu-club-membres/menu-club-membres.component';
import { MenuClubEquipesComponent } from './componenets/club/menu-club-equipes/menu-club-equipes.component';
import { MenuClubEvenementsComponent } from './componenets/club/menu-club-evenements/menu-club-evenements.component';
import { MenuClubHistoriqueComponent } from './componenets/club/menu-club-historique/menu-club-historique.component';
import { MenuUtilisateurClubsComponent } from './componenets/utilisateur/menu-utilisateur-clubs/menu-utilisateur-clubs.component';
import { MenuUtilisateurEquipesComponent } from './componenets/utilisateur/menu-utilisateur-equipes/menu-utilisateur-equipes.component';
import { MenuUtilisateurEvenementsComponent } from './componenets/utilisateur/menu-utilisateur-evenements/menu-utilisateur-evenements.component';
import { MenuUtilisateurHistoriqueComponent } from './componenets/utilisateur/menu-utilisateur-historique/menu-utilisateur-historique.component';
import { MenuAdminUtilisateursComponent } from './componenets/admin/menu-admin-utilisateurs/menu-admin-utilisateurs.component';
import { MenuAdminSportsComponent } from './componenets/admin/menu-admin-sports/menu-admin-sports.component';
import { MenuAdminClubsComponent } from './componenets/admin/menu-admin-clubs/menu-admin-clubs.component';
import { MenuAdminEquipesComponent } from './componenets/admin/menu-admin-equipes/menu-admin-equipes.component';
import { MenuAdminEvenementsComponent } from './componenets/admin/menu-admin-evenements/menu-admin-evenements.component';
import { MenuAdminHistoriqueComponent } from './componenets/admin/menu-admin-historique/menu-admin-historique.component';

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
    NosClubsComponent,
    NosSportsComponent,
    NosEvenementsComponent,
    MenuAdminComponent,
    MenuUtilisateurComponent,
    MenuClubComponent,
    MenuClubMembresComponent,
    MenuClubEquipesComponent,
    MenuClubEvenementsComponent,
    MenuClubHistoriqueComponent,
    MenuUtilisateurClubsComponent,
    MenuUtilisateurEquipesComponent,
    MenuUtilisateurEvenementsComponent,
    MenuUtilisateurHistoriqueComponent,
    MenuAdminUtilisateursComponent,
    MenuAdminSportsComponent,
    MenuAdminClubsComponent,
    MenuAdminEquipesComponent,
    MenuAdminEvenementsComponent,
    MenuAdminHistoriqueComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
