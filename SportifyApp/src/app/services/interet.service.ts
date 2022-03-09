import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Interet } from '../model/interet';

@Injectable({
  providedIn: 'root',
})
export class InteretService {
  static URL: string = 'http://localhost:8080/boot/api/interet';
  constructor(private http: HttpClient) {}

  public getAll(): Observable<Interet[]> {
    return this.http.get<Interet[]>(InteretService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(InteretService.URL + '/' + id);
  }

  public get(id: number): Observable<Interet> {
    return this.http.get<Interet>(InteretService.URL + '/' + id);
  }

  public update(interet: Interet): Observable<Interet> {
    return this.http.put<Interet>(
      InteretService.URL + '/' + interet.id,
      interet
    );
  }

  public create(interet: Interet): Observable<Interet> {
    const interetEnJson = {
      id: interet.id,
    };

    if (interet.sport) {
      Object.assign(interetEnJson, { sport: { id: interet.sport.id } });
    }
    if (interet.utilisateur) {
      Object.assign(interetEnJson, { sport: { id: interet.utilisateur.id } });
    }
    return this.http.post<Interet>(InteretService.URL, interetEnJson);
  }
}
