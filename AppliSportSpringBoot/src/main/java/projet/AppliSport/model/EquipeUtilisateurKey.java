package projet.AppliSport.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EquipeUtilisateurKey implements Serializable {

	@ManyToOne
	@JoinColumn(name = "equipeutilisateurkey_utilisateur", foreignKey = @ForeignKey(name = "equipeutilisateurkey_utilisateur_fk"))
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name = "equipeutilisateurkey_equipe", foreignKey = @ForeignKey(name = "equipeutilisateurkey_equipe_fk"))
	private Equipe equipe;
	
	public EquipeUtilisateurKey() {
		
	}

	public EquipeUtilisateurKey(Utilisateur utilisateur, Equipe equipe) {
		super();
		this.utilisateur = utilisateur;
		this.equipe = equipe;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipe, utilisateur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipeUtilisateurKey other = (EquipeUtilisateurKey) obj;
		return Objects.equals(equipe, other.equipe) && Objects.equals(utilisateur, other.utilisateur);
	}
	
	
	
}
