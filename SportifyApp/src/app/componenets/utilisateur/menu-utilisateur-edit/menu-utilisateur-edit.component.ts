import {
  FormGroup,
  FormControl,
  Validators,
  AsyncValidatorFn,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Sexe } from './../../../model/sexe';
import { CaracteristiqueService } from './../../../services/caracteristique.service';
import { ProfilService } from './../../../services/profil.service';
import { UtilisateurService } from './../../../services/utilisateur.service';
import { CompteService } from './../../../services/compte.service';
import { Interet } from './../../../model/interet';
import { Caracteristique } from './../../../model/caracteristique';
import { Profil } from './../../../model/profil';
import { Utilisateur } from './../../../model/utilisateur';
import { Compte } from './../../../model/compte';
import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { debounceTime, map, Observable } from 'rxjs';

@Component({
  selector: 'app-menu-utilisateur-edit',
  templateUrl: './menu-utilisateur-edit.component.html',
  styleUrls: ['./menu-utilisateur-edit.component.css'],
})
export class MenuUtilisateurEditComponent implements OnInit {
  compte: Compte = new Compte();
  utilisateurProfil: Utilisateur = new Utilisateur();
  utilisateurInteret: Utilisateur = new Utilisateur();
  profil: Profil = new Profil();
  carac: Caracteristique = new Caracteristique();
  interets: Interet[] = new Array<Interet>();
  utilisateur: Utilisateur = new Utilisateur();

  sexes = Sexe;

  form!: FormGroup;

  constructor(
    private authService: AuthentificationService,
    private compteService: CompteService,
    private utilisateurService: UtilisateurService,
    private profilService: ProfilService,
    private caracteristiqueService: CaracteristiqueService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.compteService
      .getType(localStorage.getItem('login')!)
      .subscribe((resultCompte) => {
        this.compte = resultCompte;
        this.utilisateurService.get(this.compte.id!).subscribe((user) => {
          this.utilisateur = user;
        });
        this.utilisateurService
          .getByIdWithProfil(this.compte.id!)
          .subscribe((userProfil) => {
            this.utilisateurProfil = userProfil;
            this.profilService
              .getByIdWithCarac(this.utilisateurProfil.profilUtilisateur?.id!)
              .subscribe((resultProfil) => {
                this.profil = resultProfil;
                this.caracteristiqueService
                  .get(this.profil.caracteristique?.id!)
                  .subscribe((resultCarac) => (this.carac = resultCarac));
              });
            this.utilisateurService
              .getByIdWithInteret(this.compte.id!)
              .subscribe((resultUtilisateurInteret) => {
                this.utilisateurInteret = resultUtilisateurInteret;
                this.interets = this.utilisateurInteret.interets!;
              });
          });
      });

    this.form = new FormGroup({
      mail: new FormControl(
        '',
        [
          Validators.required,
          Validators.maxLength(200),
          // Validators.pattern(
          //   /^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\. [a-zA-Z0-9-]+)*$/
          // ),
        ],
        this.checkMail()
      ),
      numTel: new FormControl('', [
        Validators.required,
        Validators.maxLength(30),
        Validators.pattern(/^(0|\\+33)[1-9]([-. ]?[0-9]{2}){4}$/),
      ]),
      nom: new FormControl('', [Validators.required, Validators.maxLength(30)]),
      prenom: new FormControl('', [
        Validators.required,
        Validators.maxLength(30),
      ]),
      sports: new FormControl('', [Validators.required]),
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
      poids: new FormControl('', [
        Validators.required,
        Validators.min(20),
        Validators.max(300),
      ]),
      taille: new FormControl('', [
        Validators.required,
        Validators.min(0.5),
        Validators.max(3),
      ]),
      dateNaissance: new FormControl('', [Validators.required]),
      collectif: new FormControl('', [
        Validators.required,
        Validators.min(0),
        Validators.max(10),
      ]),
      creativite: new FormControl('', [
        Validators.required,
        Validators.min(0),
        Validators.max(10),
      ]),
      determination: new FormControl('', [
        Validators.required,
        Validators.min(0),
        Validators.max(10),
      ]),
      patience: new FormControl('', [
        Validators.required,
        Validators.min(0),
        Validators.max(10),
      ]),
      detente: new FormControl('', [
        Validators.required,
        Validators.min(0),
        Validators.max(10),
      ]),
      agilite: new FormControl('', [
        Validators.required,
        Validators.min(0),
        Validators.max(10),
      ]),
      puissance: new FormControl('', [
        Validators.required,
        Validators.min(0),
        Validators.max(10),
      ]),
      vitesse: new FormControl('', [
        Validators.required,
        Validators.min(0),
        Validators.max(10),
      ]),
      endurance: new FormControl('', [
        Validators.required,
        Validators.min(0),
        Validators.max(10),
      ]),
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
      if (control!.hasError('required')) return 'Nom est obligatoire';
      else if (control!.hasError('maxlength'))
        return 'le nom ne doit pas faire plus de 30 caracteres';
    }
    return '';
  }

  get errorPrenom(): string {
    let control = this.form.get('prenom');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Nom est obligatoire';
      else if (control!.hasError('maxlength'))
        return 'le prenom ne doit pas faire plus de 30 caracteres';
    }
    return '';
  }

