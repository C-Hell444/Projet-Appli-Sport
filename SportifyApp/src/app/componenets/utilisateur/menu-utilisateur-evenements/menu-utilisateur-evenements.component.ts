import { EvenementUtilisateurService } from './../../../services/evenement-utilisateur.service';
import { EvenementUtilisateur } from './../../../model/evenement-utilisateur';
import { EvenementService } from './../../../services/evenement.service';
import { UtilisateurService } from './../../../services/utilisateur.service';
import { CompteService } from './../../../services/compte.service';
import { Evenement } from './../../../model/evenement';
import { Utilisateur } from './../../../model/utilisateur';
import { Compte } from './../../../model/compte';
import { Component, OnInit } from '@angular/core';

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
  dateJour: Date = new Date();
  date: Date = new Date();
  dates: Array<Date> = [];

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private equipeService: EvenementService,
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
              this.dates.push(this.utilisateur.evenements![i].dateFin!);
              this.equipeService
                .get(this.utilisateur.evenements![i].id?.evenement?.id!)
                .subscribe((evenement) => {
                  this.evenements.push(evenement);
                  console.log(this.evenements);
                });
            }
          });
      });
  }
  delete(eu: EvenementUtilisateur) {
    let d = new Date();
    eu.dateFin = d;
    this.evenementUtilisateurService
      .updateByIds(eu.id?.evenement?.id!, this.utilisateur.id!, eu)
      .subscribe((ok) => {
        eu = ok;
        this.evenements = [];
        this.evenementUtilisateurs = [];
        this.getAll();
      });
  }
}
