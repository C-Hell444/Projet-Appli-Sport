import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  form!: FormGroup;
  error = false;

  constructor(
    private authService: AuthentificationService,
    private router: Router
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
          this.router.navigateByUrl('/accueil');
        },
        error: (error) => {
          this.error = true;
        },
      });
  }
}
