import { AuthenticationGardPourIncriptionEtConnexionService } from './services/authentication-gard-pour-incription-et-connexion.service';
import { Routes } from '@angular/router';
import { AProposComponent } from './componenets/a-propos/a-propos.component';
import { ActualitesComponent } from './componenets/actualites/actualites.component';
import { MenuAdminClubsEditComponent } from './componenets/admin/menu-admin-clubs-edit/menu-admin-clubs-edit.component';
import { MenuAdminClubsComponent } from './componenets/admin/menu-admin-clubs/menu-admin-clubs.component';
import { MenuAdminEditComponent } from './componenets/admin/menu-admin-edit/menu-admin-edit.component';
import { MenuAdminEquipesEditComponent } from './componenets/admin/menu-admin-equipes-edit/menu-admin-equipes-edit.component';
import { MenuAdminEquipesComponent } from './componenets/admin/menu-admin-equipes/menu-admin-equipes.component';
import { MenuAdminEvenementsEditComponent } from './componenets/admin/menu-admin-evenements-edit/menu-admin-evenements-edit.component';
import { MenuAdminEvenementsComponent } from './componenets/admin/menu-admin-evenements/menu-admin-evenements.component';
import { MenuAdminHistoriqueEditComponent } from './componenets/admin/menu-admin-historique-edit/menu-admin-historique-edit.component';
import { MenuAdminHistoriqueComponent } from './componenets/admin/menu-admin-historique/menu-admin-historique.component';
import { MenuAdminSportsEditComponent } from './componenets/admin/menu-admin-sports-edit/menu-admin-sports-edit.component';
import { MenuAdminSportsComponent } from './componenets/admin/menu-admin-sports/menu-admin-sports.component';
import { MenuAdminUtilisateursEditComponent } from './componenets/admin/menu-admin-utilisateurs-edit/menu-admin-utilisateurs-edit.component';
import { MenuAdminUtilisateursComponent } from './componenets/admin/menu-admin-utilisateurs/menu-admin-utilisateurs.component';
import { MenuAdminComponent } from './componenets/admin/menu-admin/menu-admin.component';
import { MenuClubEditComponent } from './componenets/club/menu-club-edit/menu-club-edit.component';
import { MenuClubEquipesEditComponent } from './componenets/club/menu-club-equipes-edit/menu-club-equipes-edit.component';
import { MenuClubEquipesComponent } from './componenets/club/menu-club-equipes/menu-club-equipes.component';
import { MenuClubEvenementsEditComponent } from './componenets/club/menu-club-evenements-edit/menu-club-evenements-edit.component';
import { MenuClubEvenementsComponent } from './componenets/club/menu-club-evenements/menu-club-evenements.component';
import { MenuClubHistoriqueEditComponent } from './componenets/club/menu-club-historique-edit/menu-club-historique-edit.component';
import { MenuClubHistoriqueComponent } from './componenets/club/menu-club-historique/menu-club-historique.component';
import { MenuClubMembresEditComponent } from './componenets/club/menu-club-membres-edit/menu-club-membres-edit.component';
import { MenuClubMembresComponent } from './componenets/club/menu-club-membres/menu-club-membres.component';
import { MenuClubComponent } from './componenets/club/menu-club/menu-club.component';
import { ConnexionComponent } from './componenets/connexion/connexion.component';
import { FaqComponent } from './componenets/faq/faq.component';
import { InscriptionClubComponent } from './componenets/inscription-club/inscription-club.component';
import { InscriptionUtilisateurComponent } from './componenets/inscription-utilisateur/inscription-utilisateur.component';
import { MentionLegaleComponent } from './componenets/mention-legale/mention-legale.component';
import { MenuPrincipaleComponent } from './componenets/menu-principale/menu-principale.component';
import { NosClubsComponent } from './componenets/nos-clubs/nos-clubs.component';
import { NosEvenementsComponent } from './componenets/nos-evenements/nos-evenements.component';
import { NosSportsComponent } from './componenets/nos-sports/nos-sports.component';
import { NotFoundPageComponent } from './componenets/not-found-page/not-found-page.component';
import { MenuUtilisateurClubsEditComponent } from './componenets/utilisateur/menu-utilisateur-clubs-edit/menu-utilisateur-clubs-edit.component';
import { MenuUtilisateurClubsComponent } from './componenets/utilisateur/menu-utilisateur-clubs/menu-utilisateur-clubs.component';
import { MenuUtilisateurEditComponent } from './componenets/utilisateur/menu-utilisateur-edit/menu-utilisateur-edit.component';
import { MenuUtilisateurEquipesEditComponent } from './componenets/utilisateur/menu-utilisateur-equipes-edit/menu-utilisateur-equipes-edit.component';
import { MenuUtilisateurEquipesComponent } from './componenets/utilisateur/menu-utilisateur-equipes/menu-utilisateur-equipes.component';
import { MenuUtilisateurEvenementsEditComponent } from './componenets/utilisateur/menu-utilisateur-evenements-edit/menu-utilisateur-evenements-edit.component';
import { MenuUtilisateurEvenementsComponent } from './componenets/utilisateur/menu-utilisateur-evenements/menu-utilisateur-evenements.component';
import { MenuUtilisateurHistoriqueEditComponent } from './componenets/utilisateur/menu-utilisateur-historique-edit/menu-utilisateur-historique-edit.component';
import { MenuUtilisateurHistoriqueComponent } from './componenets/utilisateur/menu-utilisateur-historique/menu-utilisateur-historique.component';
import { MenuUtilisateurSuggestionsComponent } from './componenets/utilisateur/menu-utilisateur-suggestions/menu-utilisateur-suggestions.component';
import { MenuUtilisateurComponent } from './componenets/utilisateur/menu-utilisateur/menu-utilisateur.component';
import { AuthenticationGardService } from './services/authentication-gard.service';

