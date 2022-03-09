import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Sexe } from './../../../model/sexe';
import { CaracteristiqueService } from './../../../services/caracteristique.service';
import { ProfilService } from './../../../services/profil.service';
import { UtilisateurService } from './../../../services/utilisateur.service';
import { CompteService } from './../../../services/compte.service';
import { Interet } from './../../../model/interet';
import { Caracteristique } from './../../../model/caracteristique';
import { Profil } from './../../../model/profil';
import { Utilisateur } from './../../../model/utilisateur';
import { Compte } from './../../../model/compte';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-utilisateur-edit',
  templateUrl: './menu-utilisateur-edit.component.html',
  styleUrls: ['./menu-utilisateur-edit.component.css'],
})
export class MenuUtilisateurEditComponent implements OnInit {
  compte: Compte = new Compte();
  utilisateurProfil: Utilisateur = new Utilisateur();
  utilisateurInteret: Utilisateur = new Utilisateur();
  profil: Profil = new Profil();
  carac: Caracteristique = new Caracteristique();
  interets: Interet[] = new Array<Interet>();
  utilisateur: Utilisateur = new Utilisateur();

  sexes = Sexe;

  form!: FormGroup;

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private profilService: ProfilService,
    private caracteristiqueService: CaracteristiqueService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
        this.utilisateurService.get(this.compte.id!).subscribe((user) => {
          this.utilisateur = user;
        });
        this.utilisateurService
          .getByIdWithProfil(this.compte.id!)
          .subscribe((userProfil) => {
            this.utilisateurProfil = userProfil;
            this.profilService
              .getByIdWithCarac(this.utilisateurProfil.profilUtilisateur?.id!)
              .subscribe((resultProfil) => {
                this.profil = resultProfil;
                this.caracteristiqueService
                  .get(this.profil.caracteristique?.id!)
                  .subscribe((resultCarac) => (this.carac = resultCarac));
              });
            this.utilisateurService
              .getByIdWithInteret(this.compte.id!)
              .subscribe((resultUtilisateurInteret) => {
                this.utilisateurInteret = resultUtilisateurInteret;
                this.interets = this.utilisateurInteret.interets!;
              });
          });
      });

    this.form = new FormGroup({
      nom: new FormControl('', [Validators.required]),
    });
  }

  public save() {}
}
