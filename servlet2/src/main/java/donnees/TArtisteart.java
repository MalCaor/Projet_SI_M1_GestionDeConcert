/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donnees;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author yoann.dekergario
 */
@Entity
@Table(name = "t_Artiste_art")
@NamedQueries({
    @NamedQuery(name = "TArtisteart.findAll", query = "SELECT t FROM TArtisteart t"),
    @NamedQuery(name = "TArtisteart.findByArtId", query = "SELECT t FROM TArtisteart t WHERE t.artId = :artId"),
    @NamedQuery(name = "TArtisteart.findByArtNom", query = "SELECT t FROM TArtisteart t WHERE t.artNom = :artNom"),
    @NamedQuery(name = "TArtisteart.findByArtPrenom", query = "SELECT t FROM TArtisteart t WHERE t.artPrenom = :artPrenom"),
    @NamedQuery(name = "TArtisteart.findByArtPseudo", query = "SELECT t FROM TArtisteart t WHERE t.artPseudo = :artPseudo"),
    @NamedQuery(name = "TArtisteart.findByArtVille", query = "SELECT t FROM TArtisteart t WHERE t.artVille = :artVille"),
    @NamedQuery(name = "TArtisteart.findByArtAge", query = "SELECT t FROM TArtisteart t WHERE t.artAge = :artAge")})
public class TArtisteart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "art_id")
    private Integer artId;
    @Column(name = "art_nom")
    private String artNom;
    @Column(name = "art_prenom")
    private String artPrenom;
    @Column(name = "art_pseudo")
    private String artPseudo;
    @Column(name = "art_ville")
    private String artVille;
    @Column(name = "art_age")
    private Integer artAge;
    @JoinColumn(name = "grp_id", referencedColumnName = "grp_id")
    @ManyToOne(optional = false)
    private TGroupeGrp grpId;

    public TArtisteart() {
    }

    public TArtisteart(Integer artId) {
        this.artId = artId;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getArtNom() {
        return artNom;
    }

    public void setArtNom(String artNom) {
        this.artNom = artNom;
    }

    public String getArtPrenom() {
        return artPrenom;
    }

    public void setArtPrenom(String artPrenom) {
        this.artPrenom = artPrenom;
    }

    public String getArtPseudo() {
        return artPseudo;
    }

    public void setArtPseudo(String artPseudo) {
        this.artPseudo = artPseudo;
    }

    public String getArtVille() {
        return artVille;
    }

    public void setArtVille(String artVille) {
        this.artVille = artVille;
    }

    public Integer getArtAge() {
        return artAge;
    }

    public void setArtAge(Integer artAge) {
        this.artAge = artAge;
    }

    public TGroupeGrp getGrpId() {
        return grpId;
    }

    public void setGrpId(TGroupeGrp grpId) {
        this.grpId = grpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artId != null ? artId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TArtisteart)) {
            return false;
        }
        TArtisteart other = (TArtisteart) object;
        if ((this.artId == null && other.artId != null) || (this.artId != null && !this.artId.equals(other.artId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donnees.TArtisteart[ artId=" + artId + " ]";
    }
    
}
