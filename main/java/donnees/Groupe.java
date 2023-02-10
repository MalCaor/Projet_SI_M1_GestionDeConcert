package donnees;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Groupe")
@NamedQueries({
@NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g"),
@NamedQuery(name = "Groupe.findByCodeGroupe", query = "SELECT g FROM Groupe g WHERE g.grp_id = :grp_id"),
@NamedQuery(name = "Groupe.findByNom", query = "SELECT g FROM Groupe g WHERE g.grp_nom = :grp_nom"),
@NamedQuery(name = "Groupe.findByDescription", query = "SELECT g FROM Groupe g WHERE g.grp_description = :grp_description"),
})

public class Groupe implements Serializable {
	//private static final long serialVersionUID = 0;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "grp_id")
		private int grp_id;
		@Column(name = "grp_nom")
		private String grp_nom;
		@Column(name = "grp_description")
	    private String grp_description;
		@OneToMany
		private ArrayList<Artiste> grp_membres;
			 
	    
	    public Groupe(int grpId,String grpNom, String description) {
	        this.grp_id = grpId;
	        this.grp_nom = grpNom;
	        this.grp_description = description;
	        this.grp_membres = new ArrayList<>();
	    }
	    
	    public Groupe() {}

		public int getGrp_id() {
			return grp_id;
		}

		public void setGrp_id(int grp_id) {
			this.grp_id = grp_id;
		}

		public String getGrp_nom() {
			return grp_nom;
		}

		public void setGrp_nom(String grp_nom) {
			this.grp_nom = grp_nom;
		}

		public String getGrp_description() {
			return grp_description;
		}

		public void setGrp_description(String grp_description) {
			this.grp_description = grp_description;
		}

		public ArrayList<Artiste> getGrp_membres() {
			return grp_membres;
		}

		public void setGrp_membres(ArrayList<Artiste> grp_membres) {
			this.grp_membres = grp_membres;
		}
}
