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

  getAll(): Observable<Club[]> {
    return this.http.get<Club[]>(ClubService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(ClubService.URL + '/' + id);
  }

  get(id: number): Observable<Club> {
    return this.http.get<Club>(ClubService.URL + '/' + id);
  }

  update(Club: Club): Observable<Club> {
    return this.http.put<Club>(ClubService.URL + '/' + Club.id, Club);
  }

  create(Club: Club): Observable<Club> {
    const ClubEnJson = { identifiant: Club.identifiant };
    return this.http.post<Club>(ClubService.URL, ClubEnJson);
  }
}
