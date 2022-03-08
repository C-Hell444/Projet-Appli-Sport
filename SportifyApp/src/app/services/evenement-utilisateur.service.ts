import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EvenementUtilisateur } from '../model/evenement-utilisateur';

@Injectable({
  providedIn: 'root',
})
export class EvenementUtilisateurService {
  static URL: string =
    'http://localhost:8080/sportify-boot/api/evenement-utilisateur';
  constructor(private http: HttpClient) {}

  getType(login: string): Observable<EvenementUtilisateur> {
    return this.http.get<EvenementUtilisateur>(
      EvenementUtilisateurService.URL + '/' + login
    );
  }

  getAll(): Observable<EvenementUtilisateur[]> {
    return this.http.get<EvenementUtilisateur[]>(
      EvenementUtilisateurService.URL
    );
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(EvenementUtilisateurService.URL + '/' + id);
  }

  get(id: number): Observable<EvenementUtilisateur> {
    return this.http.get<EvenementUtilisateur>(
      EvenementUtilisateurService.URL + '/' + id
    );
  }

  update(
    EvenementUtilisateur: EvenementUtilisateur
  ): Observable<EvenementUtilisateur> {
    return this.http.put<EvenementUtilisateur>(
      EvenementUtilisateurService.URL + '/' + EvenementUtilisateur.id,
      EvenementUtilisateur
    );
  }

  create(
    EvenementUtilisateur: EvenementUtilisateur
  ): Observable<EvenementUtilisateur> {
    const EvenementUtilisateurEnJson = { identifiant: EvenementUtilisateur.id };
    return this.http.post<EvenementUtilisateur>(
      EvenementUtilisateurService.URL,
      EvenementUtilisateurEnJson
    );
  }
}
