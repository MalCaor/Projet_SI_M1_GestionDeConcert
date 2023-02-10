package donnees;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_Salle")
@NamedQueries({
   @NamedQuery(name = "Salle.findAll", query = "SELECT s FROM Salle s"),
   @NamedQuery(name = "Salle.findByCodeSport", query = "SELECT s FROM Salle s WHERE s.sall_id = :sall_id"),
   @NamedQuery(name = "Salle.findByIntitule", query = "SELECT s FROM Salle s WHERE s.sal_nom = :sal_nom")})

public class Salle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3601670907867020064L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "sall_id")
	private int sall_id;
	@Column(name = "sal_capacité")
	private int sal_capacité;
	@Column(name = "sal_nom")
	private String sal_nom;
	@ManyToOne
	private Gestionnaire gestionnaire;
	
	public Salle() {
		
	}
	public Salle(int cap, String nom) {
		this.sal_capacité = cap;
		this.sal_nom = nom;
	}
	
}
