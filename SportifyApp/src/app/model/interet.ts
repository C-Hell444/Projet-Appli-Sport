import { Sport } from './sport';
import { Utilisateur } from './utilisateur';

export class Interet {
  private _id: number | undefined;
  private _utilisateur: Utilisateur | undefined;
  private _sport: Sport | undefined;

  constructor(id?: number, utilisateur?: Utilisateur, sport?: Sport) {
    this._id = id;
    this._utilisateur = utilisateur;
    this._sport = sport;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter utilisateur
   * @return {Utilisateur }
   */
  public get utilisateur(): Utilisateur | undefined {
    return this._utilisateur;
  }

  /**
   * Getter sport
   * @return {Sport }
   */
  public get sport(): Sport | undefined {
    return this._sport;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter utilisateur
   * @param {Utilisateur } value
   */
  public set utilisateur(value: Utilisateur | undefined) {
    this._utilisateur = value;
  }

  /**
   * Setter sport
   * @param {Sport } value
   */
  public set sport(value: Sport | undefined) {
    this._sport = value;
  }
}
