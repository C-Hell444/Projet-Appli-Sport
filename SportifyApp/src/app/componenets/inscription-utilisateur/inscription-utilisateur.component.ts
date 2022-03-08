import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { debounceTime, map, Observable } from 'rxjs';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-inscription-utilisateur',
  templateUrl: './inscription-utilisateur.component.html',
  styleUrls: ['./inscription-utilisateur.component.css'],
})
export class InscriptionUtilisateurComponent implements OnInit {
  form!: FormGroup;
  constructor(
    private authService: AuthentificationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      login: new FormControl(
        '',
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(200),
        ],
        this.checkLogin()
      ),
      passwordGrp: new FormGroup(
        {
          password: new FormControl('', [
            Validators.required,
            Validators.pattern(
              /^(?=.*[a-z])(?=.*[A-Z])(?=.*[$@#_-])(?=.*[0-9])([a-zA-Z0-9$@#_-]{4,25})$/
            ),
            Validators.maxLength(200),
          ]),
          confirm: new FormControl(''),
        },
        this.checkNotEquals
      ),
      mail: new FormControl(
        '',
        [
          Validators.required,
          Validators.maxLength(200),
          Validators.pattern(
            /^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\. [a-zA-Z0-9-]+)*$/
          ),
        ],
        this.checkMail()
      ),
      numTel: new FormControl('', [
        Validators.required,
        Validators.maxLength(30),
        Validators.pattern(/^(0|\\+33)[1-9]([-. ]?[0-9]{2}){4}$/),
      ]),
      nom: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(100),
        Validators.pattern(/^[a-zA-Z]((-|')?([a-zA-Z]{1,}))*$/),
      ]),
      prenom: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(100),
        Validators.pattern(/^[a-zA-Z]((-|')?([a-zA-Z]{1,}))*$/),
      ]),
      numero: new FormControl('', [
        Validators.required,
        Validators.maxLength(30),
      ]),
      rue: new FormControl('', [
        Validators.required,
        Validators.maxLength(150),
      ]),
      ville: new FormControl('', [
        Validators.required,
        Validators.maxLength(100),
      ]),
      codePostale: new FormControl('', [
        Validators.required,
        Validators.maxLength(30),
      ]),
    });
  }

  clickClub() {
    this.router.navigate(['/inscription-club']);
  }

  checkNotEquals(group: AbstractControl): ValidationErrors | null {
    let formGroup = group as FormGroup;
    if (formGroup.controls['password'].errors) {
      return null;
    }
    return formGroup.controls['password'].value ==
      formGroup.controls['confirm'].value
      ? null
      : { checkNotEquals: true };
  }

  checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.authService.checkUsername(control.value).pipe(
        debounceTime(1000),
        map((res: boolean) => {
          return res ? { loginAlreadyUsed: true } : null;
        })
      );
    };
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

  get errorPassword(): string {
    let control = this.form.get('passwordGrp')?.get('password');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'mot de passe obligatoire';
      else if (control!.hasError('minlength'))
        return 'le mot de passe doit faire 4 caracteres minimum';
      else if (control!.hasError('maxlength'))
        return 'le mot de passe ne doit pas faire plus de 25 caracteres';
      else if (control!.hasError('pattern'))
        return ' le mot de passe doit contenir 1 minuscule, 1 majuscule, 1 chiffre et un caractere #@$_-';
    }
    return '';
  }

  get errorLogin(): string {
    let control = this.form.get('login');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'login obligatoire';
      else if (control!.hasError('minlength'))
        return 'le login doit faire 3 caracteres minimum';
      else if (control!.hasError('maxlength'))
        return 'le login ne doit pas faire plus de 200 caracteres';
      else if (control!.hasError('loginAlreadyUsed'))
        return ' le login est déjà utilisé';
    }
    return '';
  }

  get errorMail(): string {
    let control = this.form.get('mail');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'mail obligatoire';
      else if (control!.hasError('pattern')) return 'le mail est incorrecte';
      else if (control!.hasError('maxlength'))
        return 'le mail ne doit pas faire plus de 200 caracteres';
      else if (control!.hasError('mailAlreadyUsed'))
        return ' le mail est déjà utilisé';
    }
    return '';
  }

  get errorTel(): string {
    let control = this.form.get('numTel');
    if (control!.invalid) {
      if (control!.hasError('required'))
        return 'numéro de téléphone obligatoire';
      else if (control!.hasError('pattern'))
        return 'le numéro de téléphone est incorrecte';
      else if (control!.hasError('maxlength'))
        return 'le numéro de téléphone ne doit pas faire plus de 30 caracteres';
    }
    return '';
  }

  get errorNumero(): string {
    let control = this.form.get('numero');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'numéro de voie obligatoire';
      else if (control!.hasError('maxlength'))
        return 'le numéro de voie ne doit pas faire plus de 30 caracteres';
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
    let control = this.form.get('codePostale');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'code postale obligatoire';
      else if (control!.hasError('maxlength'))
        return 'le code postale ne doit pas faire plus de 30 caracteres';
    }
    return '';
  }

  get errorNom(): string {
    let control = this.form.get('nom');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Nom obligatoire';
      else if (control!.hasError('minlength'))
        return 'le nom doit faire 2 caracteres minimum';
      else if (control!.hasError('maxlength'))
        return 'le nom ne doit pas faire plus de 100 caracteres';
      else if (control!.hasError('pattern')) return ' le nom est incorrecte';
    }
    return '';
  }

  get errorPrenom(): string {
    let control = this.form.get('prenom');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Prenom obligatoire';
      else if (control!.hasError('minlength'))
        return 'le prenom doit faire 2 caracteres minimum';
      else if (control!.hasError('maxlength'))
        return 'le prenom ne doit pas faire plus de 100 caracteres';
      else if (control!.hasError('pattern')) return ' le prenom est incorrecte';
    }
    return '';
  }

  save() {
    let user = {
      identifiant: this.form.get('login')?.value,
      mdp: this.form.get('passwordGrp')?.get('password')?.value,
      type: 'utilisateur',
      mail: this.form.get('mail')?.value,
      numTel: this.form.get('numTel')?.value,
      nom: this.form.get('nom')?.value,
      prenom: this.form.get('prenom')?.value,
      adresse: {
        numero: this.form.get('numero')?.value,
        rue: this.form.get('rue')?.value,
        ville: this.form.get('ville')?.value,
        codePostal: this.form.get('codePostale')?.value,
      },
    };

    //console.log(user);
    this.authService.inscriptionUtilisateur(user).subscribe((ok) => {
      this.router.navigateByUrl('/menu-utilisateur');
    });
  }
}
