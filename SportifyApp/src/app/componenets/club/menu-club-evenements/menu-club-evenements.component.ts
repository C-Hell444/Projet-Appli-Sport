import { Utilisateur } from 'src/app/model/utilisateur';
import { EvenementUtilisateur } from './../../../model/evenement-utilisateur';
import { Evenement } from 'src/app/model/evenement';
import { Club } from 'src/app/model/club';
import { Compte } from 'src/app/model/compte';
import { CompteService } from 'src/app/services/compte.service';
import { ClubService } from 'src/app/services/club.service';
import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { EvenementService } from 'src/app/services/evenement.service';
import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';

@Component({
  selector: 'app-menu-club-evenements',
  templateUrl: './menu-club-evenements.component.html',
  styleUrls: ['./menu-club-evenements.component.css'],
})
export class MenuClubEvenementsComponent implements OnInit {
  compte: Compte = new Compte();
  club: Club = new Club();
  evenement: Evenement = new Evenement();
  membresEvenement: Array<Utilisateur> = [];
  eventUtilisateurs: Array<EvenementUtilisateur> = [];
  longueur: number = 0;
  dateJour: moment.Moment = moment();
  dates: Array<moment.Moment> = [];

  tab: boolean = true;
  nomEvenement: string = '';

  constructor(
    private compteService: CompteService,
    private clubService: ClubService,
    private evenementService: EvenementService,
    private utilisateurService: UtilisateurService
  ) {}

  ngOnInit(): void {
    this.tab = true;
    this.getAll();
  }

  detail(id: number, nom: string) {
    this.nomEvenement = nom;
    this.tab = false;
    this.membresEvenement = [];
    this.eventUtilisateurs = [];
    this.evenementService.getByIdWithUtilisateur(id).subscribe((resultat) => {
      this.evenement = resultat;
      this.longueur = this.evenement.participants!.length;
      for (let i = 0; i < this.longueur; i++) {
        this.utilisateurService
          .getByIdWithProfil(
            this.evenement.participants![i].id?.utilisateur?.id!
          )
          .subscribe((user) => {
            this.membresEvenement.push(user);
            this.eventUtilisateurs.push(this.evenement.participants![i]);
            this.dates.push(moment(this.evenement.participants![i].dateFin));
          });
      }
    });
  }

  retour() {
    this.tab = true;
  }

  getAll() {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.compte = result;
        this.clubService.getByIdEvenement(this.compte.id!).subscribe((res) => {
          this.club = res;
        });
      });
  }

  delete(id: number) {
    this.evenementService.delete(id).subscribe((ok) => {
      this.membresEvenement = [];
      this.getAll();
    });
  }
}
