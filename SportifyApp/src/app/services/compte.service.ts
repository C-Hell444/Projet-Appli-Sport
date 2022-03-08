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
}
