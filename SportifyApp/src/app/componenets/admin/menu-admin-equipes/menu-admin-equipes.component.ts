import { Club } from 'src/app/model/club';
import { ClubService } from 'src/app/services/club.service';
import { EquipeUtilisateur } from './../../../model/equipe-utilisateur';
import { Utilisateur } from 'src/app/model/utilisateur';
import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Equipe } from 'src/app/model/equipe';
import { EquipeService } from 'src/app/services/equipe.service';

@Component({
  selector: 'app-menu-admin-equipes',
  templateUrl: './menu-admin-equipes.component.html',
  styleUrls: ['./menu-admin-equipes.component.css'],
})
export class MenuAdminEquipesComponent implements OnInit {
  equipesObservable!: Observable<Equipe[]>;
  equipesGetAll: Array<Equipe> = [];
  equipes: Array<Equipe> = [];
  equipeClubs: Array<Equipe> = [];
  equipeUtilisateurs: Array<EquipeUtilisateur> = [];
  membres: Array<Utilisateur> = [];
  constructor(
    private equipeService: EquipeService,
    private utilisateurService: UtilisateurService,
    private clubService: ClubService
  ) {}

  ngOnInit(): void {
    this.getAll();
  }

  getAll(): void {
    this.equipeService.getAll().subscribe((listeEquipes) => {
      this.equipesGetAll = listeEquipes;

      for (let i = 0; i < this.equipesGetAll.length; i++) {
        this.equipeService
          .getByIdWithUtilisateur(this.equipesGetAll[i].id!)
          .subscribe((resultEquipe) => {
            for (let j = 0; j < resultEquipe.equipe!.length; j++) {
              this.equipes.push(resultEquipe);
              this.equipeService
                .getByIdWithClub(this.equipesGetAll[i].id!)
                .subscribe((resultClub) => {
                  this.equipeClubs.push(resultClub);
                });
              this.equipeUtilisateurs.push(resultEquipe.equipe![j]);
              this.utilisateurService
                .get(resultEquipe.equipe![j].id?.utilisateur?.id!)
                .subscribe((user) => {
                  this.membres.push(user);
                });
            }
          });
      }
    });
  }

  delete(id: number) {
    this.equipeService.delete(id).subscribe((ok) => {
      this.equipesGetAll = [];
      this.equipes = [];
      this.equipeClubs = [];
      this.equipeUtilisateurs = [];
      this.membres = [];
      this.getAll();
    });
  }
}
