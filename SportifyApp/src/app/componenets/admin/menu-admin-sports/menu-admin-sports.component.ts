import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Sport } from 'src/app/model/sport';
import { SportService } from 'src/app/services/sport.service';

@Component({
  selector: 'app-menu-admin-sports',
  templateUrl: './menu-admin-sports.component.html',
  styleUrls: ['./menu-admin-sports.component.css'],
})
export class MenuAdminSportsComponent implements OnInit {
  sportsObservable!: Observable<Sport[]>;
  constructor(private sportService: SportService) {}

  ngOnInit(): void {
    this.sportsObservable = this.sportService.getAll();
  }
}
