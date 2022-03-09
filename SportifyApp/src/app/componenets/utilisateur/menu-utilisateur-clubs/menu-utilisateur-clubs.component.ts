import { ClubService } from './../../../services/club.service';
import { ClubUtilisateur } from './../../../model/club-utilisateur';
import { Club } from './../../../model/club';
import { UtilisateurService } from './../../../services/utilisateur.service';
import { CompteService } from './../../../services/compte.service';
import { Compte } from './../../../model/compte';
import { Utilisateur } from './../../../model/utilisateur';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-utilisateur-clubs',
  templateUrl: './menu-utilisateur-clubs.component.html',
  styleUrls: ['./menu-utilisateur-clubs.component.css'],
})
export class MenuUtilisateurClubsComponent implements OnInit {
  compte: Compte = new Compte();
  utilisateur: Utilisateur = new Utilisateur();
  clubs: Array<Club> = [];
  longueur: number = 0;

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private clubService: ClubService
  ) {}

  ngOnInit(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.compte = result;
        this.utilisateurService
          .getByIdWithClubUtilisateur(this.compte.id!)
          .subscribe((res) => {
            this.utilisateur = res;
            this.longueur = this.utilisateur.clubs!.length;
            for (let i = 0; i < this.longueur; i++) {
              this.clubService
                .getByIdWithSport(this.utilisateur.clubs![i].id?.club?.id!)
                .subscribe((club) => {
                  this.clubs.push(club);
                });
            }
          });
      });
  }
}
