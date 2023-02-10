package donnees;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "t_gestionnaire_gst")
@NamedQueries({
   @NamedQuery(name = "Gestionnaire.findAll", query = "SELECT s FROM Gestionnaire s"),
   @NamedQuery(name = "Gestionnaire.findByCodeSport", query = "SELECT s FROM Gestionnaire s WHERE s.gst_id = :gst_id"),
   @NamedQuery(name = "Gestionnaire.findByIntitule", query = "SELECT s FROM Gestionnaire s WHERE s.gst_pers = :gst_pers")})

public class Gestionnaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7156058176589214274L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "gst_id")
	private int gst_id;
	@Column(name = "gst_pers")
	private String gst_pers;

	public Gestionnaire() {
		
	}
	public Gestionnaire(String nom) {
		this.gst_pers = nom;
	}
	
	public String Getgst_pers(){
		return this.gst_pers;
	}
	
	public void Setgst_pers(String n) {
		this.gst_pers = n;
	}
}
