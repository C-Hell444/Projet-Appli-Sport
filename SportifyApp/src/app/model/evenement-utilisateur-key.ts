import { Evenement } from './evenement';
import { Utilisateur } from './utilisateur';

export class EvenementUtilisateurKey {
  private _utilisateur: Utilisateur | undefined;
  private _evenement: Evenement | undefined;

  constructor(utilisateur?: Utilisateur, evenement?: Evenement) {
    this._utilisateur = utilisateur;
    this._evenement = evenement;
  }

  /**
   * Getter utilisateur
   * @return {Utilisateur }
   */
  public get utilisateur(): Utilisateur | undefined {
    return this._utilisateur;
  }

  /**
   * Getter evenement
   * @return {Evenement }
   */
  public get evenement(): Evenement | undefined {
    return this._evenement;
  }

  /**
   * Setter utilisateur
   * @param {Utilisateur } value
   */
  public set utilisateur(value: Utilisateur | undefined) {
    this._utilisateur = value;
  }

  /**
   * Setter evenement
   * @param {Evenement } value
   */
  public set evenement(value: Evenement | undefined) {
    this._evenement = value;
  }
}
