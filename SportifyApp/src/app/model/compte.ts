export class Compte {
  private _id: number | undefined;
  private _identifiant: string | undefined;
  private _mdp: string | undefined;
  private _mail: string | undefined;

  constructor(id?: number, identifiant?: string, mdp?: string, mail?: string) {
    this._id = id;
    this._identifiant = identifiant;
    this._mdp = mdp;
    this._mail = mail;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter identifiant
   * @return {string }
   */
  public get identifiant(): string | undefined {
    return this._identifiant;
  }

  /**
   * Getter mdp
   * @return {string }
   */
  public get mdp(): string | undefined {
    return this._mdp;
  }

  /**
   * Getter mail
   * @return {string }
   */
  public get mail(): string | undefined {
    return this._mail;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter identifiant
   * @param {string } value
   */
  public set identifiant(value: string | undefined) {
    this._identifiant = value;
  }

  /**
   * Setter mdp
   * @param {string } value
   */
  public set mdp(value: string | undefined) {
    this._mdp = value;
  }

  /**
   * Setter mail
   * @param {string } value
   */
  public set mail(value: string | undefined) {
    this._mail = value;
  }
}
