import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inscription-club',
  templateUrl: './inscription-club.component.html',
  styleUrls: ['./inscription-club.component.css'],
})
export class InscriptionClubComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  clickUser() {
    this.router.navigate(['/inscription-utilisateur']);
  }
}
