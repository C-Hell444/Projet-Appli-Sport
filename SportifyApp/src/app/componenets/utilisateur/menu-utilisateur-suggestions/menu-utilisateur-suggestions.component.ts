import { EvenementService } from './../../../services/evenement.service';
import { EquipeService } from './../../../services/equipe.service';
import { ClubUtilisateurKey } from './../../../model/club-utilisateur-key';
import { ClubUtilisateurService } from './../../../services/club-utilisateur.service';
import { SportService } from './../../../services/sport.service';
import { CaracteristiqueService } from './../../../services/caracteristique.service';
import { ProfilService } from './../../../services/profil.service';
import { ClubService } from 'src/app/services/club.service';
import { UtilisateurService } from './../../../services/utilisateur.service';
import { CompteService } from './../../../services/compte.service';
import { Club } from './../../../model/club';
import { Sport } from './../../../model/sport';
import { Caracteristique } from './../../../model/caracteristique';
import { Profil } from './../../../model/profil';
import { Utilisateur } from './../../../model/utilisateur';
import { Compte } from './../../../model/compte';
import { Component, OnInit } from '@angular/core';
import { ClubUtilisateur } from 'src/app/model/club-utilisateur';
import { Evenement } from 'src/app/model/evenement';

@Component({
  selector: 'app-menu-utilisateur-suggestions',
  templateUrl: './menu-utilisateur-suggestions.component.html',
  styleUrls: ['./menu-utilisateur-suggestions.component.css'],
})
export class MenuUtilisateurSuggestionsComponent implements OnInit {
  compte: Compte = new Compte();
  utilisateur: Utilisateur = new Utilisateur();
  profil: Profil = new Profil();
  caracteristique: Caracteristique = new Caracteristique();

  sports: Array<Sport> = [];
  clubs: Array<Club> = [];

  afficheSport: boolean = true;
  afficheClub: boolean = false;

  nomSport: string = '';

  cuk: ClubUtilisateurKey = new ClubUtilisateurKey();
  cu: ClubUtilisateur = new ClubUtilisateur();

  partenaires: Array<Utilisateur> = [];

  longueur: number = 0;

  clubsUtilisateur: Array<Club> = [];
  clubPresent: boolean = false;

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private clubService: ClubService,
    private profilService: ProfilService,
    private caracteristiqueService: CaracteristiqueService,
    private sportService: SportService,
    private clubUtilisateurService: ClubUtilisateurService,
    private evenementService: EvenementService
  ) {}

  ngOnInit(): void {
    this.afficheSport = true;
    this.afficheClub = false;
    this.nomSport = '';
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.compte = result;
        this.utilisateurService
          .getByIdWithClubUtilisateur(this.compte.id!)
          .subscribe((res) => {
            this.utilisateur = res;
            this.longueur = res.clubs!.length;
            for (let i = 0; i < this.longueur; i++) {
              this.clubService
                .get(this.utilisateur.clubs![i].id?.club?.id!)
                .subscribe((club) => {
                  this.clubsUtilisateur.push(club);
                });
            }
          });
        this.utilisateurService
          .getByIdWithProfil(result.id!)
          .subscribe((res) => {
            this.utilisateur = res;
            this.profilService
              .getByIdWithCarac(res.profilUtilisateur!.id!)
              .subscribe((prof) => {
                this.profil = prof;
                this.caracteristiqueService
                  .get(prof.caracteristique!.id!)
                  .subscribe((carac) => {
                    this.caracteristique = carac;
                    this.sportService
                      .getAllByCaracteristique(
                        carac.collectif!,
                        carac.creativite!,
                        carac.determination!,
                        carac.patience!,
                        carac.detente!,
                        carac.agilite!,
                        carac.puissance!,
                        carac.vitesse!,
                        carac.endurance!
                      )
                      .subscribe((sp) => {
                        this.sports = sp;
                      });
                  });
              });
          });
      });
  }

  listClubs(id: number, nom: string) {
    this.afficheSport = false;
    this.afficheClub = true;
    this.clubs = [];
    this.nomSport = nom;
    this.clubService.getAllByIdSport(id).subscribe((res) => {
      res.forEach((e) => {
        this.clubPresent = false;
        for (let i = 0; i < this.clubsUtilisateur.length; i++) {
          if (this.clubsUtilisateur[i].id == e.id) {
            this.clubPresent = true;
          }
        }
        if (this.clubPresent == false) {
          this.clubs.push(e);
        }
      });
    });
  }

  backSport() {
    this.afficheSport = true;
    this.afficheClub = false;
  }

  addClub(id: number) {
    let d: Date = new Date();
    this.clubService.get(id).subscribe((c) => {
      this.cuk.club = c;
      this.utilisateurService.get(this.utilisateur.id!).subscribe((u) => {
        this.cuk.utilisateur = u;
        this.cu.id = this.cuk;
        this.cu.dateDebut = d;
        this.clubUtilisateurService.create(this.cu).subscribe((ok) => {
          this.ngOnInit();
          this.afficheClub = false;
          this.afficheSport = true;
        });
      });
    });
  }

  listUser(id: number, nom: string) {
    this.afficheClub = false;
    this.afficheSport = false;
    this.nomSport = nom;
    this.partenaires = [];
    this.utilisateurService.getAllByIdSport(id).subscribe((res) => {
      for (let i = 0; i < res.length; i++) {
        if (res[i].id != this.utilisateur.id) {
          this.partenaires.push(res[i]);
        }
      }
    });
  }
}
