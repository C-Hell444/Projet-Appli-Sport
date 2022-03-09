package projet.AppliSport.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Adresse;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Sport;
import projet.AppliSport.model.Utilisateur;


public interface ClubRepository extends JpaRepository<Club, Long>{

	
	
	
	
	List<Club> findAllByOrderById();
	List<Club> findAllByOrderByClubNom();
	List<Club> findAllByOrderByNumTel();
	List<Club> findAllByOrderBySportClub();
	@Query("select c from Club c order by c.adresse.ville")
	List<Club> findAllByOrderByVille();
	@Query("select c from Club c order by c.adresse.codePostal")
	List<Club> findAllByOrderByCodePostal();
	
	
	List<Club> findByClubNom(String nom);
	List<Club> findByNumTel(String num);
	List<Club> findBySportClub(Sport sport);
	@Query("select c from Club c where c.sportClub.nom=:nom")
	List<Club> findBySportNom(@Param("nom")String nom);
	@Query("select c from Club c where c.adresse.ville=:ville")
	List<Club> findByVille(@Param("ville")String ville);
	@Query("select c from Club c where c.adresse.codePostal=:cp")
	List<Club> findByCodePostal(@Param("cp")String cp);

	
	
	@Query("select c from Club c left join c.sportClub where c.id=:id")
	Optional<Club> findByIdWithSport(@Param("id") Long id);
	
	
	
	@Transactional
	@Modifying
	@Query("update Club c set c.sportClub=null where c.sportClub=:sport")
	void setSportToNull(@Param("sport") Sport sport);
	
	@Query("select c from Club c left join fetch c.equipes where c.id=:id")
	Optional<Club> findByIdWithEquipe(@Param("id") Long id);
	
	@Query("select c from Club c left join fetch c.evenements where c.id=:id")
	Optional<Club> findByIdWithEvenement(@Param("id") Long id);
	
	@Query("select c from Club c left join fetch c.listeMembres where c.id=:id")
	Optional<Club> findByIdWithUtilisateur(@Param("id") Long id);
	
	@Query("select c from Club c left join fetch c.listeMembres l where c.id=:id order by l.dateDebut asc")
	Optional<Club> findByIdWithClubUtilisateurOrderByDateDebutAsc(@Param("id") Long id);
	
	@Query("select c from Club c left join fetch c.listeMembres l where c.id=:id order by l.dateDebut desc")
	Optional<Club> findByIdWithClubUtilisateurOrderByDateDebutDesc(@Param("id") Long id);
	
	@Query("select c from Club c left join fetch c.listeMembres l where c.id=:id order by l.dateFin asc")
	Optional<Club> findByIdWithClubUtilisateurOrderByDateFinAsc(@Param("id") Long id);
	
	@Query("select c from Club c left join fetch c.listeMembres l where c.id=:id order by l.dateFin desc")
	Optional<Club> findByIdWithClubUtilisateurOrderByDateFinDesc(@Param("id") Long id);

}
