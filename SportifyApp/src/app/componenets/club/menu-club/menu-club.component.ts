import { Sport } from './../../../model/sport';
import { Component, OnInit } from '@angular/core';
import { Club } from 'src/app/model/club';
import { Compte } from 'src/app/model/compte';
import { ClubService } from 'src/app/services/club.service';
import { CompteService } from 'src/app/services/compte.service';
import { SportService } from 'src/app/services/sport.service';

@Component({
  selector: 'app-menu-club',
  templateUrl: './menu-club.component.html',
  styleUrls: ['./menu-club.component.css'],
})
export class MenuClubComponent implements OnInit {
  compte: Compte = new Compte();
  club: Club = new Club();
  constructor(
    private compteService: CompteService,
    private clubService: ClubService
  ) {}

  ngOnInit(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((results) => {
        this.compte = results;
        this.clubService.getByIdWithSport(this.compte.id!).subscribe((ok) => {
          this.club = ok;
        });
      });
  }
}
