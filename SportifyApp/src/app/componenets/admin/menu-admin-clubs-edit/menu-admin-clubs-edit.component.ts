import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { debounceTime, map, Observable } from 'rxjs';
import { Club } from 'src/app/model/club';
import { Compte } from 'src/app/model/compte';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { ClubService } from 'src/app/services/club.service';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-menu-admin-clubs-edit',
  templateUrl: './menu-admin-clubs-edit.component.html',
  styleUrls: ['./menu-admin-clubs-edit.component.css'],
})
export class MenuAdminClubsEditComponent implements OnInit {
  form!: FormGroup;
  compte: Compte = new Compte();
  club: Club = new Club();
  constructor(
    private authService: AuthentificationService,
    private router: Router,
    private compteService: CompteService,
    private clubService: ClubService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.clubService.get(params['id']).subscribe((result) => {
          this.club = result;
          this.form = new FormGroup({
            mail: new FormControl(
              this.club.mail,
              [
                Validators.required,
                Validators.maxLength(200),
                // Validators.pattern(
                //   /^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\. [a-zA-Z0-9-]+)*$/
                // ),
              ],
              this.checkMail()
            ),
            numTel: new FormControl(this.club.numTel, [
              Validators.required,
              Validators.maxLength(30),
              Validators.pattern(/^(0|\\+33)[1-9]([-. ]?[0-9]{2}){4}$/),
            ]),
            nomClub: new FormControl(this.club.clubNom, [
              Validators.required,
              Validators.maxLength(30),
            ]),

            numero: new FormControl(this.club.adresse?.numero, [
              Validators.required,
              Validators.maxLength(30),
            ]),
            rue: new FormControl(this.club.adresse?.rue, [
              Validators.required,
              Validators.maxLength(150),
            ]),
            ville: new FormControl(this.club.adresse?.ville, [
              Validators.required,
              Validators.maxLength(100),
            ]),
            codePostal: new FormControl(this.club.adresse?.codePostal, [
              Validators.required,
              Validators.maxLength(30),
            ]),
          });
        });
      }
    });
  }

  checkMail(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.authService.checkMail(control.value).pipe(
        debounceTime(1000),
        map((res: boolean) => {
          return res ? { mailAlreadyUsed: true } : null;
        })
      );
    };
  }

  get errorMail(): string {
    let control = this.form.get('mail');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'mail obligatoire';
      // else if (control!.hasError('pattern')) return 'le mail est incorrecte';
      else if (control!.hasError('maxlength'))
        return 'le mail ne doit pas faire plus de 200 caracteres';
      else if (control!.hasError('mailAlreadyUsed'))
        return ' le mail est d??j?? utilis??';
    }
    return '';
  }

  get errorTel(): string {
    let control = this.form.get('numTel');
    if (control!.invalid) {
      if (control!.hasError('required'))
        return 'num??ro de t??l??phone obligatoire';
      else if (control!.hasError('pattern'))
        return 'le num??ro de t??l??phone est incorrecte';
      else if (control!.hasError('maxlength'))
        return 'le num??ro de t??l??phone ne doit pas faire plus de 30 caracteres';
    }
    return '';
  }

  get errorNumero(): string {
    let control = this.form.get('numero');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'num??ro de voie obligatoire';
      else if (control!.hasError('maxlength'))
        return 'le num??ro de voie ne doit pas faire plus de 30 caracteres';
    }
    return '';
  }

  get errorRue(): string {
    let control = this.form.get('rue');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'rue obligatoire';
      else if (control!.hasError('maxlength'))
        return 'le champ rue ne doit pas faire plus de 150 caracteres';
    }
    return '';
  }

  get errorVille(): string {
    let control = this.form.get('ville');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'ville obligatoire';
      else if (control!.hasError('maxlength'))
        return 'le champ ville ne doit pas faire plus de 100 caracteres';
    }
    return '';
  }

  get errorCp(): string {
    let control = this.form.get('codePostal');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'code postale obligatoire';
      else if (control!.hasError('maxlength'))
        return 'le code postale ne doit pas faire plus de 30 caracteres';
    }
    return '';
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
  save() {
    this.club.clubNom = this.form.controls['nomClub'].value;
    this.club.mail = this.form.controls['mail'].value;
    this.club.numTel = this.form.controls['numTel'].value;
    this.club.adresse!.numero = this.form.controls['numero'].value;
    this.club.adresse!.rue = this.form.controls['rue'].value;
    this.club.adresse!.ville = this.form.controls['ville'].value;
    this.club.adresse!.codePostal = this.form.controls['codePostal'].value;
    console.log(this.club);
    this.clubService.update(this.club).subscribe((ok) => {
      console.log(this.club);
      this.router.navigate(['/menu-admin-clubs']);
    });
  }
}
