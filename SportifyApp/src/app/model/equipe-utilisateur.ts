import { EquipeUtilisateurKey } from './equipe-utilisateur-key';

export class EquipeUtilisateur {
  private _id: EquipeUtilisateurKey | undefined;
  private _dateDebut: Date | undefined;
  private _dateFin: Date | undefined;

  constructor(id?: EquipeUtilisateurKey, dateDebut?: Date, dateFin?: Date) {
    this._id = id;
    this._dateDebut = dateDebut;
    this._dateFin = dateFin;
  }

  /**
   * Getter id
   * @return {EquipeUtilisateurKey }
   */
  public get id(): EquipeUtilisateurKey | undefined {
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
   * @param {EquipeUtilisateurKey } value
   */
  public set id(value: EquipeUtilisateurKey | undefined) {
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
