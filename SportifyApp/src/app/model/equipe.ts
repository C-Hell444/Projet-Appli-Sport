import { Club } from 'src/app/model/club';
import { EquipeUtilisateur } from './equipe-utilisateur';
export class Equipe {
  private _id: number | undefined;
  private _nom: string | undefined;
  private _equipe: EquipeUtilisateur[] | undefined;
  private _club: Club | undefined;

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter equipe
   * @return {EquipeUtilisateur[] | undefined }
   */
  public get equipe(): EquipeUtilisateur[] | undefined {
    return this._equipe;
  }

  /**
   * Getter club
   * @return {Club }
   */
  public get club(): Club | undefined {
    return this._club;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter equipe
   * @param {EquipeUtilisateur[] } value
   */
  public set equipe(value: EquipeUtilisateur[] | undefined) {
    this._equipe = value;
  }

  /**
   * Setter club
   * @param {Club } value
   */
  public set club(value: Club | undefined) {
    this._club = value;
  }

  constructor(
    id?: number,
    nom?: string,
    equipe?: EquipeUtilisateur[],
    club?: Club
  ) {
    this._id = id;
    this._nom = nom;
    this._equipe = equipe;
    this._club = club;
  }
}
