import { UtilisateurService } from './../../../services/utilisateur.service';
import { Equipe } from './../../../model/equipe';
import { Utilisateur } from './../../../model/utilisateur';
import { EquipeService } from './../../../services/equipe.service';
import { CompteService } from './../../../services/compte.service';
import { Compte } from './../../../model/compte';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Club } from 'src/app/model/club';
import { ClubService } from 'src/app/services/club.service';

@Component({
  selector: 'app-menu-club-equipes',
  templateUrl: './menu-club-equipes.component.html',
  styleUrls: ['./menu-club-equipes.component.css'],
})
export class MenuClubEquipesComponent implements OnInit {
  compte: Compte = new Compte();
  club: Club = new Club();
  equipe: Equipe = new Equipe();
  membresEquipe: Array<Utilisateur> = [];
  membres: Array<Utilisateur[]> = [];
  longueur: number = 0;

  constructor(
    private compteService: CompteService,
    private clubService: ClubService,
    private equipeService: EquipeService,
    private utilisateurService: UtilisateurService
  ) {}

  ngOnInit(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.compte = result;
        this.clubService.getByIdEquipe(this.compte.id!).subscribe((res) => {
          this.club = res;
          // for (let i = 0; i < this.club.equipes!.length; i++) {
          //   this.equipe = new Equipe();
          //   this.membresEquipe = [];
          //   this.equipeService
          //     .getByIdWithUtilisateur(this.club.equipes![i].id!)
          //     .subscribe((equipeUtilisateur) => {
          //       this.equipe = equipeUtilisateur;
          //       this.longueur = this.equipe.equipe!.length;
          //       for (let j = 0; j < this.longueur; j++) {
          //         this.utilisateurService
          //           .get(this.equipe.equipe![i].id?.utilisateur?.id!)
          //           .subscribe((user) => {
          //             this.membresEquipe.push(user);
          //           });
          //       }
          //       this.membres.push(this.membresEquipe);
          //     });
          // }
        });
      });
  }
}
