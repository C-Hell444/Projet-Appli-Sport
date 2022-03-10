import { EquipeUtilisateur } from './../../../model/equipe-utilisateur';
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
  clubEquipe: Club = new Club();
  equipes: Array<Equipe> = [];

  equipeUtilisateurs: Array<EquipeUtilisateur> = [];

  equipeMembres: Array<Utilisateur> = [];

  constructor(
    private compteService: CompteService,
    private clubService: ClubService,
    private equipeService: EquipeService,
    private utilisateurService: UtilisateurService
  ) {}

  ngOnInit(): void {
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
                    this.utilisateurService
                      .get(resultEquipe.equipe![j].id?.utilisateur?.id!)
                      .subscribe((user) => {
                        this.equipeMembres.push(user);
                      });
                  }
                });
            }
          });
      });
  }
}
