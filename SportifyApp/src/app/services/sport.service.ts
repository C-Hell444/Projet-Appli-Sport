import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Sport } from '../model/sport';

@Injectable({
  providedIn: 'root',
})
export class SportService {
  static URL: string = 'http://localhost:8080/sportify-boot/api/sport';
  constructor(private http: HttpClient) {}

  public getAll(): Observable<Sport[]> {
    return this.http.get<Sport[]>(SportService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(SportService.URL + '/' + id);
  }

  public get(id: number): Observable<Sport> {
    return this.http.get<Sport>(`${SportService.URL}/${id}`);
  }

  public update(sport: Sport): Observable<Sport> {
    return this.http.put<Sport>(SportService.URL + '/' + sport.id, sport);
  }

  public create(sport: Sport): Observable<Sport> {
    const sportEnJson = {
      nom: sport.nom,
    };
    if (sport.caracteristique) {
      Object.assign(sportEnJson, {
        caracteristique: {
          id: sport.caracteristique.id,
        },
      });
    }
    return this.http.post<Sport>(SportService.URL, sportEnJson);
  }

  public getByIdWithClub(id: number): Observable<Sport> {
    return this.http.get<Sport>(SportService.URL + '/' + id + '/club');
  }

  public getByIdWithInteret(id: number): Observable<Sport> {
    return this.http.get<Sport>(SportService.URL + '/' + id + '/interet');
  }

  public getAllByCaracteristique(
    collectif: number,
    creativite: number,
    determination: number,
    patience: number,
    detente: number,
    agilite: number,
    puissance: number,
    vitesse: number,
    endurance: number
  ): Observable<Sport[]> {
    return this.http.get<Sport[]>(
      SportService.URL +
        '/caracteristique/' +
        collectif +
        '/' +
        creativite +
        '/' +
        determination +
        '/' +
        patience +
        '/' +
        detente +
        '/' +
        agilite +
        '/' +
        puissance +
        '/' +
        vitesse +
        '/' +
        endurance
    );
  }
}
