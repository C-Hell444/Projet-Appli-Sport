package projet.AppliSport.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonView;

import projet.AppliSport.views.Views;

@Entity
@Table(name = "club", uniqueConstraints = {
		@UniqueConstraint(columnNames = "compte_identifiant", name = "club_identifiant_uk"),
		@UniqueConstraint(columnNames = "compte_mail", name = "club_mail_uk") })
public class Club extends Compte {

	@Valid
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "client_numero", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "client_rue", length = 200)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "client_code_postal", length = 20)),
			@AttributeOverride(name = "ville", column = @Column(name = "client_ville", length = 100)) })
	@JsonView(Views.Common.class)
	private Adresse adresse;

	@NotEmpty
	@Column(name = "club_tel", length = 30)
	@Pattern(regexp="^(0|\\+33)[1-9]([-. ]?[0-9]{2}){4}$")
	@JsonView(Views.Common.class)
	private String numTel;

	@NotEmpty
	@Column(name = "club_nom", length = 30)
	@JsonView(Views.Common.class)
	private String clubNom;

	@ManyToOne
	@JoinColumn(name = "club_sportclub", foreignKey = @ForeignKey(name = "club_sportclub_fk"))
	@JsonView(Views.Common.class)
	private Sport sportClub;

	@OneToMany(mappedBy = "id.utilisateur")
	@JsonView(Views.ClubUtilisateur.class)
	private List<ClubUtilisateur> listeMembres;

	@OneToMany(mappedBy = "club")
	@JsonView(Views.ClubEquipe.class)
	private List<Equipe> equipes;

	@OneToMany(mappedBy = "club")
	@JsonView(Views.ClubEvenement.class)
	private List<Evenement> evenements;

	public Club() {

	}

	public Club(String identifiant, String mdp, String mail, Adresse adresse, String numTel, Sport sportClub,
			List<Utilisateur> listeMembresActif, List<Utilisateur> listeMembresInactif) {
		super(identifiant, mdp, mail);
		this.adresse = adresse;
		this.numTel = numTel;
		this.sportClub = sportClub;

	}

	public Club(String identifiant, String mdp, String mail, @NotEmpty String numTel, @NotEmpty String clubNom) {
		super(identifiant, mdp, mail);
		this.numTel = numTel;
		this.clubNom = clubNom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public Sport getSportClub() {
		return sportClub;
	}

	public void setSportClub(Sport sportClub) {
		this.sportClub = sportClub;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public List<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	public String getClubNom() {
		return clubNom;
	}

	public void setClubNom(String clubNom) {
		this.clubNom = clubNom;
	}

	public List<ClubUtilisateur> getListeMembres() {
		return listeMembres;
	}

	public void setListeMembres(List<ClubUtilisateur> listeMembres) {
		this.listeMembres = listeMembres;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(this.getClass().getSimpleName()));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getMdp();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getIdentifiant();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
