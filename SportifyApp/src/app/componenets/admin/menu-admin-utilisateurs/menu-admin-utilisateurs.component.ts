import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { Utilisateur } from 'src/app/model/utilisateur';

@Component({
  selector: 'app-menu-admin-utilisateurs',
  templateUrl: './menu-admin-utilisateurs.component.html',
  styleUrls: ['./menu-admin-utilisateurs.component.css'],
})
export class MenuAdminUtilisateursComponent implements OnInit {
  utilisateursObservable!: Observable<Utilisateur[]>;
  constructor(private utilisateurService: UtilisateurService) {}

  ngOnInit(): void {
    this.utilisateursObservable = this.utilisateurService.getAll();
  }

  delete(id: number) {
    this.utilisateurService.delete(id).subscribe((ok) => {
      this.utilisateursObservable = this.utilisateurService.getAll();
    });
  }
}
