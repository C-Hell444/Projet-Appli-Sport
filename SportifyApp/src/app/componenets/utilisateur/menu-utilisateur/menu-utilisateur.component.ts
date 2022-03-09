import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { Compte } from './../../../model/compte';
import { CompteService } from './../../../services/compte.service';
import { Utilisateur } from 'src/app/model/utilisateur';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-utilisateur',
  templateUrl: './menu-utilisateur.component.html',
  styleUrls: ['./menu-utilisateur.component.css'],
})
export class MenuUtilisateurComponent implements OnInit {
  compte: Compte = new Compte();

  utilisateurProfil: Utilisateur = new Utilisateur();

  constructor(
    private compteService: CompteService,
    private utilisateurService: UtilisateurService
  ) {}

  ngOnInit(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.compte = result;
        this.utilisateurService
          .getByIdWithProfil(this.compte.id!)
          .subscribe((ok) => {
            this.utilisateurProfil = ok;
          });
      });
  }
}
