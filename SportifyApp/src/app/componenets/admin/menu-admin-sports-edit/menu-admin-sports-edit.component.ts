import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Club } from 'src/app/model/club';
import { Sport } from 'src/app/model/sport';
import { SportService } from 'src/app/services/sport.service';

@Component({
  selector: 'app-menu-admin-sports-edit',
  templateUrl: './menu-admin-sports-edit.component.html',
  styleUrls: ['./menu-admin-sports-edit.component.css'],
})
export class MenuAdminSportsEditComponent implements OnInit {
  sport: Sport = new Sport();
  form!: FormGroup;
  clubs: Club[] = [];
  sports: Sport[] = [];
  sports2: Sport[] = [];
  nomsClub: String[] = [];
  constructor(
    private activatedRoute: ActivatedRoute,
    private sportService: SportService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      console.log(params['id']);

      if (params['id']) {
        this.sportService.getByIdWithClub(params['id']).subscribe((result) => {
          this.sport = result;
          for (let c of this.sport.clubs!) {
            this.nomsClub.push(c.clubNom!);
          }
          this.form = new FormGroup({
            sport: new FormControl(this.sport.nom, [
              Validators.required,
              Validators.maxLength(30),
            ]),
          });
        });
      }
    });
  }

  getAll() {
    this.sportService.getAll().subscribe((ok) => {
      this.sports = ok;
      for (let s of this.sports) {
        this.sportService.getByIdWithClub(s.id!).subscribe((res) => {
          this.sports2.push(res);
        });
      }
    });
  }
  get errorNomClub(): string {
    let control = this.form.get('nomClub');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Nom de club obligatoire';
      else if (control!.hasError('maxlength'))
        return 'le nom de club ne doit pas faire plus de 30 caracteres';
    }
    return '';
  }
  get errorSport(): string {
    let control = this.form.get('sport');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Nom de club obligatoire';
      else if (control!.hasError('maxlength'))
        return 'le nom de club ne doit pas faire plus de 30 caracteres';
    }
    return '';
  }
  save() {
    this.sport.nom = this.form.controls['sport'].value;
    this.sportService.update(this.sport).subscribe((ok) => {
      console.log(this.sport);
      this.router.navigate(['/menu-admin-sports']);
    });
  }
}
