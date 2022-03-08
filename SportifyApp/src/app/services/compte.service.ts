import { Compte } from './../model/compte';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  static URL: string = 'http://localhost:8080/sportify-boot/api/compte';
  constructor(private http: HttpClient) {}

  getType(login: string): Observable<Compte> {
    return this.http.get<Compte>(CompteService.URL + '/' + login);
  }

  getAll(): Observable<Compte[]> {
    return this.http.get<Compte[]>(CompteService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(CompteService.URL + '/' + id);
  }

  get(id: number): Observable<Compte> {
    return this.http.get<Compte>(CompteService.URL + '/' + id);
  }

  update(Compte: Compte): Observable<Compte> {
    return this.http.put<Compte>(CompteService.URL + '/' + Compte.id, Compte);
  }

  create(Compte: Compte): Observable<Compte> {
    const CompteEnJson = { identifiant: Compte.identifiant };
    return this.http.post<Compte>(CompteService.URL, CompteEnJson);
  }
}
