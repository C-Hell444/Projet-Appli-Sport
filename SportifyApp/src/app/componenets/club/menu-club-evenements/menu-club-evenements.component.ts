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

@Component({
  selector: 'app-menu-club-evenements',
  templateUrl: './menu-club-evenements.component.html',
  styleUrls: ['./menu-club-evenements.component.css'],
})
export class MenuClubEvenementsComponent implements OnInit {
  compte: Compte = new Compte();
  clubEvent: Club = new Club();
  events: Array<Evenement> = [];

  eventUtilisateurs: Array<EvenementUtilisateur> = [];

  eventMembres: Array<Utilisateur> = [];
  constructor(
    private compteService: CompteService,
    private clubService: ClubService,
    private utilisateurService: UtilisateurService,
    private evenementService: EvenementService
  ) {}

  ngOnInit(): void {
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
                    this.utilisateurService
                      .get(resultEvent.participants![j].id?.utilisateur?.id!)
                      .subscribe((user) => {
                        this.eventMembres.push(user);
                      });
                  }
                });
            }
          });
      });
  }
}
