import { EvenementUtilisateurService } from './../../../services/evenement-utilisateur.service';
import { EvenementUtilisateur } from './../../../model/evenement-utilisateur';
import { EvenementService } from './../../../services/evenement.service';
import { UtilisateurService } from './../../../services/utilisateur.service';
import { CompteService } from './../../../services/compte.service';
import { Evenement } from './../../../model/evenement';
import { Utilisateur } from './../../../model/utilisateur';
import { Compte } from './../../../model/compte';
import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';

@Component({
  selector: 'app-menu-utilisateur-evenements',
  templateUrl: './menu-utilisateur-evenements.component.html',
  styleUrls: ['./menu-utilisateur-evenements.component.css'],
})
export class MenuUtilisateurEvenementsComponent implements OnInit {
  compte: Compte = new Compte();
  utilisateur: Utilisateur = new Utilisateur();
  evenementUtilisateurs: Array<EvenementUtilisateur> = [];
  evenements: Array<Evenement> = [];
  longueur: number = 0;

  dateJour: moment.Moment = moment();

  dates: Array<moment.Moment> = [];

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,

    private evenementService: EvenementService,
    private evenementUtilisateurService: EvenementUtilisateurService
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
          .getByIdWithEvenementUtilisateur(this.compte.id!)
          .subscribe((res) => {
            this.utilisateur = res;
            this.evenementUtilisateurs = this.utilisateur.evenements!;
            this.longueur = this.utilisateur.evenements!.length;
            for (let i = 0; i < this.longueur; i++) {
              this.dates.push(moment(this.evenementUtilisateurs[i].dateFin));
              console.log(this.dates);
              this.evenementService
                .get(this.utilisateur.evenements![i].id?.evenement?.id!)
                .subscribe((evenement) => {
                  this.evenements.push(evenement);
                });
            }
          });
      });
  }
  delete(eu: EvenementUtilisateur) {
    console.log(eu.dateFin);
    eu.dateFin = new Date();
    console.log(eu.dateFin);
    this.evenementUtilisateurService
      .updateByIds(eu.id?.evenement?.id!, this.utilisateur.id!, eu)
      .subscribe((ok) => {
        eu = ok;
        this.evenements = [];
        this.evenementUtilisateurs = [];
        this.dates = [];
        console.log(eu.dateFin);
        this.getAll();
      });
  }
}
