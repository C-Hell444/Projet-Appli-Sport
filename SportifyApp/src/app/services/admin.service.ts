import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../model/admin';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  static URL: string = 'http://localhost:8080/sportify-boot/api/admin';
  constructor(private http: HttpClient) {}

  getType(login: string): Observable<Admin> {
    return this.http.get<Admin>(AdminService.URL + '/' + login);
  }

  getAll(): Observable<Admin[]> {
    return this.http.get<Admin[]>(AdminService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(AdminService.URL + '/' + id);
  }

  get(id: number): Observable<Admin> {
    return this.http.get<Admin>(AdminService.URL + '/' + id);
  }

  update(Admin: Admin): Observable<Admin> {
    return this.http.put<Admin>(AdminService.URL + '/' + Admin.id, Admin);
  }

  create(Admin: Admin): Observable<Admin> {
    const AdminEnJson = {
      type: 'admin',
      identifiant: Admin.identifiant,
      mdp: Admin.mdp,
      mail: Admin.mail,
    };
    return this.http.post<Admin>(AdminService.URL, AdminEnJson);
  }
}
