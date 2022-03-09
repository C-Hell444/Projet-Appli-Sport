import { ClubUtilisateur } from './club-utilisateur';
import { Adresse } from './adresse';
import { Compte } from './compte';
import { Sport } from './sport';
import { Equipe } from './equipe';
import { Evenement } from './evenement';

export class Club extends Compte {
  private _adresse: Adresse | undefined;
  private _numTel: string | undefined;
  private _clubNom: string | undefined;
  private _sportClub: Sport | undefined;
  private _sport: number | undefined;
  private _listeMembres: ClubUtilisateur[] | undefined;
  private _equipes: Equipe[] | undefined;
  private _evenements: Evenement[] | undefined;

  constructor(
    adresse?: Adresse,
    numTel?: string,
    clubNom?: string,
    sportClub?: Sport,
    sport?: number,
    listeMembres?: ClubUtilisateur[],
    equipes?: Equipe[],
    evenements?: Evenement[]
  ) {
    super();
    this._adresse = adresse;
    this._numTel = numTel;
    this._clubNom = clubNom;
    this._sportClub = sportClub;
    this._sport = sport;
    this._listeMembres = listeMembres;
    this._equipes = equipes;
    this._evenements = evenements;
  }

  /**
   * Getter adresse
   * @return {Adresse }
   */
  public get adresse(): Adresse | undefined {
    return this._adresse;
  }

  /**
   * Getter numTel
   * @return {string }
   */
  public get numTel(): string | undefined {
    return this._numTel;
  }

  /**
   * Getter clubNom
   * @return {string }
   */
  public get clubNom(): string | undefined {
    return this._clubNom;
  }

  /**
   * Getter sportClub
   * @return {Sport }
   */
  public get sportClub(): Sport | undefined {
    return this._sportClub;
  }

  /**
   * Getter sport
   * @return {number }
   */
  public get sport(): number | undefined {
    return this._sport;
  }

  /**
   * Getter listeMembres
   * @return {ClubUtilisateur[] }
   */
  public get listeMembres(): ClubUtilisateur[] | undefined {
    return this._listeMembres;
  }

  /**
   * Getter equipes
   * @return {Equipe[] }
   */
  public get equipes(): Equipe[] | undefined {
    return this._equipes;
  }

  /**
   * Getter evenements
   * @return {Evenement[] }
   */
  public get evenements(): Evenement[] | undefined {
    return this._evenements;
  }

  /**
   * Setter adresse
   * @param {Adresse } value
   */
  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }

  /**
   * Setter numTel
   * @param {string } value
   */
  public set numTel(value: string | undefined) {
    this._numTel = value;
  }

  /**
   * Setter clubNom
   * @param {string } value
   */
  public set clubNom(value: string | undefined) {
    this._clubNom = value;
  }

  /**
   * Setter sportClub
   * @param {Sport } value
   */
  public set sportClub(value: Sport | undefined) {
    this._sportClub = value;
  }

  /**
   * Setter sport
   * @param {number} value
   */
  public set sport(value: number | undefined) {
    this._sport = value;
  }

  /**
   * Setter listeMembres
   * @param {ClubUtilisateur[] } value
   */
  public set listeMembres(value: ClubUtilisateur[] | undefined) {
    this._listeMembres = value;
  }

  /**
   * Setter equipes
   * @param {Equipe[] } value
   */
  public set equipes(value: Equipe[] | undefined) {
    this._equipes = value;
  }

  /**
   * Setter evenements
   * @param {Evenement[] } value
   */
  public set evenements(value: Evenement[] | undefined) {
    this._evenements = value;
  }
}
