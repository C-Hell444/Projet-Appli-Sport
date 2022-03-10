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
  equipes: Equipe[] = [];
  equipes2: Equipe[] = [];
  equipes3: Equipe[] = [];
  constructor(private equipeService: EquipeService) {}

  ngOnInit(): void {
    this.equipeService.getAll().subscribe((ok) => {
      this.equipes = ok;
      for (let e1 of this.equipes) {
        this.equipeService.getByIdWithClub(e1.id!).subscribe((r1) => {
          this.equipes2.push(r1);
        });

        this.equipeService.getByIdWithUtilisateur(e1.id!).subscribe((r2) => {
          console.log(r2);
          this.equipes3.push(r2);
        });
      }
      // for (let e2 of this.equipes) {
      //   this.equipeService.getByIdWithUtilisateur(e2.id!).subscribe((r2) => {
      //     console.log(r2);
      //     this.equipes3.push(r2);
      //   });
      // }
    });
  }
}
