import { Adresse } from './adresse';
import { ClubUtilisateur } from './club-utilisateur';
import { Compte } from './compte';
import { EquipeUtilisateur } from './equipe-utilisateur';
import { EvenementUtilisateur } from './evenement-utilisateur';
import { Interet } from './interet';
import { Profil } from './profil';

export class Utilisateur extends Compte {
  private _adresse: Adresse | undefined;
  private _nom: string | undefined;
  private _prenom: string | undefined;
  private _numTel: string | undefined;
  private _profilUtilisateur: Profil | undefined;
  private _interets: Interet[] | undefined;
  private _equipes: EquipeUtilisateur[] | undefined;
  private _evenements: EvenementUtilisateur[] | undefined;
  private _clubs: ClubUtilisateur[] | undefined;

  constructor(
    adresse?: Adresse,
    nom?: string,
    prenom?: string,
    numTel?: string,
    profilUtilisateur?: Profil,
    interets?: Interet[],
    equipes?: EquipeUtilisateur[],
    evenements?: EvenementUtilisateur[],
    clubs?: ClubUtilisateur[]
  ) {
    super();
    this._adresse = adresse;
    this._nom = nom;
    this._prenom = prenom;
    this._numTel = numTel;
    this._profilUtilisateur = profilUtilisateur;
    this._interets = interets;
    this._equipes = equipes;
    this._evenements = evenements;
    this._clubs = clubs;
  }

  /**
   * Getter adresse
   * @return {Adresse }
   */
  public get adresse(): Adresse | undefined {
    return this._adresse;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter prenom
   * @return {string }
   */
  public get prenom(): string | undefined {
    return this._prenom;
  }

  /**
   * Getter numTel
   * @return {string }
   */
  public get numTel(): string | undefined {
    return this._numTel;
  }

  /**
   * Getter profilUtilisateur
   * @return {Profil }
   */
  public get profilUtilisateur(): Profil | undefined {
    return this._profilUtilisateur;
  }

  /**
   * Getter interets
   * @return {Interet[] }
   */
  public get interets(): Interet[] | undefined {
    return this._interets;
  }

  /**
   * Getter equipes
   * @return {EquipeUtilisateur[] }
   */
  public get equipes(): EquipeUtilisateur[] | undefined {
    return this._equipes;
  }

  /**
   * Getter evenements
   * @return {EvenementUtilisateur[] }
   */
  public get evenements(): EvenementUtilisateur[] | undefined {
    return this._evenements;
  }

  /**
   * Getter clubs
   * @return {ClubUtilisateur[] }
   */
  public get clubs(): ClubUtilisateur[] | undefined {
    return this._clubs;
  }

  /**
   * Setter adresse
   * @param {Adresse } value
   */
  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter prenom
   * @param {string } value
   */
  public set prenom(value: string | undefined) {
    this._prenom = value;
  }

  /**
   * Setter numTel
   * @param {string } value
   */
  public set numTel(value: string | undefined) {
    this._numTel = value;
  }

  /**
   * Setter profilUtilisateur
   * @param {Profil } value
   */
  public set profilUtilisateur(value: Profil | undefined) {
    this._profilUtilisateur = value;
  }

  /**
   * Setter interets
   * @param {Interet[] } value
   */
  public set interets(value: Interet[] | undefined) {
    this._interets = value;
  }

  /**
   * Setter equipes
   * @param {EquipeUtilisateur[] } value
   */
  public set equipes(value: EquipeUtilisateur[] | undefined) {
    this._equipes = value;
  }

  /**
   * Setter evenements
   * @param {EvenementUtilisateur[] } value
   */
  public set evenements(value: EvenementUtilisateur[] | undefined) {
    this._evenements = value;
  }

  /**
   * Setter clubs
   * @param {ClubUtilisateur[] } value
   */
  public set clubs(value: ClubUtilisateur[] | undefined) {
    this._clubs = value;
  }
}
