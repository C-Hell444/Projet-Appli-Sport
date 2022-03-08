import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Profil } from '../model/profil';

@Injectable({
  providedIn: 'root',
})
export class ProfilService {
  static URL: string = 'http://localhost:8080/boot/api/profil';
  constructor(private http: HttpClient) {}

  public getAll(): Observable<Profil[]> {
    return this.http.get<Profil[]>(ProfilService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(ProfilService.URL + '/' + id);
  }

  public get(id: number): Observable<Profil> {
    return this.http.get<Profil>(ProfilService.URL + '/' + id);
  }

  public update(profil: Profil): Observable<Profil> {
    return this.http.put<Profil>(ProfilService.URL + '/' + profil.id, profil);
  }

  public create(profil: Profil): Observable<Profil> {
    const profilEnJson = {
      id: profil.id,
      poids: profil.poids,
      taille: profil.taille,
      dateNaissance: profil.dateNaissance,
      sexe: profil.sexe,
      caracteristique: profil.caracteristique,
      utilisateur: profil.utilisateur,
    };
    return this.http.post<Profil>(ProfilService.URL, profilEnJson);
  }
}
