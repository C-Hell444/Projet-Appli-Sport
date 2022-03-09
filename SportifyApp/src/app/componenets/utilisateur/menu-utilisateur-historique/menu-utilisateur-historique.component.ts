import { EvenementService } from 'src/app/services/evenement.service';
import { EquipeService } from 'src/app/services/equipe.service';
import { ClubService } from 'src/app/services/club.service';
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

  utilisateurClub: Utilisateur = new Utilisateur();
  clubsUtilisateur: ClubUtilisateur[] = new Array<ClubUtilisateur>();
  clubs: Club[] = new Array<Club>();
  clubLength: number[] = new Array<number>();

  utilisateurEquipe: Utilisateur = new Utilisateur();
  equipesUtilisateur: EquipeUtilisateur[] = new Array<EquipeUtilisateur>();
  equipes: Equipe[] = new Array<Equipe>();
  equipeLength: number[] = new Array<number>();

  utilisateurEvent: Utilisateur = new Utilisateur();
  evenementsUtilisateur: EvenementUtilisateur[] =
    new Array<EvenementUtilisateur>();
  evenements: Evenement[] = new Array<Evenement>();
  evenementLength: number[] = new Array<number>();
  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private clubService: ClubService,
    private equipeService: EquipeService,
    private evenementService: EvenementService
  ) {}

  ngOnInit(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
        this.utilisateurService
          .getByIdWithClubUtilisateurOrderByDateDebutDesc(this.compte.id!)
          .subscribe((resultClub) => {
            this.utilisateurClub = resultClub;
            this.clubsUtilisateur = this.utilisateurClub.clubs!;
            for (let i = 0; i < this.utilisateurClub.clubs?.length!; i++) {
              this.clubService
                .getByIdWithSport(this.utilisateurClub.clubs![i].id?.club?.id!)
                .subscribe((club) => {
                  this.clubs.push(club);
                  this.clubLength.push(i);
                });
            }
          });
        this.utilisateurService
          .getByIdWithEquipeUtilisateurOrderByDateDebutDesc(this.compte.id!)
          .subscribe((resultEquipe) => {
            this.utilisateurEquipe = resultEquipe;
            this.equipesUtilisateur = this.utilisateurEquipe.equipes!;
            for (let i = 0; i < this.utilisateurEquipe.equipes?.length!; i++) {
              this.equipeService
                .getByIdWithClub(
                  this.utilisateurEquipe.equipes![i].id?.equipe?.id!
                )
                .subscribe((equipe) => {
                  this.equipes.push(equipe);
                  this.equipeLength.push(i);
                });
            }
          });
        this.utilisateurService
          .getByIdWithEvenementUtilisateurOrderByDateDebutDesc(this.compte.id!)
          .subscribe((resultEvenement) => {
            this.utilisateurEvent = resultEvenement;
            this.evenementsUtilisateur = this.utilisateurEvent.evenements!;
            for (
              let i = 0;
              i < this.utilisateurEvent.evenements?.length!;
              i++
            ) {
              this.evenementService
                .getByIdWithClub(
                  this.utilisateurEvent.evenements![i].id?.evenement?.id!
                )
                .subscribe((evenement) => {
                  this.evenements.push(evenement);
                  this.evenementLength.push(i);
                });
            }
          });
      });
  }

  triAscClub(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
        this.utilisateurService
          .getByIdWithClubUtilisateurOrderByDateDebutAsc(this.compte.id!)
          .subscribe((resultClub) => {
            this.utilisateurClub = resultClub;
            this.clubsUtilisateur = this.utilisateurClub.clubs!;
            for (let i = 0; i < this.utilisateurClub.clubs?.length!; i++) {
              this.clubService
                .getByIdWithSport(this.utilisateurClub.clubs![i].id?.club?.id!)
                .subscribe((club) => {
                  this.clubs.push(club);
                  this.clubLength.push(i);
                });
            }
          });
      });
  }

  triAscEquipe(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
        this.utilisateurService
          .getByIdWithEquipeUtilisateurOrderByDateDebutAsc(this.compte.id!)
          .subscribe((resultEquipe) => {
            this.utilisateurEquipe = resultEquipe;
            this.equipesUtilisateur = this.utilisateurEquipe.equipes!;
            for (let i = 0; i < this.utilisateurEquipe.equipes?.length!; i++) {
              this.equipeService
                .getByIdWithClub(
                  this.utilisateurEquipe.equipes![i].id?.equipe?.id!
                )
                .subscribe((equipe) => {
                  this.equipes.push(equipe);
                  this.equipeLength.push(i);
                });
            }
          });
      });
  }

  triAscEvenement(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
        this.utilisateurService
          .getByIdWithEvenementUtilisateurOrderByDateDebutAsc(this.compte.id!)
          .subscribe((resultEvenement) => {
            this.utilisateurEvent = resultEvenement;
            this.evenementsUtilisateur = this.utilisateurEvent.evenements!;
            for (
              let i = 0;
              i < this.utilisateurEvent.evenements?.length!;
              i++
            ) {
              this.evenementService
                .getByIdWithClub(
                  this.utilisateurEvent.evenements![i].id?.evenement?.id!
                )
                .subscribe((evenement) => {
                  this.evenements.push(evenement);
                  this.evenementLength.push(i);
                });
            }
          });
      });
  }
}
