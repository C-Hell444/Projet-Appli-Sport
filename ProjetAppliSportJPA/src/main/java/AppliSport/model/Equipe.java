package AppliSport.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="equipe")
@SequenceGenerator(name = "seqEquipe", sequenceName = "seq_equipe", initialValue = 100, allocationSize = 1)
public class Equipe {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEquipe")
	@Column(name="id_equipe")
	private Long id;
	
	@Transient
//	@Column(name="liste_membre_equipe")
//	@OneToMany(mappedBy = "?")
	private List<Utilisateur> equipe = new ArrayList();
	
	public Equipe() {
			
	}

	

	public Equipe(Long id, List<Utilisateur> equipe) {
		this.id = id;
		this.equipe = equipe;
	}






	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public List<Utilisateur> getEquipe() {
		return equipe;
	}


	public void setEquipe(List<Utilisateur> equipe) {
		this.equipe = equipe;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipe other = (Equipe) obj;
		return Objects.equals(id, other.id);
	}

	
	

	
	
}
