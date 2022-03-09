import { Club } from 'src/app/model/club';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Equipe } from '../model/equipe';

@Injectable({
  providedIn: 'root',
})
export class EquipeService {
  static URL: string = 'http://localhost:8080/sportify-boot/api/equipe';
  constructor(private http: HttpClient) {}

  delete(id: number): Observable<void> {
    return this.http.delete<void>(EquipeService.URL + '/' + id);
  }

  update(Equipe: Equipe): Observable<Equipe> {
    return this.http.put<Equipe>(EquipeService.URL + '/' + Equipe.id, Equipe);
  }

  create(Equipe: Equipe): Observable<Equipe> {
    const EquipeEnJson = {
      id: Equipe.id,
      nom: Equipe.nom,
    };

    if (Equipe.club) {
      Object.assign(EquipeEnJson, { club: { id: Equipe.club.id } });
    }
    return this.http.post<Equipe>(EquipeService.URL, EquipeEnJson);
  }

  // =================== Get All + tri  ======================== //

  getAll(): Observable<Equipe[]> {
    return this.http.get<Equipe[]>(EquipeService.URL);
  }
  getAllOrderById(): Observable<Equipe[]> {
    return this.http.get<Equipe[]>(EquipeService.URL + '/id');
  }
  getAllOrderByNom(): Observable<Equipe[]> {
    return this.http.get<Equipe[]>(EquipeService.URL + '/nom');
  }
  getAllOrderByClub(): Observable<Equipe[]> {
    return this.http.get<Equipe[]>(EquipeService.URL + '/club');
  }

  // =================== Get By ? ======================== //

  getByNom(nom: string): Observable<Equipe[]> {
    return this.http.get<Equipe[]>(EquipeService.URL + '/nom/' + nom);
  }
  getByClubNom(nom: string): Observable<Equipe[]> {
    return this.http.get<Equipe[]>(EquipeService.URL + '/club/nom/' + nom);
  }
  getByClub(id: number): Observable<Equipe[]> {
    return this.http.get<Equipe[]>(EquipeService.URL + '/club/' + id);
  }

  // =================== Get By Id ======================== //

  get(id: number): Observable<Equipe> {
    return this.http.get<Equipe>(EquipeService.URL + '/' + id);
  }

  // =================== Get Utilisateurs + tri ======================== //

  getByIdWithUtilisateur(id: number): Observable<Equipe> {
    return this.http.get<Equipe>(EquipeService.URL + '/' + id + '/utilisateur');
  }
  getByIdWithUtilisateurOrderByDateDebutAsc(id: number): Observable<Equipe> {
    return this.http.get<Equipe>(
      EquipeService.URL + '/' + id + '/utilisateur/date-debut-asc'
    );
  }
  getByIdWithUtilisateurOrderByDateDebutDesc(id: number): Observable<Equipe> {
    return this.http.get<Equipe>(
      EquipeService.URL + '/' + id + '/utilisateur/date-debut-desc'
    );
  }
  getByIdWithUtilisateurOrderByDateFinAsc(id: number): Observable<Equipe> {
    return this.http.get<Equipe>(
      EquipeService.URL + '/' + id + '/utilisateur/date-fin-asc'
    );
  }
  getByIdWithUtilisateurOrderByDateFinDesc(id: number): Observable<Equipe> {
    return this.http.get<Equipe>(
      EquipeService.URL + '/' + id + '/utilisateur/date-fin-desc'
    );
  }
}
