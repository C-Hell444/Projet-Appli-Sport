import { Utilisateur } from './../../../model/utilisateur';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-menu-admin-utilisateurs-edit',
  templateUrl: './menu-admin-utilisateurs-edit.component.html',
  styleUrls: ['./menu-admin-utilisateurs-edit.component.css'],
})
export class MenuAdminUtilisateursEditComponent implements OnInit {
  utilisateursObservable!: Observable<Utilisateur[]>;
  utilisateur: Utilisateur = new Utilisateur();
  constructor(
    private utilisateurService: UtilisateurService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.utilisateursObservable = this.utilisateurService.getAll();
    //localStorage.setItem('id', this.compte.id!.toString());

    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.utilisateurService.get(params['id']).subscribe((result) => {
          this.utilisateur = result;
        });
      }
    });
  }
}
