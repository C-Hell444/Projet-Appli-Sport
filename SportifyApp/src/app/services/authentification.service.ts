import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationService {
  constructor(private http: HttpClient) {}

  public authentication(identifiant: string, mdp: string): Observable<void> {
    let headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(identifiant + ':' + mdp),
    });
    return this.http.get<void>('http://localhost:8080/sportify-boot/api/auth', {
      headers: headers,
    });
  }

  public isAuthenticated(): string | null {
    return localStorage.getItem('token');
  }
  /////////////////////////////////////////////////////////////////////////////////////////////////
  public inscriptionUtilisateur(user: any): Observable<any> {
    return this.http.post(
      'http://localhost:8080/sportify-boot/api/auth/inscription/utilisateur',
      user
    );
  }

  public inscriptionClub(user: any): Observable<any> {
    return this.http.post(
      'http://localhost:8080/sportify-boot/api/auth/inscription/club',
      user
    );
  }

  public checkUsername(username: string): Observable<boolean> {
    return this.http.get<boolean>(
      'http://localhost:8080/sportify-boot/api/auth/search/' + username
    );
  }

  public checkMail(mail: string): Observable<boolean> {
    return this.http.get<boolean>(
      'http://localhost:8080/sportify-boot/api/auth/search/' + mail
    );
  }
  /////////////////////////////////////////////////////////////////////////////////////////////////
}
