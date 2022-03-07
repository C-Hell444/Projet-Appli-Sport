package projet.AppliSport.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

import projet.AppliSport.views.Views;

@Embeddable
public class ClubUtilisateurKey implements Serializable {

	@ManyToOne
	@JoinColumn(name = "clubutilisateurkey_utilisateur", foreignKey = @ForeignKey(name = "clubutilisateurkey_utilisateur_fk"))
	@JsonView(Views.ClubWithClubUtilisateur.class)
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name = "clubutilisateurkey_club", foreignKey = @ForeignKey(name = "clubutilisateurkey_club_fk"))
	@JsonView(Views.UtilisateurWithClubUtilisateur.class)
	private Club club;

	public ClubUtilisateurKey() {

	}

	public ClubUtilisateurKey(Utilisateur utilisateur, Club club) {
		this.utilisateur = utilisateur;
		this.club = club;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	@Override
	public int hashCode() {
		return Objects.hash(club, utilisateur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClubUtilisateurKey other = (ClubUtilisateurKey) obj;
		return Objects.equals(club, other.club) && Objects.equals(utilisateur, other.utilisateur);
	}

}
