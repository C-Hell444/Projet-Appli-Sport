import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Caracteristique } from '../model/caracteristique';

@Injectable({
  providedIn: 'root',
})
export class CaracteristiqueService {
  static URL: string =
    'http://localhost:8080/sportify-boot/api/caracteristique';
  constructor(private http: HttpClient) {}

  public getAll(): Observable<Caracteristique[]> {
    return this.http.get<Caracteristique[]>(CaracteristiqueService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(CaracteristiqueService.URL + '/' + id);
  }

  public get(id: number): Observable<Caracteristique> {
    return this.http.get<Caracteristique>(
      CaracteristiqueService.URL + '/' + id
    );
  }

  public getProfil(id: number): Observable<Caracteristique> {
    return this.http.get<Caracteristique>(
      CaracteristiqueService.URL + '/' + id + '/profil'
    );
  }

  public update(caracteristique: Caracteristique): Observable<Caracteristique> {
    return this.http.put<Caracteristique>(
      CaracteristiqueService.URL + '/' + caracteristique.id,
      caracteristique
    );
  }

  public create(caracteristique: Caracteristique): Observable<Caracteristique> {
    const caracteristiqueEnJson = {
      id: caracteristique.id,
      collectif: caracteristique.collectif,
      creativite: caracteristique.creativite,
      determination: caracteristique.determination,
      patience: caracteristique.patience,
      detente: caracteristique.detente,
      agilite: caracteristique.agilite,
      puissance: caracteristique.puissance,
      vitesse: caracteristique.vitesse,
      endurance: caracteristique.endurance,
    };
    if (caracteristique.profil) {
      Object.assign(caracteristiqueEnJson, {
        profil: { id: caracteristique.profil.id },
      });
    }

    if (caracteristique.sport) {
      Object.assign(caracteristiqueEnJson, {
        sport: { id: caracteristique.sport.id },
      });
    }
    return this.http.post<Caracteristique>(
      CaracteristiqueService.URL,
      caracteristiqueEnJson
    );
  }
}
