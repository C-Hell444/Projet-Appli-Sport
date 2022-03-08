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

  getAll(): Observable<Equipe[]> {
    return this.http.get<Equipe[]>(EquipeService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(EquipeService.URL + '/' + id);
  }

  get(id: number): Observable<Equipe> {
    return this.http.get<Equipe>(EquipeService.URL + '/' + id);
  }

  update(Equipe: Equipe): Observable<Equipe> {
    return this.http.put<Equipe>(EquipeService.URL + '/' + Equipe.id, Equipe);
  }

  create(Equipe: Equipe): Observable<Equipe> {
    const EquipeEnJson = { identifiant: Equipe.id };
    return this.http.post<Equipe>(EquipeService.URL, EquipeEnJson);
  }
}
