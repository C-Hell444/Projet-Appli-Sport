import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Profil } from '../model/profil';
import { Sexe } from '../model/sexe';

@Injectable({
  providedIn: 'root',
})
export class ProfilService {
  static URL: string = 'http://localhost:8080/sportify-boot/api/profil';
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
    };
    if (profil.caracteristique) {
      Object.assign(profilEnJson, {
        caracteristique: { id: profil.caracteristique.id },
      });
    }
    if (profil.utilisateur) {
      Object.assign(profilEnJson, {
        caracteristique: { id: profil.utilisateur.id },
      });
    }
    return this.http.post<Profil>(ProfilService.URL, profilEnJson);
  }

  // =================== Get By ? ======================== //

  getByPoids(poids: number): Observable<Profil> {
    return this.http.get<Profil>(ProfilService.URL + '/poids/' + poids);
  }
  getByPoidsGreaterThan(poids: number): Observable<Profil> {
    return this.http.get<Profil>(
      ProfilService.URL + '/poids/' + poids + '/greater'
    );
  }
  getByPoidsLessThan(poids: number): Observable<Profil> {
    return this.http.get<Profil>(
      ProfilService.URL + '/poids/' + poids + '/less'
    );
  }

  getByTaille(taille: number): Observable<Profil> {
    return this.http.get<Profil>(ProfilService.URL + '/taille/' + taille);
  }
  getByTailleGreaterThan(taille: number): Observable<Profil> {
    return this.http.get<Profil>(
      ProfilService.URL + '/taille/' + taille + '/greater'
    );
  }
  getByTailleLessThan(taille: number): Observable<Profil> {
    return this.http.get<Profil>(
      ProfilService.URL + '/taille/' + taille + '/less'
    );
  }

  getBySexe(sexe: Sexe): Observable<Profil> {
    return this.http.get<Profil>(ProfilService.URL + '/sexe/' + sexe);
  }
  getByAgeGreaterThan(age: number): Observable<Profil> {
    return this.http.get<Profil>(
      ProfilService.URL + '/age/' + age + '/greater'
    );
  }
  getByAgeLessThan(age: number): Observable<Profil> {
    return this.http.get<Profil>(ProfilService.URL + '/age/' + age + '/less');
  }
  // =================== Get By Id ======================== //

  getByIdWithCarac(id: number): Observable<Profil> {
    return this.http.get<Profil>(ProfilService.URL + '/' + id + '/carac');
  }
  getByIdWithUtilisateur(id: number): Observable<Profil> {
    return this.http.get<Profil>(ProfilService.URL + '/' + id + '/utilisateur');
  }
}
