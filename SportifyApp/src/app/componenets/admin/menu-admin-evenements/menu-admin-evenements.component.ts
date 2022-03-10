import { Utilisateur } from './../../../model/utilisateur';
import { EvenementUtilisateur } from './../../../model/evenement-utilisateur';
import { UtilisateurService } from './../../../services/utilisateur.service';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Evenement } from 'src/app/model/evenement';
import { EvenementService } from 'src/app/services/evenement.service';

@Component({
  selector: 'app-menu-admin-evenements',
  templateUrl: './menu-admin-evenements.component.html',
  styleUrls: ['./menu-admin-evenements.component.css'],
})
export class MenuAdminEvenementsComponent implements OnInit {
  evenementsObservable!: Observable<Evenement[]>;
  evenementsGetAll: Array<Evenement> = [];
  evenements: Array<Evenement> = [];
  evenementClubs: Array<Evenement> = [];
  evenementUtilisateurs: Array<EvenementUtilisateur> = [];
  membres: Array<Utilisateur> = [];
  constructor(
    private evenementService: EvenementService,
    private utilisateurService: UtilisateurService
  ) {}

  ngOnInit(): void {
    this.evenementsObservable = this.evenementService.getAll();
    this.evenementsObservable = this.evenementService.getAll();
    this.evenementService.getAll().subscribe((listeEvenements) => {
      this.evenementsGetAll = listeEvenements;

      for (let i = 0; i < this.evenementsGetAll.length; i++) {
        this.evenementService
          .getByIdWithUtilisateur(this.evenementsGetAll[i].id!)
          .subscribe((resultEvenement) => {
            for (let j = 0; j < resultEvenement.participants!.length; j++) {
              this.evenements.push(resultEvenement);
              this.evenementService
                .getByIdWithClub(this.evenementsGetAll[i].id!)
                .subscribe((resultClub) => {
                  this.evenementClubs.push(resultClub);
                });
              this.evenementUtilisateurs.push(resultEvenement.participants![j]);
              this.utilisateurService
                .get(resultEvenement.participants![j].id?.utilisateur?.id!)
                .subscribe((user) => {
                  this.membres.push(user);
                });
            }
          });
      }
    });
  }
}
