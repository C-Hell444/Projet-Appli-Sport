import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EquipeUtilisateur } from '../model/equipe-utilisateur';

@Injectable({
  providedIn: 'root',
})
export class EquipeUtilisateurService {
  static URL: string =
    'http://localhost:8080/sportify-boot/api/equipe-utilisateur';
  constructor(private http: HttpClient) {}

  getAll(): Observable<EquipeUtilisateur[]> {
    return this.http.get<EquipeUtilisateur[]>(EquipeUtilisateurService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(EquipeUtilisateurService.URL + '/' + id);
  }

  get(id: number): Observable<EquipeUtilisateur> {
    return this.http.get<EquipeUtilisateur>(
      EquipeUtilisateurService.URL + '/' + id
    );
  }

  getByEquipeId(id: number): Observable<EquipeUtilisateur> {
    return this.http.get<EquipeUtilisateur>(
      EquipeUtilisateurService.URL + '/' + id + '/equipe'
    );
  }

  update(EquipeUtilisateur: EquipeUtilisateur): Observable<EquipeUtilisateur> {
    return this.http.put<EquipeUtilisateur>(
      EquipeUtilisateurService.URL + '/' + EquipeUtilisateur.id,
      EquipeUtilisateur
    );
  }

  create(equipeUtilisateur: EquipeUtilisateur): Observable<EquipeUtilisateur> {
    const equipeUtilisateurEnJson = {
      dateDebut: equipeUtilisateur.dateDebut,
      dateFin: null,
    };
    if (equipeUtilisateur.id) {
      Object.assign(equipeUtilisateurEnJson, {
        id: {
          equipe: {
            id: equipeUtilisateur.id!.equipe!.id,
          },
          utilisateur: {
            type: 'utilisateur',
            id: equipeUtilisateur.id!.utilisateur!.id,
          },
        },
      });
    }
    return this.http.post<EquipeUtilisateur>(
      EquipeUtilisateurService.URL,
      equipeUtilisateurEnJson
    );
  }
}
