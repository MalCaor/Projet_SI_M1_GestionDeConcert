package donnees;

import java.util.HashSet;
import java.util.Objects;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
*
* @author ercar
*/
@Entity
@Table(name = "sport")
@NamedQueries({
   @NamedQuery(name = "Sport.findAll", query = "SELECT s FROM Sport s"),
   @NamedQuery(name = "Sport.findByCodeSport", query = "SELECT s FROM Sport s WHERE s.codeSport = :codeSport"),
   @NamedQuery(name = "Sport.findByIntitule", query = "SELECT s FROM Sport s WHERE s.intitule = :intitule")})
public class Sport implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "code_sport")
   private int codeSport;
   @Column(name = "intitule")
   private String intitule;
   @OneToMany(mappedBy = "sport")
   private Set<Discipline> disciplines;

   public Sport() {
   }

   public Sport(int codeSport) {
       this.codeSport = codeSport;
   }

   public int getCodeSport() {
       return codeSport;
   }

   public void setCodeSport(int codeSport) {
       this.codeSport = codeSport;
   }

   public String getIntitule() {
       return intitule;
   }

   public void setIntitule(String intitule) {
       this.intitule = intitule;
   }

   public Set<Discipline> getDisciplines() {
       return disciplines;
   }

   public void setDisciplines(Set<Discipline> disciplineSet) {
       this.disciplines = disciplineSet;
   }



   @Override
   public String toString() {
       return "data.Sport[ codeSport=" + codeSport + " ]";
   }

@Override
public int hashCode() {
	return Objects.hash(codeSport, disciplines, intitule);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Sport other = (Sport) obj;
	return codeSport == other.codeSport && Objects.equals(disciplines, other.disciplines)
			&& Objects.equals(intitule, other.intitule);
}
   
}
