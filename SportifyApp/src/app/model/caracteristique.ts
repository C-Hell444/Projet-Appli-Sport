import { Sport } from './sport';
import { Profil } from './profil';

export class Caracteristique {
  private _id: number | undefined;
  private _collectif: number | undefined;
  private _creativite: number | undefined;
  private _determination: number | undefined;
  private _patience: number | undefined;
  private _detente: number | undefined;
  private _agilite: number | undefined;
  private _puissance: number | undefined;
  private _vitesse: number | undefined;
  private _endurance: number | undefined;
  private _profil: Profil | undefined;
  private _sport: Sport | undefined;

  constructor(
    id?: number,
    collectif?: number,
    creativite?: number,
    determination?: number,
    patience?: number,
    detente?: number,
    agilite?: number,
    puissance?: number,
    vitesse?: number,
    endurance?: number,
    profil?: Profil,
    sport?: Sport
  ) {
    this._id = id;
    this._collectif = collectif;
    this._creativite = creativite;
    this._determination = determination;
    this._patience = patience;
    this._detente = detente;
    this._agilite = agilite;
    this._puissance = puissance;
    this._vitesse = vitesse;
    this._endurance = endurance;
    this._profil = profil;
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
   * Getter collectif
   * @return {number }
   */
  public get collectif(): number | undefined {
    return this._collectif;
  }

  /**
   * Getter creativite
   * @return {number }
   */
  public get creativite(): number | undefined {
    return this._creativite;
  }

  /**
   * Getter determination
   * @return {number }
   */
  public get determination(): number | undefined {
    return this._determination;
  }

  /**
   * Getter patience
   * @return {number }
   */
  public get patience(): number | undefined {
    return this._patience;
  }

  /**
   * Getter detente
   * @return {number }
   */
  public get detente(): number | undefined {
    return this._detente;
  }

  /**
   * Getter agilite
   * @return {number }
   */
  public get agilite(): number | undefined {
    return this._agilite;
  }

  /**
   * Getter puissance
   * @return {number }
   */
  public get puissance(): number | undefined {
    return this._puissance;
  }

  /**
   * Getter vitesse
   * @return {number }
   */
  public get vitesse(): number | undefined {
    return this._vitesse;
  }

  /**
   * Getter endurance
   * @return {number }
   */
  public get endurance(): number | undefined {
    return this._endurance;
  }

  /**
   * Getter profil
   * @return {Profil }
   */
  public get profil(): Profil | undefined {
    return this._profil;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter collectif
   * @param {number } value
   */
  public set collectif(value: number | undefined) {
    this._collectif = value;
  }

  /**
   * Setter creativite
   * @param {number } value
   */
  public set creativite(value: number | undefined) {
    this._creativite = value;
  }

  /**
   * Setter determination
   * @param {number } value
   */
  public set determination(value: number | undefined) {
    this._determination = value;
  }

  /**
   * Setter patience
   * @param {number } value
   */
  public set patience(value: number | undefined) {
    this._patience = value;
  }

  /**
   * Setter detente
   * @param {number } value
   */
  public set detente(value: number | undefined) {
    this._detente = value;
  }

  /**
   * Setter agilite
   * @param {number } value
   */
  public set agilite(value: number | undefined) {
    this._agilite = value;
  }

  /**
   * Setter puissance
   * @param {number } value
   */
  public set puissance(value: number | undefined) {
    this._puissance = value;
  }

  /**
   * Setter vitesse
   * @param {number } value
   */
  public set vitesse(value: number | undefined) {
    this._vitesse = value;
  }

  /**
   * Setter endurance
   * @param {number } value
   */
  public set endurance(value: number | undefined) {
    this._endurance = value;
  }

  /**
   * Setter profil
   * @param {Profil } value
   */
  public set profil(value: Profil | undefined) {
    this._profil = value;
  }

  /**
   * Getter sport
   * @return {Sport }
   */
  public get sport(): Sport | undefined {
    return this._sport;
  }

  /**
   * Setter sport
   * @param {Sport } value
   */
  public set sport(value: Sport | undefined) {
    this._sport = value;
  }
}
