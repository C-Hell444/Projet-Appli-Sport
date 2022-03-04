import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inscription-utilisateur',
  templateUrl: './inscription-utilisateur.component.html',
  styleUrls: ['./inscription-utilisateur.component.css'],
})
export class InscriptionUtilisateurComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  clickClub() {
    this.router.navigate(['/inscription-club']);
  }
}
