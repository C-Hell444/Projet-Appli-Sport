import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthentificationService } from './authentification.service';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationGardService implements CanActivate {
  constructor(
    private authService: AuthentificationService,
    private router: Router
  ) {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | boolean
    | UrlTree
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree> {
    if (
      this.authService.isAuthenticated() &&
      state.url.includes('/menu-' + localStorage.getItem('type'))
    ) {
      return true;
    } else {
      this.router.navigateByUrl('/accueil');
      return false;
    }
  }
}
