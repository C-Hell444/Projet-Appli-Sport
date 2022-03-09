import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Club } from 'src/app/model/club';
import { ClubService } from 'src/app/services/club.service';

@Component({
  selector: 'app-menu-club-equipes',
  templateUrl: './menu-club-equipes.component.html',
  styleUrls: ['./menu-club-equipes.component.css'],
})
export class MenuClubEquipesComponent implements OnInit {
  clubsObservable!: Observable<Club[]>;
  constructor(private clubService: ClubService) {}

  ngOnInit(): void {
    this.clubsObservable = this.clubService.getAll();
  }
}
