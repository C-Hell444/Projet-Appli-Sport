import { Sport } from './../model/sport';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Club } from '../model/club';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ClubService {
  static URL: string = 'http://localhost:8080/sportify-boot/api/club';
  constructor(private http: HttpClient) {}

  getType(login: string): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/' + login);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(ClubService.URL + '/' + id);
  }

  update(Club: Club): Observable<Club> {
    return this.http.put<Club>(ClubService.URL + '/' + Club.id, Club);
  }

  create(Club: Club): Observable<Club> {
    const ClubEnJson = {
      identifiant: Club.identifiant,
      mdp: Club.mdp,
      mail: Club.mail,
      clubNom: Club.clubNom,
    };

    if (Club.adresse) {
      Object.assign(ClubEnJson, {
        adresse: {
          numero: Club.adresse.numero,
          rue: Club.adresse.rue,
          codePostal: Club.adresse.codePostal,
          ville: Club.adresse.ville,
        },
      });
    }
    if (Club.sportClub) {
      Object.assign(ClubEnJson, { sport: { id: Club.sportClub.id } });
    }

    return this.http.post<Club>(ClubService.URL, ClubEnJson);
  }

  // =================== Get All + tri  ======================== //

  getAll(): Observable<Club[]> {
    return this.http.get<Club[]>(ClubService.URL);
  }
  getAllOrderById(): Observable<Club[]> {
    return this.http.get<Club[]>(ClubService.URL + '/id');
  }
  getAllOrderByNom(): Observable<Club[]> {
    return this.http.get<Club[]>(ClubService.URL + '/nom');
  }
  getAllOrderByTel(): Observable<Club[]> {
    return this.http.get<Club[]>(ClubService.URL + '/numero');
  }
  getAllOrderBySport(): Observable<Club[]> {
    return this.http.get<Club[]>(ClubService.URL + '/sport');
  }
  getAllOrderByVille(): Observable<Club[]> {
    return this.http.get<Club[]>(ClubService.URL + '/ville');
  }
  getAllOrderByCodePostal(): Observable<Club[]> {
    return this.http.get<Club[]>(ClubService.URL + '/cp');
  }

  // =================== Get By Id ======================== //

  get(id: number): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/' + id);
  }

  getByIdWithSport(id: number): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/' + id + '/sport');
  }

  getByIdEquipe(id: number): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/' + id + '/equipe');
  }

  // =================== Get By ? ======================== //

  getByNom(nom: string): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/nom/' + nom);
  }
  getByTel(num: string): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/num/' + num);
  }
  getBySportNom(nom: string): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/sport/nom' + nom);
  }
  // getSport(id: number): Observable<Club> {
  //   return this.http.get<Club>(ClubService.URL + '/sport/' + id);
  // }
  getSportListe(sports: Sport[]): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/sport/liste');
  }
  getByVille(ville: string): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/ville/' + ville);
  }
  getByCodePostal(cp: string): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/cp/' + cp);
  }

  // =================== Get Utilisateurs + tri ======================== //

  getByIdUtilisateur(id: number): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/' + id + '/utilisateur');
  }
  getByIdUtilisateurOrderByDateDebutAsc(id: number): Observable<Club> {
    return this.http.get<Club>(
      ClubService.URL + '/' + id + '/utilisateur/date-debut-asc'
    );
  }
  getByIdUtilisateurOrderByDateDebutDesc(id: number): Observable<Club> {
    return this.http.get<Club>(
      ClubService.URL + '/' + id + '/utilisateur/date-debut-desc'
    );
  }
  getByIdUtilisateurOrderByDateFinAsc(id: number): Observable<Club> {
    return this.http.get<Club>(
      ClubService.URL + '/' + id + '/utilisateur/date-fin-asc'
    );
  }
  getByIdUtilisateurOrderByDateFinDesc(id: number): Observable<Club> {
    return this.http.get<Club>(
      ClubService.URL + '/' + id + '/utilisateur/date-fin-desc'
    );
  }

  // =================== Get Evenements + tri ======================== //

  getByIdEvenement(id: number): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/' + id + '/evenement');
  }

  getByIdEvenementOrderByDateDebutAsc(id: number): Observable<Club> {
    return this.http.get<Club>(
      ClubService.URL + '/' + id + '/evenement/date-debut-asc'
    );
  }
  getByIdEvenementOrderByDateDebutDesc(id: number): Observable<Club> {
    return this.http.get<Club>(
      ClubService.URL + '/' + id + '/evenement/date-debut-desc'
    );
  }
  getByIdEvenementOrderByDateFinAsc(id: number): Observable<Club> {
    return this.http.get<Club>(
      ClubService.URL + '/' + id + '/evenement/date-fin-asc'
    );
  }
  getByIdEvenementOrderByDateFinDesc(id: number): Observable<Club> {
    return this.http.get<Club>(
      ClubService.URL + '/' + id + '/evenement/date-fin-desc'
    );
  }

  getAllByIdSport(id: number): Observable<Club[]> {
    return this.http.get<Club[]>(ClubService.URL + '/sport/' + id);
  }
}
