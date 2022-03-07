import { Routes } from '@angular/router';
import { AProposComponent } from './componenets/a-propos/a-propos.component';
import { ActualitesComponent } from './componenets/actualites/actualites.component';
import { MenuAdminClubsComponent } from './componenets/admin/menu-admin-clubs/menu-admin-clubs.component';
import { MenuAdminEquipesComponent } from './componenets/admin/menu-admin-equipes/menu-admin-equipes.component';
import { MenuAdminEvenementsComponent } from './componenets/admin/menu-admin-evenements/menu-admin-evenements.component';
import { MenuAdminHistoriqueComponent } from './componenets/admin/menu-admin-historique/menu-admin-historique.component';
import { MenuAdminSportsComponent } from './componenets/admin/menu-admin-sports/menu-admin-sports.component';
import { MenuAdminUtilisateursComponent } from './componenets/admin/menu-admin-utilisateurs/menu-admin-utilisateurs.component';
import { MenuAdminComponent } from './componenets/admin/menu-admin/menu-admin.component';
import { MenuClubEquipesComponent } from './componenets/club/menu-club-equipes/menu-club-equipes.component';
import { MenuClubEvenementsComponent } from './componenets/club/menu-club-evenements/menu-club-evenements.component';
import { MenuClubHistoriqueComponent } from './componenets/club/menu-club-historique/menu-club-historique.component';
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
import { MenuUtilisateurClubsComponent } from './componenets/utilisateur/menu-utilisateur-clubs/menu-utilisateur-clubs.component';
import { MenuUtilisateurEquipesComponent } from './componenets/utilisateur/menu-utilisateur-equipes/menu-utilisateur-equipes.component';
import { MenuUtilisateurEvenementsComponent } from './componenets/utilisateur/menu-utilisateur-evenements/menu-utilisateur-evenements.component';
import { MenuUtilisateurHistoriqueComponent } from './componenets/utilisateur/menu-utilisateur-historique/menu-utilisateur-historique.component';
import { MenuUtilisateurComponent } from './componenets/utilisateur/menu-utilisateur/menu-utilisateur.component';

export const routes: Routes = [
  { path: 'accueil', component: MenuPrincipaleComponent },
  { path: 'actualite', component: ActualitesComponent },
  { path: 'nos-clubs', component: NosClubsComponent },
  { path: 'nos-evenements', component: NosEvenementsComponent },
  { path: 'nos-sports', component: NosSportsComponent },
  { path: 'mention-legale', component: MentionLegaleComponent },
  { path: 'faq', component: FaqComponent },
  { path: 'A-propos', component: AProposComponent },
  { path: 'connexion', component: ConnexionComponent },
  {
    path: 'inscription-utilisateur',
    component: InscriptionUtilisateurComponent,
  },
  { path: 'inscription-club', component: InscriptionClubComponent },
  { path: 'menu-club', component: MenuClubComponent },
  { path: 'menu-club-membres', component: MenuClubMembresComponent },
  { path: 'menu-club-equipes', component: MenuClubEquipesComponent },
  { path: 'menu-club-evenements', component: MenuClubEvenementsComponent },
  { path: 'menu-club-historique', component: MenuClubHistoriqueComponent },
  { path: 'menu-utilisateur', component: MenuUtilisateurComponent },
  { path: 'menu-utilisateur-clubs', component: MenuUtilisateurClubsComponent },
  {
    path: 'menu-utilisateur-equipes',
    component: MenuUtilisateurEquipesComponent,
  },
  {
    path: 'menu-utilisateur-evenements',
    component: MenuUtilisateurEvenementsComponent,
  },
  {
    path: 'menu-utilisateur-historique',
    component: MenuUtilisateurHistoriqueComponent,
  },
  { path: 'menu-admin', component: MenuAdminComponent },
  {
    path: 'menu-admin-utilisateurs',
    component: MenuAdminUtilisateursComponent,
  },
  { path: 'menu-admin-sports', component: MenuAdminSportsComponent },
  { path: 'menu-admin-clubs', component: MenuAdminClubsComponent },
  { path: 'menu-admin-equipes', component: MenuAdminEquipesComponent },
  { path: 'menu-admin-evenements', component: MenuAdminEvenementsComponent },
  { path: 'menu-admin-historique', component: MenuAdminHistoriqueComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
  {
    path: '**',
    component: NotFoundPageComponent,
  },
];
