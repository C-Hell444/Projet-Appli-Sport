package projet.AppliSport.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EvenementUtilisateurKey implements Serializable {

	@ManyToOne
	@JoinColumn(name = "evenementutilisateurkey_utilisateur", foreignKey = @ForeignKey(name = "evenementutilisateurkey_utilisateur_fk"))
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name = "evenementutilisateurkey_evenement", foreignKey = @ForeignKey(name = "evenementutilisateurkey_evenement_fk"))
	private Evenement evenement;
	
	public EvenementUtilisateurKey() {
		
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	@Override
	public int hashCode() {
		return Objects.hash(evenement, utilisateur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvenementUtilisateurKey other = (EvenementUtilisateurKey) obj;
		return Objects.equals(evenement, other.evenement) && Objects.equals(utilisateur, other.utilisateur);
	}
	
	
	
}