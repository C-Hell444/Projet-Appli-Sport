import { CompteService } from './../../services/compte.service';
import { Compte } from './../../model/compte';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from 'src/app/model/admin';
import { Club } from 'src/app/model/club';
import { Utilisateur } from 'src/app/model/utilisateur';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  form!: FormGroup;
  error = false;
  compte: Compte = new Compte();

  constructor(
    private authService: AuthentificationService,
    private router: Router,
    private compteService: CompteService
  ) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      login: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  save() {
    this.authService
      .authentication(
        this.form.controls['login'].value,
        this.form.controls['password'].value
      )
      .subscribe({
        next: (ok) => {
          this.error = false;
          localStorage.setItem('login', this.form.controls['login'].value);
          localStorage.setItem(
            'token',
            btoa(
              this.form.controls['login'].value +
                ':' +
                this.form.controls['password'].value
            )
          );
          this.compteService
            .getType(this.form.controls['login'].value)
            .subscribe((result) => {
              this.compte = result;
              // if (this.compte.type == 'admin') {
              //   this.router.navigateByUrl('/menu-admin');
              // } else if (this.compte.type == 'utilisateur') {
              //   this.router.navigateByUrl('/menu-utilisateur');
              // } else if (this.compte.type == 'club') {
              //   this.router.navigateByUrl('/menu-club');
              // }
              this.router.navigateByUrl('/accueil');
              localStorage.setItem('type', this.compte.type!);
              localStorage.setItem('id', this.compte.id!.toString());
            });
        },
        error: (error) => {
          this.error = true;
        },
      });
  }
}
