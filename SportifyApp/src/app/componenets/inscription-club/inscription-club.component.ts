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
  selector: 'app-inscription-club',
  templateUrl: './inscription-club.component.html',
  styleUrls: ['./inscription-club.component.css'],
})
export class InscriptionClubComponent implements OnInit {
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
      mail: new FormControl('', [
        Validators.required,
        Validators.maxLength(200),
        Validators.pattern(
          /^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\. [a-zA-Z0-9-]+)*$/
        ),
      ]),
      numTel: new FormControl('', [
        Validators.required,
        Validators.maxLength(30),
        Validators.pattern(/^(0|\\+33)[1-9]([-. ]?[0-9]{2}){4}$/),
      ]),
      nomClub: new FormControl('', [
        Validators.required,
        Validators.maxLength(30),
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

  clickUser() {
    this.router.navigate(['/inscription-utilisateur']);
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

  save() {
    let user = {
      username: this.form.get('login')?.value,
      password: this.form.get('passwordGrp')?.get('password')?.value,
    };
    console.log(user);
    this.authService.inscriptionClub(user).subscribe((ok) => {
      this.router.navigateByUrl('/acceuil');
    });
  }
}
