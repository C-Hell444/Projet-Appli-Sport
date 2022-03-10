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
import { EquipeUtilisateur } from 'src/app/model/equipe-utilisateur';

@Component({
  selector: 'app-menu-club-equipes',
  templateUrl: './menu-club-equipes.component.html',
  styleUrls: ['./menu-club-equipes.component.css'],
})
export class MenuClubEquipesComponent implements OnInit {
  compte: Compte = new Compte();
  club: Club = new Club();
  equipe: Equipe = new Equipe();
  membresEquipe: Array<Utilisateur> = [];
  equipeUtilisateurs: Array<EquipeUtilisateur> = [];
  longueur: number = 0;

  tab: boolean = true;
  nomEquipe: string = '';

  constructor(
    private compteService: CompteService,
    private clubService: ClubService,
    private equipeService: EquipeService,
    private utilisateurService: UtilisateurService
  ) {}

  ngOnInit(): void {
    this.tab = true;
    this.getAll();
  }

  detail(id: number, nom: string) {
    this.nomEquipe = nom;
    this.tab = false;
    this.membresEquipe = [];
    this.equipeUtilisateurs = [];

    this.equipeService.getByIdWithUtilisateur(id).subscribe((resultat) => {
      this.equipe = resultat;
      this.longueur = this.equipe.equipe!.length;
      for (let i = 0; i < this.longueur; i++) {
        this.utilisateurService
          .getByIdWithProfil(this.equipe.equipe![i].id?.utilisateur?.id!)
          .subscribe((user) => {
            this.membresEquipe.push(user);
            this.equipeUtilisateurs.push(this.equipe.equipe![i]);
          });
      }
    });
  }

  retour() {
    this.tab = true;
  }

  getAll(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.compte = result;
        this.clubService.getByIdEquipe(this.compte.id!).subscribe((res) => {
          this.club = res;
        });
      });
  }

  delete(id: number) {
    this.equipeService.delete(id).subscribe((ok) => {
      this.membresEquipe = [];
      this.getAll();
    });
  }
}
