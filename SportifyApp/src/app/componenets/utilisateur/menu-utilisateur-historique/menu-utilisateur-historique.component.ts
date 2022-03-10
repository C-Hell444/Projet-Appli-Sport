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

  utilisateurEquipe: Utilisateur = new Utilisateur();
  equipesUtilisateur: EquipeUtilisateur[] = new Array<EquipeUtilisateur>();
  equipes: Equipe[] = new Array<Equipe>();
  equipeClubs: Club[] = new Array<Club>();

  utilisateurEvent: Utilisateur = new Utilisateur();
  evenementsUtilisateur: EvenementUtilisateur[] =
    new Array<EvenementUtilisateur>();
  evenements: Evenement[] = new Array<Evenement>();
  evenementClubs: Club[] = new Array<Club>();

  afficheClubs: boolean = true;
  afficheEquipes: boolean = false;
  afficheEvents: boolean = false;

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private clubService: ClubService,
    private equipeService: EquipeService,
    private evenementService: EvenementService
  ) {}

  ngOnInit(): void {
    this.triDescClub();
    this.triDescEquipe();
    this.triDescEvenement();
  }

  triAscClub(): void {
    this.clubsUtilisateur = [];
    this.clubs = [];
    this.afficheClubs = true;
    this.afficheEquipes = false;
    this.afficheEvents = false;
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
                });
            }
          });
      });
  }
  triDescClub(): void {
    this.clubsUtilisateur = [];
    this.clubs = [];
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
                });
            }
          });
      });
  }

  triAscEquipe(): void {
    this.equipesUtilisateur = [];
    this.equipes = [];
    this.equipeClubs = [];
    this.afficheClubs = false;
    this.afficheEquipes = true;
    this.afficheEvents = false;
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
                  this.clubService
                    .getByIdWithSport(equipe.club?.id!)
                    .subscribe((club) => {
                      this.equipeClubs.push(club);
                    });
                });
            }
          });
      });
  }
  triDescEquipe(): void {
    this.equipesUtilisateur = [];
    this.equipes = [];
    this.equipeClubs = [];
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
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
                  this.clubService
                    .getByIdWithSport(equipe.club?.id!)
                    .subscribe((club) => {
                      this.equipeClubs.push(club);
                    });
                });
            }
          });
      });
  }

  triAscEvenement(): void {
    this.evenementsUtilisateur = [];
    this.evenements = [];
    this.evenementClubs = [];
    this.afficheClubs = false;
    this.afficheEquipes = false;
    this.afficheEvents = true;
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
                  this.clubService
                    .getByIdWithSport(evenement.club?.id!)
                    .subscribe((club) => {
                      this.evenementClubs.push(club);
                    });
                });
            }
          });
      });
  }
  triDescEvenement(): void {
    this.evenementsUtilisateur = [];
    this.evenements = [];
    this.evenementClubs = [];
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
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
                  this.clubService
                    .getByIdWithSport(evenement.club?.id!)
                    .subscribe((club) => {
                      this.evenementClubs.push(club);
                    });
                });
            }
          });
      });
  }
}
