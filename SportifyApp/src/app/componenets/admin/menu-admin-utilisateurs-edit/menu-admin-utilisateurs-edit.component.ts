import { Utilisateur } from './../../../model/utilisateur';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { debounceTime, map, Observable } from 'rxjs';
import { UtilisateurService } from 'src/app/services/utilisateur.service';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { CaracteristiqueService } from 'src/app/services/caracteristique.service';
import { ProfilService } from 'src/app/services/profil.service';
import { CompteService } from 'src/app/services/compte.service';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { Sexe } from 'src/app/model/sexe';
import { Caracteristique } from 'src/app/model/caracteristique';
import { Compte } from 'src/app/model/compte';
import { Interet } from 'src/app/model/interet';
import { Profil } from 'src/app/model/profil';

@Component({
  selector: 'app-menu-admin-utilisateurs-edit',
  templateUrl: './menu-admin-utilisateurs-edit.component.html',
  styleUrls: ['./menu-admin-utilisateurs-edit.component.css'],
})
export class MenuAdminUtilisateursEditComponent implements OnInit {
  utilisateursObservable!: Observable<Utilisateur[]>;
  utilisateur: Utilisateur = new Utilisateur();

  compte: Compte = new Compte();
  utilisateurProfil: Utilisateur = new Utilisateur();
  utilisateurInteret: Utilisateur = new Utilisateur();
  profil: Profil = new Profil();
  carac: Caracteristique = new Caracteristique();
  interets: Interet[] = new Array<Interet>();

  sexes = Sexe;

  form!: FormGroup;
  constructor(
    private utilisateurService: UtilisateurService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private authService: AuthentificationService,
    private profilService: ProfilService,
    private caracteristiqueService: CaracteristiqueService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.utilisateurService.get(params['id']).subscribe((result) => {
          this.utilisateur = result;
          ///////////////
          // this.profilService
          //   .getByIdWithCarac(this.utilisateur.profilUtilisateur?.id!)
          //   .subscribe((resultProfil) => {
          //     this.profil = resultProfil;
          //     this.caracteristiqueService
          //       .get(this.profil.caracteristique?.id!)
          //       .subscribe((resultCarac) => (this.carac = resultCarac));
          //   });
          // this.utilisateurService
          //   .getByIdWithInteret(this.compte.id!)
          //   .subscribe((resultUtilisateurInteret) => {
          //     this.utilisateurInteret = resultUtilisateurInteret;
          //     this.interets = this.utilisateurInteret.interets!;
          //   });
          //////////////
          this.form = new FormGroup({
            mail: new FormControl(
              this.utilisateur.mail,
              [
                Validators.required,
                Validators.maxLength(200),
                // Validators.pattern(
                //   /^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\. [a-zA-Z0-9-]+)*$/
                // ),
              ],
              this.checkMail()
            ),
            numTel: new FormControl(this.utilisateur.numTel, [
              Validators.required,
              Validators.maxLength(30),
              Validators.pattern(/^(0|\\+33)[1-9]([-. ]?[0-9]{2}){4}$/),
            ]),
            nom: new FormControl(this.utilisateur.nom, [
              Validators.required,
              Validators.maxLength(30),
            ]),
            prenom: new FormControl(this.utilisateur.prenom, [
              Validators.required,
              Validators.maxLength(30),
            ]),
            sports: new FormControl(this.interets, [Validators.required]),
            numero: new FormControl(this.utilisateur.adresse?.numero, [
              Validators.required,
              Validators.maxLength(30),
            ]),
            rue: new FormControl(this.utilisateur.adresse?.rue, [
              Validators.required,
              Validators.maxLength(150),
            ]),
            ville: new FormControl(this.utilisateur.adresse?.ville, [
              Validators.required,
              Validators.maxLength(100),
            ]),
            codePostal: new FormControl(this.utilisateur.adresse?.codePostal, [
              Validators.required,
              Validators.maxLength(30),
            ]),

            // poids: new FormControl(
            //   this.utilisateur.profilUtilisateur?.poids,
            //   [Validators.required, Validators.min(20), Validators.max(300)]
            // ),
            // taille: new FormControl(
            //   this.utilisateur.profilUtilisateur?.taille,
            //   [Validators.required, Validators.min(0.5), Validators.max(3)]
            // ),
            // dateNaissance: new FormControl(
            //   this.utilisateur.profilUtilisateur?.dateNaissance,
            //   [Validators.required]
            // ),

            // collectif: new FormControl(this.carac.collectif, [
            //   Validators.required,
            //   Validators.min(0),
            //   Validators.max(10),
            // ]),
            // creativite: new FormControl(this.carac.creativite, [
            //   Validators.required,
            //   Validators.min(0),
            //   Validators.max(10),
            // ]),
            // determination: new FormControl(this.carac.determination, [
            //   Validators.required,
            //   Validators.min(0),
            //   Validators.max(10),
            // ]),
            // patience: new FormControl(this.carac.patience, [
            //   Validators.required,
            //   Validators.min(0),
            //   Validators.max(10),
            // ]),
            // detente: new FormControl(this.carac.detente, [
            //   Validators.required,
            //   Validators.min(0),
            //   Validators.max(10),
            // ]),
            // agilite: new FormControl(this.carac.agilite, [
            //   Validators.required,
            //   Validators.min(0),
            //   Validators.max(10),
            // ]),
            // puissance: new FormControl(this.carac.puissance, [
            //   Validators.required,
            //   Validators.min(0),
            //   Validators.max(10),
            // ]),
            // vitesse: new FormControl(this.carac.vitesse, [
            //   Validators.required,
            //   Validators.min(0),
            //   Validators.max(10),
            // ]),
            // endurance: new FormControl(this.carac.endurance, [
            //   Validators.required,
            //   Validators.min(0),
            //   Validators.max(10),
            // ]),
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
    this.utilisateur.nom = this.form.controls['nom'].value;
    this.utilisateur.prenom = this.form.controls['prenom'].value;
    this.utilisateur.mail = this.form.controls['mail'].value;
    this.utilisateur.numTel = this.form.controls['numTel'].value;
    this.utilisateur.adresse!.numero = this.form.controls['numero'].value;
    this.utilisateur.adresse!.rue = this.form.controls['rue'].value;
    this.utilisateur.adresse!.ville = this.form.controls['ville'].value;
    this.utilisateur.adresse!.codePostal =
      this.form.controls['codePostal'].value;

    console.log(this.utilisateur);
    this.utilisateurService.update(this.utilisateur).subscribe((ok) => {
      this.router.navigate(['/menu-admin-utilisateurs']);
    });
  }
}
