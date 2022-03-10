import { ClubUtilisateur } from './../../../model/club-utilisateur';
import { ClubUtilisateurService } from './../../../services/club-utilisateur.service';
import { CaracteristiqueService } from './../../../services/caracteristique.service';
import { ProfilService } from './../../../services/profil.service';
import { Profil } from './../../../model/profil';
import { UtilisateurService } from './../../../services/utilisateur.service';
import { ClubService } from './../../../services/club.service';
import { CompteService } from './../../../services/compte.service';
import { Club } from './../../../model/club';
import { Compte } from './../../../model/compte';
import { Component, OnInit } from '@angular/core';
import { Utilisateur } from 'src/app/model/utilisateur';
import { Caracteristique } from 'src/app/model/caracteristique';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-menu-club-membres',
  templateUrl: './menu-club-membres.component.html',
  styleUrls: ['./menu-club-membres.component.css'],
})
export class MenuClubMembresComponent implements OnInit {
  compte: Compte = new Compte();
  club: Club = new Club();

  membres: Array<Utilisateur> = [];
  profils: Array<Profil> = [];
  caracteristiques: Array<Caracteristique> = [];
  datesInscription: Array<Date> = [];
  moyennes: Array<number> = [];
  longueur: number = 0;

  constructor(
    private compteService: CompteService,
    private clubService: ClubService,
    private utilisateurService: UtilisateurService,
    private profilService: ProfilService,
    private caracteristiqueService: CaracteristiqueService,
    private clubUtilisateurService: ClubUtilisateurService
  ) {}

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.compte = result;
        this.clubService
          .getByIdUtilisateur(this.compte.id!)
          .subscribe((res) => {
            this.club = res;
            this.longueur = this.club.listeMembres!.length;
            for (let i = 0; i < this.longueur; i++) {
              this.datesInscription.push(this.club.listeMembres![i].dateDebut!);
              this.utilisateurService
                .getByIdWithProfil(
                  this.club.listeMembres![i].id?.utilisateur?.id!
                )
                .subscribe((user) => {
                  this.membres.push(user);
                  this.profilService
                    .getByIdWithCarac(user.profilUtilisateur?.id!)
                    .subscribe((profilCarac) => {
                      this.profils.push(profilCarac);
                      this.caracteristiqueService
                        .get(profilCarac.caracteristique!.id!)
                        .subscribe((c) => {
                          this.caracteristiques.push(c);
                          this.moyennes.push(
                            (c.agilite! +
                              c.collectif! +
                              c.creativite! +
                              c.detente! +
                              c.determination! +
                              c.endurance! +
                              c.patience! +
                              c.puissance! +
                              c.vitesse!) /
                              9
                          );
                        });
                    });
                });
            }
          });
      });
  }

  delete(cu: ClubUtilisateur) {
    let d = new Date();
    cu.dateFin = d;
    this.clubUtilisateurService
      .updateByIds(this.club.id!, cu.id?.utilisateur?.id!, cu)
      .subscribe((ok) => {
        cu = ok;
        this.membres = [];
        this.profils = [];
        this.caracteristiques = [];
        this.datesInscription = [];
        this.moyennes = [];
        this.getAll();
        console.log(cu);
      });
  }
}
