import { EvenementUtilisateur } from './../../../model/evenement-utilisateur';
import { EquipeUtilisateur } from './../../../model/equipe-utilisateur';
import { ClubUtilisateur } from './../../../model/club-utilisateur';
import { Evenement } from 'src/app/model/evenement';
import { Equipe } from 'src/app/model/equipe';
import { Club } from 'src/app/model/club';
import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { CompteService } from './../../../services/compte.service';
import { Compte } from './../../../model/compte';
import { Utilisateur } from 'src/app/model/utilisateur';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-utilisateur-historique',
  templateUrl: './menu-utilisateur-historique.component.html',
  styleUrls: ['./menu-utilisateur-historique.component.css'],
})
export class MenuUtilisateurHistoriqueComponent implements OnInit {
  compte: Compte = new Compte();
  utilisateur: Utilisateur = new Utilisateur();
  clubs: ClubUtilisateur[] = new Array<ClubUtilisateur>();
  equipes: EquipeUtilisateur[] = new Array<EquipeUtilisateur>();
  evenements: EvenementUtilisateur[] = new Array<EvenementUtilisateur>();

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService
  ) {}

  ngOnInit(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
        this.utilisateurService
          .getByIdWithClubUtilisateurOrderByDateDebutDesc(this.compte.id!)
          .subscribe((resultUtilisateur) => {
            this.utilisateur = resultUtilisateur;
            this.clubs = this.utilisateur.clubs!;
          });
      });
  }
}
