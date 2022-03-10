import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Equipe } from 'src/app/model/equipe';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { ClubService } from 'src/app/services/club.service';
import { EquipeService } from 'src/app/services/equipe.service';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-menu-admin-equipes-edit',
  templateUrl: './menu-admin-equipes-edit.component.html',
  styleUrls: ['./menu-admin-equipes-edit.component.css'],
})
export class MenuAdminEquipesEditComponent implements OnInit {
  equipe: Equipe = new Equipe();
  membres: string[] = [];
  club!: string;
  form!: FormGroup;

  constructor(
    private equipeService: EquipeService,
    private utilisateurService: UtilisateurService,
    private clubService: ClubService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private authService: AuthentificationService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.equipeService
          .getByIdWithUtilisateur(params['id'])
          .subscribe((result) => {
            this.equipe = result;
            console.log(this.equipe);

            for (let e of this.equipe.equipe!) {
              //this.club != e.id?.equipe?.club?.clubNom;
              this.membres.push(
                e.id?.utilisateur?.nom! +
                  ' ' +
                  e.id?.utilisateur?.prenom! +
                  ' , '
              );
            }
            this.equipeService
              .getByIdWithClub(this.equipe.id!)
              .subscribe((r) => {
                this.club != r.club?.clubNom;
              });
            this.form = new FormGroup({
              equipe: new FormControl(this.equipe.nom, [
                Validators.required,
                Validators.maxLength(30),
              ]),
              // nomClub: new FormControl(this.club, [
              //   Validators.required,
              //   Validators.maxLength(30),
              // ]),
              membre: new FormControl(this.membres, [
                Validators.required,
                Validators.maxLength(30),
              ]),
            });
          });
      }
    });
  }

  get errorEquipe(): string {
    let control = this.form.get('equipe');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Nom équipe est obligatoire';
      else if (control!.hasError('maxlength'))
        return 'Nom équipe ne doit pas faire plus de 30 caracteres';
    }
    return '';
  }

  // get errorNomClub(): string {
  //   let control = this.form.get('nomClub');
  //   if (control!.invalid) {
  //     if (control!.hasError('required')) return 'Nom club est obligatoire';
  //     else if (control!.hasError('maxlength'))
  //       return 'Nom club ne doit pas faire plus de 30 caracteres';
  //   }
  //   return '';
  // }

  get errorMembre(): string {
    let control = this.form.get('membre');
    if (control!.invalid) {
      if (control!.hasError('required'))
        return 'Liste des membres est obligatoire';
    }
    return '';
  }

  public save() {
    this.equipeService.update(this.equipe).subscribe((ok) => {
      console.log(this.equipe);
      this.router.navigate(['/menu-admin-equipes']);
    });
  }
}
