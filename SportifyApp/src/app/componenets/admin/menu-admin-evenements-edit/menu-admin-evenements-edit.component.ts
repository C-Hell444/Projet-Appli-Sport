import { EvenementService } from './../../../services/evenement.service';
import { Evenement } from './../../../model/evenement';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { ClubService } from 'src/app/services/club.service';
import { EquipeService } from 'src/app/services/equipe.service';
import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-menu-admin-evenements-edit',
  templateUrl: './menu-admin-evenements-edit.component.html',
  styleUrls: ['./menu-admin-evenements-edit.component.css'],
})
export class MenuAdminEvenementsEditComponent implements OnInit {
  evenement: Evenement = new Evenement();
  membres: string[] = [];
  club!: string;
  form!: FormGroup;

  constructor(
    private evenementService: EvenementService,
    private utilisateurService: UtilisateurService,
    private clubService: ClubService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private authService: AuthentificationService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.evenementService
          .getByIdWithUtilisateur(params['id'])
          .subscribe((result) => {
            this.evenement = result;
            console.log(this.evenement);

            for (let e of this.evenement.participants!) {
              //this.club != e.id?.equipe?.club?.clubNom;
              this.membres.push(
                e.id?.utilisateur?.nom! +
                  ' ' +
                  e.id?.utilisateur?.prenom! +
                  ' , '
              );
            }
            this.evenementService
              .getByIdWithClub(this.evenement.id!)
              .subscribe((r) => {
                this.club != r.club?.clubNom;
              });
            this.form = new FormGroup({
              evenement: new FormControl(this.evenement.nom, [
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

  get errorEvenement(): string {
    let control = this.form.get('evenement');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Nom evenement est obligatoire';
      else if (control!.hasError('maxlength'))
        return 'Nom evenement ne doit pas faire plus de 30 caracteres';
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
    this.evenementService.update(this.evenement).subscribe((ok) => {
      console.log(this.evenement);
      this.router.navigate(['/menu-admin-evenements']);
    });
  }
}
