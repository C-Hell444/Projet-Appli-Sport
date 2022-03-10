import { ClubUtilisateurKey } from './../model/club-utilisateur-key';
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

  updateByIds(
    idClub: number,
    idUser: number,
    ClubUtilisateur: ClubUtilisateur
  ): Observable<ClubUtilisateur> {
    const ClubUtilisateurEnJson = {
      dateDebut: ClubUtilisateur.dateDebut,
      dateFin: ClubUtilisateur.dateFin,
    };

    Object.assign(ClubUtilisateurEnJson, {
      id: {
        utilisateur: {
          type: 'utilisateur',
          id: idUser,
        },
        club: { type: 'club', id: idClub },
      },
    });

    return this.http.put<ClubUtilisateur>(
      ClubUtilisateurService.URL + '/' + idClub + '/' + idUser,
      ClubUtilisateurEnJson
    );
  }

  update(ClubUtilisateur: ClubUtilisateur): Observable<ClubUtilisateur> {
    return this.http.put<ClubUtilisateur>(
      ClubUtilisateurService.URL,
      ClubUtilisateur
    );
  }

  create(ClubUtilisateur: ClubUtilisateur): Observable<ClubUtilisateur> {
    const ClubUtilisateurEnJson = {
      dateDebut: ClubUtilisateur.dateDebut,
      dateFin: null,
    };
    if (ClubUtilisateur.id) {
      Object.assign(ClubUtilisateurEnJson, {
        id: {
          utilisateur: {
            type: 'utilisateur',
            id: ClubUtilisateur.id.utilisateur!.id,
          },
          club: { type: 'club', id: ClubUtilisateur.id.club!.id },
        },
      });
    }
    return this.http.post<ClubUtilisateur>(
      ClubUtilisateurService.URL,
      ClubUtilisateurEnJson
    );
  }

  private ClubUtilisateurToJson(ClubUtilisateur: ClubUtilisateur) {
    const ClubUtilisateurEnJson = {
      dateDebut: ClubUtilisateur.dateDebut,
      dateFin: ClubUtilisateur.dateFin,
    };
    if (ClubUtilisateur.id) {
      Object.assign(ClubUtilisateurEnJson, {
        id: {
          utilisateur: {
            type: 'utilisateur',
            id: ClubUtilisateur.id.utilisateur!.id,
          },
          club: { type: 'club', id: ClubUtilisateur.id.club!.id },
        },
      });
    }
    return ClubUtilisateurEnJson;
  }
}
