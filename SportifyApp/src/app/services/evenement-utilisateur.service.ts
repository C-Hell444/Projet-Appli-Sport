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

  updateByIds(
    idEvenement: number,
    idUser: number,
    EvenementUtilisateur: EvenementUtilisateur
  ): Observable<EvenementUtilisateur> {
    const EvenementUtilisateurEnJson = {
      dateDebut: EvenementUtilisateur.dateDebut,
      dateFin: EvenementUtilisateur.dateFin,
    };

    Object.assign(EvenementUtilisateurEnJson, {
      id: {
        utilisateur: {
          type: 'utilisateur',
          id: idUser,
        },
        equipe: { id: idEvenement },
      },
    });
    return this.http.put<EvenementUtilisateur>(
      EvenementUtilisateurService.URL + '/' + idEvenement + '/' + idUser,
      EvenementUtilisateurEnJson
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
    const EvenementUtilisateurEnJson = {
      dateDebut: EvenementUtilisateur.dateDebut,
      dateFin: EvenementUtilisateur.dateFin,
    };
    if (EvenementUtilisateur.id) {
      if (EvenementUtilisateur.id.evenement) {
        Object.assign(EvenementUtilisateurEnJson, {
          Evenement: { id: EvenementUtilisateur.id.evenement.id },
        });
      }
      if (EvenementUtilisateur.id.utilisateur) {
        Object.assign(EvenementUtilisateurEnJson, {
          utilisateur: { id: EvenementUtilisateur.id.utilisateur.id },
        });
      }
    }
    return this.http.post<EvenementUtilisateur>(
      EvenementUtilisateurService.URL,
      EvenementUtilisateurEnJson
    );
  }
}
