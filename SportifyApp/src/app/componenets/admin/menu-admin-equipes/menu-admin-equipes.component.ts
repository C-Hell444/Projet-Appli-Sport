import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Equipe } from 'src/app/model/equipe';
import { EquipeService } from 'src/app/services/equipe.service';

@Component({
  selector: 'app-menu-admin-equipes',
  templateUrl: './menu-admin-equipes.component.html',
  styleUrls: ['./menu-admin-equipes.component.css'],
})
export class MenuAdminEquipesComponent implements OnInit {
  equipesObservable!: Observable<Equipe[]>;
  constructor(private equipeService: EquipeService) {}

  ngOnInit(): void {
    this.equipesObservable = this.equipeService.getAll();
  }
}
