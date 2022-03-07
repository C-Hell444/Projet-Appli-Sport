import { EvenementUtilisateurKey } from './evenement-utilisateur-key';

export class EvenementUtilisateur {
  private _id: EvenementUtilisateurKey | undefined;
  private _dateDebut: Date | undefined;
  private _dateFin: Date | undefined;

  constructor(id?: EvenementUtilisateurKey, dateDebut?: Date, dateFin?: Date) {
    this._id = id;
    this._dateDebut = dateDebut;
    this._dateFin = dateFin;
  }

  /**
   * Getter id
   * @return {EvenementUtilisateurKey }
   */
  public get id(): EvenementUtilisateurKey | undefined {
    return this._id;
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
   * Setter id
   * @param {EvenementUtilisateurKey } value
   */
  public set id(value: EvenementUtilisateurKey | undefined) {
    this._id = value;
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
}
