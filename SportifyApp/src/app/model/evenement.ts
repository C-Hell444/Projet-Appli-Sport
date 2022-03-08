import { Club } from './club';
import { EvenementUtilisateur } from './evenement-utilisateur';

export class Evenement {
  private _id: number | undefined;
  private _nom: string | undefined;
  private _dateDebut: Date | undefined;
  private _dateFin: Date | undefined;
  private _participants: EvenementUtilisateur[] | undefined;
  private _club: Club | undefined;

  constructor(
    id?: number,
    nom?: string,
    dateDebut?: Date,
    dateFin?: Date,
    participants?: EvenementUtilisateur[],
    club?: Club
  ) {
    this._id = id;
    this._nom = nom;
    this._dateDebut = dateDebut;
    this._dateFin = dateFin;
    this._participants = participants;
    this._club = club;
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
   * Getter dateDebut
   * @return {Date }
   */
  public get dateDebut(): Date | undefined {
    return this._dateDebut;
  }

  /**
   * Getter dateFin
   * @return {Date }
   */
  public get dateFin(): Date | undefined {
    return this._dateFin;
  }

  /**
   * Getter participants
   * @return {EvenementUtilisateur[] }
   */
  public get participants(): EvenementUtilisateur[] | undefined {
    return this._participants;
  }

  /**
   * Getter club
   * @return {Club }
   */
  public get club(): Club | undefined {
    return this._club;
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
   * Setter dateDebut
   * @param {Date } value
   */
  public set dateDebut(value: Date | undefined) {
    this._dateDebut = value;
  }

  /**
   * Setter dateFin
   * @param {Date } value
   */
  public set dateFin(value: Date | undefined) {
    this._dateFin = value;
  }

  /**
   * Setter participants
   * @param {EvenementUtilisateur[] } value
   */
  public set participants(value: EvenementUtilisateur[] | undefined) {
    this._participants = value;
  }

  /**
   * Setter club
   * @param {Club } value
   */
  public set club(value: Club | undefined) {
    this._club = value;
  }
}
