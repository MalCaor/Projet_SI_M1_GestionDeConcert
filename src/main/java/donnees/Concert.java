package donnees;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "t_Concert_con")
@NamedQueries({
    @NamedQuery(name = "t_Concert_con.findAll", query = "SELECT d FROM Concert d"),
    @NamedQuery(name = "t_Concert_con.findByCon_id", query = "SELECT d FROM Concert d WHERE d.con_id = :con_id"),
})
public class Concert implements Serializable{

	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_id")
    private Short con_id;
    @Column(name = "date_debut")
    private String con_date_debut;
    @Column(name = "con_date_fin")
    private String con_date_fin;
    @Column(name = "con_prix")
    private double con_fin;
    
    /*
    @JoinColumn(name = "sal_id", referencedColumnName = "csal_id")
    private List<Groupe> participant;
    */
	public Concert() {
		
	}

	public Short getCon_id() {
		return con_id;
	}

	public void setCon_id(Short con_id) {
		this.con_id = con_id;
	}

	public String getCon_date_debut() {
		return con_date_debut;
	}

	public void setCon_date_debut(String con_date_debut) {
		this.con_date_debut = con_date_debut;
	}

	public String getCon_date_fin() {
		return con_date_fin;
	}

	public void setCon_date_fin(String con_date_fin) {
		this.con_date_fin = con_date_fin;
	}

	public double getCon_fin() {
		return con_fin;
	}

	public void setCon_fin(double con_fin) {
		this.con_fin = con_fin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(con_date_debut, con_date_fin, con_fin, con_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concert other = (Concert) obj;
		return Objects.equals(con_date_debut, other.con_date_debut) && Objects.equals(con_date_fin, other.con_date_fin)
				&& Double.doubleToLongBits(con_fin) == Double.doubleToLongBits(other.con_fin)
				&& Objects.equals(con_id, other.con_id);
	}
	
	@Override 
	public String toString() {
		return this.toString();
	}
}
