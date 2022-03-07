import { Club } from './club';
import { Utilisateur } from './utilisateur';

export class ClubUtilisateurKey {
  private _utilisateur: Utilisateur | undefined;
  private _club: Club | undefined;

  constructor(utilisateur?: Utilisateur, club?: Club) {
    this._utilisateur = utilisateur;
    this._club = club;
  }

  /**
   * Getter utilisateur
   * @return {Utilisateur}
   */
  public get utilisateur(): Utilisateur | undefined {
    return this._utilisateur;
  }

  /**
   * Getter club
   * @return {Club}
   */
  public get club(): Club | undefined {
    return this._club;
  }

  /**
   * Setter utilisateur
   * @param {Utilisateur} value
   */
  public set utilisateur(value: Utilisateur | undefined) {
    this._utilisateur = value;
  }

  /**
   * Setter club
   * @param {Club} value
   */
  public set club(value: Club | undefined) {
    this._club = value;
  }
}
