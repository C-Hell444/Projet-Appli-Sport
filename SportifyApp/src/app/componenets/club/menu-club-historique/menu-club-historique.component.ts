import { EvenementService } from 'src/app/services/evenement.service';
import { Utilisateur } from 'src/app/model/utilisateur';
import { EquipeService } from 'src/app/services/equipe.service';
import { EquipeUtilisateurService } from './../../../services/equipe-utilisateur.service';
import { Evenement } from 'src/app/model/evenement';
import { Equipe } from 'src/app/model/equipe';
import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { ProfilService } from './../../../services/profil.service';
import { Profil } from './../../../model/profil';
import { ClubService } from 'src/app/services/club.service';
import { CompteService } from 'src/app/services/compte.service';
import { EvenementUtilisateur } from './../../../model/evenement-utilisateur';
import { EquipeUtilisateur } from './../../../model/equipe-utilisateur';
import { ClubUtilisateur } from './../../../model/club-utilisateur';
import { Club } from 'src/app/model/club';
import { Compte } from 'src/app/model/compte';
import { Component, OnInit } from '@angular/core';
import { Caracteristique } from 'src/app/model/caracteristique';

@Component({
  selector: 'app-menu-club-historique',
  templateUrl: './menu-club-historique.component.html',
  styleUrls: ['./menu-club-historique.component.css'],
})
export class MenuClubHistoriqueComponent implements OnInit {
  compte: Compte = new Compte();

  clubUtilisateur: Club = new Club();
  clubUtilisateurs: Array<ClubUtilisateur> = [];
  utilisateurs: Array<Utilisateur> = [];
  utilisateurProfils: Array<Profil> = [];

  clubEquipe: Club = new Club();
  equipes: Array<Equipe> = [];

  equipeUtilisateurs: Array<EquipeUtilisateur> = [];

  equipeMembres: Array<Utilisateur> = [];

  clubEvent: Club = new Club();
  events: Array<Evenement> = [];

  eventUtilisateurs: Array<EvenementUtilisateur> = [];

  eventMembres: Array<Utilisateur> = [];

  afficheMembres: boolean = true;
  afficheEquipes: boolean = false;
  afficheEvents: boolean = false;

  constructor(
    private compteService: CompteService,
    private clubService: ClubService,
    private utilisateurService: UtilisateurService,
    private equipeService: EquipeService,
    private evenementService: EvenementService
  ) {}

  ngOnInit(): void {}

