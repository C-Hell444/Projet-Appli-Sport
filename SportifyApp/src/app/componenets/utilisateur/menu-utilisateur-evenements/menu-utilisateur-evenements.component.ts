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
  evenements: Array<Evenement> = [];
  longueur: number = 0;

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private equipeService: EvenementService
  ) {}

  ngOnInit(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.compte = result;
        this.utilisateurService
          .getByIdWithEvenementUtilisateur(this.compte.id!)
          .subscribe((res) => {
            this.utilisateur = res;
            this.longueur = this.utilisateur.evenements!.length;
            for (let i = 0; i < this.longueur; i++) {
              this.equipeService
                .get(this.utilisateur.evenements![i].id?.evenement?.id!)
                .subscribe((evenement) => {
                  this.evenements.push(evenement);
                });
            }
          });
      });
  }
}
