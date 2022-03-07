import { Equipe } from './equipe';
import { Utilisateur } from './utilisateur';

export class EquipeUtilisateurKey {
  private _utilisateur: Utilisateur | undefined;
  private _equipe: Equipe | undefined;

  constructor(utilisateur?: Utilisateur, equipe?: Equipe) {
    this._utilisateur = utilisateur;
    this._equipe = equipe;
  }

  /**
   * Getter utilisateur
   * @return {Utilisateur }
   */
  public get utilisateur(): Utilisateur | undefined {
    return this._utilisateur;
  }

  /**
   * Getter equipe
   * @return {Equipe }
   */
  public get equipe(): Equipe | undefined {
    return this._equipe;
  }

  /**
   * Setter utilisateur
   * @param {Utilisateur } value
   */
  public set utilisateur(value: Utilisateur | undefined) {
    this._utilisateur = value;
  }

  /**
   * Setter equipe
   * @param {Equipe } value
   */
  public set equipe(value: Equipe | undefined) {
    this._equipe = value;
  }
}
