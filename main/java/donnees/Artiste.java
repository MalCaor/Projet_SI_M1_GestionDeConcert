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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "Artiste")
@NamedQueries({
@NamedQuery(name = "Artiste.findAll", query = "SELECT a FROM Artiste a"),
@NamedQuery(name = "Artiste.findByCodeArtiste", query = "SELECT a FROM Artiste a WHERE a.art_id = :art_id"),
@NamedQuery(name = "Artiste.findByNom", query = "SELECT a FROM Artiste a WHERE a.art_nom = :art_nom"),
@NamedQuery(name = "Artiste.findByPrenom", query = "SELECT a FROM Artiste a WHERE a.art_prenom = :art_prenom"),
@NamedQuery(name = "Artiste.findByVille", query = "SELECT a FROM Artiste a WHERE a.art_ville = :art_ville"),
})
public class Artiste implements Serializable {
	//private static final long serialVersionUID = 0;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "art_id")
	private int art_id;
	@Column(name = "art_nom")
    private String art_nom;
	@Column(name = "art_prenom")
    private String art_prenom;
	@Column(name = "art_pseudo")
    private String art_pseudo;
	@Column(name = "art_ville")
    private String art_ville;
	@Column(name = "art_age")
    private int art_age;
	@ManyToOne
	private Groupe art_groupe;
	
	
 
    
    public Artiste(int artId, String artNom, String artPrenom,String artVille,int artAge, Groupe groupe) {
        this.art_id = artId;
        this.art_nom = artNom;
        this.art_prenom = artPrenom;
        this.art_ville = artVille;
        this.art_age = artAge;
        this.art_groupe = groupe;
        
    }
    
    public Artiste() {}

	public int getArt_id() {
		return art_id;
	}

	public void setArt_id(int art_id) {
		this.art_id = art_id;
	}

	public String getArt_nom() {
		return art_nom;
	}

	public void setArt_nom(String art_nom) {
		this.art_nom = art_nom;
	}

	public String getArt_prenom() {
		return art_prenom;
	}

	public void setArt_prenom(String art_prenom) {
		this.art_prenom = art_prenom;
	}

	public String getArt_pseudo() {
		return art_pseudo;
	}

	public void setArt_pseudo(String art_pseudo) {
		this.art_pseudo = art_pseudo;
	}

	public String getArt_ville() {
		return art_ville;
	}

	public void setArt_ville(String art_ville) {
		this.art_ville = art_ville;
	}

	public int getArt_age() {
		return art_age;
	}

	public void setArt_age(int art_age) {
		this.art_age = art_age;
	}

	
    



	
    
}