  triDescUser(): void {
    this.clubUtilisateurs = [];
    this.utilisateurs = [];
    this.afficheMembres = true;
    this.afficheEquipes = false;
    this.afficheEvents = false;

    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
        this.clubService
          .getByIdUtilisateurOrderByDateDebutDesc(this.compte.id!)
          .subscribe((resultUser) => {
            this.clubUtilisateur = resultUser;
            for (
              let i = 0;
              i < this.clubUtilisateur.listeMembres?.length!;
              i++
            ) {
              this.clubUtilisateurs.push(this.clubUtilisateur.listeMembres![i]);

              this.utilisateurs.push(
                this.clubUtilisateur.listeMembres![i].id?.utilisateur!
              );
            }
          });
      });
  }

  triAscUser(): void {
    this.clubUtilisateurs = [];
    this.utilisateurs = [];
    this.afficheMembres = true;
    this.afficheEquipes = false;
    this.afficheEvents = false;

    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
        this.clubService
          .getByIdUtilisateurOrderByDateDebutAsc(this.compte.id!)
          .subscribe((resultUser) => {
            console.log(resultUser);
            this.clubUtilisateur = resultUser;
            for (
              let i = 0;
              i < this.clubUtilisateur.listeMembres?.length!;
              i++
            ) {
              this.clubUtilisateurs.push(this.clubUtilisateur.listeMembres![i]);

              this.utilisateurs.push(
                this.clubUtilisateur.listeMembres![i].id?.utilisateur!
              );
            }
          });
      });
  }
  triDescEquipe(): void {
    this.equipes = [];
    this.equipeUtilisateurs = [];
    this.equipeMembres = [];
    this.afficheMembres = false;
    this.afficheEquipes = true;
    this.afficheEvents = false;

    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;

        this.clubService
          .getByIdEquipe(this.compte.id!)
          .subscribe((resultUser) => {
            this.clubEquipe = resultUser;
            for (let i = 0; i < this.clubEquipe.equipes!.length!; i++) {
              this.equipeService
                .getByIdWithUtilisateurOrderByDateDebutDesc(
                  this.clubEquipe.equipes![i].id!
                )
                .subscribe((resultEquipe) => {
                  for (let j = 0; j < resultEquipe.equipe?.length!; j++) {
                    this.equipes.push(this.clubEquipe.equipes![i]);
                    this.equipeUtilisateurs.push(resultEquipe.equipe![j]);
                    this.equipeMembres.push(
                      resultEquipe.equipe![j].id?.utilisateur!
                    );
                  }
                });
            }
          });
      });
  }

  triAscEquipe(): void {
    this.equipes = [];
    this.equipeUtilisateurs = [];
    this.equipeMembres = [];

    this.afficheMembres = false;
    this.afficheEquipes = true;
    this.afficheEvents = false;

    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;

        this.clubService
          .getByIdEquipe(this.compte.id!)
          .subscribe((resultUser) => {
            this.clubEquipe = resultUser;
            for (let i = 0; i < this.clubEquipe.equipes!.length!; i++) {
              this.equipeService
                .getByIdWithUtilisateurOrderByDateDebutAsc(
                  this.clubEquipe.equipes![i].id!
                )
                .subscribe((resultEquipe) => {
                  for (let j = 0; j < resultEquipe.equipe?.length!; j++) {
                    this.equipes.push(this.clubEquipe.equipes![i]);
                    this.equipeUtilisateurs.push(resultEquipe.equipe![j]);
                    this.equipeMembres.push(
                      resultEquipe.equipe![j].id?.utilisateur!
                    );
                  }
                });
            }
          });
      });
  }

  triAscEvent(): void {
    this.events = [];
    this.eventUtilisateurs = [];
    this.eventMembres = [];

    this.afficheMembres = false;
    this.afficheEquipes = false;
    this.afficheEvents = true;

    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
        this.clubService
          .getByIdEvenement(this.compte.id!)
          .subscribe((resultUser) => {
            this.clubEvent = resultUser;
            for (let i = 0; i < this.clubEvent.evenements!.length!; i++) {
              this.evenementService
                .getByIdWithUtilisateurOrderByDateDebutAsc(
                  this.clubEvent.evenements![i].id!
                )
                .subscribe((resultEvent) => {
                  for (let j = 0; j < resultEvent.participants!.length!; j++) {
                    this.events.push(this.clubEvent.evenements![i]);
                    this.eventUtilisateurs.push(resultEvent.participants![j]);
                    this.eventMembres.push(
                      resultEvent.participants![j].id?.utilisateur!
                    );
                  }
                });
            }
          });
      });
  }

  triDescEvent(): void {
    this.events = [];
    this.eventUtilisateurs = [];
    this.eventMembres = [];
    this.afficheMembres = false;
    this.afficheEquipes = false;
    this.afficheEvents = true;
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
        this.clubService
          .getByIdEvenement(this.compte.id!)
          .subscribe((resultUser) => {
            this.clubEvent = resultUser;
            for (let i = 0; i < this.clubEvent.evenements!.length!; i++) {
              this.evenementService
                .getByIdWithUtilisateurOrderByDateDebutDesc(
                  this.clubEvent.evenements![i].id!
                )
                .subscribe((resultEvent) => {
                  for (let j = 0; j < resultEvent.participants!.length!; j++) {
                    this.events.push(this.clubEvent.evenements![i]);
                    this.eventUtilisateurs.push(resultEvent.participants![j]);
                    this.eventMembres.push(
                      resultEvent.participants![j].id?.utilisateur!
                    );
                  }
                });
            }
          });
      });
  }
}
