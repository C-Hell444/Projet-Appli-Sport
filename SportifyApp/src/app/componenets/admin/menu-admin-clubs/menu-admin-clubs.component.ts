import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Club } from 'src/app/model/club';
import { ClubService } from 'src/app/services/club.service';

@Component({
  selector: 'app-menu-admin-clubs',
  templateUrl: './menu-admin-clubs.component.html',
  styleUrls: ['./menu-admin-clubs.component.css'],
})
export class MenuAdminClubsComponent implements OnInit {
  clubsObservable!: Observable<Club[]>;
  clubs: Club[] = [];

  constructor(private clubService: ClubService) {}

  ngOnInit(): void {
    this.getAll();
  }

  getAll(): void {
    this.clubService.getAll().subscribe((ok) => {
      for (let c of ok) {
        this.clubService.getByIdWithSport(c.id!).subscribe((res) => {
          this.clubs.push(res);
        });
      }
    });
  }

  delete(id: number) {
    this.clubService.delete(id).subscribe((ok) => {
      this.clubs = [];

      this.getAll();
    });
  }
}
