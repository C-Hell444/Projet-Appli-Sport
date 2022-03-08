import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClubUtilisateur } from '../model/club-utilisateur';

@Injectable({
  providedIn: 'root',
})
export class ClubUtilisateurService {
  static URL: string =
    'http://localhost:8080/sportify-boot/api/club-utilisateur';
  constructor(private http: HttpClient) {}

  getAll(): Observable<ClubUtilisateur[]> {
    return this.http.get<ClubUtilisateur[]>(ClubUtilisateurService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(ClubUtilisateurService.URL + '/' + id);
  }

  get(id: number): Observable<ClubUtilisateur> {
    return this.http.get<ClubUtilisateur>(
      ClubUtilisateurService.URL + '/' + id
    );
  }

  update(ClubUtilisateur: ClubUtilisateur): Observable<ClubUtilisateur> {
    return this.http.put<ClubUtilisateur>(
      ClubUtilisateurService.URL + '/' + ClubUtilisateur.id,
      ClubUtilisateur
    );
  }

  create(ClubUtilisateur: ClubUtilisateur): Observable<ClubUtilisateur> {
    const ClubUtilisateurEnJson = { identifiant: ClubUtilisateur.id };
    return this.http.post<ClubUtilisateur>(
      ClubUtilisateurService.URL,
      ClubUtilisateurEnJson
    );
  }
}
