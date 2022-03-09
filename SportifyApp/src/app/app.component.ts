import { AuthentificationService } from './services/authentification.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'SportifyApp';

  constructor(
    private authService: AuthentificationService,
    private router: Router
  ) {
    // localStorage.clear();
  }

  get authenticated() {
    return this.authService.isAuthenticated();
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('/accueil');
  }

  get login() {
    return localStorage.getItem('login');
  }

  get profilConnectedUrl() {
    return '/menu-' + localStorage.getItem('type');
  }
}
