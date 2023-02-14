package donnees;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "sportif")
@NamedQueries({
    @NamedQuery(name = "Sportif.findAll", query = "SELECT s FROM Sportif s"),
    @NamedQuery(name = "Sportif.findByCodeSportif", query = "SELECT s FROM Sportif s WHERE s.codeSportif = :codeSportif"),
    @NamedQuery(name = "Sportif.findByNom", query = "SELECT s FROM Sportif s WHERE s.nom = :nom"),
    @NamedQuery(name = "Sportif.findByRue", query = "SELECT s FROM Sportif s WHERE s.rue = :rue"),
    @NamedQuery(name = "Sportif.findByVille", query = "SELECT s FROM Sportif s WHERE s.ville = :ville"),
    @NamedQuery(name = "Sportif.findByCodePostal", query = "SELECT s FROM Sportif s WHERE s.code_postal = :codePostal")})
public class Sportif {
	//private static final long serialVersionUID = 0;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_sportif")
	private int codeSportif;
	@Column(name = "nom")
    private String nom;
	@Column(name = "rue")
    private String rue;
	@Column(name = "ville")
    private String ville;
	@Column(name = "code_postal")
    private int code_postal;
	 @JoinTable(name = "pratique", joinColumns = {
		        @JoinColumn(name = "code_sportif", referencedColumnName = "code_sportif")}, inverseJoinColumns = {
		        @JoinColumn(name = "code_discipline", referencedColumnName = "code_discipline")})
    @ManyToMany    
    private Set<Discipline> disciplines;
 
    
    public Sportif(int codeSportif, String nom, String rue,String ville,int code_postal,Set<Discipline> discipline) {
        this.codeSportif = codeSportif;
        this.nom = nom;
        this.rue = rue;
        this.ville = ville;
        this.code_postal = code_postal;
        this.disciplines = new HashSet<Discipline>();
        
    }
    
    public Sportif() {};
    
   


/*
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Discipline other = (Discipline) obj;
        if (this.codeDiscipline != other.codeDiscipline) {
            return false;
        }
        if (!Objects.equals(this.intitule, other.intitule)) {
            return false;
        }
        if (!Objects.equals(this.sport, other.sport)) {
            return false;
        }
        return true;
    }
*/
    @Override
    public String toString() {
     	String ldisc="";
    	Iterator<Discipline> it = disciplines.iterator();
    	while(it.hasNext()) {
    		ldisc+=it.next();
    	}
        return "sportif{" + "codeSportif=" + codeSportif + ", intitule=" + nom + ", discipline ="+ldisc  + '}';
    }



	public int getCodeSportif() {
		return codeSportif;
	}



	public void setCodeSportif(int codeSportif) {
		this.codeSportif = codeSportif;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getRue() {
		return rue;
	}



	public void setRue(String rue) {
		this.rue = rue;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public int getCode_postal() {
		return code_postal;
	}



	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codeSportif;
		result = prime * result + code_postal;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());

		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}


	public Set<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(Set<Discipline> disciplines) {
		this.disciplines = disciplines;
	}
    
}
