package AppliSport.model.caracteristiques;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="caracteristique")
@SequenceGenerator(name="seqCaracteristique", sequenceName = "seq_caracteristique",initialValue = 1, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_caracteristique",discriminatorType = DiscriminatorType.STRING,length = 10)
public abstract class Caracteristique {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "seqCaracteristique")
	@Column(name="carac_id")
	private Long id;

	
	
	public Caracteristique() {
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Caracteristique other = (Caracteristique) obj;
		return Objects.equals(id, other.id);
	}

	
}
