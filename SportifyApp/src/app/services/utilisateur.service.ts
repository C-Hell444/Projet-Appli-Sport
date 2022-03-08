import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilisateur } from '../model/utilisateur';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurService {
  static URL: string = 'http://localhost:8080/sportify-boot/api/utilisateur';
  constructor(private http: HttpClient) {}

  getType(login: string): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(UtilisateurService.URL + '/' + login);
  }

  getAll(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(UtilisateurService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(UtilisateurService.URL + '/' + id);
  }

  get(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(UtilisateurService.URL + '/' + id);
  }

  update(Utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.http.put<Utilisateur>(
      UtilisateurService.URL + '/' + Utilisateur.id,
      Utilisateur
    );
  }

  create(Utilisateur: Utilisateur): Observable<Utilisateur> {
    const UtilisateurEnJson = { identifiant: Utilisateur.identifiant };
    return this.http.post<Utilisateur>(
      UtilisateurService.URL,
      UtilisateurEnJson
    );
  }
}
