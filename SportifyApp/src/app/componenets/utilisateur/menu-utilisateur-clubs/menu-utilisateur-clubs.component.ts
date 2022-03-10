import { ClubUtilisateurService } from './../../../services/club-utilisateur.service';
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
  clubUtilisateur: Array<ClubUtilisateur> = [];
  clubs: Array<Club> = [];
  longueur: number = 0;

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private clubService: ClubService,
    private clubUtilisateurService: ClubUtilisateurService
  ) {}

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.compte = result;
        this.utilisateurService
          .getByIdWithClubUtilisateur(this.compte.id!)
          .subscribe((res) => {
            this.utilisateur = res;
            this.clubUtilisateur = this.utilisateur.clubs!;
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

  delete(cu: ClubUtilisateur) {
    let d = new Date();
    cu.dateFin = d;
    this.clubUtilisateurService
      .updateByIds(cu.id?.club?.id!, this.utilisateur.id!, cu)
      .subscribe((ok) => {
        cu = ok;
        this.clubs = [];
        this.clubUtilisateur = [];
        this.getAll();
      });
  }
}
