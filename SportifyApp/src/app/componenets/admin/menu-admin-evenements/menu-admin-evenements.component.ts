import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Evenement } from 'src/app/model/evenement';
import { EvenementService } from 'src/app/services/evenement.service';

@Component({
  selector: 'app-menu-admin-evenements',
  templateUrl: './menu-admin-evenements.component.html',
  styleUrls: ['./menu-admin-evenements.component.css'],
})
export class MenuAdminEvenementsComponent implements OnInit {
  evenementsObservable!: Observable<Evenement[]>;
  constructor(private evenementService: EvenementService) {}

  ngOnInit(): void {
    this.evenementsObservable = this.evenementService.getAll();
  }
}
