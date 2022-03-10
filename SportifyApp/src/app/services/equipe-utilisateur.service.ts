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

  create(EquipeUtilisateur: EquipeUtilisateur): Observable<EquipeUtilisateur> {
    const EquipeUtilisateurEnJson = {
      dateDebut: EquipeUtilisateur.dateDebut,
      dateFin: EquipeUtilisateur.dateFin,
    };
    if (EquipeUtilisateur.id) {
      if (EquipeUtilisateur.id.equipe) {
        Object.assign(EquipeUtilisateurEnJson, {
          equipe: { id: EquipeUtilisateur.id.equipe.id },
        });
      }
      if (EquipeUtilisateur.id.utilisateur) {
        Object.assign(EquipeUtilisateurEnJson, {
          utilisateur: { id: EquipeUtilisateur.id.utilisateur.id },
        });
      }
    }
    return this.http.post<EquipeUtilisateur>(
      EquipeUtilisateurService.URL,
      EquipeUtilisateurEnJson
    );
  }
}
