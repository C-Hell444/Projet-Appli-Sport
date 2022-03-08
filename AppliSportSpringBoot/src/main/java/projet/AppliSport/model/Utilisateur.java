package projet.AppliSport.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "utilisateur", uniqueConstraints = { @UniqueConstraint(columnNames = "compte_identifiant", name = "utilisateur_identifiant_uk"), @UniqueConstraint(columnNames = "compte_mail", name = "utilisateur_mail_uk") })
public class Utilisateur extends Compte {
	
	@Valid
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "utilisateur_numero", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "utilisateur_rue", length = 200)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "utilisateur_code_postal", length = 20)),
			@AttributeOverride(name = "ville", column = @Column(name = "utilisateur_ville", length = 100)) })
	@JsonView(Views.Common.class)
	private Adresse adresse;
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]((-|')?([a-zA-Z]{1,}))*$")
	@Column(name = "utilisateur_nom", length = 100)
	@JsonView(Views.Common.class)
	private String nom;
	
	@Pattern(regexp = "^[a-zA-Z]((-|')?([a-zA-Z]{1,}))*$")
	@NotEmpty
	@Column(name = "utilisateur_prenom", length = 100)
	@JsonView(Views.Common.class)
	private String prenom;
	
	@NotEmpty
	@Pattern(regexp="^(0|\\+33)[1-9]([-. ]?[0-9]{2}){4}$")
	@Column(name = "utilisateur_tel", length = 30)
	@JsonView(Views.Common.class)
	private String numTel;
	
	@OneToMany(mappedBy = "utilisateur")
	@JsonView(Views.UtilisateurWithInteret.class)
	private Set<Interet> interets;
	@OneToOne
	@JoinColumn(name = "utilisateur_profil", foreignKey = @ForeignKey(name = "utilisateur_profil_fk"))
	@JsonView(Views.UtilisateurWithProfil.class)
	private Profil profilUtilisateur;
	
	@OneToMany(mappedBy = "id.utilisateur")
	@JsonView(Views.UtilisateurWithEquipeUtilisateur.class)
	private List<EquipeUtilisateur> equipes;
	@OneToMany(mappedBy = "id.utilisateur")
	@JsonView(Views.UtilisateurWithEvenementUtilisateur.class)
	private List<EvenementUtilisateur> evenements;
	@OneToMany(mappedBy = "id.utilisateur")
	@JsonView(Views.UtilisateurWithClubUtilisateur.class)
	private List<ClubUtilisateur> clubs;
	

	public Utilisateur() {
		
	}

	
	public Utilisateur(String identifiant, String mdp, String mail,
			@NotEmpty @Pattern(regexp = "^[a-zA-Z]((-|')?([a-zA-Z]{1,}))*$") String nom,
			@Pattern(regexp = "^[a-zA-Z]((-|')?([a-zA-Z]{1,}))*$") @NotEmpty String prenom,
			@NotEmpty @Pattern(regexp = "^(0|\\+33)[1-9]([-. ]?[0-9]{2}){4}$") String numTel) {
		super(identifiant, mdp, mail);
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
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


	

	public Set<Interet> getInterets() {
		return interets;
	}




	public void setInterets(Set<Interet> interets) {
		this.interets = interets;
	}




	public List<EquipeUtilisateur> getEquipes() {
		return equipes;
	}




	public void setEquipes(List<EquipeUtilisateur> equipes) {
		this.equipes = equipes;
	}




	public List<EvenementUtilisateur> getEvenements() {
		return evenements;
	}




	public void setEvenements(List<EvenementUtilisateur> evenements) {
		this.evenements = evenements;
	}




	public Profil getProfilUtilisateur() {
		return profilUtilisateur;
	}


	public void setProfilUtilisateur(Profil profilUtilisateur) {
		this.profilUtilisateur = profilUtilisateur;
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public List<ClubUtilisateur> getClubs() {
		return clubs;
	}




	public void setClubs(List<ClubUtilisateur> clubs) {
		this.clubs = clubs;
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