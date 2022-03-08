package projet.AppliSport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Caracteristique;
import projet.AppliSport.model.Sport;

public interface SportRepository extends JpaRepository<Sport, Long> {

	@Query("select s from Sport s left join s.clubs where s.id=:id")
	Optional<Sport> findByIdWithClub(@Param("id") Long id);

	@Query("select s from Sport s left join s.interets where s.id=:id")
	Optional<Sport> findByIdWithInteret(@Param("id") Long id);

	@Query("select s from Sport s where s.caracteristique.collectif<=:collectif and s.caracteristique.creativite<=:creativite and s.caracteristique.determination<=:determination and s.caracteristique.patience<=:patience and s.caracteristique.agilite<=:agilite and s.caracteristique.detente<=:detente and s.caracteristique.puissance<=:puissance and s.caracteristique.vitesse<=:vitesse and s.caracteristique.endurance<=:endurance")
	List<Sport> findByCaracteristique(@Param("collectif") int collectif, @Param("creativite") int creativite,
			@Param("determination") int determination, @Param("patience") int patience, @Param("agilite") int agilite,
			@Param("detente") int detente, @Param("puissance") int puissance, @Param("vitesse") int vitesse,
			@Param("endurance") int endurance);

}
