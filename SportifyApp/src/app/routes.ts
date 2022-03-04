import { Routes } from '@angular/router';
import { AProposComponent } from './componenets/a-propos/a-propos.component';
import { ActualitesComponent } from './componenets/actualites/actualites.component';
import { ConnexionComponent } from './componenets/connexion/connexion.component';
import { FaqComponent } from './componenets/faq/faq.component';
import { InscriptionClubComponent } from './componenets/inscription-club/inscription-club.component';
import { InscriptionUtilisateurComponent } from './componenets/inscription-utilisateur/inscription-utilisateur.component';
import { MentionLegaleComponent } from './componenets/mention-legale/mention-legale.component';
import { MenuPrincipaleComponent } from './componenets/menu-principale/menu-principale.component';
import { NotFoundPageComponent } from './componenets/not-found-page/not-found-page.component';

export const routes: Routes = [
  { path: 'accueil', component: MenuPrincipaleComponent },
  { path: 'actualite', component: ActualitesComponent },
  { path: 'mention-legale', component: MentionLegaleComponent },
  { path: 'faq', component: FaqComponent },
  { path: 'A-propos', component: AProposComponent },
  { path: 'connexion', component: ConnexionComponent },
  {
    path: 'inscription-utilisateur',
    component: InscriptionUtilisateurComponent,
  },
  { path: 'inscription-club', component: InscriptionClubComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
  {
    path: '**',
    component: NotFoundPageComponent,
  },
];
