import { EvenementUtilisateurService } from './../../../services/evenement-utilisateur.service';
import { EquipeUtilisateurService } from './../../../services/equipe-utilisateur.service';
import { EquipeUtilisateurKey } from './../../../model/equipe-utilisateur-key';
import { EvenementUtilisateurKey } from './../../../model/evenement-utilisateur-key';
import { Evenement } from './../../../model/evenement';
import { EvenementService } from './../../../services/evenement.service';
import { EquipeService } from './../../../services/equipe.service';
import { ClubUtilisateurService } from './../../../services/club-utilisateur.service';
import { ClubService } from './../../../services/club.service';
import { ClubUtilisateur } from './../../../model/club-utilisateur';
import { Club } from './../../../model/club';
import { UtilisateurService } from './../../../services/utilisateur.service';
import { CompteService } from './../../../services/compte.service';
import { Compte } from './../../../model/compte';
import { Utilisateur } from './../../../model/utilisateur';
import { Component, OnInit } from '@angular/core';
import { Equipe } from 'src/app/model/equipe';
import { EvenementUtilisateur } from 'src/app/model/evenement-utilisateur';
import { EquipeUtilisateur } from 'src/app/model/equipe-utilisateur';

@Component({
  selector: 'app-menu-utilisateur-clubs',
  templateUrl: './menu-utilisateur-clubs.component.html',
  styleUrls: ['./menu-utilisateur-clubs.component.css'],
})
export class MenuUtilisateurClubsComponent implements OnInit {
  compte: Compte = new Compte();
  utilisateur: Utilisateur = new Utilisateur();
  clubUtilisateur: Array<ClubUtilisateur> = [];
  clubs: Array<Club> = [];
  longueur: number = 0;

  afficheEquipe = false;
  afficheEvenement = false;

  nom: string = '';

  listEquipe: Array<Equipe> = [];
  listEvenement: Array<Evenement> = [];

  evuk: EvenementUtilisateurKey = new EvenementUtilisateurKey();
  evu: EvenementUtilisateur = new EvenementUtilisateur();

  equk: EquipeUtilisateurKey = new EquipeUtilisateurKey();
  equ: EquipeUtilisateur = new EquipeUtilisateur();

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private clubService: ClubService,
    private equipeService: EquipeService,
    private evenementService: EvenementService,
    private equipeUtilisateurService: EquipeUtilisateurService,
    private evenementUtilisateurService: EvenementUtilisateurService
    private clubService: ClubService,
    private clubUtilisateurService: ClubUtilisateurService
  ) {}

  ngOnInit(): void {
    this.clubs = [];
    this.afficheEquipe = false;
    this.afficheEvenement = false;
    this.getAll();
  }

  getAll() {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.compte = result;
        this.utilisateurService
          .getByIdWithClubUtilisateur(this.compte.id!)
          .subscribe((res) => {
            this.utilisateur = res;
            this.clubUtilisateur = this.utilisateur.clubs!;
            this.longueur = this.utilisateur.clubs!.length;
            for (let i = 0; i < this.longueur; i++) {
              this.clubService
                .getByIdWithSport(this.utilisateur.clubs![i].id?.club?.id!)
                .subscribe((club) => {
                  this.clubs.push(club);
                });
            }
          });
      });
  }

  showClub() {
    this.afficheEquipe = false;
    this.afficheEvenement = false;
    this.nom = '';
    this.ngOnInit();
  }

  showEquipe(id: number, nomClub: string) {
    this.listEquipe = [];
    this.afficheEquipe = true;
    this.afficheEvenement = false;
    this.nom = nomClub;
    this.clubService.getByIdEquipe(id).subscribe((club) => {
      for (let i = 0; i < club.equipes!.length; i++) {
        this.listEquipe.push(club.equipes![i]);
      }
    });
  }

  showEvenement(id: number, nomClub: string) {
    this.listEvenement = [];
    this.afficheEquipe = false;
    this.afficheEvenement = true;
    this.nom = nomClub;
    this.clubService.getByIdEvenement(id).subscribe((club) => {
      for (let i = 0; i < club.evenements!.length; i++) {
        this.listEvenement.push(club.evenements![i]);
      }
    });
  }

  addEquipe(id: number) {
    let d: Date = new Date();
    this.equipeService.get(id).subscribe((e) => {
      this.equk.equipe = e;
      this.utilisateurService.get(this.utilisateur.id!).subscribe((u) => {
        this.equk.utilisateur = u;
        this.equ.id = this.equk;
        this.equ.dateDebut = d;
        this.equipeUtilisateurService.create(this.equ).subscribe((ok) => {
          this.afficheEquipe = false;
          this.afficheEvenement = false;
        });
      });
    });
  }

  addEvenement(id: number) {
    this.evenementService.get(id).subscribe((e) => {
      this.evuk.evenement = e;
      this.utilisateurService.get(this.utilisateur.id!).subscribe((u) => {
        this.evuk.utilisateur = u;
        this.evu.id = this.evuk;
        this.evu.dateDebut = e.dateDebut;
        this.evu.dateFin = e.dateFin;
        this.evenementUtilisateurService.create(this.evu).subscribe((ok) => {
          this.afficheEquipe = false;
          this.afficheEvenement = false;
        });
      });
    });
  }

  delete(cu: ClubUtilisateur) {
    let d = new Date();
    cu.dateFin = d;
    this.clubUtilisateurService
      .updateByIds(cu.id?.club?.id!, this.utilisateur.id!, cu)
      .subscribe((ok) => {
        cu = ok;
        this.clubs = [];
        this.clubUtilisateur = [];
        this.getAll();
      });
  }
}
