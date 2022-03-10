import { EquipeUtilisateurService } from './../../../services/equipe-utilisateur.service';
import { EquipeUtilisateur } from './../../../model/equipe-utilisateur';
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
  equipeUtilisateurs: Array<EquipeUtilisateur> = [];
  longueur: number = 0;

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private equipeService: EquipeService,
    private equipeUtilisateurService: EquipeUtilisateurService
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
          .getByIdWithEquipeUtilisateur(this.compte.id!)
          .subscribe((res) => {
            this.utilisateur = res;
            this.equipeUtilisateurs = this.utilisateur.equipes!;
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

  delete(eu: EquipeUtilisateur) {
    console.log(eu.dateFin);
    eu.dateFin = new Date();
    console.log(eu.dateFin);
    this.equipeUtilisateurService
      .updateByIds(eu.id?.equipe?.id!, this.utilisateur.id!, eu)
      .subscribe((ok) => {
        eu = ok;
        this.equipes = [];
        this.equipeUtilisateurs = [];
        console.log(eu.dateFin);
        this.getAll();
      });
  }
}
