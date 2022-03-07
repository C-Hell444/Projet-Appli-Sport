import { Caracteristique } from './caracteristique';
import { Sexe } from './sexe';
import { Utilisateur } from './utilisateur';

export class Profil {
  private _id: number | undefined;
  private _poids: number | undefined;
  private _taille: number | undefined;
  private _dateNaissance: Date | undefined;
  private _sexe: Sexe | undefined;
  private _caracteristique: Caracteristique | undefined;
  private _utilisateur: Utilisateur | undefined;

  constructor(
    id?: number,
    poids?: number,
    taille?: number,
    dateNaissance?: Date,
    sexe?: Sexe,
    caracteristique?: Caracteristique,
    utilisateur?: Utilisateur
  ) {
    this._id = id;
    this._poids = poids;
    this._taille = taille;
    this._dateNaissance = dateNaissance;
    this._sexe = sexe;
    this._caracteristique = caracteristique;
    this._utilisateur = utilisateur;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter poids
   * @return {number }
   */
  public get poids(): number | undefined {
    return this._poids;
  }

  /**
   * Getter taille
   * @return {number }
   */
  public get taille(): number | undefined {
    return this._taille;
  }

  /**
   * Getter dateNaissance
   * @return {Date }
   */
  public get dateNaissance(): Date | undefined {
    return this._dateNaissance;
  }

  /**
   * Getter sexe
   * @return {Sexe }
   */
  public get sexe(): Sexe | undefined {
    return this._sexe;
  }

  /**
   * Getter caracteristique
   * @return {Caracteristique }
   */
  public get caracteristique(): Caracteristique | undefined {
    return this._caracteristique;
  }

  /**
   * Getter utilisateur
   * @return {Utilisateur }
   */
  public get utilisateur(): Utilisateur | undefined {
    return this._utilisateur;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter poids
   * @param {number } value
   */
  public set poids(value: number | undefined) {
    this._poids = value;
  }

  /**
   * Setter taille
   * @param {number } value
   */
  public set taille(value: number | undefined) {
    this._taille = value;
  }

  /**
   * Setter dateNaissance
   * @param {Date } value
   */
  public set dateNaissance(value: Date | undefined) {
    this._dateNaissance = value;
  }

  /**
   * Setter sexe
   * @param {Sexe } value
   */
  public set sexe(value: Sexe | undefined) {
    this._sexe = value;
  }

  /**
   * Setter caracteristique
   * @param {Caracteristique } value
   */
  public set caracteristique(value: Caracteristique | undefined) {
    this._caracteristique = value;
  }

  /**
   * Setter utilisateur
   * @param {Utilisateur } value
   */
  public set utilisateur(value: Utilisateur | undefined) {
    this._utilisateur = value;
  }
}
