import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Evenement } from '../model/evenement';

@Injectable({
  providedIn: 'root',
})
export class EvenementService {
  static URL: string = 'http://localhost:8080/sportify-boot/api/evenement';
  constructor(private http: HttpClient) {}

  delete(id: number): Observable<void> {
    return this.http.delete<void>(EvenementService.URL + '/' + id);
  }

  update(Evenement: Evenement): Observable<Evenement> {
    return this.http.put<Evenement>(
      EvenementService.URL + '/' + Evenement.id,
      Evenement
    );
  }

  create(Evenement: Evenement): Observable<Evenement> {
    const EvenementEnJson = {
      id: Evenement.id,
      nom: Evenement.nom,
      dateDebut: Evenement.dateDebut,
      dateFin: Evenement.dateFin,
    };
    if (Evenement.club) {
      Object.assign(EvenementEnJson, { club: { id: Evenement.club.id } });
    }

    return this.http.post<Evenement>(EvenementService.URL, EvenementEnJson);
  }

  // =================== Get All + tri  ======================== //

  getAll(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL);
  }

  getAllWithClub(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL + '/club');
  }

  getAllOrderById(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL + '/id');
  }
  getAllOrderByNom(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL + '/nom');
  }
  getAllOrderByClub(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL + '/club');
  }
  getAllOrderByDateDebut(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL + '/date-debut');
  }
  getAllOrderByDateFin(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL + '/date-fin');
  }

  // =================== Get By ? ======================== //

  getByNom(nom: string): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL + '/nom/' + nom);
  }
  getByClubNom(nom: string): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(
      EvenementService.URL + '/club/nom/' + nom
    );
  }
  getByClub(id: number): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL + '/club/' + id);
  }

  getByDateFutur(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL + '/date/futur/');
  }
  getByDatePasse(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL + '/date/passe/');
  }

  // =================== Get By Id ======================== //

  get(id: number): Observable<Evenement> {
    return this.http.get<Evenement>(EvenementService.URL + '/' + id);
  }

  getByIdWithClub(id: number): Observable<Evenement> {
    return this.http.get<Evenement>(EvenementService.URL + '/' + id + '/club');
  }

  // =================== Get Utilisateurs + tri ======================== //

  getByIdWithUtilisateur(id: number): Observable<Evenement> {
    return this.http.get<Evenement>(
      EvenementService.URL + '/' + id + '/utilisateur'
    );
  }
  getByIdWithUtilisateurOrderByDateDebutAsc(id: number): Observable<Evenement> {
    return this.http.get<Evenement>(
      EvenementService.URL + '/' + id + '/utilisateur/date-debut-asc'
    );
  }
  getByIdWithUtilisateurOrderByDateDebutDesc(
    id: number
  ): Observable<Evenement> {
    return this.http.get<Evenement>(
      EvenementService.URL + '/' + id + '/utilisateur/date-debut-desc'
    );
  }
  getByIdWithUtilisateurOrderByDateFinAsc(id: number): Observable<Evenement> {
    return this.http.get<Evenement>(
      EvenementService.URL + '/' + id + '/utilisateur/date-fin-asc'
    );
  }
  getByIdWithUtilisateurOrderByDateFinDesc(id: number): Observable<Evenement> {
    return this.http.get<Evenement>(
      EvenementService.URL + '/' + id + '/utilisateur/date-fin-desc'
    );
  }
}
