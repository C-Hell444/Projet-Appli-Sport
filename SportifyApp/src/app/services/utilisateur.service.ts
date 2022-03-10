import { Sport } from './../model/sport';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilisateur } from '../model/utilisateur';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurService {
  static URL: string = 'http://localhost:8080/sportify-boot/api/utilisateur';
  constructor(private http: HttpClient) {}

  getType(login: string): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(UtilisateurService.URL + '/' + login);
  }

  getAll(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(UtilisateurService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(UtilisateurService.URL + '/' + id);
  }

  get(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(UtilisateurService.URL + '/' + id);
  }

  update(utilisateur: Utilisateur): Observable<Utilisateur> {
    const UtilisateurEnJson = {
      type: 'utilisateur',
      identifiant: utilisateur.identifiant,
      mdp: utilisateur.mdp,
      mail: utilisateur.mail,
      nom: utilisateur.nom,
      prenom: utilisateur.prenom,
      numTel: utilisateur.numTel,
    };
    if (utilisateur.adresse) {
      Object.assign(UtilisateurEnJson, {
        adresse: {
          numero: utilisateur.adresse.numero,
          rue: utilisateur.adresse.rue,
          codePostal: utilisateur.adresse.codePostal,
          ville: utilisateur.adresse.ville,
        },
      });
    }
    if (utilisateur.profilUtilisateur) {
      Object.assign(UtilisateurEnJson, {
        profil: {
          id: utilisateur.profilUtilisateur.id,
        },
      });
    }
    return this.http.put<Utilisateur>(
      UtilisateurService.URL + '/' + utilisateur.id,
      UtilisateurEnJson
    );
  }

  create(utilisateur: Utilisateur): Observable<Utilisateur> {
    const UtilisateurEnJson = {
      type: 'utilisateur',
      identifiant: utilisateur.identifiant,
      mdp: utilisateur.mdp,
      mail: utilisateur.mail,
      nom: utilisateur.nom,
      prenom: utilisateur.prenom,
      numTel: utilisateur.numTel,
    };
    if (utilisateur.adresse) {
      Object.assign(UtilisateurEnJson, {
        adresse: {
          numero: utilisateur.adresse.numero,
          rue: utilisateur.adresse.rue,
          codePostal: utilisateur.adresse.codePostal,
          ville: utilisateur.adresse.ville,
        },
      });
    }
    if (utilisateur.profilUtilisateur) {
      Object.assign(UtilisateurEnJson, {
        profil: {
          id: utilisateur.profilUtilisateur.id,
        },
      });
    }
    return this.http.post<Utilisateur>(
      UtilisateurService.URL,
      UtilisateurEnJson
    );
  }

  //---------------Get All + Tri---------

  getAllOrderById(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(UtilisateurService.URL + '/id');
  }

  getAllOrderByNom(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(UtilisateurService.URL + '/nom');
  }

  getAllOrderByPrenom(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(UtilisateurService.URL + '/prenom');
  }

  getAllOrderByNumTel(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(UtilisateurService.URL + '/numero');
  }

  getAllOrderByVille(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(UtilisateurService.URL + '/ville');
  }

  getAllOrderByCodePostal(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(UtilisateurService.URL + '/cp');
  }

  //---------------Get All By Sport---------

  getAllByIdSport(id: number): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(
      UtilisateurService.URL + '/sport/' + id
    );
  }

  //---------------Get All By ?---------

  getAllByNom(nom: string): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(UtilisateurService.URL + '/nom/' + nom);
  }

  getAllByPrenom(prenom: string): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(
      UtilisateurService.URL + '/prenom/' + prenom
    );
  }

  getAllByNumTel(numero: string): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(
      UtilisateurService.URL + '/numero/' + numero
    );
  }

  getAllByVille(ville: string): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(
      UtilisateurService.URL + '/ville/' + ville
    );
  }

  getAllByCodePostal(cp: string): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(UtilisateurService.URL + '/cp/' + cp);
  }

  //---------------Get By Profil---------

  getByProfilId(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(UtilisateurService.URL + '/profil/' + id);
  }

  //---------------Get By Id---------

  getByIdWithProfil(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/profil'
    );
  }

  getByIdWithInteret(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/interet'
    );
  }

  //---------------Get By Id Avec Club + Tri---------

  getByIdWithClubUtilisateur(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/club'
    );
  }

  getByIdWithClubUtilisateurOrderByDateDebutAsc(
    id: number
  ): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/club/date-debut-asc'
    );
  }

  getByIdWithClubUtilisateurOrderByDateDebutDesc(
    id: number
  ): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/club/date-debut-desc'
    );
  }

  getByIdWithClubUtilisateurOrderByDateFinAsc(
    id: number
  ): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/club/date-fin-asc'
    );
  }

  getByIdWithClubUtilisateurOrderByDateFinDesc(
    id: number
  ): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/club/date-fin-desc'
    );
  }

  //---------------Get By Id Avec Evenement + Tri---------

  getByIdWithEvenementUtilisateur(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/evenement'
    );
  }

  getByIdWithEvenementUtilisateurOrderByDateDebutAsc(
    id: number
  ): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/evenement/date-debut-asc'
    );
  }

  getByIdWithEvenementUtilisateurOrderByDateDebutDesc(
    id: number
  ): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/evenement/date-debut-desc'
    );
  }

  getByIdWithEvenementUtilisateurOrderByDateFinAsc(
    id: number
  ): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/evenement/date-fin-asc'
    );
  }

  getByIdWithEvenementUtilisateurOrderByDateFinDesc(
    id: number
  ): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/evenement/date-fin-desc'
    );
  }

  //---------------Get By Id Avec Equipe + Tri---------

  getByIdWithEquipeUtilisateur(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/equipe'
    );
  }

  getByIdWithEquipeUtilisateurOrderByDateDebutAsc(
    id: number
  ): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/equipe/date-debut-asc'
    );
  }

  getByIdWithEquipeUtilisateurOrderByDateDebutDesc(
    id: number
  ): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/equipe/date-debut-desc'
    );
  }

  getByIdWithEquipeUtilisateurOrderByDateFinAsc(
    id: number
  ): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/equipe/date-fin-asc'
    );
  }

  getByIdWithEquipeUtilisateurOrderByDateFinDesc(
    id: number
  ): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.URL + '/' + id + '/equipe/date-fin-desc'
    );
  }
}
