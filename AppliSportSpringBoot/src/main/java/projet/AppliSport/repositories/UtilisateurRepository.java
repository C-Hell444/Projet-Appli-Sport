package projet.AppliSport.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Adresse;
import projet.AppliSport.model.Caracteristique;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Profil;
import projet.AppliSport.model.Sport;
import projet.AppliSport.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	
	
	List<Utilisateur> findAllByOrderById();
	List<Utilisateur> findAllByOrderByNom();
	List<Utilisateur> findAllByOrderByPrenom();
	List<Utilisateur> findAllByOrderByNumTel();
	@Query("select u from Utilisateur u order by u.adresse.ville")
	List<Utilisateur> findAllByOrderByVille();
	@Query("select u from Utilisateur u order by u.adresse.codePostal")
	List<Utilisateur> findAllByOrderByCodePostal();
	
	
	List<Utilisateur> findByNom(String nom);
	List<Utilisateur> findByPrenom(String prenom);
	List<Utilisateur> findByNumTel(String numTel);
	@Query("select u from Utilisateur u where u.adresse.ville=:ville")
	List<Utilisateur> findByVille(@Param("ville")String ville);
	@Query("select u from Utilisateur u where u.adresse.codePostal=:cp")
	List<Utilisateur> findByCodePostal(@Param("cp")String cp);
	
	
	
	@Query("select u from Utilisateur u left join u.interets i where i.sport=:sport")
	List<Utilisateur> findAllBySport(@Param("sport") Sport sport);
	
	
	Optional<Utilisateur> findByProfilUtilisateur(Profil profilUtilisateur);
	
	
	
	@Query("select u from Utilisateur u left join fetch u.interets where u.id=:id")
	Optional<Utilisateur> findByIdWithInterets(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.clubs where u.id=:id")
	Optional<Utilisateur> findByIdWithClubUtilisateur(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.clubs e where u.id=:id order by e.dateDebut asc")
	Optional<Utilisateur> findByIdWithClubUtilisateurOrderByDateDebutAsc(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.clubs e where u.id=:id order by e.dateDebut desc")
	Optional<Utilisateur> findByIdWithClubUtilisateurOrderByDateDebutDesc(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.clubs e where u.id=:id order by e.dateFin asc")
	Optional<Utilisateur> findByIdWithClubUtilisateurOrderByDateFinAsc(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.clubs e where u.id=:id order by e.dateFin desc")
	Optional<Utilisateur> findByIdWithClubUtilisateurOrderByDateFinDesc(@Param("id") Long id);
	
	
	
	
	@Query("select u from Utilisateur u left join fetch u.equipes where u.id=:id")
	Optional<Utilisateur> findByIdWithEquipeUtilisateur(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.equipes e where u.id=:id order by e.dateDebut asc")
	Optional<Utilisateur> findByIdWithEquipeUtilisateurOrderByDateDebutAsc(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.equipes e where u.id=:id order by e.dateDebut desc")
	Optional<Utilisateur> findByIdWithEquipeUtilisateurOrderByDateDebutDesc(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.equipes e where u.id=:id order by e.dateFin asc")
	Optional<Utilisateur> findByIdWithEquipeUtilisateurOrderByDateFinAsc(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.equipes e where u.id=:id order by e.dateFin desc")
	Optional<Utilisateur> findByIdWithEquipeUtilisateurOrderByDateFinDesc(@Param("id") Long id);
	
	
	
	
	@Query("select u from Utilisateur u left join fetch u.evenements where u.id=:id")
	Optional<Utilisateur> findByIdWithEvenementUtilisateur(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.evenements e where u.id=:id order by e.dateDebut asc")
	Optional<Utilisateur> findByIdWithEvenementUtilisateurOrderByDateDebutAsc(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.evenements e where u.id=:id order by e.dateDebut desc")
	Optional<Utilisateur> findByIdWithEvenementUtilisateurOrderByDateDebutDesc(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.evenements e where u.id=:id order by e.dateFin asc")
	Optional<Utilisateur> findByIdWithEvenementUtilisateurOrderByDateFinAsc(@Param("id") Long id);
	
	@Query("select u from Utilisateur u left join fetch u.evenements e where u.id=:id order by e.dateFin desc")
	Optional<Utilisateur> findByIdWithEvenementUtilisateurOrderByDateFinDesc(@Param("id") Long id);
	
	
	@Transactional
	@Modifying
	@Query("update Utilisateur u set u.profilUtilisateur=null where u.profilUtilisateur=:profil")
	void setProfilToNull(@Param("profil") Profil profil);
	
	
	
}
