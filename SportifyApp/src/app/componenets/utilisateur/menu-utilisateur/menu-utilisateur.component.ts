import { Interet } from './../../../model/interet';
import { InteretService } from './../../../services/interet.service';
import { Caracteristique } from './../../../model/caracteristique';
import { CaracteristiqueService } from './../../../services/caracteristique.service';
import { ProfilService } from './../../../services/profil.service';
import { Profil } from './../../../model/profil';
import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { Compte } from './../../../model/compte';
import { CompteService } from './../../../services/compte.service';
import { Utilisateur } from 'src/app/model/utilisateur';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-utilisateur',
  templateUrl: './menu-utilisateur.component.html',
  styleUrls: ['./menu-utilisateur.component.css'],
})
export class MenuUtilisateurComponent implements OnInit {
  compte: Compte = new Compte();
  utilisateurProfil: Utilisateur = new Utilisateur();
  utilisateurInteret: Utilisateur = new Utilisateur();
  profil: Profil = new Profil();
  carac: Caracteristique = new Caracteristique();
  interets: Interet[] = new Array<Interet>();

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private profilService: ProfilService,
    private caracteristiqueService: CaracteristiqueService
  ) {}

  ngOnInit(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
        this.utilisateurService
          .getByIdWithProfil(this.compte.id!)
          .subscribe((resultUtilisateurProfil) => {
            this.utilisateurProfil = resultUtilisateurProfil;
            this.profilService
              .getByIdWithCarac(this.utilisateurProfil.profilUtilisateur?.id!)
              .subscribe((resultProfil) => {
                this.profil = resultProfil;
                this.caracteristiqueService
                  .get(this.profil.caracteristique?.id!)
                  .subscribe((resultCarac) => (this.carac = resultCarac));
              });
          });
        this.utilisateurService
          .getByIdWithInteret(this.compte.id!)
          .subscribe((resultUtilisateurInteret) => {
            this.utilisateurInteret = resultUtilisateurInteret;
            this.interets = this.utilisateurInteret.interets!;
          });
      });
  }
}
