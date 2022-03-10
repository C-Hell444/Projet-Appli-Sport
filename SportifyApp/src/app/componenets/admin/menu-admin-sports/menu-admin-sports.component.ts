import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Sport } from 'src/app/model/sport';
import { SportService } from 'src/app/services/sport.service';
import { Club } from 'src/app/model/club';

@Component({
  selector: 'app-menu-admin-sports',
  templateUrl: './menu-admin-sports.component.html',
  styleUrls: ['./menu-admin-sports.component.css'],
})
export class MenuAdminSportsComponent implements OnInit {
  sportsObservable!: Observable<Sport[]>;
  clubsObservable!: Observable<Club[]>;
  sport!: Sport;
  clubs: Club[] = [];
  sports: Sport[] = [];
  sports2: Sport[] = [];
  constructor(private sportService: SportService) {}

  ngOnInit(): void {
    this.sportService.getAll().subscribe((ok) => {
      this.sports = ok;
      for (let s of this.sports) {
        this.sportService.getByIdWithClub(s.id!).subscribe((res) => {
          this.sports2.push(res);
        });
      }
    });
  }
}