export const routes: Routes = [
  { path: 'accueil', component: MenuPrincipaleComponent },
  { path: 'actualite', component: ActualitesComponent },
  { path: 'nos-clubs', component: NosClubsComponent },
  { path: 'nos-evenements', component: NosEvenementsComponent },
  { path: 'nos-sports', component: NosSportsComponent },
  { path: 'mention-legale', component: MentionLegaleComponent },
  { path: 'faq', component: FaqComponent },
  { path: 'A-propos', component: AProposComponent },
  {
    path: 'connexion',
    component: ConnexionComponent,
    canActivate: [AuthenticationGardPourIncriptionEtConnexionService],
  },
  {
    path: 'inscription-utilisateur',
    component: InscriptionUtilisateurComponent,
    canActivate: [AuthenticationGardPourIncriptionEtConnexionService],
  },
  {
    path: 'inscription-club',
    component: InscriptionClubComponent,
    canActivate: [AuthenticationGardPourIncriptionEtConnexionService],
  },
  {
    path: 'menu-club',
    component: MenuClubComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-club-edit',
    component: MenuClubEditComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-club-membres',
    component: MenuClubMembresComponent,
    canActivate: [AuthenticationGardService],
  },
  // {
  //   path: 'menu-club-membres-edit',
  //   component: MenuClubMembresEditComponent,
  //   canActivate: [AuthenticationGardService],
  // },
  {
    path: 'menu-club-equipes',
    component: MenuClubEquipesComponent,
    canActivate: [AuthenticationGardService],
  },
  // {
  //   path: 'menu-club-equipes-edit',
  //   component: MenuClubEquipesEditComponent,
  //   canActivate: [AuthenticationGardService],
  // },
  {
    path: 'menu-club-evenements',
    component: MenuClubEvenementsComponent,
    canActivate: [AuthenticationGardService],
  },
  // {
  //   path: 'menu-club-evenements-edit',
  //   component: MenuClubEvenementsEditComponent,
  //   canActivate: [AuthenticationGardService],
  // },
  {
    path: 'menu-club-historique',
    component: MenuClubHistoriqueComponent,
    canActivate: [AuthenticationGardService],
  },
  // {
  //   path: 'menu-club-historique-edit',
  //   component: MenuClubHistoriqueEditComponent,
  //   canActivate: [AuthenticationGardService],
  // },
  {
    path: 'menu-utilisateur',
    component: MenuUtilisateurComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-utilisateur-edit',
    component: MenuUtilisateurEditComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-utilisateur-clubs',
    component: MenuUtilisateurClubsComponent,
    canActivate: [AuthenticationGardService],
  },
  // {
  //   path: 'menu-utilisateur-clubs-edit',
  //   component: MenuUtilisateurClubsEditComponent,
  //   canActivate: [AuthenticationGardService],
  // },
  {
    path: 'menu-utilisateur-equipes',
    component: MenuUtilisateurEquipesComponent,
    canActivate: [AuthenticationGardService],
  },
  // {
  //   path: 'menu-utilisateur-equipes-edit',
  //   component: MenuUtilisateurEquipesEditComponent,
  //   canActivate: [AuthenticationGardService],
  // },
  {
    path: 'menu-utilisateur-evenements',
    component: MenuUtilisateurEvenementsComponent,
    canActivate: [AuthenticationGardService],
  },
  // {
  //   path: 'menu-utilisateur-evenements-edit',
  //   component: MenuUtilisateurEvenementsEditComponent,
  //   canActivate: [AuthenticationGardService],
  // },
  {
    path: 'menu-utilisateur-historique',
    component: MenuUtilisateurHistoriqueComponent,
    canActivate: [AuthenticationGardService],
  },
  // {
  //   path: 'menu-utilisateur-historique-edit',
  //   component: MenuUtilisateurHistoriqueEditComponent,
  //   canActivate: [AuthenticationGardService],
  // },
  {
    path: 'menu-utilisateur-suggestions',
    component: MenuUtilisateurSuggestionsComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin',
    component: MenuAdminComponent,
    canActivate: [AuthenticationGardService],
  },
  // {
  //   path: 'menu-admin-edit',
  //   component: MenuAdminEditComponent,
  //   canActivate: [AuthenticationGardService],
  // },
  {
    path: 'menu-admin-utilisateurs',
    component: MenuAdminUtilisateursComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-utilisateurs-edit',
    component: MenuAdminUtilisateursEditComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-utilisateurs-edit/:id',
    component: MenuAdminUtilisateursEditComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-sports',
    component: MenuAdminSportsComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-sports-edit',
    component: MenuAdminSportsEditComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-sports-edit/:id',
    component: MenuAdminSportsEditComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-clubs',
    component: MenuAdminClubsComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-clubs-edit',
    component: MenuAdminClubsEditComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-clubs-edit/:id',
    component: MenuAdminClubsEditComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-equipes',
    component: MenuAdminEquipesComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-equipes-edit',
    component: MenuAdminEquipesEditComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-equipes-edit/:id',
    component: MenuAdminEquipesEditComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-evenements',
    component: MenuAdminEvenementsComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-evenements-edit',
    component: MenuAdminEvenementsEditComponent,
    canActivate: [AuthenticationGardService],
  },
  {
    path: 'menu-admin-evenements-edit/:id',
    component: MenuAdminEvenementsEditComponent,
    canActivate: [AuthenticationGardService],
  },
  // {
  //   path: 'menu-admin-historique',
  //   component: MenuAdminHistoriqueComponent,
  //   canActivate: [AuthenticationGardService],
  // },
  // {
  //   path: 'menu-admin-historique-edit',
  //   component: MenuAdminHistoriqueEditComponent,
  //   canActivate: [AuthenticationGardService],
  // },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
  {
    path: '**',
    component: NotFoundPageComponent,
  },
];
