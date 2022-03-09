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
  profil: Profil = new Profil();
  carac: Caracteristique = new Caracteristique();

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
          .subscribe((resultUtilisateur) => {
            this.utilisateurProfil = resultUtilisateur;
            this.profilService
              .get(this.utilisateurProfil.profilUtilisateur?.id!)
              .subscribe((resultProfil) => {
                this.profil = resultProfil;
                console.log(this.profil);
              });
          });
      });
  }
}
