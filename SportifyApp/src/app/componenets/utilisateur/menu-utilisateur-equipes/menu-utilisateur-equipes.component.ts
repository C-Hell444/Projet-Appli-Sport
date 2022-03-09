import { Equipe } from './../../../model/equipe';
import { EquipeService } from './../../../services/equipe.service';
import { UtilisateurService } from './../../../services/utilisateur.service';
import { CompteService } from './../../../services/compte.service';
import { Club } from './../../../model/club';
import { Utilisateur } from './../../../model/utilisateur';
import { Compte } from './../../../model/compte';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-utilisateur-equipes',
  templateUrl: './menu-utilisateur-equipes.component.html',
  styleUrls: ['./menu-utilisateur-equipes.component.css'],
})
export class MenuUtilisateurEquipesComponent implements OnInit {
  compte: Compte = new Compte();
  utilisateur: Utilisateur = new Utilisateur();
  equipes: Array<Equipe> = [];
  longueur: number = 0;

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private equipeService: EquipeService
  ) {}

  ngOnInit(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.compte = result;
        this.utilisateurService
          .getByIdWithEquipeUtilisateur(this.compte.id!)
          .subscribe((res) => {
            this.utilisateur = res;
            this.longueur = this.utilisateur.equipes!.length;
            for (let i = 0; i < this.longueur; i++) {
              this.equipeService
                .getByIdWithClub(this.utilisateur.equipes![i].id?.equipe?.id!)
                .subscribe((equipe) => {
                  this.equipes.push(equipe);
                });
            }
          });
      });
  }
}
