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

  getAll(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(EvenementService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(EvenementService.URL + '/' + id);
  }

  get(id: number): Observable<Evenement> {
    return this.http.get<Evenement>(EvenementService.URL + '/' + id);
  }

  update(Evenement: Evenement): Observable<Evenement> {
    return this.http.put<Evenement>(
      EvenementService.URL + '/' + Evenement.id,
      Evenement
    );
  }

  create(Evenement: Evenement): Observable<Evenement> {
    const EvenementEnJson = { identifiant: Evenement.id };
    return this.http.post<Evenement>(EvenementService.URL, EvenementEnJson);
  }
}