  get errorPoids(): string {
    let control = this.form.get('poids');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Prenom est obligatoire';
      else if (control!.hasError('max')) return 'le poids max est de 300 kg';
      else if (control!.hasError('min')) return 'le poids min est de 20 kg';
    }
    return '';
  }

  get errorTaille(): string {
    let control = this.form.get('taille');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Prenom est obligatoire';
      else if (control!.hasError('max')) return 'la taille max est de 3 m';
      else if (control!.hasError('min')) return 'la taille min est de 0.5 m';
    }
    return '';
  }

  get errorDateNaissance(): string {
    let control = this.form.get('dateNaissance');
    if (control!.invalid) {
      if (control!.hasError('required'))
        return 'La date de naissance est obligatoire';
    }
    return '';
  }

  get errorCollectif(): string {
    let control = this.form.get('collectif');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Cette valeur est obligatoire';
      else if (control!.hasError('max')) return 'la valeur max est 10';
      else if (control!.hasError('min')) return 'la valeur min est 0';
    }
    return '';
  }

  get errorCreativite(): string {
    let control = this.form.get('creativite');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Cette valeur est obligatoire';
      else if (control!.hasError('max')) return 'la valeur max est 10';
      else if (control!.hasError('min')) return 'la valeur min est 0';
    }
    return '';
  }

  get errorDetermination(): string {
    let control = this.form.get('determination');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Cette valeur est obligatoire';
      else if (control!.hasError('max')) return 'la valeur max est 10';
      else if (control!.hasError('min')) return 'la valeur min est 0';
    }
    return '';
  }

  get errorPatience(): string {
    let control = this.form.get('patience');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Cette valeur est obligatoire';
      else if (control!.hasError('max')) return 'la valeur max est 10';
      else if (control!.hasError('min')) return 'la valeur min est 0';
    }
    return '';
  }

  get errorDetente(): string {
    let control = this.form.get('detente');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Cette valeur est obligatoire';
      else if (control!.hasError('max')) return 'la valeur max est 10';
      else if (control!.hasError('min')) return 'la valeur min est 0';
    }
    return '';
  }

  get errorAgilite(): string {
    let control = this.form.get('agilite');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Cette valeur est obligatoire';
      else if (control!.hasError('max')) return 'la valeur max est 10';
      else if (control!.hasError('min')) return 'la valeur min est 0';
    }
    return '';
  }

  get errorPuissance(): string {
    let control = this.form.get('puissance');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Cette valeur est obligatoire';
      else if (control!.hasError('max')) return 'la valeur max est 10';
      else if (control!.hasError('min')) return 'la valeur min est 0';
    }
    return '';
  }

  get errorVitesse(): string {
    let control = this.form.get('vitesse');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Cette valeur est obligatoire';
      else if (control!.hasError('max')) return 'la valeur max est 10';
      else if (control!.hasError('min')) return 'la valeur min est 0';
    }
    return '';
  }

  get errorEndurance(): string {
    let control = this.form.get('endurance');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Cette valeur est obligatoire';
      else if (control!.hasError('max')) return 'la valeur max est 10';
      else if (control!.hasError('min')) return 'la valeur min est 0';
    }
    return '';
  }

  get errorSport(): string {
    let control = this.form.get('sports');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'Cette valeur est obligatoire';
    }
    return '';
  }

  public save() {
    this.utilisateurService.update(this.utilisateur).subscribe((ok) => {
      console.log(this.utilisateur);
      this.router.navigate(['/menu-utilisateur']);
    });
  }
}
