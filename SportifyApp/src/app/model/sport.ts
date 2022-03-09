import { Caracteristique } from './caracteristique';
import { Club } from './club';
import { Interet } from './interet';

export class Sport {
  private _id: number | undefined;
  private _nom: string | undefined;
  private _clubs: Club[] | undefined;
  private _interets: Interet[] | undefined;
  private _caracteristique: Caracteristique | undefined;

  constructor(
    id?: number,
    nom?: string,
    clubs?: Club[],
    interets?: Interet[],
    caracteristique?: Caracteristique
  ) {
    this._id = id;
    this._nom = nom;
    this._clubs = clubs;
    this._interets = interets;
    this._caracteristique = caracteristique;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter clubs
   * @return {Club[] }
   */
  public get clubs(): Club[] | undefined {
    return this._clubs;
  }

  /**
   * Getter interets
   * @return {Interet[] }
   */
  public get interets(): Interet[] | undefined {
    return this._interets;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter clubs
   * @param {Club[] } value
   */
  public set clubs(value: Club[] | undefined) {
    this._clubs = value;
  }

  /**
   * Setter interets
   * @param {Interet[] } value
   */
  public set interets(value: Interet[] | undefined) {
    this._interets = value;
  }

  /**
   * Getter caracteristique
   * @return {Caracteristique }
   */
  public get caracteristique(): Caracteristique | undefined {
    return this._caracteristique;
  }

  /**
   * Setter caracteristique
   * @param {Caracteristique } value
   */
  public set caracteristique(value: Caracteristique | undefined) {
    this._caracteristique = value;
  }
}
